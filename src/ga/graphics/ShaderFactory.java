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
public interface ShaderFactory {

    public Shader loadFromFile(String filename, int shaderType)
            throws UnsupportedOperationException, IOException;

    public Shader loadFromFile(String vertFilename, String fragFilename)
            throws UnsupportedOperationException, IOException;

    public Shader loadFromStream(InputStream stream, int shaderType)
            throws UnsupportedOperationException, IOException;

    public Shader loadFromStream(InputStream vertStream, InputStream fragStream)
            throws UnsupportedOperationException, IOException;

    public Shader compileShader(String vertSrc, String fragSrc)
            throws UnsupportedOperationException;

    public boolean shadersSupported();

    public void initialize();
    
}
