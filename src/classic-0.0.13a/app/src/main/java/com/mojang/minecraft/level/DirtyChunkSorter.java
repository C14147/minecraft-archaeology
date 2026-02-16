package com.mojang.minecraft.level;

import com.mojang.minecraft.Player;
import java.util.Comparator;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/DirtyChunkSorter.class */
public class DirtyChunkSorter implements Comparator<Chunk> {
    private Player player;

    public DirtyChunkSorter(Player player) {
        this.player = player;
    }

    @Override // java.util.Comparator
    public int compare(Chunk c0, Chunk c1) {
        boolean i0 = c0.visible;
        boolean i1 = c1.visible;
        if (!i0 || i1) {
            return ((!i1 || i0) && c0.distanceToSqr(this.player) < c1.distanceToSqr(this.player)) ? -1 : 1;
        }
        return -1;
    }
}
