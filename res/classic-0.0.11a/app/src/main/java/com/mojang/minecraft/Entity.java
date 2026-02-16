package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.phys.AABB;
import java.util.List;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/Entity.class */
public class Entity {
    protected Level level;
    public float xo;
    public float yo;
    public float zo;
    public float x;
    public float y;
    public float z;
    public float xd;
    public float yd;
    public float zd;
    public float yRot;
    public float xRot;
    public AABB bb;
    public boolean onGround = false;
    public boolean removed = false;
    protected float heightOffset = 0.0f;
    protected float bbWidth = 0.6f;
    protected float bbHeight = 1.8f;

    public Entity(Level level) {
        this.level = level;
        resetPos();
    }

    protected void resetPos() {
        float x = ((float) Math.random()) * this.level.width;
        float y = this.level.depth + 10;
        float z = ((float) Math.random()) * this.level.height;
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
        this.x = x;
        this.y = y;
        this.z = z;
        float w = this.bbWidth / 2.0f;
        float h = this.bbHeight / 2.0f;
        this.bb = new AABB(x - w, y - h, z - w, x + w, y + h, z + w);
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
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    public void move(float xa, float ya, float za) {
        List<AABB> aABBs = this.level.getCubes(this.bb.expand(xa, ya, za));
        for (int i = 0; i < aABBs.size(); i++) {
            ya = aABBs.get(i).clipYCollide(this.bb, ya);
        }
        this.bb.move(0.0f, ya, 0.0f);
        for (int i2 = 0; i2 < aABBs.size(); i2++) {
            xa = aABBs.get(i2).clipXCollide(this.bb, xa);
        }
        this.bb.move(xa, 0.0f, 0.0f);
        for (int i3 = 0; i3 < aABBs.size(); i3++) {
            za = aABBs.get(i3).clipZCollide(this.bb, za);
        }
        this.bb.move(0.0f, 0.0f, za);
        this.onGround = ya != ya && ya < 0.0f;
        if (xa != xa) {
            this.xd = 0.0f;
        }
        if (ya != ya) {
            this.yd = 0.0f;
        }
        if (za != za) {
            this.zd = 0.0f;
        }
        this.x = (this.bb.x0 + this.bb.x1) / 2.0f;
        this.y = this.bb.y0 + this.heightOffset;
        this.z = (this.bb.z0 + this.bb.z1) / 2.0f;
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
        this.xd += (xa2 * cos) - (za2 * sin);
        this.zd += (za2 * cos) + (xa2 * sin);
    }

    public boolean isLit() {
        int xTile = (int) this.x;
        int yTile = (int) this.y;
        int zTile = (int) this.z;
        return this.level.isLit(xTile, yTile, zTile);
    }

    public void render(float a) {
    }
}
