package com.mojang.minecraft.p003c;

import com.mojang.minecraft.C0030f;
import com.mojang.minecraft.p000a.C0013g;

/* JADX INFO: renamed from: com.mojang.minecraft.c.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/c/b.class */
public final class C0020b extends C0030f {

    /* JADX INFO: renamed from: u */
    private float f135u;

    /* JADX INFO: renamed from: v */
    private float f136v;

    /* JADX INFO: renamed from: w */
    private float f137w;

    /* JADX INFO: renamed from: a */
    public int f138a;

    /* JADX INFO: renamed from: b */
    float f139b;

    /* JADX INFO: renamed from: c */
    float f140c;

    /* JADX INFO: renamed from: x */
    private int f141x;

    /* JADX INFO: renamed from: y */
    private int f142y;

    /* JADX INFO: renamed from: d */
    float f143d;

    public C0020b(C0013g c0013g, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        super(c0013g);
        this.f141x = 0;
        this.f142y = 0;
        this.f138a = i;
        m80a(0.2f, 0.2f);
        this.f196s = this.f198t / 2.0f;
        m81a(f, f2, f3);
        this.f135u = f4 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f136v = f5 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f137w = f6 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        float fRandom = ((float) (Math.random() + Math.random() + 1.0d)) * 0.15f;
        float fSqrt = (float) Math.sqrt((this.f135u * this.f135u) + (this.f136v * this.f136v) + (this.f137w * this.f137w));
        this.f135u = (this.f135u / fSqrt) * fRandom * 0.4f;
        this.f136v = ((this.f136v / fSqrt) * fRandom * 0.4f) + 0.1f;
        this.f137w = (this.f137w / fSqrt) * fRandom * 0.4f;
        this.f139b = ((float) Math.random()) * 3.0f;
        this.f140c = ((float) Math.random()) * 3.0f;
        this.f143d = (float) ((Math.random() * 0.5d) + 0.5d);
        this.f142y = (int) (4.0d / ((Math.random() * 0.9d) + 0.1d));
        this.f141x = 0;
    }

    @Override // com.mojang.minecraft.C0030f
    /* JADX INFO: renamed from: a */
    public final void mo69a() {
        this.f182e = this.f185h;
        this.f183f = this.f186i;
        this.f184g = this.f187j;
        int i = this.f141x;
        this.f141x = i + 1;
        if (i >= this.f142y) {
            this.f195r = true;
        }
        this.f136v = (float) (((double) this.f136v) - 0.04d);
        m82b(this.f135u, this.f136v, this.f137w);
        this.f135u *= 0.98f;
        this.f136v *= 0.98f;
        this.f137w *= 0.98f;
        if (this.f194q) {
            this.f135u *= 0.7f;
            this.f137w *= 0.7f;
        }
    }
}
