package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVDepthBufferFloat.class */
public final class NVDepthBufferFloat {
    public static final int GL_DEPTH_COMPONENT32F_NV = 36267;
    public static final int GL_DEPTH32F_STENCIL8_NV = 36268;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV = 36269;
    public static final int GL_DEPTH_BUFFER_FLOAT_MODE_NV = 36271;

    static native void nglDepthRangedNV(double d, double d2, long j);

    static native void nglClearDepthdNV(double d, long j);

    static native void nglDepthBoundsdNV(double d, double d2, long j);

    private NVDepthBufferFloat() {
    }

    public static void glDepthRangedNV(double n, double f) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDepthRangedNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDepthRangedNV(n, f, function_pointer);
    }

    public static void glClearDepthdNV(double d) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glClearDepthdNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglClearDepthdNV(d, function_pointer);
    }

    public static void glDepthBoundsdNV(double zmin, double zmax) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDepthBoundsdNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDepthBoundsdNV(zmin, zmax, function_pointer);
    }
}
