package com.mojang.minecraft.p000a;

import com.mojang.minecraft.phys.AABB;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.d */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/d.class */
public final class C0005d {

    /* JADX INFO: renamed from: b */
    private static C0005d f29b = new C0005d();

    /* JADX INFO: renamed from: a */
    private float[][] f28a = new float[6][4];

    /* JADX INFO: renamed from: c */
    private FloatBuffer f30c = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: d */
    private FloatBuffer f31d = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: e */
    private FloatBuffer f32e = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: f */
    private float[] f33f = new float[16];

    /* JADX INFO: renamed from: g */
    private float[] f34g = new float[16];

    /* JADX INFO: renamed from: h */
    private float[] f35h = new float[16];

    private C0005d() {
    }

    /* JADX INFO: renamed from: a */
    public static C0005d m10a() {
        C0005d c0005d = f29b;
        c0005d.f30c.clear();
        c0005d.f31d.clear();
        c0005d.f32e.clear();
        GL11.glGetFloat(2983, c0005d.f30c);
        GL11.glGetFloat(2982, c0005d.f31d);
        c0005d.f30c.flip().limit(16);
        c0005d.f30c.get(c0005d.f33f);
        c0005d.f31d.flip().limit(16);
        c0005d.f31d.get(c0005d.f34g);
        c0005d.f35h[0] = (c0005d.f34g[0] * c0005d.f33f[0]) + (c0005d.f34g[1] * c0005d.f33f[4]) + (c0005d.f34g[2] * c0005d.f33f[8]) + (c0005d.f34g[3] * c0005d.f33f[12]);
        c0005d.f35h[1] = (c0005d.f34g[0] * c0005d.f33f[1]) + (c0005d.f34g[1] * c0005d.f33f[5]) + (c0005d.f34g[2] * c0005d.f33f[9]) + (c0005d.f34g[3] * c0005d.f33f[13]);
        c0005d.f35h[2] = (c0005d.f34g[0] * c0005d.f33f[2]) + (c0005d.f34g[1] * c0005d.f33f[6]) + (c0005d.f34g[2] * c0005d.f33f[10]) + (c0005d.f34g[3] * c0005d.f33f[14]);
        c0005d.f35h[3] = (c0005d.f34g[0] * c0005d.f33f[3]) + (c0005d.f34g[1] * c0005d.f33f[7]) + (c0005d.f34g[2] * c0005d.f33f[11]) + (c0005d.f34g[3] * c0005d.f33f[15]);
        c0005d.f35h[4] = (c0005d.f34g[4] * c0005d.f33f[0]) + (c0005d.f34g[5] * c0005d.f33f[4]) + (c0005d.f34g[6] * c0005d.f33f[8]) + (c0005d.f34g[7] * c0005d.f33f[12]);
        c0005d.f35h[5] = (c0005d.f34g[4] * c0005d.f33f[1]) + (c0005d.f34g[5] * c0005d.f33f[5]) + (c0005d.f34g[6] * c0005d.f33f[9]) + (c0005d.f34g[7] * c0005d.f33f[13]);
        c0005d.f35h[6] = (c0005d.f34g[4] * c0005d.f33f[2]) + (c0005d.f34g[5] * c0005d.f33f[6]) + (c0005d.f34g[6] * c0005d.f33f[10]) + (c0005d.f34g[7] * c0005d.f33f[14]);
        c0005d.f35h[7] = (c0005d.f34g[4] * c0005d.f33f[3]) + (c0005d.f34g[5] * c0005d.f33f[7]) + (c0005d.f34g[6] * c0005d.f33f[11]) + (c0005d.f34g[7] * c0005d.f33f[15]);
        c0005d.f35h[8] = (c0005d.f34g[8] * c0005d.f33f[0]) + (c0005d.f34g[9] * c0005d.f33f[4]) + (c0005d.f34g[10] * c0005d.f33f[8]) + (c0005d.f34g[11] * c0005d.f33f[12]);
        c0005d.f35h[9] = (c0005d.f34g[8] * c0005d.f33f[1]) + (c0005d.f34g[9] * c0005d.f33f[5]) + (c0005d.f34g[10] * c0005d.f33f[9]) + (c0005d.f34g[11] * c0005d.f33f[13]);
        c0005d.f35h[10] = (c0005d.f34g[8] * c0005d.f33f[2]) + (c0005d.f34g[9] * c0005d.f33f[6]) + (c0005d.f34g[10] * c0005d.f33f[10]) + (c0005d.f34g[11] * c0005d.f33f[14]);
        c0005d.f35h[11] = (c0005d.f34g[8] * c0005d.f33f[3]) + (c0005d.f34g[9] * c0005d.f33f[7]) + (c0005d.f34g[10] * c0005d.f33f[11]) + (c0005d.f34g[11] * c0005d.f33f[15]);
        c0005d.f35h[12] = (c0005d.f34g[12] * c0005d.f33f[0]) + (c0005d.f34g[13] * c0005d.f33f[4]) + (c0005d.f34g[14] * c0005d.f33f[8]) + (c0005d.f34g[15] * c0005d.f33f[12]);
        c0005d.f35h[13] = (c0005d.f34g[12] * c0005d.f33f[1]) + (c0005d.f34g[13] * c0005d.f33f[5]) + (c0005d.f34g[14] * c0005d.f33f[9]) + (c0005d.f34g[15] * c0005d.f33f[13]);
        c0005d.f35h[14] = (c0005d.f34g[12] * c0005d.f33f[2]) + (c0005d.f34g[13] * c0005d.f33f[6]) + (c0005d.f34g[14] * c0005d.f33f[10]) + (c0005d.f34g[15] * c0005d.f33f[14]);
        c0005d.f35h[15] = (c0005d.f34g[12] * c0005d.f33f[3]) + (c0005d.f34g[13] * c0005d.f33f[7]) + (c0005d.f34g[14] * c0005d.f33f[11]) + (c0005d.f34g[15] * c0005d.f33f[15]);
        c0005d.f28a[0][0] = c0005d.f35h[3] - c0005d.f35h[0];
        c0005d.f28a[0][1] = c0005d.f35h[7] - c0005d.f35h[4];
        c0005d.f28a[0][2] = c0005d.f35h[11] - c0005d.f35h[8];
        c0005d.f28a[0][3] = c0005d.f35h[15] - c0005d.f35h[12];
        m11a(c0005d.f28a, 0);
        c0005d.f28a[1][0] = c0005d.f35h[3] + c0005d.f35h[0];
        c0005d.f28a[1][1] = c0005d.f35h[7] + c0005d.f35h[4];
        c0005d.f28a[1][2] = c0005d.f35h[11] + c0005d.f35h[8];
        c0005d.f28a[1][3] = c0005d.f35h[15] + c0005d.f35h[12];
        m11a(c0005d.f28a, 1);
        c0005d.f28a[2][0] = c0005d.f35h[3] + c0005d.f35h[1];
        c0005d.f28a[2][1] = c0005d.f35h[7] + c0005d.f35h[5];
        c0005d.f28a[2][2] = c0005d.f35h[11] + c0005d.f35h[9];
        c0005d.f28a[2][3] = c0005d.f35h[15] + c0005d.f35h[13];
        m11a(c0005d.f28a, 2);
        c0005d.f28a[3][0] = c0005d.f35h[3] - c0005d.f35h[1];
        c0005d.f28a[3][1] = c0005d.f35h[7] - c0005d.f35h[5];
        c0005d.f28a[3][2] = c0005d.f35h[11] - c0005d.f35h[9];
        c0005d.f28a[3][3] = c0005d.f35h[15] - c0005d.f35h[13];
        m11a(c0005d.f28a, 3);
        c0005d.f28a[4][0] = c0005d.f35h[3] - c0005d.f35h[2];
        c0005d.f28a[4][1] = c0005d.f35h[7] - c0005d.f35h[6];
        c0005d.f28a[4][2] = c0005d.f35h[11] - c0005d.f35h[10];
        c0005d.f28a[4][3] = c0005d.f35h[15] - c0005d.f35h[14];
        m11a(c0005d.f28a, 4);
        c0005d.f28a[5][0] = c0005d.f35h[3] + c0005d.f35h[2];
        c0005d.f28a[5][1] = c0005d.f35h[7] + c0005d.f35h[6];
        c0005d.f28a[5][2] = c0005d.f35h[11] + c0005d.f35h[10];
        c0005d.f28a[5][3] = c0005d.f35h[15] + c0005d.f35h[14];
        m11a(c0005d.f28a, 5);
        return f29b;
    }

    /* JADX INFO: renamed from: a */
    private static void m11a(float[][] fArr, int i) {
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
    public final boolean m12a(float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 6; i++) {
            if ((this.f28a[i][0] * f) + (this.f28a[i][1] * f2) + (this.f28a[i][2] * f3) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f4) + (this.f28a[i][1] * f2) + (this.f28a[i][2] * f3) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f) + (this.f28a[i][1] * f5) + (this.f28a[i][2] * f3) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f4) + (this.f28a[i][1] * f5) + (this.f28a[i][2] * f3) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f) + (this.f28a[i][1] * f2) + (this.f28a[i][2] * f6) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f4) + (this.f28a[i][1] * f2) + (this.f28a[i][2] * f6) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f) + (this.f28a[i][1] * f5) + (this.f28a[i][2] * f6) + this.f28a[i][3] <= 0.0f && (this.f28a[i][0] * f4) + (this.f28a[i][1] * f5) + (this.f28a[i][2] * f6) + this.f28a[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m13a(AABB aabb) {
        return m12a(aabb.f231x0, aabb.f232y0, aabb.f233z0, aabb.f234x1, aabb.f235y1, aabb.f236z1);
    }
}
