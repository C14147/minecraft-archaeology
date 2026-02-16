package com.mojang.minecraft.level.levelgen.synth;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/levelgen/synth/Emboss.class */
public class Emboss extends Synth {
    private Synth synth;

    public Emboss(Synth synth) {
        this.synth = synth;
    }

    @Override // com.mojang.minecraft.level.levelgen.synth.Synth
    public double getValue(double x, double y) {
        return this.synth.getValue(x, y) - this.synth.getValue(x + 1.0d, y + 1.0d);
    }
}
