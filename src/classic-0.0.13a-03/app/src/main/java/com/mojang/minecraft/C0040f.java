package com.mojang.minecraft;

/* JADX INFO: renamed from: com.mojang.minecraft.f */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/f.class */
public final class C0040f {

    /* JADX INFO: renamed from: a */
    public int f219a;

    /* JADX INFO: renamed from: b */
    public int f220b;

    /* JADX INFO: renamed from: c */
    public int f221c;

    /* JADX INFO: renamed from: d */
    public int f222d;

    public C0040f(int i, int i2, int i3, int i4, int i5) {
        this.f219a = i2;
        this.f220b = i3;
        this.f221c = i4;
        this.f222d = i5;
    }

    /* JADX INFO: renamed from: a */
    float m108a(C0033e c0033e, int i) {
        int i2 = this.f219a;
        int i3 = this.f220b;
        int i4 = this.f221c;
        if (i == 1) {
            if (this.f222d == 0) {
                i3--;
            }
            if (this.f222d == 1) {
                i3++;
            }
            if (this.f222d == 2) {
                i4--;
            }
            if (this.f222d == 3) {
                i4++;
            }
            if (this.f222d == 4) {
                i2--;
            }
            if (this.f222d == 5) {
                i2++;
            }
        }
        float f = i2 - c0033e.f234h;
        float f2 = i3 - c0033e.f235i;
        float f3 = i4 - c0033e.f236j;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }
}
