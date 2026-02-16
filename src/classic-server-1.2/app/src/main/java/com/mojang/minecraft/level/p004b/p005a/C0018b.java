package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/b.class */
public final class C0018b extends AbstractC0019c {

    /* JADX INFO: renamed from: b */
    private int f85b = 8;

    /* JADX INFO: renamed from: a */
    private C0020d[] f84a = new C0020d[8];

    public C0018b(Random random, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f84a[i2] = new C0020d(random);
        }
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0019c
    /* JADX INFO: renamed from: a */
    public final double mo27a(double d, double d2) {
        double dMo27a = 0.0d;
        double d3 = 1.0d;
        for (int i = 0; i < this.f85b; i++) {
            dMo27a += this.f84a[i].mo27a(d / d3, d2 / d3) * d3;
            d3 *= 2.0d;
        }
        return dMo27a;
    }
}
