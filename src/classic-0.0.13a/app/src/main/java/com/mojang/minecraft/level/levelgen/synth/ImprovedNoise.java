package com.mojang.minecraft.level.levelgen.synth;

import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/levelgen/synth/ImprovedNoise.class */
public class ImprovedNoise extends Synth {

    /* JADX INFO: renamed from: p */
    private int[] f46p;
    public double scale;

    public ImprovedNoise() {
        this(new Random());
    }

    public ImprovedNoise(Random random) {
        this.f46p = new int[512];
        for (int i = 0; i < 256; i++) {
            this.f46p[i] = i;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int j = random.nextInt(256 - i2) + i2;
            int tmp = this.f46p[i2];
            this.f46p[i2] = this.f46p[j];
            this.f46p[j] = tmp;
            this.f46p[i2 + 256] = this.f46p[i2];
        }
    }

    public double noise(double x, double y, double z) {
        int X = ((int) Math.floor(x)) & 255;
        int Y = ((int) Math.floor(y)) & 255;
        int Z = ((int) Math.floor(z)) & 255;
        double x2 = x - Math.floor(x);
        double y2 = y - Math.floor(y);
        double z2 = z - Math.floor(z);
        double u = fade(x2);
        double v = fade(y2);
        double w = fade(z2);
        int A = this.f46p[X] + Y;
        int AA = this.f46p[A] + Z;
        int AB = this.f46p[A + 1] + Z;
        int B = this.f46p[X + 1] + Y;
        int BA = this.f46p[B] + Z;
        int BB = this.f46p[B + 1] + Z;
        return lerp(w, lerp(v, lerp(u, grad(this.f46p[AA], x2, y2, z2), grad(this.f46p[BA], x2 - 1.0d, y2, z2)), lerp(u, grad(this.f46p[AB], x2, y2 - 1.0d, z2), grad(this.f46p[BB], x2 - 1.0d, y2 - 1.0d, z2))), lerp(v, lerp(u, grad(this.f46p[AA + 1], x2, y2, z2 - 1.0d), grad(this.f46p[BA + 1], x2 - 1.0d, y2, z2 - 1.0d)), lerp(u, grad(this.f46p[AB + 1], x2, y2 - 1.0d, z2 - 1.0d), grad(this.f46p[BB + 1], x2 - 1.0d, y2 - 1.0d, z2 - 1.0d))));
    }

    public double fade(double t) {
        return t * t * t * ((t * ((t * 6.0d) - 15.0d)) + 10.0d);
    }

    public double lerp(double t, double a, double b) {
        return a + (t * (b - a));
    }

    public double grad(int hash, double x, double y, double z) {
        int h = hash & 15;
        double u = h < 8 ? x : y;
        double v = h < 4 ? y : (h == 12 || h == 14) ? x : z;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

    @Override // com.mojang.minecraft.level.levelgen.synth.Synth
    public double getValue(double x, double y) {
        return noise(x, y, 0.0d);
    }
}
