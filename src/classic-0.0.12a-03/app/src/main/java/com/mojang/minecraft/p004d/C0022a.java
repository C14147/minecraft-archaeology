package com.mojang.minecraft.p004d;

import com.mojang.minecraft.C0030f;
import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p002b.C0015a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.d.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/d/a.class */
public final class C0022a extends C0030f {

    /* JADX INFO: renamed from: a */
    private float f144a;

    /* JADX INFO: renamed from: b */
    private float f145b;

    /* JADX INFO: renamed from: c */
    private float f146c;

    /* JADX INFO: renamed from: d */
    private float f147d;

    /* JADX INFO: renamed from: u */
    private static C0024c f148u = new C0024c();

    /* JADX INFO: renamed from: v */
    private C0015a f149v;

    public C0022a(C0013g c0013g, C0015a c0015a, float f, float f2, float f3) {
        super(c0013g);
        this.f149v = c0015a;
        this.f147d = ((float) (Math.random() + 1.0d)) * 0.01f;
        m81a(f, f2, f3);
        this.f145b = ((float) Math.random()) * 1239813.0f;
        this.f144a = (float) (Math.random() * 3.141592653589793d * 2.0d);
        this.f146c = 1.0f;
    }

    @Override // com.mojang.minecraft.C0030f
    /* JADX INFO: renamed from: a */
    public final void mo69a() {
        this.f182e = this.f185h;
        this.f183f = this.f186i;
        this.f184g = this.f187j;
        if (this.f186i < -100.0f) {
            this.f195r = true;
        }
        this.f144a += this.f147d;
        this.f147d = (float) (((double) this.f147d) * 0.99d);
        this.f147d = (float) (((double) this.f147d) + ((Math.random() - Math.random()) * Math.random() * Math.random() * 0.07999999821186066d));
        float fSin = (float) Math.sin(this.f144a);
        float fCos = (float) Math.cos(this.f144a);
        if (this.f194q && Math.random() < 0.08d) {
            this.f189l = 0.5f;
        }
        m85c(fSin, fCos, this.f194q ? 0.1f : 0.02f);
        this.f189l = (float) (((double) this.f189l) - 0.08d);
        m82b(this.f188k, this.f189l, this.f190m);
        this.f188k *= 0.91f;
        this.f189l *= 0.98f;
        this.f190m *= 0.91f;
        if (this.f194q) {
            this.f188k *= 0.7f;
            this.f190m *= 0.7f;
        }
    }

    @Override // com.mojang.minecraft.C0030f
    /* JADX INFO: renamed from: a */
    public final void mo70a(float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f149v.m45a("/char.png", 9728));
        GL11.glPushMatrix();
        double dNanoTime = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.f146c)) + ((double) this.f145b);
        float f2 = (float) (((-Math.abs(Math.sin(dNanoTime * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f182e + ((this.f185h - this.f182e) * f), this.f183f + ((this.f186i - this.f183f) * f), this.f184g + ((this.f187j - this.f184g) * f));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, f2, 0.0f);
        GL11.glRotatef((this.f144a * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        C0024c c0024c = f148u;
        float f3 = (float) dNanoTime;
        c0024c.f162a.f158b = (float) Math.sin(((double) f3) * 0.83d);
        c0024c.f162a.f157a = ((float) Math.sin(f3)) * 0.8f;
        c0024c.f164c.f157a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 2.0f;
        c0024c.f164c.f159c = (float) (Math.sin(((double) f3) * 0.2312d) + 1.0d);
        c0024c.f165d.f157a = ((float) Math.sin(((double) f3) * 0.6662d)) * 2.0f;
        c0024c.f165d.f159c = (float) (Math.sin(((double) f3) * 0.2812d) - 1.0d);
        c0024c.f166e.f157a = ((float) Math.sin(((double) f3) * 0.6662d)) * 1.4f;
        c0024c.f167f.f157a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 1.4f;
        c0024c.f162a.m73a();
        c0024c.f163b.m73a();
        c0024c.f164c.m73a();
        c0024c.f165d.m73a();
        c0024c.f166e.m73a();
        c0024c.f167f.m73a();
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
