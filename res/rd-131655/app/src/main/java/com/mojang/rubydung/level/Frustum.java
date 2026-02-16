package com.mojang.rubydung.level;

import com.mojang.rubydung.phys.AABB;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/Frustum.class */
public class Frustum {
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int BOTTOM = 2;
    public static final int TOP = 3;
    public static final int BACK = 4;
    public static final int FRONT = 5;
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    private static Frustum frustum = new Frustum();
    float[][] m_Frustum = new float[6][4];
    FloatBuffer modl_b = BufferUtils.createFloatBuffer(16);
    FloatBuffer proj_b = BufferUtils.createFloatBuffer(16);

    public static Frustum getFrustum() {
        frustum.calculateFrustum();
        return frustum;
    }

    public void normalizePlane(float[][] frustum2, int side) {
        float magnitude = (float) Math.sqrt((frustum2[side][0] * frustum2[side][0]) + (frustum2[side][1] * frustum2[side][1]) + (frustum2[side][2] * frustum2[side][2]));
        float[] fArr = frustum2[side];
        fArr[0] = fArr[0] / magnitude;
        float[] fArr2 = frustum2[side];
        fArr2[1] = fArr2[1] / magnitude;
        float[] fArr3 = frustum2[side];
        fArr3[2] = fArr3[2] / magnitude;
        float[] fArr4 = frustum2[side];
        fArr4[3] = fArr4[3] / magnitude;
    }

