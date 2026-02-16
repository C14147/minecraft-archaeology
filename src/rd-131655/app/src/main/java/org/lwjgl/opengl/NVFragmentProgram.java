package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVFragmentProgram.class */
public final class NVFragmentProgram extends NVProgram {
    public static final int GL_FRAGMENT_PROGRAM_NV = 34928;
    public static final int GL_MAX_TEXTURE_COORDS_NV = 34929;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS_NV = 34930;
    public static final int GL_FRAGMENT_PROGRAM_BINDING_NV = 34931;
    public static final int GL_MAX_FRAGMENT_PROGRAM_LOCAL_PARAMETERS_NV = 34920;

    static native void nglProgramNamedParameter4fNV(int i, int i2, long j, float f, float f2, float f3, float f4, long j2);

    static native void nglProgramNamedParameter4dNV(int i, int i2, long j, double d, double d2, double d3, double d4, long j2);

    static native void nglGetProgramNamedParameterfvNV(int i, int i2, long j, long j2, long j3);

    static native void nglGetProgramNamedParameterdvNV(int i, int i2, long j, long j2, long j3);

    private NVFragmentProgram() {
    }

    public static void glProgramNamedParameter4fNV(int id, ByteBuffer name, float x, float y, float z, float w) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramNamedParameter4fNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        nglProgramNamedParameter4fNV(id, name.remaining(), MemoryUtil.getAddress(name), x, y, z, w, function_pointer);
    }

    public static void glProgramNamedParameter4dNV(int id, ByteBuffer name, double x, double y, double z, double w) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProgramNamedParameter4dNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        nglProgramNamedParameter4dNV(id, name.remaining(), MemoryUtil.getAddress(name), x, y, z, w, function_pointer);
    }

    public static void glGetProgramNamedParameterNV(int id, ByteBuffer name, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramNamedParameterfvNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkBuffer(params, 4);
        nglGetProgramNamedParameterfvNV(id, name.remaining(), MemoryUtil.getAddress(name), MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glGetProgramNamedParameterNV(int id, ByteBuffer name, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetProgramNamedParameterdvNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkBuffer(params, 4);
        nglGetProgramNamedParameterdvNV(id, name.remaining(), MemoryUtil.getAddress(name), MemoryUtil.getAddress(params), function_pointer);
    }
}
