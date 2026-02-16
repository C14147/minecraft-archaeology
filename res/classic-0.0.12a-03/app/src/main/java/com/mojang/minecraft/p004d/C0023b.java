package com.mojang.minecraft.p004d;

import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.d.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/d/b.class */
public final class C0023b {

    /* JADX INFO: renamed from: d */
    private C0026e[] f150d;

    /* JADX INFO: renamed from: e */
    private C0025d[] f151e;

    /* JADX INFO: renamed from: f */
    private int f152f;

    /* JADX INFO: renamed from: g */
    private int f153g;

    /* JADX INFO: renamed from: h */
    private float f154h;

    /* JADX INFO: renamed from: i */
    private float f155i;

    /* JADX INFO: renamed from: j */
    private float f156j;

    /* JADX INFO: renamed from: a */
    public float f157a;

    /* JADX INFO: renamed from: b */
    public float f158b;

    /* JADX INFO: renamed from: c */
    public float f159c;

    /* JADX INFO: renamed from: k */
    private boolean f160k = false;

    /* JADX INFO: renamed from: l */
    private int f161l = 0;

    public C0023b(int i, int i2) {
        this.f152f = i;
        this.f153g = i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m71a(float f, float f2, float f3, int i, int i2, int i3) {
        this.f150d = new C0026e[8];
        this.f151e = new C0025d[6];
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
        this.f150d[0] = c0026e;
        this.f150d[1] = c0026e2;
        this.f150d[2] = c0026e3;
        this.f150d[3] = c0026e4;
        this.f150d[4] = c0026e5;
        this.f150d[5] = c0026e6;
        this.f150d[6] = c0026e7;
        this.f150d[7] = c0026e8;
        this.f151e[0] = new C0025d(new C0026e[]{c0026e6, c0026e2, c0026e3, c0026e7}, this.f152f + i3 + i, this.f153g + i3, this.f152f + i3 + i + i3, this.f153g + i3 + i2);
        this.f151e[1] = new C0025d(new C0026e[]{c0026e, c0026e5, c0026e8, c0026e4}, this.f152f, this.f153g + i3, this.f152f + i3, this.f153g + i3 + i2);
        this.f151e[2] = new C0025d(new C0026e[]{c0026e6, c0026e5, c0026e, c0026e2}, this.f152f + i3, this.f153g, this.f152f + i3 + i, this.f153g + i3);
        this.f151e[3] = new C0025d(new C0026e[]{c0026e3, c0026e4, c0026e8, c0026e7}, this.f152f + i3 + i, this.f153g, this.f152f + i3 + i + i, this.f153g + i3);
        this.f151e[4] = new C0025d(new C0026e[]{c0026e2, c0026e, c0026e4, c0026e3}, this.f152f + i3, this.f153g + i3, this.f152f + i3 + i, this.f153g + i3 + i2);
        this.f151e[5] = new C0025d(new C0026e[]{c0026e5, c0026e6, c0026e7, c0026e8}, this.f152f + i3 + i + i3, this.f153g + i3, this.f152f + i3 + i + i3 + i, this.f153g + i3 + i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m72a(float f, float f2, float f3) {
        this.f154h = f;
        this.f155i = f2;
        this.f156j = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m73a() {
        if (!this.f160k) {
            this.f161l = GL11.glGenLists(1);
            GL11.glNewList(this.f161l, 4864);
            GL11.glBegin(7);
            for (int i = 0; i < this.f151e.length; i++) {
                C0025d c0025d = this.f151e[i];
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
                for (int i2 = 3; i2 >= 0; i2--) {
                    C0026e c0026e = c0025d.f168a[i2];
                    GL11.glTexCoord2f(c0026e.f170b / 63.999f, c0026e.f171c / 31.999f);
                    GL11.glVertex3f(c0026e.f169a.f172a, c0026e.f169a.f173b, c0026e.f169a.f174c);
                }
            }
            GL11.glEnd();
            GL11.glEndList();
            this.f160k = true;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f154h, this.f155i, this.f156j);
        GL11.glRotatef(this.f159c * 57.29578f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this.f158b * 57.29578f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.f157a * 57.29578f, 1.0f, 0.0f, 0.0f);
        GL11.glCallList(this.f161l);
        GL11.glPopMatrix();
    }
}
