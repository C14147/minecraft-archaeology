package com.mojang.minecraft.p002b;

import com.mojang.minecraft.p006f.C0031a;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.c */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/b/c.class */
public final class C0017c {

    /* JADX INFO: renamed from: b */
    private static C0017c f99b = new C0017c();

    /* JADX INFO: renamed from: a */
    private float[][] f98a = new float[6][4];

    /* JADX INFO: renamed from: c */
    private FloatBuffer f100c = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: d */
    private FloatBuffer f101d = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: e */
    private FloatBuffer f102e = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: f */
    private float[] f103f = new float[16];

    /* JADX INFO: renamed from: g */
    private float[] f104g = new float[16];

    /* JADX INFO: renamed from: h */
    private float[] f105h = new float[16];

    private C0017c() {
    }

    /* JADX INFO: renamed from: a */
    public static C0017c m55a() {
        C0017c c0017c = f99b;
        c0017c.f100c.clear();
        c0017c.f101d.clear();
        c0017c.f102e.clear();
        GL11.glGetFloat(2983, c0017c.f100c);
        GL11.glGetFloat(2982, c0017c.f101d);
        c0017c.f100c.flip().limit(16);
        c0017c.f100c.get(c0017c.f103f);
        c0017c.f101d.flip().limit(16);
        c0017c.f101d.get(c0017c.f104g);
        c0017c.f105h[0] = (c0017c.f104g[0] * c0017c.f103f[0]) + (c0017c.f104g[1] * c0017c.f103f[4]) + (c0017c.f104g[2] * c0017c.f103f[8]) + (c0017c.f104g[3] * c0017c.f103f[12]);
        c0017c.f105h[1] = (c0017c.f104g[0] * c0017c.f103f[1]) + (c0017c.f104g[1] * c0017c.f103f[5]) + (c0017c.f104g[2] * c0017c.f103f[9]) + (c0017c.f104g[3] * c0017c.f103f[13]);
        c0017c.f105h[2] = (c0017c.f104g[0] * c0017c.f103f[2]) + (c0017c.f104g[1] * c0017c.f103f[6]) + (c0017c.f104g[2] * c0017c.f103f[10]) + (c0017c.f104g[3] * c0017c.f103f[14]);
        c0017c.f105h[3] = (c0017c.f104g[0] * c0017c.f103f[3]) + (c0017c.f104g[1] * c0017c.f103f[7]) + (c0017c.f104g[2] * c0017c.f103f[11]) + (c0017c.f104g[3] * c0017c.f103f[15]);
        c0017c.f105h[4] = (c0017c.f104g[4] * c0017c.f103f[0]) + (c0017c.f104g[5] * c0017c.f103f[4]) + (c0017c.f104g[6] * c0017c.f103f[8]) + (c0017c.f104g[7] * c0017c.f103f[12]);
        c0017c.f105h[5] = (c0017c.f104g[4] * c0017c.f103f[1]) + (c0017c.f104g[5] * c0017c.f103f[5]) + (c0017c.f104g[6] * c0017c.f103f[9]) + (c0017c.f104g[7] * c0017c.f103f[13]);
        c0017c.f105h[6] = (c0017c.f104g[4] * c0017c.f103f[2]) + (c0017c.f104g[5] * c0017c.f103f[6]) + (c0017c.f104g[6] * c0017c.f103f[10]) + (c0017c.f104g[7] * c0017c.f103f[14]);
        c0017c.f105h[7] = (c0017c.f104g[4] * c0017c.f103f[3]) + (c0017c.f104g[5] * c0017c.f103f[7]) + (c0017c.f104g[6] * c0017c.f103f[11]) + (c0017c.f104g[7] * c0017c.f103f[15]);
        c0017c.f105h[8] = (c0017c.f104g[8] * c0017c.f103f[0]) + (c0017c.f104g[9] * c0017c.f103f[4]) + (c0017c.f104g[10] * c0017c.f103f[8]) + (c0017c.f104g[11] * c0017c.f103f[12]);
        c0017c.f105h[9] = (c0017c.f104g[8] * c0017c.f103f[1]) + (c0017c.f104g[9] * c0017c.f103f[5]) + (c0017c.f104g[10] * c0017c.f103f[9]) + (c0017c.f104g[11] * c0017c.f103f[13]);
        c0017c.f105h[10] = (c0017c.f104g[8] * c0017c.f103f[2]) + (c0017c.f104g[9] * c0017c.f103f[6]) + (c0017c.f104g[10] * c0017c.f103f[10]) + (c0017c.f104g[11] * c0017c.f103f[14]);
        c0017c.f105h[11] = (c0017c.f104g[8] * c0017c.f103f[3]) + (c0017c.f104g[9] * c0017c.f103f[7]) + (c0017c.f104g[10] * c0017c.f103f[11]) + (c0017c.f104g[11] * c0017c.f103f[15]);
        c0017c.f105h[12] = (c0017c.f104g[12] * c0017c.f103f[0]) + (c0017c.f104g[13] * c0017c.f103f[4]) + (c0017c.f104g[14] * c0017c.f103f[8]) + (c0017c.f104g[15] * c0017c.f103f[12]);
        c0017c.f105h[13] = (c0017c.f104g[12] * c0017c.f103f[1]) + (c0017c.f104g[13] * c0017c.f103f[5]) + (c0017c.f104g[14] * c0017c.f103f[9]) + (c0017c.f104g[15] * c0017c.f103f[13]);
        c0017c.f105h[14] = (c0017c.f104g[12] * c0017c.f103f[2]) + (c0017c.f104g[13] * c0017c.f103f[6]) + (c0017c.f104g[14] * c0017c.f103f[10]) + (c0017c.f104g[15] * c0017c.f103f[14]);
        c0017c.f105h[15] = (c0017c.f104g[12] * c0017c.f103f[3]) + (c0017c.f104g[13] * c0017c.f103f[7]) + (c0017c.f104g[14] * c0017c.f103f[11]) + (c0017c.f104g[15] * c0017c.f103f[15]);
        c0017c.f98a[0][0] = c0017c.f105h[3] - c0017c.f105h[0];
        c0017c.f98a[0][1] = c0017c.f105h[7] - c0017c.f105h[4];
        c0017c.f98a[0][2] = c0017c.f105h[11] - c0017c.f105h[8];
        c0017c.f98a[0][3] = c0017c.f105h[15] - c0017c.f105h[12];
        m56a(c0017c.f98a, 0);
        c0017c.f98a[1][0] = c0017c.f105h[3] + c0017c.f105h[0];
        c0017c.f98a[1][1] = c0017c.f105h[7] + c0017c.f105h[4];
        c0017c.f98a[1][2] = c0017c.f105h[11] + c0017c.f105h[8];
        c0017c.f98a[1][3] = c0017c.f105h[15] + c0017c.f105h[12];
        m56a(c0017c.f98a, 1);
        c0017c.f98a[2][0] = c0017c.f105h[3] + c0017c.f105h[1];
        c0017c.f98a[2][1] = c0017c.f105h[7] + c0017c.f105h[5];
        c0017c.f98a[2][2] = c0017c.f105h[11] + c0017c.f105h[9];
        c0017c.f98a[2][3] = c0017c.f105h[15] + c0017c.f105h[13];
        m56a(c0017c.f98a, 2);
        c0017c.f98a[3][0] = c0017c.f105h[3] - c0017c.f105h[1];
        c0017c.f98a[3][1] = c0017c.f105h[7] - c0017c.f105h[5];
        c0017c.f98a[3][2] = c0017c.f105h[11] - c0017c.f105h[9];
        c0017c.f98a[3][3] = c0017c.f105h[15] - c0017c.f105h[13];
        m56a(c0017c.f98a, 3);
        c0017c.f98a[4][0] = c0017c.f105h[3] - c0017c.f105h[2];
        c0017c.f98a[4][1] = c0017c.f105h[7] - c0017c.f105h[6];
        c0017c.f98a[4][2] = c0017c.f105h[11] - c0017c.f105h[10];
        c0017c.f98a[4][3] = c0017c.f105h[15] - c0017c.f105h[14];
        m56a(c0017c.f98a, 4);
        c0017c.f98a[5][0] = c0017c.f105h[3] + c0017c.f105h[2];
        c0017c.f98a[5][1] = c0017c.f105h[7] + c0017c.f105h[6];
        c0017c.f98a[5][2] = c0017c.f105h[11] + c0017c.f105h[10];
        c0017c.f98a[5][3] = c0017c.f105h[15] + c0017c.f105h[14];
        m56a(c0017c.f98a, 5);
        return f99b;
    }

