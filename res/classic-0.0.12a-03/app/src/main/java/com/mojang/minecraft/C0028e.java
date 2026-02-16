package com.mojang.minecraft;

/* JADX INFO: renamed from: com.mojang.minecraft.e */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/e.class */
public final class C0028e {

    /* JADX INFO: renamed from: a */
    public int f175a;

    /* JADX INFO: renamed from: b */
    public int f176b;

    /* JADX INFO: renamed from: c */
    public int f177c;

    /* JADX INFO: renamed from: d */
    public int f178d;

    public C0028e(int i, int i2, int i3, int i4, int i5) {
        this.f175a = i2;
        this.f176b = i3;
        this.f177c = i4;
        this.f178d = i5;
    }

    /* JADX INFO: renamed from: a */
    float m75a(C0021d c0021d, int i) {
        int i2 = this.f175a;
        int i3 = this.f176b;
        int i4 = this.f177c;
        if (i == 1) {
            if (this.f178d == 0) {
                i3--;
            }
            if (this.f178d == 1) {
                i3++;
            }
            if (this.f178d == 2) {
                i4--;
            }
            if (this.f178d == 3) {
                i4++;
            }
            if (this.f178d == 4) {
                i2--;
            }
            if (this.f178d == 5) {
                i2++;
            }
        }
        float f = i2 - c0021d.f185h;
        float f2 = i3 - c0021d.f186i;
        float f3 = i4 - c0021d.f187j;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }
}
