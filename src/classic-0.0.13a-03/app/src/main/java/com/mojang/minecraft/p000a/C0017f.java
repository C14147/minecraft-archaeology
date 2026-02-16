package com.mojang.minecraft.p000a;

import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p008f.C0041a;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.f */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/f.class */
public final class C0017f {

    /* JADX INFO: renamed from: a */
    public int f77a;

    /* JADX INFO: renamed from: b */
    public int f78b;

    /* JADX INFO: renamed from: c */
    public int f79c;

    /* JADX INFO: renamed from: d */
    public byte[] f80d;

    /* JADX INFO: renamed from: l */
    private int[] f81l;

    /* JADX INFO: renamed from: h */
    public String f85h;

    /* JADX INFO: renamed from: i */
    public String f86i;

    /* JADX INFO: renamed from: j */
    public long f87j;

    /* JADX INFO: renamed from: e */
    ArrayList f82e = new ArrayList();

    /* JADX INFO: renamed from: f */
    public Random f83f = new Random();

    /* JADX INFO: renamed from: g */
    public int f84g = this.f83f.nextInt();

    /* JADX INFO: renamed from: k */
    public int f88k = 0;

    /* JADX INFO: renamed from: a */
    public final void m46a(int i, int i2, int i3, byte[] bArr) {
        this.f77a = i;
        this.f78b = i3;
        this.f79c = i2;
        this.f80d = bArr;
        this.f81l = new int[i * i3];
        m47c(0, 0, i, i3);
        for (int i4 = 0; i4 < this.f82e.size(); i4++) {
            ((C0016e) this.f82e.get(i4)).m41a();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m47c(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                int i7 = this.f81l[i5 + (i6 * this.f77a)];
                int i8 = this.f79c - 1;
                while (i8 > 0) {
                    C0002a c0002a = C0002a.f10a[m53b(i5, i8, i6)];
                    if (c0002a == null ? false : c0002a.mo16a()) {
                        break;
                    } else {
                        i8--;
                    }
                }
                this.f81l[i5 + (i6 * this.f77a)] = i8 + 1;
                if (i7 != i8) {
                    int i9 = i7 < i8 ? i7 : i8;
                    int i10 = i7 > i8 ? i7 : i8;
                    for (int i11 = 0; i11 < this.f82e.size(); i11++) {
                        int i12 = i5;
                        int i13 = i6;
                        ((C0016e) this.f82e.get(i11)).m45a(i12 - 1, i9 - 1, i13 - 1, i12 + 1, i10 + 1, i13 + 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final ArrayList m48a(C0041a c0041a) {
        C0041a c0041aMo15b;
        C0041a c0041aMo15b2;
        ArrayList arrayList = new ArrayList();
        int iFloor = (int) Math.floor(c0041a.f224a);
        int iFloor2 = (int) Math.floor(c0041a.f227d + 1.0f);
        int iFloor3 = (int) Math.floor(c0041a.f225b);
        int iFloor4 = (int) Math.floor(c0041a.f228e + 1.0f);
        int iFloor5 = (int) Math.floor(c0041a.f226c);
        int iFloor6 = (int) Math.floor(c0041a.f229f + 1.0f);
        for (int i = iFloor; i < iFloor2; i++) {
            for (int i2 = iFloor3; i2 < iFloor4; i2++) {
                for (int i3 = iFloor5; i3 < iFloor6; i3++) {
                    if (i >= 0 && i2 >= 0 && i3 >= 0 && i < this.f77a && i2 < this.f79c && i3 < this.f78b) {
                        C0002a c0002a = C0002a.f10a[m53b(i, i2, i3)];
                        if (c0002a != null && (c0041aMo15b2 = c0002a.mo15b(i, i2, i3)) != null) {
                            arrayList.add(c0041aMo15b2);
                        }
                    } else if ((i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i3 >= this.f78b) && (c0041aMo15b = C0002a.f15f.mo15b(i, i2, i3)) != null) {
                        arrayList.add(c0041aMo15b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m49a(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i2 >= this.f79c || i3 >= this.f78b || i4 == this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i]) {
            return false;
        }
        this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i] = (byte) i4;
        m51d(i - 1, i2, i3, i4);
        m51d(i + 1, i2, i3, i4);
        m51d(i, i2 - 1, i3, i4);
        m51d(i, i2 + 1, i3, i4);
        m51d(i, i2, i3 - 1, i4);
        m51d(i, i2, i3 + 1, i4);
        m47c(i, i3, 1, 1);
        for (int i5 = 0; i5 < this.f82e.size(); i5++) {
            ((C0016e) this.f82e.get(i5)).m45a(i - 1, i2 - 1, i3 - 1, i + 1, i2 + 1, i3 + 1);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m50b(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i2 >= this.f79c || i3 >= this.f78b || i4 == this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i]) {
            return false;
        }
        this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i] = (byte) i4;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private void m51d(int i, int i2, int i3, int i4) {
        C0002a c0002a;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i2 >= this.f79c || i3 >= this.f78b || (c0002a = C0002a.f10a[this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i]]) == null) {
            return;
        }
        c0002a.mo22a(this, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m52a(int i, int i2, int i3) {
        return i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i2 >= this.f79c || i3 >= this.f78b || i2 >= this.f81l[i + (i3 * this.f77a)];
    }

    /* JADX INFO: renamed from: b */
    public final int m53b(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f77a || i2 >= this.f79c || i3 >= this.f78b) {
            return 0;
        }
        return this.f80d[(((i2 * this.f78b) + i3) * this.f77a) + i];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m54a(C0041a c0041a, int i) {
        int iFloor = (int) Math.floor(c0041a.f224a);
        int iFloor2 = (int) Math.floor(c0041a.f227d + 1.0f);
        int iFloor3 = (int) Math.floor(c0041a.f225b);
        int iFloor4 = (int) Math.floor(c0041a.f228e + 1.0f);
        int iFloor5 = (int) Math.floor(c0041a.f226c);
        int iFloor6 = (int) Math.floor(c0041a.f229f + 1.0f);
        if (iFloor < 0) {
            iFloor = 0;
        }
        if (iFloor3 < 0) {
            iFloor3 = 0;
        }
        if (iFloor5 < 0) {
            iFloor5 = 0;
        }
        if (iFloor2 > this.f77a) {
            iFloor2 = this.f77a;
        }
        if (iFloor4 > this.f79c) {
            iFloor4 = this.f79c;
        }
        if (iFloor6 > this.f78b) {
            iFloor6 = this.f78b;
        }
        for (int i2 = iFloor; i2 < iFloor2; i2++) {
            for (int i3 = iFloor3; i3 < iFloor4; i3++) {
                for (int i4 = iFloor5; i4 < iFloor6; i4++) {
                    C0002a c0002a = C0002a.f10a[m53b(i2, i3, i4)];
                    if (c0002a != null && c0002a.mo21d() == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
