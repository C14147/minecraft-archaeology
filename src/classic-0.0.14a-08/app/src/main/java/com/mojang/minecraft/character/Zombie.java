package com.mojang.minecraft.character;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0002a;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/character/Zombie.class */
public class Zombie extends Entity {
    public static final long serialVersionUID = 77479605454997290L;

    /* JADX INFO: renamed from: a */
    private static C0019a f141a = new C0019a();
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
        this.f0xo = this.f3x;
        this.f1yo = this.f4y;
        this.f2zo = this.f5z;
        if (this.f4y < -100.0f) {
            remove();
        }
        this.rot += this.rotA;
        this.rotA = (float) (((double) this.rotA) * 0.99d);
        this.rotA = (float) (((double) this.rotA) + ((Math.random() - Math.random()) * Math.random() * Math.random() * 0.07999999821186066d));
        float fSin = (float) Math.sin(this.rot);
        float fCos = (float) Math.cos(this.rot);
        if (this.onGround && Math.random() < 0.08d) {
            this.f7yd = 0.5f;
        }
        moveRelative(fSin, fCos, this.onGround ? 0.1f : 0.02f);
        this.f7yd = (float) (((double) this.f7yd) - 0.08d);
        move(this.f6xd, this.f7yd, this.f8zd);
        this.f6xd *= 0.91f;
        this.f7yd *= 0.98f;
        this.f8zd *= 0.91f;
        if (this.onGround) {
            this.f6xd *= 0.7f;
            this.f8zd *= 0.7f;
        }
    }

    @Override // com.mojang.minecraft.Entity
    public void render(C0002a c0002a, float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, c0002a.m0a("/char.png", 9728));
        GL11.glPushMatrix();
        double dNanoTime = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.speed)) + ((double) this.timeOffs);
        float brightness = getBrightness();
        GL11.glColor3f(brightness, brightness, brightness);
        float f2 = (float) (((-Math.abs(Math.sin(dNanoTime * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f0xo + ((this.f3x - this.f0xo) * f), this.f1yo + ((this.f4y - this.f1yo) * f), this.f2zo + ((this.f5z - this.f2zo) * f));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, f2, 0.0f);
        GL11.glRotatef((this.rot * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        C0019a c0019a = f141a;
        float f3 = (float) dNanoTime;
        c0019a.f142a.f160b = (float) Math.sin(((double) f3) * 0.83d);
        c0019a.f142a.f159a = ((float) Math.sin(f3)) * 0.8f;
        c0019a.f144c.f159a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 2.0f;
        c0019a.f144c.f161c = (float) (Math.sin(((double) f3) * 0.2312d) + 1.0d);
        c0019a.f145d.f159a = ((float) Math.sin(((double) f3) * 0.6662d)) * 2.0f;
        c0019a.f145d.f161c = (float) (Math.sin(((double) f3) * 0.2812d) - 1.0d);
        c0019a.f146e.f159a = ((float) Math.sin(((double) f3) * 0.6662d)) * 1.4f;
        c0019a.f147f.f159a = ((float) Math.sin((((double) f3) * 0.6662d) + 3.141592653589793d)) * 1.4f;
        c0019a.f142a.m67a();
        c0019a.f143b.m67a();
        c0019a.f144c.m67a();
        c0019a.f145d.m67a();
        c0019a.f146e.m67a();
        c0019a.f147f.m67a();
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
