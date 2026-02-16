package com.mojang.minecraft.player;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/player/Player.class */
public class Player extends Entity {
    private C0050a input;

    public Player(Level level, C0050a c0050a) {
        super(level);
        this.heightOffset = 1.62f;
        this.input = c0050a;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        super.tick();
        boolean zIsInWater = isInWater();
        boolean zIsInLava = isInLava();
        this.input.mo128a();
        if (!this.input.f301d) {
            this.input.f300c = false;
        } else if (zIsInWater || zIsInLava) {
            this.f15yd += 0.04f;
        } else if (this.onGround && !this.input.f300c) {
            this.f15yd = 0.42f;
            this.input.f300c = true;
        }
        if (zIsInWater) {
            float f = this.f12y;
            moveRelative(this.input.f298a, this.input.f299b, 0.02f);
            move(this.f14xd, this.f15yd, this.f16zd);
            this.f14xd *= 0.8f;
            this.f15yd *= 0.8f;
            this.f16zd *= 0.8f;
            this.f15yd = (float) (((double) this.f15yd) - 0.02d);
            if (this.horizontalCollision && isFree(this.f14xd, ((this.f15yd + 0.6f) - this.f12y) + f, this.f16zd)) {
                this.f15yd = 0.3f;
                return;
            }
            return;
        }
        if (!zIsInLava) {
            moveRelative(this.input.f298a, this.input.f299b, this.onGround ? 0.1f : 0.02f);
            move(this.f14xd, this.f15yd, this.f16zd);
            this.f14xd *= 0.91f;
            this.f15yd *= 0.98f;
            this.f16zd *= 0.91f;
            this.f15yd = (float) (((double) this.f15yd) - 0.08d);
            if (this.onGround) {
                this.f14xd *= 0.6f;
                this.f16zd *= 0.6f;
                return;
            }
            return;
        }
        float f2 = this.f12y;
        moveRelative(this.input.f298a, this.input.f299b, 0.02f);
        move(this.f14xd, this.f15yd, this.f16zd);
        this.f14xd *= 0.5f;
        this.f15yd *= 0.5f;
        this.f16zd *= 0.5f;
        this.f15yd = (float) (((double) this.f15yd) - 0.02d);
        if (this.horizontalCollision && isFree(this.f14xd, ((this.f15yd + 0.6f) - this.f12y) + f2, this.f16zd)) {
            this.f15yd = 0.3f;
        }
    }

    public void releaseAllKeys() {
        this.input.mo129b();
    }

    public void setKey(int i, boolean z) {
        this.input.mo130a(i, z);
    }
}
