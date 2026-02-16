package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0013g;
import org.lwjgl.input.Keyboard;

/* JADX INFO: renamed from: com.mojang.minecraft.d */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/d.class */
public final class C0021d extends C0030f {
    public C0021d(C0013g c0013g) {
        super(c0013g);
        this.f196s = 1.62f;
    }

    @Override // com.mojang.minecraft.C0030f
    /* JADX INFO: renamed from: a */
    public final void mo69a() {
        this.f182e = this.f185h;
        this.f183f = this.f186i;
        this.f184g = this.f187j;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean zC = m83c();
        boolean zD = m84d();
        if (Keyboard.isKeyDown(19)) {
            m79b();
        }
        if (Keyboard.isKeyDown(200) || Keyboard.isKeyDown(17)) {
            f2 = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(208) || Keyboard.isKeyDown(31)) {
            f2 += 1.0f;
        }
        if (Keyboard.isKeyDown(203) || Keyboard.isKeyDown(30)) {
            f = 0.0f - 1.0f;
        }
        if (Keyboard.isKeyDown(205) || Keyboard.isKeyDown(32)) {
            f += 1.0f;
        }
        if (Keyboard.isKeyDown(57) || Keyboard.isKeyDown(219)) {
            if (zC) {
                this.f189l += 0.06f;
            } else if (zD) {
                this.f189l += 0.04f;
            } else if (this.f194q) {
                this.f189l = 0.5f;
            }
        }
        if (zC) {
            m85c(f, f2, 0.02f);
            m82b(this.f188k, this.f189l, this.f190m);
            this.f188k *= 0.7f;
            this.f189l *= 0.7f;
            this.f190m *= 0.7f;
            this.f189l = (float) (((double) this.f189l) - 0.02d);
            return;
        }
        if (zD) {
            m85c(f, f2, 0.02f);
            m82b(this.f188k, this.f189l, this.f190m);
            this.f188k *= 0.5f;
            this.f189l *= 0.5f;
            this.f190m *= 0.5f;
            this.f189l = (float) (((double) this.f189l) - 0.02d);
            return;
        }
        m85c(f, f2, this.f194q ? 0.1f : 0.02f);
        m82b(this.f188k, this.f189l, this.f190m);
        this.f188k *= 0.91f;
        this.f189l *= 0.98f;
        this.f190m *= 0.91f;
        this.f189l = (float) (((double) this.f189l) - 0.08d);
        if (this.f194q) {
            this.f188k *= 0.6f;
            this.f190m *= 0.6f;
        }
    }
}
