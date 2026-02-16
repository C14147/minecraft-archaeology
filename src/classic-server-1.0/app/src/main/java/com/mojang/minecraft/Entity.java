package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0024a;
import com.mojang.minecraft.p001a.C0004b;
import com.mojang.minecraft.p002b.InterfaceC0005a;
import com.mojang.minecraft.phys.AABB;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/Entity.class */
public class Entity implements Serializable {
    public static final long serialVersionUID = 0;
    protected Level level;

    /* JADX INFO: renamed from: xo */
    public float f12xo;

    /* JADX INFO: renamed from: yo */
    public float f13yo;

    /* JADX INFO: renamed from: zo */
    public float f14zo;

    /* JADX INFO: renamed from: x */
    public float f15x;

    /* JADX INFO: renamed from: y */
    public float f16y;

    /* JADX INFO: renamed from: z */
    public float f17z;

    /* JADX INFO: renamed from: xd */
    public float f18xd;

    /* JADX INFO: renamed from: yd */
    public float f19yd;

    /* JADX INFO: renamed from: zd */
    public float f20zd;
    public float yRot;
    public float xRot;
    public float yRotO;
    public float xRotO;

    /* JADX INFO: renamed from: bb */
    public AABB f21bb;
    public boolean onGround = false;
    public boolean horizontalCollision = false;
    public boolean removed = false;
    public float heightOffset = 0.0f;
    protected float bbWidth = 0.6f;
    protected float bbHeight = 1.8f;

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
            if (this.level.getCubes(this.f21bb).size() == 0) {
                break;
            }
        }
        this.f20zd = 0.0f;
        this.f19yd = 0.0f;
        this.f18xd = 0.0f;
        this.yRot = this.level.rotSpawn;
        this.xRot = 0.0f;
    }

    public void remove() {
        this.removed = true;
    }

    protected void setSize(float f, float f2) {
        this.bbWidth = f;
        this.bbHeight = f2;
    }

    protected void setPos(C0004b c0004b) {
        setPos(this.f15x, this.f16y, this.f17z);
        setRot(this.yRot, this.xRot);
    }

    protected void setRot(float f, float f2) {
        this.yRot = f;
        this.xRot = f2;
    }

    protected void setPos(float f, float f2, float f3) {
        this.f15x = f;
        this.f16y = f2;
        this.f17z = f3;
        float f4 = this.bbWidth / 2.0f;
        float f5 = this.bbHeight / 2.0f;
        this.f21bb = new AABB(f - f4, f2 - f5, f3 - f4, f + f4, f2 + f5, f3 + f4);
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
        this.f12xo = this.f15x;
        this.f13yo = this.f16y;
        this.f14zo = this.f17z;
        this.xRotO = this.xRot;
        this.yRotO = this.yRot;
    }

    public boolean isFree(float f, float f2, float f3) {
        AABB aabbCloneMove = this.f21bb.cloneMove(f, f2, f3);
        return this.level.getCubes(aabbCloneMove).size() <= 0 && !this.level.containsAnyLiquid(aabbCloneMove);
    }

    public void move(float f, float f2, float f3) {
        ArrayList cubes = this.level.getCubes(this.f21bb.expand(f, f2, f3));
        for (int i = 0; i < cubes.size(); i++) {
            f2 = ((AABB) cubes.get(i)).clipYCollide(this.f21bb, f2);
        }
        this.f21bb.move(0.0f, f2, 0.0f);
        for (int i2 = 0; i2 < cubes.size(); i2++) {
            f = ((AABB) cubes.get(i2)).clipXCollide(this.f21bb, f);
        }
        this.f21bb.move(f, 0.0f, 0.0f);
        for (int i3 = 0; i3 < cubes.size(); i3++) {
            f3 = ((AABB) cubes.get(i3)).clipZCollide(this.f21bb, f3);
        }
        this.f21bb.move(0.0f, 0.0f, f3);
        this.horizontalCollision = (f == f && f3 == f3) ? false : true;
        this.onGround = f2 != f2 && f2 < 0.0f;
        if (f != f) {
            this.f18xd = 0.0f;
        }
        if (f2 != f2) {
            this.f19yd = 0.0f;
        }
        if (f3 != f3) {
            this.f20zd = 0.0f;
        }
        this.f15x = (this.f21bb.f96x0 + this.f21bb.f99x1) / 2.0f;
        this.f16y = this.f21bb.f97y0 + this.heightOffset;
        this.f17z = (this.f21bb.f98z0 + this.f21bb.f101z1) / 2.0f;
    }

    public boolean isInWater() {
        return this.level.containsLiquid(this.f21bb.grow(0.0f, -0.4f, 0.0f), C0024a.f94b);
    }

    public boolean isInLava() {
        return this.level.containsLiquid(this.f21bb.grow(0.0f, -0.4f, 0.0f), C0024a.f95c);
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
        this.f18xd += (f6 * fCos) - (f7 * fSin);
        this.f20zd += (f7 * fCos) + (f6 * fSin);
    }

    public boolean isLit() {
        return this.level.isLit((int) this.f15x, (int) this.f16y, (int) this.f17z);
    }

    public float getBrightness() {
        return this.level.getBrightness((int) this.f15x, (int) (this.f16y + (this.heightOffset / 2.0f)), (int) this.f17z);
    }

    public void render(InterfaceC0005a interfaceC0005a, float f) {
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void moveTo(float f, float f2, float f3, float f4, float f5) {
        this.f15x = f;
        this.f12xo = f;
        this.f16y = f2;
        this.f13yo = f2;
        this.f17z = f3;
        this.f14zo = f3;
        this.yRot = f4;
        this.xRot = f5;
        setPos(f, f2, f3);
    }
}
