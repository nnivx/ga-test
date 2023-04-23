/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

import org.newdawn.slick.geom.Shape;

/**
 * Interface for landmarks visible from the world map.
 * <p>
 * Landmark takes optional properties, the following
 * are listed in order of getting the value.
 * <pre>
 * x_pos
 * y_pos
 * x_anchor
 * y_anchor
 * x_size
 * y_size
 *
 *
 * default_image
 * hover_image
 * pressed_image
 *
 * hover_sound
 * pressed_sound
 *
 * default_color
 * hover_color
 * pressed_color
 *
 *
 *
 * </pre>
 * @author Nyks Nivero
 */
public interface Landmark extends Properties {
    public String getLandmarkID();

    public String getName();

    public String getInfo();

    public String getDescription();

    public Shape getShape();
}
