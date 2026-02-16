package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0022a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/b.class */
public class C0008b {

    /* JADX INFO: renamed from: a */
    public static final C0008b[] f49a = new C0008b[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f50b = new boolean[256];

    /* JADX INFO: renamed from: v */
    private static int[] f51v = new int[256];

    /* JADX INFO: renamed from: c */
    public static final C0008b f52c = new C0008b(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0008b f53d = new C0015i(2);

    /* JADX INFO: renamed from: e */
    public static final C0008b f54e = new C0010d(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0008b f55f = new C0008b(4, 16);

    /* JADX INFO: renamed from: g */
    public static final C0008b f56g = new C0008b(5, 4);

    /* JADX INFO: renamed from: h */
    public static final C0008b f57h = new C0007a(6);

    /* JADX INFO: renamed from: i */
    public static final C0008b f58i = new C0008b(7, 17);

    /* JADX INFO: renamed from: j */
    public static final C0008b f59j = new C0014h(8, C0022a.f93b);

    /* JADX INFO: renamed from: k */
    public static final C0008b f60k = new C0012f(9, C0022a.f93b);

    /* JADX INFO: renamed from: l */
    public static final C0008b f61l = new C0014h(10, C0022a.f94c);

    /* JADX INFO: renamed from: m */
    public static final C0008b f62m = new C0012f(11, C0022a.f94c);

    /* JADX INFO: renamed from: n */
    public static final C0008b f63n = new C0011e(12, 18);

    /* JADX INFO: renamed from: o */
    public static final C0008b f64o = new C0011e(13, 19);

    /* JADX INFO: renamed from: p */
    public static final C0008b f65p = new C0008b(14, 32);

    /* JADX INFO: renamed from: q */
    public static final C0008b f66q = new C0008b(15, 33);

    /* JADX INFO: renamed from: r */
    public static final C0008b f67r = new C0008b(16, 34);

    /* JADX INFO: renamed from: s */
    public static final C0008b f68s = new C0013g(17);

    /* JADX INFO: renamed from: t */
    public static final C0008b f69t = new C0009c(18, 22);

    /* JADX INFO: renamed from: u */
    public final int f70u;

    protected C0008b(int i) {
        new Random();
        f49a[i] = this;
        this.f70u = i;
    }

    /* JADX INFO: renamed from: a */
    protected final void m13a(boolean z) {
        f50b[this.f70u] = z;
    }

    protected C0008b(int i, int i2) {
        this(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m14a(int i) {
        f51v[this.f70u] = 16;
    }

    /* JADX INFO: renamed from: a */
    public AABB mo10a(int i, int i2, int i3) {
        return new AABB(i, i2, i3, i + 1, i2 + 1, i3 + 1);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo11a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo12b() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void mo9a(Level level, int i, int i2, int i3, Random random) {
    }

    /* JADX INFO: renamed from: c */
    public C0022a mo15c() {
        return C0022a.f92a;
    }

    /* JADX INFO: renamed from: a */
    public void mo16a(Level level, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: renamed from: a */
    public void mo17a(Level level, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: d */
    public int mo18d() {
        return 0;
    }
}
