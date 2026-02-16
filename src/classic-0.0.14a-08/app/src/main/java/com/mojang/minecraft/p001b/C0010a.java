package com.mojang.minecraft.p001b;

import org.lwjgl.input.Keyboard;

/* JADX INFO: renamed from: com.mojang.minecraft.b.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/a.class */
public final class C0010a extends C0012c {

    /* JADX INFO: renamed from: e */
    private C0012c f70e;

    /* JADX INFO: renamed from: g */
    private int f72g;

    /* JADX INFO: renamed from: h */
    private String f73h;

    /* JADX INFO: renamed from: f */
    private String f71f = "Enter level name:";

    /* JADX INFO: renamed from: i */
    private int f74i = 0;

    public C0010a(C0012c c0012c, String str, int i) {
        this.f70e = c0012c;
        this.f72g = i;
        this.f73h = str;
        if (this.f73h.equals("-")) {
            this.f73h = "";
        }
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo29a() {
        this.f78d.clear();
        Keyboard.enableRepeatEvents(true);
        this.f78d.add(new C0013d(0, (this.f76b / 2) - 100, (this.f77c / 4) + 120, 200, 20, "Save"));
        this.f78d.add(new C0013d(1, (this.f76b / 2) - 100, (this.f77c / 4) + 144, 200, 20, "Cancel"));
        ((C0013d) this.f78d.get(0)).f85g = this.f73h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: b */
    public final void mo30b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: c */
    public final void mo31c() {
        this.f74i++;
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    protected final void mo32a(C0013d c0013d) {
        if (c0013d.f85g) {
            if (c0013d.f84f == 0 && this.f73h.trim().length() > 1) {
                this.f75a.m62a(this.f72g, this.f73h.trim());
                this.f75a.m46a((C0012c) null);
                this.f75a.m50c();
            }
            if (c0013d.f84f == 1) {
                this.f75a.m46a(this.f70e);
            }
        }
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    protected final void mo33a(char c, int i) {
        if (i == 14 && this.f73h.length() > 0) {
            this.f73h = this.f73h.substring(0, this.f73h.length() - 1);
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-_'*!\"#%/()=+?[]{}<>".indexOf(c) >= 0) {
            this.f73h += c;
        }
        ((C0013d) this.f78d.get(0)).f85g = this.f73h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo34a(int i, int i2) {
        m37a(0, 0, this.f76b, this.f77c, 1610941696, -1607454624);
        m38a(this.f71f, this.f76b / 2, 40, 16777215);
        int i3 = (this.f76b / 2) - 100;
        int i4 = (this.f77c / 2) - 10;
        m36a(i3 - 1, i4 - 1, i3 + 200 + 1, i4 + 20 + 1, -6250336);
        m36a(i3, i4, i3 + 200, i4 + 20, -16777216);
        m39b(this.f73h + ((this.f74i / 6) % 2 == 0 ? "_" : ""), i3 + 4, i4 + 6, 14737632);
        super.mo34a(i, i2);
    }
}
