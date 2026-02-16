package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/APPLEFlushBufferRange.class */
public final class APPLEFlushBufferRange {
    public static final int GL_BUFFER_SERIALIZED_MODIFY_APPLE = 35346;
    public static final int GL_BUFFER_FLUSHING_UNMAP_APPLE = 35347;

    static native void nglBufferParameteriAPPLE(int i, int i2, int i3, long j);

    static native void nglFlushMappedBufferRangeAPPLE(int i, long j, long j2, long j3);

    private APPLEFlushBufferRange() {
    }

    public static void glBufferParameteriAPPLE(int target, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glBufferParameteriAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglBufferParameteriAPPLE(target, pname, param, function_pointer);
    }

    public static void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFlushMappedBufferRangeAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFlushMappedBufferRangeAPPLE(target, offset, size, function_pointer);
    }
}
