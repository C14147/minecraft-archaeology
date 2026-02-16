package com.mojang.minecraft.p001a;

import com.mojang.minecraft.C0028e;
import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.player.Player;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.g */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/g.class */
public final class C0009g {

    /* JADX INFO: renamed from: a */
    public Level f57a;

    /* JADX INFO: renamed from: b */
    public C0003a f58b;

    /* JADX INFO: renamed from: i */
    private C0008f[] f63i;

    /* JADX INFO: renamed from: g */
    public C0008f[] f64g;

    /* JADX INFO: renamed from: j */
    private int f65j;

    /* JADX INFO: renamed from: k */
    private int f66k;

    /* JADX INFO: renamed from: l */
    private int f67l;

    /* JADX INFO: renamed from: d */
    public int f60d = 0;

    /* JADX INFO: renamed from: e */
    public IntBuffer f61e = BufferUtils.createIntBuffer(65536);

    /* JADX INFO: renamed from: f */
    public Set f62f = new HashSet();

    /* JADX INFO: renamed from: h */
    public int f68h = 0;

    /* JADX INFO: renamed from: m */
    private float f69m = -9999.0f;

    /* JADX INFO: renamed from: n */
    private float f70n = -9999.0f;

    /* JADX INFO: renamed from: o */
    private float f71o = -9999.0f;

    /* JADX INFO: renamed from: c */
    public int f59c = GL11.glGenLists(2);

    public C0009g(C0003a c0003a) {
        this.f58b = c0003a;
    }

