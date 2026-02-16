package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBInstancedArrays.class */
public final class ARBInstancedArrays {
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;

    static native void nglVertexAttribDivisorARB(int i, int i2, long j);

    private ARBInstancedArrays() {
    }

    public static void glVertexAttribDivisorARB(int index, int divisor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexAttribDivisorARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglVertexAttribDivisorARB(index, divisor, function_pointer);
    }
}
