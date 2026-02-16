package com.mojang.minecraft.p001b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.g */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/g.class */
public final class C0016g extends RunnableC0015f {
    public C0016g(C0012c c0012c) {
        super(c0012c);
        this.f93e = "Save level";
    }

    @Override // com.mojang.minecraft.p001b.RunnableC0015f
    /* JADX INFO: renamed from: a */
    protected final void mo41a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0013d) this.f78d.get(i)).f83e = strArr[i];
            ((C0013d) this.f78d.get(i)).f86h = true;
        }
    }

    @Override // com.mojang.minecraft.p001b.RunnableC0015f
    /* JADX INFO: renamed from: a */
    protected final void mo42a(int i) {
        this.f75a.m46a(new C0010a(this, ((C0013d) this.f78d.get(i)).f83e, i));
    }
}
