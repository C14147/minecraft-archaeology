package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.c */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/c.class */
public final class C0020c extends AbstractC0019b {

    /* JADX INFO: renamed from: b */
    private int f89b = 8;

    /* JADX INFO: renamed from: a */
    private C0021d[] f88a = new C0021d[8];

    public C0020c(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f88a[i2] = new C0021d(random);
        }
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0019b
    /* JADX INFO: renamed from: a */
    public final double mo27a(double d, double d2) {
        double dMo27a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f89b; i++) {
            dMo27a += this.f88a[i].mo27a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo27a;
    }
}
