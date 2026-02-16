package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTCompiledVertexArray.class */
public final class EXTCompiledVertexArray {
    public static final int GL_ARRAY_ELEMENT_LOCK_FIRST_EXT = 33192;
    public static final int GL_ARRAY_ELEMENT_LOCK_COUNT_EXT = 33193;

    static native void nglLockArraysEXT(int i, int i2, long j);

    static native void nglUnlockArraysEXT(long j);

    private EXTCompiledVertexArray() {
    }

    public static void glLockArraysEXT(int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glLockArraysEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglLockArraysEXT(first, count, function_pointer);
    }

    public static void glUnlockArraysEXT() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glUnlockArraysEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglUnlockArraysEXT(function_pointer);
    }
}
