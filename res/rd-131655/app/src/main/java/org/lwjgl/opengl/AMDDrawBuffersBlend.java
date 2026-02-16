package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AMDDrawBuffersBlend.class */
public final class AMDDrawBuffersBlend {
    static native void nglBlendFuncIndexedAMD(int i, int i2, int i3, long j);

    static native void nglBlendFuncSeparateIndexedAMD(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglBlendEquationIndexedAMD(int i, int i2, long j);

    static native void nglBlendEquationSeparateIndexedAMD(int i, int i2, int i3, long j);

    private AMDDrawBuffersBlend() {
    }

    public static void glBlendFuncIndexedAMD(int buf, int src, int dst) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendFuncIndexedAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendFuncIndexedAMD(buf, src, dst, function_pointer);
    }

    public static void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendFuncSeparateIndexedAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendFuncSeparateIndexedAMD(buf, srcRGB, dstRGB, srcAlpha, dstAlpha, function_pointer);
    }

    public static void glBlendEquationIndexedAMD(int buf, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendEquationIndexedAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendEquationIndexedAMD(buf, mode, function_pointer);
    }

    public static void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendEquationSeparateIndexedAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendEquationSeparateIndexedAMD(buf, modeRGB, modeAlpha, function_pointer);
    }
}
