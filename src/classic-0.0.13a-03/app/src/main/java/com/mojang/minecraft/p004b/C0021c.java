package com.mojang.minecraft.p004b;

import com.mojang.minecraft.p008f.C0041a;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.c */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/b/c.class */
public final class C0021c {

    /* JADX INFO: renamed from: b */
    private static C0021c f106b = new C0021c();

    /* JADX INFO: renamed from: a */
    private float[][] f105a = new float[6][4];

    /* JADX INFO: renamed from: c */
    private FloatBuffer f107c = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: d */
    private FloatBuffer f108d = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: e */
    private FloatBuffer f109e = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: f */
    private float[] f110f = new float[16];

    /* JADX INFO: renamed from: g */
    private float[] f111g = new float[16];

    /* JADX INFO: renamed from: h */
    private float[] f112h = new float[16];

    private C0021c() {
    }

    /* JADX INFO: renamed from: a */
    public static C0021c m65a() {
        C0021c c0021c = f106b;
        c0021c.f107c.clear();
        c0021c.f108d.clear();
        c0021c.f109e.clear();
        GL11.glGetFloat(2983, c0021c.f107c);
        GL11.glGetFloat(2982, c0021c.f108d);
        c0021c.f107c.flip().limit(16);
        c0021c.f107c.get(c0021c.f110f);
        c0021c.f108d.flip().limit(16);
        c0021c.f108d.get(c0021c.f111g);
        c0021c.f112h[0] = (c0021c.f111g[0] * c0021c.f110f[0]) + (c0021c.f111g[1] * c0021c.f110f[4]) + (c0021c.f111g[2] * c0021c.f110f[8]) + (c0021c.f111g[3] * c0021c.f110f[12]);
        c0021c.f112h[1] = (c0021c.f111g[0] * c0021c.f110f[1]) + (c0021c.f111g[1] * c0021c.f110f[5]) + (c0021c.f111g[2] * c0021c.f110f[9]) + (c0021c.f111g[3] * c0021c.f110f[13]);
        c0021c.f112h[2] = (c0021c.f111g[0] * c0021c.f110f[2]) + (c0021c.f111g[1] * c0021c.f110f[6]) + (c0021c.f111g[2] * c0021c.f110f[10]) + (c0021c.f111g[3] * c0021c.f110f[14]);
        c0021c.f112h[3] = (c0021c.f111g[0] * c0021c.f110f[3]) + (c0021c.f111g[1] * c0021c.f110f[7]) + (c0021c.f111g[2] * c0021c.f110f[11]) + (c0021c.f111g[3] * c0021c.f110f[15]);
        c0021c.f112h[4] = (c0021c.f111g[4] * c0021c.f110f[0]) + (c0021c.f111g[5] * c0021c.f110f[4]) + (c0021c.f111g[6] * c0021c.f110f[8]) + (c0021c.f111g[7] * c0021c.f110f[12]);
        c0021c.f112h[5] = (c0021c.f111g[4] * c0021c.f110f[1]) + (c0021c.f111g[5] * c0021c.f110f[5]) + (c0021c.f111g[6] * c0021c.f110f[9]) + (c0021c.f111g[7] * c0021c.f110f[13]);
        c0021c.f112h[6] = (c0021c.f111g[4] * c0021c.f110f[2]) + (c0021c.f111g[5] * c0021c.f110f[6]) + (c0021c.f111g[6] * c0021c.f110f[10]) + (c0021c.f111g[7] * c0021c.f110f[14]);
        c0021c.f112h[7] = (c0021c.f111g[4] * c0021c.f110f[3]) + (c0021c.f111g[5] * c0021c.f110f[7]) + (c0021c.f111g[6] * c0021c.f110f[11]) + (c0021c.f111g[7] * c0021c.f110f[15]);
        c0021c.f112h[8] = (c0021c.f111g[8] * c0021c.f110f[0]) + (c0021c.f111g[9] * c0021c.f110f[4]) + (c0021c.f111g[10] * c0021c.f110f[8]) + (c0021c.f111g[11] * c0021c.f110f[12]);
        c0021c.f112h[9] = (c0021c.f111g[8] * c0021c.f110f[1]) + (c0021c.f111g[9] * c0021c.f110f[5]) + (c0021c.f111g[10] * c0021c.f110f[9]) + (c0021c.f111g[11] * c0021c.f110f[13]);
        c0021c.f112h[10] = (c0021c.f111g[8] * c0021c.f110f[2]) + (c0021c.f111g[9] * c0021c.f110f[6]) + (c0021c.f111g[10] * c0021c.f110f[10]) + (c0021c.f111g[11] * c0021c.f110f[14]);
        c0021c.f112h[11] = (c0021c.f111g[8] * c0021c.f110f[3]) + (c0021c.f111g[9] * c0021c.f110f[7]) + (c0021c.f111g[10] * c0021c.f110f[11]) + (c0021c.f111g[11] * c0021c.f110f[15]);
        c0021c.f112h[12] = (c0021c.f111g[12] * c0021c.f110f[0]) + (c0021c.f111g[13] * c0021c.f110f[4]) + (c0021c.f111g[14] * c0021c.f110f[8]) + (c0021c.f111g[15] * c0021c.f110f[12]);
        c0021c.f112h[13] = (c0021c.f111g[12] * c0021c.f110f[1]) + (c0021c.f111g[13] * c0021c.f110f[5]) + (c0021c.f111g[14] * c0021c.f110f[9]) + (c0021c.f111g[15] * c0021c.f110f[13]);
        c0021c.f112h[14] = (c0021c.f111g[12] * c0021c.f110f[2]) + (c0021c.f111g[13] * c0021c.f110f[6]) + (c0021c.f111g[14] * c0021c.f110f[10]) + (c0021c.f111g[15] * c0021c.f110f[14]);
        c0021c.f112h[15] = (c0021c.f111g[12] * c0021c.f110f[3]) + (c0021c.f111g[13] * c0021c.f110f[7]) + (c0021c.f111g[14] * c0021c.f110f[11]) + (c0021c.f111g[15] * c0021c.f110f[15]);
        c0021c.f105a[0][0] = c0021c.f112h[3] - c0021c.f112h[0];
        c0021c.f105a[0][1] = c0021c.f112h[7] - c0021c.f112h[4];
        c0021c.f105a[0][2] = c0021c.f112h[11] - c0021c.f112h[8];
        c0021c.f105a[0][3] = c0021c.f112h[15] - c0021c.f112h[12];
        m66a(c0021c.f105a, 0);
        c0021c.f105a[1][0] = c0021c.f112h[3] + c0021c.f112h[0];
        c0021c.f105a[1][1] = c0021c.f112h[7] + c0021c.f112h[4];
        c0021c.f105a[1][2] = c0021c.f112h[11] + c0021c.f112h[8];
        c0021c.f105a[1][3] = c0021c.f112h[15] + c0021c.f112h[12];
        m66a(c0021c.f105a, 1);
        c0021c.f105a[2][0] = c0021c.f112h[3] + c0021c.f112h[1];
        c0021c.f105a[2][1] = c0021c.f112h[7] + c0021c.f112h[5];
        c0021c.f105a[2][2] = c0021c.f112h[11] + c0021c.f112h[9];
        c0021c.f105a[2][3] = c0021c.f112h[15] + c0021c.f112h[13];
        m66a(c0021c.f105a, 2);
        c0021c.f105a[3][0] = c0021c.f112h[3] - c0021c.f112h[1];
        c0021c.f105a[3][1] = c0021c.f112h[7] - c0021c.f112h[5];
        c0021c.f105a[3][2] = c0021c.f112h[11] - c0021c.f112h[9];
        c0021c.f105a[3][3] = c0021c.f112h[15] - c0021c.f112h[13];
        m66a(c0021c.f105a, 3);
        c0021c.f105a[4][0] = c0021c.f112h[3] - c0021c.f112h[2];
        c0021c.f105a[4][1] = c0021c.f112h[7] - c0021c.f112h[6];
        c0021c.f105a[4][2] = c0021c.f112h[11] - c0021c.f112h[10];
        c0021c.f105a[4][3] = c0021c.f112h[15] - c0021c.f112h[14];
        m66a(c0021c.f105a, 4);
        c0021c.f105a[5][0] = c0021c.f112h[3] + c0021c.f112h[2];
        c0021c.f105a[5][1] = c0021c.f112h[7] + c0021c.f112h[6];
        c0021c.f105a[5][2] = c0021c.f112h[11] + c0021c.f112h[10];
        c0021c.f105a[5][3] = c0021c.f112h[15] + c0021c.f112h[14];
        m66a(c0021c.f105a, 5);
        return f106b;
    }

