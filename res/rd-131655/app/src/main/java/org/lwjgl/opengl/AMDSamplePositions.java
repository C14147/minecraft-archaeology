package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AMDSamplePositions.class */
public final class AMDSamplePositions {
    public static final int GL_SUBSAMPLE_DISTANCE_AMD = 34879;

    static native void nglSetMultisamplefvAMD(int i, int i2, long j, long j2);

    private AMDSamplePositions() {
    }

    public static void glSetMultisampleAMD(int pname, int index, FloatBuffer val) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glSetMultisamplefvAMD;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(val, 2);
        nglSetMultisamplefvAMD(pname, index, MemoryUtil.getAddress(val), function_pointer);
    }
}
