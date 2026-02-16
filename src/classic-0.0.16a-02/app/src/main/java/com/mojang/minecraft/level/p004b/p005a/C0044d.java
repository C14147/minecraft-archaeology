package com.mojang.minecraft.level.p004b.p005a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/b/a/d.class */
public final class C0044d extends AbstractC0043c {

    /* JADX INFO: renamed from: a */
    private int[] f246a;

    public C0044d() {
        this(new Random());
    }

    public C0044d(Random random) {
        this.f246a = new int[512];
        for (int i = 0; i < 256; i++) {
            this.f246a[i] = i;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int iNextInt = random.nextInt(256 - i2) + i2;
            int i3 = this.f246a[i2];
            this.f246a[i2] = this.f246a[iNextInt];
            this.f246a[iNextInt] = i3;
            this.f246a[i2 + 256] = this.f246a[i2];
        }
    }

    /* JADX INFO: renamed from: a */
    private static double m123a(double d) {
        return d * d * d * ((d * ((d * 6.0d) - 15.0d)) + 10.0d);
    }

    /* JADX INFO: renamed from: a */
    private static double m124a(double d, double d2, double d3) {
        return d2 + (d * (d3 - d2));
    }

    /* JADX INFO: renamed from: a */
    private static double m125a(int i, double d, double d2, double d3) {
        int i2 = i & 15;
        double d4 = i2 < 8 ? d : d2;
        double d5 = i2 < 4 ? d2 : (i2 == 12 || i2 == 14) ? d : d3;
        return ((i2 & 1) == 0 ? d4 : -d4) + ((i2 & 2) == 0 ? d5 : -d5);
    }

    @Override // com.mojang.minecraft.level.p004b.p005a.AbstractC0043c
    /* JADX INFO: renamed from: a */
    public final double mo122a(double d, double d2) {
        int iFloor = ((int) Math.floor(d)) & 255;
        int iFloor2 = ((int) Math.floor(d2)) & 255;
        int iFloor3 = ((int) Math.floor(0.0d)) & 255;
        double dFloor = d - Math.floor(d);
        double dFloor2 = d2 - Math.floor(d2);
        double dFloor3 = 0.0d - Math.floor(0.0d);
        double dM123a = m123a(dFloor);
        double dM123a2 = m123a(dFloor2);
        double dM123a3 = m123a(dFloor3);
        int i = this.f246a[iFloor] + iFloor2;
        int i2 = this.f246a[i] + iFloor3;
        int i3 = this.f246a[i + 1] + iFloor3;
        int i4 = this.f246a[iFloor + 1] + iFloor2;
        int i5 = this.f246a[i4] + iFloor3;
        int i6 = this.f246a[i4 + 1] + iFloor3;
        return m124a(dM123a3, m124a(dM123a2, m124a(dM123a, m125a(this.f246a[i2], dFloor, dFloor2, dFloor3), m125a(this.f246a[i5], dFloor - 1.0d, dFloor2, dFloor3)), m124a(dM123a, m125a(this.f246a[i3], dFloor, dFloor2 - 1.0d, dFloor3), m125a(this.f246a[i6], dFloor - 1.0d, dFloor2 - 1.0d, dFloor3))), m124a(dM123a2, m124a(dM123a, m125a(this.f246a[i2 + 1], dFloor, dFloor2, dFloor3 - 1.0d), m125a(this.f246a[i5 + 1], dFloor - 1.0d, dFloor2, dFloor3 - 1.0d)), m124a(dM123a, m125a(this.f246a[i3 + 1], dFloor, dFloor2 - 1.0d, dFloor3 - 1.0d), m125a(this.f246a[i6 + 1], dFloor - 1.0d, dFloor2 - 1.0d, dFloor3 - 1.0d))));
    }
}
