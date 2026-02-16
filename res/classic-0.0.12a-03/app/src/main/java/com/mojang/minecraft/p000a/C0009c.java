package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0021d;
import com.mojang.minecraft.p000a.p001a.C0003b;
import com.mojang.minecraft.p002b.C0016b;
import com.mojang.minecraft.p006f.C0031a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.c */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/c.class */
public final class C0009c {

    /* JADX INFO: renamed from: a */
    public C0031a f36a;

    /* JADX INFO: renamed from: d */
    private C0013g f37d;

    /* JADX INFO: renamed from: e */
    private int f38e;

    /* JADX INFO: renamed from: f */
    private int f39f;

    /* JADX INFO: renamed from: g */
    private int f40g;

    /* JADX INFO: renamed from: h */
    private int f41h;

    /* JADX INFO: renamed from: i */
    private int f42i;

    /* JADX INFO: renamed from: j */
    private int f43j;

    /* JADX INFO: renamed from: k */
    private float f44k;

    /* JADX INFO: renamed from: l */
    private float f45l;

    /* JADX INFO: renamed from: m */
    private float f46m;

    /* JADX INFO: renamed from: n */
    private boolean f47n = true;

    /* JADX INFO: renamed from: o */
    private int f48o;

    /* JADX INFO: renamed from: b */
    public boolean f49b;

    /* JADX INFO: renamed from: p */
    private static C0016b f50p = C0016b.f97a;

    /* JADX INFO: renamed from: c */
    public static int f51c = 0;

    /* JADX INFO: renamed from: q */
    private static long f52q = 0;

    /* JADX INFO: renamed from: r */
    private static int f53r = 0;

    public C0009c(C0013g c0013g, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f48o = -1;
        this.f37d = c0013g;
        this.f38e = i;
        this.f39f = i2;
        this.f40g = i3;
        this.f41h = i4;
        this.f42i = i5;
        this.f43j = i6;
        this.f44k = (i + i4) / 2.0f;
        this.f45l = (i2 + i5) / 2.0f;
        this.f46m = (i3 + i6) / 2.0f;
        this.f36a = new C0031a(i, i2, i3, i4, i5, i6);
        this.f48o = GL11.glGenLists(3);
    }

    /* JADX INFO: renamed from: b */
    private void m21b(int i) {
        long jNanoTime = System.nanoTime();
        GL11.glNewList(this.f48o + i, 4864);
        f50p.m48b();
        int i2 = 0;
        for (int i3 = this.f38e; i3 < this.f41h; i3++) {
            for (int i4 = this.f39f; i4 < this.f42i; i4++) {
                for (int i5 = this.f40g; i5 < this.f43j; i5++) {
                    int iM42b = this.f37d.m42b(i3, i4, i5);
                    if (iM42b > 0) {
                        C0003b.f13a[iM42b].mo3a(f50p, this.f37d, i, i3, i4, i5);
                        i2++;
                    }
                }
            }
        }
        f50p.m46a();
        GL11.glEndList();
        long jNanoTime2 = System.nanoTime();
        if (i2 > 0) {
            f52q += jNanoTime2 - jNanoTime;
            f53r++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m22a() {
        f51c++;
        m21b(0);
        m21b(1);
        m21b(2);
        this.f47n = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m23a(int i) {
        GL11.glCallList(this.f48o + i);
    }

    /* JADX INFO: renamed from: b */
    public final void m24b() {
        if (!this.f47n) {
            System.currentTimeMillis();
        }
        this.f47n = true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m25c() {
        return this.f47n;
    }

    /* JADX INFO: renamed from: a */
    public final float m26a(C0021d c0021d) {
        float f = c0021d.f185h - this.f44k;
        float f2 = c0021d.f186i - this.f45l;
        float f3 = c0021d.f187j - this.f46m;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    /* JADX INFO: renamed from: d */
    public final void m27d() {
        this.f47n = true;
        for (int i = 0; i < 3; i++) {
            GL11.glNewList(this.f48o + i, 4864);
            GL11.glEndList();
        }
    }
}
