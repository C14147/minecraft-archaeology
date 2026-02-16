package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/PartialDisk.class */
public class PartialDisk extends Quadric {
    private static final int CACHE_SIZE = 240;

    public void draw(float innerRadius, float outerRadius, int slices, int loops, float startAngle, float sweepAngle) {
        int slices2;
        int finish;
        float[] sinCache = new float[240];
        float[] cosCache = new float[240];
        float texLow = 0.0f;
        float texHigh = 0.0f;
        if (slices >= 240) {
            slices = 239;
        }
        if (slices < 2 || loops < 1 || outerRadius <= 0.0f || innerRadius < 0.0f || innerRadius > outerRadius) {
            System.err.println("PartialDisk: GLU_INVALID_VALUE");
            return;
        }
        if (sweepAngle < -360.0f) {
            sweepAngle = 360.0f;
        }
        if (sweepAngle > 360.0f) {
            sweepAngle = 360.0f;
        }
        if (sweepAngle < 0.0f) {
            startAngle += sweepAngle;
            sweepAngle = -sweepAngle;
        }
        if (sweepAngle == 360.0f) {
            slices2 = slices;
        } else {
            slices2 = slices + 1;
        }
        float deltaRadius = outerRadius - innerRadius;
        float angleOffset = (startAngle / 180.0f) * 3.1415927f;
        for (int i = 0; i <= slices; i++) {
            float angle = angleOffset + ((((3.1415927f * sweepAngle) / 180.0f) * i) / slices);
            sinCache[i] = sin(angle);
            cosCache[i] = cos(angle);
        }
        if (sweepAngle == 360.0f) {
            sinCache[slices] = sinCache[0];
            cosCache[slices] = cosCache[0];
        }
        switch (this.normals) {
            case GLU.GLU_SMOOTH /* 100000 */:
            case GLU.GLU_FLAT /* 100001 */:
                if (this.orientation == 100020) {
                    GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                } else {
                    GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                }
                break;
        }
        switch (this.drawStyle) {
            case GLU.GLU_POINT /* 100010 */:
                GL11.glBegin(0);
                for (int i2 = 0; i2 < slices2; i2++) {
                    float sintemp = sinCache[i2];
                    float costemp = cosCache[i2];
                    for (int j = 0; j <= loops; j++) {
                        float radiusLow = outerRadius - (deltaRadius * (j / loops));
                        if (this.textureFlag) {
                            float texLow2 = (radiusLow / outerRadius) / 2.0f;
                            GL11.glTexCoord2f((texLow2 * sinCache[i2]) + 0.5f, (texLow2 * cosCache[i2]) + 0.5f);
                        }
                        GL11.glVertex3f(radiusLow * sintemp, radiusLow * costemp, 0.0f);
                    }
                }
                GL11.glEnd();
                break;
            case GLU.GLU_LINE /* 100011 */:
                if (innerRadius == outerRadius) {
                    GL11.glBegin(3);
                    for (int i3 = 0; i3 <= slices; i3++) {
                        if (this.textureFlag) {
                            GL11.glTexCoord2f((sinCache[i3] / 2.0f) + 0.5f, (cosCache[i3] / 2.0f) + 0.5f);
                        }
                        GL11.glVertex3f(innerRadius * sinCache[i3], innerRadius * cosCache[i3], 0.0f);
                    }
                    GL11.glEnd();
                } else {
                    for (int j2 = 0; j2 <= loops; j2++) {
                        float radiusLow2 = outerRadius - (deltaRadius * (j2 / loops));
                        if (this.textureFlag) {
                            texLow = (radiusLow2 / outerRadius) / 2.0f;
                        }
                        GL11.glBegin(3);
                        for (int i4 = 0; i4 <= slices; i4++) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i4]) + 0.5f, (texLow * cosCache[i4]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow2 * sinCache[i4], radiusLow2 * cosCache[i4], 0.0f);
                        }
                        GL11.glEnd();
                    }
                    for (int i5 = 0; i5 < slices2; i5++) {
                        float sintemp2 = sinCache[i5];
                        float costemp2 = cosCache[i5];
                        GL11.glBegin(3);
                        for (int j3 = 0; j3 <= loops; j3++) {
                            float radiusLow3 = outerRadius - (deltaRadius * (j3 / loops));
                            if (this.textureFlag) {
                                texLow = (radiusLow3 / outerRadius) / 2.0f;
                            }
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i5]) + 0.5f, (texLow * cosCache[i5]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow3 * sintemp2, radiusLow3 * costemp2, 0.0f);
                        }
                        GL11.glEnd();
                    }
                }
                break;
            case GLU.GLU_FILL /* 100012 */:
                if (innerRadius == 0.0f) {
                    finish = loops - 1;
                    GL11.glBegin(6);
                    if (this.textureFlag) {
                        GL11.glTexCoord2f(0.5f, 0.5f);
                    }
                    GL11.glVertex3f(0.0f, 0.0f, 0.0f);
                    float radiusLow4 = outerRadius - (deltaRadius * ((loops - 1) / loops));
                    if (this.textureFlag) {
                        texLow = (radiusLow4 / outerRadius) / 2.0f;
                    }
                    if (this.orientation == 100020) {
                        for (int i6 = slices; i6 >= 0; i6--) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i6]) + 0.5f, (texLow * cosCache[i6]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow4 * sinCache[i6], radiusLow4 * cosCache[i6], 0.0f);
                        }
                    } else {
                        for (int i7 = 0; i7 <= slices; i7++) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i7]) + 0.5f, (texLow * cosCache[i7]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow4 * sinCache[i7], radiusLow4 * cosCache[i7], 0.0f);
                        }
                    }
                    GL11.glEnd();
                } else {
                    finish = loops;
                }
                for (int j4 = 0; j4 < finish; j4++) {
                    float radiusLow5 = outerRadius - (deltaRadius * (j4 / loops));
                    float radiusHigh = outerRadius - (deltaRadius * ((j4 + 1) / loops));
                    if (this.textureFlag) {
                        texLow = (radiusLow5 / outerRadius) / 2.0f;
                        texHigh = (radiusHigh / outerRadius) / 2.0f;
                    }
                    GL11.glBegin(8);
                    for (int i8 = 0; i8 <= slices; i8++) {
                        if (this.orientation == 100020) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i8]) + 0.5f, (texLow * cosCache[i8]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow5 * sinCache[i8], radiusLow5 * cosCache[i8], 0.0f);
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texHigh * sinCache[i8]) + 0.5f, (texHigh * cosCache[i8]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusHigh * sinCache[i8], radiusHigh * cosCache[i8], 0.0f);
                        } else {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texHigh * sinCache[i8]) + 0.5f, (texHigh * cosCache[i8]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusHigh * sinCache[i8], radiusHigh * cosCache[i8], 0.0f);
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i8]) + 0.5f, (texLow * cosCache[i8]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow5 * sinCache[i8], radiusLow5 * cosCache[i8], 0.0f);
                        }
                    }
                    GL11.glEnd();
                }
                break;
            case GLU.GLU_SILHOUETTE /* 100013 */:
                if (sweepAngle < 360.0f) {
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 <= slices) {
                            float sintemp3 = sinCache[i10];
                            float costemp3 = cosCache[i10];
                            GL11.glBegin(3);
                            for (int j5 = 0; j5 <= loops; j5++) {
                                float radiusLow6 = outerRadius - (deltaRadius * (j5 / loops));
                                if (this.textureFlag) {
                                    texLow = (radiusLow6 / outerRadius) / 2.0f;
                                    GL11.glTexCoord2f((texLow * sinCache[i10]) + 0.5f, (texLow * cosCache[i10]) + 0.5f);
                                }
                                GL11.glVertex3f(radiusLow6 * sintemp3, radiusLow6 * costemp3, 0.0f);
                            }
                            GL11.glEnd();
                            i9 = i10 + slices;
                        }
                    }
                }
                int i11 = 0;
                while (true) {
                    int j6 = i11;
                    if (j6 <= loops) {
                        float radiusLow7 = outerRadius - (deltaRadius * (j6 / loops));
                        if (this.textureFlag) {
                            texLow = (radiusLow7 / outerRadius) / 2.0f;
                        }
                        GL11.glBegin(3);
                        for (int i12 = 0; i12 <= slices; i12++) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f((texLow * sinCache[i12]) + 0.5f, (texLow * cosCache[i12]) + 0.5f);
                            }
                            GL11.glVertex3f(radiusLow7 * sinCache[i12], radiusLow7 * cosCache[i12], 0.0f);
                        }
                        GL11.glEnd();
                        if (innerRadius != outerRadius) {
                            i11 = j6 + loops;
                        }
                    }
                    break;
                }
                break;
        }
    }
}
