package org.lwjgl.opencl;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLObjectRetainable.class */
abstract class CLObjectRetainable extends CLObject {
    private int refCount;

    protected CLObjectRetainable(long pointer) {
        super(pointer);
        if (super.isValid()) {
            this.refCount = 1;
        }
    }

    public final int getReferenceCount() {
        return this.refCount;
    }

    @Override // org.lwjgl.PointerWrapperAbstract
    public final boolean isValid() {
        return this.refCount > 0;
    }

    int retain() {
        checkValid();
        int i = this.refCount + 1;
        this.refCount = i;
        return i;
    }

    int release() {
        checkValid();
        int i = this.refCount - 1;
        this.refCount = i;
        return i;
    }
}
