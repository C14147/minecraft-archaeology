package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/APPLEVertexArrayObject.class */
public final class APPLEVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING_APPLE = 34229;

    static native void nglBindVertexArrayAPPLE(int i, long j);

    static native void nglDeleteVertexArraysAPPLE(int i, long j, long j2);

    static native void nglGenVertexArraysAPPLE(int i, long j, long j2);

    static native boolean nglIsVertexArrayAPPLE(int i, long j);

    private APPLEVertexArrayObject() {
    }

    public static void glBindVertexArrayAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBindVertexArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBindVertexArrayAPPLE(array, function_pointer);
    }

    public static void glDeleteVertexArraysAPPLE(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        nglDeleteVertexArraysAPPLE(arrays.remaining(), MemoryUtil.getAddress(arrays), function_pointer);
    }

    public static void glDeleteVertexArraysAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDeleteVertexArraysAPPLE(1, APIUtil.getInt(caps, array), function_pointer);
    }

    public static void glGenVertexArraysAPPLE(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        nglGenVertexArraysAPPLE(arrays.remaining(), MemoryUtil.getAddress(arrays), function_pointer);
    }

    public static int glGenVertexArraysAPPLE() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGenVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer arrays = APIUtil.getBufferInt(caps);
        nglGenVertexArraysAPPLE(1, MemoryUtil.getAddress(arrays), function_pointer);
        return arrays.get(0);
    }

    public static boolean glIsVertexArrayAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsVertexArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsVertexArrayAPPLE(array, function_pointer);
        return __result;
    }
}
