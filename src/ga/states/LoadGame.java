/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Nyks Nivero
 */
public class LoadGame extends org.newdawn.slick.state.BasicGameState {

    @Override
    public int getID() {
        return "continue".hashCode();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
    }

}
