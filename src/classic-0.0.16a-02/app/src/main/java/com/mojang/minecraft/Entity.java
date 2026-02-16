package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0045a;
import com.mojang.minecraft.net.C0047b;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.phys.AABB;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/Entity.class */
public class Entity implements Serializable {
    public static final long serialVersionUID = 0;
    protected Level level;

    /* JADX INFO: renamed from: xo */
    public float f8xo;

    /* JADX INFO: renamed from: yo */
    public float f9yo;

    /* JADX INFO: renamed from: zo */
    public float f10zo;

    /* JADX INFO: renamed from: x */
    public float f11x;

    /* JADX INFO: renamed from: y */
    public float f12y;

    /* JADX INFO: renamed from: z */
    public float f13z;

    /* JADX INFO: renamed from: xd */
    public float f14xd;

    /* JADX INFO: renamed from: yd */
    public float f15yd;

    /* JADX INFO: renamed from: zd */
    public float f16zd;
    public float yRot;
    public float xRot;
    public float yRotO;
    public float xRotO;

    /* JADX INFO: renamed from: bb */
    public AABB f17bb;
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
        if (this.level == null) {
            return;
        }
        float f = this.level.xSpawn + 0.5f;
        float f2 = this.level.zSpawn + 0.5f;
        for (float f3 = this.level.ySpawn; f3 > 0.0f; f3 += 1.0f) {
            setPos(f, f3, f2);
            if (this.level.getCubes(this.f17bb).size() == 0) {
                break;
            }
        }
        this.f16zd = 0.0f;
        this.f15yd = 0.0f;
        this.f14xd = 0.0f;
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

    public void setPos(C0047b c0047b) {
        if (c0047b.f280g) {
            setPos(c0047b.f274a, c0047b.f275b, c0047b.f276c);
        } else {
            setPos(this.f11x, this.f12y, this.f13z);
        }
        if (c0047b.f279f) {
            setRot(c0047b.f277d, c0047b.f278e);
        } else {
            setRot(this.yRot, this.xRot);
        }
    }

    protected void setRot(float f, float f2) {
        this.yRot = f;
        this.xRot = f2;
    }

    public void setPos(float f, float f2, float f3) {
        this.f11x = f;
        this.f12y = f2;
        this.f13z = f3;
        float f4 = this.bbWidth / 2.0f;
        float f5 = this.bbHeight / 2.0f;
        this.f17bb = new AABB(f - f4, f2 - f5, f3 - f4, f + f4, f2 + f5, f3 + f4);
    }

    public void turn(float f, float f2) {
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
        this.xRotO += this.xRot - f3;
        this.yRotO += this.yRot - f4;
    }

    public void interpolateTurn(float f, float f2) {
        this.yRot = (float) (((double) this.yRot) + (((double) f) * 0.15d));
        this.xRot = (float) (((double) this.xRot) - (((double) f2) * 0.15d));
        if (this.xRot < -90.0f) {
            this.xRot = -90.0f;
        }
        if (this.xRot > 90.0f) {
            this.xRot = 90.0f;
        }
    }

    public void tick() {
        this.f8xo = this.f11x;
        this.f9yo = this.f12y;
        this.f10zo = this.f13z;
        this.xRotO = this.xRot;
        this.yRotO = this.yRot;
    }

    public boolean isFree(float f, float f2, float f3) {
        AABB aabbCloneMove = this.f17bb.cloneMove(f, f2, f3);
        return this.level.getCubes(aabbCloneMove).size() <= 0 && !this.level.containsAnyLiquid(aabbCloneMove);
    }

    public void move(float f, float f2, float f3) {
        ArrayList cubes = this.level.getCubes(this.f17bb.expand(f, f2, f3));
        for (int i = 0; i < cubes.size(); i++) {
            f2 = ((AABB) cubes.get(i)).clipYCollide(this.f17bb, f2);
        }
        this.f17bb.move(0.0f, f2, 0.0f);
        for (int i2 = 0; i2 < cubes.size(); i2++) {
            f = ((AABB) cubes.get(i2)).clipXCollide(this.f17bb, f);
        }
        this.f17bb.move(f, 0.0f, 0.0f);
        for (int i3 = 0; i3 < cubes.size(); i3++) {
            f3 = ((AABB) cubes.get(i3)).clipZCollide(this.f17bb, f3);
        }
        this.f17bb.move(0.0f, 0.0f, f3);
        this.horizontalCollision = (f == f && f3 == f3) ? false : true;
        this.onGround = f2 != f2 && f2 < 0.0f;
        if (f != f) {
            this.f14xd = 0.0f;
        }
        if (f2 != f2) {
            this.f15yd = 0.0f;
        }
        if (f3 != f3) {
            this.f16zd = 0.0f;
        }
        this.f11x = (this.f17bb.f292x0 + this.f17bb.f295x1) / 2.0f;
        this.f12y = this.f17bb.f293y0 + this.heightOffset;
        this.f13z = (this.f17bb.f294z0 + this.f17bb.f297z1) / 2.0f;
    }

    public boolean isInWater() {
        return this.level.containsLiquid(this.f17bb.grow(0.0f, -0.4f, 0.0f), C0045a.f249b);
    }

    public boolean isInLava() {
        return this.level.containsLiquid(this.f17bb.grow(0.0f, -0.4f, 0.0f), C0045a.f250c);
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
        this.f14xd += (f6 * fCos) - (f7 * fSin);
        this.f16zd += (f7 * fCos) + (f6 * fSin);
    }

    public boolean isLit() {
        return this.level.isLit((int) this.f11x, (int) this.f12y, (int) this.f13z);
    }

    public float getBrightness() {
        return this.level.getBrightness((int) this.f11x, (int) (this.f12y + (this.heightOffset / 2.0f)), (int) this.f13z);
    }

    public void render(C0003a c0003a, float f) {
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void moveTo(float f, float f2, float f3, float f4, float f5) {
        this.f11x = f;
        this.f8xo = f;
        this.f12y = f2;
        this.f9yo = f2;
        this.f13z = f3;
        this.f10zo = f3;
        this.xRot = f4;
        this.yRot = f5;
        setPos(f, f2, f3);
    }
}
