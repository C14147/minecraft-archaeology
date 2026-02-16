package com.mojang.minecraft.p007e;

/* JADX INFO: renamed from: com.mojang.minecraft.e.e */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/e/e.class */
public final class C0038e {

    /* JADX INFO: renamed from: a */
    public C0039f f213a;

    /* JADX INFO: renamed from: b */
    public float f214b;

    /* JADX INFO: renamed from: c */
    public float f215c;

    public C0038e(float f, float f2, float f3, float f4, float f5) {
        this(new C0039f(f, f2, f3), f4, f5);
    }

    /* JADX INFO: renamed from: a */
    public final C0038e m107a(float f, float f2) {
        return new C0038e(this, f, f2);
    }

    private C0038e(C0038e c0038e, float f, float f2) {
        this.f213a = c0038e.f213a;
        this.f214b = f;
        this.f215c = f2;
    }

    private C0038e(C0039f c0039f, float f, float f2) {
        this.f213a = c0039f;
        this.f214b = f;
        this.f215c = f2;
    }
}
