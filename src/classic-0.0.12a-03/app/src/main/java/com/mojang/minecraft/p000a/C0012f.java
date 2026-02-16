package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0021d;
import com.mojang.minecraft.C0028e;
import com.mojang.minecraft.p000a.p001a.C0003b;
import com.mojang.minecraft.p002b.C0015a;
import com.mojang.minecraft.p002b.C0016b;
import java.util.Arrays;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.f */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/f.class */
public final class C0012f {

    /* JADX INFO: renamed from: a */
    public C0013g f59a;

    /* JADX INFO: renamed from: b */
    public C0009c[] f60b;

    /* JADX INFO: renamed from: e */
    private C0009c[] f61e;

    /* JADX INFO: renamed from: f */
    private int f62f;

    /* JADX INFO: renamed from: g */
    private int f63g;

    /* JADX INFO: renamed from: h */
    private int f64h;

    /* JADX INFO: renamed from: i */
    private C0015a f65i;

    /* JADX INFO: renamed from: c */
    public int f66c;

    /* JADX INFO: renamed from: d */
    public int f67d = 0;

    /* JADX INFO: renamed from: j */
    private float f68j = 0.0f;

    /* JADX INFO: renamed from: k */
    private float f69k = 0.0f;

    /* JADX INFO: renamed from: l */
    private float f70l = 0.0f;

    public C0012f(C0013g c0013g, C0015a c0015a) {
        this.f59a = c0013g;
        this.f65i = c0015a;
        c0013g.f76e.add(this);
        this.f62f = ((c0013g.f71a + 16) - 1) / 16;
        this.f63g = ((c0013g.f73c + 16) - 1) / 16;
        this.f64h = ((c0013g.f72b + 16) - 1) / 16;
        this.f60b = new C0009c[this.f62f * this.f63g * this.f64h];
        this.f61e = new C0009c[this.f62f * this.f63g * this.f64h];
        for (int i = 0; i < this.f62f; i++) {
            for (int i2 = 0; i2 < this.f63g; i2++) {
                for (int i3 = 0; i3 < this.f64h; i3++) {
                    int i4 = i << 4;
                    int i5 = i2 << 4;
                    int i6 = i3 << 4;
                    int i7 = (i + 1) << 4;
                    int i8 = (i2 + 1) << 4;
                    int i9 = (i3 + 1) << 4;
                    i7 = i7 > c0013g.f71a ? c0013g.f71a : i7;
                    i8 = i8 > c0013g.f73c ? c0013g.f73c : i8;
                    if (i9 > c0013g.f72b) {
                        i9 = c0013g.f72b;
                    }
                    this.f60b[((i + (i2 * this.f62f)) * this.f64h) + i3] = new C0009c(c0013g, i4, i5, i6, i7, i8, i9);
                    this.f61e[((i + (i2 * this.f62f)) * this.f64h) + i3] = this.f60b[((i + (i2 * this.f62f)) * this.f64h) + i3];
                }
            }
        }
        this.f66c = GL11.glGenLists(2);
        GL11.glNewList(this.f66c, 4864);
        m29b();
        GL11.glEndList();
        GL11.glNewList(this.f66c + 1, 4864);
        m30c();
        GL11.glEndList();
    }

