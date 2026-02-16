package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p000a.p001a.C0003b;
import com.mojang.minecraft.p006f.C0031a;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.mojang.minecraft.f */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/f.class */
public class C0030f {

    /* JADX INFO: renamed from: a */
    private C0013g f181a;

    /* JADX INFO: renamed from: e */
    public float f182e;

    /* JADX INFO: renamed from: f */
    public float f183f;

    /* JADX INFO: renamed from: g */
    public float f184g;

    /* JADX INFO: renamed from: h */
    public float f185h;

    /* JADX INFO: renamed from: i */
    public float f186i;

    /* JADX INFO: renamed from: j */
    public float f187j;

    /* JADX INFO: renamed from: k */
    public float f188k;

    /* JADX INFO: renamed from: l */
    public float f189l;

    /* JADX INFO: renamed from: m */
    public float f190m;

    /* JADX INFO: renamed from: n */
    public float f191n;

    /* JADX INFO: renamed from: o */
    public float f192o;

    /* JADX INFO: renamed from: p */
    public C0031a f193p;

    /* JADX INFO: renamed from: q */
    public boolean f194q = false;

    /* JADX INFO: renamed from: r */
    public boolean f195r = false;

    /* JADX INFO: renamed from: s */
    public float f196s = 0.0f;

    /* JADX INFO: renamed from: b */
    private float f197b = 0.6f;

    /* JADX INFO: renamed from: t */
    public float f198t = 1.8f;

    public C0030f(C0013g c0013g) {
        this.f181a = c0013g;
        m79b();
    }

    /* JADX INFO: renamed from: b */
    protected final void m79b() {
        m81a(((float) Math.random()) * this.f181a.f71a, this.f181a.f73c + 10, ((float) Math.random()) * this.f181a.f72b);
    }

    /* JADX INFO: renamed from: a */
    public final void m80a(float f, float f2) {
        this.f197b = f;
        this.f198t = f2;
    }

    /* JADX INFO: renamed from: a */
    public final void m81a(float f, float f2, float f3) {
        this.f185h = f;
        this.f186i = f2;
        this.f187j = f3;
        float f4 = this.f197b / 2.0f;
        float f5 = this.f198t / 2.0f;
        this.f193p = new C0031a(f - f4, f2 - f5, f3 - f4, f + f4, f2 + f5, f3 + f4);
    }

    /* JADX INFO: renamed from: a */
    public void mo69a() {
        this.f182e = this.f185h;
        this.f183f = this.f186i;
        this.f184g = this.f187j;
    }

