package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBTextureBufferRange.class */
public final class ARBTextureBufferRange {
    public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
    public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;

    static native void nglTextureBufferRangeEXT(int i, int i2, int i3, int i4, long j, long j2, long j3);

    private ARBTextureBufferRange() {
    }

    public static void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
        GL43.glTexBufferRange(target, internalformat, buffer, offset, size);
    }

    public static void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTextureBufferRangeEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTextureBufferRangeEXT(texture, target, internalformat, buffer, offset, size, function_pointer);
    }
}
