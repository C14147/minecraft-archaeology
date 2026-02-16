package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBDrawBuffersBlend.class */
public final class ARBDrawBuffersBlend {
    static native void nglBlendEquationiARB(int i, int i2, long j);

    static native void nglBlendEquationSeparateiARB(int i, int i2, int i3, long j);

    static native void nglBlendFunciARB(int i, int i2, int i3, long j);

    static native void nglBlendFuncSeparateiARB(int i, int i2, int i3, int i4, int i5, long j);

    private ARBDrawBuffersBlend() {
    }

    public static void glBlendEquationiARB(int buf, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendEquationiARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendEquationiARB(buf, mode, function_pointer);
    }

    public static void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendEquationSeparateiARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendEquationSeparateiARB(buf, modeRGB, modeAlpha, function_pointer);
    }

    public static void glBlendFunciARB(int buf, int src, int dst) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendFunciARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendFunciARB(buf, src, dst, function_pointer);
    }

    public static void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendFuncSeparateiARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendFuncSeparateiARB(buf, srcRGB, dstRGB, srcAlpha, dstAlpha, function_pointer);
    }
}
