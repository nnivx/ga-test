/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 *
 * @author Nyks Nivero
 */
public class Utils {

    public static int[] autocropImageCoords(Image image, int[] dest)
            throws SlickException {
        Graphics g = image.getGraphics();
        int cols = image.getWidth();
        int rows = image.getHeight();
        int x = 0, y = 0, x2 = cols, y2 = rows;

        int col = 0, row = 0;
        // run a column-major loop to get the first non-transparent pixel
        for (; col < cols; ++col) {
            for (; row < rows; ++row) {
                int alpha = g.getPixel(col, row).getAlpha();
                // mark this pixel as the x?, y
                if (alpha != 0) {
                    x = col;
                    y = row;
                    break;
                }
            }
        }
        // check rows from (0, y] to see if there is a smaller x
        for (row = 0; row < y; ++rows) {
            for (; col < cols; ++cols) {
                int alpha = g.getPixel(col, row).getAlpha();
                if (alpha != 0 && (col < x)) {
                    x = col;
                }
            }
        }
        // repeat on opposite corner
        // run a column-major loop to get the first non-transparent pixel
        for (col = cols-1; col > y; --col) {
            for (row = rows-1; row > x; --row) {
                int alpha = g.getPixel(col, row).getAlpha();
                // mark this pixel as the x2?, y2
                if (alpha != 0) {
                    x2 = col;
                    y2 = row;
                    break;
                }
            }
        }
        // check all rows from (rows, y2] to see if there is a smaller x2
        for (row = rows; row >= 0; --row) {
            for (; col >= 0; --col) {
                int alpha = g.getPixel(col, row).getAlpha();
                if (alpha != 0 && (col < x2)) {
                    x2 = col;
                }
            }
        }

        if (dest == null) dest = new int[4];
        dest[0] = x;
        dest[1] = y;
        dest[2] = x2;
        dest[3] = y2;
        return dest;
    }

    private Utils() {
    }
}