    /* JADX INFO: renamed from: b */
    public final void m82b(float f, float f2, float f3) {
        C0031a c0031aMo4a;
        C0031a c0031aMo4a2;
        C0013g c0013g = this.f181a;
        C0031a c0031a = this.f193p;
        float f4 = c0031a.f200a;
        float f5 = c0031a.f201b;
        float f6 = c0031a.f202c;
        float f7 = c0031a.f203d;
        float f8 = c0031a.f204e;
        float f9 = c0031a.f205f;
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
        C0031a c0031a2 = new C0031a(f4, f5, f6, f7, f8, f9);
        ArrayList arrayList = new ArrayList();
        int iFloor = (int) Math.floor(c0031a2.f200a);
        int iFloor2 = (int) Math.floor(c0031a2.f203d + 1.0f);
        int iFloor3 = (int) Math.floor(c0031a2.f201b);
        int iFloor4 = (int) Math.floor(c0031a2.f204e + 1.0f);
        int iFloor5 = (int) Math.floor(c0031a2.f202c);
        int iFloor6 = (int) Math.floor(c0031a2.f205f + 1.0f);
        for (int i = iFloor; i < iFloor2; i++) {
            for (int i2 = iFloor3; i2 < iFloor4; i2++) {
                for (int i3 = iFloor5; i3 < iFloor6; i3++) {
                    if (i >= 0 && i2 >= 0 && i3 >= 0 && i < c0013g.f71a && i2 < c0013g.f73c && i3 < c0013g.f72b) {
                        C0003b c0003b = C0003b.f13a[c0013g.m42b(i, i2, i3)];
                        if (c0003b != null && (c0031aMo4a2 = c0003b.mo4a(i, i2, i3)) != null) {
                            arrayList.add(c0031aMo4a2);
                        }
                    } else if ((i < 0 || i2 < 0 || i3 < 0 || i >= c0013g.f71a || i3 >= c0013g.f72b) && (c0031aMo4a = C0003b.f18f.mo4a(i, i2, i3)) != null) {
                        arrayList.add(c0031aMo4a);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            C0031a c0031a3 = (C0031a) arrayList.get(i4);
            C0031a c0031a4 = this.f193p;
            float f10 = f2;
            if (c0031a4.f203d > c0031a3.f200a && c0031a4.f200a < c0031a3.f203d && c0031a4.f205f > c0031a3.f202c && c0031a4.f202c < c0031a3.f205f) {
                if (f10 > 0.0f && c0031a4.f204e <= c0031a3.f201b) {
                    float f11 = c0031a3.f201b - c0031a4.f204e;
                    if (f11 < f10) {
                        f10 = f11;
                    }
                }
                if (f10 < 0.0f && c0031a4.f201b >= c0031a3.f204e) {
                    float f12 = c0031a3.f204e - c0031a4.f201b;
                    if (f12 > f10) {
                        f10 = f12;
                    }
                }
            }
            f2 = f10;
        }
        this.f193p.m88a(0.0f, f2, 0.0f);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            C0031a c0031a5 = (C0031a) arrayList.get(i5);
            C0031a c0031a6 = this.f193p;
            float f13 = f;
            if (c0031a6.f204e > c0031a5.f201b && c0031a6.f201b < c0031a5.f204e && c0031a6.f205f > c0031a5.f202c && c0031a6.f202c < c0031a5.f205f) {
                if (f13 > 0.0f && c0031a6.f203d <= c0031a5.f200a) {
                    float f14 = c0031a5.f200a - c0031a6.f203d;
                    if (f14 < f13) {
                        f13 = f14;
                    }
                }
                if (f13 < 0.0f && c0031a6.f200a >= c0031a5.f203d) {
                    float f15 = c0031a5.f203d - c0031a6.f200a;
                    if (f15 > f13) {
                        f13 = f15;
                    }
                }
            }
            f = f13;
        }
        this.f193p.m88a(f, 0.0f, 0.0f);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            C0031a c0031a7 = (C0031a) arrayList.get(i6);
            C0031a c0031a8 = this.f193p;
            float f16 = f3;
            if (c0031a8.f203d > c0031a7.f200a && c0031a8.f200a < c0031a7.f203d && c0031a8.f204e > c0031a7.f201b && c0031a8.f201b < c0031a7.f204e) {
                if (f16 > 0.0f && c0031a8.f205f <= c0031a7.f202c) {
                    float f17 = c0031a7.f202c - c0031a8.f205f;
                    if (f17 < f16) {
                        f16 = f17;
                    }
                }
                if (f16 < 0.0f && c0031a8.f202c >= c0031a7.f205f) {
                    float f18 = c0031a7.f205f - c0031a8.f202c;
                    if (f18 > f16) {
                        f16 = f18;
                    }
                }
            }
            f3 = f16;
        }
        this.f193p.m88a(0.0f, 0.0f, f3);
        this.f194q = f2 != f2 && f2 < 0.0f;
        if (f != f) {
            this.f188k = 0.0f;
        }
        if (f2 != f2) {
            this.f189l = 0.0f;
        }
        if (f3 != f3) {
            this.f190m = 0.0f;
        }
        this.f185h = (this.f193p.f200a + this.f193p.f203d) / 2.0f;
        this.f186i = this.f193p.f201b + this.f196s;
        this.f187j = (this.f193p.f202c + this.f193p.f205f) / 2.0f;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m83c() {
        return this.f181a.m43a(this.f193p, 1);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m84d() {
        return this.f181a.m43a(this.f193p, 2);
    }

    /* JADX INFO: renamed from: c */
    public final void m85c(float f, float f2, float f3) {
        float f4 = (f * f) + (f2 * f2);
        if (f4 < 0.01f) {
            return;
        }
        float fSqrt = f3 / ((float) Math.sqrt(f4));
        float f5 = f * fSqrt;
        float f6 = f2 * fSqrt;
        float fSin = (float) Math.sin((((double) this.f191n) * 3.141592653589793d) / 180.0d);
        float fCos = (float) Math.cos((((double) this.f191n) * 3.141592653589793d) / 180.0d);
        this.f188k += (f5 * fCos) - (f6 * fSin);
        this.f190m += (f6 * fCos) + (f5 * fSin);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m86e() {
        return this.f181a.m41a((int) this.f185h, (int) this.f186i, (int) this.f187j);
    }

    /* JADX INFO: renamed from: a */
    public void mo70a(float f) {
    }
}