    /* JADX INFO: renamed from: a */
    public final void m24a(Level level) {
        if (this.f57a != null) {
            this.f57a.removeListener$74652038(this);
        }
        this.f57a = level;
        if (level != null) {
            level.addListener$74652038(this);
            m25a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m25a() {
        if (this.f64g != null) {
            for (int i = 0; i < this.f64g.length; i++) {
                this.f64g[i].m20a();
            }
        }
        this.f65j = this.f57a.width / 16;
        this.f66k = this.f57a.depth / 16;
        this.f67l = this.f57a.height / 16;
        this.f64g = new C0008f[this.f65j * this.f66k * this.f67l];
        this.f63i = new C0008f[this.f65j * this.f66k * this.f67l];
        for (int i2 = 0; i2 < this.f65j; i2++) {
            for (int i3 = 0; i3 < this.f66k; i3++) {
                for (int i4 = 0; i4 < this.f67l; i4++) {
                    this.f64g[(((i4 * this.f66k) + i3) * this.f65j) + i2] = new C0008f(this.f57a, i2 << 4, i3 << 4, i4 << 4, 16);
                    this.f63i[(((i4 * this.f66k) + i3) * this.f65j) + i2] = this.f64g[(((i4 * this.f66k) + i3) * this.f65j) + i2];
                }
            }
        }
        this.f62f.clear();
        GL11.glNewList(this.f59c, 4864);
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f58b.m4a("/rock.png", 9728));
        GL11.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
        C0005c c0005c = C0005c.f35a;
        float groundLevel = this.f57a.getGroundLevel();
        int i5 = 128 > this.f57a.width ? this.f57a.width : 128;
        if (i5 > this.f57a.height) {
            i5 = this.f57a.height;
        }
        int i6 = 2048 / i5;
        c0005c.m7b();
        int i7 = (-i5) * i6;
        while (true) {
            int i8 = i7;
            if (i8 >= this.f57a.width + (i5 * i6)) {
                break;
            }
            int i9 = (-i5) * i6;
            while (true) {
                int i10 = i9;
                if (i10 < this.f57a.height + (i5 * i6)) {
                    float f = groundLevel;
                    if (i8 >= 0 && i10 >= 0 && i8 < this.f57a.width && i10 < this.f57a.height) {
                        f = 0.0f;
                    }
                    c0005c.m10a(i8, f, i10 + i5, 0.0f, i5);
                    c0005c.m10a(i8 + i5, f, i10 + i5, i5, i5);
                    c0005c.m10a(i8 + i5, f, i10, i5, 0.0f);
                    c0005c.m10a(i8, f, i10, 0.0f, 0.0f);
                    i9 = i10 + i5;
                }
            }
            i7 = i8 + i5;
        }
        c0005c.m5a();
        GL11.glBindTexture(3553, this.f58b.m4a("/rock.png", 9728));
        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        c0005c.m7b();
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= this.f57a.width) {
                break;
            }
            c0005c.m10a(i12, 0.0f, 0.0f, 0.0f, 0.0f);
            c0005c.m10a(i12 + i5, 0.0f, 0.0f, i5, 0.0f);
            c0005c.m10a(i12 + i5, groundLevel, 0.0f, i5, groundLevel);
            c0005c.m10a(i12, groundLevel, 0.0f, 0.0f, groundLevel);
            c0005c.m10a(i12, groundLevel, this.f57a.height, 0.0f, groundLevel);
            c0005c.m10a(i12 + i5, groundLevel, this.f57a.height, i5, groundLevel);
            c0005c.m10a(i12 + i5, 0.0f, this.f57a.height, i5, 0.0f);
            c0005c.m10a(i12, 0.0f, this.f57a.height, 0.0f, 0.0f);
            i11 = i12 + i5;
        }
        GL11.glColor3f(0.6f, 0.6f, 0.6f);
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= this.f57a.height) {
                break;
            }
            c0005c.m10a(0.0f, groundLevel, i14, 0.0f, 0.0f);
            c0005c.m10a(0.0f, groundLevel, i14 + i5, i5, 0.0f);
            c0005c.m10a(0.0f, 0.0f, i14 + i5, i5, groundLevel);
            c0005c.m10a(0.0f, 0.0f, i14, 0.0f, groundLevel);
            c0005c.m10a(this.f57a.width, 0.0f, i14, 0.0f, groundLevel);
            c0005c.m10a(this.f57a.width, 0.0f, i14 + i5, i5, groundLevel);
            c0005c.m10a(this.f57a.width, groundLevel, i14 + i5, i5, 0.0f);
            c0005c.m10a(this.f57a.width, groundLevel, i14, 0.0f, 0.0f);
            i13 = i14 + i5;
        }
        c0005c.m5a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glEndList();
        GL11.glNewList(this.f59c + 1, 4864);
        GL11.glEnable(3553);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.f58b.m4a("/water.png", 9728));
        float waterLevel = this.f57a.getWaterLevel();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        C0005c c0005c2 = C0005c.f35a;
        int i15 = 128 > this.f57a.width ? this.f57a.width : 128;
        if (i15 > this.f57a.height) {
            i15 = this.f57a.height;
        }
        int i16 = 2048 / i15;
        c0005c2.m7b();
        int i17 = (-i15) * i16;
        while (true) {
            int i18 = i17;
            if (i18 >= this.f57a.width + (i15 * i16)) {
                c0005c2.m5a();
                GL11.glDisable(3042);
                GL11.glDisable(3553);
                GL11.glEndList();
                m32a(0, 0, 0, this.f57a.width, this.f57a.depth, this.f57a.height);
                return;
            }
            int i19 = (-i15) * i16;
            while (true) {
                int i20 = i19;
                if (i20 < this.f57a.height + (i15 * i16)) {
                    float f2 = waterLevel - 0.1f;
                    if (i18 < 0 || i20 < 0 || i18 >= this.f57a.width || i20 >= this.f57a.height) {
                        c0005c2.m10a(i18, f2, i20 + i15, 0.0f, i15);
                        c0005c2.m10a(i18 + i15, f2, i20 + i15, i15, i15);
                        c0005c2.m10a(i18 + i15, f2, i20, i15, 0.0f);
                        c0005c2.m10a(i18, f2, i20, 0.0f, 0.0f);
                        c0005c2.m10a(i18, f2, i20, 0.0f, 0.0f);
                        c0005c2.m10a(i18 + i15, f2, i20, i15, 0.0f);
                        c0005c2.m10a(i18 + i15, f2, i20 + i15, i15, i15);
                        c0005c2.m10a(i18, f2, i20 + i15, 0.0f, i15);
                    }
                    i19 = i20 + i15;
                }
            }
            i17 = i18 + i15;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m26a(C0006d c0006d, float f) {
        for (int i = 0; i < this.f57a.entities.size(); i++) {
            if (c0006d.m17a(((Entity) this.f57a.entities.get(i)).f17bb)) {
                ((Entity) this.f57a.entities.get(i)).render(this.f58b, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m27a(Player player, int i) {
        float f = player.f11x - this.f69m;
        float f2 = player.f12y - this.f70n;
        float f3 = player.f13z - this.f71o;
        if ((f * f) + (f2 * f2) + (f3 * f3) > 64.0f) {
            this.f69m = player.f11x;
            this.f70n = player.f12y;
            this.f71o = player.f13z;
            Arrays.sort(this.f63i, new C0007e(player));
        }
        this.f61e.clear();
        for (int i2 = 0; i2 < this.f63i.length; i2++) {
            this.f63i[i2].m22a(this.f61e, i);
        }
        this.f61e.flip();
        if (this.f61e.remaining() > 0) {
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.f58b.m4a("/terrain.png", 9728));
            GL11.glCallLists(this.f61e);
            GL11.glDisable(3553);
        }
        return this.f61e.remaining();
    }

    /* JADX INFO: renamed from: a */
    public final void m28a(float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f58b.m4a("/clouds.png", 9728));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        C0005c c0005c = C0005c.f35a;
        float f2 = this.f57a.depth + 2;
        float f3 = (this.f68h + f) * 4.8828125E-4f * 0.03f;
        c0005c.m7b();
        for (int i = -2048; i < this.f57a.width + 2048; i += 512) {
            for (int i2 = -2048; i2 < this.f57a.height + 2048; i2 += 512) {
                c0005c.m10a(i, f2, i2 + 512, (i * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0005c.m10a(i + 512, f2, i2 + 512, ((i + 512) * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0005c.m10a(i + 512, f2, i2, ((i + 512) * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0005c.m10a(i, f2, i2, (i * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0005c.m10a(i, f2, i2, (i * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0005c.m10a(i + 512, f2, i2, ((i + 512) * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0005c.m10a(i + 512, f2, i2 + 512, ((i + 512) * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0005c.m10a(i, f2, i2 + 512, (i * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
            }
        }
        c0005c.m5a();
        GL11.glDisable(3553);
        c0005c.m7b();
        c0005c.m8a(0.5f, 0.8f, 1.0f);
        float f4 = this.f57a.depth + 10;
        for (int i3 = -2048; i3 < this.f57a.width + 2048; i3 += 512) {
            for (int i4 = -2048; i4 < this.f57a.height + 2048; i4 += 512) {
                c0005c.m11b(i3, f4, i4);
                c0005c.m11b(i3 + 512, f4, i4);
                c0005c.m11b(i3 + 512, f4, i4 + 512);
                c0005c.m11b(i3, f4, i4 + 512);
            }
        }
        c0005c.m5a();
    }

    /* JADX INFO: renamed from: a */
    public final void m29a(int i, int i2, int i3) {
        int tile = this.f57a.getTile(i, i2, i3);
        if (tile == 0 || !C0030a.f197a[tile].mo105b()) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glColor4f(0.2f, 0.2f, 0.2f, 1.0f);
        GL11.glDepthFunc(513);
        C0005c c0005c = C0005c.f35a;
        c0005c.m7b();
        for (int i4 = 0; i4 < 6; i4++) {
            C0030a.f197a[tile].mo99a(c0005c, i, i2, i3, i4);
        }
        c0005c.m5a();
        GL11.glCullFace(1028);
        c0005c.m7b();
        for (int i5 = 0; i5 < 6; i5++) {
            C0030a.f197a[tile].mo99a(c0005c, i, i2, i3, i5);
        }
        c0005c.m5a();
        GL11.glCullFace(1029);
        GL11.glDisable(3553);
        GL11.glDepthFunc(515);
    }

    /* JADX INFO: renamed from: a */
    public final void m30a(Player player, C0028e c0028e, int i, int i2) {
        C0005c c0005c = C0005c.f35a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, ((((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f) * 0.5f);
        if (i == 0) {
            c0005c.m7b();
            for (int i3 = 0; i3 < 6; i3++) {
                C0030a.m101a(player, c0005c, c0028e.f187a, c0028e.f188b, c0028e.f189c, i3);
            }
            c0005c.m5a();
        } else {
            GL11.glBlendFunc(770, 771);
            float fSin = (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.8f;
            GL11.glColor4f(fSin, fSin, fSin, (((float) Math.sin(System.currentTimeMillis() / 200.0d)) * 0.2f) + 0.5f);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.f58b.m4a("/terrain.png", 9728));
            int i4 = c0028e.f187a;
            int i5 = c0028e.f188b;
            int i6 = c0028e.f189c;
            if (c0028e.f190d == 0) {
                i5--;
            }
            if (c0028e.f190d == 1) {
                i5++;
            }
            if (c0028e.f190d == 2) {
                i6--;
            }
            if (c0028e.f190d == 3) {
                i6++;
            }
            if (c0028e.f190d == 4) {
                i4--;
            }
            if (c0028e.f190d == 5) {
                i4++;
            }
            c0005c.m7b();
            c0005c.m13c();
            C0030a.f197a[i2].mo94a(c0005c, this.f57a, 0, i4, i5, i6);
            C0030a.f197a[i2].mo94a(c0005c, this.f57a, 1, i4, i5, i6);
            c0005c.m5a();
            GL11.glDisable(3553);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    /* JADX INFO: renamed from: a */
    public static void m31a(C0028e c0028e, int i) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
        float f = c0028e.f187a;
        float f2 = c0028e.f188b;
        float f3 = c0028e.f189c;
        if (i == 1) {
            if (c0028e.f190d == 0) {
                f2 -= 1.0f;
            }
            if (c0028e.f190d == 1) {
                f2 += 1.0f;
            }
            if (c0028e.f190d == 2) {
                f3 -= 1.0f;
            }
            if (c0028e.f190d == 3) {
                f3 += 1.0f;
            }
            if (c0028e.f190d == 4) {
                f -= 1.0f;
            }
            if (c0028e.f190d == 5) {
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
    public final void m32a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i / 16;
        int i8 = i2 / 16;
        int i9 = i3 / 16;
        int i10 = i4 / 16;
        int i11 = i5 / 16;
        int i12 = i6 / 16;
        if (i7 < 0) {
            i7 = 0;
        }
        if (i8 < 0) {
            i8 = 0;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        if (i10 > this.f65j - 1) {
            i10 = this.f65j - 1;
        }
        if (i11 > this.f66k - 1) {
            i11 = this.f66k - 1;
        }
        if (i12 > this.f67l - 1) {
            i12 = this.f67l - 1;
        }
        for (int i13 = i7; i13 <= i10; i13++) {
            for (int i14 = i8; i14 <= i11; i14++) {
                for (int i15 = i9; i15 <= i12; i15++) {
                    this.f62f.add(this.f64g[(((i15 * this.f66k) + i14) * this.f65j) + i13]);
                }
            }
        }
    }
}
