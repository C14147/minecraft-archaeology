package org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.GLSync;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/KHRGLEvent.class */
public final class KHRGLEvent {
    public static final int CL_COMMAND_GL_FENCE_SYNC_OBJECT_KHR = 8205;

    static native long nclCreateEventFromGLsyncKHR(long j, long j2, long j3, long j4);

    private KHRGLEvent() {
    }

    public static CLEvent clCreateEventFromGLsyncKHR(CLContext context, GLSync sync, IntBuffer errcode_ret) {
        long function_pointer = CLCapabilities.clCreateEventFromGLsyncKHR;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (errcode_ret != null) {
            BufferChecks.checkBuffer(errcode_ret, 1);
        }
        CLEvent __result = new CLEvent(nclCreateEventFromGLsyncKHR(context.getPointer(), sync.getPointer(), MemoryUtil.getAddressSafe(errcode_ret), function_pointer), context);
        return __result;
    }
}
