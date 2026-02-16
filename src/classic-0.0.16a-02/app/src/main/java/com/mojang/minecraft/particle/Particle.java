package com.mojang.minecraft.particle;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.p001a.C0005c;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/particle/Particle.class */
public class Particle extends Entity {

    /* JADX INFO: renamed from: xd */
    private float f285xd;

    /* JADX INFO: renamed from: yd */
    private float f286yd;

    /* JADX INFO: renamed from: zd */
    private float f287zd;
    public int tex;

    /* JADX INFO: renamed from: uo */
    private float f288uo;

    /* JADX INFO: renamed from: vo */
    private float f289vo;
    private int age;
    private int lifetime;
    private float size;
    private float gravity;

    public Particle(Level level, float f, float f2, float f3, float f4, float f5, float f6, C0030a c0030a) {
        super(level);
        this.age = 0;
        this.lifetime = 0;
        this.tex = c0030a.f218u;
        this.gravity = c0030a.f226w;
        setSize(0.2f, 0.2f);
        this.heightOffset = this.bbHeight / 2.0f;
        setPos(f, f2, f3);
        this.f285xd = f4 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f286yd = f5 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f287zd = f6 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        float fRandom = ((float) (Math.random() + Math.random() + 1.0d)) * 0.15f;
        float fSqrt = (float) Math.sqrt((this.f285xd * this.f285xd) + (this.f286yd * this.f286yd) + (this.f287zd * this.f287zd));
        this.f285xd = (this.f285xd / fSqrt) * fRandom * 0.4f;
        this.f286yd = ((this.f286yd / fSqrt) * fRandom * 0.4f) + 0.1f;
        this.f287zd = (this.f287zd / fSqrt) * fRandom * 0.4f;
        this.f288uo = ((float) Math.random()) * 3.0f;
        this.f289vo = ((float) Math.random()) * 3.0f;
        this.size = (float) ((Math.random() * 0.5d) + 0.5d);
        this.lifetime = (int) (4.0d / ((Math.random() * 0.9d) + 0.1d));
        this.age = 0;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        this.f8xo = this.f11x;
        this.f9yo = this.f12y;
        this.f10zo = this.f13z;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
        this.f286yd = (float) (((double) this.f286yd) - (0.04d * ((double) this.gravity)));
        move(this.f285xd, this.f286yd, this.f287zd);
        this.f285xd *= 0.98f;
        this.f286yd *= 0.98f;
        this.f287zd *= 0.98f;
        if (this.onGround) {
            this.f285xd *= 0.7f;
            this.f287zd *= 0.7f;
        }
    }

    public void render(C0005c c0005c, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((this.tex % 16) + (this.f288uo / 4.0f)) / 16.0f;
        float f8 = f7 + 0.015609375f;
        float f9 = ((this.tex / 16) + (this.f289vo / 4.0f)) / 16.0f;
        float f10 = f9 + 0.015609375f;
        float f11 = 0.1f * this.size;
        float f12 = this.f8xo + ((this.f11x - this.f8xo) * f);
        float f13 = this.f9yo + ((this.f12y - this.f9yo) * f);
        float f14 = this.f10zo + ((this.f13z - this.f10zo) * f);
        c0005c.m10a((f12 - (f2 * f11)) - (f5 * f11), f13 - (f3 * f11), (f14 - (f4 * f11)) - (f6 * f11), f7, f10);
        c0005c.m10a((f12 - (f2 * f11)) + (f5 * f11), f13 + (f3 * f11), (f14 - (f4 * f11)) + (f6 * f11), f7, f9);
        c0005c.m10a(f12 + (f2 * f11) + (f5 * f11), f13 + (f3 * f11), f14 + (f4 * f11) + (f6 * f11), f8, f9);
        c0005c.m10a((f12 + (f2 * f11)) - (f5 * f11), f13 - (f3 * f11), (f14 + (f4 * f11)) - (f6 * f11), f8, f10);
    }
}
