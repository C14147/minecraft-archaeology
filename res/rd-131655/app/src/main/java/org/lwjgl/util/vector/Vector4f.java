package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/Vector4f.class */
public class Vector4f extends Vector implements Serializable, ReadableVector4f, WritableVector4f {
    private static final long serialVersionUID = 1;
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f() {
    }

    public Vector4f(ReadableVector4f src) {
        set(src);
    }

    public Vector4f(float x, float y, float z, float w) {
        set(x, y, z, w);
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

    @Override // org.lwjgl.util.vector.WritableVector4f
    public void set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4f set(ReadableVector4f src) {
        this.x = src.getX();
        this.y = src.getY();
        this.z = src.getZ();
        this.w = src.getW();
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z) + (this.w * this.w);
    }

    public Vector4f translate(float x, float y, float z, float w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w += w;
        return this;
    }

    public static Vector4f add(Vector4f left, Vector4f right, Vector4f dest) {
        if (dest == null) {
            return new Vector4f(left.x + right.x, left.y + right.y, left.z + right.z, left.w + right.w);
        }
        dest.set(left.x + right.x, left.y + right.y, left.z + right.z, left.w + right.w);
        return dest;
    }

    public static Vector4f sub(Vector4f left, Vector4f right, Vector4f dest) {
        if (dest == null) {
            return new Vector4f(left.x - right.x, left.y - right.y, left.z - right.z, left.w - right.w);
        }
        dest.set(left.x - right.x, left.y - right.y, left.z - right.z, left.w - right.w);
        return dest;
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vector4f negate(Vector4f dest) {
        if (dest == null) {
            dest = new Vector4f();
        }
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        dest.w = -this.w;
        return dest;
    }

    public Vector4f normalise(Vector4f dest) {
        float l = length();
        if (dest == null) {
            dest = new Vector4f(this.x / l, this.y / l, this.z / l, this.w / l);
        } else {
            dest.set(this.x / l, this.y / l, this.z / l, this.w / l);
        }
        return dest;
    }

    public static float dot(Vector4f left, Vector4f right) {
        return (left.x * right.x) + (left.y * right.y) + (left.z * right.z) + (left.w * right.w);
    }

    public static float angle(Vector4f a, Vector4f b) {
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
        this.w = buf.get();
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector scale(float scale) {
        this.x *= scale;
        this.y *= scale;
        this.z *= scale;
        this.w *= scale;
        return this;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public Vector store(FloatBuffer buf) {
        buf.put(this.x);
        buf.put(this.y);
        buf.put(this.z);
        buf.put(this.w);
        return this;
    }

    public String toString() {
        return "Vector4f: " + this.x + " " + this.y + " " + this.z + " " + this.w;
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

    @Override // org.lwjgl.util.vector.WritableVector4f
    public void setW(float w) {
        this.w = w;
    }

    @Override // org.lwjgl.util.vector.ReadableVector4f
    public float getW() {
        return this.w;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector4f other = (Vector4f) obj;
        return this.x == other.x && this.y == other.y && this.z == other.z && this.w == other.w;
    }
}
