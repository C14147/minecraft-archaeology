package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBSparseBuffer.class */
public final class ARBSparseBuffer {
    public static final int GL_SPARSE_STORAGE_BIT_ARB = 1024;
    public static final int GL_SPARSE_BUFFER_PAGE_SIZE_ARB = 33528;

    static native void nglBufferPageCommitmentARB(int i, long j, long j2, boolean z, long j3);

    private ARBSparseBuffer() {
    }

    public static void glBufferPageCommitmentARB(int target, long offset, long size, boolean commit) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferPageCommitmentARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBufferPageCommitmentARB(target, offset, size, commit, function_pointer);
    }
}
