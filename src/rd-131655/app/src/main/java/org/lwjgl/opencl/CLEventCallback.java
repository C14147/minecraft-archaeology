package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLEventCallback.class */
public abstract class CLEventCallback extends PointerWrapperAbstract {
    private CLObjectRegistry<CLEvent> eventRegistry;

    protected abstract void handleMessage(CLEvent cLEvent, int i);

    protected CLEventCallback() {
        super(CallbackUtil.getEventCallback());
    }

    void setRegistry(CLObjectRegistry<CLEvent> eventRegistry) {
        this.eventRegistry = eventRegistry;
    }

    private void handleMessage(long event_address, int event_command_exec_status) {
        handleMessage((CLEvent) this.eventRegistry.getObject(event_address), event_command_exec_status);
    }
}
