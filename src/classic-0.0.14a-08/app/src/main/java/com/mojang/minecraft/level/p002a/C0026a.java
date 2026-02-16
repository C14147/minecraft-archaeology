package com.mojang.minecraft.level.p002a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0004c;
import com.mojang.minecraft.particle.C0041a;
import com.mojang.minecraft.particle.Particle;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.player.Player;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/a/a.class */
public class C0026a {

    /* JADX INFO: renamed from: a */
    public static final C0026a[] f177a = new C0026a[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f178b = new boolean[256];

    /* JADX INFO: renamed from: c */
    public static final C0026a f179c = new C0026a(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0026a f180d = new C0032g(2);

    /* JADX INFO: renamed from: e */
    public static final C0026a f181e = new C0028c(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0026a f182f = new C0026a(4, 16);

    /* JADX INFO: renamed from: g */
    public static final C0026a f183g = new C0026a(5, 4);

    /* JADX INFO: renamed from: h */
    public static final C0026a f184h = new C0033h(6);

    /* JADX INFO: renamed from: i */
    public static final C0026a f185i = new C0026a(7, 17);

    /* JADX INFO: renamed from: j */
    public static final C0026a f186j = new C0034i(8, 1);

    /* JADX INFO: renamed from: k */
    public static final C0026a f187k = new C0030e(9, 1);

    /* JADX INFO: renamed from: l */
    public static final C0026a f188l = new C0034i(10, 2);

    /* JADX INFO: renamed from: m */
    public static final C0026a f189m = new C0030e(11, 2);

    /* JADX INFO: renamed from: n */
    public static final C0026a f190n = new C0029d(12, 18);

    /* JADX INFO: renamed from: o */
    public static final C0026a f191o = new C0029d(13, 19);

    /* JADX INFO: renamed from: p */
    public static final C0026a f192p = new C0026a(14, 32);

    /* JADX INFO: renamed from: q */
    public static final C0026a f193q = new C0026a(15, 33);

    /* JADX INFO: renamed from: r */
    public static final C0026a f194r = new C0026a(16, 34);

    /* JADX INFO: renamed from: s */
    public static final C0026a f195s = new C0031f(17);

    /* JADX INFO: renamed from: t */
    public static final C0026a f196t = new C0027b(18, 22);

    /* JADX INFO: renamed from: u */
    public int f197u;

    /* JADX INFO: renamed from: v */
    public final int f198v;

    /* JADX INFO: renamed from: w */
    private float f199w;

    /* JADX INFO: renamed from: x */
    private float f200x;

    /* JADX INFO: renamed from: y */
    private float f201y;

    /* JADX INFO: renamed from: z */
    private float f202z;

    /* JADX INFO: renamed from: A */
    private float f203A;

    /* JADX INFO: renamed from: B */
    private float f204B;

    protected C0026a(int i) {
        new Random();
        f177a[i] = this;
        this.f198v = i;
        m80a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    protected final void m79a(boolean z) {
        f178b[this.f198v] = z;
    }

    /* JADX INFO: renamed from: a */
    protected final void m80a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f199w = 0.0f;
        this.f200x = f2;
        this.f201y = 0.0f;
        this.f202z = 1.0f;
        this.f203A = f5;
        this.f204B = 1.0f;
    }

    protected C0026a(int i, int i2) {
        this(i);
        this.f197u = i2;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo81a(C0004c c0004c, Level level, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (mo83a(level, i2, i3 - 1, i4, i, 0)) {
            float brightness = level.getBrightness(i2, i3 - 1, i4);
            c0004c.m4a(brightness * 1.0f, brightness * 1.0f, brightness * 1.0f);
            mo85a(c0004c, i2, i3, i4, 0);
            z = true;
        }
        if (mo83a(level, i2, i3 + 1, i4, i, 1)) {
            float brightness2 = level.getBrightness(i2, i3 + 1, i4);
            c0004c.m4a(brightness2 * 1.0f, brightness2 * 1.0f, brightness2 * 1.0f);
            mo85a(c0004c, i2, i3, i4, 1);
            z = true;
        }
        if (mo83a(level, i2, i3, i4 - 1, i, 2)) {
            float brightness3 = level.getBrightness(i2, i3, i4 - 1);
            c0004c.m4a(0.8f * brightness3, 0.8f * brightness3, 0.8f * brightness3);
            mo85a(c0004c, i2, i3, i4, 2);
            z = true;
        }
        if (mo83a(level, i2, i3, i4 + 1, i, 3)) {
            float brightness4 = level.getBrightness(i2, i3, i4 + 1);
            c0004c.m4a(0.8f * brightness4, 0.8f * brightness4, 0.8f * brightness4);
            mo85a(c0004c, i2, i3, i4, 3);
            z = true;
        }
        if (mo83a(level, i2 - 1, i3, i4, i, 4)) {
            float brightness5 = level.getBrightness(i2 - 1, i3, i4);
            c0004c.m4a(0.6f * brightness5, 0.6f * brightness5, 0.6f * brightness5);
            mo85a(c0004c, i2, i3, i4, 4);
            z = true;
        }
        if (mo83a(level, i2 + 1, i3, i4, i, 5)) {
            float brightness6 = level.getBrightness(i2 + 1, i3, i4);
            c0004c.m4a(0.6f * brightness6, 0.6f * brightness6, 0.6f * brightness6);
            mo85a(c0004c, i2, i3, i4, 5);
            z = true;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m82a(Level level, int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            i2--;
        }
        if (i4 == 1) {
            i2++;
        }
        if (i4 == 2) {
            i3--;
        }
        if (i4 == 3) {
            i3++;
        }
        if (i4 == 4) {
            i--;
        }
        if (i4 == 5) {
            i++;
        }
        return !level.isSolidTile(i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo83a(Level level, int i, int i2, int i3, int i4, int i5) {
        return (i4 == 1 || level.isSolidTile(i, i2, i3)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    protected int mo84a(int i) {
        return this.f197u;
    }

    /* JADX INFO: renamed from: a */
    public void mo85a(C0004c c0004c, int i, int i2, int i3, int i4) {
        int iMo84a = mo84a(i4);
        int i5 = (iMo84a % 16) << 4;
        int i6 = (iMo84a / 16) << 4;
        float f = i5 / 256.0f;
        float f2 = (i5 + 15.99f) / 256.0f;
        float f3 = i6 / 256.0f;
        float f4 = (i6 + 15.99f) / 256.0f;
        float f5 = i + this.f199w;
        float f6 = i + this.f202z;
        float f7 = i2 + this.f200x;
        float f8 = i2 + this.f203A;
        float f9 = i3 + this.f201y;
        float f10 = i3 + this.f204B;
        if (i4 == 0) {
            c0004c.m6a(f5, f7, f10, f, f4);
            c0004c.m6a(f5, f7, f9, f, f3);
            c0004c.m6a(f6, f7, f9, f2, f3);
            c0004c.m6a(f6, f7, f10, f2, f4);
            return;
        }
        if (i4 == 1) {
            c0004c.m6a(f6, f8, f10, f2, f4);
            c0004c.m6a(f6, f8, f9, f2, f3);
            c0004c.m6a(f5, f8, f9, f, f3);
            c0004c.m6a(f5, f8, f10, f, f4);
            return;
        }
        if (i4 == 2) {
            c0004c.m6a(f5, f8, f9, f2, f3);
            c0004c.m6a(f6, f8, f9, f, f3);
            c0004c.m6a(f6, f7, f9, f, f4);
            c0004c.m6a(f5, f7, f9, f2, f4);
            return;
        }
        if (i4 == 3) {
            c0004c.m6a(f5, f8, f10, f, f3);
            c0004c.m6a(f5, f7, f10, f, f4);
            c0004c.m6a(f6, f7, f10, f2, f4);
            c0004c.m6a(f6, f8, f10, f2, f3);
            return;
        }
        if (i4 == 4) {
            c0004c.m6a(f5, f8, f10, f2, f3);
            c0004c.m6a(f5, f8, f9, f, f3);
            c0004c.m6a(f5, f7, f9, f, f4);
            c0004c.m6a(f5, f7, f10, f2, f4);
            return;
        }
        if (i4 == 5) {
            c0004c.m6a(f6, f7, f10, f, f4);
            c0004c.m6a(f6, f7, f9, f2, f4);
            c0004c.m6a(f6, f8, f9, f2, f3);
            c0004c.m6a(f6, f8, f10, f, f3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m86b(C0004c c0004c, int i, int i2, int i3, int i4) {
        int iMo84a = mo84a(i4);
        float f = (iMo84a % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iMo84a / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        float f5 = i + this.f199w;
        float f6 = i + this.f202z;
        float f7 = i2 + this.f200x;
        float f8 = i2 + this.f203A;
        float f9 = i3 + this.f201y;
        float f10 = i3 + this.f204B;
        if (i4 == 0) {
            c0004c.m6a(f6, f7, f10, f2, f4);
            c0004c.m6a(f6, f7, f9, f2, f3);
            c0004c.m6a(f5, f7, f9, f, f3);
            c0004c.m6a(f5, f7, f10, f, f4);
        }
        if (i4 == 1) {
            c0004c.m6a(f5, f8, f10, f, f4);
            c0004c.m6a(f5, f8, f9, f, f3);
            c0004c.m6a(f6, f8, f9, f2, f3);
            c0004c.m6a(f6, f8, f10, f2, f4);
        }
        if (i4 == 2) {
            c0004c.m6a(f5, f7, f9, f2, f4);
            c0004c.m6a(f6, f7, f9, f, f4);
            c0004c.m6a(f6, f8, f9, f, f3);
            c0004c.m6a(f5, f8, f9, f2, f3);
        }
        if (i4 == 3) {
            c0004c.m6a(f6, f8, f10, f2, f3);
            c0004c.m6a(f6, f7, f10, f2, f4);
            c0004c.m6a(f5, f7, f10, f, f4);
            c0004c.m6a(f5, f8, f10, f, f3);
        }
        if (i4 == 4) {
            c0004c.m6a(f5, f7, f10, f2, f4);
            c0004c.m6a(f5, f7, f9, f, f4);
            c0004c.m6a(f5, f8, f9, f, f3);
            c0004c.m6a(f5, f8, f10, f2, f3);
        }
        if (i4 == 5) {
            c0004c.m6a(f6, f8, f10, f, f3);
            c0004c.m6a(f6, f8, f9, f2, f3);
            c0004c.m6a(f6, f7, f9, f2, f4);
            c0004c.m6a(f6, f7, f10, f, f4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m87a(Player player, C0004c c0004c, int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i + 1.0f;
        float f3 = i2;
        float f4 = i2 + 1.0f;
        float f5 = i3;
        float f6 = i3 + 1.0f;
        if (i4 == 0 && i2 > player.f4y) {
            c0004c.m7b(f, f3, f6);
            c0004c.m7b(f, f3, f5);
            c0004c.m7b(f2, f3, f5);
            c0004c.m7b(f2, f3, f6);
        }
        if (i4 == 1 && i2 < player.f4y) {
            c0004c.m7b(f2, f4, f6);
            c0004c.m7b(f2, f4, f5);
            c0004c.m7b(f, f4, f5);
            c0004c.m7b(f, f4, f6);
        }
        if (i4 == 2 && i3 > player.f5z) {
            c0004c.m7b(f, f4, f5);
            c0004c.m7b(f2, f4, f5);
            c0004c.m7b(f2, f3, f5);
            c0004c.m7b(f, f3, f5);
        }
        if (i4 == 3 && i3 < player.f5z) {
            c0004c.m7b(f, f4, f6);
            c0004c.m7b(f, f3, f6);
            c0004c.m7b(f2, f3, f6);
            c0004c.m7b(f2, f4, f6);
        }
        if (i4 == 4 && i > player.f3x) {
            c0004c.m7b(f, f4, f6);
            c0004c.m7b(f, f4, f5);
            c0004c.m7b(f, f3, f5);
            c0004c.m7b(f, f3, f6);
        }
        if (i4 != 5 || i >= player.f3x) {
            return;
        }
        c0004c.m7b(f2, f3, f6);
        c0004c.m7b(f2, f3, f5);
        c0004c.m7b(f2, f4, f5);
        c0004c.m7b(f2, f4, f6);
    }

    /* JADX INFO: renamed from: a */
    public static AABB m88a(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: b */
    public AABB mo89b(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo90a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo91b() {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo92c() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo93a(Level level, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: a */
    public final void m94a(Level level, int i, int i2, int i3, C0041a c0041a) {
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    float f = i + ((i4 + 0.5f) / 4);
                    float f2 = i2 + ((i5 + 0.5f) / 4);
                    float f3 = i3 + ((i6 + 0.5f) / 4);
                    c0041a.f229a.add(new Particle(level, f, f2, f3, (f - i) - 0.5f, (f2 - i2) - 0.5f, (f3 - i3) - 0.5f, this.f197u));
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public int mo95d() {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public void mo96b(Level level, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: renamed from: a */
    public void mo97a(Level level, int i, int i2, int i3) {
    }
}
