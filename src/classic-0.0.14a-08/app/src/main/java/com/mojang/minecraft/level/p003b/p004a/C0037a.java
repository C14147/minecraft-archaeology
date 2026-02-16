package com.mojang.minecraft.level.p003b.p004a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/b/a/a.class */
public final class C0037a extends AbstractC0039c {

    /* JADX INFO: renamed from: b */
    private int f220b = 8;

    /* JADX INFO: renamed from: a */
    private C0040d[] f219a = new C0040d[8];

    public C0037a(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f219a[i2] = new C0040d(random);
        }
    }

    @Override // com.mojang.minecraft.level.p003b.p004a.AbstractC0039c
    /* JADX INFO: renamed from: a */
    public final double mo107a(double d, double d2) {
        double dMo107a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f220b; i++) {
            dMo107a += this.f219a[i].mo107a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo107a;
    }
}
