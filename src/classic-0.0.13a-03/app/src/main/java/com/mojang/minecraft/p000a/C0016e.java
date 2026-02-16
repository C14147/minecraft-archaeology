package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0033e;
import com.mojang.minecraft.C0040f;
import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p004b.C0019a;
import com.mojang.minecraft.p004b.C0020b;
import java.nio.IntBuffer;
import java.util.Arrays;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.e */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/e.class */
public final class C0016e {

    /* JADX INFO: renamed from: a */
    public C0017f f64a;

    /* JADX INFO: renamed from: b */
    public C0014c[] f65b;

    /* JADX INFO: renamed from: e */
    private C0014c[] f66e;

    /* JADX INFO: renamed from: f */
    private int f67f;

    /* JADX INFO: renamed from: g */
    private int f68g;

    /* JADX INFO: renamed from: h */
    private int f69h;

    /* JADX INFO: renamed from: i */
    private C0019a f70i;

    /* JADX INFO: renamed from: c */
    public int f71c;

    /* JADX INFO: renamed from: d */
    public int f72d = 0;

    /* JADX INFO: renamed from: j */
    private IntBuffer f73j = BufferUtils.createIntBuffer(1024);

    /* JADX INFO: renamed from: k */
    private float f74k = 0.0f;

    /* JADX INFO: renamed from: l */
    private float f75l = 0.0f;

    /* JADX INFO: renamed from: m */
    private float f76m = 0.0f;

    public C0016e(C0017f c0017f, C0019a c0019a) {
        this.f64a = c0017f;
        this.f70i = c0019a;
        c0017f.f82e.add(this);
        this.f71c = GL11.glGenLists(2);
        m41a();
    }

