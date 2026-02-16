package com.mojang.minecraft.character;

import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.character.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/character/d.class */
public final class C0025d {

    /* JADX INFO: renamed from: d */
    private C0026e[] f121d;

    /* JADX INFO: renamed from: e */
    private C0023b[] f122e;

    /* JADX INFO: renamed from: f */
    private int f123f;

    /* JADX INFO: renamed from: g */
    private int f124g;

    /* JADX INFO: renamed from: h */
    private float f125h;

    /* JADX INFO: renamed from: i */
    private float f126i;

    /* JADX INFO: renamed from: j */
    private float f127j;

    /* JADX INFO: renamed from: a */
    public float f128a;

    /* JADX INFO: renamed from: b */
    public float f129b;

    /* JADX INFO: renamed from: c */
    public float f130c;

    /* JADX INFO: renamed from: k */
    private boolean f131k = false;

    /* JADX INFO: renamed from: l */
    private int f132l = 0;

    public C0025d(int i, int i2) {
        this.f123f = i;
        this.f124g = i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m52a(float f, float f2, float f3, int i, int i2, int i3) {
        this.f121d = new C0026e[8];
        this.f122e = new C0023b[6];
        float f4 = f + i;
        float f5 = f2 + i2;
        float f6 = f3 + i3;
        C0026e c0026e = new C0026e(f, f2, f3, 0.0f, 0.0f);
        C0026e c0026e2 = new C0026e(f4, f2, f3, 0.0f, 8.0f);
        C0026e c0026e3 = new C0026e(f4, f5, f3, 8.0f, 8.0f);
        C0026e c0026e4 = new C0026e(f, f5, f3, 8.0f, 0.0f);
        C0026e c0026e5 = new C0026e(f, f2, f6, 0.0f, 0.0f);
        C0026e c0026e6 = new C0026e(f4, f2, f6, 0.0f, 8.0f);
        C0026e c0026e7 = new C0026e(f4, f5, f6, 8.0f, 8.0f);
        C0026e c0026e8 = new C0026e(f, f5, f6, 8.0f, 0.0f);
        this.f121d[0] = c0026e;
        this.f121d[1] = c0026e2;
        this.f121d[2] = c0026e3;
        this.f121d[3] = c0026e4;
        this.f121d[4] = c0026e5;
        this.f121d[5] = c0026e6;
        this.f121d[6] = c0026e7;
        this.f121d[7] = c0026e8;
        this.f122e[0] = new C0023b(new C0026e[]{c0026e6, c0026e2, c0026e3, c0026e7}, this.f123f + i3 + i, this.f124g + i3, this.f123f + i3 + i + i3, this.f124g + i3 + i2);
        this.f122e[1] = new C0023b(new C0026e[]{c0026e, c0026e5, c0026e8, c0026e4}, this.f123f, this.f124g + i3, this.f123f + i3, this.f124g + i3 + i2);
        this.f122e[2] = new C0023b(new C0026e[]{c0026e6, c0026e5, c0026e, c0026e2}, this.f123f + i3, this.f124g, this.f123f + i3 + i, this.f124g + i3);
        this.f122e[3] = new C0023b(new C0026e[]{c0026e3, c0026e4, c0026e8, c0026e7}, this.f123f + i3 + i, this.f124g, this.f123f + i3 + i + i, this.f124g + i3);
        this.f122e[4] = new C0023b(new C0026e[]{c0026e2, c0026e, c0026e4, c0026e3}, this.f123f + i3, this.f124g + i3, this.f123f + i3 + i, this.f124g + i3 + i2);
        this.f122e[5] = new C0023b(new C0026e[]{c0026e5, c0026e6, c0026e7, c0026e8}, this.f123f + i3 + i + i3, this.f124g + i3, this.f123f + i3 + i + i3 + i, this.f124g + i3 + i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m53a(float f, float f2, float f3) {
        this.f125h = f;
        this.f126i = f2;
        this.f127j = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m54a() {
        if (!this.f131k) {
            this.f132l = GL11.glGenLists(1);
            GL11.glNewList(this.f132l, 4864);
            GL11.glBegin(7);
            for (int i = 0; i < this.f122e.length; i++) {
                C0023b c0023b = this.f122e[i];
                for (int i2 = 3; i2 >= 0; i2--) {
                    C0026e c0026e = c0023b.f117a[i2];
                    GL11.glTexCoord2f(c0026e.f134b / 64.0f, c0026e.f135c / 32.0f);
                    GL11.glVertex3f(c0026e.f133a.f118a, c0026e.f133a.f119b, c0026e.f133a.f120c);
                }
            }
            GL11.glEnd();
            GL11.glEndList();
            this.f131k = true;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f125h, this.f126i, this.f127j);
        GL11.glRotatef(this.f130c * 57.29578f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this.f129b * 57.29578f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.f128a * 57.29578f, 1.0f, 0.0f, 0.0f);
        GL11.glCallList(this.f132l);
        GL11.glPopMatrix();
    }
}
