package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ATISeparateStencil.class */
public final class ATISeparateStencil {
    public static final int GL_STENCIL_BACK_FUNC_ATI = 34816;
    public static final int GL_STENCIL_BACK_FAIL_ATI = 34817;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL_ATI = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS_ATI = 34819;

    static native void nglStencilOpSeparateATI(int i, int i2, int i3, int i4, long j);

    static native void nglStencilFuncSeparateATI(int i, int i2, int i3, int i4, long j);

    private ATISeparateStencil() {
    }

    public static void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glStencilOpSeparateATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglStencilOpSeparateATI(face, sfail, dpfail, dppass, function_pointer);
    }

    public static void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glStencilFuncSeparateATI;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglStencilFuncSeparateATI(frontfunc, backfunc, ref, mask, function_pointer);
    }
}
