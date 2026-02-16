package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0017f;

/* JADX INFO: renamed from: com.mojang.minecraft.e */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/e.class */
public final class C0033e extends C0042g {

    /* JADX INFO: renamed from: a */
    boolean[] f187a;

    public C0033e(C0017f c0017f) {
        super(c0017f);
        this.f187a = new boolean[10];
        this.f246t = 1.62f;
    }

    @Override // com.mojang.minecraft.C0042g
    /* JADX INFO: renamed from: a */
    public final void mo102a() {
        this.f231e = this.f234h;
        this.f232f = this.f235i;
        this.f233g = this.f236j;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean zC = m117c();
        boolean zD = m118d();
        if (this.f187a[0]) {
            f2 = 0.0f - 1.0f;
        }
        if (this.f187a[1]) {
            f2 += 1.0f;
        }
        if (this.f187a[2]) {
            f = 0.0f - 1.0f;
        }
        if (this.f187a[3]) {
            f += 1.0f;
        }
        if (this.f187a[4]) {
            if (zC || zD) {
                this.f238l += 0.04f;
            } else if (this.f243q) {
                this.f238l = 0.42f;
                this.f187a[4] = false;
            }
        }
        if (zC) {
            float f3 = this.f235i;
            m119d(f, f2, 0.02f);
            m116c(this.f237k, this.f238l, this.f239m);
            this.f237k *= 0.8f;
            this.f238l *= 0.8f;
            this.f239m *= 0.8f;
            this.f238l = (float) (((double) this.f238l) - 0.02d);
            if (this.f244r && m115b(this.f237k, ((this.f238l + 0.6f) - this.f235i) + f3, this.f239m)) {
                this.f238l = 0.3f;
                return;
            }
            return;
        }
        if (!zD) {
            m119d(f, f2, this.f243q ? 0.1f : 0.02f);
            m116c(this.f237k, this.f238l, this.f239m);
            this.f237k *= 0.91f;
            this.f238l *= 0.98f;
            this.f239m *= 0.91f;
            this.f238l = (float) (((double) this.f238l) - 0.08d);
            if (this.f243q) {
                this.f237k *= 0.6f;
                this.f239m *= 0.6f;
                return;
            }
            return;
        }
        float f4 = this.f235i;
        m119d(f, f2, 0.02f);
        m116c(this.f237k, this.f238l, this.f239m);
        this.f237k *= 0.5f;
        this.f238l *= 0.5f;
        this.f239m *= 0.5f;
        this.f238l = (float) (((double) this.f238l) - 0.02d);
        if (this.f244r && m115b(this.f237k, ((this.f238l + 0.6f) - this.f235i) + f4, this.f239m)) {
            this.f238l = 0.3f;
        }
    }
}
