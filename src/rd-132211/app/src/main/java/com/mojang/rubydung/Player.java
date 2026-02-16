package com.mojang.rubydung;

import com.mojang.rubydung.level.Level;
import com.mojang.rubydung.phys.AABB;
import java.util.List;
import org.lwjgl.input.Keyboard;

/* JADX INFO: loaded from: pre-Classic rd-132211.jar:com/mojang/rubydung/Player.class */
public class Player {
    private Level level;
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

    public Player(Level level) {
        this.level = level;
        resetPos();
    }

    private void resetPos() {
        float x = ((float) Math.random()) * this.level.width;
        float y = this.level.depth + 10;
        float z = ((float) Math.random()) * this.level.height;
        setPos(x, y, z);
    }

    private void setPos(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.bb = new AABB(x - 0.3f, y - 0.9f, z - 0.3f, x + 0.3f, y + 0.9f, z + 0.3f);
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
        float xa = 0.0f;
        float ya = 0.0f;
        if (Keyboard.isKeyDown(19)) {
            resetPos();
        }
        if (Keyboard.isKeyDown(200) || Keyboard.isKeyDown(17)) {
            ya = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(208) || Keyboard.isKeyDown(31)) {
            ya += 1.0f;
        }
        if (Keyboard.isKeyDown(203) || Keyboard.isKeyDown(30)) {
            xa = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(205) || Keyboard.isKeyDown(32)) {
            xa += 1.0f;
        }
        if ((Keyboard.isKeyDown(57) || Keyboard.isKeyDown(219)) && this.onGround) {
            this.yd = 0.12f;
        }
        moveRelative(xa, ya, this.onGround ? 0.02f : 0.005f);
        this.yd = (float) (((double) this.yd) - 0.005d);
        move(this.xd, this.yd, this.zd);
        this.xd *= 0.91f;
        this.yd *= 0.98f;
        this.zd *= 0.91f;
        if (this.onGround) {
            this.xd *= 0.8f;
            this.zd *= 0.8f;
        }
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
        this.y = this.bb.y0 + 1.62f;
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
}
