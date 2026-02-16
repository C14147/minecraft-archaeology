package com.mojang.minecraft.p007e;

import com.mojang.minecraft.C0042g;
import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p004b.C0019a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.e.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/e/a.class */
public final class C0034a extends C0042g {

    /* JADX INFO: renamed from: a */
    private float f188a;

    /* JADX INFO: renamed from: b */
    private float f189b;

    /* JADX INFO: renamed from: c */
    private float f190c;

    /* JADX INFO: renamed from: d */
    private float f191d;

    /* JADX INFO: renamed from: v */
    private static C0036c f192v = new C0036c();

    /* JADX INFO: renamed from: w */
    private C0019a f193w;

    public C0034a(C0017f c0017f, C0019a c0019a, float f, float f2, float f3) {
        super(c0017f);
        this.f193w = c0019a;
        this.f191d = ((float) (Math.random() + 1.0d)) * 0.01f;
        m114a(f, f2, f3);
        this.f189b = ((float) Math.random()) * 1239813.0f;
        this.f188a = (float) (Math.random() * 3.141592653589793d * 2.0d);
        this.f190c = 1.0f;
    }

    @Override // com.mojang.minecraft.C0042g
    /* JADX INFO: renamed from: a */
    public final void mo102a() {
        this.f231e = this.f234h;
        this.f232f = this.f235i;
        this.f233g = this.f236j;
        if (this.f235i < -100.0f) {
            this.f245s = true;
        }
        this.f188a += this.f191d;
        this.f191d = (float) (((double) this.f191d) * 0.99d);
        this.f191d = (float) (((double) this.f191d) + ((Math.random() - Math.random()) * Math.random() * Math.random() * 0.07999999821186066d));
        float fSin = (float) Math.sin(this.f188a);
        float fCos = (float) Math.cos(this.f188a);
        if (this.f243q && Math.random() < 0.08d) {
            this.f238l = 0.5f;
        }
        m119d(fSin, fCos, this.f243q ? 0.1f : 0.02f);
        this.f238l = (float) (((double) this.f238l) - 0.08d);
        m116c(this.f237k, this.f238l, this.f239m);
        this.f237k *= 0.91f;
        this.f238l *= 0.98f;
        this.f239m *= 0.91f;
        if (this.f243q) {
            this.f237k *= 0.7f;
            this.f239m *= 0.7f;
        }
    }

    @Override // com.mojang.minecraft.C0042g
    /* JADX INFO: renamed from: a */
    public final void mo103a(float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f193w.m55a("/char.png", 9728));
        GL11.glPushMatrix();
        double dNanoTime = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.f190c)) + ((double) this.f189b);
        float f2 = (float) (((-Math.abs(Math.sin(dNanoTime * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f231e + ((this.f234h - this.f231e) * f), this.f232f + ((this.f235i - this.f232f) * f), this.f233g + ((this.f236j - this.f233g) * f));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, f2, 0.0f);
        GL11.glRotatef((this.f188a * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        C0036c c0036c = f192v;
        float f3 = (float) dNanoTime;
        c0036c.f206a.f202b = (float) Math.sin(((double) f3) * 0.83d);
        c0036c.f206a.f201a = ((float) Math.sin(f3)) * 0.8f;
        c0036c.f208c.f201a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 2.0f;
        c0036c.f208c.f203c = (float) (Math.sin(((double) f3) * 0.2312d) + 1.0d);
        c0036c.f209d.f201a = ((float) Math.sin(((double) f3) * 0.6662d)) * 2.0f;
        c0036c.f209d.f203c = (float) (Math.sin(((double) f3) * 0.2812d) - 1.0d);
        c0036c.f210e.f201a = ((float) Math.sin(((double) f3) * 0.6662d)) * 1.4f;
        c0036c.f211f.f201a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 1.4f;
        c0036c.f206a.m106a();
        c0036c.f207b.m106a();
        c0036c.f208c.m106a();
        c0036c.f209d.m106a();
        c0036c.f210e.m106a();
        c0036c.f211f.m106a();
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
