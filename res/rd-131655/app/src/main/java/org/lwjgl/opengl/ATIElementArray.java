package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ATIElementArray.class */
public final class ATIElementArray {
    public static final int GL_ELEMENT_ARRAY_ATI = 34664;
    public static final int GL_ELEMENT_ARRAY_TYPE_ATI = 34665;
    public static final int GL_ELEMENT_ARRAY_POINTER_ATI = 34666;

    static native void nglElementPointerATI(int i, long j, long j2);

    static native void nglDrawElementArrayATI(int i, int i2, long j);

    static native void nglDrawRangeElementArrayATI(int i, int i2, int i3, int i4, long j);

    private ATIElementArray() {
    }

    public static void glElementPointerATI(ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglElementPointerATI(GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glElementPointerATI(IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglElementPointerATI(GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glElementPointerATI(ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glElementPointerATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglElementPointerATI(GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glDrawElementArrayATI(int mode, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementArrayATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawElementArrayATI(mode, count, function_pointer);
    }

    public static void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementArrayATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawRangeElementArrayATI(mode, start, end, count, function_pointer);
    }
}
