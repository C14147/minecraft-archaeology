package com.mojang.minecraft.level.levelgen.synth;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/levelgen/synth/Scale.class */
public class Scale extends Synth {
    private Synth synth;
    private double xScale;
    private double yScale;

    public Scale(Synth synth, double xScale, double yScale) {
        this.synth = synth;
        this.xScale = 1.0d / xScale;
        this.yScale = 1.0d / yScale;
    }

    @Override // com.mojang.minecraft.level.levelgen.synth.Synth
    public double getValue(double x, double y) {
        return this.synth.getValue(x * this.xScale, y * this.yScale);
    }
}
