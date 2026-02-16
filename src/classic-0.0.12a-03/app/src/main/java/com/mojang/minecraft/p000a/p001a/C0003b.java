package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.C0021d;
import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p002b.C0016b;
import com.mojang.minecraft.p003c.C0019a;
import com.mojang.minecraft.p003c.C0020b;
import com.mojang.minecraft.p006f.C0031a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/a/b.class */
public class C0003b {

    /* JADX INFO: renamed from: a */
    public static final C0003b[] f13a = new C0003b[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f14b = new boolean[256];

    /* JADX INFO: renamed from: c */
    public static final C0003b f15c = new C0003b(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0003b f16d = new C0007f(2);

    /* JADX INFO: renamed from: e */
    public static final C0003b f17e = new C0004c(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0003b f18f;

    /* JADX INFO: renamed from: g */
    public static final C0003b f19g;

    /* JADX INFO: renamed from: h */
    public static final C0003b f20h;

    /* JADX INFO: renamed from: i */
    public static final C0003b f21i;

    /* JADX INFO: renamed from: j */
    public static final C0003b f22j;

    /* JADX INFO: renamed from: k */
    public int f23k;

    /* JADX INFO: renamed from: l */
    public final int f24l;

    /* JADX INFO: renamed from: m */
    private float f25m;

    /* JADX INFO: renamed from: n */
    private float f26n;

    /* JADX INFO: renamed from: o */
    private float f27o;

    /* JADX INFO: renamed from: p */
    private float f28p;

    /* JADX INFO: renamed from: q */
    private float f29q;

    /* JADX INFO: renamed from: r */
    private float f30r;

    protected C0003b(int i) {
        f13a[i] = this;
        this.f24l = i;
        m8a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    protected final void m7a(boolean z) {
        f14b[this.f24l] = z;
    }

    /* JADX INFO: renamed from: a */
    protected final void m8a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f25m = 0.0f;
        this.f26n = f2;
        this.f27o = 0.0f;
        this.f28p = 1.0f;
        this.f29q = f5;
        this.f30r = 1.0f;
    }

    protected C0003b(int i, int i2) {
        this(i);
        this.f23k = i2;
    }

    /* JADX INFO: renamed from: a */
    public void mo3a(C0016b c0016b, C0013g c0013g, int i, int i2, int i3, int i4) {
        if (mo9a(c0013g, i2, i3 - 1, i4, i)) {
            c0016b.m50a((byte) -1, (byte) -1, (byte) -1);
            mo11a(c0016b, i2, i3, i4, 0);
        }
        if (mo9a(c0013g, i2, i3 + 1, i4, i)) {
            c0016b.m50a((byte) -1, (byte) -1, (byte) -1);
            mo11a(c0016b, i2, i3, i4, 1);
        }
        if (mo9a(c0013g, i2, i3, i4 - 1, i)) {
            c0016b.m50a((byte) -52, (byte) -52, (byte) -52);
            mo11a(c0016b, i2, i3, i4, 2);
        }
        if (mo9a(c0013g, i2, i3, i4 + 1, i)) {
            c0016b.m50a((byte) -52, (byte) -52, (byte) -52);
            mo11a(c0016b, i2, i3, i4, 3);
        }
        if (mo9a(c0013g, i2 - 1, i3, i4, i)) {
            c0016b.m50a((byte) -103, (byte) -103, (byte) -103);
            mo11a(c0016b, i2, i3, i4, 4);
        }
        if (mo9a(c0013g, i2 + 1, i3, i4, i)) {
            c0016b.m50a((byte) -103, (byte) -103, (byte) -103);
            mo11a(c0016b, i2, i3, i4, 5);
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo9a(C0013g c0013g, int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= c0013g.f71a || i2 >= c0013g.f73c || i3 >= c0013g.f72b) {
            return false;
        }
        boolean zM41a = true;
        if (i4 == 2) {
            return false;
        }
        if (i4 >= 0) {
            zM41a = c0013g.m41a(i, i2, i3) ^ (i4 == 1);
        }
        C0003b c0003b = f13a[c0013g.m42b(i, i2, i3)];
        return !(c0003b == null ? false : c0003b.mo6b()) && zM41a;
    }

    /* JADX INFO: renamed from: a */
    protected int mo10a(int i) {
        return this.f23k;
    }

    /* JADX INFO: renamed from: a */
    public void mo11a(C0016b c0016b, int i, int i2, int i3, int i4) {
        int iMo10a = mo10a(i4);
        float f = (iMo10a % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iMo10a / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        float f5 = i + this.f25m;
        float f6 = i + this.f28p;
        float f7 = i2 + this.f26n;
        float f8 = i2 + this.f29q;
        float f9 = i3 + this.f27o;
        float f10 = i3 + this.f30r;
        if (i4 == 0) {
            c0016b.m51a(f5, f7, f10, f, f4);
            c0016b.m51a(f5, f7, f9, f, f3);
            c0016b.m51a(f6, f7, f9, f2, f3);
            c0016b.m51a(f6, f7, f10, f2, f4);
        }
        if (i4 == 1) {
            c0016b.m51a(f6, f8, f10, f2, f4);
            c0016b.m51a(f6, f8, f9, f2, f3);
            c0016b.m51a(f5, f8, f9, f, f3);
            c0016b.m51a(f5, f8, f10, f, f4);
        }
        if (i4 == 2) {
            c0016b.m51a(f5, f8, f9, f2, f3);
            c0016b.m51a(f6, f8, f9, f, f3);
            c0016b.m51a(f6, f7, f9, f, f4);
            c0016b.m51a(f5, f7, f9, f2, f4);
        }
        if (i4 == 3) {
            c0016b.m51a(f5, f8, f10, f, f3);
            c0016b.m51a(f5, f7, f10, f, f4);
            c0016b.m51a(f6, f7, f10, f2, f4);
            c0016b.m51a(f6, f8, f10, f2, f3);
        }
        if (i4 == 4) {
            c0016b.m51a(f5, f8, f10, f2, f3);
            c0016b.m51a(f5, f8, f9, f, f3);
            c0016b.m51a(f5, f7, f9, f, f4);
            c0016b.m51a(f5, f7, f10, f2, f4);
        }
        if (i4 == 5) {
            c0016b.m51a(f6, f7, f10, f, f4);
            c0016b.m51a(f6, f7, f9, f2, f4);
            c0016b.m51a(f6, f8, f9, f2, f3);
            c0016b.m51a(f6, f8, f10, f, f3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m12b(C0016b c0016b, int i, int i2, int i3, int i4) {
        int iMo10a = mo10a(i4);
        float f = (iMo10a % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iMo10a / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        float f5 = i + this.f25m;
        float f6 = i + this.f28p;
        float f7 = i2 + this.f26n;
        float f8 = i2 + this.f29q;
        float f9 = i3 + this.f27o;
        float f10 = i3 + this.f30r;
        if (i4 == 0) {
            c0016b.m51a(f6, f7, f10, f2, f4);
            c0016b.m51a(f6, f7, f9, f2, f3);
            c0016b.m51a(f5, f7, f9, f, f3);
            c0016b.m51a(f5, f7, f10, f, f4);
        }
        if (i4 == 1) {
            c0016b.m51a(f5, f8, f10, f, f4);
            c0016b.m51a(f5, f8, f9, f, f3);
            c0016b.m51a(f6, f8, f9, f2, f3);
            c0016b.m51a(f6, f8, f10, f2, f4);
        }
        if (i4 == 2) {
            c0016b.m51a(f5, f7, f9, f2, f4);
            c0016b.m51a(f6, f7, f9, f, f4);
            c0016b.m51a(f6, f8, f9, f, f3);
            c0016b.m51a(f5, f8, f9, f2, f3);
        }
        if (i4 == 3) {
            c0016b.m51a(f6, f8, f10, f2, f3);
            c0016b.m51a(f6, f7, f10, f2, f4);
            c0016b.m51a(f5, f7, f10, f, f4);
            c0016b.m51a(f5, f8, f10, f, f3);
        }
        if (i4 == 4) {
            c0016b.m51a(f5, f7, f10, f2, f4);
            c0016b.m51a(f5, f7, f9, f, f4);
            c0016b.m51a(f5, f8, f9, f, f3);
            c0016b.m51a(f5, f8, f10, f2, f3);
        }
        if (i4 == 5) {
            c0016b.m51a(f6, f8, f10, f, f3);
            c0016b.m51a(f6, f8, f9, f2, f3);
            c0016b.m51a(f6, f7, f9, f2, f4);
            c0016b.m51a(f6, f7, f10, f, f4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m13a(C0021d c0021d, C0016b c0016b, int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i + 1.0f;
        float f3 = i2;
        float f4 = i2 + 1.0f;
        float f5 = i3;
        float f6 = i3 + 1.0f;
        if (i4 == 0 && i2 > c0021d.f186i) {
            c0016b.m52a(f, f3, f6);
            c0016b.m52a(f, f3, f5);
            c0016b.m52a(f2, f3, f5);
            c0016b.m52a(f2, f3, f6);
        }
        if (i4 == 1 && i2 < c0021d.f186i) {
            c0016b.m52a(f2, f4, f6);
            c0016b.m52a(f2, f4, f5);
            c0016b.m52a(f, f4, f5);
            c0016b.m52a(f, f4, f6);
        }
        if (i4 == 2 && i3 > c0021d.f187j) {
            c0016b.m52a(f, f4, f5);
            c0016b.m52a(f2, f4, f5);
            c0016b.m52a(f2, f3, f5);
            c0016b.m52a(f, f3, f5);
        }
        if (i4 == 3 && i3 < c0021d.f187j) {
            c0016b.m52a(f, f4, f6);
            c0016b.m52a(f, f3, f6);
            c0016b.m52a(f2, f3, f6);
            c0016b.m52a(f2, f4, f6);
        }
        if (i4 == 4 && i > c0021d.f185h) {
            c0016b.m52a(f, f4, f6);
            c0016b.m52a(f, f4, f5);
            c0016b.m52a(f, f3, f5);
            c0016b.m52a(f, f3, f6);
        }
        if (i4 != 5 || i >= c0021d.f185h) {
            return;
        }
        c0016b.m52a(f2, f3, f6);
        c0016b.m52a(f2, f3, f5);
        c0016b.m52a(f2, f4, f5);
        c0016b.m52a(f2, f4, f6);
    }

    /* JADX INFO: renamed from: b */
    public static C0031a m14b(int i, int i2, int i3) {
        return new C0031a(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public C0031a mo4a(int i, int i2, int i3) {
        return new C0031a(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo5a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo6b() {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo15c() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo2a(C0013g c0013g, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: a */
    public final void m16a(C0013g c0013g, int i, int i2, int i3, C0019a c0019a) {
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    float f = i + ((i4 + 0.5f) / 4);
                    float f2 = i2 + ((i5 + 0.5f) / 4);
                    float f3 = i3 + ((i6 + 0.5f) / 4);
                    c0019a.f133a.add(new C0020b(c0013g, f, f2, f3, (f - i) - 0.5f, (f2 - i2) - 0.5f, (f3 - i3) - 0.5f, this.f23k));
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public int mo17d() {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public void mo18b(C0013g c0013g, int i, int i2, int i3, int i4) {
    }

    static {
        new C0003b(4, 16);
        new C0003b(5, 4);
        new C0002a(6);
        f18f = new C0003b(7, 17);
        f19g = new C0006e(8, 1);
        f20h = new C0005d(9, 1);
        f21i = new C0006e(10, 2);
        f22j = new C0005d(11, 2);
    }
}
