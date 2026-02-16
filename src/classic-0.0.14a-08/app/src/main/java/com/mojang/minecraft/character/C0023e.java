package com.mojang.minecraft.character;

/* JADX INFO: renamed from: com.mojang.minecraft.character.e */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/character/e.class */
public final class C0023e {

    /* JADX INFO: renamed from: a */
    public C0021c f164a;

    /* JADX INFO: renamed from: b */
    public float f165b;

    /* JADX INFO: renamed from: c */
    public float f166c;

    public C0023e(float f, float f2, float f3, float f4, float f5) {
        this(new C0021c(f, f2, f3), f4, f5);
    }

    /* JADX INFO: renamed from: a */
    public final C0023e m68a(float f, float f2) {
        return new C0023e(this, f, f2);
    }

    private C0023e(C0023e c0023e, float f, float f2) {
        this.f164a = c0023e.f164a;
        this.f165b = f;
        this.f166c = f2;
    }

    private C0023e(C0021c c0021c, float f, float f2) {
        this.f164a = c0021c;
        this.f165b = f;
        this.f166c = f2;
    }
}
