/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaframe;

import frame.BasicGameState;
import frame.FrameGame;
import frame.util.Warper;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nyks Nivero
 */
public class Splash extends BasicGameState {

    public static final int DURATION = 6000;
    private Image enmartworks;
    private int cx, cy;
    private int elapsed;
    private final Color color = new Color(Color.white);
    
    @Override
    public String getID() {
        return "splash";
    }

    @Override
    public void init(GameContainer container, FrameGame game) throws SlickException {
        enmartworks = new Image(ga.Core.res.ENMA);
        
        cx = enmartworks.getWidth()/2;
        cy = enmartworks.getHeight()/2;
        elapsed = 0;
        reset(container, game);
    }

    @Override
    public void reset(GameContainer container, FrameGame game) {
        elapsed = 0;
    }

    @Override
    public void enter(GameContainer container, FrameGame game) {
        reset(container, game);
    }

    @Override
    public void leave(GameContainer container, FrameGame game) {

    }

    @Override
    public void render(GameContainer container, FrameGame game, Graphics g) {
        int w = container.getWidth();
        int h = container.getHeight();
        g.setColor(color);
        g.fillRect(0, 0, w, h);
        g.drawImage(enmartworks, w/2 - cx, h/2 - cy);
    }

    @Override
    public void update(GameContainer container, FrameGame game, int delta) throws SlickException {
        super.update(container, game, delta);
        elapsed += delta;

        if (elapsed >= DURATION) {
            game.transition("interptest");
        }

    }

}
