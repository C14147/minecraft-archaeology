package com.mojang.minecraft.level;

import com.mojang.minecraft.Player;
import java.util.Comparator;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/DistanceSorter.class */
public class DistanceSorter implements Comparator<Chunk> {
    private Player player;

    public DistanceSorter(Player player) {
        this.player = player;
    }

    @Override // java.util.Comparator
    public int compare(Chunk c0, Chunk c1) {
        return c0.distanceToSqr(this.player) < c1.distanceToSqr(this.player) ? -1 : 1;
    }
}
