package com.mojang.minecraft.particle;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0004c;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/particle/Particle.class */
public class Particle extends Entity {

    /* JADX INFO: renamed from: xd */
    private float f224xd;

    /* JADX INFO: renamed from: yd */
    private float f225yd;

    /* JADX INFO: renamed from: zd */
    private float f226zd;
    public int tex;

    /* JADX INFO: renamed from: uo */
    private float f227uo;

    /* JADX INFO: renamed from: vo */
    private float f228vo;
    private int age;
    private int lifetime;
    private float size;

    public Particle(Level level, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        super(level);
        this.age = 0;
        this.lifetime = 0;
        this.tex = i;
        setSize(0.2f, 0.2f);
        this.heightOffset = this.bbHeight / 2.0f;
        setPos(f, f2, f3);
        this.f224xd = f4 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f225yd = f5 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f226zd = f6 + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        float fRandom = ((float) (Math.random() + Math.random() + 1.0d)) * 0.15f;
        float fSqrt = (float) Math.sqrt((this.f224xd * this.f224xd) + (this.f225yd * this.f225yd) + (this.f226zd * this.f226zd));
        this.f224xd = (this.f224xd / fSqrt) * fRandom * 0.4f;
        this.f225yd = ((this.f225yd / fSqrt) * fRandom * 0.4f) + 0.1f;
        this.f226zd = (this.f226zd / fSqrt) * fRandom * 0.4f;
        this.f227uo = ((float) Math.random()) * 3.0f;
        this.f228vo = ((float) Math.random()) * 3.0f;
        this.size = (float) ((Math.random() * 0.5d) + 0.5d);
        this.lifetime = (int) (4.0d / ((Math.random() * 0.9d) + 0.1d));
        this.age = 0;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        this.f0xo = this.f3x;
        this.f1yo = this.f4y;
        this.f2zo = this.f5z;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
        this.f225yd = (float) (((double) this.f225yd) - 0.04d);
        move(this.f224xd, this.f225yd, this.f226zd);
        this.f224xd *= 0.98f;
        this.f225yd *= 0.98f;
        this.f226zd *= 0.98f;
        if (this.onGround) {
            this.f224xd *= 0.7f;
            this.f226zd *= 0.7f;
        }
    }

    public void render(C0004c c0004c, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((this.tex % 16) + (this.f227uo / 4.0f)) / 16.0f;
        float f8 = f7 + 0.015609375f;
        float f9 = ((this.tex / 16) + (this.f228vo / 4.0f)) / 16.0f;
        float f10 = f9 + 0.015609375f;
        float f11 = 0.1f * this.size;
        float f12 = this.f0xo + ((this.f3x - this.f0xo) * f);
        float f13 = this.f1yo + ((this.f4y - this.f1yo) * f);
        float f14 = this.f2zo + ((this.f5z - this.f2zo) * f);
        c0004c.m6a((f12 - (f2 * f11)) - (f5 * f11), f13 - (f3 * f11), (f14 - (f4 * f11)) - (f6 * f11), f7, f10);
        c0004c.m6a((f12 - (f2 * f11)) + (f5 * f11), f13 + (f3 * f11), (f14 - (f4 * f11)) + (f6 * f11), f7, f9);
        c0004c.m6a(f12 + (f2 * f11) + (f5 * f11), f13 + (f3 * f11), f14 + (f4 * f11) + (f6 * f11), f8, f9);
        c0004c.m6a((f12 + (f2 * f11)) - (f5 * f11), f13 - (f3 * f11), (f14 + (f4 * f11)) - (f6 * f11), f8, f10);
    }
}
