package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTGpuProgramParameters.class */
public final class EXTGpuProgramParameters {
    static native void nglProgramEnvParameters4fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramLocalParameters4fvEXT(int i, int i2, int i3, long j, long j2);

    private EXTGpuProgramParameters() {
    }

    public static void glProgramEnvParameters4EXT(int target, int index, int count, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramEnvParameters4fvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, count << 2);
        nglProgramEnvParameters4fvEXT(target, index, count, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glProgramLocalParameters4EXT(int target, int index, int count, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramLocalParameters4fvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, count << 2);
        nglProgramLocalParameters4fvEXT(target, index, count, MemoryUtil.getAddress(params), function_pointer);
    }
}
