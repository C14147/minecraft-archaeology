package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLMemObjectDestructorCallback.class */
public abstract class CLMemObjectDestructorCallback extends PointerWrapperAbstract {
    protected abstract void handleMessage(long j);

    protected CLMemObjectDestructorCallback() {
        super(CallbackUtil.getMemObjectDestructorCallback());
    }
}
