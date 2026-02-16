package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVPrimitiveRestart.class */
public final class NVPrimitiveRestart {
    public static final int GL_PRIMITIVE_RESTART_NV = 34136;
    public static final int GL_PRIMITIVE_RESTART_INDEX_NV = 34137;

    static native void nglPrimitiveRestartNV(long j);

    static native void nglPrimitiveRestartIndexNV(int i, long j);

    private NVPrimitiveRestart() {
    }

    public static void glPrimitiveRestartNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPrimitiveRestartNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglPrimitiveRestartNV(function_pointer);
    }

    public static void glPrimitiveRestartIndexNV(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glPrimitiveRestartIndexNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglPrimitiveRestartIndexNV(index, function_pointer);
    }
}
