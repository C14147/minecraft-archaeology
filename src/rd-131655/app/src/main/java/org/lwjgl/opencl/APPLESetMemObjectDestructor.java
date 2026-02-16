package org.lwjgl.opencl;

import org.lwjgl.BufferChecks;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/APPLESetMemObjectDestructor.class */
public final class APPLESetMemObjectDestructor {
    static native int nclSetMemObjectDestructorAPPLE(long j, long j2, long j3, long j4);

    private APPLESetMemObjectDestructor() {
    }

    public static int clSetMemObjectDestructorAPPLE(CLMem memobj, CLMemObjectDestructorCallback pfn_notify) {
        long function_pointer = CLCapabilities.clSetMemObjectDestructorAPPLE;
        BufferChecks.checkFunctionAddress(function_pointer);
        long user_data = CallbackUtil.createGlobalRef(pfn_notify);
        int __result = 0;
        try {
            __result = nclSetMemObjectDestructorAPPLE(memobj.getPointer(), pfn_notify.getPointer(), user_data, function_pointer);
            CallbackUtil.checkCallback(__result, user_data);
            return __result;
        } catch (Throwable th) {
            CallbackUtil.checkCallback(__result, user_data);
            throw th;
        }
    }
}
