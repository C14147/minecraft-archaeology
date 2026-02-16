package com.mojang.minecraft.character;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/character/Vec3.class */
public class Vec3 {

    /* JADX INFO: renamed from: x */
    public float f19x;

    /* JADX INFO: renamed from: y */
    public float f20y;

    /* JADX INFO: renamed from: z */
    public float f21z;

    public Vec3(float x, float y, float z) {
        this.f19x = x;
        this.f20y = y;
        this.f21z = z;
    }

    public Vec3 interpolateTo(Vec3 t, float p) {
        float xt = this.f19x + ((t.f19x - this.f19x) * p);
        float yt = this.f20y + ((t.f20y - this.f20y) * p);
        float zt = this.f21z + ((t.f21z - this.f21z) * p);
        return new Vec3(xt, yt, zt);
    }

    public void set(float x, float y, float z) {
        this.f19x = x;
        this.f20y = y;
        this.f21z = z;
    }
}
