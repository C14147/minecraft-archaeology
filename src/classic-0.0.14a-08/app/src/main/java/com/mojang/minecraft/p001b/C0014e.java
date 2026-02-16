package com.mojang.minecraft.p001b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.e */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/e.class */
public final class C0014e extends C0012c {

    /* JADX INFO: renamed from: e */
    private C0012c f87e;

    public C0014e(C0012c c0012c) {
        this.f87e = c0012c;
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo29a() {
        this.f78d.clear();
        this.f78d.add(new C0013d(0, (this.f76b / 2) - 100, this.f77c / 3, 200, 20, "Small"));
        this.f78d.add(new C0013d(1, (this.f76b / 2) - 100, (this.f77c / 3) + 32, 200, 20, "Normal"));
        this.f78d.add(new C0013d(2, (this.f76b / 2) - 100, (this.f77c / 3) + 64, 200, 20, "Huge"));
        this.f78d.add(new C0013d(3, (this.f76b / 2) - 100, (this.f77c / 3) + 96, 200, 20, "Cancel"));
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    protected final void mo32a(C0013d c0013d) {
        if (c0013d.f84f == 3) {
            this.f75a.m46a(this.f87e);
            return;
        }
        this.f75a.m61b(c0013d.f84f);
        this.f75a.m46a((C0012c) null);
        this.f75a.m50c();
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo34a(int i, int i2) {
        m37a(0, 0, this.f76b, this.f77c, 1610941696, -1607454624);
        m38a("Generate new level", this.f76b / 2, 40, 16777215);
        super.mo34a(i, i2);
    }
}
