/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaframe;

import frame.FrameGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nyks Nivero
 */
public class GAFrame extends FrameGame {

    public GAFrame(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) {
        addState(new InterpolatorStressTest());
    }

    public static void main(String[] args) {
        try {
            GAFrame game = new GAFrame("Taitooru");
            AppGameContainer container = new AppGameContainer(game);
            container.setDisplayMode(800,600,false);
            container.setMouseGrabbed(false);
            Mouse.setClipMouseCoordinatesToWindow(true);
            {// entry point
                Splash s = new Splash();
                game.addState(s);
                game.transition("splash", NoTransition, NoTransition);
//                game.enterState(s.getID(), null, new org.newdawn.slick.state.transition.FadeInTransition());
            }
            //container.setShowFPS(false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
