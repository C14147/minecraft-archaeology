package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVDrawTexture.class */
public final class NVDrawTexture {
    static native void nglDrawTextureNV(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j);

    private NVDrawTexture() {
    }

    public static void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawTextureNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawTextureNV(texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1, function_pointer);
    }
}
