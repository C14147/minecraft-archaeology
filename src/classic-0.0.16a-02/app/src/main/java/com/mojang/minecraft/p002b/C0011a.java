package com.mojang.minecraft.p002b;

import org.lwjgl.input.Keyboard;

/* JADX INFO: renamed from: com.mojang.minecraft.b.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/a.class */
public final class C0011a extends C0014d {

    /* JADX INFO: renamed from: e */
    private C0014d f74e;

    /* JADX INFO: renamed from: g */
    private int f76g;

    /* JADX INFO: renamed from: h */
    private String f77h;

    /* JADX INFO: renamed from: f */
    private String f75f = "Enter level name:";

    /* JADX INFO: renamed from: i */
    private int f78i = 0;

    public C0011a(C0014d c0014d, String str, int i) {
        this.f74e = c0014d;
        this.f76g = i;
        this.f77h = str;
        if (this.f77h.equals("-")) {
            this.f77h = "";
        }
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo33a() {
        this.f84d.clear();
        Keyboard.enableRepeatEvents(true);
        this.f84d.add(new C0015e(0, (this.f82b / 2) - 100, (this.f83c / 4) + 120, 200, 20, "Save"));
        this.f84d.add(new C0015e(1, (this.f82b / 2) - 100, (this.f83c / 4) + 144, 200, 20, "Cancel"));
        ((C0015e) this.f84d.get(0)).f91g = this.f77h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: b */
    public final void mo34b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: c */
    public final void mo35c() {
        this.f78i++;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo36a(C0015e c0015e) {
        if (c0015e.f91g) {
            if (c0015e.f90f == 0 && this.f77h.trim().length() > 1) {
                this.f81a.m76a(this.f76g, this.f77h.trim());
                this.f81a.m57a((C0014d) null);
                this.f81a.m61c();
            }
            if (c0015e.f90f == 1) {
                this.f81a.m57a(this.f74e);
            }
        }
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo37a(char c, int i) {
        if (i == 14 && this.f77h.length() > 0) {
            this.f77h = this.f77h.substring(0, this.f77h.length() - 1);
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-_'*!\"#%/()=+?[]{}<>".indexOf(c) >= 0 && this.f77h.length() < 64) {
            this.f77h += c;
        }
        ((C0015e) this.f84d.get(0)).f91g = this.f77h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo38a(int i, int i2) {
        m41a(0, 0, this.f82b, this.f83c, 1610941696, -1607454624);
        m42a(this.f75f, this.f82b / 2, 40, 16777215);
        int i3 = (this.f82b / 2) - 100;
        int i4 = (this.f83c / 2) - 10;
        m40a(i3 - 1, i4 - 1, i3 + 200 + 1, i4 + 20 + 1, -6250336);
        m40a(i3, i4, i3 + 200, i4 + 20, -16777216);
        m43b(this.f77h + ((this.f78i / 6) % 2 == 0 ? "_" : ""), i3 + 4, i4 + 6, 14737632);
        super.mo38a(i, i2);
    }
}
