package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBTextureBufferObject.class */
public final class ARBTextureBufferObject {
    public static final int GL_TEXTURE_BUFFER_ARB = 35882;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER_ARB = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT_ARB = 35886;

    static native void nglTexBufferARB(int i, int i2, int i3, long j);

    private ARBTextureBufferObject() {
    }

    public static void glTexBufferARB(int target, int internalformat, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTexBufferARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTexBufferARB(target, internalformat, buffer, function_pointer);
    }
}
