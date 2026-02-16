package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVConditionalRender.class */
public final class NVConditionalRender {
    public static final int GL_QUERY_WAIT_NV = 36371;
    public static final int GL_QUERY_NO_WAIT_NV = 36372;
    public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
    public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;

    static native void nglBeginConditionalRenderNV(int i, int i2, long j);

    static native void nglEndConditionalRenderNV(long j);

    private NVConditionalRender() {
    }

    public static void glBeginConditionalRenderNV(int id, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBeginConditionalRenderNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBeginConditionalRenderNV(id, mode, function_pointer);
    }

    public static void glEndConditionalRenderNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glEndConditionalRenderNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglEndConditionalRenderNV(function_pointer);
    }
}
