package com.mojang.minecraft.p000a.p002b.p003a;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b.a.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/b/a/a.class */
public final class C0010a extends AbstractC0012c {

    /* JADX INFO: renamed from: a */
    private AbstractC0012c f40a;

    /* JADX INFO: renamed from: b */
    private AbstractC0012c f41b;

    public C0010a(AbstractC0012c abstractC0012c, AbstractC0012c abstractC0012c2) {
        this.f40a = abstractC0012c;
        this.f41b = abstractC0012c2;
    }

    @Override // com.mojang.minecraft.p000a.p002b.p003a.AbstractC0012c
    /* JADX INFO: renamed from: a */
    public final double mo29a(double d, double d2) {
        return this.f40a.mo29a(d + this.f41b.mo29a(d, d2), d2);
    }
}
