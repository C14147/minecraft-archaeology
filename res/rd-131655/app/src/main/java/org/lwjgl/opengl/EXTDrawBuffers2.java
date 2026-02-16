package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTDrawBuffers2.class */
public final class EXTDrawBuffers2 {
    static native void nglColorMaskIndexedEXT(int i, boolean z, boolean z2, boolean z3, boolean z4, long j);

    static native void nglGetBooleanIndexedvEXT(int i, int i2, long j, long j2);

    static native void nglGetIntegerIndexedvEXT(int i, int i2, long j, long j2);

    static native void nglEnableIndexedEXT(int i, int i2, long j);

    static native void nglDisableIndexedEXT(int i, int i2, long j);

    static native boolean nglIsEnabledIndexedEXT(int i, int i2, long j);

    private EXTDrawBuffers2() {
    }

    public static void glColorMaskIndexedEXT(int buf, boolean r, boolean g, boolean b, boolean a) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glColorMaskIndexedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglColorMaskIndexedEXT(buf, r, g, b, a, function_pointer);
    }

    public static void glGetBooleanIndexedEXT(int value, int index, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBooleanIndexedvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        nglGetBooleanIndexedvEXT(value, index, MemoryUtil.getAddress(data), function_pointer);
    }

    public static boolean glGetBooleanIndexedEXT(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetBooleanIndexedvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer data = APIUtil.getBufferByte(caps, 1);
        nglGetBooleanIndexedvEXT(value, index, MemoryUtil.getAddress(data), function_pointer);
        return data.get(0) == 1;
    }

    public static void glGetIntegerIndexedEXT(int value, int index, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetIntegerIndexedvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        nglGetIntegerIndexedvEXT(value, index, MemoryUtil.getAddress(data), function_pointer);
    }

    public static int glGetIntegerIndexedEXT(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetIntegerIndexedvEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtil.getBufferInt(caps);
        nglGetIntegerIndexedvEXT(value, index, MemoryUtil.getAddress(data), function_pointer);
        return data.get(0);
    }

    public static void glEnableIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glEnableIndexedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglEnableIndexedEXT(target, index, function_pointer);
    }

    public static void glDisableIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDisableIndexedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDisableIndexedEXT(target, index, function_pointer);
    }

    public static boolean glIsEnabledIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsEnabledIndexedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsEnabledIndexedEXT(target, index, function_pointer);
        return __result;
    }
}
