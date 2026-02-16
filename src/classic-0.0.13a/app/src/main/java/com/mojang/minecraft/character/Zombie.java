package com.mojang.minecraft.character;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.renderer.Textures;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/character/Zombie.class */
public class Zombie extends Entity {
    public float rot;
    public float timeOffs;
    public float speed;
    public float rotA;
    private static ZombieModel zombieModel = new ZombieModel();
    private Textures textures;

    public Zombie(Level level, Textures textures, float x, float y, float z) {
        super(level);
        this.textures = textures;
        this.rotA = ((float) (Math.random() + 1.0d)) * 0.01f;
        setPos(x, y, z);
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
        float xa = (float) Math.sin(this.rot);
        float ya = (float) Math.cos(this.rot);
        if (this.onGround && Math.random() < 0.08d) {
            this.f7yd = 0.5f;
        }
        moveRelative(xa, ya, this.onGround ? 0.1f : 0.02f);
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
    public void render(float a) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.textures.loadTexture("/char.png", 9728));
        GL11.glPushMatrix();
        double time = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.speed)) + ((double) this.timeOffs);
        float yy = (float) (((-Math.abs(Math.sin(time * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f0xo + ((this.f3x - this.f0xo) * a), this.f1yo + ((this.f4y - this.f1yo) * a), this.f2zo + ((this.f5z - this.f2zo) * a));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, yy, 0.0f);
        GL11.glRotatef((this.rot * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        zombieModel.render((float) time);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
