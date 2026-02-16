package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLPrintfCallback.class */
public abstract class CLPrintfCallback extends PointerWrapperAbstract {
    protected abstract void handleMessage(String str);

    protected CLPrintfCallback() {
        super(CallbackUtil.getPrintfCallback());
    }
}
