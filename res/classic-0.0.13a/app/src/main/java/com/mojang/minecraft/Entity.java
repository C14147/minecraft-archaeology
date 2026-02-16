package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.phys.AABB;
import java.util.List;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/Entity.class */
public class Entity {
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

    /* JADX INFO: renamed from: bb */
    public AABB f9bb;
    public boolean onGround = false;
    public boolean horizontalCollision = false;
    public boolean removed = false;
    protected float heightOffset = 0.0f;
    protected float bbWidth = 0.6f;
    protected float bbHeight = 1.8f;

    public Entity(Level level) {
        this.level = level;
        resetPos();
    }

    protected void resetPos() {
        float x = (((float) Math.random()) * (this.level.width - 2)) + 1.0f;
        float y = this.level.depth + 10;
        float z = (((float) Math.random()) * (this.level.height - 2)) + 1.0f;
        setPos(x, y, z);
    }

    public void remove() {
        this.removed = true;
    }

    protected void setSize(float w, float h) {
        this.bbWidth = w;
        this.bbHeight = h;
    }

    protected void setPos(float x, float y, float z) {
        this.f3x = x;
        this.f4y = y;
        this.f5z = z;
        float w = this.bbWidth / 2.0f;
        float h = this.bbHeight / 2.0f;
        this.f9bb = new AABB(x - w, y - h, z - w, x + w, y + h, z + w);
    }

    public void turn(float xo, float yo) {
        this.yRot = (float) (((double) this.yRot) + (((double) xo) * 0.15d));
        this.xRot = (float) (((double) this.xRot) - (((double) yo) * 0.15d));
        if (this.xRot < -90.0f) {
            this.xRot = -90.0f;
        }
        if (this.xRot > 90.0f) {
            this.xRot = 90.0f;
        }
    }

    public void tick() {
        this.f0xo = this.f3x;
        this.f1yo = this.f4y;
        this.f2zo = this.f5z;
    }

    public boolean isFree(float xa, float ya, float za) {
        AABB box = this.f9bb.cloneMove(xa, ya, za);
        List<AABB> aABBs = this.level.getCubes(box);
        return aABBs.size() <= 0 && !this.level.containsAnyLiquid(box);
    }

    public void move(float xa, float ya, float za) {
        List<AABB> aABBs = this.level.getCubes(this.f9bb.expand(xa, ya, za));
        for (int i = 0; i < aABBs.size(); i++) {
            ya = aABBs.get(i).clipYCollide(this.f9bb, ya);
        }
        this.f9bb.move(0.0f, ya, 0.0f);
        for (int i2 = 0; i2 < aABBs.size(); i2++) {
            xa = aABBs.get(i2).clipXCollide(this.f9bb, xa);
        }
        this.f9bb.move(xa, 0.0f, 0.0f);
        for (int i3 = 0; i3 < aABBs.size(); i3++) {
            za = aABBs.get(i3).clipZCollide(this.f9bb, za);
        }
        this.f9bb.move(0.0f, 0.0f, za);
        this.horizontalCollision = (xa == xa && za == za) ? false : true;
        this.onGround = ya != ya && ya < 0.0f;
        if (xa != xa) {
            this.f6xd = 0.0f;
        }
        if (ya != ya) {
            this.f7yd = 0.0f;
        }
        if (za != za) {
            this.f8zd = 0.0f;
        }
        this.f3x = (this.f9bb.f53x0 + this.f9bb.f56x1) / 2.0f;
        this.f4y = this.f9bb.f54y0 + this.heightOffset;
        this.f5z = (this.f9bb.f55z0 + this.f9bb.f58z1) / 2.0f;
    }

    public boolean isInWater() {
        return this.level.containsLiquid(this.f9bb.grow(0.0f, -0.4f, 0.0f), 1);
    }

    public boolean isInLava() {
        return this.level.containsLiquid(this.f9bb, 2);
    }

    public void moveRelative(float xa, float za, float speed) {
        float dist = (xa * xa) + (za * za);
        if (dist < 0.01f) {
            return;
        }
        float dist2 = speed / ((float) Math.sqrt(dist));
        float xa2 = xa * dist2;
        float za2 = za * dist2;
        float sin = (float) Math.sin((((double) this.yRot) * 3.141592653589793d) / 180.0d);
        float cos = (float) Math.cos((((double) this.yRot) * 3.141592653589793d) / 180.0d);
        this.f6xd += (xa2 * cos) - (za2 * sin);
        this.f8zd += (za2 * cos) + (xa2 * sin);
    }

    public boolean isLit() {
        int xTile = (int) this.f3x;
        int yTile = (int) this.f4y;
        int zTile = (int) this.f5z;
        return this.level.isLit(xTile, yTile, zTile);
    }

    public void render(float a) {
    }
}
