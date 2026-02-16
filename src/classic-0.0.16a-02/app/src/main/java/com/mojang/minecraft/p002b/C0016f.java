package com.mojang.minecraft.p002b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.f */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/f.class */
public final class C0016f extends C0014d {

    /* JADX INFO: renamed from: e */
    private C0014d f93e;

    public C0016f(C0014d c0014d) {
        this.f93e = c0014d;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo33a() {
        this.f84d.clear();
        this.f84d.add(new C0015e(0, (this.f82b / 2) - 100, this.f83c / 3, 200, 20, "Small"));
        this.f84d.add(new C0015e(1, (this.f82b / 2) - 100, (this.f83c / 3) + 32, 200, 20, "Normal"));
        this.f84d.add(new C0015e(2, (this.f82b / 2) - 100, (this.f83c / 3) + 64, 200, 20, "Huge"));
        this.f84d.add(new C0015e(3, (this.f82b / 2) - 100, (this.f83c / 3) + 96, 200, 20, "Cancel"));
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo36a(C0015e c0015e) {
        if (c0015e.f90f == 3) {
            this.f81a.m57a(this.f93e);
            return;
        }
        this.f81a.m75b(c0015e.f90f);
        this.f81a.m57a((C0014d) null);
        this.f81a.m61c();
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo38a(int i, int i2) {
        m41a(0, 0, this.f82b, this.f83c, 1610941696, -1607454624);
        m42a("Generate new level", this.f82b / 2, 40, 16777215);
        super.mo38a(i, i2);
    }
}
