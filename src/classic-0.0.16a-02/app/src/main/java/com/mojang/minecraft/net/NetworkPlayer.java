package com.mojang.minecraft.net;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.RunnableC0027d;
import com.mojang.minecraft.character.C0022a;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.p002b.C0020j;
import java.util.LinkedList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/net/NetworkPlayer.class */
public class NetworkPlayer extends Entity {
    public static final long serialVersionUID = 77479605454997290L;

    /* JADX INFO: renamed from: a */
    private static C0022a f251a = new C0022a();
    private float animStep;
    private float animStepO;
    private List moveQueue;
    private RunnableC0027d minecraft;

    /* JADX INFO: renamed from: xp */
    private int f252xp;

    /* JADX INFO: renamed from: yp */
    private int f253yp;

    /* JADX INFO: renamed from: zp */
    private int f254zp;
    private float yBodyRot;
    private float yBodyRotO;
    String name;

    public NetworkPlayer(RunnableC0027d runnableC0027d, int i, String str, int i2, int i3, int i4, float f, float f2) {
        super(runnableC0027d.f142c);
        this.moveQueue = new LinkedList();
        this.yBodyRot = 0.0f;
        this.yBodyRotO = 0.0f;
        this.minecraft = runnableC0027d;
        this.name = str;
        this.f252xp = i2;
        this.f253yp = i3;
        this.f254zp = i4;
        setPos(i2 / 32.0f, i3 / 32.0f, i4 / 32.0f);
        this.xRot = f2;
        this.yRot = f;
        this.heightOffset = 1.62f;
    }

    @Override // com.mojang.minecraft.Entity
    public void tick() {
        float f;
        float f2;
        super.tick();
        this.animStepO = this.animStep;
        int i = 5;
        do {
            if (this.moveQueue.size() > 0) {
                setPos((C0047b) this.moveQueue.remove(0));
            }
            int i2 = i;
            i--;
            if (i2 <= 0) {
                break;
            }
        } while (this.moveQueue.size() > 10);
        float f3 = this.f11x - this.f8xo;
        float f4 = this.f13z - this.f10zo;
        this.yBodyRotO = this.yBodyRot;
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
        float f5 = this.yBodyRot;
        float f6 = 0.0f;
        if (fSqrt == 0.0f) {
            this.animStep = 0.0f;
        } else {
            f6 = fSqrt * 3.0f;
            f5 = -(((((float) Math.atan2(f4, f3)) * 180.0f) / 3.1415927f) + 90.0f);
        }
        float f7 = f5 - this.yBodyRot;
        while (true) {
            f = f7;
            if (f >= -180.0f) {
                break;
            } else {
                f7 = f + 360.0f;
            }
        }
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        this.yBodyRot += f * 0.1f;
        float f8 = this.yRot - this.yBodyRot;
        while (true) {
            f2 = f8;
            if (f2 >= -180.0f) {
                break;
            } else {
                f8 = f2 + 360.0f;
            }
        }
        while (f2 >= 180.0f) {
            f2 -= 360.0f;
        }
        boolean z = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.yBodyRot = this.yRot - f2;
        if (z) {
            f6 = -f6;
        }
        while (this.yRot - this.yRotO < -180.0f) {
            this.yRotO -= 360.0f;
        }
        while (this.yRot - this.yRotO >= 180.0f) {
            this.yRotO += 360.0f;
        }
        while (this.yBodyRot - this.yBodyRotO < -180.0f) {
            this.yBodyRotO -= 360.0f;
        }
        while (this.yBodyRot - this.yBodyRotO >= 180.0f) {
            this.yBodyRotO += 360.0f;
        }
        while (this.xRot - this.xRotO < -180.0f) {
            this.xRotO -= 360.0f;
        }
        while (this.xRot - this.xRotO >= 180.0f) {
            this.xRotO += 360.0f;
        }
        this.animStep += f6;
    }

