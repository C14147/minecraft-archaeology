package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVTextureBarrier.class */
public final class NVTextureBarrier {
    static native void nglTextureBarrierNV(long j);

    private NVTextureBarrier() {
    }

    public static void glTextureBarrierNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTextureBarrierNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglTextureBarrierNV(function_pointer);
    }
}
