package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/APPLEFence.class */
public final class APPLEFence {
    public static final int GL_DRAW_PIXELS_APPLE = 35338;
    public static final int GL_FENCE_APPLE = 35339;

    static native void nglGenFencesAPPLE(int i, long j, long j2);

    static native void nglDeleteFencesAPPLE(int i, long j, long j2);

    static native void nglSetFenceAPPLE(int i, long j);

    static native boolean nglIsFenceAPPLE(int i, long j);

    static native boolean nglTestFenceAPPLE(int i, long j);

    static native void nglFinishFenceAPPLE(int i, long j);

    static native boolean nglTestObjectAPPLE(int i, int i2, long j);

    static native void nglFinishObjectAPPLE(int i, int i2, long j);

    private APPLEFence() {
    }

    public static void glGenFencesAPPLE(IntBuffer fences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenFencesAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(fences);
        nglGenFencesAPPLE(fences.remaining(), MemoryUtil.getAddress(fences), function_pointer);
    }

    public static int glGenFencesAPPLE() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenFencesAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer fences = APIUtil.getBufferInt(caps);
        nglGenFencesAPPLE(1, MemoryUtil.getAddress(fences), function_pointer);
        return fences.get(0);
    }

    public static void glDeleteFencesAPPLE(IntBuffer fences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteFencesAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(fences);
        nglDeleteFencesAPPLE(fences.remaining(), MemoryUtil.getAddress(fences), function_pointer);
    }

    public static void glDeleteFencesAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteFencesAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteFencesAPPLE(1, APIUtil.getInt(caps, fence), function_pointer);
    }

    public static void glSetFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glSetFenceAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglSetFenceAPPLE(fence, function_pointer);
    }

    public static boolean glIsFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsFenceAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsFenceAPPLE(fence, function_pointer);
        return __result;
    }

    public static boolean glTestFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTestFenceAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglTestFenceAPPLE(fence, function_pointer);
        return __result;
    }

    public static void glFinishFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFinishFenceAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFinishFenceAPPLE(fence, function_pointer);
    }

    public static boolean glTestObjectAPPLE(int object, int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glTestObjectAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglTestObjectAPPLE(object, name, function_pointer);
        return __result;
    }

    public static void glFinishObjectAPPLE(int object, int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFinishObjectAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFinishObjectAPPLE(object, name, function_pointer);
    }
}
