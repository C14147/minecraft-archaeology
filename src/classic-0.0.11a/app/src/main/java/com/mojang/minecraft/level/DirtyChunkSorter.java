package com.mojang.minecraft.level;

import com.mojang.minecraft.Player;
import com.mojang.minecraft.renderer.Frustum;
import java.util.Comparator;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/level/DirtyChunkSorter.class */
public class DirtyChunkSorter implements Comparator<Chunk> {
    private Player player;
    private Frustum frustum;
    private long now = System.currentTimeMillis();

    public DirtyChunkSorter(Player player, Frustum frustum) {
        this.player = player;
        this.frustum = frustum;
    }

    @Override // java.util.Comparator
    public int compare(Chunk c0, Chunk c1) {
        boolean i0 = this.frustum.isVisible(c0.aabb);
        boolean i1 = this.frustum.isVisible(c1.aabb);
        if (i0 && !i1) {
            return -1;
        }
        if (i1 && !i0) {
            return 1;
        }
        int t0 = (int) ((this.now - c0.dirtiedTime) / 2000);
        int t1 = (int) ((this.now - c1.dirtiedTime) / 2000);
        if (t0 < t1) {
            return -1;
        }
        return (t0 <= t1 && c0.distanceToSqr(this.player) < c1.distanceToSqr(this.player)) ? -1 : 1;
    }
}
