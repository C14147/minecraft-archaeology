package com.mojang.minecraft.p002b;

/* JADX INFO: renamed from: com.mojang.minecraft.b.i */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/i.class */
public final class C0019i extends RunnableC0017g {
    public C0019i(C0014d c0014d) {
        super(c0014d);
        this.f99e = "Save level";
    }

    @Override // com.mojang.minecraft.p002b.RunnableC0017g
    /* JADX INFO: renamed from: a */
    protected final void mo45a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0015e) this.f84d.get(i)).f89e = strArr[i];
            ((C0015e) this.f84d.get(i)).f92h = true;
        }
    }

    @Override // com.mojang.minecraft.p002b.RunnableC0017g
    /* JADX INFO: renamed from: a */
    protected final void mo46a(int i) {
        this.f81a.m57a(new C0011a(this, ((C0015e) this.f84d.get(i)).f89e, i));
    }
}
