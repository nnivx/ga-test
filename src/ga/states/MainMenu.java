/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states;

import ga.Core;
import ga.GAConstants;
import ga.states.mainmenu.Selector;
import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.FastTrig;
/**
 *
 * @author Nyks Nivero
 */
public class MainMenu extends GAState {
    // Fields initialized later
    private Selector sel;
    private Image image;
    private Image highlight;
    private Graphics gTarget;
    private int tw;
    private TrueTypeFont font;
    private TrueTypeFont optFont;
    private Sound itemSfx, selectSfx, failSfx;

    // Final fields/configurables
    private final int selX = 35;
    private final Color selColor = Color.darkGray;
    private final int idealX = 90;
    private final int idealHelpX = idealX + 15;
    private final int optY = 175;
    private final int optSpacing = 55;
    private final int optEase = 1000;
    private final Option[] opts;

    // Changing fields
    private int optcur;
    private int selY;
    private int highY;
    private String transitionTo;

    public MainMenu() {
        int y = optY;
        opts = new Option[]{
            new Option("Start", "Start a new game", 66, y),
            new Option("Continue", "Load saved game", 66, (y += optSpacing)),
            new Option("Extras", "???", 66, (y += 55)),
            new Option("Config", "Change game settings", 66, (y += optSpacing)),
            new Option("Help", "View help, credits and about", 66, (y += optSpacing)),
            new Option("Quit", "Quit...", 66, (y += optSpacing)),
        };
        optcur = 0;
    }

    public void jumpToOption(int opt) throws IndexOutOfBoundsException {
        jumpToOption(opt, false);
    }

    public void jumpToOption(int opt, boolean skip) throws IndexOutOfBoundsException {
        jumpToOption(opt, skip, !skip);
    }

    public void jumpToOption(int opt, boolean skip, boolean playsound) throws IndexOutOfBoundsException {
        opts[optcur].setSelected(false, skip);
        opts[opt].setSelected(true, skip);
        optcur = opt;
        highlightOption();
        if (playsound)itemSfx.play();
    }

    @Override
    public int getID() {
        return "mainmenu".hashCode();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        sel = new Selector();

        image = new Image(800, 600);
        gTarget = image.getGraphics();

        // bake the background
        // background - dock - mea - ribbon - info - logo
        Image background = new Image(Core.res.MAIN_BACKGROUND);
        Image dock = new Image(Core.res.MAIN_DOCK);
        Image mea = new Image(Core.res.MAIN_MEA);
        Image ribbon = new Image(Core.res.MAIN_RIBBON);
        Image logo = new Image(Core.res.GA_LOGO);
        
        gTarget.drawImage(background, 0, 0);
        background.destroy();
        gTarget.drawImage(dock, 0, 0);
        dock.destroy();
        gTarget.drawImage(mea, 331, 20);
        mea.destroy();
        gTarget.drawImage(ribbon, 0, 570);
        ribbon.destroy();
        gTarget.drawImage(logo, 31, 16);
        logo.destroy();
        gTarget.flush();

        // bake the highlight
        highlight = new Image(Core.res.MAIN_HIGHLIGHT);
        
        Font awtFont = new Font("monospaced", Font.PLAIN, 12);
        font = new TrueTypeFont(awtFont, false);
        optFont = new TrueTypeFont(new Font("monospaced", Font.PLAIN, 35), true);

        tw = container.getWidth() - font.getWidth(GAConstants.INFO_STR) - 5;

        itemSfx = new Sound(Core.res.MENU_ITEM_SFX);
        selectSfx = new Sound(Core.res.SELECT_SFX);
        failSfx = new Sound(Core.res.SELECT_FAIL_SFX);
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        g.drawImage(image, 0, 0);
        g.setFont(font);
        g.drawString(GAConstants.INFO_STR, tw, 572);
        g.drawImage(highlight, 0, highY, selColor);
        g.drawLine(0, selY + 17, highlight.getWidth(), selY + 17);
        
        sel.draw(selX, selY);

        for (Option opt: opts) {
            opt.render(container, game, g);
        }
    }