    /* JADX INFO: renamed from: a */
    private static void m66a(float[][] fArr, int i) {
        float fSqrt = (float) Math.sqrt((fArr[i][0] * fArr[i][0]) + (fArr[i][1] * fArr[i][1]) + (fArr[i][2] * fArr[i][2]));
        float[] fArr2 = fArr[i];
        fArr2[0] = fArr2[0] / fSqrt;
        float[] fArr3 = fArr[i];
        fArr3[1] = fArr3[1] / fSqrt;
        float[] fArr4 = fArr[i];
        fArr4[2] = fArr4[2] / fSqrt;
        float[] fArr5 = fArr[i];
        fArr5[3] = fArr5[3] / fSqrt;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m67a(C0041a c0041a) {
        float f = c0041a.f224a;
        float f2 = c0041a.f225b;
        float f3 = c0041a.f226c;
        float f4 = c0041a.f227d;
        float f5 = c0041a.f228e;
        float f6 = c0041a.f229f;
        for (int i = 0; i < 6; i++) {
            if ((this.f105a[i][0] * f) + (this.f105a[i][1] * f2) + (this.f105a[i][2] * f3) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f4) + (this.f105a[i][1] * f2) + (this.f105a[i][2] * f3) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f) + (this.f105a[i][1] * f5) + (this.f105a[i][2] * f3) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f4) + (this.f105a[i][1] * f5) + (this.f105a[i][2] * f3) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f) + (this.f105a[i][1] * f2) + (this.f105a[i][2] * f6) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f4) + (this.f105a[i][1] * f2) + (this.f105a[i][2] * f6) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f) + (this.f105a[i][1] * f5) + (this.f105a[i][2] * f6) + this.f105a[i][3] <= 0.0f && (this.f105a[i][0] * f4) + (this.f105a[i][1] * f5) + (this.f105a[i][2] * f6) + this.f105a[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }
}