    /* JADX INFO: renamed from: a */
    private static void m56a(float[][] fArr, int i) {
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
    public final boolean m57a(C0031a c0031a) {
        float f = c0031a.f200a;
        float f2 = c0031a.f201b;
        float f3 = c0031a.f202c;
        float f4 = c0031a.f203d;
        float f5 = c0031a.f204e;
        float f6 = c0031a.f205f;
        for (int i = 0; i < 6; i++) {
            if ((this.f98a[i][0] * f) + (this.f98a[i][1] * f2) + (this.f98a[i][2] * f3) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f4) + (this.f98a[i][1] * f2) + (this.f98a[i][2] * f3) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f) + (this.f98a[i][1] * f5) + (this.f98a[i][2] * f3) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f4) + (this.f98a[i][1] * f5) + (this.f98a[i][2] * f3) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f) + (this.f98a[i][1] * f2) + (this.f98a[i][2] * f6) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f4) + (this.f98a[i][1] * f2) + (this.f98a[i][2] * f6) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f) + (this.f98a[i][1] * f5) + (this.f98a[i][2] * f6) + this.f98a[i][3] <= 0.0f && (this.f98a[i][0] * f4) + (this.f98a[i][1] * f5) + (this.f98a[i][2] * f6) + this.f98a[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }
}
