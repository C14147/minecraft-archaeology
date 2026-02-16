package com.mojang.minecraft.p006d;

import com.mojang.minecraft.C0042g;
import com.mojang.minecraft.p000a.C0017f;

/* JADX INFO: renamed from: com.mojang.minecraft.d.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/d/b.class */
public final class C0032b extends C0042g {

    /* JADX INFO: renamed from: v */
    private float f178v;

    /* JADX INFO: renamed from: w */
    private float f179w;

    /* JADX INFO: renamed from: x */
    private float f180x;

    /* JADX INFO: renamed from: a */
    public int f181a;

    /* JADX INFO: renamed from: b */
    float f182b;

    /* JADX INFO: renamed from: c */
    float f183c;

    /* JADX INFO: renamed from: y */
    private int f184y;

    /* JADX INFO: renamed from: z */
    private int f185z;

    /* JADX INFO: renamed from: d */
    float f186d;

    public C0032b(C0017f c0017f, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        super(c0017f);
        this.f184y = 0;
        this.f185z = 0;
        this.f181a = i;
        m113a(0.2f, 0.2f);
        this.f246t = this.f248u / 2.0f;
        m114a(f, f2, f3);
        this.f178v = f4 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f179w = f5 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f180x = f6 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        float fRandom = ((float) (Math.random() + Math.random() + 1.0d)) * 0.15f;
        float fSqrt = (float) Math.sqrt((this.f178v * this.f178v) + (this.f179w * this.f179w) + (this.f180x * this.f180x));
        this.f178v = (this.f178v / fSqrt) * fRandom * 0.4f;
        this.f179w = ((this.f179w / fSqrt) * fRandom * 0.4f) + 0.1f;
        this.f180x = (this.f180x / fSqrt) * fRandom * 0.4f;
        this.f182b = ((float) Math.random()) * 3.0f;
        this.f183c = ((float) Math.random()) * 3.0f;
        this.f186d = (float) ((Math.random() * 0.5d) + 0.5d);
        this.f185z = (int) (4.0d / ((Math.random() * 0.9d) + 0.1d));
        this.f184y = 0;
    }

    @Override // com.mojang.minecraft.C0042g
    /* JADX INFO: renamed from: a */
    public final void mo102a() {
        this.f231e = this.f234h;
        this.f232f = this.f235i;
        this.f233g = this.f236j;
        int i = this.f184y;
        this.f184y = i + 1;
        if (i >= this.f185z) {
            this.f245s = true;
        }
        this.f179w = (float) (((double) this.f179w) - 0.04d);
        m116c(this.f178v, this.f179w, this.f180x);
        this.f178v *= 0.98f;
        this.f179w *= 0.98f;
        this.f180x *= 0.98f;
        if (this.f243q) {
            this.f178v *= 0.7f;
            this.f180x *= 0.7f;
        }
    }
}
