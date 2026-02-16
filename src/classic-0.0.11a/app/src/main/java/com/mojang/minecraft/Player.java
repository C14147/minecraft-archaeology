package com.mojang.minecraft;

import com.mojang.minecraft.level.Level;
import org.lwjgl.input.Keyboard;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/Player.class */
public class Player extends Entity {
    public Player(Level level) {
        super(level);
        this.heightOffset = 1.62f;
    }

    @Override // com.mojang.minecraft.Entity
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
            this.yd = 0.5f;
        }
        moveRelative(xa, ya, this.onGround ? 0.1f : 0.02f);
        this.yd = (float) (((double) this.yd) - 0.08d);
        move(this.xd, this.yd, this.zd);
        this.xd *= 0.91f;
        this.yd *= 0.98f;
        this.zd *= 0.91f;
        if (this.onGround) {
            this.xd *= 0.7f;
            this.zd *= 0.7f;
        }
    }
}
