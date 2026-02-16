package com.mojang.minecraft.level.p004b;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0008b;
import com.mojang.minecraft.level.p004b.p005a.C0018a;
import com.mojang.minecraft.level.p004b.p005a.C0020c;
import com.mojang.minecraft.server.MinecraftServer;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/b/a.class */
public final class C0017a {

    /* JADX INFO: renamed from: a */
    private MinecraftServer f79a;

    /* JADX INFO: renamed from: b */
    private int f80b;

    /* JADX INFO: renamed from: c */
    private int f81c;

    /* JADX INFO: renamed from: d */
    private int f82d;

    /* JADX INFO: renamed from: f */
    private byte[] f84f;

    /* JADX INFO: renamed from: e */
    private Random f83e = new Random();

    /* JADX INFO: renamed from: g */
    private int[] f85g = new int[1048576];

    public C0017a(MinecraftServer minecraftServer) {
        this.f79a = minecraftServer;
    }

    /* JADX INFO: renamed from: a */
    public final Level m21a(String str, int i, int i2, int i3) {
        this.f79a.m39a("Generating level");
        this.f80b = 256;
        this.f81c = 256;
        this.f82d = 64;
        this.f84f = new byte[(256 << 8) << 6];
        this.f79a.m40b("Raising..");
        C0018a c0018a = new C0018a(new C0020c(this.f83e, 8), new C0020c(this.f83e, 8));
        C0018a c0018a2 = new C0018a(new C0020c(this.f83e, 8), new C0020c(this.f83e, 8));
        C0020c c0020c = new C0020c(this.f83e, 8);
        int[] iArr = new int[this.f80b * this.f81c];
        for (int i4 = 0; i4 < this.f80b; i4++) {
            for (int i5 = 0; i5 < this.f81c; i5++) {
                double dMo27a = (c0018a.mo27a(i4 * 1.3f, i5 * 1.3f) / 8.0d) - 8.0d;
                double dMo27a2 = (c0018a2.mo27a(i4 * 1.3f, i5 * 1.3f) / 6.0d) + 6.0d;
                if (c0020c.mo27a(i4, i5) / 8.0d > 0.0d) {
                    dMo27a2 = dMo27a;
                }
                double dMax = Math.max(dMo27a, dMo27a2) / 2.0d;
                double d = dMax;
                if (dMax < 0.0d) {
                    d /= 2.0d;
                }
                iArr[i4 + (i5 * this.f80b)] = (int) d;
            }
        }
        this.f79a.m40b("Eroding..");
        C0018a c0018a3 = new C0018a(new C0020c(this.f83e, 8), new C0020c(this.f83e, 8));
        C0018a c0018a4 = new C0018a(new C0020c(this.f83e, 8), new C0020c(this.f83e, 8));
        for (int i6 = 0; i6 < this.f80b; i6++) {
            for (int i7 = 0; i7 < this.f81c; i7++) {
                double dMo27a3 = c0018a3.mo27a(i6 << 1, i7 << 1) / 8.0d;
                int i8 = c0018a4.mo27a((double) (i6 << 1), (double) (i7 << 1)) > 0.0d ? 1 : 0;
                if (dMo27a3 > 2.0d) {
                    iArr[i6 + (i7 * this.f80b)] = (((iArr[i6 + (i7 * this.f80b)] - i8) / 2) << 1) + i8;
                }
            }
        }
        this.f79a.m40b("Soiling..");
        int i9 = this.f80b;
        int i10 = this.f81c;
        int i11 = this.f82d;
        C0020c c0020c2 = new C0020c(this.f83e, 8);
        for (int i12 = 0; i12 < i9; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                int iMo27a = ((int) (c0020c2.mo27a(i12, i13) / 24.0d)) - 4;
                int i14 = iArr[i12 + (i13 * i9)] + (i11 / 2);
                int i15 = i14 + iMo27a;
                iArr[i12 + (i13 * i9)] = Math.max(i14, i15);
                for (int i16 = 0; i16 < i11; i16++) {
                    int i17 = (((i16 * this.f81c) + i13) * this.f80b) + i12;
                    int i18 = i16 <= i14 ? C0008b.f54e.f70u : 0;
                    if (i16 <= i15) {
                        i18 = C0008b.f52c.f70u;
                    }
                    this.f84f[i17] = (byte) i18;
                }
            }
        }
        this.f79a.m40b("Carving..");
        int i19 = this.f80b;
        int i20 = this.f81c;
        int i21 = this.f82d;
        int i22 = (((i19 * i20) * i21) / 256) / 64;
        for (int i23 = 0; i23 < i22; i23++) {
            float fNextFloat = this.f83e.nextFloat() * i19;
            float fNextFloat2 = this.f83e.nextFloat() * i21;
            float fNextFloat3 = this.f83e.nextFloat() * i20;
            int iNextFloat = (int) ((this.f83e.nextFloat() + this.f83e.nextFloat()) * 75.0f);
            float fNextFloat4 = (float) (((double) this.f83e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) this.f83e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i24 = 0; i24 < iNextFloat; i24++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (this.f83e.nextFloat() - this.f83e.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (this.f83e.nextFloat() - this.f83e.nextFloat());
                float fSin = (float) ((Math.sin((((double) i24) * 3.141592653589793d) / ((double) iNextFloat)) * 2.5d) + 1.0d);
                for (int i25 = (int) (fNextFloat - fSin); i25 <= ((int) (fNextFloat + fSin)); i25++) {
                    for (int i26 = (int) (fNextFloat2 - fSin); i26 <= ((int) (fNextFloat2 + fSin)); i26++) {
                        for (int i27 = (int) (fNextFloat3 - fSin); i27 <= ((int) (fNextFloat3 + fSin)); i27++) {
                            float f = i25 - fNextFloat;
                            float f2 = i26 - fNextFloat2;
                            float f3 = i27 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i25 >= 1 && i26 >= 1 && i27 >= 1 && i25 < this.f80b - 1 && i26 < this.f82d - 1 && i27 < this.f81c - 1) {
                                int i28 = (((i26 * this.f81c) + i27) * this.f80b) + i25;
                                if (this.f84f[i28] == C0008b.f52c.f70u) {
                                    this.f84f[i28] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        m24a(C0008b.f67r.f70u, 90, 1, 4);
        m24a(C0008b.f66q.f70u, 70, 2, 4);
        m24a(C0008b.f65p.f70u, 50, 3, 4);
        this.f79a.m40b("Watering..");
        long jNanoTime = System.nanoTime();
        long jM26a = 0;
        int i29 = C0008b.f60k.f70u;
        for (int i30 = 0; i30 < this.f80b; i30++) {
            jM26a = jM26a + m26a(i30, (this.f82d / 2) - 1, 0, 0, i29) + m26a(i30, (this.f82d / 2) - 1, this.f81c - 1, 0, i29);
        }
        for (int i31 = 0; i31 < this.f81c; i31++) {
            jM26a = jM26a + m26a(0, (this.f82d / 2) - 1, i31, 0, i29) + m26a(this.f80b - 1, (this.f82d / 2) - 1, i31, 0, i29);
        }
        int i32 = (this.f80b * this.f81c) / 200;
        for (int i33 = 0; i33 < i32; i33++) {
            int iNextInt = this.f83e.nextInt(this.f80b);
            int iNextInt2 = ((this.f82d / 2) - 1) - this.f83e.nextInt(3);
            int iNextInt3 = this.f83e.nextInt(this.f81c);
            if (this.f84f[(((iNextInt2 * this.f81c) + iNextInt3) * this.f80b) + iNextInt] == 0) {
                jM26a += m26a(iNextInt, iNextInt2, iNextInt3, 0, i29);
            }
        }
        System.out.println("Flood filled " + jM26a + " tiles in " + ((System.nanoTime() - jNanoTime) / 1000000.0d) + " ms");
        this.f79a.m40b("Melting..");
        m25a();
        this.f79a.m40b("Growing..");
        m22a(iArr);
        this.f79a.m40b("Planting..");
        m23b(iArr);
        Level level = new Level();
        level.setData(256, 64, 256, this.f84f);
        level.createTime = System.currentTimeMillis();
        level.creator = str;
        level.name = "A Nice World";
        return level;
    }

    /* JADX INFO: renamed from: a */
    private void m22a(int[] iArr) {
        int i = this.f80b;
        int i2 = this.f81c;
        int i3 = this.f82d;
        C0020c c0020c = new C0020c(this.f83e, 8);
        C0020c c0020c2 = new C0020c(this.f83e, 8);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                boolean z = c0020c.mo27a((double) i4, (double) i5) > 8.0d;
                boolean z2 = c0020c2.mo27a((double) i4, (double) i5) > 12.0d;
                int i6 = iArr[i4 + (i5 * i)];
                int i7 = (((i6 * this.f81c) + i5) * this.f80b) + i4;
                int i8 = this.f84f[((((i6 + 1) * this.f81c) + i5) * this.f80b) + i4] & 255;
                if ((i8 == C0008b.f59j.f70u || i8 == C0008b.f60k.f70u) && i6 <= (i3 / 2) - 1 && z2) {
                    this.f84f[i7] = (byte) C0008b.f64o.f70u;
                }
                if (i8 == 0) {
                    int i9 = C0008b.f53d.f70u;
                    if (i6 <= (i3 / 2) - 1 && z) {
                        i9 = C0008b.f63n.f70u;
                    }
                    this.f84f[i7] = (byte) i9;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m23b(int[] iArr) {
        int i = this.f80b;
        int i2 = (this.f80b * this.f81c) / 4000;
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt = this.f83e.nextInt(this.f80b);
            int iNextInt2 = this.f83e.nextInt(this.f81c);
            for (int i4 = 0; i4 < 20; i4++) {
                int iNextInt3 = iNextInt;
                int iNextInt4 = iNextInt2;
                for (int i5 = 0; i5 < 20; i5++) {
                    iNextInt3 += this.f83e.nextInt(6) - this.f83e.nextInt(6);
                    iNextInt4 += this.f83e.nextInt(6) - this.f83e.nextInt(6);
                    if (iNextInt3 >= 0 && iNextInt4 >= 0 && iNextInt3 < this.f80b && iNextInt4 < this.f81c) {
                        int i6 = iArr[iNextInt3 + (iNextInt4 * i)] + 1;
                        int iNextInt5 = this.f83e.nextInt(3) + 4;
                        boolean z = true;
                        for (int i7 = i6; i7 <= i6 + 1 + iNextInt5; i7++) {
                            int i8 = i7 >= ((i6 + 1) + iNextInt5) - 2 ? 2 : 1;
                            for (int i9 = iNextInt3 - i8; i9 <= iNextInt3 + i8 && z; i9++) {
                                for (int i10 = iNextInt4 - i8; i10 <= iNextInt4 + i8 && z; i10++) {
                                    if (i9 < 0 || i7 < 0 || i10 < 0 || i9 >= this.f80b || i7 >= this.f82d || i10 >= this.f81c) {
                                        z = false;
                                    } else if ((this.f84f[(((i7 * this.f81c) + i10) * this.f80b) + i9] & 255) != 0) {
                                        z = false;
                                    }
                                }
                            }
                        }
                        if (z) {
                            int i11 = (((i6 * this.f81c) + iNextInt4) * this.f80b) + iNextInt3;
                            if ((this.f84f[((((i6 - 1) * this.f81c) + iNextInt4) * this.f80b) + iNextInt3] & 255) == C0008b.f53d.f70u && i6 < (this.f82d - iNextInt5) - 1) {
                                this.f84f[i11 - ((1 * this.f80b) * this.f81c)] = (byte) C0008b.f54e.f70u;
                                for (int i12 = (i6 - 3) + iNextInt5; i12 <= i6 + iNextInt5; i12++) {
                                    int i13 = i12 - (i6 + iNextInt5);
                                    int i14 = 1 - (i13 / 2);
                                    for (int i15 = iNextInt3 - i14; i15 <= iNextInt3 + i14; i15++) {
                                        int i16 = i15 - iNextInt3;
                                        for (int i17 = iNextInt4 - i14; i17 <= iNextInt4 + i14; i17++) {
                                            int i18 = i17 - iNextInt4;
                                            if (Math.abs(i16) != i14 || Math.abs(i18) != i14 || (this.f83e.nextInt(2) != 0 && i13 != 0)) {
                                                this.f84f[(((i12 * this.f81c) + i17) * this.f80b) + i15] = (byte) C0008b.f69t.f70u;
                                            }
                                        }
                                    }
                                }
                                for (int i19 = 0; i19 < iNextInt5; i19++) {
                                    this.f84f[i11 + (i19 * this.f80b * this.f81c)] = (byte) C0008b.f68s.f70u;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m24a(int i, int i2, int i3, int i4) {
        byte b = (byte) i;
        int i5 = this.f80b;
        int i6 = this.f81c;
        int i7 = this.f82d;
        int i8 = (((((i5 * i6) * i7) / 256) / 64) * i2) / 100;
        for (int i9 = 0; i9 < i8; i9++) {
            float fNextFloat = this.f83e.nextFloat() * i5;
            float fNextFloat2 = this.f83e.nextFloat() * i7;
            float fNextFloat3 = this.f83e.nextFloat() * i6;
            int iNextFloat = (int) ((((this.f83e.nextFloat() + this.f83e.nextFloat()) * 75.0f) * i2) / 100.0f);
            float fNextFloat4 = (float) (((double) this.f83e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) this.f83e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i10 = 0; i10 < iNextFloat; i10++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (this.f83e.nextFloat() - this.f83e.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (this.f83e.nextFloat() - this.f83e.nextFloat());
                float fSin = (float) (((Math.sin((((double) i10) * 3.141592653589793d) / ((double) iNextFloat)) * ((double) i2)) / 100.0d) + 1.0d);
                for (int i11 = (int) (fNextFloat - fSin); i11 <= ((int) (fNextFloat + fSin)); i11++) {
                    for (int i12 = (int) (fNextFloat2 - fSin); i12 <= ((int) (fNextFloat2 + fSin)); i12++) {
                        for (int i13 = (int) (fNextFloat3 - fSin); i13 <= ((int) (fNextFloat3 + fSin)); i13++) {
                            float f = i11 - fNextFloat;
                            float f2 = i12 - fNextFloat2;
                            float f3 = i13 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i11 >= 1 && i12 >= 1 && i13 >= 1 && i11 < this.f80b - 1 && i12 < this.f82d - 1 && i13 < this.f81c - 1) {
                                int i14 = (((i12 * this.f81c) + i13) * this.f80b) + i11;
                                if (this.f84f[i14] == C0008b.f52c.f70u) {
                                    this.f84f[i14] = b;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m25a() {
        int i = 0;
        int i2 = ((this.f80b * this.f81c) * this.f82d) / 10000;
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt = this.f83e.nextInt(this.f80b);
            int iNextInt2 = this.f83e.nextInt((this.f82d / 2) - 4);
            int iNextInt3 = this.f83e.nextInt(this.f81c);
            if (this.f84f[(((iNextInt2 * this.f81c) + iNextInt3) * this.f80b) + iNextInt] == 0) {
                i++;
                m26a(iNextInt, iNextInt2, iNextInt3, 0, C0008b.f62m.f70u);
            }
        }
        System.out.println("LavaCount: " + i);
    }

    /* JADX INFO: renamed from: a */
    private long m26a(int i, int i2, int i3, int i4, int i5) {
        byte b = (byte) i5;
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        int i7 = 1;
        while ((1 << i6) < this.f80b) {
            i6++;
        }
        while ((1 << i7) < this.f81c) {
            i7++;
        }
        int i8 = this.f81c - 1;
        int i9 = this.f80b - 1;
        int length = 0 + 1;
        this.f85g[0] = (((i2 << i7) + i3) << i6) + i;
        long j = 0;
        int i10 = this.f80b * this.f81c;
        while (length > 0) {
            length--;
            int i11 = this.f85g[length];
            if (length == 0 && arrayList.size() > 0) {
                System.out.println("IT HAPPENED!");
                this.f85g = (int[]) arrayList.remove(arrayList.size() - 1);
                length = this.f85g.length;
            }
            int i12 = (i11 >> i6) & i8;
            int i13 = i11 >> (i6 + i7);
            int i14 = i11 & i9;
            int i15 = i14;
            int i16 = i14;
            while (i15 > 0 && this.f84f[i11 - 1] == 0) {
                i15--;
                i11--;
            }
            while (i16 < this.f80b && this.f84f[(i11 + i16) - i15] == 0) {
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
                this.f84f[i11] = b;
                if (i12 > 0) {
                    boolean z4 = this.f84f[i11 - this.f80b] == 0;
                    boolean z5 = z4;
                    if (z4 && !z) {
                        if (length == this.f85g.length) {
                            arrayList.add(this.f85g);
                            this.f85g = new int[1048576];
                            length = 0;
                        }
                        int i20 = length;
                        length++;
                        this.f85g[i20] = i11 - this.f80b;
                    }
                    z = z5;
                }
                if (i12 < this.f81c - 1) {
                    boolean z6 = this.f84f[i11 + this.f80b] == 0;
                    boolean z7 = z6;
                    if (z6 && !z2) {
                        if (length == this.f85g.length) {
                            arrayList.add(this.f85g);
                            this.f85g = new int[1048576];
                            length = 0;
                        }
                        int i21 = length;
                        length++;
                        this.f85g[i21] = i11 + this.f80b;
                    }
                    z2 = z7;
                }
                if (i13 > 0) {
                    byte b2 = this.f84f[i11 - i10];
                    if ((b == C0008b.f61l.f70u || b == C0008b.f62m.f70u) && (b2 == C0008b.f59j.f70u || b2 == C0008b.f60k.f70u)) {
                        this.f84f[i11 - i10] = (byte) C0008b.f52c.f70u;
                    }
                    boolean z8 = b2 == 0;
                    boolean z9 = z8;
                    if (z8 && !z3) {
                        if (length == this.f85g.length) {
                            arrayList.add(this.f85g);
                            this.f85g = new int[1048576];
                            length = 0;
                        }
                        int i22 = length;
                        length++;
                        this.f85g[i22] = i11 - i10;
                    }
                    z3 = z9;
                }
                i11++;
            }
        }
        return j;
    }
}
