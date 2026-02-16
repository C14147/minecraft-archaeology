package com.mojang.rubydung.character;

import com.mojang.rubydung.Entity;
import com.mojang.rubydung.Textures;
import com.mojang.rubydung.level.Level;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: pre-Classic rd-132328.jar:com/mojang/rubydung/character/Zombie.class */
public class Zombie extends Entity {
    public Cube head;
    public Cube body;
    public Cube arm0;
    public Cube arm1;
    public Cube leg0;
    public Cube leg1;
    public float rot;
    public float timeOffs;
    public float speed;
    public float rotA;

    public Zombie(Level level, float x, float y, float z) {
        super(level);
        this.rotA = ((float) (Math.random() + 1.0d)) * 0.01f;
        this.x = x;
        this.y = y;
        this.z = z;
        this.timeOffs = ((float) Math.random()) * 1239813.0f;
        this.rot = (float) (Math.random() * 3.141592653589793d * 2.0d);
        this.speed = 1.0f;
        this.head = new Cube(0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.body = new Cube(16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.arm0 = new Cube(40, 16);
        this.arm0.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.arm0.setPos(-5.0f, 2.0f, 0.0f);
        this.arm1 = new Cube(40, 16);
        this.arm1.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.arm1.setPos(5.0f, 2.0f, 0.0f);
        this.leg0 = new Cube(0, 16);
        this.leg0.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg0.setPos(-2.0f, 12.0f, 0.0f);
        this.leg1 = new Cube(0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leg1.setPos(2.0f, 12.0f, 0.0f);
    }

    @Override // com.mojang.rubydung.Entity
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.rot += this.rotA;
        this.rotA = (float) (((double) this.rotA) * 0.99d);
        this.rotA = (float) (((double) this.rotA) + ((Math.random() - Math.random()) * Math.random() * Math.random() * 0.009999999776482582d));
        float xa = (float) Math.sin(this.rot);
        float ya = (float) Math.cos(this.rot);
        if (this.onGround && Math.random() < 0.01d) {
            this.yd = 0.12f;
        }
        moveRelative(xa, ya, this.onGround ? 0.02f : 0.005f);
        this.yd = (float) (((double) this.yd) - 0.005d);
        move(this.xd, this.yd, this.zd);
        this.xd *= 0.91f;
        this.yd *= 0.98f;
        this.zd *= 0.91f;
        if (this.y > 100.0f) {
            resetPos();
        }
        if (this.onGround) {
            this.xd *= 0.8f;
            this.zd *= 0.8f;
        }
    }

    public void render(float a) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, Textures.loadTexture("/char.png", 9728));
        GL11.glPushMatrix();
        double time = ((System.nanoTime() / 1.0E9d) * 10.0d * ((double) this.speed)) + ((double) this.timeOffs);
        float yy = (float) (((-Math.abs(Math.sin(time * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.xo + ((this.x - this.xo) * a), this.yo + ((this.y - this.yo) * a), this.zo + ((this.z - this.zo) * a));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.058333334f, 0.058333334f, 0.058333334f);
        GL11.glTranslatef(0.0f, yy, 0.0f);
        GL11.glRotatef((this.rot * 57.29578f) + 180.0f, 0.0f, 1.0f, 0.0f);
        this.head.yRot = ((float) Math.sin(time * 0.83d)) * 1.0f;
        this.head.xRot = ((float) Math.sin(time)) * 0.8f;
        this.arm0.xRot = ((float) Math.sin((time * 0.6662d) + 3.141592653589793d)) * 2.0f;
        this.arm0.zRot = ((float) (Math.sin(time * 0.2312d) + 1.0d)) * 1.0f;
        this.arm1.xRot = ((float) Math.sin(time * 0.6662d)) * 2.0f;
        this.arm1.zRot = ((float) (Math.sin(time * 0.2812d) - 1.0d)) * 1.0f;
        this.leg0.xRot = ((float) Math.sin(time * 0.6662d)) * 1.4f;
        this.leg1.xRot = ((float) Math.sin((time * 0.6662d) + 3.141592653589793d)) * 1.4f;
        this.head.render();
        this.body.render();
        this.arm0.render();
        this.arm1.render();
        this.leg0.render();
        this.leg1.render();
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }
}
