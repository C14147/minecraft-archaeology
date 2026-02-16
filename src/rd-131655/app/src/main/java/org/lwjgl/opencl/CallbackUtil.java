package org.lwjgl.opencl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CallbackUtil.class */
final class CallbackUtil {
    private static final Map<CLContext, Long> contextUserData = new HashMap();

    private static native long ncreateGlobalRef(Object obj);

    static native void deleteGlobalRef(long j);

    static native long getContextCallback();

    static native long getMemObjectDestructorCallback();

    static native long getProgramCallback();

    static native long getNativeKernelCallback();

    static native long getEventCallback();

    static native long getPrintfCallback();

    static native long getLogMessageToSystemLogAPPLE();

    static native long getLogMessageToStdoutAPPLE();

    static native long getLogMessageToStderrAPPLE();

    private CallbackUtil() {
    }

    static long createGlobalRef(Object obj) {
        if (obj == null) {
            return 0L;
        }
        return ncreateGlobalRef(obj);
    }

    static void checkCallback(int errcode, long user_data) {
        if (errcode != 0 && user_data != 0) {
            deleteGlobalRef(user_data);
        }
    }
}
