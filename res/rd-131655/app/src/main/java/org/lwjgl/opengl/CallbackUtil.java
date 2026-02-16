package org.lwjgl.opengl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/CallbackUtil.class */
final class CallbackUtil {
    private static final Map<ContextCapabilities, Long> contextUserParamsARB = new HashMap();
    private static final Map<ContextCapabilities, Long> contextUserParamsAMD = new HashMap();
    private static final Map<ContextCapabilities, Long> contextUserParamsKHR = new HashMap();

    private static native long ncreateGlobalRef(Object obj);

    private static native void deleteGlobalRef(long j);

    static native long getDebugOutputCallbackARB();

    static native long getDebugOutputCallbackAMD();

    static native long getDebugCallbackKHR();

    private CallbackUtil() {
    }

    static long createGlobalRef(Object obj) {
        if (obj == null) {
            return 0L;
        }
        return ncreateGlobalRef(obj);
    }

    private static void registerContextCallback(long userParam, Map<ContextCapabilities, Long> contextUserData) {
        ContextCapabilities caps = GLContext.getCapabilities();
        if (caps == null) {
            deleteGlobalRef(userParam);
            throw new IllegalStateException("No context is current.");
        }
        Long userParam_old = contextUserData.remove(caps);
        if (userParam_old != null) {
            deleteGlobalRef(userParam_old.longValue());
        }
        if (userParam != 0) {
            contextUserData.put(caps, Long.valueOf(userParam));
        }
    }

    static void unregisterCallbacks(Object context) {
        ContextCapabilities caps = GLContext.getCapabilities(context);
        Long userParam = contextUserParamsARB.remove(caps);
        if (userParam != null) {
            deleteGlobalRef(userParam.longValue());
        }
        Long userParam2 = contextUserParamsAMD.remove(caps);
        if (userParam2 != null) {
            deleteGlobalRef(userParam2.longValue());
        }
        Long userParam3 = contextUserParamsKHR.remove(caps);
        if (userParam3 != null) {
            deleteGlobalRef(userParam3.longValue());
        }
    }

    static void registerContextCallbackARB(long userParam) {
        registerContextCallback(userParam, contextUserParamsARB);
    }

    static void registerContextCallbackAMD(long userParam) {
        registerContextCallback(userParam, contextUserParamsAMD);
    }

    static void registerContextCallbackKHR(long userParam) {
        registerContextCallback(userParam, contextUserParamsKHR);
    }
}
