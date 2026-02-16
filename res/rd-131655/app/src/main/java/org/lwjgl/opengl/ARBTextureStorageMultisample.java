package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBTextureStorageMultisample.class */
public final class ARBTextureStorageMultisample {
    static native void nglTextureStorage2DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglTextureStorage3DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j);

    private ARBTextureStorageMultisample() {
    }

    public static void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        GL43.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
        GL43.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTextureStorage2DMultisampleEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTextureStorage2DMultisampleEXT(texture, target, samples, internalformat, width, height, fixedsamplelocations, function_pointer);
    }

    public static void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTextureStorage3DMultisampleEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTextureStorage3DMultisampleEXT(texture, target, samples, internalformat, width, height, depth, fixedsamplelocations, function_pointer);
    }
}
