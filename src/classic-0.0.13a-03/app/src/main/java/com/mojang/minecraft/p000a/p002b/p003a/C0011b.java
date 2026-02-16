package com.mojang.minecraft.p000a.p002b.p003a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b.a.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/b/a/b.class */
public final class C0011b extends AbstractC0012c {

    /* JADX INFO: renamed from: b */
    private int f43b = 8;

    /* JADX INFO: renamed from: a */
    private C0013d[] f42a = new C0013d[8];

    public C0011b(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f42a[i2] = new C0013d(random);
        }
    }

    @Override // com.mojang.minecraft.p000a.p002b.p003a.AbstractC0012c
    /* JADX INFO: renamed from: a */
    public final double mo29a(double d, double d2) {
        double dMo29a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f43b; i++) {
            dMo29a += this.f42a[i].mo29a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo29a;
    }
}
