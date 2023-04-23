/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

import ga.states.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

/**
 *
 * @author Nyks Nivero
 */
public class P1 extends StateBasedGame {

    public P1() {
        super(GAConstants.WINDOW_TITLE);
    }

    @Override
    public void initStatesList(GameContainer container) {
        addState(new MainMenu());
        addState(new LoadGame());
        addState(new Extras());
        addState(new Help());
        addState(new Quit());
        addState(new MapView());
    }

    private static void printNSpaces(int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(' ');
        
    }
    private static void dumpXML(XMLElement element, int depth) {
        printNSpaces(depth);
        System.out.format("%s = '%s'\n", element.getName(), element.getContent().trim());
        for (String s: element.getAttributeNames()) {
            printNSpaces(depth+2);
            System.out.format("%s = '%s'\n", s, element.getAttribute(s).trim());
        }
        XMLElementList list = element.getChildren();
        for (int i = 0; i < list.size(); ++i) {
            dumpXML(list.get(i), depth + 1);
        }
    }

    public static void dumpXML(XMLElement element) {
        dumpXML(element, 0);
    }

    public static void main(String[] argv) {
        try {
            P1 game = new P1();
            AppGameContainer container = new AppGameContainer(game);
            container.setDisplayMode(800,600,false);
            container.setMouseGrabbed(false);
//            Mouse.setClipMouseCoordinatesToWindow(true);
            {// entry point
                Splash s = new Splash();
                game.addState(s);
                game.enterState(s.getID(), null, new org.newdawn.slick.state.transition.FadeInTransition());
            }
            //container.setShowFPS(false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
