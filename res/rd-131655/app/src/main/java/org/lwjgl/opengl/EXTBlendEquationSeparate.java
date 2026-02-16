package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTBlendEquationSeparate.class */
public final class EXTBlendEquationSeparate {
    public static final int GL_BLEND_EQUATION_RGB_EXT = 32777;
    public static final int GL_BLEND_EQUATION_ALPHA_EXT = 34877;

    static native void nglBlendEquationSeparateEXT(int i, int i2, long j);

    private EXTBlendEquationSeparate() {
    }

    public static void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendEquationSeparateEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendEquationSeparateEXT(modeRGB, modeAlpha, function_pointer);
    }
}
