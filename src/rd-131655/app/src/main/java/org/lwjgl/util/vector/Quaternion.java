package org.lwjgl.util.vector;

import java.nio.FloatBuffer;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/vector/Quaternion.class */
public class Quaternion extends Vector implements ReadableVector4f {
    private static final long serialVersionUID = 1;
    public float x;
    public float y;
    public float z;
    public float w;

    public Quaternion() {
        setIdentity();
    }

    public Quaternion(ReadableVector4f src) {
        set(src);
    }

    public Quaternion(float x, float y, float z, float w) {
        set(x, y, z, w);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion set(ReadableVector4f src) {
        this.x = src.getX();
        this.y = src.getY();
        this.z = src.getZ();
        this.w = src.getW();
        return this;
    }

    public Quaternion setIdentity() {
        return setIdentity(this);
    }

    public static Quaternion setIdentity(Quaternion q) {
        q.x = 0.0f;
        q.y = 0.0f;
        q.z = 0.0f;
        q.w = 1.0f;
        return q;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z) + (this.w * this.w);
    }

    public static Quaternion normalise(Quaternion src, Quaternion dest) {
        float inv_l = 1.0f / src.length();
        if (dest == null) {
            dest = new Quaternion();
        }
        dest.set(src.x * inv_l, src.y * inv_l, src.z * inv_l, src.w * inv_l);
        return dest;
    }

    public Quaternion normalise(Quaternion dest) {
        return normalise(this, dest);
    }

    public static float dot(Quaternion left, Quaternion right) {
        return (left.x * right.x) + (left.y * right.y) + (left.z * right.z) + (left.w * right.w);
    }

    public Quaternion negate(Quaternion dest) {
        return negate(this, dest);
    }

    public static Quaternion negate(Quaternion src, Quaternion dest) {
        if (dest == null) {
            dest = new Quaternion();
        }
        dest.x = -src.x;
        dest.y = -src.y;
        dest.z = -src.z;
        dest.w = src.w;
        return dest;
    }

    @Override // org.lwjgl.util.vector.Vector
    public Vector negate() {
        return negate(this, this);
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
        return scale(scale, this, this);
    }

    public static Quaternion scale(float scale, Quaternion src, Quaternion dest) {
        if (dest == null) {
            dest = new Quaternion();
        }
        dest.x = src.x * scale;
        dest.y = src.y * scale;
        dest.z = src.z * scale;
        dest.w = src.w * scale;
        return dest;
    }

    @Override // org.lwjgl.util.vector.Vector, org.lwjgl.util.vector.ReadableVector
    public Vector store(FloatBuffer buf) {
        buf.put(this.x);
        buf.put(this.y);
        buf.put(this.z);
        buf.put(this.w);
        return this;
    }

    @Override // org.lwjgl.util.vector.ReadableVector2f
    public final float getX() {
        return this.x;
    }

    @Override // org.lwjgl.util.vector.ReadableVector2f
    public final float getY() {
        return this.y;
    }

    public final void setX(float x) {
        this.x = x;
    }

    public final void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override // org.lwjgl.util.vector.ReadableVector3f
    public float getZ() {
        return this.z;
    }

    public void setW(float w) {
        this.w = w;
    }

    @Override // org.lwjgl.util.vector.ReadableVector4f
    public float getW() {
        return this.w;
    }

    public String toString() {
        return "Quaternion: " + this.x + " " + this.y + " " + this.z + " " + this.w;
    }

    public static Quaternion mul(Quaternion left, Quaternion right, Quaternion dest) {
        if (dest == null) {
            dest = new Quaternion();
        }
        dest.set((((left.x * right.w) + (left.w * right.x)) + (left.y * right.z)) - (left.z * right.y), (((left.y * right.w) + (left.w * right.y)) + (left.z * right.x)) - (left.x * right.z), (((left.z * right.w) + (left.w * right.z)) + (left.x * right.y)) - (left.y * right.x), (((left.w * right.w) - (left.x * right.x)) - (left.y * right.y)) - (left.z * right.z));
        return dest;
    }

    public static Quaternion mulInverse(Quaternion left, Quaternion right, Quaternion dest) {
        float n = right.lengthSquared();
        float n2 = ((double) n) == 0.0d ? n : 1.0f / n;
        if (dest == null) {
            dest = new Quaternion();
        }
        dest.set(((((left.x * right.w) - (left.w * right.x)) - (left.y * right.z)) + (left.z * right.y)) * n2, ((((left.y * right.w) - (left.w * right.y)) - (left.z * right.x)) + (left.x * right.z)) * n2, ((((left.z * right.w) - (left.w * right.z)) - (left.x * right.y)) + (left.y * right.x)) * n2, ((left.w * right.w) + (left.x * right.x) + (left.y * right.y) + (left.z * right.z)) * n2);
        return dest;
    }

    public final void setFromAxisAngle(Vector4f a1) {
        this.x = a1.x;
        this.y = a1.y;
        this.z = a1.z;
        float n = (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
        float s = (float) (Math.sin(0.5d * ((double) a1.w)) / ((double) n));
        this.x *= s;
        this.y *= s;
        this.z *= s;
        this.w = (float) Math.cos(0.5d * ((double) a1.w));
    }

    public final Quaternion setFromMatrix(Matrix4f m) {
        return setFromMatrix(m, this);
    }

    public static Quaternion setFromMatrix(Matrix4f m, Quaternion q) {
        return q.setFromMat(m.m00, m.m01, m.m02, m.m10, m.m11, m.m12, m.m20, m.m21, m.m22);
    }

    public final Quaternion setFromMatrix(Matrix3f m) {
        return setFromMatrix(m, this);
    }

    public static Quaternion setFromMatrix(Matrix3f m, Quaternion q) {
        return q.setFromMat(m.m00, m.m01, m.m02, m.m10, m.m11, m.m12, m.m20, m.m21, m.m22);
    }

    private Quaternion setFromMat(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        float tr = m00 + m11 + m22;
        if (tr >= 0.0d) {
            float s = (float) Math.sqrt(((double) tr) + 1.0d);
            this.w = s * 0.5f;
            float s2 = 0.5f / s;
            this.x = (m21 - m12) * s2;
            this.y = (m02 - m20) * s2;
            this.z = (m10 - m01) * s2;
        } else {
            float max = Math.max(Math.max(m00, m11), m22);
            if (max == m00) {
                float s3 = (float) Math.sqrt(((double) (m00 - (m11 + m22))) + 1.0d);
                this.x = s3 * 0.5f;
                float s4 = 0.5f / s3;
                this.y = (m01 + m10) * s4;
                this.z = (m20 + m02) * s4;
                this.w = (m21 - m12) * s4;
            } else if (max == m11) {
                float s5 = (float) Math.sqrt(((double) (m11 - (m22 + m00))) + 1.0d);
                this.y = s5 * 0.5f;
                float s6 = 0.5f / s5;
                this.z = (m12 + m21) * s6;
                this.x = (m01 + m10) * s6;
                this.w = (m02 - m20) * s6;
            } else {
                float s7 = (float) Math.sqrt(((double) (m22 - (m00 + m11))) + 1.0d);
                this.z = s7 * 0.5f;
                float s8 = 0.5f / s7;
                this.x = (m20 + m02) * s8;
                this.y = (m12 + m21) * s8;
                this.w = (m10 - m01) * s8;
            }
        }
        return this;
    }
}
