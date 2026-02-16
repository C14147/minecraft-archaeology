package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p008f.C0041a;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.mojang.minecraft.g */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/g.class */
public class C0042g {

    /* JADX INFO: renamed from: a */
    private C0017f f230a;

    /* JADX INFO: renamed from: e */
    public float f231e;

    /* JADX INFO: renamed from: f */
    public float f232f;

    /* JADX INFO: renamed from: g */
    public float f233g;

    /* JADX INFO: renamed from: h */
    public float f234h;

    /* JADX INFO: renamed from: i */
    public float f235i;

    /* JADX INFO: renamed from: j */
    public float f236j;

    /* JADX INFO: renamed from: k */
    public float f237k;

    /* JADX INFO: renamed from: l */
    public float f238l;

    /* JADX INFO: renamed from: m */
    public float f239m;

    /* JADX INFO: renamed from: n */
    public float f240n;

    /* JADX INFO: renamed from: o */
    public float f241o;

    /* JADX INFO: renamed from: p */
    public C0041a f242p;

    /* JADX INFO: renamed from: q */
    public boolean f243q = false;

    /* JADX INFO: renamed from: r */
    public boolean f244r = false;

    /* JADX INFO: renamed from: s */
    public boolean f245s = false;

    /* JADX INFO: renamed from: t */
    public float f246t = 0.0f;

    /* JADX INFO: renamed from: b */
    private float f247b = 0.6f;

    /* JADX INFO: renamed from: u */
    public float f248u = 1.8f;

    public C0042g(C0017f c0017f) {
        this.f230a = c0017f;
        m112b();
    }

