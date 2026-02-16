package com.mojang.minecraft.phys;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/phys/AABB.class */
public class AABB {
    private float epsilon = 0.0f;

    /* JADX INFO: renamed from: x0 */
    public float f53x0;

    /* JADX INFO: renamed from: y0 */
    public float f54y0;

    /* JADX INFO: renamed from: z0 */
    public float f55z0;

    /* JADX INFO: renamed from: x1 */
    public float f56x1;

    /* JADX INFO: renamed from: y1 */
    public float f57y1;

    /* JADX INFO: renamed from: z1 */
    public float f58z1;

    public AABB(float x0, float y0, float z0, float x1, float y1, float z1) {
        this.f53x0 = x0;
        this.f54y0 = y0;
        this.f55z0 = z0;
        this.f56x1 = x1;
        this.f57y1 = y1;
        this.f58z1 = z1;
    }

    public AABB expand(float xa, float ya, float za) {
        float _x0 = this.f53x0;
        float _y0 = this.f54y0;
        float _z0 = this.f55z0;
        float _x1 = this.f56x1;
        float _y1 = this.f57y1;
        float _z1 = this.f58z1;
        if (xa < 0.0f) {
            _x0 += xa;
        }
        if (xa > 0.0f) {
            _x1 += xa;
        }
        if (ya < 0.0f) {
            _y0 += ya;
        }
        if (ya > 0.0f) {
            _y1 += ya;
        }
        if (za < 0.0f) {
            _z0 += za;
        }
        if (za > 0.0f) {
            _z1 += za;
        }
        return new AABB(_x0, _y0, _z0, _x1, _y1, _z1);
    }

    public AABB grow(float xa, float ya, float za) {
        float _x0 = this.f53x0 - xa;
        float _y0 = this.f54y0 - ya;
        float _z0 = this.f55z0 - za;
        float _x1 = this.f56x1 + xa;
        float _y1 = this.f57y1 + ya;
        float _z1 = this.f58z1 + za;
        return new AABB(_x0, _y0, _z0, _x1, _y1, _z1);
    }

    public AABB cloneMove(float xa, float ya, float za) {
        return new AABB(this.f53x0 + za, this.f54y0 + ya, this.f55z0 + za, this.f56x1 + xa, this.f57y1 + ya, this.f58z1 + za);
    }

    public float clipXCollide(AABB c, float xa) {
        if (c.f57y1 <= this.f54y0 || c.f54y0 >= this.f57y1) {
            return xa;
        }
        if (c.f58z1 <= this.f55z0 || c.f55z0 >= this.f58z1) {
            return xa;
        }
        if (xa > 0.0f && c.f56x1 <= this.f53x0) {
            float max = (this.f53x0 - c.f56x1) - this.epsilon;
            if (max < xa) {
                xa = max;
            }
        }
        if (xa < 0.0f && c.f53x0 >= this.f56x1) {
            float max2 = (this.f56x1 - c.f53x0) + this.epsilon;
            if (max2 > xa) {
                xa = max2;
            }
        }
        return xa;
    }

    public float clipYCollide(AABB c, float ya) {
        if (c.f56x1 <= this.f53x0 || c.f53x0 >= this.f56x1) {
            return ya;
        }
        if (c.f58z1 <= this.f55z0 || c.f55z0 >= this.f58z1) {
            return ya;
        }
        if (ya > 0.0f && c.f57y1 <= this.f54y0) {
            float max = (this.f54y0 - c.f57y1) - this.epsilon;
            if (max < ya) {
                ya = max;
            }
        }
        if (ya < 0.0f && c.f54y0 >= this.f57y1) {
            float max2 = (this.f57y1 - c.f54y0) + this.epsilon;
            if (max2 > ya) {
                ya = max2;
            }
        }
        return ya;
    }

    public float clipZCollide(AABB c, float za) {
        if (c.f56x1 <= this.f53x0 || c.f53x0 >= this.f56x1) {
            return za;
        }
        if (c.f57y1 <= this.f54y0 || c.f54y0 >= this.f57y1) {
            return za;
        }
        if (za > 0.0f && c.f58z1 <= this.f55z0) {
            float max = (this.f55z0 - c.f58z1) - this.epsilon;
            if (max < za) {
                za = max;
            }
        }
        if (za < 0.0f && c.f55z0 >= this.f58z1) {
            float max2 = (this.f58z1 - c.f55z0) + this.epsilon;
            if (max2 > za) {
                za = max2;
            }
        }
        return za;
    }

    public boolean intersects(AABB c) {
        return c.f56x1 > this.f53x0 && c.f53x0 < this.f56x1 && c.f57y1 > this.f54y0 && c.f54y0 < this.f57y1 && c.f58z1 > this.f55z0 && c.f55z0 < this.f58z1;
    }

    public void move(float xa, float ya, float za) {
        this.f53x0 += xa;
        this.f54y0 += ya;
        this.f55z0 += za;
        this.f56x1 += xa;
        this.f57y1 += ya;
        this.f58z1 += za;
    }
}
