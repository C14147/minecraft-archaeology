package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/openal/ALCcontext.class */
public final class ALCcontext {
    final long context;
    private boolean valid = true;

    ALCcontext(long context) {
        this.context = context;
    }

    public boolean equals(Object context) {
        if (context instanceof ALCcontext) {
            return ((ALCcontext) context).context == this.context;
        }
        return super.equals(context);
    }

    static IntBuffer createAttributeList(int contextFrequency, int contextRefresh, int contextSynchronized) {
        IntBuffer attribList = BufferUtils.createIntBuffer(7);
        attribList.put(4103);
        attribList.put(contextFrequency);
        attribList.put(4104);
        attribList.put(contextRefresh);
        attribList.put(4105);
        attribList.put(contextSynchronized);
        attribList.put(0);
        return attribList;
    }

    void setInvalid() {
        this.valid = false;
    }

    public boolean isValid() {
        return this.valid;
    }
}
