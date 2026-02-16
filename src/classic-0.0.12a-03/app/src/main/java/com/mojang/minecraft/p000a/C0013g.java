package com.mojang.minecraft.p000a;

import com.mojang.minecraft.RunnableC0018c;
import com.mojang.minecraft.p000a.p001a.C0003b;
import com.mojang.minecraft.p006f.C0031a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.g */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/g.class */
public final class C0013g {

    /* JADX INFO: renamed from: a */
    public final int f71a;

    /* JADX INFO: renamed from: b */
    public final int f72b;

    /* JADX INFO: renamed from: c */
    public final int f73c;

    /* JADX INFO: renamed from: d */
    public byte[] f74d;

    /* JADX INFO: renamed from: i */
    private int[] f75i;

    /* JADX INFO: renamed from: j */
    private RunnableC0018c f79j;

    /* JADX INFO: renamed from: e */
    ArrayList f76e = new ArrayList();

    /* JADX INFO: renamed from: f */
    public Random f77f = new Random();

    /* JADX INFO: renamed from: g */
    public int f78g = this.f77f.nextInt();

    /* JADX INFO: renamed from: h */
    public int f80h = 0;

    /* JADX INFO: renamed from: k */
    private int[] f81k = new int[1048576];

    public C0013g(RunnableC0018c runnableC0018c, int i, int i2, int i3) {
        this.f79j = runnableC0018c;
        int i4 = (runnableC0018c.f107a * 240) / runnableC0018c.f108b;
        int i5 = (runnableC0018c.f108b * 240) / runnableC0018c.f108b;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, i4, i5, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        runnableC0018c.m67a("Loading level", "Reading..");
        this.f71a = 256;
        this.f72b = 256;
        this.f73c = 64;
        this.f74d = new byte[(256 << 8) << 6];
        this.f75i = new int[256 << 8];
        if (m35c()) {
            return;
        }
        m34a();
    }

