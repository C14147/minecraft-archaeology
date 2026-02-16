package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/Cylinder.class */
public class Cylinder extends Quadric {
    public void draw(float baseRadius, float topRadius, float height, int slices, int stacks) {
        float nsign;
        float x;
        float y;
        if (this.orientation == 100021) {
            nsign = -1.0f;
        } else {
            nsign = 1.0f;
        }
        float da = 6.2831855f / slices;
        float dr = (topRadius - baseRadius) / stacks;
        float dz = height / stacks;
        float nz = (baseRadius - topRadius) / height;
        if (this.drawStyle == 100010) {
            GL11.glBegin(0);
            for (int i = 0; i < slices; i++) {
                float x2 = cos(i * da);
                float y2 = sin(i * da);
                normal3f(x2 * nsign, y2 * nsign, nz * nsign);
                float z = 0.0f;
                float r = baseRadius;
                for (int j = 0; j <= stacks; j++) {
                    GL11.glVertex3f(x2 * r, y2 * r, z);
                    z += dz;
                    r += dr;
                }
            }
            GL11.glEnd();
            return;
        }
        if (this.drawStyle == 100011 || this.drawStyle == 100013) {
            if (this.drawStyle == 100011) {
                float z2 = 0.0f;
                float r2 = baseRadius;
                for (int j2 = 0; j2 <= stacks; j2++) {
                    GL11.glBegin(2);
                    for (int i2 = 0; i2 < slices; i2++) {
                        float x3 = cos(i2 * da);
                        float y3 = sin(i2 * da);
                        normal3f(x3 * nsign, y3 * nsign, nz * nsign);
                        GL11.glVertex3f(x3 * r2, y3 * r2, z2);
                    }
                    GL11.glEnd();
                    z2 += dz;
                    r2 += dr;
                }
            } else if (baseRadius != 0.0d) {
                GL11.glBegin(2);
                for (int i3 = 0; i3 < slices; i3++) {
                    float x4 = cos(i3 * da);
                    float y4 = sin(i3 * da);
                    normal3f(x4 * nsign, y4 * nsign, nz * nsign);
                    GL11.glVertex3f(x4 * baseRadius, y4 * baseRadius, 0.0f);
                }
                GL11.glEnd();
                GL11.glBegin(2);
                for (int i4 = 0; i4 < slices; i4++) {
                    float x5 = cos(i4 * da);
                    float y5 = sin(i4 * da);
                    normal3f(x5 * nsign, y5 * nsign, nz * nsign);
                    GL11.glVertex3f(x5 * topRadius, y5 * topRadius, height);
                }
                GL11.glEnd();
            }
            GL11.glBegin(1);
            for (int i5 = 0; i5 < slices; i5++) {
                float x6 = cos(i5 * da);
                float y6 = sin(i5 * da);
                normal3f(x6 * nsign, y6 * nsign, nz * nsign);
                GL11.glVertex3f(x6 * baseRadius, y6 * baseRadius, 0.0f);
                GL11.glVertex3f(x6 * topRadius, y6 * topRadius, height);
            }
            GL11.glEnd();
            return;
        }
        if (this.drawStyle == 100012) {
            float ds = 1.0f / slices;
            float dt = 1.0f / stacks;
            float t = 0.0f;
            float z3 = 0.0f;
            float r3 = baseRadius;
            for (int j3 = 0; j3 < stacks; j3++) {
                float s = 0.0f;
                GL11.glBegin(8);
                for (int i6 = 0; i6 <= slices; i6++) {
                    if (i6 == slices) {
                        x = sin(0.0f);
                        y = cos(0.0f);
                    } else {
                        x = sin(i6 * da);
                        y = cos(i6 * da);
                    }
                    if (nsign == 1.0f) {
                        normal3f(x * nsign, y * nsign, nz * nsign);
                        TXTR_COORD(s, t);
                        GL11.glVertex3f(x * r3, y * r3, z3);
                        normal3f(x * nsign, y * nsign, nz * nsign);
                        TXTR_COORD(s, t + dt);
                        GL11.glVertex3f(x * (r3 + dr), y * (r3 + dr), z3 + dz);
                    } else {
                        normal3f(x * nsign, y * nsign, nz * nsign);
                        TXTR_COORD(s, t);
                        GL11.glVertex3f(x * r3, y * r3, z3);
                        normal3f(x * nsign, y * nsign, nz * nsign);
                        TXTR_COORD(s, t + dt);
                        GL11.glVertex3f(x * (r3 + dr), y * (r3 + dr), z3 + dz);
                    }
                    s += ds;
                }
                GL11.glEnd();
                r3 += dr;
                t += dt;
                z3 += dz;
            }
        }
    }
}
