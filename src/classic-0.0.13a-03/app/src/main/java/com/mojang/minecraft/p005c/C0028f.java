package com.mojang.minecraft.p005c;

/* JADX INFO: renamed from: com.mojang.minecraft.c.f */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c/f.class */
public final class C0028f extends RunnableC0027e {
    public C0028f(C0026d c0026d) {
        super(c0026d);
        this.f171e = "Save level";
    }

    @Override // com.mojang.minecraft.p005c.RunnableC0027e
    /* JADX INFO: renamed from: a */
    protected final void mo96a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0024b) this.f165d.get(i)).f158e = strArr[i];
            ((C0024b) this.f165d.get(i)).f161h = true;
        }
    }

    @Override // com.mojang.minecraft.p005c.RunnableC0027e
    /* JADX INFO: renamed from: a */
    protected final void mo97a(int i) {
        this.f162a.m68a(new C0023a(this, ((C0024b) this.f165d.get(i)).f158e, i));
    }
}
