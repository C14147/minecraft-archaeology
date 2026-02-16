package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/GREMEDYFrameTerminator.class */
public final class GREMEDYFrameTerminator {
    static native void nglFrameTerminatorGREMEDY(long j);

    private GREMEDYFrameTerminator() {
    }

    public static void glFrameTerminatorGREMEDY() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glFrameTerminatorGREMEDY;
        BufferChecks.checkFunctionAddress(function_pointer);
        nglFrameTerminatorGREMEDY(function_pointer);
    }
}
