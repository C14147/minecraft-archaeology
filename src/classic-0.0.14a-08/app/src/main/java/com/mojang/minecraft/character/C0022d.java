package com.mojang.minecraft.character;

import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.character.d */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/character/d.class */
public final class C0022d {

    /* JADX INFO: renamed from: d */
    private C0023e[] f152d;

    /* JADX INFO: renamed from: e */
    private C0020b[] f153e;

    /* JADX INFO: renamed from: f */
    private int f154f;

    /* JADX INFO: renamed from: g */
    private int f155g;

    /* JADX INFO: renamed from: h */
    private float f156h;

    /* JADX INFO: renamed from: i */
    private float f157i;

    /* JADX INFO: renamed from: j */
    private float f158j;

    /* JADX INFO: renamed from: a */
    public float f159a;

    /* JADX INFO: renamed from: b */
    public float f160b;

    /* JADX INFO: renamed from: c */
    public float f161c;

    /* JADX INFO: renamed from: k */
    private boolean f162k = false;

    /* JADX INFO: renamed from: l */
    private int f163l = 0;

    public C0022d(int i, int i2) {
        this.f154f = i;
        this.f155g = i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m65a(float f, float f2, float f3, int i, int i2, int i3) {
        this.f152d = new C0023e[8];
        this.f153e = new C0020b[6];
        float f4 = f + i;
        float f5 = f2 + i2;
        float f6 = f3 + i3;
        C0023e c0023e = new C0023e(f, f2, f3, 0.0f, 0.0f);
        C0023e c0023e2 = new C0023e(f4, f2, f3, 0.0f, 8.0f);
        C0023e c0023e3 = new C0023e(f4, f5, f3, 8.0f, 8.0f);
        C0023e c0023e4 = new C0023e(f, f5, f3, 8.0f, 0.0f);
        C0023e c0023e5 = new C0023e(f, f2, f6, 0.0f, 0.0f);
        C0023e c0023e6 = new C0023e(f4, f2, f6, 0.0f, 8.0f);
        C0023e c0023e7 = new C0023e(f4, f5, f6, 8.0f, 8.0f);
        C0023e c0023e8 = new C0023e(f, f5, f6, 8.0f, 0.0f);
        this.f152d[0] = c0023e;
        this.f152d[1] = c0023e2;
        this.f152d[2] = c0023e3;
        this.f152d[3] = c0023e4;
        this.f152d[4] = c0023e5;
        this.f152d[5] = c0023e6;
        this.f152d[6] = c0023e7;
        this.f152d[7] = c0023e8;
        this.f153e[0] = new C0020b(new C0023e[]{c0023e6, c0023e2, c0023e3, c0023e7}, this.f154f + i3 + i, this.f155g + i3, this.f154f + i3 + i + i3, this.f155g + i3 + i2);
        this.f153e[1] = new C0020b(new C0023e[]{c0023e, c0023e5, c0023e8, c0023e4}, this.f154f, this.f155g + i3, this.f154f + i3, this.f155g + i3 + i2);
        this.f153e[2] = new C0020b(new C0023e[]{c0023e6, c0023e5, c0023e, c0023e2}, this.f154f + i3, this.f155g, this.f154f + i3 + i, this.f155g + i3);
        this.f153e[3] = new C0020b(new C0023e[]{c0023e3, c0023e4, c0023e8, c0023e7}, this.f154f + i3 + i, this.f155g, this.f154f + i3 + i + i, this.f155g + i3);
        this.f153e[4] = new C0020b(new C0023e[]{c0023e2, c0023e, c0023e4, c0023e3}, this.f154f + i3, this.f155g + i3, this.f154f + i3 + i, this.f155g + i3 + i2);
        this.f153e[5] = new C0020b(new C0023e[]{c0023e5, c0023e6, c0023e7, c0023e8}, this.f154f + i3 + i + i3, this.f155g + i3, this.f154f + i3 + i + i3 + i, this.f155g + i3 + i2);
    }

    /* JADX INFO: renamed from: a */
    public final void m66a(float f, float f2, float f3) {
        this.f156h = f;
        this.f157i = f2;
        this.f158j = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public final void m67a() {
        if (!this.f162k) {
            this.f163l = GL11.glGenLists(1);
            GL11.glNewList(this.f163l, 4864);
            GL11.glBegin(7);
            for (int i = 0; i < this.f153e.length; i++) {
                C0020b c0020b = this.f153e[i];
                for (int i2 = 3; i2 >= 0; i2--) {
                    C0023e c0023e = c0020b.f148a[i2];
                    GL11.glTexCoord2f(c0023e.f165b / 63.999f, c0023e.f166c / 31.999f);
                    GL11.glVertex3f(c0023e.f164a.f149a, c0023e.f164a.f150b, c0023e.f164a.f151c);
                }
            }
            GL11.glEnd();
            GL11.glEndList();
            this.f162k = true;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f156h, this.f157i, this.f158j);
        GL11.glRotatef(this.f161c * 57.29578f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this.f160b * 57.29578f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.f159a * 57.29578f, 1.0f, 0.0f, 0.0f);
        GL11.glCallList(this.f163l);
        GL11.glPopMatrix();
    }
}
