package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0045a;
import com.mojang.minecraft.p001a.C0005c;
import com.mojang.minecraft.particle.C0049a;
import com.mojang.minecraft.particle.Particle;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.player.Player;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/a.class */
public class C0030a {

    /* JADX INFO: renamed from: a */
    public static final C0030a[] f197a = new C0030a[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f198b = new boolean[256];

    /* JADX INFO: renamed from: x */
    private static int[] f199x = new int[256];

    /* JADX INFO: renamed from: c */
    public static final C0030a f200c;

    /* JADX INFO: renamed from: d */
    public static final C0030a f201d;

    /* JADX INFO: renamed from: e */
    public static final C0030a f202e;

    /* JADX INFO: renamed from: f */
    public static final C0030a f203f;

    /* JADX INFO: renamed from: g */
    public static final C0030a f204g;

    /* JADX INFO: renamed from: h */
    public static final C0030a f205h;

    /* JADX INFO: renamed from: i */
    public static final C0030a f206i;

    /* JADX INFO: renamed from: j */
    public static final C0030a f207j;

    /* JADX INFO: renamed from: k */
    public static final C0030a f208k;

    /* JADX INFO: renamed from: l */
    public static final C0030a f209l;

    /* JADX INFO: renamed from: m */
    public static final C0030a f210m;

    /* JADX INFO: renamed from: n */
    public static final C0030a f211n;

    /* JADX INFO: renamed from: o */
    public static final C0030a f212o;

    /* JADX INFO: renamed from: p */
    public static final C0030a f213p;

    /* JADX INFO: renamed from: q */
    public static final C0030a f214q;

    /* JADX INFO: renamed from: r */
    public static final C0030a f215r;

    /* JADX INFO: renamed from: s */
    public static final C0030a f216s;

    /* JADX INFO: renamed from: t */
    public static final C0030a f217t;

    /* JADX INFO: renamed from: u */
    public int f218u;

    /* JADX INFO: renamed from: v */
    public final int f219v;

    /* JADX INFO: renamed from: y */
    private float f220y;

    /* JADX INFO: renamed from: z */
    private float f221z;

    /* JADX INFO: renamed from: A */
    private float f222A;

    /* JADX INFO: renamed from: B */
    private float f223B;

    /* JADX INFO: renamed from: C */
    private float f224C;

    /* JADX INFO: renamed from: D */
    private float f225D;

    /* JADX INFO: renamed from: w */
    public float f226w;

    protected C0030a(int i) {
        new Random();
        f197a[i] = this;
        this.f219v = i;
        m92a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    protected final void m91a(boolean z) {
        f198b[this.f219v] = z;
    }

    /* JADX INFO: renamed from: a */
    protected final void m92a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f220y = 0.0f;
        this.f221z = f2;
        this.f222A = 0.0f;
        this.f223B = 1.0f;
        this.f224C = f5;
        this.f225D = 1.0f;
    }

    protected C0030a(int i, int i2) {
        this(i);
        this.f218u = i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m93a(int i) {
        f199x[this.f219v] = 16;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo94a(C0005c c0005c, Level level, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (mo97a(level, i2, i3 - 1, i4, i, 0)) {
            float fMo95a = mo95a(level, i2, i3 - 1, i4);
            c0005c.m8a(0.5f * fMo95a, 0.5f * fMo95a, 0.5f * fMo95a);
            mo99a(c0005c, i2, i3, i4, 0);
            z = true;
        }
        if (mo97a(level, i2, i3 + 1, i4, i, 1)) {
            float fMo95a2 = mo95a(level, i2, i3 + 1, i4);
            c0005c.m8a(fMo95a2 * 1.0f, fMo95a2 * 1.0f, fMo95a2 * 1.0f);
            mo99a(c0005c, i2, i3, i4, 1);
            z = true;
        }
        if (mo97a(level, i2, i3, i4 - 1, i, 2)) {
            float fMo95a3 = mo95a(level, i2, i3, i4 - 1);
            c0005c.m8a(0.8f * fMo95a3, 0.8f * fMo95a3, 0.8f * fMo95a3);
            mo99a(c0005c, i2, i3, i4, 2);
            z = true;
        }
        if (mo97a(level, i2, i3, i4 + 1, i, 3)) {
            float fMo95a4 = mo95a(level, i2, i3, i4 + 1);
            c0005c.m8a(0.8f * fMo95a4, 0.8f * fMo95a4, 0.8f * fMo95a4);
            mo99a(c0005c, i2, i3, i4, 3);
            z = true;
        }
        if (mo97a(level, i2 - 1, i3, i4, i, 4)) {
            float fMo95a5 = mo95a(level, i2 - 1, i3, i4);
            c0005c.m8a(0.6f * fMo95a5, 0.6f * fMo95a5, 0.6f * fMo95a5);
            mo99a(c0005c, i2, i3, i4, 4);
            z = true;
        }
        if (mo97a(level, i2 + 1, i3, i4, i, 5)) {
            float fMo95a6 = mo95a(level, i2 + 1, i3, i4);
            c0005c.m8a(0.6f * fMo95a6, 0.6f * fMo95a6, 0.6f * fMo95a6);
            mo99a(c0005c, i2, i3, i4, 5);
            z = true;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    protected float mo95a(Level level, int i, int i2, int i3) {
        return level.getBrightness(i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m96a(Level level, int i, int i2, int i3, int i4) {
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
    protected boolean mo97a(Level level, int i, int i2, int i3, int i4, int i5) {
        return (i4 == 1 || level.isSolidTile(i, i2, i3)) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    protected int mo98b(int i) {
        return this.f218u;
    }

    /* JADX INFO: renamed from: a */
    public void mo99a(C0005c c0005c, int i, int i2, int i3, int i4) {
        int iMo98b = mo98b(i4);
        int i5 = (iMo98b % 16) << 4;
        int i6 = (iMo98b / 16) << 4;
        float f = i5 / 256.0f;
        float f2 = (i5 + 15.99f) / 256.0f;
        float f3 = i6 / 256.0f;
        float f4 = (i6 + 15.99f) / 256.0f;
        float f5 = i + this.f220y;
        float f6 = i + this.f223B;
        float f7 = i2 + this.f221z;
        float f8 = i2 + this.f224C;
        float f9 = i3 + this.f222A;
        float f10 = i3 + this.f225D;
        if (i4 == 0) {
            c0005c.m10a(f5, f7, f10, f, f4);
            c0005c.m10a(f5, f7, f9, f, f3);
            c0005c.m10a(f6, f7, f9, f2, f3);
            c0005c.m10a(f6, f7, f10, f2, f4);
            return;
        }
        if (i4 == 1) {
            c0005c.m10a(f6, f8, f10, f2, f4);
            c0005c.m10a(f6, f8, f9, f2, f3);
            c0005c.m10a(f5, f8, f9, f, f3);
            c0005c.m10a(f5, f8, f10, f, f4);
            return;
        }
        if (i4 == 2) {
            c0005c.m10a(f5, f8, f9, f2, f3);
            c0005c.m10a(f6, f8, f9, f, f3);
            c0005c.m10a(f6, f7, f9, f, f4);
            c0005c.m10a(f5, f7, f9, f2, f4);
            return;
        }
        if (i4 == 3) {
            c0005c.m10a(f5, f8, f10, f, f3);
            c0005c.m10a(f5, f7, f10, f, f4);
            c0005c.m10a(f6, f7, f10, f2, f4);
            c0005c.m10a(f6, f8, f10, f2, f3);
            return;
        }
        if (i4 == 4) {
            c0005c.m10a(f5, f8, f10, f2, f3);
            c0005c.m10a(f5, f8, f9, f, f3);
            c0005c.m10a(f5, f7, f9, f, f4);
            c0005c.m10a(f5, f7, f10, f2, f4);
            return;
        }
        if (i4 == 5) {
            c0005c.m10a(f6, f7, f10, f, f4);
            c0005c.m10a(f6, f7, f9, f2, f4);
            c0005c.m10a(f6, f8, f9, f2, f3);
            c0005c.m10a(f6, f8, f10, f, f3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m100b(C0005c c0005c, int i, int i2, int i3, int i4) {
        int iMo98b = mo98b(i4);
        float f = (iMo98b % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iMo98b / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        float f5 = i + this.f220y;
        float f6 = i + this.f223B;
        float f7 = i2 + this.f221z;
        float f8 = i2 + this.f224C;
        float f9 = i3 + this.f222A;
        float f10 = i3 + this.f225D;
        if (i4 == 0) {
            c0005c.m10a(f6, f7, f10, f2, f4);
            c0005c.m10a(f6, f7, f9, f2, f3);
            c0005c.m10a(f5, f7, f9, f, f3);
            c0005c.m10a(f5, f7, f10, f, f4);
        }
        if (i4 == 1) {
            c0005c.m10a(f5, f8, f10, f, f4);
            c0005c.m10a(f5, f8, f9, f, f3);
            c0005c.m10a(f6, f8, f9, f2, f3);
            c0005c.m10a(f6, f8, f10, f2, f4);
        }
        if (i4 == 2) {
            c0005c.m10a(f5, f7, f9, f2, f4);
            c0005c.m10a(f6, f7, f9, f, f4);
            c0005c.m10a(f6, f8, f9, f, f3);
            c0005c.m10a(f5, f8, f9, f2, f3);
        }
        if (i4 == 3) {
            c0005c.m10a(f6, f8, f10, f2, f3);
            c0005c.m10a(f6, f7, f10, f2, f4);
            c0005c.m10a(f5, f7, f10, f, f4);
            c0005c.m10a(f5, f8, f10, f, f3);
        }
        if (i4 == 4) {
            c0005c.m10a(f5, f7, f10, f2, f4);
            c0005c.m10a(f5, f7, f9, f, f4);
            c0005c.m10a(f5, f8, f9, f, f3);
            c0005c.m10a(f5, f8, f10, f2, f3);
        }
        if (i4 == 5) {
            c0005c.m10a(f6, f8, f10, f, f3);
            c0005c.m10a(f6, f8, f9, f2, f3);
            c0005c.m10a(f6, f7, f9, f2, f4);
            c0005c.m10a(f6, f7, f10, f, f4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m101a(Player player, C0005c c0005c, int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i + 1.0f;
        float f3 = i2;
        float f4 = i2 + 1.0f;
        float f5 = i3;
        float f6 = i3 + 1.0f;
        if (i4 == 0 && i2 > player.f12y) {
            c0005c.m11b(f, f3, f6);
            c0005c.m11b(f, f3, f5);
            c0005c.m11b(f2, f3, f5);
            c0005c.m11b(f2, f3, f6);
        }
        if (i4 == 1 && i2 < player.f12y) {
            c0005c.m11b(f2, f4, f6);
            c0005c.m11b(f2, f4, f5);
            c0005c.m11b(f, f4, f5);
            c0005c.m11b(f, f4, f6);
        }
        if (i4 == 2 && i3 > player.f13z) {
            c0005c.m11b(f, f4, f5);
            c0005c.m11b(f2, f4, f5);
            c0005c.m11b(f2, f3, f5);
            c0005c.m11b(f, f3, f5);
        }
        if (i4 == 3 && i3 < player.f13z) {
            c0005c.m11b(f, f4, f6);
            c0005c.m11b(f, f3, f6);
            c0005c.m11b(f2, f3, f6);
            c0005c.m11b(f2, f4, f6);
        }
        if (i4 == 4 && i > player.f11x) {
            c0005c.m11b(f, f4, f6);
            c0005c.m11b(f, f4, f5);
            c0005c.m11b(f, f3, f5);
            c0005c.m11b(f, f3, f6);
        }
        if (i4 != 5 || i >= player.f11x) {
            return;
        }
        c0005c.m11b(f2, f3, f6);
        c0005c.m11b(f2, f3, f5);
        c0005c.m11b(f2, f4, f5);
        c0005c.m11b(f2, f4, f6);
    }

    /* JADX INFO: renamed from: a */
    public static AABB m102a(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: b */
    public AABB mo103b(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo104a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo105b() {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo106c() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo107a(Level level, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: a */
    public final void m108a(Level level, int i, int i2, int i3, C0049a c0049a) {
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    float f = i + ((i4 + 0.5f) / 4);
                    float f2 = i2 + ((i5 + 0.5f) / 4);
                    float f3 = i3 + ((i6 + 0.5f) / 4);
                    c0049a.f290a.add(new Particle(level, f, f2, f3, (f - i) - 0.5f, (f2 - i2) - 0.5f, (f3 - i3) - 0.5f, this));
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public C0045a mo109d() {
        return C0045a.f248a;
    }

    /* JADX INFO: renamed from: b */
    public void mo110b(Level level, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: renamed from: b */
    public void mo111b(Level level, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: e */
    public int mo112e() {
        return 0;
    }

    static {
        C0030a c0030a = new C0030a(1, 1);
        c0030a.f226w = 1.0f;
        f200c = c0030a;
        C0036g c0036g = new C0036g(2);
        c0036g.f226w = 1.0f;
        f201d = c0036g;
        C0032c c0032c = new C0032c(3, 2);
        c0032c.f226w = 1.0f;
        f202e = c0032c;
        C0030a c0030a2 = new C0030a(4, 16);
        c0030a2.f226w = 1.0f;
        f203f = c0030a2;
        C0030a c0030a3 = new C0030a(5, 4);
        c0030a3.f226w = 1.0f;
        f204g = c0030a3;
        C0037h c0037h = new C0037h(6);
        c0037h.f226w = 1.0f;
        f205h = c0037h;
        C0030a c0030a4 = new C0030a(7, 17);
        c0030a4.f226w = 1.0f;
        f206i = c0030a4;
        C0038i c0038i = new C0038i(8, C0045a.f249b);
        c0038i.f226w = 1.0f;
        f207j = c0038i;
        C0034e c0034e = new C0034e(9, C0045a.f249b);
        c0034e.f226w = 1.0f;
        f208k = c0034e;
        C0038i c0038i2 = new C0038i(10, C0045a.f250c);
        c0038i2.f226w = 1.0f;
        f209l = c0038i2;
        C0034e c0034e2 = new C0034e(11, C0045a.f250c);
        c0034e2.f226w = 1.0f;
        f210m = c0034e2;
        C0033d c0033d = new C0033d(12, 18);
        c0033d.f226w = 1.0f;
        f211n = c0033d;
        C0033d c0033d2 = new C0033d(13, 19);
        c0033d2.f226w = 1.0f;
        f212o = c0033d2;
        C0030a c0030a5 = new C0030a(14, 32);
        c0030a5.f226w = 1.0f;
        f213p = c0030a5;
        C0030a c0030a6 = new C0030a(15, 33);
        c0030a6.f226w = 1.0f;
        f214q = c0030a6;
        C0030a c0030a7 = new C0030a(16, 34);
        c0030a7.f226w = 1.0f;
        f215r = c0030a7;
        C0035f c0035f = new C0035f(17);
        c0035f.f226w = 1.0f;
        f216s = c0035f;
        C0031b c0031b = new C0031b(18, 22);
        c0031b.f226w = 0.4f;
        f217t = c0031b;
    }
}
