package com.mojang.minecraft.p001b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.b */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/b.class */
public final class C0011b extends C0012c {
    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo29a() {
        this.f78d.clear();
        this.f78d.add(new C0013d(0, (this.f76b / 2) - 100, this.f77c / 3, 200, 20, "Generate new level..."));
        this.f78d.add(new C0013d(1, (this.f76b / 2) - 100, (this.f77c / 3) + 32, 200, 20, "Save level.."));
        this.f78d.add(new C0013d(2, (this.f76b / 2) - 100, (this.f77c / 3) + 64, 200, 20, "Load level.."));
        this.f78d.add(new C0013d(3, (this.f76b / 2) - 100, (this.f77c / 3) + 96, 200, 20, "Back to game"));
        if (this.f75a.f107c == null) {
            ((C0013d) this.f78d.get(1)).f85g = false;
            ((C0013d) this.f78d.get(2)).f85g = false;
        }
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    protected final void mo32a(C0013d c0013d) {
        if (c0013d.f84f == 0) {
            this.f75a.m46a(new C0014e(this));
        }
        if (this.f75a.f107c != null) {
            if (c0013d.f84f == 1) {
                this.f75a.m46a(new C0016g(this));
            }
            if (c0013d.f84f == 2) {
                this.f75a.m46a(new RunnableC0015f(this));
            }
        }
        if (c0013d.f84f == 3) {
            this.f75a.m46a((C0012c) null);
            this.f75a.m50c();
        }
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo34a(int i, int i2) {
        m37a(0, 0, this.f76b, this.f77c, 1610941696, -1607454624);
        m38a("Game menu", this.f76b / 2, 40, 16777215);
        super.mo34a(i, i2);
    }
}
