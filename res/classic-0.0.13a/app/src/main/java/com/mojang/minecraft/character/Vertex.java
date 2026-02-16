package com.mojang.minecraft.character;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/character/Vertex.class */
public class Vertex {
    public Vec3 pos;

    /* JADX INFO: renamed from: u */
    public float f22u;

    /* JADX INFO: renamed from: v */
    public float f23v;

    public Vertex(float x, float y, float z, float u, float v) {
        this(new Vec3(x, y, z), u, v);
    }

    public Vertex remap(float u, float v) {
        return new Vertex(this, u, v);
    }

    public Vertex(Vertex vertex, float u, float v) {
        this.pos = vertex.pos;
        this.f22u = u;
        this.f23v = v;
    }

    public Vertex(Vec3 pos, float u, float v) {
        this.pos = pos;
        this.f22u = u;
        this.f23v = v;
    }
}