    /* JADX INFO: renamed from: b */
    protected final void m112b() {
        m114a((((float) Math.random()) * (this.f230a.f77a - 2)) + 1.0f, this.f230a.f79c + 10, (((float) Math.random()) * (this.f230a.f78b - 2)) + 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public final void m113a(float f, float f2) {
        this.f247b = f;
        this.f248u = f2;
    }

    /* JADX INFO: renamed from: a */
    public final void m114a(float f, float f2, float f3) {
        this.f234h = f;
        this.f235i = f2;
        this.f236j = f3;
        float f4 = this.f247b / 2.0f;
        float f5 = this.f248u / 2.0f;
        this.f242p = new C0041a(f - f4, f2 - f5, f3 - f4, f + f4, f2 + f5, f3 + f4);
    }

    /* JADX INFO: renamed from: a */
    public void mo102a() {
        this.f231e = this.f234h;
        this.f232f = this.f235i;
        this.f233g = this.f236j;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m115b(float f, float f2, float f3) {
        boolean z;
        C0041a c0041a = this.f242p;
        if (this.f230a.m48a(new C0041a(c0041a.f224a + f3, c0041a.f225b + f2, c0041a.f226c + f3, c0041a.f227d + f, c0041a.f228e + f2, c0041a.f229f + f3)).size() > 0) {
            return false;
        }
        C0017f c0017f = this.f230a;
        int iFloor = (int) Math.floor(r0.f224a);
        int iFloor2 = (int) Math.floor(r0.f227d + 1.0f);
        int iFloor3 = (int) Math.floor(r0.f225b);
        int iFloor4 = (int) Math.floor(r0.f228e + 1.0f);
        int iFloor5 = (int) Math.floor(r0.f226c);
        int iFloor6 = (int) Math.floor(r0.f229f + 1.0f);
        if (iFloor < 0) {
            iFloor = 0;
        }
        if (iFloor3 < 0) {
            iFloor3 = 0;
        }
        if (iFloor5 < 0) {
            iFloor5 = 0;
        }
        if (iFloor2 > c0017f.f77a) {
            iFloor2 = c0017f.f77a;
        }
        if (iFloor4 > c0017f.f79c) {
            iFloor4 = c0017f.f79c;
        }
        if (iFloor6 > c0017f.f78b) {
            iFloor6 = c0017f.f78b;
        }
        int i = iFloor;
        loop0: while (true) {
            if (i >= iFloor2) {
                z = false;
                break;
            }
            for (int i2 = iFloor3; i2 < iFloor4; i2++) {
                for (int i3 = iFloor5; i3 < iFloor6; i3++) {
                    C0002a c0002a = C0002a.f10a[c0017f.m53b(i, i2, i3)];
                    if (c0002a != null && c0002a.mo21d() > 0) {
                        z = true;
                        break loop0;
                    }
                }
            }
            i++;
        }
        return !z;
    }

    /* JADX INFO: renamed from: c */
    public final void m116c(float f, float f2, float f3) {
        C0017f c0017f = this.f230a;
        C0041a c0041a = this.f242p;
        float f4 = c0041a.f224a;
        float f5 = c0041a.f225b;
        float f6 = c0041a.f226c;
        float f7 = c0041a.f227d;
        float f8 = c0041a.f228e;
        float f9 = c0041a.f229f;
        if (f < 0.0f) {
            f4 += f;
        }
        if (f > 0.0f) {
            f7 += f;
        }
        if (f2 < 0.0f) {
            f5 += f2;
        }
        if (f2 > 0.0f) {
            f8 += f2;
        }
        if (f3 < 0.0f) {
            f6 += f3;
        }
        if (f3 > 0.0f) {
            f9 += f3;
        }
        ArrayList arrayListM48a = c0017f.m48a(new C0041a(f4, f5, f6, f7, f8, f9));
        for (int i = 0; i < arrayListM48a.size(); i++) {
            C0041a c0041a2 = (C0041a) arrayListM48a.get(i);
            C0041a c0041a3 = this.f242p;
            float f10 = f2;
            if (c0041a3.f227d > c0041a2.f224a && c0041a3.f224a < c0041a2.f227d && c0041a3.f229f > c0041a2.f226c && c0041a3.f226c < c0041a2.f229f) {
                if (f10 > 0.0f && c0041a3.f228e <= c0041a2.f225b) {
                    float f11 = c0041a2.f225b - c0041a3.f228e;
                    if (f11 < f10) {
                        f10 = f11;
                    }
                }
                if (f10 < 0.0f && c0041a3.f225b >= c0041a2.f228e) {
                    float f12 = c0041a2.f228e - c0041a3.f225b;
                    if (f12 > f10) {
                        f10 = f12;
                    }
                }
            }
            f2 = f10;
        }
        this.f242p.m111b(0.0f, f2, 0.0f);
        for (int i2 = 0; i2 < arrayListM48a.size(); i2++) {
            C0041a c0041a4 = (C0041a) arrayListM48a.get(i2);
            C0041a c0041a5 = this.f242p;
            float f13 = f;
            if (c0041a5.f228e > c0041a4.f225b && c0041a5.f225b < c0041a4.f228e && c0041a5.f229f > c0041a4.f226c && c0041a5.f226c < c0041a4.f229f) {
                if (f13 > 0.0f && c0041a5.f227d <= c0041a4.f224a) {
                    float f14 = c0041a4.f224a - c0041a5.f227d;
                    if (f14 < f13) {
                        f13 = f14;
                    }
                }
                if (f13 < 0.0f && c0041a5.f224a >= c0041a4.f227d) {
                    float f15 = c0041a4.f227d - c0041a5.f224a;
                    if (f15 > f13) {
                        f13 = f15;
                    }
                }
            }
            f = f13;
        }
        this.f242p.m111b(f, 0.0f, 0.0f);
        for (int i3 = 0; i3 < arrayListM48a.size(); i3++) {
            C0041a c0041a6 = (C0041a) arrayListM48a.get(i3);
            C0041a c0041a7 = this.f242p;
            float f16 = f3;
            if (c0041a7.f227d > c0041a6.f224a && c0041a7.f224a < c0041a6.f227d && c0041a7.f228e > c0041a6.f225b && c0041a7.f225b < c0041a6.f228e) {
                if (f16 > 0.0f && c0041a7.f229f <= c0041a6.f226c) {
                    float f17 = c0041a6.f226c - c0041a7.f229f;
                    if (f17 < f16) {
                        f16 = f17;
                    }
                }
                if (f16 < 0.0f && c0041a7.f226c >= c0041a6.f229f) {
                    float f18 = c0041a6.f229f - c0041a7.f226c;
                    if (f18 > f16) {
                        f16 = f18;
                    }
                }
            }
            f3 = f16;
        }
        this.f242p.m111b(0.0f, 0.0f, f3);
        this.f244r = (f == f && f3 == f3) ? false : true;
        this.f243q = f2 != f2 && f2 < 0.0f;
        if (f != f) {
            this.f237k = 0.0f;
        }
        if (f2 != f2) {
            this.f238l = 0.0f;
        }
        if (f3 != f3) {
            this.f239m = 0.0f;
        }
        this.f234h = (this.f242p.f224a + this.f242p.f227d) / 2.0f;
        this.f235i = this.f242p.f225b + this.f246t;
        this.f236j = (this.f242p.f226c + this.f242p.f229f) / 2.0f;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m117c() {
        return this.f230a.m54a(this.f242p.m109a(0.0f, -0.4f, 0.0f), 1);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m118d() {
        return this.f230a.m54a(this.f242p, 2);
    }

    /* JADX INFO: renamed from: d */
    public final void m119d(float f, float f2, float f3) {
        float f4 = (f * f) + (f2 * f2);
        if (f4 < 0.01f) {
            return;
        }
        float fSqrt = f3 / ((float) Math.sqrt(f4));
        float f5 = f * fSqrt;
        float f6 = f2 * fSqrt;
        float fSin = (float) Math.sin((((double) this.f240n) * 3.141592653589793d) / 180.0d);
        float fCos = (float) Math.cos((((double) this.f240n) * 3.141592653589793d) / 180.0d);
        this.f237k += (f5 * fCos) - (f6 * fSin);
        this.f239m += (f6 * fCos) + (f5 * fSin);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m120e() {
        return this.f230a.m52a((int) this.f234h, (int) this.f235i, (int) this.f236j);
    }

    /* JADX INFO: renamed from: a */
    public void mo103a(float f) {
    }
}
