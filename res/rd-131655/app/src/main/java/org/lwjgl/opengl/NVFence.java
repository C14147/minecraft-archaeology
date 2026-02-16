package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVFence.class */
public final class NVFence {
    public static final int GL_ALL_COMPLETED_NV = 34034;
    public static final int GL_FENCE_STATUS_NV = 34035;
    public static final int GL_FENCE_CONDITION_NV = 34036;

    static native void nglGenFencesNV(int i, long j, long j2);

    static native void nglDeleteFencesNV(int i, long j, long j2);

    static native void nglSetFenceNV(int i, int i2, long j);

    static native boolean nglTestFenceNV(int i, long j);

    static native void nglFinishFenceNV(int i, long j);

    static native boolean nglIsFenceNV(int i, long j);

    static native void nglGetFenceivNV(int i, int i2, long j, long j2);

    private NVFence() {
    }

    public static void glGenFencesNV(IntBuffer piFences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenFencesNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFences);
        nglGenFencesNV(piFences.remaining(), MemoryUtil.getAddress(piFences), function_pointer);
    }

    public static int glGenFencesNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenFencesNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer piFences = APIUtil.getBufferInt(caps);
        nglGenFencesNV(1, MemoryUtil.getAddress(piFences), function_pointer);
        return piFences.get(0);
    }

    public static void glDeleteFencesNV(IntBuffer piFences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteFencesNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFences);
        nglDeleteFencesNV(piFences.remaining(), MemoryUtil.getAddress(piFences), function_pointer);
    }

    public static void glDeleteFencesNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteFencesNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteFencesNV(1, APIUtil.getInt(caps, fence), function_pointer);
    }

    public static void glSetFenceNV(int fence, int condition) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glSetFenceNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglSetFenceNV(fence, condition, function_pointer);
    }

    public static boolean glTestFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTestFenceNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglTestFenceNV(fence, function_pointer);
        return __result;
    }

    public static void glFinishFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFinishFenceNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFinishFenceNV(fence, function_pointer);
    }

    public static boolean glIsFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsFenceNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsFenceNV(fence, function_pointer);
        return __result;
    }

    public static void glGetFenceivNV(int fence, int pname, IntBuffer piParams) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetFenceivNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(piParams, 4);
        nglGetFenceivNV(fence, pname, MemoryUtil.getAddress(piParams), function_pointer);
    }
}
