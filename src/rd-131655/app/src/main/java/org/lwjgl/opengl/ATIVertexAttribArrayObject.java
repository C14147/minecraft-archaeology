package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ATIVertexAttribArrayObject.class */
public final class ATIVertexAttribArrayObject {
    static native void nglVertexAttribArrayObjectATI(int i, int i2, int i3, boolean z, int i4, int i5, int i6, long j);

    static native void nglGetVertexAttribArrayObjectfvATI(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribArrayObjectivATI(int i, int i2, long j, long j2);

    private ATIVertexAttribArrayObject() {
    }

    public static void glVertexAttribArrayObjectATI(int index, int size, int type, boolean normalized, int stride, int buffer, int offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexAttribArrayObjectATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglVertexAttribArrayObjectATI(index, size, type, normalized, stride, buffer, offset, function_pointer);
    }

    public static void glGetVertexAttribArrayObjectATI(int index, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVertexAttribArrayObjectfvATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglGetVertexAttribArrayObjectfvATI(index, pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static void glGetVertexAttribArrayObjectATI(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetVertexAttribArrayObjectivATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        nglGetVertexAttribArrayObjectivATI(index, pname, MemoryUtil.getAddress(params), function_pointer);
    }
}