    /* JADX INFO: renamed from: a */
    public final void m28a(C0021d c0021d, int i) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f65i.m45a("/terrain.png", 9728));
        float f = c0021d.f185h - this.f68j;
        float f2 = c0021d.f186i - this.f69k;
        float f3 = c0021d.f187j - this.f70l;
        if ((f * f) + (f2 * f2) + (f3 * f3) > 64.0f) {
            this.f68j = c0021d.f185h;
            this.f69k = c0021d.f186i;
            this.f70l = c0021d.f187j;
            Arrays.sort(this.f61e, new C0011e(c0021d));
        }
        for (int i2 = 0; i2 < this.f61e.length; i2++) {
            if (this.f61e[i2].f49b) {
                float f4 = 256 / (1 << this.f67d);
                if (this.f67d == 0 || this.f61e[i2].m26a(c0021d) < f4 * f4) {
                    this.f61e[i2].m23a(i);
                }
            }
        }
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: b */
    private void m29b() {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f65i.m45a("/rock.png", 9728));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        C0016b c0016b = C0016b.f97a;
        float f = 32.0f - 2.0f;
        c0016b.m48b();
        for (int i = -640; i < this.f59a.f71a + 640; i += 128) {
            for (int i2 = -640; i2 < this.f59a.f72b + 640; i2 += 128) {
                float f2 = f;
                if (i >= 0 && i2 >= 0 && i < this.f59a.f71a && i2 < this.f59a.f72b) {
                    f2 = 0.0f;
                }
                c0016b.m51a(i, f2, i2 + 128, 0.0f, 128);
                c0016b.m51a(i + 128, f2, i2 + 128, 128, 128);
                c0016b.m51a(i + 128, f2, i2, 128, 0.0f);
                c0016b.m51a(i, f2, i2, 0.0f, 0.0f);
            }
        }
        c0016b.m46a();
        GL11.glBindTexture(3553, this.f65i.m45a("/rock.png", 9728));
        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        c0016b.m48b();
        for (int i3 = 0; i3 < this.f59a.f71a; i3 += 128) {
            c0016b.m51a(i3, 0.0f, 0.0f, 0.0f, 0.0f);
            c0016b.m51a(i3 + 128, 0.0f, 0.0f, 128, 0.0f);
            c0016b.m51a(i3 + 128, f, 0.0f, 128, f);
            c0016b.m51a(i3, f, 0.0f, 0.0f, f);
            c0016b.m51a(i3, f, this.f59a.f72b, 0.0f, f);
            c0016b.m51a(i3 + 128, f, this.f59a.f72b, 128, f);
            c0016b.m51a(i3 + 128, 0.0f, this.f59a.f72b, 128, 0.0f);
            c0016b.m51a(i3, 0.0f, this.f59a.f72b, 0.0f, 0.0f);
        }
        GL11.glColor3f(0.6f, 0.6f, 0.6f);
        for (int i4 = 0; i4 < this.f59a.f72b; i4 += 128) {
            c0016b.m51a(0.0f, f, i4, 0.0f, 0.0f);
            c0016b.m51a(0.0f, f, i4 + 128, 128, 0.0f);
            c0016b.m51a(0.0f, 0.0f, i4 + 128, 128, f);
            c0016b.m51a(0.0f, 0.0f, i4, 0.0f, f);
            c0016b.m51a(this.f59a.f71a, 0.0f, i4, 0.0f, f);
            c0016b.m51a(this.f59a.f71a, 0.0f, i4 + 128, 128, f);
            c0016b.m51a(this.f59a.f71a, f, i4 + 128, 128, 0.0f);
            c0016b.m51a(this.f59a.f71a, f, i4, 0.0f, 0.0f);
        }
        c0016b.m46a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: c */
    private void m30c() {
        GL11.glEnable(3553);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.f65i.m45a("/water.png", 9728));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        C0016b c0016b = C0016b.f97a;
        c0016b.m48b();
        for (int i = -640; i < this.f59a.f71a + 640; i += 128) {
            for (int i2 = -640; i2 < this.f59a.f72b + 640; i2 += 128) {
                float f = 32.0f - 0.1f;
                if (i < 0 || i2 < 0 || i >= this.f59a.f71a || i2 >= this.f59a.f72b) {
                    c0016b.m51a(i, f, i2 + 128, 0.0f, 128);
                    c0016b.m51a(i + 128, f, i2 + 128, 128, 128);
                    c0016b.m51a(i + 128, f, i2, 128, 0.0f);
                    c0016b.m51a(i, f, i2, 0.0f, 0.0f);
                    c0016b.m51a(i, f, i2, 0.0f, 0.0f);
                    c0016b.m51a(i + 128, f, i2, 128, 0.0f);
                    c0016b.m51a(i + 128, f, i2 + 128, 128, 128);
                    c0016b.m51a(i, f, i2 + 128, 0.0f, 128);
                }
            }
        }
        c0016b.m46a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: a */
    public final void m31a(C0021d c0021d, C0028e c0028e, int i, int i2) {
        C0016b c0016b = C0016b.f97a;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, ((((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f) * 0.5f);
        if (i == 0) {
            c0016b.m48b();
            for (int i3 = 0; i3 < 6; i3++) {
                C0003b.m13a(c0021d, c0016b, c0028e.f175a, c0028e.f176b, c0028e.f177c, i3);
            }
            c0016b.m46a();
        } else {
            GL11.glBlendFunc(770, 771);
            float fSin = (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.8f;
            GL11.glColor4f(fSin, fSin, fSin, (((float) Math.sin(System.currentTimeMillis() / 200.0d)) * 0.2f) + 0.5f);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.f65i.m45a("/terrain.png", 9728));
            int i4 = c0028e.f175a;
            int i5 = c0028e.f176b;
            int i6 = c0028e.f177c;
            if (c0028e.f178d == 0) {
                i5--;
            }
            if (c0028e.f178d == 1) {
                i5++;
            }
            if (c0028e.f178d == 2) {
                i6--;
            }
            if (c0028e.f178d == 3) {
                i6++;
            }
            if (c0028e.f178d == 4) {
                i4--;
            }
            if (c0028e.f178d == 5) {
                i4++;
            }
            c0016b.m48b();
            c0016b.m54c();
            C0003b.f13a[i2].mo3a(c0016b, this.f59a, 0, i4, i5, i6);
            C0003b.f13a[i2].mo3a(c0016b, this.f59a, 1, i4, i5, i6);
            c0016b.m46a();
            GL11.glDisable(3553);
        }
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    public final void m32a(int i, int i2, int i3, int i4, int i5, int i6) {
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
        if (i8 >= this.f62f) {
            i8 = this.f62f - 1;
        }
        if (i10 >= this.f63g) {
            i10 = this.f63g - 1;
        }
        if (i12 >= this.f64h) {
            i12 = this.f64h - 1;
        }
        for (int i13 = i7; i13 <= i8; i13++) {
            for (int i14 = i9; i14 <= i10; i14++) {
                for (int i15 = i11; i15 <= i12; i15++) {
                    this.f60b[((i13 + (i14 * this.f62f)) * this.f64h) + i15].m24b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m33a() {
        for (int i = 0; i < this.f60b.length; i++) {
            this.f60b[i].m27d();
        }
    }
}
