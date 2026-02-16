package com.mojang.minecraft.character;

/* JADX INFO: renamed from: com.mojang.minecraft.character.e */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/character/e.class */
public final class C0026e {

    /* JADX INFO: renamed from: a */
    public C0024c f133a;

    /* JADX INFO: renamed from: b */
    public float f134b;

    /* JADX INFO: renamed from: c */
    public float f135c;

    public C0026e(float f, float f2, float f3, float f4, float f5) {
        this(new C0024c(f, f2, f3), f4, f5);
    }

    /* JADX INFO: renamed from: a */
    public final C0026e m55a(float f, float f2) {
        return new C0026e(this, f, f2);
    }

    private C0026e(C0026e c0026e, float f, float f2) {
        this.f133a = c0026e.f133a;
        this.f134b = f;
        this.f135c = f2;
    }

    private C0026e(C0024c c0024c, float f, float f2) {
        this.f133a = c0024c;
        this.f134b = f;
        this.f135c = f2;
    }
}
