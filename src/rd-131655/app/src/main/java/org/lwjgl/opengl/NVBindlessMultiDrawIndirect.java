package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVBindlessMultiDrawIndirect.class */
public final class NVBindlessMultiDrawIndirect {
    static native void nglMultiDrawArraysIndirectBindlessNV(int i, long j, int i2, int i3, int i4, long j2);

    static native void nglMultiDrawArraysIndirectBindlessNVBO(int i, long j, int i2, int i3, int i4, long j2);

    static native void nglMultiDrawElementsIndirectBindlessNV(int i, int i2, long j, int i3, int i4, int i5, long j2);

    static native void nglMultiDrawElementsIndirectBindlessNVBO(int i, int i2, long j, int i3, int i4, int i5, long j2);

    private NVBindlessMultiDrawIndirect() {
    }

    public static void glMultiDrawArraysIndirectBindlessNV(int mode, ByteBuffer indirect, int drawCount, int stride, int vertexBufferCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 20 + (24 * vertexBufferCount) : stride) * drawCount);
        nglMultiDrawArraysIndirectBindlessNV(mode, MemoryUtil.getAddress(indirect), drawCount, stride, vertexBufferCount, function_pointer);
    }

    public static void glMultiDrawArraysIndirectBindlessNV(int mode, long indirect_buffer_offset, int drawCount, int stride, int vertexBufferCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawArraysIndirectBindlessNVBO(mode, indirect_buffer_offset, drawCount, stride, vertexBufferCount, function_pointer);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(int mode, int type, ByteBuffer indirect, int drawCount, int stride, int vertexBufferCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 48 + (24 * vertexBufferCount) : stride) * drawCount);
        nglMultiDrawElementsIndirectBindlessNV(mode, type, MemoryUtil.getAddress(indirect), drawCount, stride, vertexBufferCount, function_pointer);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(int mode, int type, long indirect_buffer_offset, int drawCount, int stride, int vertexBufferCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawElementsIndirectBindlessNVBO(mode, type, indirect_buffer_offset, drawCount, stride, vertexBufferCount, function_pointer);
    }
}
