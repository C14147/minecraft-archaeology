package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBIndirectParameters.class */
public final class ARBIndirectParameters {
    public static final int GL_PARAMETER_BUFFER_ARB = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;

    static native void nglMultiDrawArraysIndirectCountARB(int i, long j, long j2, int i2, int i3, long j3);

    static native void nglMultiDrawArraysIndirectCountARBBO(int i, long j, long j2, int i2, int i3, long j3);

    static native void nglMultiDrawElementsIndirectCountARB(int i, int i2, long j, long j2, int i3, int i4, long j3);

    static native void nglMultiDrawElementsIndirectCountARBBO(int i, int i2, long j, long j2, int i3, int i4, long j3);

    private ARBIndirectParameters() {
    }

    public static void glMultiDrawArraysIndirectCountARB(int mode, ByteBuffer indirect, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 16 : stride) * maxdrawcount);
        nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.getAddress(indirect), drawcount, maxdrawcount, stride, function_pointer);
    }

    public static void glMultiDrawArraysIndirectCountARB(int mode, long indirect_buffer_offset, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawArraysIndirectCountARBBO(mode, indirect_buffer_offset, drawcount, maxdrawcount, stride, function_pointer);
    }

    public static void glMultiDrawArraysIndirectCountARB(int mode, IntBuffer indirect, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 4 : stride >> 2) * maxdrawcount);
        nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.getAddress(indirect), drawcount, maxdrawcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectCountARB(int mode, int type, ByteBuffer indirect, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 20 : stride) * maxdrawcount);
        nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.getAddress(indirect), drawcount, maxdrawcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectCountARB(int mode, int type, long indirect_buffer_offset, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        nglMultiDrawElementsIndirectCountARBBO(mode, type, indirect_buffer_offset, drawcount, maxdrawcount, stride, function_pointer);
    }

    public static void glMultiDrawElementsIndirectCountARB(int mode, int type, IntBuffer indirect, long drawcount, int maxdrawcount, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, (stride == 0 ? 5 : stride >> 2) * maxdrawcount);
        nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.getAddress(indirect), drawcount, maxdrawcount, stride, function_pointer);
    }
}
