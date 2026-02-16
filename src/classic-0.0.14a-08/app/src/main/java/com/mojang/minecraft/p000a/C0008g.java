package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0024d;
import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p002a.C0026a;
import com.mojang.minecraft.player.Player;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.g */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/g.class */
public final class C0008g {

    /* JADX INFO: renamed from: a */
    public Level f49a;

    /* JADX INFO: renamed from: g */
    private C0002a f50g;

    /* JADX INFO: renamed from: i */
    private C0007f[] f55i;

    /* JADX INFO: renamed from: e */
    public C0007f[] f56e;

    /* JADX INFO: renamed from: j */
    private int f57j;

    /* JADX INFO: renamed from: k */
    private int f58k;

    /* JADX INFO: renamed from: l */
    private int f59l;

    /* JADX INFO: renamed from: c */
    public int f52c = 0;

    /* JADX INFO: renamed from: h */
    private IntBuffer f53h = BufferUtils.createIntBuffer(65536);

    /* JADX INFO: renamed from: d */
    public Set f54d = new HashSet();

    /* JADX INFO: renamed from: f */
    public int f60f = 0;

    /* JADX INFO: renamed from: m */
    private float f61m = -9999.0f;

    /* JADX INFO: renamed from: n */
    private float f62n = -9999.0f;

    /* JADX INFO: renamed from: o */
    private float f63o = -9999.0f;

    /* JADX INFO: renamed from: b */
    public int f51b = GL11.glGenLists(2);

    public C0008g(C0002a c0002a) {
        this.f50g = c0002a;
    }

    /* JADX INFO: renamed from: a */
    public final void m20a(Level level) {
        if (this.f49a != null) {
            this.f49a.removeListener$74652038(this);
        }
        this.f49a = level;
        level.addListener$74652038(this);
        m21a();
    }

