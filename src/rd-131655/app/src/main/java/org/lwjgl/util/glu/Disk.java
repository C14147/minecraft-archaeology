package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/Disk.class */
public class Disk extends Quadric {
    public void draw(float innerRadius, float outerRadius, int slices, int loops) {
        float f;
        float f2;
        if (this.normals != 100002) {
            if (this.orientation == 100020) {
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
            } else {
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
            }
        }
        float da = 6.2831855f / slices;
        float dr = (outerRadius - innerRadius) / loops;
        switch (this.drawStyle) {
            case GLU.GLU_POINT /* 100010 */:
                GL11.glBegin(0);
                for (int s = 0; s < slices; s++) {
                    float a = s * da;
                    float x = sin(a);
                    float y = cos(a);
                    for (int l = 0; l <= loops; l++) {
                        float r = innerRadius * l * dr;
                        GL11.glVertex2f(r * x, r * y);
                    }
                }
                GL11.glEnd();
                break;
            case GLU.GLU_LINE /* 100011 */:
                for (int l2 = 0; l2 <= loops; l2++) {
                    float r2 = innerRadius + (l2 * dr);
                    GL11.glBegin(2);
                    for (int s2 = 0; s2 < slices; s2++) {
                        float a2 = s2 * da;
                        GL11.glVertex2f(r2 * sin(a2), r2 * cos(a2));
                    }
                    GL11.glEnd();
                }
                for (int s3 = 0; s3 < slices; s3++) {
                    float a3 = s3 * da;
                    float x2 = sin(a3);
                    float y2 = cos(a3);
                    GL11.glBegin(3);
                    for (int l3 = 0; l3 <= loops; l3++) {
                        float r3 = innerRadius + (l3 * dr);
                        GL11.glVertex2f(r3 * x2, r3 * y2);
                    }
                    GL11.glEnd();
                }
                break;
            case GLU.GLU_FILL /* 100012 */:
                float dtc = 2.0f * outerRadius;
                float r1 = innerRadius;
                for (int l4 = 0; l4 < loops; l4++) {
                    float r22 = r1 + dr;
                    if (this.orientation == 100020) {
                        GL11.glBegin(8);
                        for (int s4 = 0; s4 <= slices; s4++) {
                            if (s4 == slices) {
                                f2 = 0.0f;
                            } else {
                                f2 = s4 * da;
                            }
                            float a4 = f2;
                            float sa = sin(a4);
                            float ca = cos(a4);
                            TXTR_COORD(0.5f + ((sa * r22) / dtc), 0.5f + ((ca * r22) / dtc));
                            GL11.glVertex2f(r22 * sa, r22 * ca);
                            TXTR_COORD(0.5f + ((sa * r1) / dtc), 0.5f + ((ca * r1) / dtc));
                            GL11.glVertex2f(r1 * sa, r1 * ca);
                        }
                        GL11.glEnd();
                    } else {
                        GL11.glBegin(8);
                        for (int s5 = slices; s5 >= 0; s5--) {
                            if (s5 == slices) {
                                f = 0.0f;
                            } else {
                                f = s5 * da;
                            }
                            float a5 = f;
                            float sa2 = sin(a5);
                            float ca2 = cos(a5);
                            TXTR_COORD(0.5f - ((sa2 * r22) / dtc), 0.5f + ((ca2 * r22) / dtc));
                            GL11.glVertex2f(r22 * sa2, r22 * ca2);
                            TXTR_COORD(0.5f - ((sa2 * r1) / dtc), 0.5f + ((ca2 * r1) / dtc));
                            GL11.glVertex2f(r1 * sa2, r1 * ca2);
                        }
                        GL11.glEnd();
                    }
                    r1 = r22;
                }
                break;
            case GLU.GLU_SILHOUETTE /* 100013 */:
                if (innerRadius != 0.0d) {
                    GL11.glBegin(2);
                    float f3 = 0.0f;
                    while (true) {
                        float a6 = f3;
                        if (a6 < 6.2831854820251465d) {
                            float x3 = innerRadius * sin(a6);
                            float y3 = innerRadius * cos(a6);
                            GL11.glVertex2f(x3, y3);
                            f3 = a6 + da;
                        } else {
                            GL11.glEnd();
                        }
                    }
                }
                GL11.glBegin(2);
                float f4 = 0.0f;
                while (true) {
                    float a7 = f4;
                    if (a7 < 6.2831855f) {
                        float x4 = outerRadius * sin(a7);
                        float y4 = outerRadius * cos(a7);
                        GL11.glVertex2f(x4, y4);
                        f4 = a7 + da;
                    } else {
                        GL11.glEnd();
                    }
                    break;
                }
                break;
        }
    }
}
