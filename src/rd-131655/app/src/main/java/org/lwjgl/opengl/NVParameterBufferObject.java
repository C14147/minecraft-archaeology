package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVParameterBufferObject.class */
public final class NVParameterBufferObject {
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_BINDINGS_NV = 36256;
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_SIZE_NV = 36257;
    public static final int GL_VERTEX_PROGRAM_PARAMETER_BUFFER_NV = 36258;
    public static final int GL_GEOMETRY_PROGRAM_PARAMETER_BUFFER_NV = 36259;
    public static final int GL_FRAGMENT_PROGRAM_PARAMETER_BUFFER_NV = 36260;

    static native void nglProgramBufferParametersfvNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglProgramBufferParametersIivNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglProgramBufferParametersIuivNV(int i, int i2, int i3, int i4, long j, long j2);

    private NVParameterBufferObject() {
    }

    public static void glProgramBufferParametersNV(int target, int buffer, int index, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramBufferParametersfvNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        nglProgramBufferParametersfvNV(target, buffer, index, params.remaining() >> 2, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glProgramBufferParametersINV(int target, int buffer, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramBufferParametersIivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        nglProgramBufferParametersIivNV(target, buffer, index, params.remaining() >> 2, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glProgramBufferParametersIuNV(int target, int buffer, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramBufferParametersIuivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        nglProgramBufferParametersIuivNV(target, buffer, index, params.remaining() >> 2, MemoryUtil.getAddress(params), function_pointer);
    }
}
