/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaframe;

import frame.BasicGameState;
import frame.FrameGame;
import frame.util.Warper;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nyks Nivero
 */
public class InterpolatorStressTest extends BasicGameState {

    public static final int DURATION = 20000;
    private int elapsed = 0;

    private Image image;
    private final Color color = new Color(100, 100, 100);

    // 5000????!! that's 5000*2 interpolators
    // 3 fps drop at 10k interpolators...
    private final Vector2f[] points = new Vector2f[2000];

    @Override
    public String getID() {
        return "interptest";
    }

    @Override
    public void init(GameContainer container, FrameGame game) throws SlickException {
        image = new Image("testdata/particle.tga");
    }

    @Override
    public void enter(GameContainer container, FrameGame game) {
        elapsed = 0;
        Random rand = new Random();
        int maxTime = (int) (DURATION*0.8);
        int minTime = (int) (DURATION*0.2);
        // THIS IS MOTHERFCKING AWESEOME FOR THESE LINES HOLY SHIT
        for (int i = 0; i < points.length; ++i) {
            points[i] = new Vector2f();
            // add an interpolator for the x axis
            game.engine().interpolate(points[i]::setX,
//                    rand.nextInt(container.getWidth()),
                    0,
                    rand.nextInt(container.getWidth()),
                    rand.nextInt(maxTime-minTime)+minTime,
                    Warper.flash(Warper::easeIn));
            // add an interpolator for the y-axis
            game.engine().interpolate(points[i]::setY,
                    rand.nextInt(container.getHeight()),
//                    0,
                    rand.nextInt(container.getHeight()),
                    rand.nextInt(maxTime-minTime)+minTime,
                    Warper::easeIn);
        }
        // add an interpolator for the color
        game.engine().interpolate(f->{
            color.r = color.g = color.b = color.a = f;
        }, 0, 1, maxTime, Warper.flash(Warper::linear));
    }

    @Override
    public void leave(GameContainer container, FrameGame game) {

    }

    @Override
    public void render(GameContainer container, FrameGame game, Graphics g) {
        for (Vector2f v: points) {
            g.drawImage(image, v.x, v.y, color);
        }
    }

    @Override
    public void update(GameContainer container, FrameGame game, int delta) throws SlickException {
        super.update(container, game, delta);
        elapsed += delta;
        if (elapsed > DURATION) {
            container.exit();
        }
    }
}
