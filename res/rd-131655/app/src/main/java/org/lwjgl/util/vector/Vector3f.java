package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/Vector3f.class */
public class Vector3f extends Vector implements Serializable, ReadableVector3f, WritableVector3f {
    private static final long serialVersionUID = 1;
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public Vector3f(ReadableVector3f src) {
        set(src);
    }

    public Vector3f(float x, float y, float z) {
        set(x, y, z);
    }

    @Override // org.lwjgl.util.vector.WritableVector2f
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override // org.lwjgl.util.vector.WritableVector3f
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f set(ReadableVector3f src) {
        this.x = src.getX();
        this.y = src.getY();
        this.z = src.getZ();
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }

    public Vector3f translate(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public static Vector3f add(Vector3f left, Vector3f right, Vector3f dest) {
        if (dest == null) {
            return new Vector3f(left.x + right.x, left.y + right.y, left.z + right.z);
        }
        dest.set(left.x + right.x, left.y + right.y, left.z + right.z);
        return dest;
    }

    public static Vector3f sub(Vector3f left, Vector3f right, Vector3f dest) {
        if (dest == null) {
            return new Vector3f(left.x - right.x, left.y - right.y, left.z - right.z);
        }
        dest.set(left.x - right.x, left.y - right.y, left.z - right.z);
        return dest;
    }

    public static Vector3f cross(Vector3f left, Vector3f right, Vector3f dest) {
        if (dest == null) {
            dest = new Vector3f();
        }
        dest.set((left.y * right.z) - (left.z * right.y), (right.x * left.z) - (right.z * left.x), (left.x * right.y) - (left.y * right.x));
        return dest;
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3f negate(Vector3f dest) {
        if (dest == null) {
            dest = new Vector3f();
        }
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        return dest;
    }

    public Vector3f normalise(Vector3f dest) {
        float l = length();
        if (dest == null) {
            dest = new Vector3f(this.x / l, this.y / l, this.z / l);
        } else {
            dest.set(this.x / l, this.y / l, this.z / l);
        }
        return dest;
    }

    public static float dot(Vector3f left, Vector3f right) {
        return (left.x * right.x) + (left.y * right.y) + (left.z * right.z);
    }

    public static float angle(Vector3f a, Vector3f b) {
        float dls = dot(a, b) / (a.length() * b.length());
        if (dls < -1.0f) {
            dls = -1.0f;
        } else if (dls > 1.0f) {
            dls = 1.0f;
        }
        return (float) Math.acos(dls);
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector load(FloatBuffer buf) {
        this.x = buf.get();
        this.y = buf.get();
        this.z = buf.get();
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector scale(float scale) {
        this.x *= scale;
        this.y *= scale;
        this.z *= scale;
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public Vector store(FloatBuffer buf) {
        buf.put(this.x);
        buf.put(this.y);
        buf.put(this.z);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Vector3f[");
        sb.append(this.x);
        sb.append(", ");
        sb.append(this.y);
        sb.append(", ");
        sb.append(this.z);
        sb.append(']');
        return sb.toString();
    }

    @Override // org.lwjgl.util.vector.ReadableVector2f
    public final float getX() {
        return this.x;
    }

    @Override // org.lwjgl.util.vector.ReadableVector2f
    public final float getY() {
        return this.y;
    }

    @Override // org.lwjgl.util.vector.WritableVector2f
    public final void setX(float x) {
        this.x = x;
    }

    @Override // org.lwjgl.util.vector.WritableVector2f
    public final void setY(float y) {
        this.y = y;
    }

    @Override // org.lwjgl.util.vector.WritableVector3f
    public void setZ(float z) {
        this.z = z;
    }

    @Override // org.lwjgl.util.vector.ReadableVector3f
    public float getZ() {
        return this.z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector3f other = (Vector3f) obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }
}
