package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTFramebufferMultisample.class */
public final class EXTFramebufferMultisample {
    public static final int GL_RENDERBUFFER_SAMPLES_EXT = 36011;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE_EXT = 36182;
    public static final int GL_MAX_SAMPLES_EXT = 36183;

    static native void nglRenderbufferStorageMultisampleEXT(int i, int i2, int i3, int i4, int i5, long j);

    private EXTFramebufferMultisample() {
    }

    public static void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glRenderbufferStorageMultisampleEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglRenderbufferStorageMultisampleEXT(target, samples, internalformat, width, height, function_pointer);
    }
}
