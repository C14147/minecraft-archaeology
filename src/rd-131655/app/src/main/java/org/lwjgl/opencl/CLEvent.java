package org.lwjgl.opencl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLEvent.class */
public final class CLEvent extends CLObjectChild<CLContext> {
    private static final CLEventUtil util = (CLEventUtil) CLPlatform.getInfoUtilInstance(CLEvent.class, "CL_EVENT_UTIL");
    private final CLCommandQueue queue;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLEvent$CLEventUtil.class */
    interface CLEventUtil extends InfoUtil<CLEvent> {
        long getProfilingInfoLong(CLEvent cLEvent, int i);
    }

    CLEvent(long pointer, CLContext context) {
        this(pointer, context, null);
    }

    CLEvent(long pointer, CLCommandQueue queue) {
        this(pointer, queue.getParent(), queue);
    }

    CLEvent(long pointer, CLContext context, CLCommandQueue queue) {
        super(pointer, context);
        if (isValid()) {
            this.queue = queue;
            if (queue == null) {
                context.getCLEventRegistry().registerObject(this);
                return;
            } else {
                queue.getCLEventRegistry().registerObject(this);
                return;
            }
        }
        this.queue = null;
    }

    public CLCommandQueue getCLCommandQueue() {
        return this.queue;
    }

    public int getInfoInt(int param_name) {
        return util.getInfoInt(this, param_name);
    }

    public long getProfilingInfoLong(int param_name) {
        return util.getProfilingInfoLong(this, param_name);
    }

    CLObjectRegistry<CLEvent> getParentRegistry() {
        if (this.queue == null) {
            return getParent().getCLEventRegistry();
        }
        return this.queue.getCLEventRegistry();
    }

    @Override // org.lwjgl.opencl.CLObjectRetainable
    int release() {
        try {
            int iRelease = super.release();
            if (!isValid()) {
                if (this.queue == null) {
                    getParent().getCLEventRegistry().unregisterObject(this);
                } else {
                    this.queue.getCLEventRegistry().unregisterObject(this);
                }
            }
            return iRelease;
        } catch (Throwable th) {
            if (!isValid()) {
                if (this.queue == null) {
                    getParent().getCLEventRegistry().unregisterObject(this);
                } else {
                    this.queue.getCLEventRegistry().unregisterObject(this);
                }
            }
            throw th;
        }
    }
}
