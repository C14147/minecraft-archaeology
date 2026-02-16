package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLContextCallback.class */
public abstract class CLContextCallback extends PointerWrapperAbstract {
    private final boolean custom;

    protected abstract void handleMessage(String str, ByteBuffer byteBuffer);

    protected CLContextCallback() {
        super(CallbackUtil.getContextCallback());
        this.custom = false;
    }

    protected CLContextCallback(long pointer) {
        super(pointer);
        if (pointer == 0) {
            throw new RuntimeException("Invalid callback function pointer specified.");
        }
        this.custom = true;
    }

    final boolean isCustom() {
        return this.custom;
    }
}
