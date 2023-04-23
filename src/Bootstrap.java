
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nyks Nivero
 */
public class Bootstrap {

    private Bootstrap() {

    }

    public static void main(String[] args) {
        System.setProperty("java.library.path", "libs");
        System.setProperty("org.lwjgl.librarypath", new File("libs/natives").getAbsolutePath());
        // Invoke directly
        ga.P1.main(args);
    }
}
