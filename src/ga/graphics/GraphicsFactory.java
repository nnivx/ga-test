/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.graphics;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Nyks Nivero
 */
public class GraphicsFactory {

    public static Shader shaderFromFile(String filename, int shaderType)
            throws UnsupportedOperationException, IOException {
        return shaderFactory.loadFromFile(filename, shaderType);
    }

    public static Shader shaderFromFile(String vertFilename, String fragFilename)
            throws UnsupportedOperationException, IOException {
        return shaderFactory.loadFromFile(vertFilename, fragFilename);
    }

    public static Shader shaderFromStream(InputStream stream, int shaderType)
            throws UnsupportedOperationException, IOException {
        return shaderFactory.loadFromStream(stream, shaderType);
    }

    public static Shader shaderFromStream(InputStream vertStream, InputStream fragStream)
            throws UnsupportedOperationException, IOException {
        return shaderFactory.loadFromStream(vertStream, fragStream);
    }

    public static Shader compileVertexShader(String vertSrc)
            throws UnsupportedOperationException {
        return compileShader(vertSrc, null);
    }

    public static Shader compileFragmentShader(String fragSrc)
            throws UnsupportedOperationException {
        return compileShader(null, fragSrc);
    }

    public static Shader compileShader(String vertSrc, String fragSrc)
            throws UnsupportedOperationException {
        return shaderFactory.compileShader(vertSrc, fragSrc);
    }

    public static boolean shadersSupported() {
        return shaderFactory.shadersSupported();
    }
    
    static final ShaderFactory SHADER_UNSUPPORTED = new UnsupportedShaderFactory();
    private static ShaderFactory shaderFactory = SHADER_UNSUPPORTED;

    public static void setShaderFactory(ShaderFactory factory) {
        factory.initialize();
        if (factory.shadersSupported()) {
            shaderFactory = factory;
        } else {
            shaderFactory = SHADER_UNSUPPORTED;
        }
    }

    public static void init() {
        shaderFactory.initialize();
    }

    private GraphicsFactory() {

    }
}
