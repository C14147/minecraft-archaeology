package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AMDInterleavedElements.class */
public final class AMDInterleavedElements {
    public static final int GL_VERTEX_ELEMENT_SWIZZLE_AMD = 37284;
    public static final int GL_VERTEX_ID_SWIZZLE_AMD = 37285;

    static native void nglVertexAttribParameteriAMD(int i, int i2, int i3, long j);

    private AMDInterleavedElements() {
    }

    public static void glVertexAttribParameteriAMD(int index, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glVertexAttribParameteriAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglVertexAttribParameteriAMD(index, pname, param, function_pointer);
    }
}
