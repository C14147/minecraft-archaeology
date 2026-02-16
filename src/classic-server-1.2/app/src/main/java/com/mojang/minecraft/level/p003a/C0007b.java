package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0021a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/b.class */
public class C0007b {

    /* JADX INFO: renamed from: a */
    public static final C0007b[] f48a = new C0007b[256];

    /* JADX INFO: renamed from: b */
    public static final boolean[] f49b = new boolean[256];

    /* JADX INFO: renamed from: s */
    private static int[] f50s = new int[256];

    /* JADX INFO: renamed from: c */
    public static final C0007b f51c = new C0007b(1, 1);

    /* JADX INFO: renamed from: d */
    public static final C0007b f52d = new C0014i(2);

    /* JADX INFO: renamed from: e */
    public static final C0007b f53e = new C0009d(3, 2);

    /* JADX INFO: renamed from: f */
    public static final C0007b f54f;

    /* JADX INFO: renamed from: g */
    public static final C0007b f55g;

    /* JADX INFO: renamed from: h */
    public static final C0007b f56h;

    /* JADX INFO: renamed from: i */
    public static final C0007b f57i;

    /* JADX INFO: renamed from: j */
    public static final C0007b f58j;

    /* JADX INFO: renamed from: k */
    public static final C0007b f59k;

    /* JADX INFO: renamed from: l */
    public static final C0007b f60l;

    /* JADX INFO: renamed from: m */
    public static final C0007b f61m;

    /* JADX INFO: renamed from: n */
    public static final C0007b f62n;

    /* JADX INFO: renamed from: o */
    public static final C0007b f63o;

    /* JADX INFO: renamed from: p */
    public static final C0007b f64p;

    /* JADX INFO: renamed from: q */
    public static final C0007b f65q;

    /* JADX INFO: renamed from: r */
    public final int f66r;

    protected C0007b(int i) {
        new Random();
        f48a[i] = this;
        this.f66r = i;
    }

    /* JADX INFO: renamed from: a */
    protected final void m13a(boolean z) {
        f49b[this.f66r] = z;
    }

    protected C0007b(int i, int i2) {
        this(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m14a(int i) {
        f50s[this.f66r] = 16;
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
    public C0021a mo15c() {
        return C0021a.f88a;
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

    static {
        new C0007b(4, 16);
        new C0007b(5, 4);
        new C0006a(6);
        f54f = new C0007b(7, 17);
        f55g = new C0013h(8, C0021a.f89b);
        f56h = new C0011f(9, C0021a.f89b);
        f57i = new C0013h(10, C0021a.f90c);
        f58j = new C0011f(11, C0021a.f90c);
        f59k = new C0010e(12, 18);
        f60l = new C0010e(13, 19);
        f61m = new C0007b(14, 32);
        f62n = new C0007b(15, 33);
        f63o = new C0007b(16, 34);
        f64p = new C0012g(17);
        f65q = new C0008c(18, 22);
    }
}
