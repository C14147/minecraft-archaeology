package com.mojang.minecraft.p007e;

import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.e.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/e/b.class */
public final class C0035b {

    /* JADX INFO: renamed from: d */
    private C0038e[] f194d;

    /* JADX INFO: renamed from: e */
    private C0037d[] f195e;

    /* JADX INFO: renamed from: f */
    private int f196f;

    /* JADX INFO: renamed from: g */
    private int f197g;

    /* JADX INFO: renamed from: h */
    private float f198h;

    /* JADX INFO: renamed from: i */
    private float f199i;

    /* JADX INFO: renamed from: j */
    private float f200j;

    /* JADX INFO: renamed from: a */
    public float f201a;

    /* JADX INFO: renamed from: b */
    public float f202b;

    /* JADX INFO: renamed from: c */
    public float f203c;

    /* JADX INFO: renamed from: k */
    private boolean f204k = false;

    /* JADX INFO: renamed from: l */
    private int f205l = 0;

    public C0035b(int i, int i2) {
        this.f196f = i;
        this.f197g = i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m104a(float f, float f2, float f3, int i, int i2, int i3) {
        this.f194d = new C0038e[8];
        this.f195e = new C0037d[6];
        float f4 = f + i;
        float f5 = f2 + i2;
        float f6 = f3 + i3;
        C0038e c0038e = new C0038e(f, f2, f3, 0.0f, 0.0f);
        C0038e c0038e2 = new C0038e(f4, f2, f3, 0.0f, 8.0f);
        C0038e c0038e3 = new C0038e(f4, f5, f3, 8.0f, 8.0f);
        C0038e c0038e4 = new C0038e(f, f5, f3, 8.0f, 0.0f);
        C0038e c0038e5 = new C0038e(f, f2, f6, 0.0f, 0.0f);
        C0038e c0038e6 = new C0038e(f4, f2, f6, 0.0f, 8.0f);
        C0038e c0038e7 = new C0038e(f4, f5, f6, 8.0f, 8.0f);
        C0038e c0038e8 = new C0038e(f, f5, f6, 8.0f, 0.0f);
        this.f194d[0] = c0038e;
        this.f194d[1] = c0038e2;
        this.f194d[2] = c0038e3;
        this.f194d[3] = c0038e4;
        this.f194d[4] = c0038e5;
        this.f194d[5] = c0038e6;
        this.f194d[6] = c0038e7;
        this.f194d[7] = c0038e8;
        this.f195e[0] = new C0037d(new C0038e[]{c0038e6, c0038e2, c0038e3, c0038e7}, this.f196f + i3 + i, this.f197g + i3, this.f196f + i3 + i + i3, this.f197g + i3 + i2);
        this.f195e[1] = new C0037d(new C0038e[]{c0038e, c0038e5, c0038e8, c0038e4}, this.f196f, this.f197g + i3, this.f196f + i3, this.f197g + i3 + i2);
        this.f195e[2] = new C0037d(new C0038e[]{c0038e6, c0038e5, c0038e, c0038e2}, this.f196f + i3, this.f197g, this.f196f + i3 + i, this.f197g + i3);
        this.f195e[3] = new C0037d(new C0038e[]{c0038e3, c0038e4, c0038e8, c0038e7}, this.f196f + i3 + i, this.f197g, this.f196f + i3 + i + i, this.f197g + i3);
        this.f195e[4] = new C0037d(new C0038e[]{c0038e2, c0038e, c0038e4, c0038e3}, this.f196f + i3, this.f197g + i3, this.f196f + i3 + i, this.f197g + i3 + i2);
        this.f195e[5] = new C0037d(new C0038e[]{c0038e5, c0038e6, c0038e7, c0038e8}, this.f196f + i3 + i + i3, this.f197g + i3, this.f196f + i3 + i + i3 + i, this.f197g + i3 + i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m105a(float f, float f2, float f3) {
        this.f198h = f;
        this.f199i = f2;
        this.f200j = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m106a() {
        if (!this.f204k) {
            this.f205l = GL11.glGenLists(1);
            GL11.glNewList(this.f205l, 4864);
            GL11.glBegin(7);
            for (int i = 0; i < this.f195e.length; i++) {
                C0037d c0037d = this.f195e[i];
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
                for (int i2 = 3; i2 >= 0; i2--) {
                    C0038e c0038e = c0037d.f212a[i2];
                    GL11.glTexCoord2f(c0038e.f214b / 63.999f, c0038e.f215c / 31.999f);
                    GL11.glVertex3f(c0038e.f213a.f216a, c0038e.f213a.f217b, c0038e.f213a.f218c);
                }
            }
            GL11.glEnd();
            GL11.glEndList();
            this.f204k = true;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f198h, this.f199i, this.f200j);
        GL11.glRotatef(this.f203c * 57.29578f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this.f202b * 57.29578f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.f201a * 57.29578f, 1.0f, 0.0f, 0.0f);
        GL11.glCallList(this.f205l);
        GL11.glPopMatrix();
    }
}
