package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/Vector.class */
public abstract class Vector implements Serializable, ReadableVector {
    public abstract float lengthSquared();

    public abstract Vector load(FloatBuffer floatBuffer);

    public abstract Vector negate();

    public abstract Vector store(FloatBuffer floatBuffer);

    public abstract Vector scale(float f);

    protected Vector() {
    }

    @Override // org.lwjgl.util.vector.ReadableVector
    public final float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public final Vector normalise() {
        float len = length();
        if (len != 0.0f) {
            float l = 1.0f / len;
            return scale(l);
        }
        throw new IllegalStateException("Zero length vector");
    }
}
