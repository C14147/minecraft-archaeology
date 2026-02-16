package com.mojang.minecraft.p002b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.c */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/c.class */
public final class C0013c extends C0014d {
    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo33a() {
        this.f84d.clear();
        this.f84d.add(new C0015e(0, (this.f82b / 2) - 100, this.f83c / 3, 200, 20, "Generate new level..."));
        this.f84d.add(new C0015e(1, (this.f82b / 2) - 100, (this.f83c / 3) + 32, 200, 20, "Save level.."));
        this.f84d.add(new C0015e(2, (this.f82b / 2) - 100, (this.f83c / 3) + 64, 200, 20, "Load level.."));
        this.f84d.add(new C0015e(3, (this.f82b / 2) - 100, (this.f83c / 3) + 96, 200, 20, "Back to game"));
        if (this.f81a.f147e == null) {
            ((C0015e) this.f84d.get(1)).f91g = false;
            ((C0015e) this.f84d.get(2)).f91g = false;
        }
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo36a(C0015e c0015e) {
        if (c0015e.f90f == 0) {
            this.f81a.m57a(new C0016f(this));
        }
        if (this.f81a.f147e != null) {
            if (c0015e.f90f == 1) {
                this.f81a.m57a(new C0019i(this));
            }
            if (c0015e.f90f == 2) {
                this.f81a.m57a(new RunnableC0017g(this));
            }
        }
        if (c0015e.f90f == 3) {
            this.f81a.m57a((C0014d) null);
            this.f81a.m61c();
        }
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo38a(int i, int i2) {
        m41a(0, 0, this.f82b, this.f83c, 1610941696, -1607454624);
        m42a("Game menu", this.f82b / 2, 40, 16777215);
        super.mo38a(i, i2);
    }
}
