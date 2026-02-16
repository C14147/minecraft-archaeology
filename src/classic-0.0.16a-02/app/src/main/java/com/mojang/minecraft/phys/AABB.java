package com.mojang.minecraft.phys;

import java.io.Serializable;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/phys/AABB.class */
public class AABB implements Serializable {
    public static final long serialVersionUID = 0;
    private float epsilon = 0.0f;

    /* JADX INFO: renamed from: x0 */
    public float f292x0;

    /* JADX INFO: renamed from: y0 */
    public float f293y0;

    /* JADX INFO: renamed from: z0 */
    public float f294z0;

    /* JADX INFO: renamed from: x1 */
    public float f295x1;

    /* JADX INFO: renamed from: y1 */
    public float f296y1;

    /* JADX INFO: renamed from: z1 */
    public float f297z1;

    public AABB(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f292x0 = f;
        this.f293y0 = f2;
        this.f294z0 = f3;
        this.f295x1 = f4;
        this.f296y1 = f5;
        this.f297z1 = f6;
    }

    public AABB expand(float f, float f2, float f3) {
        float f4 = this.f292x0;
        float f5 = this.f293y0;
        float f6 = this.f294z0;
        float f7 = this.f295x1;
        float f8 = this.f296y1;
        float f9 = this.f297z1;
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
        return new AABB(this.f292x0 - f, this.f293y0 - f2, this.f294z0 - f3, this.f295x1 + f, this.f296y1 + f2, this.f297z1 + f3);
    }

    public AABB cloneMove(float f, float f2, float f3) {
        return new AABB(this.f292x0 + f3, this.f293y0 + f2, this.f294z0 + f3, this.f295x1 + f, this.f296y1 + f2, this.f297z1 + f3);
    }

    public float clipXCollide(AABB aabb, float f) {
        if (aabb.f296y1 <= this.f293y0 || aabb.f293y0 >= this.f296y1) {
            return f;
        }
        if (aabb.f297z1 <= this.f294z0 || aabb.f294z0 >= this.f297z1) {
            return f;
        }
        if (f > 0.0f && aabb.f295x1 <= this.f292x0) {
            float f2 = (this.f292x0 - aabb.f295x1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f292x0 >= this.f295x1) {
            float f3 = (this.f295x1 - aabb.f292x0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public float clipYCollide(AABB aabb, float f) {
        if (aabb.f295x1 <= this.f292x0 || aabb.f292x0 >= this.f295x1) {
            return f;
        }
        if (aabb.f297z1 <= this.f294z0 || aabb.f294z0 >= this.f297z1) {
            return f;
        }
        if (f > 0.0f && aabb.f296y1 <= this.f293y0) {
            float f2 = (this.f293y0 - aabb.f296y1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f293y0 >= this.f296y1) {
            float f3 = (this.f296y1 - aabb.f293y0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public float clipZCollide(AABB aabb, float f) {
        if (aabb.f295x1 <= this.f292x0 || aabb.f292x0 >= this.f295x1) {
            return f;
        }
        if (aabb.f296y1 <= this.f293y0 || aabb.f293y0 >= this.f296y1) {
            return f;
        }
        if (f > 0.0f && aabb.f297z1 <= this.f294z0) {
            float f2 = (this.f294z0 - aabb.f297z1) - this.epsilon;
            if (f2 < f) {
                f = f2;
            }
        }
        if (f < 0.0f && aabb.f294z0 >= this.f297z1) {
            float f3 = (this.f297z1 - aabb.f294z0) + this.epsilon;
            if (f3 > f) {
                f = f3;
            }
        }
        return f;
    }

    public boolean intersects(AABB aabb) {
        return aabb.f295x1 > this.f292x0 && aabb.f292x0 < this.f295x1 && aabb.f296y1 > this.f293y0 && aabb.f293y0 < this.f296y1 && aabb.f297z1 > this.f294z0 && aabb.f294z0 < this.f297z1;
    }

    public void move(float f, float f2, float f3) {
        this.f292x0 += f;
        this.f293y0 += f2;
        this.f294z0 += f3;
        this.f295x1 += f;
        this.f296y1 += f2;
        this.f297z1 += f3;
    }
}
