package org.lwjgl.opengl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/Util.class */
public final class Util {
    private Util() {
    }

    public static void checkGLError() throws OpenGLException {
        int err = GL11.glGetError();
        if (err != 0) {
            throw new OpenGLException(err);
        }
    }

    public static String translateGLErrorString(int error_code) {
        switch (error_code) {
            case 0:
                return "No error";
            case GL11.GL_INVALID_ENUM /* 1280 */:
                return "Invalid enum";
            case GL11.GL_INVALID_VALUE /* 1281 */:
                return "Invalid value";
            case GL11.GL_INVALID_OPERATION /* 1282 */:
                return "Invalid operation";
            case GL11.GL_STACK_OVERFLOW /* 1283 */:
                return "Stack overflow";
            case GL11.GL_STACK_UNDERFLOW /* 1284 */:
                return "Stack underflow";
            case GL11.GL_OUT_OF_MEMORY /* 1285 */:
                return "Out of memory";
            case 1286:
                return "Invalid framebuffer operation";
            case ARBImaging.GL_TABLE_TOO_LARGE /* 32817 */:
                return "Table too large";
            default:
                return null;
        }
    }
}