    /* JADX INFO: renamed from: a */
    public final void m21a() {
        if (this.f56e != null) {
            for (int i = 0; i < this.f56e.length; i++) {
                this.f56e[i].m16a();
            }
        }
        this.f57j = this.f49a.width / 16;
        this.f58k = this.f49a.depth / 16;
        this.f59l = this.f49a.height / 16;
        this.f56e = new C0007f[this.f57j * this.f58k * this.f59l];
        this.f55i = new C0007f[this.f57j * this.f58k * this.f59l];
        for (int i2 = 0; i2 < this.f57j; i2++) {
            for (int i3 = 0; i3 < this.f58k; i3++) {
                for (int i4 = 0; i4 < this.f59l; i4++) {
                    this.f56e[(((i4 * this.f58k) + i3) * this.f57j) + i2] = new C0007f(this.f49a, i2 << 4, i3 << 4, i4 << 4, 16);
                    this.f55i[(((i4 * this.f58k) + i3) * this.f57j) + i2] = this.f56e[(((i4 * this.f58k) + i3) * this.f57j) + i2];
                }
            }
        }
        this.f54d.clear();
        GL11.glNewList(this.f51b, 4864);
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f50g.m0a("/rock.png", 9728));
        GL11.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
        C0004c c0004c = C0004c.f27a;
        float groundLevel = this.f49a.getGroundLevel();
        int i5 = 128 > this.f49a.width ? this.f49a.width : 128;
        if (i5 > this.f49a.height) {
            i5 = this.f49a.height;
        }
        int i6 = 2048 / i5;
        c0004c.m3b();
        int i7 = (-i5) * i6;
        while (true) {
            int i8 = i7;
            if (i8 >= this.f49a.width + (i5 * i6)) {
                break;
            }
            int i9 = (-i5) * i6;
            while (true) {
                int i10 = i9;
                if (i10 < this.f49a.height + (i5 * i6)) {
                    float f = groundLevel;
                    if (i8 >= 0 && i10 >= 0 && i8 < this.f49a.width && i10 < this.f49a.height) {
                        f = 0.0f;
                    }
                    c0004c.m6a(i8, f, i10 + i5, 0.0f, i5);
                    c0004c.m6a(i8 + i5, f, i10 + i5, i5, i5);
                    c0004c.m6a(i8 + i5, f, i10, i5, 0.0f);
                    c0004c.m6a(i8, f, i10, 0.0f, 0.0f);
                    i9 = i10 + i5;
                }
            }
            i7 = i8 + i5;
        }
        c0004c.m1a();
        GL11.glBindTexture(3553, this.f50g.m0a("/rock.png", 9728));
        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        c0004c.m3b();
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= this.f49a.width) {
                break;
            }
            c0004c.m6a(i12, 0.0f, 0.0f, 0.0f, 0.0f);
            c0004c.m6a(i12 + i5, 0.0f, 0.0f, i5, 0.0f);
            c0004c.m6a(i12 + i5, groundLevel, 0.0f, i5, groundLevel);
            c0004c.m6a(i12, groundLevel, 0.0f, 0.0f, groundLevel);
            c0004c.m6a(i12, groundLevel, this.f49a.height, 0.0f, groundLevel);
            c0004c.m6a(i12 + i5, groundLevel, this.f49a.height, i5, groundLevel);
            c0004c.m6a(i12 + i5, 0.0f, this.f49a.height, i5, 0.0f);
            c0004c.m6a(i12, 0.0f, this.f49a.height, 0.0f, 0.0f);
            i11 = i12 + i5;
        }
        GL11.glColor3f(0.6f, 0.6f, 0.6f);
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= this.f49a.height) {
                break;
            }
            c0004c.m6a(0.0f, groundLevel, i14, 0.0f, 0.0f);
            c0004c.m6a(0.0f, groundLevel, i14 + i5, i5, 0.0f);
            c0004c.m6a(0.0f, 0.0f, i14 + i5, i5, groundLevel);
            c0004c.m6a(0.0f, 0.0f, i14, 0.0f, groundLevel);
            c0004c.m6a(this.f49a.width, 0.0f, i14, 0.0f, groundLevel);
            c0004c.m6a(this.f49a.width, 0.0f, i14 + i5, i5, groundLevel);
            c0004c.m6a(this.f49a.width, groundLevel, i14 + i5, i5, 0.0f);
            c0004c.m6a(this.f49a.width, groundLevel, i14, 0.0f, 0.0f);
            i13 = i14 + i5;
        }
        c0004c.m1a();
        GL11.glDisable(3042);
        GL11.glDisable(3553);
        GL11.glEndList();
        GL11.glNewList(this.f51b + 1, 4864);
        GL11.glEnable(3553);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.f50g.m0a("/water.png", 9728));
        float waterLevel = this.f49a.getWaterLevel();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        C0004c c0004c2 = C0004c.f27a;
        int i15 = 128 > this.f49a.width ? this.f49a.width : 128;
        if (i15 > this.f49a.height) {
            i15 = this.f49a.height;
        }
        int i16 = 2048 / i15;
        c0004c2.m3b();
        int i17 = (-i15) * i16;
        while (true) {
            int i18 = i17;
            if (i18 >= this.f49a.width + (i15 * i16)) {
                c0004c2.m1a();
                GL11.glDisable(3042);
                GL11.glDisable(3553);
                GL11.glEndList();
                m28a(0, 0, 0, this.f49a.width, this.f49a.depth, this.f49a.height);
                return;
            }
            int i19 = (-i15) * i16;
            while (true) {
                int i20 = i19;
                if (i20 < this.f49a.height + (i15 * i16)) {
                    float f2 = waterLevel - 0.1f;
                    if (i18 < 0 || i20 < 0 || i18 >= this.f49a.width || i20 >= this.f49a.height) {
                        c0004c2.m6a(i18, f2, i20 + i15, 0.0f, i15);
                        c0004c2.m6a(i18 + i15, f2, i20 + i15, i15, i15);
                        c0004c2.m6a(i18 + i15, f2, i20, i15, 0.0f);
                        c0004c2.m6a(i18, f2, i20, 0.0f, 0.0f);
                        c0004c2.m6a(i18, f2, i20, 0.0f, 0.0f);
                        c0004c2.m6a(i18 + i15, f2, i20, i15, 0.0f);
                        c0004c2.m6a(i18 + i15, f2, i20 + i15, i15, i15);
                        c0004c2.m6a(i18, f2, i20 + i15, 0.0f, i15);
                    }
                    i19 = i20 + i15;
                }
            }
            i17 = i18 + i15;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m22a(C0005d c0005d, float f) {
        for (int i = 0; i < this.f49a.entities.size(); i++) {
            if (c0005d.m13a(((Entity) this.f49a.entities.get(i)).f9bb)) {
                ((Entity) this.f49a.entities.get(i)).render(this.f50g, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m23a(Player player, int i) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f50g.m0a("/terrain.png", 9728));
        float f = player.f3x - this.f61m;
        float f2 = player.f4y - this.f62n;
        float f3 = player.f5z - this.f63o;
        if ((f * f) + (f2 * f2) + (f3 * f3) > 64.0f) {
            this.f61m = player.f3x;
            this.f62n = player.f4y;
            this.f63o = player.f5z;
            Arrays.sort(this.f55i, new C0006e(player));
        }
        this.f53h.clear();
        for (int i2 = 0; i2 < this.f55i.length; i2++) {
            this.f55i[i2].m18a(this.f53h, i);
        }
        if (this.f53h.position() > 0) {
            this.f53h.flip();
            GL11.glCallLists(this.f53h);
        }
        GL11.glDisable(3553);
    }

    /* JADX INFO: renamed from: a */
    public final void m24a(float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f50g.m0a("/clouds.png", 9728));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        C0004c c0004c = C0004c.f27a;
        float f2 = this.f49a.depth + 2;
        float f3 = (this.f60f + f) * 4.8828125E-4f * 0.03f;
        c0004c.m3b();
        for (int i = -2048; i < this.f49a.width + 2048; i += 512) {
            for (int i2 = -2048; i2 < this.f49a.height + 2048; i2 += 512) {
                c0004c.m6a(i, f2, i2 + 512, (i * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0004c.m6a(i + 512, f2, i2 + 512, ((i + 512) * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0004c.m6a(i + 512, f2, i2, ((i + 512) * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0004c.m6a(i, f2, i2, (i * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0004c.m6a(i, f2, i2, (i * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0004c.m6a(i + 512, f2, i2, ((i + 512) * 4.8828125E-4f) + f3, i2 * 4.8828125E-4f);
                c0004c.m6a(i + 512, f2, i2 + 512, ((i + 512) * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
                c0004c.m6a(i, f2, i2 + 512, (i * 4.8828125E-4f) + f3, (i2 + 512) * 4.8828125E-4f);
            }
        }
        c0004c.m1a();
        GL11.glDisable(3553);
        c0004c.m3b();
        c0004c.m4a(0.5f, 0.8f, 1.0f);
        float f4 = this.f49a.depth + 10;
        for (int i3 = -2048; i3 < this.f49a.width + 2048; i3 += 512) {
            for (int i4 = -2048; i4 < this.f49a.height + 2048; i4 += 512) {
                c0004c.m7b(i3, f4, i4);
                c0004c.m7b(i3 + 512, f4, i4);
                c0004c.m7b(i3 + 512, f4, i4 + 512);
                c0004c.m7b(i3, f4, i4 + 512);
            }
        }
        c0004c.m1a();
    }

    /* JADX INFO: renamed from: a */
    public final void m25a(int i, int i2, int i3) {
        int tile = this.f49a.getTile(i, i2, i3);
        if (tile == 0 || !C0026a.f177a[tile].mo91b()) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glColor4f(0.2f, 0.2f, 0.2f, 1.0f);
        GL11.glDepthFunc(513);
        C0004c c0004c = C0004c.f27a;
        c0004c.m3b();
        for (int i4 = 0; i4 < 6; i4++) {
            C0026a.f177a[tile].mo85a(c0004c, i, i2, i3, i4);
        }
        c0004c.m1a();
        GL11.glCullFace(1028);
        c0004c.m3b();
        for (int i5 = 0; i5 < 6; i5++) {
            C0026a.f177a[tile].mo85a(c0004c, i, i2, i3, i5);
        }
        c0004c.m1a();
        GL11.glCullFace(1029);
        GL11.glDisable(3553);
        GL11.glDepthFunc(515);
    }

    /* JADX INFO: renamed from: a */
    public final void m26a(Player player, C0024d c0024d, int i, int i2) {
        C0004c c0004c = C0004c.f27a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, ((((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f) * 0.5f);
        if (i == 0) {
            c0004c.m3b();
            for (int i3 = 0; i3 < 6; i3++) {
                C0026a.m87a(player, c0004c, c0024d.f167a, c0024d.f168b, c0024d.f169c, i3);
            }
            c0004c.m1a();
        } else {
            GL11.glBlendFunc(770, 771);
            float fSin = (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.8f;
            GL11.glColor4f(fSin, fSin, fSin, (((float) Math.sin(System.currentTimeMillis() / 200.0d)) * 0.2f) + 0.5f);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.f50g.m0a("/terrain.png", 9728));
            int i4 = c0024d.f167a;
            int i5 = c0024d.f168b;
            int i6 = c0024d.f169c;
            if (c0024d.f170d == 0) {
                i5--;
            }
            if (c0024d.f170d == 1) {
                i5++;
            }
            if (c0024d.f170d == 2) {
                i6--;
            }
            if (c0024d.f170d == 3) {
                i6++;
            }
            if (c0024d.f170d == 4) {
                i4--;
            }
            if (c0024d.f170d == 5) {
                i4++;
            }
            c0004c.m3b();
            c0004c.m9c();
            C0026a.f177a[i2].mo81a(c0004c, this.f49a, 0, i4, i5, i6);
            C0026a.f177a[i2].mo81a(c0004c, this.f49a, 1, i4, i5, i6);
            c0004c.m1a();
            GL11.glDisable(3553);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    /* JADX INFO: renamed from: a */
    public static void m27a(C0024d c0024d, int i) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
        float f = c0024d.f167a;
        float f2 = c0024d.f168b;
        float f3 = c0024d.f169c;
        if (i == 1) {
            if (c0024d.f170d == 0) {
                f2 -= 1.0f;
            }
            if (c0024d.f170d == 1) {
                f2 += 1.0f;
            }
            if (c0024d.f170d == 2) {
                f3 -= 1.0f;
            }
            if (c0024d.f170d == 3) {
                f3 += 1.0f;
            }
            if (c0024d.f170d == 4) {
                f -= 1.0f;
            }
            if (c0024d.f170d == 5) {
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
    public final void m28a(int i, int i2, int i3, int i4, int i5, int i6) {
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
        if (i10 > this.f57j - 1) {
            i10 = this.f57j - 1;
        }
        if (i11 > this.f58k - 1) {
            i11 = this.f58k - 1;
        }
        if (i12 > this.f59l - 1) {
            i12 = this.f59l - 1;
        }
        for (int i13 = i7; i13 <= i10; i13++) {
            for (int i14 = i8; i14 <= i11; i14++) {
                for (int i15 = i9; i15 <= i12; i15++) {
                    this.f54d.add(this.f56e[(((i15 * this.f58k) + i14) * this.f57j) + i13]);
                }
            }
        }
    }
}
