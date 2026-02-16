package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AMDMultiDrawIndirect.class */
public final class AMDMultiDrawIndirect {
    static native void nglMultiDrawArraysIndirectAMD(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawArraysIndirectAMDBO(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawElementsIndirectAMD(int i, int i2, long j, int i3, int i4, long j2);

    static native void nglMultiDrawElementsIndirectAMDBO(int i, int i2, long j, int i3, int i4, long j2);

    private AMDMultiDrawIndirect() {
    }

    public static void glMultiDrawArraysIndirectAMD(int mode, ByteBuffer indirect, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 16 : stride) * primcount);
        nglMultiDrawArraysIndirectAMD(mode, MemoryUtil.getAddress(indirect), primcount, stride, function_pointer);
    }

    public static void glMultiDrawArraysIndirectAMD(int mode, long indirect_buffer_offset, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawArraysIndirectAMDBO(mode, indirect_buffer_offset, primcount, stride, function_pointer);
    }

    public static void glMultiDrawArraysIndirectAMD(int mode, IntBuffer indirect, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 4 : stride >> 2) * primcount);
        nglMultiDrawArraysIndirectAMD(mode, MemoryUtil.getAddress(indirect), primcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectAMD(int mode, int type, ByteBuffer indirect, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 20 : stride) * primcount);
        nglMultiDrawElementsIndirectAMD(mode, type, MemoryUtil.getAddress(indirect), primcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectAMD(int mode, int type, long indirect_buffer_offset, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawElementsIndirectAMDBO(mode, type, indirect_buffer_offset, primcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectAMD(int mode, int type, IntBuffer indirect, int primcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 5 : stride >> 2) * primcount);
        nglMultiDrawElementsIndirectAMD(mode, type, MemoryUtil.getAddress(indirect), primcount, stride, function_pointer);
    }
}
