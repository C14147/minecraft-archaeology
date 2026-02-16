package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLEvent;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBCLEvent.class */
public final class ARBCLEvent {
    public static final int GL_SYNC_CL_EVENT_ARB = 33344;
    public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;

    static native long nglCreateSyncFromCLeventARB(long j, long j2, int i, long j3);

    private ARBCLEvent() {
    }

    public static GLSync glCreateSyncFromCLeventARB(CLContext context, CLEvent event, int flags) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCreateSyncFromCLeventARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLSync __result = new GLSync(nglCreateSyncFromCLeventARB(context.getPointer(), event.getPointer(), flags, function_pointer));
        return __result;
    }
}
