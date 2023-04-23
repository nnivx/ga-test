/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states;

import ga.Core;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Nyks Nivero
 */
public class Splash extends GAState {

    public static final int DURATION = 1500;
    private Image enmartworks;
    private int cx, cy;
    private int elapsed;
    
    @Override
    public int getID() {
        return "splash".hashCode();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) {
        elapsed = 0;
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        // no-op
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        enmartworks = new Image(Core.res.ENMA);
        cx = enmartworks.getWidth()/2;
        cy = enmartworks.getHeight()/2;
        elapsed = 0;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        int w = container.getWidth();
        int h = container.getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
        g.drawImage(enmartworks, w/2 - cx, h/2 - cy);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        elapsed += delta;

        if (elapsed >= 1500) {
            transition(container, game, "mainmenu");
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        elapsed = DURATION;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        elapsed = DURATION;
    }

}
