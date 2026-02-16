package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0002a;
import com.mojang.minecraft.phys.AABB;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/Entity.class */
public class Entity implements Serializable {
    public static final long serialVersionUID = 0;
    protected Level level;

    /* JADX INFO: renamed from: xo */
    public float f0xo;

    /* JADX INFO: renamed from: yo */
    public float f1yo;

    /* JADX INFO: renamed from: zo */
    public float f2zo;

    /* JADX INFO: renamed from: x */
    public float f3x;

    /* JADX INFO: renamed from: y */
    public float f4y;

    /* JADX INFO: renamed from: z */
    public float f5z;

    /* JADX INFO: renamed from: xd */
    public float f6xd;

    /* JADX INFO: renamed from: yd */
    public float f7yd;

    /* JADX INFO: renamed from: zd */
    public float f8zd;
    public float yRot;
    public float xRot;
    public float yRotI;
    public float xRotI;

    /* JADX INFO: renamed from: bb */
    public AABB f9bb;
    public boolean onGround = false;
    public boolean horizontalCollision = false;
    public boolean removed = false;
    public float heightOffset = 0.0f;
    protected float bbWidth = 0.6f;
    public float bbHeight = 1.8f;

    public Entity(Level level) {
        this.level = level;
        setPos(0.0f, 0.0f, 0.0f);
    }

    protected void resetPos() {
        float f = this.level.xSpawn + 0.5f;
        float f2 = this.level.zSpawn + 0.5f;
        for (float f3 = this.level.ySpawn; f3 > 0.0f; f3 += 1.0f) {
            setPos(f, f3, f2);
            if (this.level.getCubes(this.f9bb).size() == 0) {
                break;
            }
        }
        this.f8zd = 0.0f;
        this.f7yd = 0.0f;
        this.f6xd = 0.0f;
        this.yRot = this.level.rotSpawn;
        this.xRot = 0.0f;
    }

    public void remove() {
        this.removed = true;
    }

    public void setSize(float f, float f2) {
        this.bbWidth = f;
        this.bbHeight = f2;
    }

    public void setPos(float f, float f2, float f3) {
        this.f3x = f;
        this.f4y = f2;
        this.f5z = f3;
        float f4 = this.bbWidth / 2.0f;
        float f5 = this.bbHeight / 2.0f;
        this.f9bb = new AABB(f - f4, f2 - f5, f3 - f4, f + f4, f2 + f5, f3 + f4);
    }

    public void turn(float f, float f2) {
        this.yRot = (float) (((double) this.yRot) + (((double) f) * 0.15d));
        this.xRot = (float) (((double) this.xRot) - (((double) f2) * 0.15d));
        if (this.xRot < -90.0f) {
            this.xRot = -90.0f;
        }
        if (this.xRot > 90.0f) {
            this.xRot = 90.0f;
        }
    }

    public void interpolateTurn(float f, float f2) {
        float f3 = this.xRot;
        float f4 = this.yRot;
        this.yRot = (float) (((double) this.yRot) + (((double) f) * 0.15d));
        this.xRot = (float) (((double) this.xRot) - (((double) f2) * 0.15d));
        if (this.xRot < -90.0f) {
            this.xRot = -90.0f;
        }
        if (this.xRot > 90.0f) {
            this.xRot = 90.0f;
        }
        this.xRotI = this.xRot - f3;
        this.yRotI = this.yRot - f4;
    }

    public void tick() {
        this.f0xo = this.f3x;
        this.f1yo = this.f4y;
        this.f2zo = this.f5z;
        this.xRotI = 0.0f;
        this.yRotI = 0.0f;
    }

    public boolean isFree(float f, float f2, float f3) {
        AABB aabbCloneMove = this.f9bb.cloneMove(f, f2, f3);
        return this.level.getCubes(aabbCloneMove).size() <= 0 && !this.level.containsAnyLiquid(aabbCloneMove);
    }

    public void move(float f, float f2, float f3) {
        ArrayList cubes = this.level.getCubes(this.f9bb.expand(f, f2, f3));
        for (int i = 0; i < cubes.size(); i++) {
            f2 = ((AABB) cubes.get(i)).clipYCollide(this.f9bb, f2);
        }
        this.f9bb.move(0.0f, f2, 0.0f);
        for (int i2 = 0; i2 < cubes.size(); i2++) {
            f = ((AABB) cubes.get(i2)).clipXCollide(this.f9bb, f);
        }
        this.f9bb.move(f, 0.0f, 0.0f);
        for (int i3 = 0; i3 < cubes.size(); i3++) {
            f3 = ((AABB) cubes.get(i3)).clipZCollide(this.f9bb, f3);
        }
        this.f9bb.move(0.0f, 0.0f, f3);
        this.horizontalCollision = (f == f && f3 == f3) ? false : true;
        this.onGround = f2 != f2 && f2 < 0.0f;
        if (f != f) {
            this.f6xd = 0.0f;
        }
        if (f2 != f2) {
            this.f7yd = 0.0f;
        }
        if (f3 != f3) {
            this.f8zd = 0.0f;
        }
        this.f3x = (this.f9bb.f231x0 + this.f9bb.f234x1) / 2.0f;
        this.f4y = this.f9bb.f232y0 + this.heightOffset;
        this.f5z = (this.f9bb.f233z0 + this.f9bb.f236z1) / 2.0f;
    }

    public boolean isInWater() {
        return this.level.containsLiquid(this.f9bb.grow(0.0f, -0.4f, 0.0f), 1);
    }

    public boolean isInLava() {
        return this.level.containsLiquid(this.f9bb, 2);
    }

    public void moveRelative(float f, float f2, float f3) {
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float f4 = fSqrt;
        if (fSqrt < 0.01f) {
            return;
        }
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        float f5 = f3 / f4;
        float f6 = f * f5;
        float f7 = f2 * f5;
        float fSin = (float) Math.sin((((double) this.yRot) * 3.141592653589793d) / 180.0d);
        float fCos = (float) Math.cos((((double) this.yRot) * 3.141592653589793d) / 180.0d);
        this.f6xd += (f6 * fCos) - (f7 * fSin);
        this.f8zd += (f7 * fCos) + (f6 * fSin);
    }

    public boolean isLit() {
        return this.level.isLit((int) this.f3x, (int) this.f4y, (int) this.f5z);
    }

    public float getBrightness() {
        return this.level.getBrightness((int) this.f3x, (int) (this.f4y + (this.heightOffset / 2.0f)), (int) this.f5z);
    }

    public void render(C0002a c0002a, float f) {
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
