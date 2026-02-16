package com.mojang.minecraft.p000a.p002b;

import com.mojang.minecraft.RunnableC0022c;
import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p000a.p002b.p003a.C0010a;
import com.mojang.minecraft.p000a.p002b.p003a.C0011b;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/b/a.class */
public final class C0009a {

    /* JADX INFO: renamed from: a */
    private RunnableC0022c f33a;

    /* JADX INFO: renamed from: b */
    private int f34b;

    /* JADX INFO: renamed from: c */
    private int f35c;

    /* JADX INFO: renamed from: d */
    private int f36d;

    /* JADX INFO: renamed from: f */
    private byte[] f38f;

    /* JADX INFO: renamed from: e */
    private Random f37e = new Random();

    /* JADX INFO: renamed from: g */
    private int[] f39g = new int[1048576];

    public C0009a(RunnableC0022c runnableC0022c) {
        this.f33a = runnableC0022c;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m25a(C0017f c0017f, String str, int i, int i2, int i3) {
        this.f33a.m79a("Generating level");
        this.f34b = 256;
        this.f35c = 256;
        this.f36d = 64;
        this.f38f = new byte[(256 << 8) << 6];
        this.f33a.m80b("Raising..");
        C0010a c0010a = new C0010a(new C0011b(this.f37e, 8), new C0011b(this.f37e, 8));
        C0010a c0010a2 = new C0010a(new C0011b(this.f37e, 8), new C0011b(this.f37e, 8));
        C0011b c0011b = new C0011b(this.f37e, 8);
        int[] iArr = new int[this.f34b * this.f35c];
        for (int i4 = 0; i4 < this.f34b; i4++) {
            m26a((i4 * 100) / (this.f34b - 1));
            for (int i5 = 0; i5 < this.f35c; i5++) {
                double dMo29a = (c0010a.mo29a(i4, i5) / 8.0d) - 8.0d;
                double dMo29a2 = (c0010a2.mo29a(i4, i5) / 8.0d) + 8.0d;
                if (c0011b.mo29a(i4, i5) / 8.0d > 2.0d) {
                    dMo29a2 = dMo29a;
                }
                double dMax = Math.max(dMo29a, dMo29a2);
                iArr[i4 + (i5 * this.f34b)] = (int) (((((dMax * dMax) * dMax) / 100.0d) + (dMax * 3.0d)) / 8.0d);
            }
        }
        this.f33a.m80b("Eroding..");
        C0010a c0010a3 = new C0010a(new C0011b(this.f37e, 8), new C0011b(this.f37e, 8));
        C0010a c0010a4 = new C0010a(new C0011b(this.f37e, 8), new C0011b(this.f37e, 8));
        for (int i6 = 0; i6 < this.f34b; i6++) {
            m26a((i6 * 100) / (this.f34b - 1));
            for (int i7 = 0; i7 < this.f35c; i7++) {
                double dMo29a3 = c0010a3.mo29a(i6 << 1, i7 << 1) / 8.0d;
                int i8 = c0010a4.mo29a((double) (i6 << 1), (double) (i7 << 1)) > 0.0d ? 1 : 0;
                if (dMo29a3 > 2.0d) {
                    iArr[i6 + (i7 * this.f34b)] = (((iArr[i6 + (i7 * this.f34b)] - i8) / 2) << 1) + i8;
                }
            }
        }
        this.f33a.m80b("Soiling..");
        int i9 = this.f34b;
        int i10 = this.f35c;
        int i11 = this.f36d;
        for (int i12 = 0; i12 < i9; i12++) {
            m26a((i12 * 100) / (this.f34b - 1));
            for (int i13 = 0; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    int i15 = (((i13 * this.f35c) + i14) * this.f34b) + i12;
                    int i16 = iArr[i12 + (i14 * i9)] + (i11 / 2);
                    int i17 = i16 - 2;
                    int i18 = 0;
                    if (i13 == i16 && i13 >= (i11 / 2) - 1) {
                        i18 = C0002a.f13d.f21l;
                    } else if (i13 <= i16) {
                        i18 = C0002a.f14e.f21l;
                    }
                    if (i13 <= i17) {
                        i18 = C0002a.f12c.f21l;
                    }
                    this.f38f[i15] = (byte) i18;
                }
            }
        }
        this.f33a.m80b("Carving..");
        int i19 = this.f34b;
        int i20 = this.f35c;
        int i21 = this.f36d;
        int i22 = (((i19 * i20) * i21) / 256) / 64;
        for (int i23 = 0; i23 < i22; i23++) {
            m26a((i23 * 100) / (i22 - 1));
            float fNextFloat = this.f37e.nextFloat() * i19;
            float fNextFloat2 = this.f37e.nextFloat() * i21;
            float fNextFloat3 = this.f37e.nextFloat() * i20;
            int iNextFloat = (int) (this.f37e.nextFloat() + (this.f37e.nextFloat() * 150.0f));
            float fNextFloat4 = (float) (((double) this.f37e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) this.f37e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i24 = 0; i24 < iNextFloat; i24++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (this.f37e.nextFloat() - this.f37e.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (this.f37e.nextFloat() - this.f37e.nextFloat());
                float fSin = (float) ((Math.sin((((double) i24) * 3.141592653589793d) / ((double) iNextFloat)) * 2.5d) + 1.0d);
                for (int i25 = (int) (fNextFloat - fSin); i25 <= ((int) (fNextFloat + fSin)); i25++) {
                    for (int i26 = (int) (fNextFloat2 - fSin); i26 <= ((int) (fNextFloat2 + fSin)); i26++) {
                        for (int i27 = (int) (fNextFloat3 - fSin); i27 <= ((int) (fNextFloat3 + fSin)); i27++) {
                            float f = i25 - fNextFloat;
                            float f2 = i26 - fNextFloat2;
                            float f3 = i27 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i25 >= 1 && i26 >= 1 && i27 >= 1 && i25 < this.f34b - 1 && i26 < this.f36d - 1 && i27 < this.f35c - 1) {
                                int i28 = (((i26 * this.f35c) + i27) * this.f34b) + i25;
                                if (this.f38f[i28] == C0002a.f12c.f21l) {
                                    this.f38f[i28] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f33a.m80b("Watering..");
        long jNanoTime = System.nanoTime();
        long jM28a = 0;
        int i29 = C0002a.f17h.f21l;
        m26a(0);
        for (int i30 = 0; i30 < this.f34b; i30++) {
            jM28a = jM28a + m28a(i30, (this.f36d / 2) - 1, 0, 0, i29) + m28a(i30, (this.f36d / 2) - 1, this.f35c - 1, 0, i29);
        }
        for (int i31 = 0; i31 < this.f35c; i31++) {
            jM28a = jM28a + m28a(0, (this.f36d / 2) - 1, i31, 0, i29) + m28a(this.f34b - 1, (this.f36d / 2) - 1, i31, 0, i29);
        }
        int i32 = (this.f34b * this.f35c) / 200;
        for (int i33 = 0; i33 < i32; i33++) {
            if (i33 % 100 == 0) {
                m26a((i33 * 100) / (i32 - 1));
            }
            int iNextInt = this.f37e.nextInt(this.f34b);
            int iNextInt2 = ((this.f36d / 2) - 1) - this.f37e.nextInt(3);
            int iNextInt3 = this.f37e.nextInt(this.f35c);
            if (this.f38f[(((iNextInt2 * this.f35c) + iNextInt3) * this.f34b) + iNextInt] == 0) {
                jM28a += m28a(iNextInt, iNextInt2, iNextInt3, 0, i29);
            }
        }
        m26a(100);
        System.out.println("Flood filled " + jM28a + " tiles in " + ((System.nanoTime() - jNanoTime) / 1000000.0d) + " ms");
        this.f33a.m80b("Melting..");
        m27a();
        c0017f.m46a(256, 64, 256, this.f38f);
        c0017f.f87j = System.currentTimeMillis();
        c0017f.f86i = str;
        c0017f.f85h = "A Nice World";
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m26a(int i) {
        this.f33a.m81a(i);
    }

    /* JADX INFO: renamed from: a */
    private void m27a() {
        int i = 0;
        int i2 = ((this.f34b * this.f35c) * this.f36d) / 10000;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 % 100 == 0) {
                m26a((i3 * 100) / (i2 - 1));
            }
            int iNextInt = this.f37e.nextInt(this.f34b);
            int iNextInt2 = this.f37e.nextInt((this.f36d / 2) - 4);
            int iNextInt3 = this.f37e.nextInt(this.f35c);
            if (this.f38f[(((iNextInt2 * this.f35c) + iNextInt3) * this.f34b) + iNextInt] == 0) {
                i++;
                m28a(iNextInt, iNextInt2, iNextInt3, 0, C0002a.f19j.f21l);
            }
        }
        m26a(100);
        System.out.println("LavaCount: " + i);
    }

    /* JADX INFO: renamed from: a */
    private long m28a(int i, int i2, int i3, int i4, int i5) {
        byte b = (byte) i5;
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        int i7 = 1;
        while ((1 << i6) < this.f34b) {
            i6++;
        }
        while ((1 << i7) < this.f35c) {
            i7++;
        }
        int i8 = this.f35c - 1;
        int i9 = this.f34b - 1;
        int length = 0 + 1;
        this.f39g[0] = (((i2 << i7) + i3) << i6) + i;
        long j = 0;
        int i10 = this.f34b * this.f35c;
        while (length > 0) {
            length--;
            int i11 = this.f39g[length];
            if (length == 0 && arrayList.size() > 0) {
                System.out.println("IT HAPPENED!");
                this.f39g = (int[]) arrayList.remove(arrayList.size() - 1);
                length = this.f39g.length;
            }
            int i12 = (i11 >> i6) & i8;
            int i13 = i11 >> (i6 + i7);
            int i14 = i11 & i9;
            int i15 = i14;
            int i16 = i14;
            while (i15 > 0 && this.f38f[i11 - 1] == 0) {
                i15--;
                i11--;
            }
            while (i16 < this.f34b && this.f38f[(i11 + i16) - i15] == 0) {
                i16++;
            }
            int i17 = (i11 >> i6) & i8;
            int i18 = i11 >> (i6 + i7);
            if (i17 != i12 || i18 != i13) {
                System.out.println("hoooly fuck");
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            j += (long) (i16 - i15);
            for (int i19 = i15; i19 < i16; i19++) {
                this.f38f[i11] = b;
                if (i12 > 0) {
                    boolean z4 = this.f38f[i11 - this.f34b] == 0;
                    boolean z5 = z4;
                    if (z4 && !z) {
                        if (length == this.f39g.length) {
                            arrayList.add(this.f39g);
                            this.f39g = new int[1048576];
                            length = 0;
                        }
                        int i20 = length;
                        length++;
                        this.f39g[i20] = i11 - this.f34b;
                    }
                    z = z5;
                }
                if (i12 < this.f35c - 1) {
                    boolean z6 = this.f38f[i11 + this.f34b] == 0;
                    boolean z7 = z6;
                    if (z6 && !z2) {
                        if (length == this.f39g.length) {
                            arrayList.add(this.f39g);
                            this.f39g = new int[1048576];
                            length = 0;
                        }
                        int i21 = length;
                        length++;
                        this.f39g[i21] = i11 + this.f34b;
                    }
                    z2 = z7;
                }
                if (i13 > 0) {
                    byte b2 = this.f38f[i11 - i10];
                    if ((b == C0002a.f18i.f21l || b == C0002a.f19j.f21l) && (b2 == C0002a.f16g.f21l || b2 == C0002a.f17h.f21l)) {
                        this.f38f[i11 - i10] = (byte) C0002a.f12c.f21l;
                    }
                    boolean z8 = b2 == 0;
                    boolean z9 = z8;
                    if (z8 && !z3) {
                        if (length == this.f39g.length) {
                            arrayList.add(this.f39g);
                            this.f39g = new int[1048576];
                            length = 0;
                        }
                        int i22 = length;
                        length++;
                        this.f39g[i22] = i11 - i10;
                    }
                    z3 = z9;
                }
                i11++;
            }
        }
        return j;
    }
}
