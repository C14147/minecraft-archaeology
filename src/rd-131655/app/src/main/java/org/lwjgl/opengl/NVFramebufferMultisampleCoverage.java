package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVFramebufferMultisampleCoverage.class */
public final class NVFramebufferMultisampleCoverage {
    public static final int GL_RENDERBUFFER_COVERAGE_SAMPLES_NV = 36011;
    public static final int GL_RENDERBUFFER_COLOR_SAMPLES_NV = 36368;
    public static final int GL_MAX_MULTISAMPLE_COVERAGE_MODES_NV = 36369;
    public static final int GL_MULTISAMPLE_COVERAGE_MODES_NV = 36370;

    static native void nglRenderbufferStorageMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    private NVFramebufferMultisampleCoverage() {
    }

    public static void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glRenderbufferStorageMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglRenderbufferStorageMultisampleCoverageNV(target, coverageSamples, colorSamples, internalformat, width, height, function_pointer);
    }
}
