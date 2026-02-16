package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTStencilTwoSide.class */
public final class EXTStencilTwoSide {
    public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 35088;
    public static final int GL_ACTIVE_STENCIL_FACE_EXT = 35089;

    static native void nglActiveStencilFaceEXT(int i, long j);

    private EXTStencilTwoSide() {
    }

    public static void glActiveStencilFaceEXT(int face) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glActiveStencilFaceEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglActiveStencilFaceEXT(face, function_pointer);
    }
}
