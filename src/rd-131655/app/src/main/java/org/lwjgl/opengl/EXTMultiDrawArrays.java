package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/EXTMultiDrawArrays.class */
public final class EXTMultiDrawArrays {
    static native void nglMultiDrawArraysEXT(int i, long j, long j2, int i2, long j3);

    private EXTMultiDrawArrays() {
    }

    public static void glMultiDrawArraysEXT(int mode, IntBuffer piFirst, IntBuffer piCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glMultiDrawArraysEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFirst);
        BufferChecks.checkBuffer(piCount, piFirst.remaining());
        nglMultiDrawArraysEXT(mode, MemoryUtil.getAddress(piFirst), MemoryUtil.getAddress(piCount), piFirst.remaining(), function_pointer);
    }
}
