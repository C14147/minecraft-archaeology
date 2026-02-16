package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTBlendFuncSeparate.class */
public final class EXTBlendFuncSeparate {
    public static final int GL_BLEND_DST_RGB_EXT = 32968;
    public static final int GL_BLEND_SRC_RGB_EXT = 32969;
    public static final int GL_BLEND_DST_ALPHA_EXT = 32970;
    public static final int GL_BLEND_SRC_ALPHA_EXT = 32971;

    static native void nglBlendFuncSeparateEXT(int i, int i2, int i3, int i4, long j);

    private EXTBlendFuncSeparate() {
    }

    public static void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlendFuncSeparateEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlendFuncSeparateEXT(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha, function_pointer);
    }
}