    public void calculateFrustum() {
        float[] proj = new float[16];
        float[] modl = new float[16];
        this.proj_b.rewind();
        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, this.proj_b);
        this.proj_b.rewind();
        this.proj_b.get(proj);
        this.modl_b.rewind();
        GL11.glGetFloat(2982, this.modl_b);
        this.modl_b.rewind();
        this.modl_b.get(modl);
        float[] clip = {(modl[0] * proj[0]) + (modl[1] * proj[4]) + (modl[2] * proj[8]) + (modl[3] * proj[12]), (modl[0] * proj[1]) + (modl[1] * proj[5]) + (modl[2] * proj[9]) + (modl[3] * proj[13]), (modl[0] * proj[2]) + (modl[1] * proj[6]) + (modl[2] * proj[10]) + (modl[3] * proj[14]), (modl[0] * proj[3]) + (modl[1] * proj[7]) + (modl[2] * proj[11]) + (modl[3] * proj[15]), (modl[4] * proj[0]) + (modl[5] * proj[4]) + (modl[6] * proj[8]) + (modl[7] * proj[12]), (modl[4] * proj[1]) + (modl[5] * proj[5]) + (modl[6] * proj[9]) + (modl[7] * proj[13]), (modl[4] * proj[2]) + (modl[5] * proj[6]) + (modl[6] * proj[10]) + (modl[7] * proj[14]), (modl[4] * proj[3]) + (modl[5] * proj[7]) + (modl[6] * proj[11]) + (modl[7] * proj[15]), (modl[8] * proj[0]) + (modl[9] * proj[4]) + (modl[10] * proj[8]) + (modl[11] * proj[12]), (modl[8] * proj[1]) + (modl[9] * proj[5]) + (modl[10] * proj[9]) + (modl[11] * proj[13]), (modl[8] * proj[2]) + (modl[9] * proj[6]) + (modl[10] * proj[10]) + (modl[11] * proj[14]), (modl[8] * proj[3]) + (modl[9] * proj[7]) + (modl[10] * proj[11]) + (modl[11] * proj[15]), (modl[12] * proj[0]) + (modl[13] * proj[4]) + (modl[14] * proj[8]) + (modl[15] * proj[12]), (modl[12] * proj[1]) + (modl[13] * proj[5]) + (modl[14] * proj[9]) + (modl[15] * proj[13]), (modl[12] * proj[2]) + (modl[13] * proj[6]) + (modl[14] * proj[10]) + (modl[15] * proj[14]), (modl[12] * proj[3]) + (modl[13] * proj[7]) + (modl[14] * proj[11]) + (modl[15] * proj[15])};
        this.m_Frustum[0][0] = clip[3] - clip[0];
        this.m_Frustum[0][1] = clip[7] - clip[4];
        this.m_Frustum[0][2] = clip[11] - clip[8];
        this.m_Frustum[0][3] = clip[15] - clip[12];
        normalizePlane(this.m_Frustum, 0);
        this.m_Frustum[1][0] = clip[3] + clip[0];
        this.m_Frustum[1][1] = clip[7] + clip[4];
        this.m_Frustum[1][2] = clip[11] + clip[8];
        this.m_Frustum[1][3] = clip[15] + clip[12];
        normalizePlane(this.m_Frustum, 1);
        this.m_Frustum[2][0] = clip[3] + clip[1];
        this.m_Frustum[2][1] = clip[7] + clip[5];
        this.m_Frustum[2][2] = clip[11] + clip[9];
        this.m_Frustum[2][3] = clip[15] + clip[13];
        normalizePlane(this.m_Frustum, 2);
        this.m_Frustum[3][0] = clip[3] - clip[1];
        this.m_Frustum[3][1] = clip[7] - clip[5];
        this.m_Frustum[3][2] = clip[11] - clip[9];
        this.m_Frustum[3][3] = clip[15] - clip[13];
        normalizePlane(this.m_Frustum, 3);
        this.m_Frustum[4][0] = clip[3] - clip[2];
        this.m_Frustum[4][1] = clip[7] - clip[6];
        this.m_Frustum[4][2] = clip[11] - clip[10];
        this.m_Frustum[4][3] = clip[15] - clip[14];
        normalizePlane(this.m_Frustum, 4);
        this.m_Frustum[5][0] = clip[3] + clip[2];
        this.m_Frustum[5][1] = clip[7] + clip[6];
        this.m_Frustum[5][2] = clip[11] + clip[10];
        this.m_Frustum[5][3] = clip[15] + clip[14];
        normalizePlane(this.m_Frustum, 5);
    }

    public boolean pointInFrustum(float x, float y, float z) {
        for (int i = 0; i < 6; i++) {
            if ((this.m_Frustum[i][0] * x) + (this.m_Frustum[i][1] * y) + (this.m_Frustum[i][2] * z) + this.m_Frustum[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustum(float x, float y, float z, float radius) {
        for (int i = 0; i < 6; i++) {
            if ((this.m_Frustum[i][0] * x) + (this.m_Frustum[i][1] * y) + (this.m_Frustum[i][2] * z) + this.m_Frustum[i][3] <= (-radius)) {
                return false;
            }
        }
        return true;
    }

    public boolean cubeInFrustum(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        for (int i = 0; i < 6; i++) {
            if ((this.m_Frustum[i][0] * minX) + (this.m_Frustum[i][1] * minY) + (this.m_Frustum[i][2] * minZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * maxX) + (this.m_Frustum[i][1] * minY) + (this.m_Frustum[i][2] * minZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * minX) + (this.m_Frustum[i][1] * maxY) + (this.m_Frustum[i][2] * minZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * maxX) + (this.m_Frustum[i][1] * maxY) + (this.m_Frustum[i][2] * minZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * minX) + (this.m_Frustum[i][1] * minY) + (this.m_Frustum[i][2] * maxZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * maxX) + (this.m_Frustum[i][1] * minY) + (this.m_Frustum[i][2] * maxZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * minX) + (this.m_Frustum[i][1] * maxY) + (this.m_Frustum[i][2] * maxZ) + this.m_Frustum[i][3] <= 0.0f && (this.m_Frustum[i][0] * maxX) + (this.m_Frustum[i][1] * maxY) + (this.m_Frustum[i][2] * maxZ) + this.m_Frustum[i][3] <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean cubeInFrustum(AABB aabb) {
        return cubeInFrustum((float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ);
    }
}
