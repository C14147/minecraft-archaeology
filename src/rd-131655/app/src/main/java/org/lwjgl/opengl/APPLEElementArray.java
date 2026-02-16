package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/APPLEElementArray.class */
public final class APPLEElementArray {
    public static final int GL_ELEMENT_ARRAY_APPLE = 34664;
    public static final int GL_ELEMENT_ARRAY_TYPE_APPLE = 34665;
    public static final int GL_ELEMENT_ARRAY_POINTER_APPLE = 34666;

    static native void nglElementPointerAPPLE(int i, long j, long j2);

    static native void nglDrawElementArrayAPPLE(int i, int i2, int i3, long j);

    static native void nglDrawRangeElementArrayAPPLE(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglMultiDrawElementArrayAPPLE(int i, long j, long j2, int i2, long j3);

    static native void nglMultiDrawRangeElementArrayAPPLE(int i, int i2, int i3, long j, long j2, int i4, long j3);

    private APPLEElementArray() {
    }

    public static void glElementPointerAPPLE(ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(pointer), function_pointer);
    }

    public static void glElementPointerAPPLE(IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(pointer), function_pointer);
    }

    public static void glElementPointerAPPLE(ShortBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(pointer), function_pointer);
    }

    public static void glDrawElementArrayAPPLE(int mode, int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawElementArrayAPPLE(mode, first, count, function_pointer);
    }

    public static void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawRangeElementArrayAPPLE(mode, start, end, first, count, function_pointer);
    }

    public static void glMultiDrawElementArrayAPPLE(int mode, IntBuffer first, IntBuffer count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(first);
        BufferChecks.checkBuffer(count, first.remaining());
        nglMultiDrawElementArrayAPPLE(mode, MemoryUtil.getAddress(first), MemoryUtil.getAddress(count), first.remaining(), function_pointer);
    }

    public static void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, IntBuffer first, IntBuffer count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawRangeElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(first);
        BufferChecks.checkBuffer(count, first.remaining());
        nglMultiDrawRangeElementArrayAPPLE(mode, start, end, MemoryUtil.getAddress(first), MemoryUtil.getAddress(count), first.remaining(), function_pointer);
    }
}
