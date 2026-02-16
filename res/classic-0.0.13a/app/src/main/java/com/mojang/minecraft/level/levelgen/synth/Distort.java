package com.mojang.minecraft.level.levelgen.synth;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/levelgen/synth/Distort.class */
public class Distort extends Synth {
    private Synth source;
    private Synth distort;

    public Distort(Synth source, Synth distort) {
        this.source = source;
        this.distort = distort;
    }

    @Override // com.mojang.minecraft.level.levelgen.synth.Synth
    public double getValue(double x, double y) {
        return this.source.getValue(x + this.distort.getValue(x, y), y);
    }
}
