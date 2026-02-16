package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0033e;
import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p004b.C0020b;
import com.mojang.minecraft.p008f.C0041a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.c */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/c.class */
public final class C0014c {

    /* JADX INFO: renamed from: a */
    public C0041a f45a;

    /* JADX INFO: renamed from: e */
    private C0017f f46e;

    /* JADX INFO: renamed from: f */
    private int f47f;

    /* JADX INFO: renamed from: g */
    private int f48g;

    /* JADX INFO: renamed from: h */
    private int f49h;

    /* JADX INFO: renamed from: i */
    private int f50i;

    /* JADX INFO: renamed from: j */
    private int f51j;

    /* JADX INFO: renamed from: k */
    private int f52k;

    /* JADX INFO: renamed from: l */
    private float f53l;

    /* JADX INFO: renamed from: m */
    private float f54m;

    /* JADX INFO: renamed from: n */
    private float f55n;

    /* JADX INFO: renamed from: o */
    private boolean f56o = true;

    /* JADX INFO: renamed from: p */
    private int f57p;

    /* JADX INFO: renamed from: b */
    public boolean f58b;

    /* JADX INFO: renamed from: c */
    public boolean f59c;

    /* JADX INFO: renamed from: q */
    private static C0020b f60q = C0020b.f104a;

    /* JADX INFO: renamed from: d */
    public static int f61d = 0;

    /* JADX INFO: renamed from: r */
    private static int f62r = 0;

    public C0014c(C0017f c0017f, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f57p = -1;
        this.f46e = c0017f;
        this.f47f = i;
        this.f48g = i2;
        this.f49h = i3;
        this.f50i = i4;
        this.f51j = i5;
        this.f52k = i6;
        this.f53l = (i + i4) / 2.0f;
        this.f54m = (i2 + i5) / 2.0f;
        this.f55n = (i3 + i6) / 2.0f;
        this.f45a = new C0041a(i, i2, i3, i4, i5, i6);
        this.f57p = GL11.glGenLists(3);
    }

    /* JADX INFO: renamed from: b */
    private void m33b(int i) {
        GL11.glNewList(this.f57p + i, 4864);
        f60q.m58b();
        int i2 = 0;
        boolean zMo8a = false;
        for (int i3 = this.f47f; i3 < this.f50i; i3++) {
            for (int i4 = this.f48g; i4 < this.f51j; i4++) {
                for (int i5 = this.f49h; i5 < this.f52k; i5++) {
                    int iM53b = this.f46e.m53b(i3, i4, i5);
                    if (iM53b > 0) {
                        zMo8a |= C0002a.f10a[iM53b].mo8a(f60q, this.f46e, i, i3, i4, i5);
                        i2++;
                    }
                }
            }
        }
        if (zMo8a) {
            this.f59c = false;
        }
        f60q.m56a();
        GL11.glEndList();
        if (i2 > 0) {
            f62r++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m34a() {
        this.f59c = true;
        f61d++;
        m33b(0);
        m33b(1);
        m33b(2);
        this.f56o = false;
    }

    /* JADX INFO: renamed from: a */
    public final int m35a(int i) {
        return this.f57p + i;
    }

    /* JADX INFO: renamed from: b */
    public final void m36b() {
        if (!this.f56o) {
            System.currentTimeMillis();
        }
        this.f56o = true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m37c() {
        return this.f56o;
    }

    /* JADX INFO: renamed from: a */
    public final float m38a(C0033e c0033e) {
        float f = c0033e.f234h - this.f53l;
        float f2 = c0033e.f235i - this.f54m;
        float f3 = c0033e.f236j - this.f55n;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    /* JADX INFO: renamed from: d */
    public final void m39d() {
        this.f56o = true;
        for (int i = 0; i < 3; i++) {
            GL11.glNewList(this.f57p + i, 4864);
            GL11.glEndList();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m40e() {
        GL11.glDeleteLists(this.f57p, 3);
    }
}
