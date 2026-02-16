package com.mojang.minecraft.p005c;

import com.mojang.minecraft.RunnableC0022c;
import org.lwjgl.input.Keyboard;

/* JADX INFO: renamed from: com.mojang.minecraft.c.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c/a.class */
public final class C0023a extends C0026d {

    /* JADX INFO: renamed from: e */
    private C0026d f149e;

    /* JADX INFO: renamed from: g */
    private int f151g;

    /* JADX INFO: renamed from: h */
    private String f152h;

    /* JADX INFO: renamed from: f */
    private String f150f = "Enter level name:";

    /* JADX INFO: renamed from: i */
    private int f153i = 0;

    public C0023a(C0026d c0026d, String str, int i) {
        this.f149e = c0026d;
        this.f151g = i;
        this.f152h = str;
        if (this.f152h.equals("-")) {
            this.f152h = "";
        }
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo84a() {
        Keyboard.enableRepeatEvents(true);
        this.f165d.add(new C0024b(0, (this.f163b / 2) - 100, (this.f164c / 4) + 120, 200, 20, "Save"));
        this.f165d.add(new C0024b(1, (this.f163b / 2) - 100, (this.f164c / 4) + 144, 200, 20, "Cancel"));
        ((C0024b) this.f165d.get(0)).f160g = this.f152h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: b */
    public final void mo85b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: c */
    public final void mo86c() {
        this.f153i++;
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    protected final void mo87a(C0024b c0024b) {
        if (c0024b.f160g) {
            if (c0024b.f159f == 0 && this.f152h.trim().length() > 1) {
                RunnableC0022c runnableC0022c = this.f162a;
                int i = this.f151g;
                runnableC0022c.f136i.m1a(runnableC0022c.f119c, runnableC0022c.f125e, runnableC0022c.f124d.f174a, runnableC0022c.f124d.f175b, this.f152h.trim(), i);
                this.f162a.m68a((C0026d) null);
                this.f162a.m72b();
            }
            if (c0024b.f159f == 1) {
                this.f162a.m68a(this.f149e);
            }
        }
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    protected final void mo88a(char c, int i) {
        if (i == 14 && this.f152h.length() > 0) {
            this.f152h = this.f152h.substring(0, this.f152h.length() - 1);
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-_'*!\"#%/()=+?[]{}<>".indexOf(c) >= 0) {
            this.f152h += c;
        }
        ((C0024b) this.f165d.get(0)).f160g = this.f152h.trim().length() > 1;
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo89a(int i, int i2) {
        m92a(0, 0, this.f163b, this.f164c, 1610941696, -1607454624);
        m93a(this.f150f, this.f163b / 2, 40, 16777215);
        int i3 = (this.f163b / 2) - 100;
        int i4 = (this.f164c / 2) - 10;
        m91a(i3 - 1, i4 - 1, i3 + 200 + 1, i4 + 20 + 1, -6250336);
        m91a(i3, i4, i3 + 200, i4 + 20, -16777216);
        m94b(this.f152h + ((this.f153i / 6) % 2 == 0 ? "_" : ""), i3 + 4, i4 + 6, 14737632);
        super.mo89a(i, i2);
    }
}
