package com.mojang.minecraft.p008f;

/* JADX INFO: renamed from: com.mojang.minecraft.f.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/f/a.class */
public final class C0041a {

    /* JADX INFO: renamed from: g */
    private float f223g = 0.0f;

    /* JADX INFO: renamed from: a */
    public float f224a;

    /* JADX INFO: renamed from: b */
    public float f225b;

    /* JADX INFO: renamed from: c */
    public float f226c;

    /* JADX INFO: renamed from: d */
    public float f227d;

    /* JADX INFO: renamed from: e */
    public float f228e;

    /* JADX INFO: renamed from: f */
    public float f229f;

    public C0041a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f224a = f;
        this.f225b = f2;
        this.f226c = f3;
        this.f227d = f4;
        this.f228e = f5;
        this.f229f = f6;
    }

    /* JADX INFO: renamed from: a */
    public final C0041a m109a(float f, float f2, float f3) {
        return new C0041a(this.f224a - f, this.f225b - f2, this.f226c - f3, this.f227d + f, this.f228e + f2, this.f229f + f3);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m110a(C0041a c0041a) {
        return c0041a.f227d > this.f224a && c0041a.f224a < this.f227d && c0041a.f228e > this.f225b && c0041a.f225b < this.f228e && c0041a.f229f > this.f226c && c0041a.f226c < this.f229f;
    }

    /* JADX INFO: renamed from: b */
    public final void m111b(float f, float f2, float f3) {
        this.f224a += f;
        this.f225b += f2;
        this.f226c += f3;
        this.f227d += f;
        this.f228e += f2;
        this.f229f += f3;
    }
}