    private boolean yOverOption(int opt, int y) {
        float height = highlight.getHeight();
        float miny = opts[opt].y;
        return (y >= miny) && (y <= miny+height);
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        if (newx <= highlight.getWidth()) {
            for (int i = 0; i < opts.length; ++i) {
                if (yOverOption(i, newy)) {
                    if (i != optcur) jumpToOption(i);
                    break;
                }
            }
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        if (button == 0) {
            for (int i = 0; i < opts.length; ++i) {
                if (yOverOption(i, y)) {
                    executeOption(i);
                    break;
                }
            }
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        
        if (transitionTo != null) {
            switch (transitionTo) {
                case "Quit":
                    transition(container, game, "quit");
                    return;
                case "Start":
                    transition(container, game, "mapview");
                    return;
            }
        }

        sel.getAnimation().update(delta);

        for (Option opt: opts) {
            opt.update(container, game, delta);
        }
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) {
        jumpToOption(optcur, true);
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_W:
            case Input.KEY_UP:
                incOptionCursor(-1);
                break;
            case Input.KEY_S:
            case Input.KEY_DOWN:
                incOptionCursor(1);
                break;
            case Input.KEY_RETURN:
            case Input.KEY_NUMPADENTER:
                executeOption(optcur);
                break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {

    }

    /**
     * Increments option cursor by specified amount.
     */
    private void incOptionCursor(int amt) {
        amt += optcur;
        if (amt >= (opts.length - 1)) {
            amt = opts.length - 1;
        } else if (amt < 0) {
            amt = 0;
        }
        jumpToOption(amt);
    }

    /**
     * Moves the highlight to currently selected option.
     */
    private void highlightOption() {
        selY = optY + optcur*optSpacing + optFont.getHeight()/2;
        highY = selY - highlight.getHeight()/2;
    }

    /**
     * Execute option.
     */
    private void executeOption(int option) {
        if (opts[optcur].text.equals("Extras")) {
            failSfx.play();
        } else {
            selectSfx.play();
        }
        transitionTo = opts[option].text;
    }

    // Visible options in main menu
    private class Option {
        // option text
        final String text;
        final String help;
        // offset
        final int posX, posY;

        // position
        float x, helpX, y;
        // selected
        boolean selected;
        // animation elapsed
        int elapsed;
        boolean upd = true;

        void setSelected(boolean selected) {
            setSelected(selected, false);
        }

        void setSelected(boolean selected, boolean skip) {
            if (selected != this.selected) {
                helpX = 0;
                elapsed = 0;
                this.selected = selected;
            }
            if (skip) {
                if (selected) {
                    x = idealX;
                    helpX = idealHelpX;
                } else {
                    x = posX;
                    helpX = 0; // not important
                }
            }
            // we update only if we don't skip
            upd = !skip;
        }

        Option(String text, String help, int offx, int offy) {
            assert offx < idealX; // offx must be less than idealX
            this.text = text;
            this.help = help;
            this.posX = offx;
            this.posY = offy;
            x = offx;
            y = offy;
            helpX = 0;
            elapsed = 0;
            selected = false;
        }

        void render(GameContainer container, StateBasedGame game, Graphics g) {
            // must be filled at init
            g.setFont(optFont);
            g.drawString(text, x, y);
            g.setFont(font);
            if (selected)
                g.drawString(help, helpX, selY+20);
        }


        private double ease(double a, double b) {
            // ease interpolator
            double t = elapsed >= optEase? 1.0: ((double)elapsed)/optEase;
            t = FastTrig.cos((1.0 - t) * Math.PI / 2.0);
            //t = 1.0 - FastTrig.cos(t * Math.PI / 2.0);
            //t = .5 - FastTrig.cos(Math.PI * t) / 2.0;
            return a + t*(b - a);
        }


        void update(GameContainer container, StateBasedGame game, int delta) {
            // compared to calling the interpolator every time,
            // a flag is quite a better solution
            if (!upd) return;
            elapsed += delta;
            if (selected) {
                x = (float) ease(x, idealX);
                helpX = (float) ease(helpX, idealX+15);
            } else {
                x = (float) ease(x, posX);
            }
            if (elapsed > optEase) upd = false;
        }
    }
}
