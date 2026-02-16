package com.mojang.minecraft.level.p004b.p005a;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.b */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/b/a/b.class */
public final class C0042b extends AbstractC0043c {

    /* JADX INFO: renamed from: a */
    private AbstractC0043c f244a;

    /* JADX INFO: renamed from: b */
    private AbstractC0043c f245b;

    public C0042b(AbstractC0043c abstractC0043c, AbstractC0043c abstractC0043c2) {
        this.f244a = abstractC0043c;
        this.f245b = abstractC0043c2;
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0043c
    /* JADX INFO: renamed from: a */
    public final double mo122a(double d, double d2) {
        return this.f244a.mo122a(d + this.f245b.mo122a(d, d2), d2);
    }
}
