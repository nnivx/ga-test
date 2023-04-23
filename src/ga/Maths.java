/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

/**
 *
 * @author Nyks Nivero
 */
public class Maths {

    public static double inRange(double what, double min, double max) {
        return what>max? max: what<min? min: what;
    }

    public static int inRange(int what, int min, int max) {
        return what>max? max: what<min? min: what;
    }

    private Maths() {
    }
}
