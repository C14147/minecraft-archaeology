package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLNativeKernel.class */
public abstract class CLNativeKernel extends PointerWrapperAbstract {
    protected abstract void execute(ByteBuffer[] byteBufferArr);

    protected CLNativeKernel() {
        super(CallbackUtil.getNativeKernelCallback());
    }
}
