package com.mojang.minecraft.phys;

import java.io.Serializable;

/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/phys/AABB.class */
public class AABB implements Serializable {
    public static final long serialVersionUID = 0;
    private float epsilon = 0.0f;

    /* JADX INFO: renamed from: x0 */
    public float f91x0;

    /* JADX INFO: renamed from: y0 */
    public float f92y0;

    /* JADX INFO: renamed from: z0 */
    public float f93z0;

    /* JADX INFO: renamed from: x1 */
    public float f94x1;

    /* JADX INFO: renamed from: y1 */
    public float f95y1;

    /* JADX INFO: renamed from: z1 */
    public float f96z1;

    public AABB(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f91x0 = f;
        this.f92y0 = f2;
        this.f93z0 = f3;
        this.f94x1 = f4;
        this.f95y1 = f5;
        this.f96z1 = f6;
    }

    public AABB expand(float f, float f2, float f3) {
        float f4 = this.f91x0;
        float f5 = this.f92y0;
        float f6 = this.f93z0;
        float f7 = this.f94x1;
        float f8 = this.f95y1;
        float f9 = this.f96z1;
        if (f < 0.0f) {
            f4 += f;
        }
        if (f > 0.0f) {
            f7 += f;
        }
        if (f2 < 0.0f) {
            f5 += f2;
        }
        if (f2 > 0.0f) {
            f8 += f2;
        }
        if (f3 < 0.0f) {
            f6 += f3;
        }
        if (f3 > 0.0f) {
            f9 += f3;
        }
        return new AABB(f4, f5, f6, f7, f8, f9);
    }

    public AABB grow(float f, float f2, float f3) {
        return new AABB(this.f91x0 - f, this.f92y0 - f2, this.f93z0 - f3, this.f94x1 + f, this.f95y1 + f2, this.f96z1 + f3);
    }

    public AABB cloneMove(float f, float f2, float f3) {
        return new AABB(this.f91x0 + f3, this.f92y0 + f2, this.f93z0 + f3, this.f94x1 + f, this.f95y1 + f2, this.f96z1 + f3);
    }

    public float clipXCollide(AABB aabb, float f) {
        if (aabb.f95y1 <= this.f92y0 || aabb.f92y0 >= this.f95y1) {
            return f;
        }
        if (aabb.f96z1 <= this.f93z0 || aabb.f93z0 >= this.f96z1) {
            return f;
        }
        if (f > 0.0f && aabb.f94x1 <= this.f91x0) {
            float f2 = (this.f91x0 - aabb.f94x1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f91x0 >= this.f94x1) {
            float f3 = (this.f94x1 - aabb.f91x0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public float clipYCollide(AABB aabb, float f) {
        if (aabb.f94x1 <= this.f91x0 || aabb.f91x0 >= this.f94x1) {
            return f;
        }
        if (aabb.f96z1 <= this.f93z0 || aabb.f93z0 >= this.f96z1) {
            return f;
        }
        if (f > 0.0f && aabb.f95y1 <= this.f92y0) {
            float f2 = (this.f92y0 - aabb.f95y1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f92y0 >= this.f95y1) {
            float f3 = (this.f95y1 - aabb.f92y0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public float clipZCollide(AABB aabb, float f) {
        if (aabb.f94x1 <= this.f91x0 || aabb.f91x0 >= this.f94x1) {
            return f;
        }
        if (aabb.f95y1 <= this.f92y0 || aabb.f92y0 >= this.f95y1) {
            return f;
        }
        if (f > 0.0f && aabb.f96z1 <= this.f93z0) {
            float f2 = (this.f93z0 - aabb.f96z1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f93z0 >= this.f96z1) {
            float f3 = (this.f96z1 - aabb.f93z0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public boolean intersects(AABB aabb) {
        return aabb.f94x1 > this.f91x0 && aabb.f91x0 < this.f94x1 && aabb.f95y1 > this.f92y0 && aabb.f92y0 < this.f95y1 && aabb.f96z1 > this.f93z0 && aabb.f93z0 < this.f96z1;
    }

    public void move(float f, float f2, float f3) {
        this.f91x0 += f;
        this.f92y0 += f2;
        this.f93z0 += f3;
        this.f94x1 += f;
        this.f95y1 += f2;
        this.f96z1 += f3;
    }
}
