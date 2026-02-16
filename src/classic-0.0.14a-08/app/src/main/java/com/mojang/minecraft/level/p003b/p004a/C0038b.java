package com.mojang.minecraft.level.p003b.p004a;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.b */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/b/a/b.class */
public final class C0038b extends AbstractC0039c {

    /* JADX INFO: renamed from: a */
    private AbstractC0039c f221a;

    /* JADX INFO: renamed from: b */
    private AbstractC0039c f222b;

    public C0038b(AbstractC0039c abstractC0039c, AbstractC0039c abstractC0039c2) {
        this.f221a = abstractC0039c;
        this.f222b = abstractC0039c2;
    }

    @Override // com.mojang.minecraft.level.p003b.p004a.AbstractC0039c
    /* JADX INFO: renamed from: a */
    public final double mo107a(double d, double d2) {
        return this.f221a.mo107a(d + this.f222b.mo107a(d, d2), d2);
    }
}
