package org.lwjgl.opencl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APPLEContextLoggingUtil.class */
public final class APPLEContextLoggingUtil {
    public static final CLContextCallback SYSTEM_LOG_CALLBACK;
    public static final CLContextCallback STD_OUT_CALLBACK;
    public static final CLContextCallback STD_ERR_CALLBACK;

    static {
        if (CLCapabilities.CL_APPLE_ContextLoggingFunctions) {
            SYSTEM_LOG_CALLBACK = new CLContextCallback(CallbackUtil.getLogMessageToSystemLogAPPLE()) { // from class: org.lwjgl.opencl.APPLEContextLoggingUtil.1
                @Override // org.lwjgl.opencl.CLContextCallback
                protected void handleMessage(String errinfo, ByteBuffer private_info) {
                    throw new UnsupportedOperationException();
                }
            };
            STD_OUT_CALLBACK = new CLContextCallback(CallbackUtil.getLogMessageToStdoutAPPLE()) { // from class: org.lwjgl.opencl.APPLEContextLoggingUtil.2
                @Override // org.lwjgl.opencl.CLContextCallback
                protected void handleMessage(String errinfo, ByteBuffer private_info) {
                    throw new UnsupportedOperationException();
                }
            };
            STD_ERR_CALLBACK = new CLContextCallback(CallbackUtil.getLogMessageToStderrAPPLE()) { // from class: org.lwjgl.opencl.APPLEContextLoggingUtil.3
                @Override // org.lwjgl.opencl.CLContextCallback
                protected void handleMessage(String errinfo, ByteBuffer private_info) {
                    throw new UnsupportedOperationException();
                }
            };
        } else {
            SYSTEM_LOG_CALLBACK = null;
            STD_OUT_CALLBACK = null;
            STD_ERR_CALLBACK = null;
        }
    }

    private APPLEContextLoggingUtil() {
    }
}
