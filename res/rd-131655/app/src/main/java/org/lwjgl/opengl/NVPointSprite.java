package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVPointSprite.class */
public final class NVPointSprite {
    public static final int GL_POINT_SPRITE_NV = 34913;
    public static final int GL_COORD_REPLACE_NV = 34914;
    public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;

    static native void nglPointParameteriNV(int i, int i2, long j);

    static native void nglPointParameterivNV(int i, long j, long j2);

    private NVPointSprite() {
    }

    public static void glPointParameteriNV(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPointParameteriNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglPointParameteriNV(pname, param, function_pointer);
    }

    public static void glPointParameterNV(int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPointParameterivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglPointParameterivNV(pname, MemoryUtil.getAddress(params), function_pointer);
    }
}
