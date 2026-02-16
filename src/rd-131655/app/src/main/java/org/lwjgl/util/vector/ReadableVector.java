package org.lwjgl.util.vector;

import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/ReadableVector.class */
public interface ReadableVector {
    float length();

    float lengthSquared();

    Vector store(FloatBuffer floatBuffer);
}
