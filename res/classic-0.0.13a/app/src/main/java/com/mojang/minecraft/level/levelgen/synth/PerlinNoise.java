package com.mojang.minecraft.level.levelgen.synth;

import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/levelgen/synth/PerlinNoise.class */
public class PerlinNoise extends Synth {
    private ImprovedNoise[] noiseLevels;
    private int levels;

    public PerlinNoise(int levels) {
        this(new Random(), levels);
    }

    public PerlinNoise(Random random, int levels) {
        this.levels = levels;
        this.noiseLevels = new ImprovedNoise[levels];
        for (int i = 0; i < levels; i++) {
            this.noiseLevels[i] = new ImprovedNoise(random);
        }
    }

    @Override // com.mojang.minecraft.level.levelgen.synth.Synth
    public double getValue(double x, double y) {
        double value = 0.0d;
        double pow = 1.0d;
        for (int i = 0; i < this.levels; i++) {
            value += this.noiseLevels[i].getValue(x / pow, y / pow) * pow;
            pow *= 2.0d;
        }
        return value;
    }
}
