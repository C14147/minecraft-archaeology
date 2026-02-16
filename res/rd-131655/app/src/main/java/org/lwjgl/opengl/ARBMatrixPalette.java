package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBMatrixPalette.class */
public final class ARBMatrixPalette {
    public static final int GL_MATRIX_PALETTE_ARB = 34880;
    public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
    public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
    public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
    public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
    public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;

    static native void nglCurrentPaletteMatrixARB(int i, long j);

    static native void nglMatrixIndexPointerARB(int i, int i2, int i3, long j, long j2);

    static native void nglMatrixIndexPointerARBBO(int i, int i2, int i3, long j, long j2);

    static native void nglMatrixIndexubvARB(int i, long j, long j2);

    static native void nglMatrixIndexusvARB(int i, long j, long j2);

    static native void nglMatrixIndexuivARB(int i, long j, long j2);

    private ARBMatrixPalette() {
    }

    public static void glCurrentPaletteMatrixARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCurrentPaletteMatrixARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglCurrentPaletteMatrixARB(index, function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int stride, ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        }
        nglMatrixIndexPointerARB(size, GL11.GL_UNSIGNED_BYTE, stride, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int stride, IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        }
        nglMatrixIndexPointerARB(size, GL11.GL_UNSIGNED_INT, stride, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int stride, ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        }
        nglMatrixIndexPointerARB(size, GL11.GL_UNSIGNED_SHORT, stride, MemoryUtil.getAddress(pPointer), function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int type, int stride, long pPointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        nglMatrixIndexPointerARBBO(size, type, stride, pPointer_buffer_offset, function_pointer);
    }

    public static void glMatrixIndexuARB(ByteBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexubvARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        nglMatrixIndexubvARB(pIndices.remaining(), MemoryUtil.getAddress(pIndices), function_pointer);
    }

    public static void glMatrixIndexuARB(ShortBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexusvARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        nglMatrixIndexusvARB(pIndices.remaining(), MemoryUtil.getAddress(pIndices), function_pointer);
    }

    public static void glMatrixIndexuARB(IntBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMatrixIndexuivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        nglMatrixIndexuivARB(pIndices.remaining(), MemoryUtil.getAddress(pIndices), function_pointer);
    }
}
