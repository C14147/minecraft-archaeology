package com.mojang.minecraft.p001a;

import com.mojang.minecraft.phys.AABB;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/d.class */
public final class C0006d {

    /* JADX INFO: renamed from: b */
    private static C0006d f37b = new C0006d();

    /* JADX INFO: renamed from: a */
    private float[][] f36a = new float[6][4];

    /* JADX INFO: renamed from: c */
    private FloatBuffer f38c = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: d */
    private FloatBuffer f39d = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: e */
    private FloatBuffer f40e = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: f */
    private float[] f41f = new float[16];

    /* JADX INFO: renamed from: g */
    private float[] f42g = new float[16];

    /* JADX INFO: renamed from: h */
    private float[] f43h = new float[16];

    private C0006d() {
    }

    /* JADX INFO: renamed from: a */
    public static C0006d m14a() {
        C0006d c0006d = f37b;
        c0006d.f38c.clear();
        c0006d.f39d.clear();
        c0006d.f40e.clear();
        GL11.glGetFloat(2983, c0006d.f38c);
        GL11.glGetFloat(2982, c0006d.f39d);
        c0006d.f38c.flip().limit(16);
        c0006d.f38c.get(c0006d.f41f);
        c0006d.f39d.flip().limit(16);
        c0006d.f39d.get(c0006d.f42g);
        c0006d.f43h[0] = (c0006d.f42g[0] * c0006d.f41f[0]) + (c0006d.f42g[1] * c0006d.f41f[4]) + (c0006d.f42g[2] * c0006d.f41f[8]) + (c0006d.f42g[3] * c0006d.f41f[12]);
        c0006d.f43h[1] = (c0006d.f42g[0] * c0006d.f41f[1]) + (c0006d.f42g[1] * c0006d.f41f[5]) + (c0006d.f42g[2] * c0006d.f41f[9]) + (c0006d.f42g[3] * c0006d.f41f[13]);
        c0006d.f43h[2] = (c0006d.f42g[0] * c0006d.f41f[2]) + (c0006d.f42g[1] * c0006d.f41f[6]) + (c0006d.f42g[2] * c0006d.f41f[10]) + (c0006d.f42g[3] * c0006d.f41f[14]);
        c0006d.f43h[3] = (c0006d.f42g[0] * c0006d.f41f[3]) + (c0006d.f42g[1] * c0006d.f41f[7]) + (c0006d.f42g[2] * c0006d.f41f[11]) + (c0006d.f42g[3] * c0006d.f41f[15]);
        c0006d.f43h[4] = (c0006d.f42g[4] * c0006d.f41f[0]) + (c0006d.f42g[5] * c0006d.f41f[4]) + (c0006d.f42g[6] * c0006d.f41f[8]) + (c0006d.f42g[7] * c0006d.f41f[12]);
        c0006d.f43h[5] = (c0006d.f42g[4] * c0006d.f41f[1]) + (c0006d.f42g[5] * c0006d.f41f[5]) + (c0006d.f42g[6] * c0006d.f41f[9]) + (c0006d.f42g[7] * c0006d.f41f[13]);
        c0006d.f43h[6] = (c0006d.f42g[4] * c0006d.f41f[2]) + (c0006d.f42g[5] * c0006d.f41f[6]) + (c0006d.f42g[6] * c0006d.f41f[10]) + (c0006d.f42g[7] * c0006d.f41f[14]);
        c0006d.f43h[7] = (c0006d.f42g[4] * c0006d.f41f[3]) + (c0006d.f42g[5] * c0006d.f41f[7]) + (c0006d.f42g[6] * c0006d.f41f[11]) + (c0006d.f42g[7] * c0006d.f41f[15]);
        c0006d.f43h[8] = (c0006d.f42g[8] * c0006d.f41f[0]) + (c0006d.f42g[9] * c0006d.f41f[4]) + (c0006d.f42g[10] * c0006d.f41f[8]) + (c0006d.f42g[11] * c0006d.f41f[12]);
        c0006d.f43h[9] = (c0006d.f42g[8] * c0006d.f41f[1]) + (c0006d.f42g[9] * c0006d.f41f[5]) + (c0006d.f42g[10] * c0006d.f41f[9]) + (c0006d.f42g[11] * c0006d.f41f[13]);
        c0006d.f43h[10] = (c0006d.f42g[8] * c0006d.f41f[2]) + (c0006d.f42g[9] * c0006d.f41f[6]) + (c0006d.f42g[10] * c0006d.f41f[10]) + (c0006d.f42g[11] * c0006d.f41f[14]);
        c0006d.f43h[11] = (c0006d.f42g[8] * c0006d.f41f[3]) + (c0006d.f42g[9] * c0006d.f41f[7]) + (c0006d.f42g[10] * c0006d.f41f[11]) + (c0006d.f42g[11] * c0006d.f41f[15]);
        c0006d.f43h[12] = (c0006d.f42g[12] * c0006d.f41f[0]) + (c0006d.f42g[13] * c0006d.f41f[4]) + (c0006d.f42g[14] * c0006d.f41f[8]) + (c0006d.f42g[15] * c0006d.f41f[12]);
        c0006d.f43h[13] = (c0006d.f42g[12] * c0006d.f41f[1]) + (c0006d.f42g[13] * c0006d.f41f[5]) + (c0006d.f42g[14] * c0006d.f41f[9]) + (c0006d.f42g[15] * c0006d.f41f[13]);
        c0006d.f43h[14] = (c0006d.f42g[12] * c0006d.f41f[2]) + (c0006d.f42g[13] * c0006d.f41f[6]) + (c0006d.f42g[14] * c0006d.f41f[10]) + (c0006d.f42g[15] * c0006d.f41f[14]);
        c0006d.f43h[15] = (c0006d.f42g[12] * c0006d.f41f[3]) + (c0006d.f42g[13] * c0006d.f41f[7]) + (c0006d.f42g[14] * c0006d.f41f[11]) + (c0006d.f42g[15] * c0006d.f41f[15]);
        c0006d.f36a[0][0] = c0006d.f43h[3] - c0006d.f43h[0];
        c0006d.f36a[0][1] = c0006d.f43h[7] - c0006d.f43h[4];
        c0006d.f36a[0][2] = c0006d.f43h[11] - c0006d.f43h[8];
        c0006d.f36a[0][3] = c0006d.f43h[15] - c0006d.f43h[12];
        m15a(c0006d.f36a, 0);
        c0006d.f36a[1][0] = c0006d.f43h[3] + c0006d.f43h[0];
        c0006d.f36a[1][1] = c0006d.f43h[7] + c0006d.f43h[4];
        c0006d.f36a[1][2] = c0006d.f43h[11] + c0006d.f43h[8];
        c0006d.f36a[1][3] = c0006d.f43h[15] + c0006d.f43h[12];
        m15a(c0006d.f36a, 1);
        c0006d.f36a[2][0] = c0006d.f43h[3] + c0006d.f43h[1];
        c0006d.f36a[2][1] = c0006d.f43h[7] + c0006d.f43h[5];
        c0006d.f36a[2][2] = c0006d.f43h[11] + c0006d.f43h[9];
        c0006d.f36a[2][3] = c0006d.f43h[15] + c0006d.f43h[13];
        m15a(c0006d.f36a, 2);
        c0006d.f36a[3][0] = c0006d.f43h[3] - c0006d.f43h[1];
        c0006d.f36a[3][1] = c0006d.f43h[7] - c0006d.f43h[5];
        c0006d.f36a[3][2] = c0006d.f43h[11] - c0006d.f43h[9];
        c0006d.f36a[3][3] = c0006d.f43h[15] - c0006d.f43h[13];
        m15a(c0006d.f36a, 3);
        c0006d.f36a[4][0] = c0006d.f43h[3] - c0006d.f43h[2];
        c0006d.f36a[4][1] = c0006d.f43h[7] - c0006d.f43h[6];
        c0006d.f36a[4][2] = c0006d.f43h[11] - c0006d.f43h[10];
        c0006d.f36a[4][3] = c0006d.f43h[15] - c0006d.f43h[14];
        m15a(c0006d.f36a, 4);
        c0006d.f36a[5][0] = c0006d.f43h[3] + c0006d.f43h[2];
        c0006d.f36a[5][1] = c0006d.f43h[7] + c0006d.f43h[6];
        c0006d.f36a[5][2] = c0006d.f43h[11] + c0006d.f43h[10];
        c0006d.f36a[5][3] = c0006d.f43h[15] + c0006d.f43h[14];
        m15a(c0006d.f36a, 5);
        return f37b;
    }

    /* JADX INFO: renamed from: a */
    private static void m15a(float[][] fArr, int i) {
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
    public final boolean m16a(float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 6; i++) {
            if ((this.f36a[i][0] * f) + (this.f36a[i][1] * f2) + (this.f36a[i][2] * f3) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f4) + (this.f36a[i][1] * f2) + (this.f36a[i][2] * f3) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f) + (this.f36a[i][1] * f5) + (this.f36a[i][2] * f3) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f4) + (this.f36a[i][1] * f5) + (this.f36a[i][2] * f3) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f) + (this.f36a[i][1] * f2) + (this.f36a[i][2] * f6) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f4) + (this.f36a[i][1] * f2) + (this.f36a[i][2] * f6) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f) + (this.f36a[i][1] * f5) + (this.f36a[i][2] * f6) + this.f36a[i][3] <= 0.0f && (this.f36a[i][0] * f4) + (this.f36a[i][1] * f5) + (this.f36a[i][2] * f6) + this.f36a[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m17a(AABB aabb) {
        return m16a(aabb.f292x0, aabb.f293y0, aabb.f294z0, aabb.f295x1, aabb.f296y1, aabb.f297z1);
    }
}
