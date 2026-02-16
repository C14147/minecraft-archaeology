package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/APPLEVertexProgramEvaluators.class */
public final class APPLEVertexProgramEvaluators {
    public static final int GL_VERTEX_ATTRIB_MAP1_APPLE = 35328;
    public static final int GL_VERTEX_ATTRIB_MAP2_APPLE = 35329;
    public static final int GL_VERTEX_ATTRIB_MAP1_SIZE_APPLE = 35330;
    public static final int GL_VERTEX_ATTRIB_MAP1_COEFF_APPLE = 35331;
    public static final int GL_VERTEX_ATTRIB_MAP1_ORDER_APPLE = 35332;
    public static final int GL_VERTEX_ATTRIB_MAP1_DOMAIN_APPLE = 35333;
    public static final int GL_VERTEX_ATTRIB_MAP2_SIZE_APPLE = 35334;
    public static final int GL_VERTEX_ATTRIB_MAP2_COEFF_APPLE = 35335;
    public static final int GL_VERTEX_ATTRIB_MAP2_ORDER_APPLE = 35336;
    public static final int GL_VERTEX_ATTRIB_MAP2_DOMAIN_APPLE = 35337;

    static native void nglEnableVertexAttribAPPLE(int i, int i2, long j);

    static native void nglDisableVertexAttribAPPLE(int i, int i2, long j);

    static native boolean nglIsVertexAttribEnabledAPPLE(int i, int i2, long j);

    static native void nglMapVertexAttrib1dAPPLE(int i, int i2, double d, double d2, int i3, int i4, long j, long j2);

    static native void nglMapVertexAttrib1fAPPLE(int i, int i2, float f, float f2, int i3, int i4, long j, long j2);

    static native void nglMapVertexAttrib2dAPPLE(int i, int i2, double d, double d2, int i3, int i4, double d3, double d4, int i5, int i6, long j, long j2);

    static native void nglMapVertexAttrib2fAPPLE(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, int i5, int i6, long j, long j2);

    private APPLEVertexProgramEvaluators() {
    }

    public static void glEnableVertexAttribAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glEnableVertexAttribAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglEnableVertexAttribAPPLE(index, pname, function_pointer);
    }

    public static void glDisableVertexAttribAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDisableVertexAttribAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDisableVertexAttribAPPLE(index, pname, function_pointer);
    }

    public static boolean glIsVertexAttribEnabledAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsVertexAttribEnabledAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = nglIsVertexAttribEnabledAPPLE(index, pname, function_pointer);
        return __result;
    }

    public static void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapVertexAttrib1dAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        nglMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, MemoryUtil.getAddress(points), function_pointer);
    }

    public static void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapVertexAttrib1fAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        nglMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, MemoryUtil.getAddress(points), function_pointer);
    }

    public static void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapVertexAttrib2dAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        nglMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.getAddress(points), function_pointer);
    }

    public static void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMapVertexAttrib2fAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        nglMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.getAddress(points), function_pointer);
    }
}
