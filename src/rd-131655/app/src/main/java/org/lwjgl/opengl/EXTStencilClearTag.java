package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTStencilClearTag.class */
public final class EXTStencilClearTag {
    public static final int GL_STENCIL_TAG_BITS_EXT = 35058;
    public static final int GL_STENCIL_CLEAR_TAG_VALUE_EXT = 35059;

    static native void nglStencilClearTagEXT(int i, int i2, long j);

    private EXTStencilClearTag() {
    }

    public static void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glStencilClearTagEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglStencilClearTagEXT(stencilTagBits, stencilClearTag, function_pointer);
    }
}
