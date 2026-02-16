package com.mojang.minecraft.p004d;

/* JADX INFO: renamed from: com.mojang.minecraft.d.e */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/d/e.class */
public final class C0026e {

    /* JADX INFO: renamed from: a */
    public C0027f f169a;

    /* JADX INFO: renamed from: b */
    public float f170b;

    /* JADX INFO: renamed from: c */
    public float f171c;

    public C0026e(float f, float f2, float f3, float f4, float f5) {
        this(new C0027f(f, f2, f3), f4, f5);
    }

    /* JADX INFO: renamed from: a */
    public final C0026e m74a(float f, float f2) {
        return new C0026e(this, f, f2);
    }

    private C0026e(C0026e c0026e, float f, float f2) {
        this.f169a = c0026e.f169a;
        this.f170b = f;
        this.f171c = f2;
    }

    private C0026e(C0027f c0027f, float f, float f2) {
        this.f169a = c0027f;
        this.f170b = f;
        this.f171c = f2;
    }
}
