package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTDrawInstanced.class */
public final class EXTDrawInstanced {
    static native void nglDrawArraysInstancedEXT(int i, int i2, int i3, int i4, long j);

    static native void nglDrawElementsInstancedEXT(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglDrawElementsInstancedEXTBO(int i, int i2, int i3, long j, int i4, long j2);

    private EXTDrawInstanced() {
    }

    public static void glDrawArraysInstancedEXT(int mode, int first, int count, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawArraysInstancedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDrawArraysInstancedEXT(mode, first, count, primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, ByteBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedEXT(mode, indices.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, IntBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedEXT(mode, indices.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, ShortBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        nglDrawElementsInstancedEXT(mode, indices.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(indices), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, int indices_count, int type, long indices_buffer_offset, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDrawElementsInstancedEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        nglDrawElementsInstancedEXTBO(mode, indices_count, type, indices_buffer_offset, primcount, function_pointer);
    }
}
