/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

/**
 *
 * @author Nyks Nivero
 */
abstract class GAState extends BasicGameState {
    protected void beforeTransition(GameContainer container, StateBasedGame game,
            String where) {

    }

    protected void afterTransition(GameContainer container, StateBasedGame game,
            String where) {

    }

    protected final void transition(GameContainer container, StateBasedGame game,
            String where, Transition fx1, Transition fx2) {
        beforeTransition(container, game, where);
        game.enterState(where.hashCode(), fx1, fx2);
        afterTransition(container, game, where);
    }

    protected final void transition(GameContainer container, StateBasedGame game,
            String where) {
        transition(container, game, where, new FadeOutTransition(), new FadeInTransition());
    }
}
