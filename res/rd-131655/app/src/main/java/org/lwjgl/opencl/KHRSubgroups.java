package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/KHRSubgroups.class */
public final class KHRSubgroups {
    static native int nclGetKernelSubGroupInfoKHR(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, long j8);

    private KHRSubgroups() {
    }

    public static int clGetKernelSubGroupInfoKHR(CLKernel kernel, CLDevice device, int param_name, ByteBuffer input_value, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
        long function_pointer = CLCapabilities.clGetKernelSubGroupInfoKHR;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (input_value != null) {
            BufferChecks.checkDirect(input_value);
        }
        if (param_value != null) {
            BufferChecks.checkDirect(param_value);
        }
        if (param_value_size_ret != null) {
            BufferChecks.checkBuffer(param_value_size_ret, 1);
        }
        int __result = nclGetKernelSubGroupInfoKHR(kernel.getPointer(), device == null ? 0L : device.getPointer(), param_name, input_value == null ? 0 : input_value.remaining(), MemoryUtil.getAddressSafe(input_value), param_value == null ? 0 : param_value.remaining(), MemoryUtil.getAddressSafe(param_value), MemoryUtil.getAddressSafe(param_value_size_ret), function_pointer);
        return __result;
    }
}
