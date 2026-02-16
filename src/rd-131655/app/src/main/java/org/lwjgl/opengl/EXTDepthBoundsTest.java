package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTDepthBoundsTest.class */
public final class EXTDepthBoundsTest {
    public static final int GL_DEPTH_BOUNDS_TEST_EXT = 34960;
    public static final int GL_DEPTH_BOUNDS_EXT = 34961;

    static native void nglDepthBoundsEXT(double d, double d2, long j);

    private EXTDepthBoundsTest() {
    }

    public static void glDepthBoundsEXT(double zmin, double zmax) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDepthBoundsEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglDepthBoundsEXT(zmin, zmax, function_pointer);
    }
}
