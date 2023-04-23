/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.graphics;

import org.lwjgl.util.vector.Matrix4f;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Nyks Nivero
 */
public interface Shader {

    public static final int VERTEX_SHADER = 0;
    public static final int FRAGMENT_SHADER = 1;

    public void setParameterf(String param, float x);

    public void setParameter2f(String param, float x, float y);

    public void setParameter3f(String param, float x, float y, float z);

    public void setParameter4f(String param, float x, float y, float z, float w);

    public void setParameterColor(String param, Color color);

    public void setParameterColor(String param, float r, float g, float b, float a);

    public void setParameterMatrix4(String param, Matrix4f matrix);

    public void setParameterTex(String param, Texture tex);

    public void setParameterTexCurrent(String param);

    public void bind();

    public void destroy();
    
    public int getShaderID();
}