    /* JADX INFO: renamed from: a */
    public final void m41a() {
        this.f74k = -900000.0f;
        this.f75l = -900000.0f;
        this.f76m = -900000.0f;
        if (this.f65b != null) {
            for (int i = 0; i < this.f65b.length; i++) {
                this.f65b[i].m40e();
            }
        }
        this.f67f = ((this.f64a.f77a + 16) - 1) / 16;
        this.f68g = ((this.f64a.f79c + 16) - 1) / 16;
        this.f69h = ((this.f64a.f78b + 16) - 1) / 16;
        this.f65b = new C0014c[this.f67f * this.f68g * this.f69h];
        this.f66e = new C0014c[this.f67f * this.f68g * this.f69h];
        for (int i2 = 0; i2 < this.f67f; i2++) {
            for (int i3 = 0; i3 < this.f68g; i3++) {
                for (int i4 = 0; i4 < this.f69h; i4++) {
                    int i5 = i2 << 4;
                    int i6 = i3 << 4;
                    int i7 = i4 << 4;
                    int i8 = (i2 + 1) << 4;
                    int i9 = (i3 + 1) << 4;
                    int i10 = (i4 + 1) << 4;
                    if (i8 > this.f64a.f77a) {
                        i8 = this.f64a.f77a;
                    }
                    if (i9 > this.f64a.f79c) {
                        i9 = this.f64a.f79c;
                    }
                    if (i10 > this.f64a.f78b) {
                        i10 = this.f64a.f78b;
                    }
                    this.f65b[((i2 + (i3 * this.f67f)) * this.f69h) + i4] = new C0014c(this.f64a, i5, i6, i7, i8, i9, i10);
                    this.f66e[((i2 + (i3 * this.f67f)) * this.f69h) + i4] = this.f65b[((i2 + (i3 * this.f67f)) * this.f69h) + i4];
                }
            }
        }
        GL11.glNewList(this.f71c, 4864);
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f70i.m55a("/rock.png", 9728));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        C0020b c0020b = C0020b.f104a;
        float f = 32.0f - 2.0f;
        int i11 = 128 > this.f64a.f77a ? this.f64a.f77a : 128;
        if (i11 > this.f64a.f78b) {
            i11 = this.f64a.f78b;
        }
        int i12 = 2048 / i11;
        c0020b.m58b();
        int i13 = (-i11) * i12;
        while (true) {
            int i14 = i13;
            if (i14 >= this.f64a.f77a + (i11 * i12)) {
                break;
            }
            int i15 = (-i11) * i12;
            while (true) {
                int i16 = i15;
                if (i16 < this.f64a.f78b + (i11 * i12)) {
                    float f2 = f;
                    if (i14 >= 0 && i16 >= 0 && i14 < this.f64a.f77a && i16 < this.f64a.f78b) {
                        f2 = 0.0f;
                    }
                    c0020b.m61a(i14, f2, i16 + i11, 0.0f, i11);
                    c0020b.m61a(i14 + i11, f2, i16 + i11, i11, i11);
                    c0020b.m61a(i14 + i11, f2, i16, i11, 0.0f);
                    c0020b.m61a(i14, f2, i16, 0.0f, 0.0f);
                    i15 = i16 + i11;
                }
            }
            i13 = i14 + i11;
        }
        c0020b.m56a();
        GL11.glBindTexture(3553, this.f70i.m55a("/rock.png", 9728));
        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        c0020b.m58b();
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= this.f64a.f77a) {
                break;
            }
            c0020b.m61a(i18, 0.0f, 0.0f, 0.0f, 0.0f);
            c0020b.m61a(i18 + i11, 0.0f, 0.0f, i11, 0.0f);
            c0020b.m61a(i18 + i11, f, 0.0f, i11, f);
            c0020b.m61a(i18, f, 0.0f, 0.0f, f);
            c0020b.m61a(i18, f, this.f64a.f78b, 0.0f, f);
            c0020b.m61a(i18 + i11, f, this.f64a.f78b, i11, f);
            c0020b.m61a(i18 + i11, 0.0f, this.f64a.f78b, i11, 0.0f);
            c0020b.m61a(i18, 0.0f, this.f64a.f78b, 0.0f, 0.0f);
            i17 = i18 + i11;
        }
        GL11.glColor3f(0.6f, 0.6f, 0.6f);
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= this.f64a.f78b) {
                break;
            }
            c0020b.m61a(0.0f, f, i20, 0.0f, 0.0f);
            c0020b.m61a(0.0f, f, i20 + i11, i11, 0.0f);
            c0020b.m61a(0.0f, 0.0f, i20 + i11, i11, f);
            c0020b.m61a(0.0f, 0.0f, i20, 0.0f, f);
            c0020b.m61a(this.f64a.f77a, 0.0f, i20, 0.0f, f);
            c0020b.m61a(this.f64a.f77a, 0.0f, i20 + i11, i11, f);
            c0020b.m61a(this.f64a.f77a, f, i20 + i11, i11, 0.0f);
            c0020b.m61a(this.f64a.f77a, f, i20, 0.0f, 0.0f);
            i19 = i20 + i11;
        }
        c0020b.m56a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glEndList();
        GL11.glNewList(this.f71c + 1, 4864);
        GL11.glEnable(3553);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.f70i.m55a("/water.png", 9728));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        C0020b c0020b2 = C0020b.f104a;
        int i21 = 128 > this.f64a.f77a ? this.f64a.f77a : 128;
        if (i21 > this.f64a.f78b) {
            i21 = this.f64a.f78b;
        }
        int i22 = 2048 / i21;
        c0020b2.m58b();
        int i23 = (-i21) * i22;
        while (true) {
            int i24 = i23;
            if (i24 >= this.f64a.f77a + (i21 * i22)) {
                break;
            }
            int i25 = (-i21) * i22;
            while (true) {
                int i26 = i25;
                if (i26 < this.f64a.f78b + (i21 * i22)) {
                    float f3 = 32.0f - 0.1f;
                    if (i24 < 0 || i26 < 0 || i24 >= this.f64a.f77a || i26 >= this.f64a.f78b) {
                        c0020b2.m61a(i24, f3, i26 + i21, 0.0f, i21);
                        c0020b2.m61a(i24 + i21, f3, i26 + i21, i21, i21);
                        c0020b2.m61a(i24 + i21, f3, i26, i21, 0.0f);
                        c0020b2.m61a(i24, f3, i26, 0.0f, 0.0f);
                        c0020b2.m61a(i24, f3, i26, 0.0f, 0.0f);
                        c0020b2.m61a(i24 + i21, f3, i26, i21, 0.0f);
                        c0020b2.m61a(i24 + i21, f3, i26 + i21, i21, i21);
                        c0020b2.m61a(i24, f3, i26 + i21, 0.0f, i21);
                    }
                    i25 = i26 + i21;
                }
            }
            i23 = i24 + i21;
        }
        c0020b2.m56a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glEndList();
        for (int i27 = 0; i27 < this.f65b.length; i27++) {
            this.f65b[i27].m39d();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m42a(C0033e c0033e, int i) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f70i.m55a("/terrain.png", 9728));
        float f = c0033e.f234h - this.f74k;
        float f2 = c0033e.f235i - this.f75l;
        float f3 = c0033e.f236j - this.f76m;
        if ((f * f) + (f2 * f2) + (f3 * f3) > 64.0f) {
            this.f74k = c0033e.f234h;
            this.f75l = c0033e.f235i;
            this.f76m = c0033e.f236j;
            Arrays.sort(this.f66e, new C0015d(c0033e));
        }
        this.f73j.clear();
        for (int i2 = 0; i2 < this.f66e.length; i2++) {
            if (this.f66e[i2].f58b && !this.f66e[i2].f59c) {
                float f4 = 256 / (1 << this.f72d);
                if (this.f72d == 0 || this.f66e[i2].m38a(c0033e) < f4 * f4) {
                    this.f73j.put(this.f66e[i2].m35a(i));
                    if (this.f73j.remaining() == 0) {
                        this.f73j.flip();
                        GL11.glCallLists(this.f73j);
                        this.f73j.clear();
                    }
                }
            }
        }
        if (this.f73j.position() > 0) {
            this.f73j.flip();
            GL11.glCallLists(this.f73j);
        }
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: a */
    public final void m43a(C0033e c0033e, C0040f c0040f, int i, int i2) {
        C0020b c0020b = C0020b.f104a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, ((((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f) * 0.5f);
        if (i == 0) {
            c0020b.m58b();
            for (int i3 = 0; i3 < 6; i3++) {
                C0002a.m13a(c0033e, c0020b, c0040f.f219a, c0040f.f220b, c0040f.f221c, i3);
            }
            c0020b.m56a();
        } else {
            GL11.glBlendFunc(770, 771);
            float fSin = (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.8f;
            GL11.glColor4f(fSin, fSin, fSin, (((float) Math.sin(System.currentTimeMillis() / 200.0d)) * 0.2f) + 0.5f);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.f70i.m55a("/terrain.png", 9728));
            int i4 = c0040f.f219a;
            int i5 = c0040f.f220b;
            int i6 = c0040f.f221c;
            if (c0040f.f222d == 0) {
                i5--;
            }
            if (c0040f.f222d == 1) {
                i5++;
            }
            if (c0040f.f222d == 2) {
                i6--;
            }
            if (c0040f.f222d == 3) {
                i6++;
            }
            if (c0040f.f222d == 4) {
                i4--;
            }
            if (c0040f.f222d == 5) {
                i4++;
            }
            c0020b.m58b();
            c0020b.m64c();
            C0002a.f10a[i2].mo8a(c0020b, this.f64a, 0, i4, i5, i6);
            C0002a.f10a[i2].mo8a(c0020b, this.f64a, 1, i4, i5, i6);
            c0020b.m56a();
            GL11.glDisable(3553);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    /* JADX INFO: renamed from: a */
    public static void m44a(C0040f c0040f, int i) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
        float f = c0040f.f219a;
        float f2 = c0040f.f220b;
        float f3 = c0040f.f221c;
        if (i == 1) {
            if (c0040f.f222d == 0) {
                f2 -= 1.0f;
            }
            if (c0040f.f222d == 1) {
                f2 += 1.0f;
            }
            if (c0040f.f222d == 2) {
                f3 -= 1.0f;
            }
            if (c0040f.f222d == 3) {
                f3 += 1.0f;
            }
            if (c0040f.f222d == 4) {
                f -= 1.0f;
            }
            if (c0040f.f222d == 5) {
                f += 1.0f;
            }
        }
        GL11.glBegin(3);
        GL11.glVertex3f(f, f2, f3);
        GL11.glVertex3f(f + 1.0f, f2, f3);
        GL11.glVertex3f(f + 1.0f, f2, f3 + 1.0f);
        GL11.glVertex3f(f, f2, f3 + 1.0f);
        GL11.glVertex3f(f, f2, f3);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glVertex3f(f, f2 + 1.0f, f3);
        GL11.glVertex3f(f + 1.0f, f2 + 1.0f, f3);
        GL11.glVertex3f(f + 1.0f, f2 + 1.0f, f3 + 1.0f);
        GL11.glVertex3f(f, f2 + 1.0f, f3 + 1.0f);
        GL11.glVertex3f(f, f2 + 1.0f, f3);
        GL11.glEnd();
        GL11.glBegin(1);
        GL11.glVertex3f(f, f2, f3);
        GL11.glVertex3f(f, f2 + 1.0f, f3);
        GL11.glVertex3f(f + 1.0f, f2, f3);
        GL11.glVertex3f(f + 1.0f, f2 + 1.0f, f3);
        GL11.glVertex3f(f + 1.0f, f2, f3 + 1.0f);
        GL11.glVertex3f(f + 1.0f, f2 + 1.0f, f3 + 1.0f);
        GL11.glVertex3f(f, f2, f3 + 1.0f);
        GL11.glVertex3f(f, f2 + 1.0f, f3 + 1.0f);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    public final void m45a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i / 16;
        int i8 = i4 / 16;
        int i9 = i2 / 16;
        int i10 = i5 / 16;
        int i11 = i3 / 16;
        int i12 = i6 / 16;
        if (i7 < 0) {
            i7 = 0;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i8 >= this.f67f) {
            i8 = this.f67f - 1;
        }
        if (i10 >= this.f68g) {
            i10 = this.f68g - 1;
        }
        if (i12 >= this.f69h) {
            i12 = this.f69h - 1;
        }
        for (int i13 = i7; i13 <= i8; i13++) {
            for (int i14 = i9; i14 <= i10; i14++) {
                for (int i15 = i11; i15 <= i12; i15++) {
                    this.f65b[((i13 + (i14 * this.f67f)) * this.f69h) + i15].m36b();
                }
            }
        }
    }
}
