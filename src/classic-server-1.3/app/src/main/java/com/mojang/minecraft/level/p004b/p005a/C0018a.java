package com.mojang.minecraft.level.p004b.p005a;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/a.class */
public final class C0018a extends AbstractC0019b {

    /* JADX INFO: renamed from: a */
    private AbstractC0019b f86a;

    /* JADX INFO: renamed from: b */
    private AbstractC0019b f87b;

    public C0018a(AbstractC0019b abstractC0019b, AbstractC0019b abstractC0019b2) {
        this.f86a = abstractC0019b;
        this.f87b = abstractC0019b2;
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0019b
    /* JADX INFO: renamed from: a */
    public final double mo27a(double d, double d2) {
        return this.f86a.mo27a(d + this.f87b.mo27a(d, d2), d2);
    }
}
