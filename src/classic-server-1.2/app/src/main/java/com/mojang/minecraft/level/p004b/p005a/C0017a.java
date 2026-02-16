package com.mojang.minecraft.level.p004b.p005a;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/a.class */
public final class C0017a extends AbstractC0019c {

    /* JADX INFO: renamed from: a */
    private AbstractC0019c f82a;

    /* JADX INFO: renamed from: b */
    private AbstractC0019c f83b;

    public C0017a(AbstractC0019c abstractC0019c, AbstractC0019c abstractC0019c2) {
        this.f82a = abstractC0019c;
        this.f83b = abstractC0019c2;
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0019c
    /* JADX INFO: renamed from: a */
    public final double mo27a(double d, double d2) {
        return this.f82a.mo27a(d + this.f83b.mo27a(d, d2), d2);
    }
}
