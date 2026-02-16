package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APPLEContextLoggingFunctions.class */
final class APPLEContextLoggingFunctions {
    static native void nclLogMessagesToSystemLogAPPLE(long j, long j2, long j3, long j4, long j5);

    static native void nclLogMessagesToStdoutAPPLE(long j, long j2, long j3, long j4, long j5);

    static native void nclLogMessagesToStderrAPPLE(long j, long j2, long j3, long j4, long j5);

    private APPLEContextLoggingFunctions() {
    }

    static void clLogMessagesToSystemLogAPPLE(ByteBuffer errstr, ByteBuffer private_info, ByteBuffer user_data) {
        long function_pointer = CLCapabilities.clLogMessagesToSystemLogAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(errstr);
        BufferChecks.checkDirect(private_info);
        BufferChecks.checkDirect(user_data);
        nclLogMessagesToSystemLogAPPLE(MemoryUtil.getAddress(errstr), MemoryUtil.getAddress(private_info), private_info.remaining(), MemoryUtil.getAddress(user_data), function_pointer);
    }

    static void clLogMessagesToStdoutAPPLE(ByteBuffer errstr, ByteBuffer private_info, ByteBuffer user_data) {
        long function_pointer = CLCapabilities.clLogMessagesToStdoutAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(errstr);
        BufferChecks.checkDirect(private_info);
        BufferChecks.checkDirect(user_data);
        nclLogMessagesToStdoutAPPLE(MemoryUtil.getAddress(errstr), MemoryUtil.getAddress(private_info), private_info.remaining(), MemoryUtil.getAddress(user_data), function_pointer);
    }

    static void clLogMessagesToStderrAPPLE(ByteBuffer errstr, ByteBuffer private_info, ByteBuffer user_data) {
        long function_pointer = CLCapabilities.clLogMessagesToStderrAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(errstr);
        BufferChecks.checkDirect(private_info);
        BufferChecks.checkDirect(user_data);
        nclLogMessagesToStderrAPPLE(MemoryUtil.getAddress(errstr), MemoryUtil.getAddress(private_info), private_info.remaining(), MemoryUtil.getAddress(user_data), function_pointer);
    }
}
