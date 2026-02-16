package com.mojang.minecraft.p005c;

/* JADX INFO: renamed from: com.mojang.minecraft.c.c */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c/c.class */
public final class C0025c extends C0026d {
    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo84a() {
        this.f165d.add(new C0024b(0, (this.f163b / 2) - 100, this.f164c / 3, 200, 20, "Generate new level"));
        this.f165d.add(new C0024b(1, (this.f163b / 2) - 100, (this.f164c / 3) + 32, 200, 20, "Save level.."));
        this.f165d.add(new C0024b(2, (this.f163b / 2) - 100, (this.f164c / 3) + 64, 200, 20, "Load level.."));
        this.f165d.add(new C0024b(3, (this.f163b / 2) - 100, (this.f164c / 3) + 96, 200, 20, "Back to game"));
        if (this.f162a.f124d == null) {
            ((C0024b) this.f165d.get(1)).f160g = false;
            ((C0024b) this.f165d.get(2)).f160g = false;
        }
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    protected final void mo87a(C0024b c0024b) {
        if (c0024b.f159f == 0) {
            this.f162a.m82c();
            this.f162a.m68a((C0026d) null);
            this.f162a.m72b();
        }
        if (this.f162a.f124d != null) {
            if (c0024b.f159f == 1) {
                this.f162a.m68a(new C0028f(this));
            }
            if (c0024b.f159f == 2) {
                this.f162a.m68a(new RunnableC0027e(this));
            }
        }
        if (c0024b.f159f == 3) {
            this.f162a.m68a((C0026d) null);
            this.f162a.m72b();
        }
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo89a(int i, int i2) {
        m92a(0, 0, this.f163b, this.f164c, 1610941696, -1607454624);
        m93a("Game menu", this.f163b / 2, 40, 16777215);
        super.mo89a(i, i2);
    }
}
