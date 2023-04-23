/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Nyks Nivero
 */
public class Quit extends BasicGameState {

    private int tm;

    @Override
    public int getID() {
        return "quit".hashCode();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        tm += delta;
        if (tm >= 1) container.exit();
    }
    
    @Override
    public void enter(GameContainer container, StateBasedGame game) {
        tm = 0;
    }
}
