/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.graphics;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.lwjgl.BufferUtils;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.vector.Matrix4f;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

/**
 * Will give a shader most of the time even when lwjgl has no support.
 * 
 * @author Nyks Nivero
 */
public class NativeShaderFactory implements ShaderFactory {

    // The shader factory we return
    private static ShaderFactory factory;
    // A working instance
    private static NativeShaderFactory workingInstance = null;

    static {
        tryLoadLibrary();
    }

    public static void tryLoadLibrary() {
        try {
            System.loadLibrary("gashader");
        } catch (Exception e) {
            System.err.print(e);
            factory = GraphicsFactory.SHADER_UNSUPPORTED;
        }
        if (workingInstance == null) {
            workingInstance = new NativeShaderFactory();
        }
        // if the shaders are (still) not supported, just delegate
        // the unsupported factory so we don't have to check for
        // isSupported() every time...
        factory = workingInstance.shadersSupported()?
                workingInstance:
                GraphicsFactory.SHADER_UNSUPPORTED;
    }
    
    private NativeShaderFactory() {

    }

    /**
     * Returns a ShaderFactory (not always this class instance!)
     * @return a ShaderFactory
     */
    public static ShaderFactory get() {
        return factory;
    }
    
    @Override
    public Shader loadFromFile(String filename, int shaderType)
            throws IOException {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public Shader loadFromFile(String vertFilename, String fragFilename)
            throws IOException {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public Shader loadFromStream(InputStream stream, int shaderType)
            throws IOException {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public Shader loadFromStream(InputStream vertStream, InputStream fragStream)
            throws IOException {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public Shader compileShader(String vertSrc, String fragSrc) {
        ByteBuffer buf1 = null, buf2 = null;
        if (vertSrc != null) {
            byte[] bytes = vertSrc.getBytes();
            buf1 = BufferUtils.createByteBuffer(bytes.length);
            buf1.put(bytes, 0, bytes.length);
        }
        if (fragSrc != null) {
            byte[] bytes = fragSrc.getBytes();
            buf2 = BufferUtils.createByteBuffer(bytes.length);
            buf2.put(bytes, 0, bytes.length);
        }
        return compileShader(buf1, buf2);
    }

    private Shader compileShader(ByteBuffer buf1, ByteBuffer buf2) {
        int re = compile_shader(MemoryUtil.getAddress(buf1), MemoryUtil.getAddress(buf2));
        if (re == -1) {
            throw new RuntimeException("shader compile error");
        }
        return new NativeShaderImpl(re);
    }

    @Override
    public boolean shadersSupported() {
        return check_support();
    }

    @Override
    public void initialize() {
        // no-op?!
    }

    private static native boolean check_support();
    private static native int get_max_texture_units();

    private static native int compile_shader(long addrA, long addrB);
    private static native void delete_shader(int shader);

    private static native void nglUseProgramObjectARB(int i);
    private static native void nglUniform1iARB(int i, int index);
    private static native void nglActiveTextureARB(int i);

    private static native int get_parameter(int sh, String s);
    private static native void set_parameterf(int sh, int loc, float x);
    private static native void set_parameter2f(int sh, int loc, float x, float y);
    private static native void set_parameter3f(int sh, int loc, float x, float y, float z);
    private static native void set_parameter4f(int sh, int loc, float x, float y, float z, float w);
    private static native void set_parameterMatrix4f(int sh, int loc,
            float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33);

    private class NativeShaderImpl implements Shader {
        final TreeMap<Integer, Texture> textures;
        final HashMap<String, Integer> params;
        int shaderID;
        int currentTexture = -1;

        NativeShaderImpl(int shaderID) {
            textures = new TreeMap<>();
            params = new HashMap<>();
            this.shaderID = shaderID;
        }

        int getParamLocation(String name) {
            if (params.containsKey(name)) {
                return params.get(name);
            }
            int loc = get_parameter(shaderID, name);
            if (loc == -1) {
                throw new IllegalArgumentException("parameter name not found");
            }
            params.put(name, loc);
            return loc;
        }

        @Override
        public void setParameterf(String param, float x) {
            set_parameterf(shaderID, getParamLocation(param), x);
        }

        @Override
        public void setParameter2f(String param, float x, float y) {
            set_parameter2f(shaderID, getParamLocation(param), x, y);
        }

        @Override
        public void setParameter3f(String param, float x, float y, float z) {
            set_parameter3f(shaderID, getParamLocation(param), x, y, z);
        }

        @Override
        public void setParameter4f(String param, float x, float y, float z, float w) {
            set_parameter4f(shaderID, getParamLocation(param), x, y, z, w);
        }

        @Override
        public void setParameterColor(String param, Color color) {
            setParameterColor(param, color.r, color.g, color.b, color.a);
        }

        @Override
        public void setParameterColor(String param, float r, float g, float b, float a) {
            set_parameter4f(shaderID, getParamLocation(param), r, g, b, a);
        }

        @Override
        public void setParameterMatrix4(String param, Matrix4f matrix) {
            set_parameterMatrix4f(shaderID, getParamLocation(param),
                    matrix.m00, matrix.m01, matrix.m02, matrix.m03,
                    matrix.m10, matrix.m11, matrix.m12, matrix.m13,
                    matrix.m20, matrix.m21, matrix.m22, matrix.m23,
                    matrix.m30, matrix.m31, matrix.m32, matrix.m33);
        }

        @Override
        public void setParameterTex(String param, Texture tex) {
            int loc = getParamLocation(param);
            if (textures.containsKey(loc)) {
                if (textures.size() + 1 >= get_max_texture_units()) {
                    org.newdawn.slick.util.Log.error("No available texture units");
                    return;
                }
            }
            textures.put(loc, tex);
        }

        @Override
        public void setParameterTexCurrent(String param) {
            currentTexture = getParamLocation(param);
        }
        
        // I can't find it in lwjgl
        private static final int GL_TEXTURE0_ARB = 0x84C0;
        private void bindTextures() {
            int index = 1;
            for (Entry<Integer, Texture> e: textures.entrySet()) {
                nglUniform1iARB(e.getKey(), index);
                nglActiveTextureARB(GL_TEXTURE0_ARB + index);
                e.getValue().bind();
                ++index;
            }
            nglActiveTextureARB(GL_TEXTURE0_ARB);
        }
    
        @Override
        public void bind() {
            // no check for ensure
            if (shaderID != 0) {
                nglUseProgramObjectARB(shaderID);
                bindTextures();
                if (currentTexture != -1)
                    nglUniform1iARB(currentTexture, 0);
            } else {
                nglUseProgramObjectARB(0);
            }
        }

        @Override
        public void destroy() {
            delete_shader(getShaderID());
            shaderID = 0;
        }

        @Override
        public int getShaderID() {
            return shaderID;
        }

    }
}
