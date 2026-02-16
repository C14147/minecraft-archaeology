package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/Matrix.class */
public abstract class Matrix implements Serializable {
    public abstract Matrix setIdentity();

    public abstract Matrix invert();

    public abstract Matrix load(FloatBuffer floatBuffer);

    public abstract Matrix loadTranspose(FloatBuffer floatBuffer);

    public abstract Matrix negate();

    public abstract Matrix store(FloatBuffer floatBuffer);

    public abstract Matrix storeTranspose(FloatBuffer floatBuffer);

    public abstract Matrix transpose();

    public abstract Matrix setZero();

    public abstract float determinant();

    protected Matrix() {
    }
}
