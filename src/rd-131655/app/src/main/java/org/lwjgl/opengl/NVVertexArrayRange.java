package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/NVVertexArrayRange.class */
public final class NVVertexArrayRange {
    public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
    public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
    public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;
    public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
    public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;

    static native void nglVertexArrayRangeNV(int i, long j, long j2);

    static native void nglFlushVertexArrayRangeNV(long j);

    static native ByteBuffer nglAllocateMemoryNV(int i, float f, float f2, float f3, long j, long j2);

    static native void nglFreeMemoryNV(long j, long j2);

    private NVVertexArrayRange() {
    }

    public static void glVertexArrayRangeNV(ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglVertexArrayRangeNV(pPointer.remaining(), MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glVertexArrayRangeNV(DoubleBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglVertexArrayRangeNV(pPointer.remaining() << 3, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glVertexArrayRangeNV(FloatBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglVertexArrayRangeNV(pPointer.remaining() << 2, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glVertexArrayRangeNV(IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglVertexArrayRangeNV(pPointer.remaining() << 2, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glVertexArrayRangeNV(ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        nglVertexArrayRangeNV(pPointer.remaining() << 1, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glFlushVertexArrayRangeNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFlushVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFlushVertexArrayRangeNV(function_pointer);
    }

    public static ByteBuffer glAllocateMemoryNV(int size, float readFrequency, float writeFrequency, float priority) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glAllocateMemoryNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = nglAllocateMemoryNV(size, readFrequency, writeFrequency, priority, size, function_pointer);
        if (LWJGLUtil.CHECKS && __result == null) {
            return null;
        }
        return __result.order(ByteOrder.nativeOrder());
    }

    public static void glFreeMemoryNV(ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFreeMemoryNV;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        nglFreeMemoryNV(MemoryUtil.getAddress(pointer), function_pointer);
    }
}
