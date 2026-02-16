package org.lwjgl.util.glu;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/Util.class */
public class Util {
    private static IntBuffer scratch = BufferUtils.createIntBuffer(16);

    protected static int ceil(int a, int b) {
        return a % b == 0 ? a / b : (a / b) + 1;
    }

    protected static float[] normalize(float[] v) {
        float r = (float) Math.sqrt((v[0] * v[0]) + (v[1] * v[1]) + (v[2] * v[2]));
        if (r == 0.0d) {
            return v;
        }
        float r2 = 1.0f / r;
        v[0] = v[0] * r2;
        v[1] = v[1] * r2;
        v[2] = v[2] * r2;
        return v;
    }

    protected static void cross(float[] v1, float[] v2, float[] result) {
        result[0] = (v1[1] * v2[2]) - (v1[2] * v2[1]);
        result[1] = (v1[2] * v2[0]) - (v1[0] * v2[2]);
        result[2] = (v1[0] * v2[1]) - (v1[1] * v2[0]);
    }

    protected static int compPerPix(int format) {
        switch (format) {
            case GL11.GL_COLOR_INDEX /* 6400 */:
            case GL11.GL_STENCIL_INDEX /* 6401 */:
            case GL11.GL_DEPTH_COMPONENT /* 6402 */:
            case GL11.GL_RED /* 6403 */:
            case GL11.GL_GREEN /* 6404 */:
            case GL11.GL_BLUE /* 6405 */:
            case GL11.GL_ALPHA /* 6406 */:
            case GL11.GL_LUMINANCE /* 6409 */:
                return 1;
            case GL11.GL_RGB /* 6407 */:
            case 32992:
                return 3;
            case GL11.GL_RGBA /* 6408 */:
            case 32993:
                return 4;
            case GL11.GL_LUMINANCE_ALPHA /* 6410 */:
                return 2;
            default:
                return -1;
        }
    }

    protected static int nearestPower(int value) {
        int i = 1;
        if (value == 0) {
            return -1;
        }
        while (value != 1) {
            if (value == 3) {
                return i << 2;
            }
            value >>= 1;
            i <<= 1;
        }
        return i;
    }

    protected static int bytesPerPixel(int format, int type) {
        int n;
        int m;
        switch (format) {
            case GL11.GL_COLOR_INDEX /* 6400 */:
            case GL11.GL_STENCIL_INDEX /* 6401 */:
            case GL11.GL_DEPTH_COMPONENT /* 6402 */:
            case GL11.GL_RED /* 6403 */:
            case GL11.GL_GREEN /* 6404 */:
            case GL11.GL_BLUE /* 6405 */:
            case GL11.GL_ALPHA /* 6406 */:
            case GL11.GL_LUMINANCE /* 6409 */:
                n = 1;
                break;
            case GL11.GL_RGB /* 6407 */:
            case 32992:
                n = 3;
                break;
            case GL11.GL_RGBA /* 6408 */:
            case 32993:
                n = 4;
                break;
            case GL11.GL_LUMINANCE_ALPHA /* 6410 */:
                n = 2;
                break;
            default:
                n = 0;
                break;
        }
        switch (type) {
            case GL11.GL_BYTE /* 5120 */:
                m = 1;
                break;
            case GL11.GL_UNSIGNED_BYTE /* 5121 */:
                m = 1;
                break;
            case GL11.GL_SHORT /* 5122 */:
                m = 2;
                break;
            case GL11.GL_UNSIGNED_SHORT /* 5123 */:
                m = 2;
                break;
            case GL11.GL_INT /* 5124 */:
                m = 4;
                break;
            case GL11.GL_UNSIGNED_INT /* 5125 */:
                m = 4;
                break;
            case GL11.GL_FLOAT /* 5126 */:
                m = 4;
                break;
            case GL11.GL_BITMAP /* 6656 */:
                m = 1;
                break;
            default:
                m = 0;
                break;
        }
        return n * m;
    }

    protected static int glGetIntegerv(int what) {
        scratch.rewind();
        GL11.glGetInteger(what, scratch);
        return scratch.get();
    }
}
