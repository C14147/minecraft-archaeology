package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0024a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/b.class */
public class C0008b {

    /* JADX INFO: renamed from: a */
    public static final C0008b[] f49a = new C0008b[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f50b = new boolean[256];

    /* JADX INFO: renamed from: w */
    private static int[] f51w = new int[256];

    /* JADX INFO: renamed from: c */
    public static final C0008b f52c = new C0008b(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0008b f53d = new C0017k(2);

    /* JADX INFO: renamed from: e */
    public static final C0008b f54e = new C0010d(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0008b f55f;

    /* JADX INFO: renamed from: g */
    public static final C0008b f56g;

    /* JADX INFO: renamed from: h */
    public static final C0008b f57h;

    /* JADX INFO: renamed from: i */
    public static final C0008b f58i;

    /* JADX INFO: renamed from: j */
    public static final C0008b f59j;

    /* JADX INFO: renamed from: k */
    public static final C0008b f60k;

    /* JADX INFO: renamed from: l */
    public static final C0008b f61l;

    /* JADX INFO: renamed from: m */
    public static final C0008b f62m;

    /* JADX INFO: renamed from: n */
    public static final C0008b f63n;

    /* JADX INFO: renamed from: o */
    public static final C0008b f64o;

    /* JADX INFO: renamed from: p */
    public static final C0008b f65p;

    /* JADX INFO: renamed from: q */
    public static final C0008b f66q;

    /* JADX INFO: renamed from: r */
    public static final C0008b f67r;

    /* JADX INFO: renamed from: s */
    public static final C0008b f68s;

    /* JADX INFO: renamed from: t */
    public static final C0008b f69t;

    /* JADX INFO: renamed from: u */
    public static final C0008b f70u;

    /* JADX INFO: renamed from: v */
    public final int f71v;

    protected C0008b(int i) {
        new Random();
        f49a[i] = this;
        this.f71v = i;
    }

    /* JADX INFO: renamed from: a */
    protected final void m12a(boolean z) {
        f50b[this.f71v] = z;
    }

    protected C0008b(int i, int i2) {
        this(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m13a(int i) {
        f51w[this.f71v] = 16;
    }

    /* JADX INFO: renamed from: a */
    public AABB mo9a(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo10a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo11b() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo8a(Level level, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: c */
    public C0024a mo14c() {
        return C0024a.f93a;
    }

    /* JADX INFO: renamed from: a */
    public void mo15a(Level level, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: renamed from: a */
    public void mo16a(Level level, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: d */
    public int mo17d() {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public void mo18b(Level level, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: c */
    public void mo19c(Level level, int i, int i2, int i3) {
    }

    static {
        new C0008b(4, 16);
        f55f = new C0008b(5, 4);
        f56g = new C0007a(6);
        f57h = new C0008b(7, 17);
        f58i = new C0016j(8, C0024a.f94b);
        f59j = new C0013g(9, C0024a.f94b);
        f60k = new C0016j(10, C0024a.f95c);
        f61l = new C0013g(11, C0024a.f95c);
        f62m = new C0012f(12, 18);
        f63n = new C0012f(13, 19);
        f64o = new C0008b(14, 32);
        f65p = new C0008b(15, 33);
        f66q = new C0008b(16, 34);
        f67r = new C0014h(17);
        f68s = new C0009c(18, 22, true);
        f69t = new C0011e(19);
        f70u = new C0015i(20, 49, false);
    }
}