    @Override // com.mojang.minecraft.Entity
    public void render(C0003a c0003a, float f) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, c0003a.m4a("/char.png", 9728));
        float f2 = this.yBodyRotO + ((this.yBodyRot - this.yBodyRotO) * f);
        float f3 = this.yRotO + ((this.yRot - this.yRotO) * f);
        float f4 = this.xRotO + ((this.xRot - this.xRotO) * f);
        float f5 = f3 - f2;
        GL11.glPushMatrix();
        float f6 = this.animStepO + ((this.animStep - this.animStepO) * f);
        float brightness = getBrightness();
        GL11.glColor3f(brightness, brightness, brightness);
        float f7 = (float) (((-Math.abs(Math.sin(((double) f6) * 0.6662d))) * 5.0d) - 23.0d);
        GL11.glTranslatef(this.f8xo + ((this.f11x - this.f8xo) * f), (this.f9yo + ((this.f12y - this.f9yo) * f)) - this.heightOffset, this.f10zo + ((this.f13z - this.f10zo) * f));
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
        GL11.glTranslatef(0.0f, f7, 0.0f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        f251a.m51a(f6, f5, f4);
        C0020j c0020j = this.minecraft.f155i;
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f8xo + ((this.f11x - this.f8xo) * f), this.f9yo + ((this.f12y - this.f9yo) * f) + 0.8f, this.f10zo + ((this.f13z - this.f10zo) * f));
        GL11.glRotatef(-this.minecraft.f144d.yRot, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(0.05f, -0.05f, 0.05f);
        GL11.glTranslatef((-c0020j.m50a(this.name)) / 2.0f, 0.0f, 0.0f);
        if (this.name.equalsIgnoreCase("Notch")) {
            c0020j.m48b(this.name, 0, 0, 16776960);
        } else {
            c0020j.m48b(this.name, 0, 0, 16777215);
        }
        GL11.glTranslatef(1.0f, 1.0f, -0.05f);
        c0020j.m48b(this.name, 0, 0, 5263440);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
    }

    public void queue(byte b, byte b2, byte b3, float f, float f2) {
        this.moveQueue.add(new C0047b((this.f252xp + (b / 2.0f)) / 32.0f, (this.f253yp + (b2 / 2.0f)) / 32.0f, (this.f254zp + (b3 / 2.0f)) / 32.0f, (this.yRot + f) / 2.0f, (this.xRot + f2) / 2.0f));
        this.f252xp += b;
        this.f253yp += b2;
        this.f254zp += b3;
        this.moveQueue.add(new C0047b(this.f252xp / 32.0f, this.f253yp / 32.0f, this.f254zp / 32.0f, f, f2));
    }

    public void teleport(short s, short s2, short s3, float f, float f2) {
        this.moveQueue.add(new C0047b((this.f252xp + s) / 64.0f, (this.f253yp + s2) / 64.0f, (this.f254zp + s3) / 64.0f, (this.yRot + f) / 2.0f, (this.xRot + f2) / 2.0f));
        this.f252xp = s;
        this.f253yp = s2;
        this.f254zp = s3;
        this.moveQueue.add(new C0047b(this.f252xp / 32.0f, this.f253yp / 32.0f, this.f254zp / 32.0f, f, f2));
    }

    public void queue(byte b, byte b2, byte b3) {
        this.moveQueue.add(new C0047b((this.f252xp + (b / 2.0f)) / 32.0f, (this.f253yp + (b2 / 2.0f)) / 32.0f, (this.f254zp + (b3 / 2.0f)) / 32.0f));
        this.f252xp += b;
        this.f253yp += b2;
        this.f254zp += b3;
        this.moveQueue.add(new C0047b(this.f252xp / 32.0f, this.f253yp / 32.0f, this.f254zp / 32.0f));
    }

    public void queue(float f, float f2) {
        this.moveQueue.add(new C0047b((this.yRot + f) / 2.0f, (this.xRot + f2) / 2.0f));
        this.moveQueue.add(new C0047b(f, f2));
    }
}
