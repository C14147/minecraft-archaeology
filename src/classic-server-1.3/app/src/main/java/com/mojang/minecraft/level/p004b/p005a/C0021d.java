package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.d */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a/d.class */
public final class C0021d extends AbstractC0019b {

    /* JADX INFO: renamed from: a */
    private int[] f90a;

    public C0021d() {
        this(new Random());
    }

    public C0021d(Random random) {
        this.f90a = new int[512];
        for (int i = 0; i < 256; i++) {
            this.f90a[i] = i;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int iNextInt = random.nextInt(256 - i2) + i2;
            int i3 = this.f90a[i2];
            this.f90a[i2] = this.f90a[iNextInt];
            this.f90a[iNextInt] = i3;
            this.f90a[i2 + 256] = this.f90a[i2];
        }
    }

    /* JADX INFO: renamed from: a */
    private static double m28a(double d) {
        return d * d * d * ((d * ((d * 6.0d) - 15.0d)) + 10.0d);
    }

    /* JADX INFO: renamed from: a */
    private static double m29a(double d, double d2, double d3) {
        return d2 + (d * (d3 - d2));
    }

    /* JADX INFO: renamed from: a */
    private static double m30a(int i, double d, double d2, double d3) {
        int i2 = i & 15;
        double d4 = i2 < 8 ? d : d2;
        double d5 = i2 < 4 ? d2 : (i2 == 12 || i2 == 14) ? d : d3;
        return ((i2 & 1) == 0 ? d4 : -d4) + ((i2 & 2) == 0 ? d5 : -d5);
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0019b
    /* JADX INFO: renamed from: a */
    public final double mo27a(double d, double d2) {
        int iFloor = ((int) Math.floor(d)) & 255;
        int iFloor2 = ((int) Math.floor(d2)) & 255;
        int iFloor3 = ((int) Math.floor(0.0d)) & 255;
        double dFloor = d - Math.floor(d);
        double dFloor2 = d2 - Math.floor(d2);
        double dFloor3 = 0.0d - Math.floor(0.0d);
        double dM28a = m28a(dFloor);
        double dM28a2 = m28a(dFloor2);
        double dM28a3 = m28a(dFloor3);
        int i = this.f90a[iFloor] + iFloor2;
        int i2 = this.f90a[i] + iFloor3;
        int i3 = this.f90a[i + 1] + iFloor3;
        int i4 = this.f90a[iFloor + 1] + iFloor2;
        int i5 = this.f90a[i4] + iFloor3;
        int i6 = this.f90a[i4 + 1] + iFloor3;
        return m29a(dM28a3, m29a(dM28a2, m29a(dM28a, m30a(this.f90a[i2], dFloor, dFloor2, dFloor3), m30a(this.f90a[i5], dFloor - 1.0d, dFloor2, dFloor3)), m29a(dM28a, m30a(this.f90a[i3], dFloor, dFloor2 - 1.0d, dFloor3), m30a(this.f90a[i6], dFloor - 1.0d, dFloor2 - 1.0d, dFloor3))), m29a(dM28a2, m29a(dM28a, m30a(this.f90a[i2 + 1], dFloor, dFloor2, dFloor3 - 1.0d), m30a(this.f90a[i5 + 1], dFloor - 1.0d, dFloor2, dFloor3 - 1.0d)), m29a(dM28a, m30a(this.f90a[i3 + 1], dFloor, dFloor2 - 1.0d, dFloor3 - 1.0d), m30a(this.f90a[i6 + 1], dFloor - 1.0d, dFloor2 - 1.0d, dFloor3 - 1.0d))));
    }
}
