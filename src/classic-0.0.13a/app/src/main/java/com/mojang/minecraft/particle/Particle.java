package com.mojang.minecraft.particle;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.renderer.Tesselator;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/particle/Particle.class */
public class Particle extends Entity {

    /* JADX INFO: renamed from: xd */
    private float f48xd;

    /* JADX INFO: renamed from: yd */
    private float f49yd;

    /* JADX INFO: renamed from: zd */
    private float f50zd;
    public int tex;

    /* JADX INFO: renamed from: uo */
    private float f51uo;

    /* JADX INFO: renamed from: vo */
    private float f52vo;
    private int age;
    private int lifetime;
    private float size;

    public Particle(Level level, float x, float y, float z, float xa, float ya, float za, int tex) {
        super(level);
        this.age = 0;
        this.lifetime = 0;
        this.tex = tex;
        setSize(0.2f, 0.2f);
        this.heightOffset = this.bbHeight / 2.0f;
        setPos(x, y, z);
        this.f48xd = xa + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f49yd = ya + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        this.f50zd = za + (((float) ((Math.random() * 2.0d) - 1.0d)) * 0.4f);
        float speed = ((float) (Math.random() + Math.random() + 1.0d)) * 0.15f;
        float dd = (float) Math.sqrt((this.f48xd * this.f48xd) + (this.f49yd * this.f49yd) + (this.f50zd * this.f50zd));
        this.f48xd = (this.f48xd / dd) * speed * 0.4f;
        this.f49yd = ((this.f49yd / dd) * speed * 0.4f) + 0.1f;
        this.f50zd = (this.f50zd / dd) * speed * 0.4f;
        this.f51uo = ((float) Math.random()) * 3.0f;
        this.f52vo = ((float) Math.random()) * 3.0f;
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
        this.f49yd = (float) (((double) this.f49yd) - 0.04d);
        move(this.f48xd, this.f49yd, this.f50zd);
        this.f48xd *= 0.98f;
        this.f49yd *= 0.98f;
        this.f50zd *= 0.98f;
        if (this.onGround) {
            this.f48xd *= 0.7f;
            this.f50zd *= 0.7f;
        }
    }

    public void render(Tesselator t, float a, float xa, float ya, float za, float xa2, float za2) {
        float u0 = ((this.tex % 16) + (this.f51uo / 4.0f)) / 16.0f;
        float u1 = u0 + 0.015609375f;
        float v0 = ((this.tex / 16) + (this.f52vo / 4.0f)) / 16.0f;
        float v1 = v0 + 0.015609375f;
        float r = 0.1f * this.size;
        float x = this.f0xo + ((this.f3x - this.f0xo) * a);
        float y = this.f1yo + ((this.f4y - this.f1yo) * a);
        float z = this.f2zo + ((this.f5z - this.f2zo) * a);
        t.vertexUV((x - (xa * r)) - (xa2 * r), y - (ya * r), (z - (za * r)) - (za2 * r), u0, v1);
        t.vertexUV((x - (xa * r)) + (xa2 * r), y + (ya * r), (z - (za * r)) + (za2 * r), u0, v0);
        t.vertexUV(x + (xa * r) + (xa2 * r), y + (ya * r), z + (za * r) + (za2 * r), u1, v0);
        t.vertexUV((x + (xa * r)) - (xa2 * r), y - (ya * r), (z + (za * r)) - (za2 * r), u1, v1);
    }
}
