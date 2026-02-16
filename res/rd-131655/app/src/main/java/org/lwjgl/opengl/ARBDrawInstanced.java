package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBDrawInstanced.class */
public final class ARBDrawInstanced {
    static native void nglDrawArraysInstancedARB(int i, int i2, int i3, int i4, long j);

    static native void nglDrawElementsInstancedARB(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglDrawElementsInstancedARBBO(int i, int i2, int i3, long j, int i4, long j2);

    private ARBDrawInstanced() {
    }

    public static void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawArraysInstancedARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawArraysInstancedARB(mode, first, count, primcount, function_pointer);
    }

    public static void glDrawElementsInstancedARB(int mode, ByteBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedARB(mode, indices.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedARB(int mode, IntBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedARB(mode, indices.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedARB(int mode, ShortBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedARB(mode, indices.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedARB(int mode, int indices_count, int type, long indices_buffer_offset, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        nglDrawElementsInstancedARBBO(mode, indices_count, type, indices_buffer_offset, primcount, function_pointer);
    }
}
