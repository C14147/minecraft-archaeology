package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTProvokingVertex.class */
public final class EXTProvokingVertex {
    public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430;
    public static final int GL_PROVOKING_VERTEX_EXT = 36431;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION_EXT = 36428;

    static native void nglProvokingVertexEXT(int i, long j);

    private EXTProvokingVertex() {
    }

    public static void glProvokingVertexEXT(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glProvokingVertexEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglProvokingVertexEXT(mode, function_pointer);
    }
}
