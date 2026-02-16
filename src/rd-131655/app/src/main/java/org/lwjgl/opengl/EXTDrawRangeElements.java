package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTDrawRangeElements.class */
public final class EXTDrawRangeElements {
    public static final int GL_MAX_ELEMENTS_VERTICES_EXT = 33000;
    public static final int GL_MAX_ELEMENTS_INDICES_EXT = 33001;

    static native void nglDrawRangeElementsEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglDrawRangeElementsEXTBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    private EXTDrawRangeElements() {
    }

    public static void glDrawRangeElementsEXT(int mode, int start, int end, ByteBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(pIndices);
        nglDrawRangeElementsEXT(mode, start, end, pIndices.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(pIndices), function_pointer);
    }

    public static void glDrawRangeElementsEXT(int mode, int start, int end, IntBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(pIndices);
        nglDrawRangeElementsEXT(mode, start, end, pIndices.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(pIndices), function_pointer);
    }

    public static void glDrawRangeElementsEXT(int mode, int start, int end, ShortBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(pIndices);
        nglDrawRangeElementsEXT(mode, start, end, pIndices.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(pIndices), function_pointer);
    }

    public static void glDrawRangeElementsEXT(int mode, int start, int end, int pIndices_count, int type, long pIndices_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        nglDrawRangeElementsEXTBO(mode, start, end, pIndices_count, type, pIndices_buffer_offset, function_pointer);
    }
}
