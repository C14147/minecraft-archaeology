package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.c */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/c.class */
public final class C0022c extends AbstractC0021b {

    /* JADX INFO: renamed from: b */
    private int f90b = 8;

    /* JADX INFO: renamed from: a */
    private C0023d[] f89a = new C0023d[8];

    public C0022c(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f89a[i2] = new C0023d(random);
        }
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0021b
    /* JADX INFO: renamed from: a */
    public final double mo29a(double d, double d2) {
        double dMo29a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f90b; i++) {
            dMo29a += this.f89a[i].mo29a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo29a;
    }
}
