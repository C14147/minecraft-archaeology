package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.C0033e;
import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p004b.C0020b;
import com.mojang.minecraft.p006d.C0031a;
import com.mojang.minecraft.p006d.C0032b;
import com.mojang.minecraft.p008f.C0041a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a/a.class */
public class C0002a {

    /* JADX INFO: renamed from: a */
    public static final C0002a[] f10a = new C0002a[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f11b = new boolean[256];

    /* JADX INFO: renamed from: c */
    public static final C0002a f12c = new C0002a(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0002a f13d = new C0007f(2);

    /* JADX INFO: renamed from: e */
    public static final C0002a f14e = new C0004c(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0002a f15f;

    /* JADX INFO: renamed from: g */
    public static final C0002a f16g;

    /* JADX INFO: renamed from: h */
    public static final C0002a f17h;

    /* JADX INFO: renamed from: i */
    public static final C0002a f18i;

    /* JADX INFO: renamed from: j */
    public static final C0002a f19j;

    /* JADX INFO: renamed from: k */
    public int f20k;

    /* JADX INFO: renamed from: l */
    public final int f21l;

    /* JADX INFO: renamed from: m */
    private float f22m;

    /* JADX INFO: renamed from: n */
    private float f23n;

    /* JADX INFO: renamed from: o */
    private float f24o;

    /* JADX INFO: renamed from: p */
    private float f25p;

    /* JADX INFO: renamed from: q */
    private float f26q;

    /* JADX INFO: renamed from: r */
    private float f27r;

    protected C0002a(int i) {
        f10a[i] = this;
        this.f21l = i;
        m7a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    protected final void m6a(boolean z) {
        f11b[this.f21l] = z;
    }

    /* JADX INFO: renamed from: a */
    protected final void m7a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f22m = 0.0f;
        this.f23n = f2;
        this.f24o = 0.0f;
        this.f25p = 1.0f;
        this.f26q = f5;
        this.f27r = 1.0f;
    }

    protected C0002a(int i, int i2) {
        this(i);
        this.f20k = i2;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo8a(C0020b c0020b, C0017f c0017f, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (mo9a(c0017f, i2, i3 - 1, i4, i, 0)) {
            c0020b.m60a((byte) -1, (byte) -1, (byte) -1);
            mo11a(c0020b, i2, i3, i4, 0);
            z = true;
        }
        if (mo9a(c0017f, i2, i3 + 1, i4, i, 1)) {
            c0020b.m60a((byte) -1, (byte) -1, (byte) -1);
            mo11a(c0020b, i2, i3, i4, 1);
            z = true;
        }
        if (mo9a(c0017f, i2, i3, i4 - 1, i, 2)) {
            c0020b.m60a((byte) -52, (byte) -52, (byte) -52);
            mo11a(c0020b, i2, i3, i4, 2);
            z = true;
        }
        if (mo9a(c0017f, i2, i3, i4 + 1, i, 3)) {
            c0020b.m60a((byte) -52, (byte) -52, (byte) -52);
            mo11a(c0020b, i2, i3, i4, 3);
            z = true;
        }
        if (mo9a(c0017f, i2 - 1, i3, i4, i, 4)) {
            c0020b.m60a((byte) -103, (byte) -103, (byte) -103);
            mo11a(c0020b, i2, i3, i4, 4);
            z = true;
        }
        if (mo9a(c0017f, i2 + 1, i3, i4, i, 5)) {
            c0020b.m60a((byte) -103, (byte) -103, (byte) -103);
            mo11a(c0020b, i2, i3, i4, 5);
            z = true;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo9a(C0017f c0017f, int i, int i2, int i3, int i4, int i5) {
        boolean zM52a = true;
        if (i4 == 2) {
            return false;
        }
        if (i4 >= 0) {
            zM52a = c0017f.m52a(i, i2, i3) ^ (i4 == 1);
        }
        C0002a c0002a = f10a[c0017f.m53b(i, i2, i3)];
        return !(c0002a == null ? false : c0002a.mo17b()) && zM52a;
    }

    /* JADX INFO: renamed from: a */
    protected int mo10a(int i) {
        return this.f20k;
    }

    /* JADX INFO: renamed from: a */
    public void mo11a(C0020b c0020b, int i, int i2, int i3, int i4) {
        int iMo10a = mo10a(i4);
        int i5 = (iMo10a % 16) << 4;
        int i6 = (iMo10a / 16) << 4;
        float f = i5 / 256.0f;
        float f2 = (i5 + 15.99f) / 256.0f;
        float f3 = i6 / 256.0f;
        float f4 = (i6 + 15.99f) / 256.0f;
        float f5 = i + this.f22m;
        float f6 = i + this.f25p;
        float f7 = i2 + this.f23n;
        float f8 = i2 + this.f26q;
        float f9 = i3 + this.f24o;
        float f10 = i3 + this.f27r;
        if (i4 == 0) {
            c0020b.m61a(f5, f7, f10, f, f4);
            c0020b.m61a(f5, f7, f9, f, f3);
            c0020b.m61a(f6, f7, f9, f2, f3);
            c0020b.m61a(f6, f7, f10, f2, f4);
            return;
        }
        if (i4 == 1) {
            c0020b.m61a(f6, f8, f10, f2, f4);
            c0020b.m61a(f6, f8, f9, f2, f3);
            c0020b.m61a(f5, f8, f9, f, f3);
            c0020b.m61a(f5, f8, f10, f, f4);
            return;
        }
        if (i4 == 2) {
            c0020b.m61a(f5, f8, f9, f2, f3);
            c0020b.m61a(f6, f8, f9, f, f3);
            c0020b.m61a(f6, f7, f9, f, f4);
            c0020b.m61a(f5, f7, f9, f2, f4);
            return;
        }
        if (i4 == 3) {
            c0020b.m61a(f5, f8, f10, f, f3);
            c0020b.m61a(f5, f7, f10, f, f4);
            c0020b.m61a(f6, f7, f10, f2, f4);
            c0020b.m61a(f6, f8, f10, f2, f3);
            return;
        }
        if (i4 == 4) {
            c0020b.m61a(f5, f8, f10, f2, f3);
            c0020b.m61a(f5, f8, f9, f, f3);
            c0020b.m61a(f5, f7, f9, f, f4);
            c0020b.m61a(f5, f7, f10, f2, f4);
            return;
        }
        if (i4 == 5) {
            c0020b.m61a(f6, f7, f10, f, f4);
            c0020b.m61a(f6, f7, f9, f2, f4);
            c0020b.m61a(f6, f8, f9, f2, f3);
            c0020b.m61a(f6, f8, f10, f, f3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m12b(C0020b c0020b, int i, int i2, int i3, int i4) {
        int iMo10a = mo10a(i4);
        float f = (iMo10a % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iMo10a / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        float f5 = i + this.f22m;
        float f6 = i + this.f25p;
        float f7 = i2 + this.f23n;
        float f8 = i2 + this.f26q;
        float f9 = i3 + this.f24o;
        float f10 = i3 + this.f27r;
        if (i4 == 0) {
            c0020b.m61a(f6, f7, f10, f2, f4);
            c0020b.m61a(f6, f7, f9, f2, f3);
            c0020b.m61a(f5, f7, f9, f, f3);
            c0020b.m61a(f5, f7, f10, f, f4);
        }
        if (i4 == 1) {
            c0020b.m61a(f5, f8, f10, f, f4);
            c0020b.m61a(f5, f8, f9, f, f3);
            c0020b.m61a(f6, f8, f9, f2, f3);
            c0020b.m61a(f6, f8, f10, f2, f4);
        }
        if (i4 == 2) {
            c0020b.m61a(f5, f7, f9, f2, f4);
            c0020b.m61a(f6, f7, f9, f, f4);
            c0020b.m61a(f6, f8, f9, f, f3);
            c0020b.m61a(f5, f8, f9, f2, f3);
        }
        if (i4 == 3) {
            c0020b.m61a(f6, f8, f10, f2, f3);
            c0020b.m61a(f6, f7, f10, f2, f4);
            c0020b.m61a(f5, f7, f10, f, f4);
            c0020b.m61a(f5, f8, f10, f, f3);
        }
        if (i4 == 4) {
            c0020b.m61a(f5, f7, f10, f2, f4);
            c0020b.m61a(f5, f7, f9, f, f4);
            c0020b.m61a(f5, f8, f9, f, f3);
            c0020b.m61a(f5, f8, f10, f2, f3);
        }
        if (i4 == 5) {
            c0020b.m61a(f6, f8, f10, f, f3);
            c0020b.m61a(f6, f8, f9, f2, f3);
            c0020b.m61a(f6, f7, f9, f2, f4);
            c0020b.m61a(f6, f7, f10, f, f4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m13a(C0033e c0033e, C0020b c0020b, int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i + 1.0f;
        float f3 = i2;
        float f4 = i2 + 1.0f;
        float f5 = i3;
        float f6 = i3 + 1.0f;
        if (i4 == 0 && i2 > c0033e.f235i) {
            c0020b.m62a(f, f3, f6);
            c0020b.m62a(f, f3, f5);
            c0020b.m62a(f2, f3, f5);
            c0020b.m62a(f2, f3, f6);
        }
        if (i4 == 1 && i2 < c0033e.f235i) {
            c0020b.m62a(f2, f4, f6);
            c0020b.m62a(f2, f4, f5);
            c0020b.m62a(f, f4, f5);
            c0020b.m62a(f, f4, f6);
        }
        if (i4 == 2 && i3 > c0033e.f236j) {
            c0020b.m62a(f, f4, f5);
            c0020b.m62a(f2, f4, f5);
            c0020b.m62a(f2, f3, f5);
            c0020b.m62a(f, f3, f5);
        }
        if (i4 == 3 && i3 < c0033e.f236j) {
            c0020b.m62a(f, f4, f6);
            c0020b.m62a(f, f3, f6);
            c0020b.m62a(f2, f3, f6);
            c0020b.m62a(f2, f4, f6);
        }
        if (i4 == 4 && i > c0033e.f234h) {
            c0020b.m62a(f, f4, f6);
            c0020b.m62a(f, f4, f5);
            c0020b.m62a(f, f3, f5);
            c0020b.m62a(f, f3, f6);
        }
        if (i4 != 5 || i >= c0033e.f234h) {
            return;
        }
        c0020b.m62a(f2, f3, f6);
        c0020b.m62a(f2, f3, f5);
        c0020b.m62a(f2, f4, f5);
        c0020b.m62a(f2, f4, f6);
    }

    /* JADX INFO: renamed from: a */
    public static C0041a m14a(int i, int i2, int i3) {
        return new C0041a(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: b */
    public C0041a mo15b(int i, int i2, int i3) {
        return new C0041a(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo16a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo17b() {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo18c() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo19a(C0017f c0017f, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: a */
    public final void m20a(C0017f c0017f, int i, int i2, int i3, C0031a c0031a) {
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    float f = i + ((i4 + 0.5f) / 4);
                    float f2 = i2 + ((i5 + 0.5f) / 4);
                    float f3 = i3 + ((i6 + 0.5f) / 4);
                    c0031a.f176a.add(new C0032b(c0017f, f, f2, f3, (f - i) - 0.5f, (f2 - i2) - 0.5f, (f3 - i3) - 0.5f, this.f20k));
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public int mo21d() {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public void mo22a(C0017f c0017f, int i, int i2, int i3, int i4) {
    }

    static {
        new C0002a(4, 16);
        new C0002a(5, 4);
        new C0003b(6);
        f15f = new C0002a(7, 17);
        f16g = new C0006e(8, 1);
        f17h = new C0005d(9, 1);
        f18i = new C0006e(10, 2);
        f19j = new C0005d(11, 2);
    }
}
