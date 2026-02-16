package org.lwjgl.opencl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/KHRTerminateContext.class */
public final class KHRTerminateContext {
    public static final int CL_DEVICE_TERMINATE_CAPABILITY_KHR = 8207;
    public static final int CL_CONTEXT_TERMINATE_KHR = 8208;

    static native int nclTerminateContextKHR(long j, long j2);

    private KHRTerminateContext() {
    }

    public static int clTerminateContextKHR(CLContext context) {
        long function_pointer = CLCapabilities.clTerminateContextKHR;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = nclTerminateContextKHR(context.getPointer(), function_pointer);
        return __result;
    }
}
