package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTFramebufferBlit.class */
public final class EXTFramebufferBlit {
    public static final int GL_READ_FRAMEBUFFER_EXT = 36008;
    public static final int GL_DRAW_FRAMEBUFFER_EXT = 36009;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING_EXT = 36006;
    public static final int GL_READ_FRAMEBUFFER_BINDING_EXT = 36010;

    static native void nglBlitFramebufferEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);

    private EXTFramebufferBlit() {
    }

    public static void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBlitFramebufferEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBlitFramebufferEXT(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, function_pointer);
    }
}
