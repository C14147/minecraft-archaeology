package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBWindowPos.class */
public final class ARBWindowPos {
    static native void nglWindowPos2fARB(float f, float f2, long j);

    static native void nglWindowPos2dARB(double d, double d2, long j);

    static native void nglWindowPos2iARB(int i, int i2, long j);

    static native void nglWindowPos2sARB(short s, short s2, long j);

    static native void nglWindowPos3fARB(float f, float f2, float f3, long j);

    static native void nglWindowPos3dARB(double d, double d2, double d3, long j);

    static native void nglWindowPos3iARB(int i, int i2, int i3, long j);

    static native void nglWindowPos3sARB(short s, short s2, short s3, long j);

    private ARBWindowPos() {
    }

    public static void glWindowPos2fARB(float x, float y) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos2fARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos2fARB(x, y, function_pointer);
    }

    public static void glWindowPos2dARB(double x, double y) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos2dARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos2dARB(x, y, function_pointer);
    }

    public static void glWindowPos2iARB(int x, int y) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos2iARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos2iARB(x, y, function_pointer);
    }

    public static void glWindowPos2sARB(short x, short y) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos2sARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos2sARB(x, y, function_pointer);
    }

    public static void glWindowPos3fARB(float x, float y, float z) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos3fARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos3fARB(x, y, z, function_pointer);
    }

    public static void glWindowPos3dARB(double x, double y, double z) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos3dARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos3dARB(x, y, z, function_pointer);
    }

    public static void glWindowPos3iARB(int x, int y, int z) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos3iARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos3iARB(x, y, z, function_pointer);
    }

    public static void glWindowPos3sARB(short x, short y, short z) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glWindowPos3sARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglWindowPos3sARB(x, y, z, function_pointer);
    }
}
