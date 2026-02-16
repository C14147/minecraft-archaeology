package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBSampleShading.class */
public final class ARBSampleShading {
    public static final int GL_SAMPLE_SHADING_ARB = 35894;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE_ARB = 35895;

    static native void nglMinSampleShadingARB(float f, long j);

    private ARBSampleShading() {
    }

    public static void glMinSampleShadingARB(float value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMinSampleShadingARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglMinSampleShadingARB(value, function_pointer);
    }
}
