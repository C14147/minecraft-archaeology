package com.mojang.minecraft.level.p004b.p005a;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/a.class */
public final class C0020a extends AbstractC0021b {

    /* JADX INFO: renamed from: a */
    private AbstractC0021b f87a;

    /* JADX INFO: renamed from: b */
    private AbstractC0021b f88b;

    public C0020a(AbstractC0021b abstractC0021b, AbstractC0021b abstractC0021b2) {
        this.f87a = abstractC0021b;
        this.f88b = abstractC0021b2;
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0021b
    /* JADX INFO: renamed from: a */
    public final double mo29a(double d, double d2) {
        return this.f87a.mo29a(d + this.f88b.mo29a(d, d2), d2);
    }
}
