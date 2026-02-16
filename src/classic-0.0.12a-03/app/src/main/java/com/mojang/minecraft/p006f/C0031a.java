package com.mojang.minecraft.p006f;

/* JADX INFO: renamed from: com.mojang.minecraft.f.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/f/a.class */
public final class C0031a {

    /* JADX INFO: renamed from: g */
    private float f199g = 0.0f;

    /* JADX INFO: renamed from: a */
    public float f200a;

    /* JADX INFO: renamed from: b */
    public float f201b;

    /* JADX INFO: renamed from: c */
    public float f202c;

    /* JADX INFO: renamed from: d */
    public float f203d;

    /* JADX INFO: renamed from: e */
    public float f204e;

    /* JADX INFO: renamed from: f */
    public float f205f;

    public C0031a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f200a = f;
        this.f201b = f2;
        this.f202c = f3;
        this.f203d = f4;
        this.f204e = f5;
        this.f205f = f6;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m87a(C0031a c0031a) {
        return c0031a.f203d > this.f200a && c0031a.f200a < this.f203d && c0031a.f204e > this.f201b && c0031a.f201b < this.f204e && c0031a.f205f > this.f202c && c0031a.f202c < this.f205f;
    }

    /* JADX INFO: renamed from: a */
    public final void m88a(float f, float f2, float f3) {
        this.f200a += f;
        this.f201b += f2;
        this.f202c += f3;
        this.f203d += f;
        this.f204e += f2;
        this.f205f += f3;
    }
}
