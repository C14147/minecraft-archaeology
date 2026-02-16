package com.mojang.minecraft.level.p004b;

import com.mojang.minecraft.RunnableC0027d;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.level.p004b.p005a.C0041a;
import com.mojang.minecraft.level.p004b.p005a.C0042b;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.b.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/b/a.class */
public final class C0040a {

    /* JADX INFO: renamed from: a */
    private RunnableC0027d f235a;

    /* JADX INFO: renamed from: b */
    private int f236b;

    /* JADX INFO: renamed from: c */
    private int f237c;

    /* JADX INFO: renamed from: d */
    private int f238d;

    /* JADX INFO: renamed from: f */
    private byte[] f240f;

    /* JADX INFO: renamed from: e */
    private Random f239e = new Random();

    /* JADX INFO: renamed from: g */
    private int[] f241g = new int[1048576];

    public C0040a(RunnableC0027d runnableC0027d) {
        this.f235a = runnableC0027d;
    }

    /* JADX INFO: renamed from: a */
    public final Level m115a(String str, int i, int i2, int i3) {
        this.f235a.m72a("Generating level");
        this.f236b = i;
        this.f237c = i2;
        this.f238d = 64;
        this.f240f = new byte[(i * i2) << 6];
        this.f235a.m73b("Raising..");
        C0042b c0042b = new C0042b(new C0041a(this.f239e, 8), new C0041a(this.f239e, 8));
        C0042b c0042b2 = new C0042b(new C0041a(this.f239e, 8), new C0041a(this.f239e, 8));
        C0041a c0041a = new C0041a(this.f239e, 8);
        int[] iArr = new int[this.f236b * this.f237c];
        for (int i4 = 0; i4 < this.f236b; i4++) {
            m119a((i4 * 100) / (this.f236b - 1));
            for (int i5 = 0; i5 < this.f237c; i5++) {
                double dMo122a = (c0042b.mo122a(i4 * 1.3f, i5 * 1.3f) / 8.0d) - 8.0d;
                double dMo122a2 = (c0042b2.mo122a(i4 * 1.3f, i5 * 1.3f) / 6.0d) + 6.0d;
                if (c0041a.mo122a(i4, i5) / 8.0d > 0.0d) {
                    dMo122a2 = dMo122a;
                }
                double dMax = Math.max(dMo122a, dMo122a2) / 2.0d;
                double d = dMax;
                if (dMax < 0.0d) {
                    d /= 2.0d;
                }
                iArr[i4 + (i5 * this.f236b)] = (int) d;
            }
        }
        this.f235a.m73b("Eroding..");
        C0042b c0042b3 = new C0042b(new C0041a(this.f239e, 8), new C0041a(this.f239e, 8));
        C0042b c0042b4 = new C0042b(new C0041a(this.f239e, 8), new C0041a(this.f239e, 8));
        for (int i6 = 0; i6 < this.f236b; i6++) {
            m119a((i6 * 100) / (this.f236b - 1));
            for (int i7 = 0; i7 < this.f237c; i7++) {
                double dMo122a3 = c0042b3.mo122a(i6 << 1, i7 << 1) / 8.0d;
                int i8 = c0042b4.mo122a((double) (i6 << 1), (double) (i7 << 1)) > 0.0d ? 1 : 0;
                if (dMo122a3 > 2.0d) {
                    iArr[i6 + (i7 * this.f236b)] = (((iArr[i6 + (i7 * this.f236b)] - i8) / 2) << 1) + i8;
                }
            }
        }
        this.f235a.m73b("Soiling..");
        int i9 = this.f236b;
        int i10 = this.f237c;
        int i11 = this.f238d;
        C0041a c0041a2 = new C0041a(this.f239e, 8);
        for (int i12 = 0; i12 < i9; i12++) {
            m119a((i12 * 100) / (this.f236b - 1));
            for (int i13 = 0; i13 < i10; i13++) {
                int iMo122a = ((int) (c0041a2.mo122a(i12, i13) / 24.0d)) - 4;
                int i14 = iArr[i12 + (i13 * i9)] + (i11 / 2);
                int i15 = i14 + iMo122a;
                iArr[i12 + (i13 * i9)] = Math.max(i14, i15);
                for (int i16 = 0; i16 < i11; i16++) {
                    int i17 = (((i16 * this.f237c) + i13) * this.f236b) + i12;
                    int i18 = i16 <= i14 ? C0030a.f202e.f219v : 0;
                    if (i16 <= i15) {
                        i18 = C0030a.f200c.f219v;
                    }
                    this.f240f[i17] = (byte) i18;
                }
            }
        }
        this.f235a.m73b("Carving..");
        int i19 = this.f236b;
        int i20 = this.f237c;
        int i21 = this.f238d;
        int i22 = (((i19 * i20) * i21) / 256) / 64;
        for (int i23 = 0; i23 < i22; i23++) {
            m119a(((i23 * 100) / (i22 - 1)) / 4);
            float fNextFloat = this.f239e.nextFloat() * i19;
            float fNextFloat2 = this.f239e.nextFloat() * i21;
            float fNextFloat3 = this.f239e.nextFloat() * i20;
            int iNextFloat = (int) ((this.f239e.nextFloat() + this.f239e.nextFloat()) * 75.0f);
            float fNextFloat4 = (float) (((double) this.f239e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) this.f239e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i24 = 0; i24 < iNextFloat; i24++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (this.f239e.nextFloat() - this.f239e.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (this.f239e.nextFloat() - this.f239e.nextFloat());
                float fSin = (float) ((Math.sin((((double) i24) * 3.141592653589793d) / ((double) iNextFloat)) * 2.5d) + 1.0d);
                for (int i25 = (int) (fNextFloat - fSin); i25 <= ((int) (fNextFloat + fSin)); i25++) {
                    for (int i26 = (int) (fNextFloat2 - fSin); i26 <= ((int) (fNextFloat2 + fSin)); i26++) {
                        for (int i27 = (int) (fNextFloat3 - fSin); i27 <= ((int) (fNextFloat3 + fSin)); i27++) {
                            float f = i25 - fNextFloat;
                            float f2 = i26 - fNextFloat2;
                            float f3 = i27 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i25 >= 1 && i26 >= 1 && i27 >= 1 && i25 < this.f236b - 1 && i26 < this.f238d - 1 && i27 < this.f237c - 1) {
                                int i28 = (((i26 * this.f237c) + i27) * this.f236b) + i25;
                                if (this.f240f[i28] == C0030a.f200c.f219v) {
                                    this.f240f[i28] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        m118a(C0030a.f215r.f219v, 90, 1, 4);
        m118a(C0030a.f214q.f219v, 70, 2, 4);
        m118a(C0030a.f213p.f219v, 50, 3, 4);
        this.f235a.m73b("Watering..");
        long jNanoTime = System.nanoTime();
        long jM121a = 0;
        int i29 = C0030a.f208k.f219v;
        m119a(0);
        for (int i30 = 0; i30 < this.f236b; i30++) {
            jM121a = jM121a + m121a(i30, (this.f238d / 2) - 1, 0, 0, i29) + m121a(i30, (this.f238d / 2) - 1, this.f237c - 1, 0, i29);
        }
        for (int i31 = 0; i31 < this.f237c; i31++) {
            jM121a = jM121a + m121a(0, (this.f238d / 2) - 1, i31, 0, i29) + m121a(this.f236b - 1, (this.f238d / 2) - 1, i31, 0, i29);
        }
        int i32 = (this.f236b * this.f237c) / 200;
        for (int i33 = 0; i33 < i32; i33++) {
            if (i33 % 100 == 0) {
                m119a((i33 * 100) / (i32 - 1));
            }
            int iNextInt = this.f239e.nextInt(this.f236b);
            int iNextInt2 = ((this.f238d / 2) - 1) - this.f239e.nextInt(3);
            int iNextInt3 = this.f239e.nextInt(this.f237c);
            if (this.f240f[(((iNextInt2 * this.f237c) + iNextInt3) * this.f236b) + iNextInt] == 0) {
                jM121a += m121a(iNextInt, iNextInt2, iNextInt3, 0, i29);
            }
        }
        m119a(100);
        System.out.println("Flood filled " + jM121a + " tiles in " + ((System.nanoTime() - jNanoTime) / 1000000.0d) + " ms");
        this.f235a.m73b("Melting..");
        m120a();
        this.f235a.m73b("Growing..");
        m116a(iArr);
        this.f235a.m73b("Planting..");
        m117b(iArr);
        Level level = new Level();
        level.setData(i, 64, i2, this.f240f);
        level.createTime = System.currentTimeMillis();
        level.creator = str;
        level.name = "A Nice World";
        return level;
    }

    /* JADX INFO: renamed from: a */
    private void m116a(int[] iArr) {
        int i = this.f236b;
        int i2 = this.f237c;
        int i3 = this.f238d;
        C0041a c0041a = new C0041a(this.f239e, 8);
        C0041a c0041a2 = new C0041a(this.f239e, 8);
        for (int i4 = 0; i4 < i; i4++) {
            m119a((i4 * 100) / (this.f236b - 1));
            for (int i5 = 0; i5 < i2; i5++) {
                boolean z = c0041a.mo122a((double) i4, (double) i5) > 8.0d;
                boolean z2 = c0041a2.mo122a((double) i4, (double) i5) > 12.0d;
                int i6 = iArr[i4 + (i5 * i)];
                int i7 = (((i6 * this.f237c) + i5) * this.f236b) + i4;
                int i8 = this.f240f[((((i6 + 1) * this.f237c) + i5) * this.f236b) + i4] & 255;
                if ((i8 == C0030a.f207j.f219v || i8 == C0030a.f208k.f219v) && i6 <= (i3 / 2) - 1 && z2) {
                    this.f240f[i7] = (byte) C0030a.f212o.f219v;
                }
                if (i8 == 0) {
                    int i9 = C0030a.f201d.f219v;
                    if (i6 <= (i3 / 2) - 1 && z) {
                        i9 = C0030a.f211n.f219v;
                    }
                    this.f240f[i7] = (byte) i9;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m117b(int[] iArr) {
        int i = this.f236b;
        int i2 = (this.f236b * this.f237c) / 4000;
        for (int i3 = 0; i3 < i2; i3++) {
            m119a((i3 * 100) / (i2 - 1));
            int iNextInt = this.f239e.nextInt(this.f236b);
            int iNextInt2 = this.f239e.nextInt(this.f237c);
            for (int i4 = 0; i4 < 20; i4++) {
                int iNextInt3 = iNextInt;
                int iNextInt4 = iNextInt2;
                for (int i5 = 0; i5 < 20; i5++) {
                    iNextInt3 += this.f239e.nextInt(6) - this.f239e.nextInt(6);
                    iNextInt4 += this.f239e.nextInt(6) - this.f239e.nextInt(6);
                    if (iNextInt3 >= 0 && iNextInt4 >= 0 && iNextInt3 < this.f236b && iNextInt4 < this.f237c) {
                        int i6 = iArr[iNextInt3 + (iNextInt4 * i)] + 1;
                        int iNextInt5 = this.f239e.nextInt(3) + 4;
                        boolean z = true;
                        for (int i7 = i6; i7 <= i6 + 1 + iNextInt5; i7++) {
                            int i8 = i7 >= ((i6 + 1) + iNextInt5) - 2 ? 2 : 1;
                            for (int i9 = iNextInt3 - i8; i9 <= iNextInt3 + i8 && z; i9++) {
                                for (int i10 = iNextInt4 - i8; i10 <= iNextInt4 + i8 && z; i10++) {
                                    if (i9 < 0 || i7 < 0 || i10 < 0 || i9 >= this.f236b || i7 >= this.f238d || i10 >= this.f237c) {
                                        z = false;
                                    } else if ((this.f240f[(((i7 * this.f237c) + i10) * this.f236b) + i9] & 255) != 0) {
                                        z = false;
                                    }
                                }
                            }
                        }
                        if (z) {
                            int i11 = (((i6 * this.f237c) + iNextInt4) * this.f236b) + iNextInt3;
                            if ((this.f240f[((((i6 - 1) * this.f237c) + iNextInt4) * this.f236b) + iNextInt3] & 255) == C0030a.f201d.f219v && i6 < (this.f238d - iNextInt5) - 1) {
                                this.f240f[i11 - ((1 * this.f236b) * this.f237c)] = (byte) C0030a.f202e.f219v;
                                for (int i12 = (i6 - 3) + iNextInt5; i12 <= i6 + iNextInt5; i12++) {
                                    int i13 = i12 - (i6 + iNextInt5);
                                    int i14 = 1 - (i13 / 2);
                                    for (int i15 = iNextInt3 - i14; i15 <= iNextInt3 + i14; i15++) {
                                        int i16 = i15 - iNextInt3;
                                        for (int i17 = iNextInt4 - i14; i17 <= iNextInt4 + i14; i17++) {
                                            int i18 = i17 - iNextInt4;
                                            if (Math.abs(i16) != i14 || Math.abs(i18) != i14 || (this.f239e.nextInt(2) != 0 && i13 != 0)) {
                                                this.f240f[(((i12 * this.f237c) + i17) * this.f236b) + i15] = (byte) C0030a.f217t.f219v;
                                            }
                                        }
                                    }
                                }
                                for (int i19 = 0; i19 < iNextInt5; i19++) {
                                    this.f240f[i11 + (i19 * this.f236b * this.f237c)] = (byte) C0030a.f216s.f219v;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m118a(int i, int i2, int i3, int i4) {
        byte b = (byte) i;
        int i5 = this.f236b;
        int i6 = this.f237c;
        int i7 = this.f238d;
        int i8 = (((((i5 * i6) * i7) / 256) / 64) * i2) / 100;
        for (int i9 = 0; i9 < i8; i9++) {
            m119a((((i9 * 100) / (i8 - 1)) / 4) + ((i3 * 100) / 4));
            float fNextFloat = this.f239e.nextFloat() * i5;
            float fNextFloat2 = this.f239e.nextFloat() * i7;
            float fNextFloat3 = this.f239e.nextFloat() * i6;
            int iNextFloat = (int) ((((this.f239e.nextFloat() + this.f239e.nextFloat()) * 75.0f) * i2) / 100.0f);
            float fNextFloat4 = (float) (((double) this.f239e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) this.f239e.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i10 = 0; i10 < iNextFloat; i10++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (this.f239e.nextFloat() - this.f239e.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (this.f239e.nextFloat() - this.f239e.nextFloat());
                float fSin = (float) (((Math.sin((((double) i10) * 3.141592653589793d) / ((double) iNextFloat)) * ((double) i2)) / 100.0d) + 1.0d);
                for (int i11 = (int) (fNextFloat - fSin); i11 <= ((int) (fNextFloat + fSin)); i11++) {
                    for (int i12 = (int) (fNextFloat2 - fSin); i12 <= ((int) (fNextFloat2 + fSin)); i12++) {
                        for (int i13 = (int) (fNextFloat3 - fSin); i13 <= ((int) (fNextFloat3 + fSin)); i13++) {
                            float f = i11 - fNextFloat;
                            float f2 = i12 - fNextFloat2;
                            float f3 = i13 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i11 >= 1 && i12 >= 1 && i13 >= 1 && i11 < this.f236b - 1 && i12 < this.f238d - 1 && i13 < this.f237c - 1) {
                                int i14 = (((i12 * this.f237c) + i13) * this.f236b) + i11;
                                if (this.f240f[i14] == C0030a.f200c.f219v) {
                                    this.f240f[i14] = b;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m119a(int i) {
        this.f235a.m74a(i);
    }

    /* JADX INFO: renamed from: a */
    private void m120a() {
        int i = 0;
        int i2 = ((this.f236b * this.f237c) * this.f238d) / 10000;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 % 100 == 0) {
                m119a((i3 * 100) / (i2 - 1));
            }
            int iNextInt = this.f239e.nextInt(this.f236b);
            int iNextInt2 = this.f239e.nextInt((this.f238d / 2) - 4);
            int iNextInt3 = this.f239e.nextInt(this.f237c);
            if (this.f240f[(((iNextInt2 * this.f237c) + iNextInt3) * this.f236b) + iNextInt] == 0) {
                i++;
                m121a(iNextInt, iNextInt2, iNextInt3, 0, C0030a.f210m.f219v);
            }
        }
        m119a(100);
        System.out.println("LavaCount: " + i);
    }

    /* JADX INFO: renamed from: a */
    private long m121a(int i, int i2, int i3, int i4, int i5) {
        byte b = (byte) i5;
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        int i7 = 1;
        while ((1 << i6) < this.f236b) {
            i6++;
        }
        while ((1 << i7) < this.f237c) {
            i7++;
        }
        int i8 = this.f237c - 1;
        int i9 = this.f236b - 1;
        int length = 0 + 1;
        this.f241g[0] = (((i2 << i7) + i3) << i6) + i;
        long j = 0;
        int i10 = this.f236b * this.f237c;
        while (length > 0) {
            length--;
            int i11 = this.f241g[length];
            if (length == 0 && arrayList.size() > 0) {
                System.out.println("IT HAPPENED!");
                this.f241g = (int[]) arrayList.remove(arrayList.size() - 1);
                length = this.f241g.length;
            }
            int i12 = (i11 >> i6) & i8;
            int i13 = i11 >> (i6 + i7);
            int i14 = i11 & i9;
            int i15 = i14;
            int i16 = i14;
            while (i15 > 0 && this.f240f[i11 - 1] == 0) {
                i15--;
                i11--;
            }
            while (i16 < this.f236b && this.f240f[(i11 + i16) - i15] == 0) {
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
                this.f240f[i11] = b;
                if (i12 > 0) {
                    boolean z4 = this.f240f[i11 - this.f236b] == 0;
                    boolean z5 = z4;
                    if (z4 && !z) {
                        if (length == this.f241g.length) {
                            arrayList.add(this.f241g);
                            this.f241g = new int[1048576];
                            length = 0;
                        }
                        int i20 = length;
                        length++;
                        this.f241g[i20] = i11 - this.f236b;
                    }
                    z = z5;
                }
                if (i12 < this.f237c - 1) {
                    boolean z6 = this.f240f[i11 + this.f236b] == 0;
                    boolean z7 = z6;
                    if (z6 && !z2) {
                        if (length == this.f241g.length) {
                            arrayList.add(this.f241g);
                            this.f241g = new int[1048576];
                            length = 0;
                        }
                        int i21 = length;
                        length++;
                        this.f241g[i21] = i11 + this.f236b;
                    }
                    z2 = z7;
                }
                if (i13 > 0) {
                    byte b2 = this.f240f[i11 - i10];
                    if ((b == C0030a.f209l.f219v || b == C0030a.f210m.f219v) && (b2 == C0030a.f207j.f219v || b2 == C0030a.f208k.f219v)) {
                        this.f240f[i11 - i10] = (byte) C0030a.f200c.f219v;
                    }
                    boolean z8 = b2 == 0;
                    boolean z9 = z8;
                    if (z8 && !z3) {
                        if (length == this.f241g.length) {
                            arrayList.add(this.f241g);
                            this.f241g = new int[1048576];
                            length = 0;
                        }
                        int i22 = length;
                        length++;
                        this.f241g[i22] = i11 - i10;
                    }
                    z3 = z9;
                }
                i11++;
            }
        }
        return j;
    }
}
