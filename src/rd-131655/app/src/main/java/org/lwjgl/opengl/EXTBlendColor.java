package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTBlendColor.class */
public final class EXTBlendColor {
    public static final int GL_CONSTANT_COLOR_EXT = 32769;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR_EXT = 32770;
    public static final int GL_CONSTANT_ALPHA_EXT = 32771;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA_EXT = 32772;
    public static final int GL_BLEND_COLOR_EXT = 32773;

    static native void nglBlendColorEXT(float f, float f2, float f3, float f4, long j);

    private EXTBlendColor() {
    }

    public static void glBlendColorEXT(float red, float green, float blue, float alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendColorEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendColorEXT(red, green, blue, alpha, function_pointer);
    }
}
