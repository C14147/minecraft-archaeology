package com.mojang.minecraft.p002b;

import com.mojang.minecraft.net.C0046a;
import com.mojang.minecraft.net.C0048c;
import org.lwjgl.input.Keyboard;

/* JADX INFO: renamed from: com.mojang.minecraft.b.b */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/b.class */
public final class C0012b extends C0014d {

    /* JADX INFO: renamed from: e */
    private String f79e = "";

    /* JADX INFO: renamed from: f */
    private int f80f = 0;

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo33a() {
        Keyboard.enableRepeatEvents(true);
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: b */
    public final void mo34b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: c */
    public final void mo35c() {
        this.f80f++;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo37a(char c, int i) {
        if (i == 1) {
            this.f81a.m57a((C0014d) null);
            return;
        }
        if (i == 28) {
            C0048c c0048c = this.f81a.f164l;
            String strTrim = this.f79e.trim().trim();
            if (strTrim.length() > 0) {
                c0048c.f282b.m2a(C0046a.f268n, -1, strTrim);
            }
            this.f81a.m57a((C0014d) null);
            return;
        }
        if (i == 14 && this.f79e.length() > 0) {
            this.f79e = this.f79e.substring(0, this.f79e.length() - 1);
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-_'*!\"#%/()=+?[]{}<>".indexOf(c) < 0 || this.f79e.length() >= 64) {
            return;
        }
        this.f79e += c;
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo38a(int i, int i2) {
        m40a(2, this.f83c - 14, this.f82b - 2, this.f83c - 2, Integer.MIN_VALUE);
        m43b("> " + this.f79e + ((this.f80f / 6) % 2 == 0 ? "_" : ""), 4, this.f83c - 12, 14737632);
    }
}
