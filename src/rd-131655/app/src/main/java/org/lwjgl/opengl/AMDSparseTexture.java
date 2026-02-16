package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AMDSparseTexture.class */
public final class AMDSparseTexture {
    public static final int GL_TEXTURE_STORAGE_SPARSE_BIT_AMD = 1;
    public static final int GL_VIRTUAL_PAGE_SIZE_X_AMD = 37269;
    public static final int GL_VIRTUAL_PAGE_SIZE_Y_AMD = 37270;
    public static final int GL_VIRTUAL_PAGE_SIZE_Z_AMD = 37271;
    public static final int GL_MAX_SPARSE_TEXTURE_SIZE_AMD = 37272;
    public static final int GL_MAX_SPARSE_3D_TEXTURE_SIZE_AMD = 37273;
    public static final int GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS = 37274;
    public static final int GL_MIN_SPARSE_LEVEL_AMD = 37275;
    public static final int GL_MIN_LOD_WARNING_AMD = 37276;

    static native void nglTexStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglTextureStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    private AMDSparseTexture() {
    }

    public static void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTexStorageSparseAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTexStorageSparseAMD(target, internalFormat, width, height, depth, layers, flags, function_pointer);
    }

    public static void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTextureStorageSparseAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTextureStorageSparseAMD(texture, target, internalFormat, width, height, depth, layers, flags, function_pointer);
    }
}