    /* JADX INFO: renamed from: a */
    public final void m34a() {
        this.f79j.m67a("Generating level", "Raising..");
        C0010d c0010d = new C0010d(this.f71a, this.f72b, this.f73c);
        int i = c0010d.f54a;
        int i2 = c0010d.f55b;
        int i3 = c0010d.f56c;
        int[] iArrM1a = new C0001a(c0010d.f57d, 1, true).m1a(i, i2);
        int[] iArrM1a2 = new C0001a(c0010d.f57d, 0, true).m1a(i, i2);
        int[] iArrM1a3 = new C0001a(c0010d.f57d, 2, false).m1a(i, i2);
        int[] iArrM1a4 = new C0001a(c0010d.f57d, 4, false).m1a(i, i2);
        int[] iArrM1a5 = new C0001a(c0010d.f57d, 1, true).m1a(i, i2);
        byte[] bArr = new byte[c0010d.f54a * c0010d.f55b * c0010d.f56c];
        int i4 = i3 / 2;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = iArrM1a[i5 + (i7 * c0010d.f54a)];
                    int i9 = iArrM1a2[i5 + (i7 * c0010d.f54a)];
                    int i10 = iArrM1a3[i5 + (i7 * c0010d.f54a)];
                    int i11 = iArrM1a4[i5 + (i7 * c0010d.f54a)];
                    if (i10 < 128) {
                        i9 = i8;
                    }
                    int i12 = i8;
                    if (i9 > i12) {
                        i12 = i9;
                    }
                    int i13 = (((i12 - 128) / 8) + i4) - 1;
                    int i14 = ((((iArrM1a5[i5 + (i7 * c0010d.f54a)] - 128) / 6) + i4) + i13) / 2;
                    if (i11 < 92) {
                        i13 = (i13 / 2) << 1;
                    } else if (i11 < 160) {
                        i13 = (i13 / 4) << 2;
                    }
                    if (i13 < i4 - 2) {
                        i13 = ((i13 - i4) / 2) + i4;
                    }
                    if (i14 > i13 - 2) {
                        i14 = i13 - 2;
                    }
                    int i15 = (((i6 * c0010d.f55b) + i7) * c0010d.f54a) + i5;
                    int i16 = 0;
                    if (i6 == i13 && i6 >= i3 / 2) {
                        i16 = C0003b.f16d.f24l;
                    }
                    if (i6 < i13) {
                        i16 = C0003b.f17e.f24l;
                    }
                    if (i6 <= i14) {
                        i16 = C0003b.f15c.f24l;
                    }
                    bArr[i15] = (byte) i16;
                }
            }
        }
        this.f74d = bArr;
        this.f79j.m67a("Generating level", "Carving..");
        byte[] bArr2 = this.f74d;
        int i17 = c0010d.f54a;
        int i18 = c0010d.f55b;
        int i19 = c0010d.f56c;
        int i20 = (((i17 * i18) * i19) / 256) / 64;
        for (int i21 = 0; i21 < i20; i21++) {
            float fNextFloat = c0010d.f57d.nextFloat() * i17;
            float fNextFloat2 = c0010d.f57d.nextFloat() * i19;
            float fNextFloat3 = c0010d.f57d.nextFloat() * i18;
            int iNextFloat = (int) (c0010d.f57d.nextFloat() + (c0010d.f57d.nextFloat() * 150.0f));
            float fNextFloat4 = (float) (((double) c0010d.f57d.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat5 = 0.0f;
            float fNextFloat6 = (float) (((double) c0010d.f57d.nextFloat()) * 3.141592653589793d * 2.0d);
            float fNextFloat7 = 0.0f;
            for (int i22 = 0; i22 < iNextFloat; i22++) {
                fNextFloat = (float) (((double) fNextFloat) + (Math.sin(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat3 = (float) (((double) fNextFloat3) + (Math.cos(fNextFloat4) * Math.cos(fNextFloat6)));
                fNextFloat2 = (float) (((double) fNextFloat2) + Math.sin(fNextFloat6));
                fNextFloat4 += fNextFloat5 * 0.2f;
                fNextFloat5 = (fNextFloat5 * 0.9f) + (c0010d.f57d.nextFloat() - c0010d.f57d.nextFloat());
                fNextFloat6 = (fNextFloat6 + (fNextFloat7 * 0.5f)) * 0.5f;
                fNextFloat7 = (fNextFloat7 * 0.9f) + (c0010d.f57d.nextFloat() - c0010d.f57d.nextFloat());
                float fSin = (float) ((Math.sin((((double) i22) * 3.141592653589793d) / ((double) iNextFloat)) * 2.5d) + 1.0d);
                for (int i23 = (int) (fNextFloat - fSin); i23 <= ((int) (fNextFloat + fSin)); i23++) {
                    for (int i24 = (int) (fNextFloat2 - fSin); i24 <= ((int) (fNextFloat2 + fSin)); i24++) {
                        for (int i25 = (int) (fNextFloat3 - fSin); i25 <= ((int) (fNextFloat3 + fSin)); i25++) {
                            float f = i23 - fNextFloat;
                            float f2 = i24 - fNextFloat2;
                            float f3 = i25 - fNextFloat3;
                            if ((f * f) + (f2 * f2 * 2.0f) + (f3 * f3) < fSin * fSin && i23 >= 1 && i24 >= 1 && i25 >= 1 && i23 < c0010d.f54a - 1 && i24 < c0010d.f56c - 1 && i25 < c0010d.f55b - 1) {
                                int i26 = (((i24 * c0010d.f55b) + i25) * c0010d.f54a) + i23;
                                if (bArr2[i26] == C0003b.f15c.f24l) {
                                    bArr2[i26] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f74d = bArr2;
        this.f79j.m67a("Generating level", "Watering..");
        long jNanoTime = System.nanoTime();
        long jM44a = 0;
        int i27 = C0003b.f20h.f24l;
        for (int i28 = 0; i28 < this.f71a; i28++) {
            jM44a = jM44a + m44a(i28, (this.f73c / 2) - 1, 0, 0, i27) + m44a(i28, (this.f73c / 2) - 1, this.f72b - 1, 0, i27);
        }
        for (int i29 = 0; i29 < this.f72b; i29++) {
            jM44a = jM44a + m44a(0, (this.f73c / 2) - 1, i29, 0, i27) + m44a(this.f71a - 1, (this.f73c / 2) - 1, i29, 0, i27);
        }
        long jNanoTime2 = System.nanoTime();
        this.f79j.m67a("Generating level", "Melting..");
        int i30 = 0;
        for (int i31 = 0; i31 < 400; i31++) {
            int iNextInt = this.f77f.nextInt(this.f71a);
            int iNextInt2 = this.f77f.nextInt(this.f73c / 2);
            int iNextInt3 = this.f77f.nextInt(this.f72b);
            if (m42b(iNextInt, iNextInt2, iNextInt3) == 0) {
                i30++;
                jM44a += m44a(iNextInt, iNextInt2, iNextInt3, 0, C0003b.f22j.f24l);
            }
        }
        System.out.println("LavaCount: " + i30);
        System.out.println("Flood filled " + jM44a + " tiles in " + ((jNanoTime2 - jNanoTime) / 1000000.0d) + " ms");
        m37c(0, 0, this.f71a, this.f72b);
        for (int i32 = 0; i32 < this.f76e.size(); i32++) {
            ((C0012f) this.f76e.get(i32)).m33a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Exception] */
    /* JADX INFO: renamed from: c */
    private boolean m35c() {
        ?? r0;
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(new FileInputStream(new File("level.dat"))));
            dataInputStream.readFully(this.f74d);
            dataInputStream.close();
            m37c(0, 0, this.f71a, this.f72b);
            int i = 0;
            while (true) {
                r0 = i;
                if (r0 >= this.f76e.size()) {
                    return true;
                }
                ((C0012f) this.f76e.get(i)).m33a();
                i++;
            }
        } catch (Exception e) {
            r0.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.DataOutputStream, java.lang.Exception] */
    /* JADX INFO: renamed from: b */
    public final void m36b() {
        ?? dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(new File("level.dat"))));
            dataOutputStream.write(this.f74d);
            dataOutputStream.close();
        } catch (Exception e) {
            dataOutputStream.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m37c(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                int i7 = this.f75i[i5 + (i6 * this.f71a)];
                int i8 = this.f73c - 1;
                while (i8 > 0) {
                    C0003b c0003b = C0003b.f13a[m42b(i5, i8, i6)];
                    if (c0003b == null ? false : c0003b.mo5a()) {
                        break;
                    } else {
                        i8--;
                    }
                }
                this.f75i[i5 + (i6 * this.f71a)] = i8 + 1;
                if (i7 != i8) {
                    int i9 = i7 < i8 ? i7 : i8;
                    int i10 = i7 > i8 ? i7 : i8;
                    for (int i11 = 0; i11 < this.f76e.size(); i11++) {
                        int i12 = i5;
                        int i13 = i6;
                        ((C0012f) this.f76e.get(i11)).m32a(i12 - 1, i9 - 1, i13 - 1, i12 + 1, i10 + 1, i13 + 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m38a(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f71a || i2 >= this.f73c || i3 >= this.f72b || i4 == this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i]) {
            return false;
        }
        this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i] = (byte) i4;
        m40d(i - 1, i2, i3, i4);
        m40d(i + 1, i2, i3, i4);
        m40d(i, i2 - 1, i3, i4);
        m40d(i, i2 + 1, i3, i4);
        m40d(i, i2, i3 - 1, i4);
        m40d(i, i2, i3 + 1, i4);
        m37c(i, i3, 1, 1);
        for (int i5 = 0; i5 < this.f76e.size(); i5++) {
            ((C0012f) this.f76e.get(i5)).m32a(i - 1, i2 - 1, i3 - 1, i + 1, i2 + 1, i3 + 1);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m39b(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f71a || i2 >= this.f73c || i3 >= this.f72b || i4 == this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i]) {
            return false;
        }
        this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i] = (byte) i4;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private void m40d(int i, int i2, int i3, int i4) {
        C0003b c0003b;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f71a || i2 >= this.f73c || i3 >= this.f72b || (c0003b = C0003b.f13a[this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i]]) == null) {
            return;
        }
        c0003b.mo18b(this, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m41a(int i, int i2, int i3) {
        return i < 0 || i2 < 0 || i3 < 0 || i >= this.f71a || i2 >= this.f73c || i3 >= this.f72b || i2 >= this.f75i[i + (i3 * this.f71a)];
    }

    /* JADX INFO: renamed from: b */
    public final int m42b(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.f71a || i2 >= this.f73c || i3 >= this.f72b) {
            return 0;
        }
        return this.f74d[(((i2 * this.f72b) + i3) * this.f71a) + i];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m43a(C0031a c0031a, int i) {
        int iFloor = (int) Math.floor(c0031a.f200a);
        int iFloor2 = (int) Math.floor(c0031a.f203d + 1.0f);
        int iFloor3 = (int) Math.floor(c0031a.f201b);
        int iFloor4 = (int) Math.floor(c0031a.f204e + 1.0f);
        int iFloor5 = (int) Math.floor(c0031a.f202c);
        int iFloor6 = (int) Math.floor(c0031a.f205f + 1.0f);
        if (iFloor < 0) {
            iFloor = 0;
        }
        if (iFloor3 < 0) {
            iFloor3 = 0;
        }
        if (iFloor5 < 0) {
            iFloor5 = 0;
        }
        if (iFloor2 > this.f71a) {
            iFloor2 = this.f71a;
        }
        if (iFloor4 > this.f73c) {
            iFloor4 = this.f73c;
        }
        if (iFloor6 > this.f72b) {
            iFloor6 = this.f72b;
        }
        for (int i2 = iFloor; i2 < iFloor2; i2++) {
            for (int i3 = iFloor3; i3 < iFloor4; i3++) {
                for (int i4 = iFloor5; i4 < iFloor6; i4++) {
                    C0003b c0003b = C0003b.f13a[m42b(i2, i3, i4)];
                    if (c0003b != null && c0003b.mo17d() == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private long m44a(int i, int i2, int i3, int i4, int i5) {
        byte b = (byte) i5;
        ArrayList arrayList = new ArrayList();
        int i6 = this.f72b - 1;
        int i7 = this.f71a - 1;
        int length = 0 + 1;
        this.f81k[0] = (((i2 << 8) + i3) << 8) + i;
        long j = 0;
        int i8 = this.f71a * this.f72b;
        while (length > 0) {
            length--;
            int i9 = this.f81k[length];
            if (length == 0 && arrayList.size() > 0) {
                System.out.println("IT HAPPENED!");
                this.f81k = (int[]) arrayList.remove(arrayList.size() - 1);
                length = this.f81k.length;
            }
            int i10 = (i9 >> 8) & i6;
            int i11 = i9 >> 16;
            int i12 = i9 & i7;
            int i13 = i12;
            int i14 = i12;
            while (i13 > 0 && this.f74d[i9 - 1] == 0) {
                i13--;
                i9--;
            }
            while (i14 < this.f71a && this.f74d[(i9 + i14) - i13] == 0) {
                i14++;
            }
            int i15 = (i9 >> 8) & i6;
            int i16 = i9 >> 16;
            if (i15 != i10 || i16 != i11) {
                System.out.println("hoooly fuck");
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            j += (long) (i14 - i13);
            for (int i17 = i13; i17 < i14; i17++) {
                this.f74d[i9] = b;
                if (i10 > 0) {
                    boolean z4 = this.f74d[i9 - this.f71a] == 0;
                    boolean z5 = z4;
                    if (z4 && !z) {
                        if (length == this.f81k.length) {
                            arrayList.add(this.f81k);
                            this.f81k = new int[1048576];
                            length = 0;
                        }
                        int i18 = length;
                        length++;
                        this.f81k[i18] = i9 - this.f71a;
                    }
                    z = z5;
                }
                if (i10 < this.f72b - 1) {
                    boolean z6 = this.f74d[i9 + this.f71a] == 0;
                    boolean z7 = z6;
                    if (z6 && !z2) {
                        if (length == this.f81k.length) {
                            arrayList.add(this.f81k);
                            this.f81k = new int[1048576];
                            length = 0;
                        }
                        int i19 = length;
                        length++;
                        this.f81k[i19] = i9 + this.f71a;
                    }
                    z2 = z7;
                }
                if (i11 > 0) {
                    boolean z8 = this.f74d[i9 - i8] == 0;
                    boolean z9 = z8;
                    if (z8 && !z3) {
                        if (length == this.f81k.length) {
                            arrayList.add(this.f81k);
                            this.f81k = new int[1048576];
                            length = 0;
                        }
                        int i20 = length;
                        length++;
                        this.f81k[i20] = i9 - i8;
                    }
                    z3 = z9;
                }
                i9++;
            }
        }
        return j;
    }
}
