package com.mojang.minecraft.player;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/player/Player.class */
public class Player extends Entity {
    private C0042a input;

    public Player(Level level, C0042a c0042a) {
        super(level);
        this.heightOffset = 1.62f;
        this.input = c0042a;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        super.tick();
        boolean zIsInWater = isInWater();
        boolean zIsInLava = isInLava();
        this.input.mo112a();
        if (!this.input.f240d) {
            this.input.f239c = false;
        } else if (zIsInWater || zIsInLava) {
            this.f7yd += 0.04f;
        } else if (this.onGround && !this.input.f239c) {
            this.f7yd = 0.42f;
            this.input.f239c = true;
        }
        if (zIsInWater) {
            float f = this.f4y;
            moveRelative(this.input.f237a, this.input.f238b, 0.02f);
            move(this.f6xd, this.f7yd, this.f8zd);
            this.f6xd *= 0.8f;
            this.f7yd *= 0.8f;
            this.f8zd *= 0.8f;
            this.f7yd = (float) (((double) this.f7yd) - 0.02d);
            if (this.horizontalCollision && isFree(this.f6xd, ((this.f7yd + 0.6f) - this.f4y) + f, this.f8zd)) {
                this.f7yd = 0.3f;
                return;
            }
            return;
        }
        if (!zIsInLava) {
            moveRelative(this.input.f237a, this.input.f238b, this.onGround ? 0.1f : 0.02f);
            move(this.f6xd, this.f7yd, this.f8zd);
            this.f6xd *= 0.91f;
            this.f7yd *= 0.98f;
            this.f8zd *= 0.91f;
            this.f7yd = (float) (((double) this.f7yd) - 0.08d);
            if (this.onGround) {
                this.f6xd *= 0.6f;
                this.f8zd *= 0.6f;
                return;
            }
            return;
        }
        float f2 = this.f4y;
        moveRelative(this.input.f237a, this.input.f238b, 0.02f);
        move(this.f6xd, this.f7yd, this.f8zd);
        this.f6xd *= 0.5f;
        this.f7yd *= 0.5f;
        this.f8zd *= 0.5f;
        this.f7yd = (float) (((double) this.f7yd) - 0.02d);
        if (this.horizontalCollision && isFree(this.f6xd, ((this.f7yd + 0.6f) - this.f4y) + f2, this.f8zd)) {
            this.f7yd = 0.3f;
        }
    }

    public void releaseAllKeys() {
        this.input.mo113b();
    }

    public void setKey(int i, boolean z) {
        this.input.mo114a(i, z);
    }
}
