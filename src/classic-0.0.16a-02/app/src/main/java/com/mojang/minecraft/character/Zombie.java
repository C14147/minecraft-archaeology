package com.mojang.minecraft.character;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p001a.C0003a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/character/Zombie.class */
public class Zombie extends Entity {
    public static final long serialVersionUID = 77479605454997290L;

    /* JADX INFO: renamed from: a */
    private static C0022a f110a = new C0022a();
    public float rot;
    public float timeOffs;
    public float speed;
    public float rotA;

    public Zombie(Level level, float f, float f2, float f3) {
        super(level);
        this.rotA = ((float) (Math.random() + 1.0d)) * 0.01f;
        setPos(f, f2, f3);
        this.timeOffs = ((float) Math.random()) * 1239813.0f;
        this.rot = (float) (Math.random() * 3.141592653589793d * 2.0d);
        this.speed = 1.0f;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        this.f8xo = this.f11x;
        this.f9yo = this.f12y;
        this.f10zo = this.f13z;
        if (this.f12y < -100.0f) {
            remove();
        }
        this.rot += this.rotA;
        this.rotA = (float) (((double) this.rotA) * 0.99d);
        this.rotA = (float) (((double) this.rotA) + ((Math.random() - Math.random()) * Math.random() * Math.random() * 0.07999999821186066d));
        float fSin = (float) Math.sin(this.rot);
        float fCos = (float) Math.cos(this.rot);
        if (this.onGround && Math.random() < 0.08d) {
            this.f15yd = 0.5f;
        }
        moveRelative(fSin, fCos, this.onGround ? 0.1f : 0.02f);
        this.f15yd = (float) (((double) this.f15yd) - 0.08d);
        move(this.f14xd, this.f15yd, this.f16zd);
        this.f14xd *= 0.91f;
        this.f15yd *= 0.98f;
        this.f16zd *= 0.91f;
        if (this.onGround) {
            this.f14xd *= 0.7f;
            this.f16zd *= 0.7f;
        }
    }

    @Override // com.mojang.minecraft.Entity
    public void render(C0003a c0003a, float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, c0003a.m4a("/char.png", 9728));
        GL11.glPushMatrix();
        double dNanoTime = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.speed)) + ((double) this.timeOffs);
        float brightness = getBrightness();
        GL11.glColor3f(brightness, brightness, brightness);
        float f2 = (float) (((-Math.abs(Math.sin(dNanoTime * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f8xo + ((this.f11x - this.f8xo) * f), this.f9yo + ((this.f12y - this.f9yo) * f), this.f10zo + ((this.f13z - this.f10zo) * f));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, f2, 0.0f);
        GL11.glRotatef((this.rot * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        f110a.m51a((float) dNanoTime, 0.0f, 0.0f);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
