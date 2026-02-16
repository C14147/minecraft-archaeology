package org.lwjgl.opencl;

import org.lwjgl.PointerBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLCommandQueue.class */
public final class CLCommandQueue extends CLObjectChild<CLContext> {
    private static final InfoUtil<CLCommandQueue> util = CLPlatform.getInfoUtilInstance(CLCommandQueue.class, "CL_COMMAND_QUEUE_UTIL");
    private final CLDevice device;
    private final CLObjectRegistry<CLEvent> clEvents;

    CLCommandQueue(long pointer, CLContext context, CLDevice device) {
        super(pointer, context);
        if (isValid()) {
            this.device = device;
            this.clEvents = new CLObjectRegistry<>();
            context.getCLCommandQueueRegistry().registerObject(this);
        } else {
            this.device = null;
            this.clEvents = null;
        }
    }

    public CLDevice getCLDevice() {
        return this.device;
    }

    public CLEvent getCLEvent(long id) {
        return (CLEvent) this.clEvents.getObject(id);
    }

    public int getInfoInt(int param_name) {
        return util.getInfoInt(this, param_name);
    }

    CLObjectRegistry<CLEvent> getCLEventRegistry() {
        return this.clEvents;
    }

    void registerCLEvent(PointerBuffer event) {
        if (event != null) {
            new CLEvent(event.get(event.position()), this);
        }
    }

    @Override // org.lwjgl.opencl.CLObjectRetainable
    int release() {
        try {
            int iRelease = super.release();
            if (!isValid()) {
                getParent().getCLCommandQueueRegistry().unregisterObject(this);
            }
            return iRelease;
        } catch (Throwable th) {
            if (!isValid()) {
                getParent().getCLCommandQueueRegistry().unregisterObject(this);
            }
            throw th;
        }
    }
}
