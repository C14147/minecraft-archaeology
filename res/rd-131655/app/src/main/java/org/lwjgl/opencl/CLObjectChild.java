package org.lwjgl.opencl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opencl.CLObject;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opencl/CLObjectChild.class */
abstract class CLObjectChild<P extends CLObject> extends CLObjectRetainable {
    private final P parent;

    protected CLObjectChild(long pointer, P parent) {
        super(pointer);
        if (LWJGLUtil.DEBUG && parent != null && !parent.isValid()) {
            throw new IllegalStateException("The parent specified is not a valid CL object.");
        }
        this.parent = parent;
    }

    public P getParent() {
        return this.parent;
    }
}
