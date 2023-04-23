/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.graphics;

import java.io.IOException;
import java.io.InputStream;

/**
 * A helper class to optimize resolving unsupported calls.
 * 
 * @author Nyks Nivero
 */
class UnsupportedShaderFactory implements ShaderFactory {
    
    @Override
    public Shader loadFromFile(String filename, int shaderType)
            throws UnsupportedOperationException, IOException {
        throw new UnsupportedOperationException("Shader not supported.");
    }

    @Override
    public Shader loadFromFile(String vertFilename, String fragFilename)
            throws UnsupportedOperationException, IOException {
        throw new UnsupportedOperationException("Shader not supported.");
    }

    @Override
    public Shader loadFromStream(InputStream stream, int shaderType)
            throws UnsupportedOperationException, IOException {
        throw new UnsupportedOperationException("Shader not supported.");
    }

    @Override
    public Shader loadFromStream(InputStream vertStream, InputStream fragStream)
            throws UnsupportedOperationException, IOException {
        throw new UnsupportedOperationException("Shader not supported.");
    }

    @Override
    public Shader compileShader(String vertSrc, String fragSrc)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Shader not supported.");
    }

    @Override
    public boolean shadersSupported() {
        return false;
    }

    @Override
    public void initialize() {
        // no-op
    }

}
