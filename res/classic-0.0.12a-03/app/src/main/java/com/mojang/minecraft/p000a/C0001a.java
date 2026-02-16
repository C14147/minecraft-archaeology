package com.mojang.minecraft.p000a;

import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/a.class */
public final class C0001a {

    /* JADX INFO: renamed from: a */
    private Random f9a;

    /* JADX INFO: renamed from: b */
    private int f10b;

    /* JADX INFO: renamed from: c */
    private int f11c = 16;

    /* JADX INFO: renamed from: d */
    private boolean f12d;

    public C0001a(Random random, int i, boolean z) {
        this.f10b = 0;
        this.f9a = random;
        this.f10b = i;
        this.f12d = z;
    }

    /* JADX INFO: renamed from: a */
    public final int[] m1a(int i, int i2) {
        int[] iArr = new int[i * i2];
        int i3 = this.f10b;
        int i4 = i >> i3;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i2) {
                break;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < i) {
                    iArr[i8 + (i6 * i)] = (this.f9a.nextInt(256) - 128) * this.f11c;
                    if (this.f12d) {
                        if (i8 == 0 || i6 == 0) {
                            iArr[i8 + (i6 * i)] = 0;
                        } else {
                            iArr[i8 + (i6 * i)] = (this.f9a.nextInt(192) - 64) * this.f11c;
                        }
                    }
                    i7 = i8 + i4;
                }
            }
            i5 = i6 + i4;
        }
        int i9 = i >> i3;
        while (true) {
            int i10 = i9;
            if (i10 <= 1) {
                break;
            }
            int i11 = 256 * (i10 << i3);
            int i12 = i10 / 2;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= i2) {
                    break;
                }
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 < i) {
                        int i17 = iArr[(i16 % i) + ((i14 % i2) * i)];
                        iArr[i16 + i12 + ((i14 + i12) * i)] = (((((i17 + iArr[(i16 % i) + (((i14 + i10) % i2) * i)]) + iArr[((i16 + i10) % i) + ((i14 % i2) * i)]) + iArr[((i16 + i10) % i) + (((i14 + i10) % i2) * i)]) / 4) + this.f9a.nextInt(i11 << 1)) - i11;
                        if (this.f12d && (i16 == 0 || i14 == 0)) {
                            iArr[i16 + (i14 * i)] = 0;
                        }
                        i15 = i16 + i10;
                    }
                }
                i13 = i14 + i10;
            }
            int i18 = 0;
            while (true) {
                int i19 = i18;
                if (i19 < i2) {
                    int i20 = 0;
                    while (true) {
                        int i21 = i20;
                        if (i21 < i) {
                            int i22 = iArr[i21 + (i19 * i)];
                            int i23 = iArr[((i21 + i10) % i) + (i19 * i)];
                            int i24 = iArr[i21 + (((i19 + i10) % i) * i)];
                            int i25 = iArr[((i21 + i12) & (i - 1)) + ((((i19 + i12) - i10) & (i2 - 1)) * i)];
                            int i26 = iArr[(((i21 + i12) - i10) & (i - 1)) + (((i19 + i12) & (i2 - 1)) * i)];
                            int i27 = iArr[((i21 + i12) % i) + (((i19 + i12) % i2) * i)];
                            int iNextInt = (((((i22 + i23) + i27) + i25) / 4) + this.f9a.nextInt(i11 << 1)) - i11;
                            int iNextInt2 = (((((i22 + i24) + i27) + i26) / 4) + this.f9a.nextInt(i11 << 1)) - i11;
                            iArr[i21 + i12 + (i19 * i)] = iNextInt;
                            iArr[i21 + ((i19 + i12) * i)] = iNextInt2;
                            i20 = i21 + i10;
                        }
                    }
                    i18 = i19 + i10;
                }
            }
            i9 = i10 / 2;
        }
        int[] iArr2 = new int[i * i2];
        for (int i28 = 0; i28 < i2; i28++) {
            for (int i29 = 0; i29 < i; i29++) {
                iArr2[i29 + (i28 * i)] = (iArr[(i29 % i) + ((i28 % i2) * i)] / 512) + 128;
            }
        }
        return iArr2;
    }
}
