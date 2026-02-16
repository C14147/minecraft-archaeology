package com.mojang.minecraft.character;

/* JADX INFO: renamed from: com.mojang.minecraft.character.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/character/a.class */
public final class C0022a {

    /* JADX INFO: renamed from: a */
    private C0025d f111a = new C0025d(0, 0);

    /* JADX INFO: renamed from: b */
    private C0025d f112b;

    /* JADX INFO: renamed from: c */
    private C0025d f113c;

    /* JADX INFO: renamed from: d */
    private C0025d f114d;

    /* JADX INFO: renamed from: e */
    private C0025d f115e;

    /* JADX INFO: renamed from: f */
    private C0025d f116f;

    public C0022a() {
        this.f111a.m52a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.f112b = new C0025d(16, 16);
        this.f112b.m52a(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.f113c = new C0025d(40, 16);
        this.f113c.m52a(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.f113c.m53a(-5.0f, 2.0f, 0.0f);
        this.f114d = new C0025d(40, 16);
        this.f114d.m52a(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.f114d.m53a(5.0f, 2.0f, 0.0f);
        this.f115e = new C0025d(0, 16);
        this.f115e.m52a(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.f115e.m53a(-2.0f, 12.0f, 0.0f);
        this.f116f = new C0025d(0, 16);
        this.f116f.m52a(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.f116f.m53a(2.0f, 12.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public final void m51a(float f, float f2, float f3) {
        this.f111a.f129b = f2 / 57.29578f;
        this.f111a.f128a = f3 / 57.29578f;
        this.f113c.f128a = ((float) Math.sin((((double) f) * 0.6662d) + 3.141592653589793d)) * 2.0f;
        this.f113c.f130c = (float) (Math.sin(((double) f) * 0.2312d) + 1.0d);
        this.f114d.f128a = ((float) Math.sin(((double) f) * 0.6662d)) * 2.0f;
        this.f114d.f130c = (float) (Math.sin(((double) f) * 0.2812d) - 1.0d);
        this.f115e.f128a = ((float) Math.sin(((double) f) * 0.6662d)) * 1.4f;
        this.f116f.f128a = ((float) Math.sin((((double) f) * 0.6662d) + 3.141592653589793d)) * 1.4f;
        this.f111a.m54a();
        this.f112b.m54a();
        this.f113c.m54a();
        this.f114d.m54a();
        this.f115e.m54a();
        this.f116f.m54a();
    }
}
