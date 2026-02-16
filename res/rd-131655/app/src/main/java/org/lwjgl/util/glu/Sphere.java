package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/Sphere.class */
public class Sphere extends Quadric {
    public void draw(float radius, int slices, int stacks) {
        float nsign;
        int imin;
        int imax;
        boolean normals = this.normals != 100002;
        if (this.orientation == 100021) {
            nsign = -1.0f;
        } else {
            nsign = 1.0f;
        }
        float drho = 3.1415927f / stacks;
        float dtheta = 6.2831855f / slices;
        if (this.drawStyle == 100012) {
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                GL11.glVertex3f(0.0f, 0.0f, nsign * radius);
                int j = 0;
                while (j <= slices) {
                    float theta = j == slices ? 0.0f : j * dtheta;
                    float x = (-sin(theta)) * sin(drho);
                    float y = cos(theta) * sin(drho);
                    float z = nsign * cos(drho);
                    if (normals) {
                        GL11.glNormal3f(x * nsign, y * nsign, z * nsign);
                    }
                    GL11.glVertex3f(x * radius, y * radius, z * radius);
                    j++;
                }
                GL11.glEnd();
            }
            float ds = 1.0f / slices;
            float dt = 1.0f / stacks;
            float t = 1.0f;
            if (this.textureFlag) {
                imin = 0;
                imax = stacks;
            } else {
                imin = 1;
                imax = stacks - 1;
            }
            for (int i = imin; i < imax; i++) {
                float rho = i * drho;
                GL11.glBegin(8);
                float s = 0.0f;
                int j2 = 0;
                while (j2 <= slices) {
                    float theta2 = j2 == slices ? 0.0f : j2 * dtheta;
                    float x2 = (-sin(theta2)) * sin(rho);
                    float y2 = cos(theta2) * sin(rho);
                    float z2 = nsign * cos(rho);
                    if (normals) {
                        GL11.glNormal3f(x2 * nsign, y2 * nsign, z2 * nsign);
                    }
                    TXTR_COORD(s, t);
                    GL11.glVertex3f(x2 * radius, y2 * radius, z2 * radius);
                    float x3 = (-sin(theta2)) * sin(rho + drho);
                    float y3 = cos(theta2) * sin(rho + drho);
                    float z3 = nsign * cos(rho + drho);
                    if (normals) {
                        GL11.glNormal3f(x3 * nsign, y3 * nsign, z3 * nsign);
                    }
                    TXTR_COORD(s, t - dt);
                    s += ds;
                    GL11.glVertex3f(x3 * radius, y3 * radius, z3 * radius);
                    j2++;
                }
                GL11.glEnd();
                t -= dt;
            }
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                GL11.glVertex3f(0.0f, 0.0f, (-radius) * nsign);
                float rho2 = 3.1415927f - drho;
                float s2 = 1.0f;
                int j3 = slices;
                while (j3 >= 0) {
                    float theta3 = j3 == slices ? 0.0f : j3 * dtheta;
                    float x4 = (-sin(theta3)) * sin(rho2);
                    float y4 = cos(theta3) * sin(rho2);
                    float z4 = nsign * cos(rho2);
                    if (normals) {
                        GL11.glNormal3f(x4 * nsign, y4 * nsign, z4 * nsign);
                    }
                    s2 -= ds;
                    GL11.glVertex3f(x4 * radius, y4 * radius, z4 * radius);
                    j3--;
                }
                GL11.glEnd();
                return;
            }
            return;
        }
        if (this.drawStyle == 100011 || this.drawStyle == 100013) {
            for (int i2 = 1; i2 < stacks; i2++) {
                float rho3 = i2 * drho;
                GL11.glBegin(2);
                for (int j4 = 0; j4 < slices; j4++) {
                    float theta4 = j4 * dtheta;
                    float x5 = cos(theta4) * sin(rho3);
                    float y5 = sin(theta4) * sin(rho3);
                    float z5 = cos(rho3);
                    if (normals) {
                        GL11.glNormal3f(x5 * nsign, y5 * nsign, z5 * nsign);
                    }
                    GL11.glVertex3f(x5 * radius, y5 * radius, z5 * radius);
                }
                GL11.glEnd();
            }
            for (int j5 = 0; j5 < slices; j5++) {
                float theta5 = j5 * dtheta;
                GL11.glBegin(3);
                for (int i3 = 0; i3 <= stacks; i3++) {
                    float rho4 = i3 * drho;
                    float x6 = cos(theta5) * sin(rho4);
                    float y6 = sin(theta5) * sin(rho4);
                    float z6 = cos(rho4);
                    if (normals) {
                        GL11.glNormal3f(x6 * nsign, y6 * nsign, z6 * nsign);
                    }
                    GL11.glVertex3f(x6 * radius, y6 * radius, z6 * radius);
                }
                GL11.glEnd();
            }
            return;
        }
        if (this.drawStyle == 100010) {
            GL11.glBegin(0);
            if (normals) {
                GL11.glNormal3f(0.0f, 0.0f, nsign);
            }
            GL11.glVertex3f(0.0f, 0.0f, radius);
            if (normals) {
                GL11.glNormal3f(0.0f, 0.0f, -nsign);
            }
            GL11.glVertex3f(0.0f, 0.0f, -radius);
            for (int i4 = 1; i4 < stacks - 1; i4++) {
                float rho5 = i4 * drho;
                for (int j6 = 0; j6 < slices; j6++) {
                    float theta6 = j6 * dtheta;
                    float x7 = cos(theta6) * sin(rho5);
                    float y7 = sin(theta6) * sin(rho5);
                    float z7 = cos(rho5);
                    if (normals) {
                        GL11.glNormal3f(x7 * nsign, y7 * nsign, z7 * nsign);
                    }
                    GL11.glVertex3f(x7 * radius, y7 * radius, z7 * radius);
                }
            }
            GL11.glEnd();
        }
    }
}
