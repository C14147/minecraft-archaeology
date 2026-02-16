package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLObject.class */
abstract class CLObject extends PointerWrapperAbstract {
    protected CLObject(long pointer) {
        super(pointer);
    }

    final long getPointerUnsafe() {
        return this.pointer;
    }
}
