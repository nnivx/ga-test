/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.states.mainmenu;

import ga.Core;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nyks Nivero
 */
public class Selector {

    private final int w;
    private final int h;
    private final Image img;
    private final Animation anim;
    
    public Selector() throws SlickException {
        img = new Image(Core.res.SELECTOR);
        Image[] imgs = new Image[11];
        w = img.getWidth()/11;
        h = img.getHeight();
        for (int i = 0; i < 11; ++i)
            imgs[i] = img.getSubImage(w*i, 0, w, h);
        anim = new Animation(imgs, 60);
        anim.setPingPong(true);
        anim.setAutoUpdate(false);
    }

    public Animation getAnimation() {
        return anim;
    }

    public void draw(float x, float y) {
        anim.draw(x-w/2, y-h/2);
    }
}
