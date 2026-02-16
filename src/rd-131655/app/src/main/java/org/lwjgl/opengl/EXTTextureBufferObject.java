package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTTextureBufferObject.class */
public final class EXTTextureBufferObject {
    public static final int GL_TEXTURE_BUFFER_EXT = 35882;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_EXT = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER_EXT = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_EXT = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT_EXT = 35886;

    static native void nglTexBufferEXT(int i, int i2, int i3, long j);

    private EXTTextureBufferObject() {
    }

    public static void glTexBufferEXT(int target, int internalformat, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTexBufferEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTexBufferEXT(target, internalformat, buffer, function_pointer);
    }
}
