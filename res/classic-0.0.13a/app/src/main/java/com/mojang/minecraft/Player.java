package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/Player.class */
public class Player extends Entity {
    public static final int KEY_UP = 0;
    public static final int KEY_DOWN = 1;
    public static final int KEY_LEFT = 2;
    public static final int KEY_RIGHT = 3;
    public static final int KEY_JUMP = 4;
    private boolean[] keys;

    public Player(Level level) {
        super(level);
        this.keys = new boolean[10];
        this.heightOffset = 1.62f;
    }

    public void setKey(int key, boolean state) {
        int id = -1;
        if (key == 200 || key == 17) {
            id = 0;
        }
        if (key == 208 || key == 31) {
            id = 1;
        }
        if (key == 203 || key == 30) {
            id = 2;
        }
        if (key == 205 || key == 32) {
            id = 3;
        }
        if (key == 57 || key == 219) {
            id = 4;
        }
        if (id >= 0) {
            this.keys[id] = state;
        }
    }

    public void releaseAllKeys() {
        for (int i = 0; i < 10; i++) {
            this.keys[i] = false;
        }
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        this.f0xo = this.f3x;
        this.f1yo = this.f4y;
        this.f2zo = this.f5z;
        float xa = 0.0f;
        float ya = 0.0f;
        boolean inWater = isInWater();
        boolean inLava = isInLava();
        if (this.keys[0]) {
            ya = 0.0f - 1.0f;
        }
        if (this.keys[1]) {
            ya += 1.0f;
        }
        if (this.keys[2]) {
            xa = 0.0f - 1.0f;
        }
        if (this.keys[3]) {
            xa += 1.0f;
        }
        if (this.keys[4]) {
            if (inWater || inLava) {
                this.f7yd += 0.04f;
            } else if (this.onGround) {
                this.f7yd = 0.42f;
                this.keys[4] = false;
            }
        }
        if (inWater) {
            float yo = this.f4y;
            moveRelative(xa, ya, 0.02f);
            move(this.f6xd, this.f7yd, this.f8zd);
            this.f6xd *= 0.8f;
            this.f7yd *= 0.8f;
            this.f8zd *= 0.8f;
            this.f7yd = (float) (((double) this.f7yd) - 0.02d);
            if (this.horizontalCollision && isFree(this.f6xd, ((this.f7yd + 0.6f) - this.f4y) + yo, this.f8zd)) {
                this.f7yd = 0.3f;
                return;
            }
            return;
        }
        if (inLava) {
            float yo2 = this.f4y;
            moveRelative(xa, ya, 0.02f);
            move(this.f6xd, this.f7yd, this.f8zd);
            this.f6xd *= 0.5f;
            this.f7yd *= 0.5f;
            this.f8zd *= 0.5f;
            this.f7yd = (float) (((double) this.f7yd) - 0.02d);
            if (this.horizontalCollision && isFree(this.f6xd, ((this.f7yd + 0.6f) - this.f4y) + yo2, this.f8zd)) {
                this.f7yd = 0.3f;
                return;
            }
            return;
        }
        moveRelative(xa, ya, this.onGround ? 0.1f : 0.02f);
        move(this.f6xd, this.f7yd, this.f8zd);
        this.f6xd *= 0.91f;
        this.f7yd *= 0.98f;
        this.f8zd *= 0.91f;
        this.f7yd = (float) (((double) this.f7yd) - 0.08d);
        if (this.onGround) {
            this.f6xd *= 0.6f;
            this.f8zd *= 0.6f;
        }
    }
}
