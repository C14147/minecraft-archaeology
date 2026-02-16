package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/b/a/a.class */
public final class C0041a extends AbstractC0043c {

    /* JADX INFO: renamed from: b */
    private int f243b = 8;

    /* JADX INFO: renamed from: a */
    private C0044d[] f242a = new C0044d[8];

    public C0041a(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f242a[i2] = new C0044d(random);
        }
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0043c
    /* JADX INFO: renamed from: a */
    public final double mo122a(double d, double d2) {
        double dMo122a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f243b; i++) {
            dMo122a += this.f242a[i].mo122a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo122a;
    }
}
