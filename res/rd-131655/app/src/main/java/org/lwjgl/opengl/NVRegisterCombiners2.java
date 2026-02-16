package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVRegisterCombiners2.class */
public final class NVRegisterCombiners2 {
    public static final int GL_PER_STAGE_CONSTANTS_NV = 34101;

    static native void nglCombinerStageParameterfvNV(int i, int i2, long j, long j2);

    static native void nglGetCombinerStageParameterfvNV(int i, int i2, long j, long j2);

    private NVRegisterCombiners2() {
    }

    public static void glCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCombinerStageParameterfvNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglCombinerStageParameterfvNV(stage, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glGetCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetCombinerStageParameterfvNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglGetCombinerStageParameterfvNV(stage, pname, MemoryUtil.getAddress(params), function_pointer);
    }
}
