package com.mojang.minecraft.level;

import com.mojang.minecraft.Player;
import com.mojang.minecraft.level.tile.Tile;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Tesselator;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/Chunk.class */
public class Chunk {
    public AABB aabb;
    public final Level level;

    /* JADX INFO: renamed from: x0 */
    public final int f30x0;

    /* JADX INFO: renamed from: y0 */
    public final int f31y0;

    /* JADX INFO: renamed from: z0 */
    public final int f32z0;

    /* JADX INFO: renamed from: x1 */
    public final int f33x1;

    /* JADX INFO: renamed from: y1 */
    public final int f34y1;

    /* JADX INFO: renamed from: z1 */
    public final int f35z1;

    /* JADX INFO: renamed from: x */
    public final float f36x;

    /* JADX INFO: renamed from: y */
    public final float f37y;

    /* JADX INFO: renamed from: z */
    public final float f38z;
    private int lists;
    public boolean visible;

    /* JADX INFO: renamed from: t */
    private static Tesselator f39t = Tesselator.instance;
    public static int updates = 0;
    private static long totalTime = 0;
    private static int totalUpdates = 0;
    private boolean dirty = true;
    public long dirtiedTime = 0;

    public Chunk(Level level, int x0, int y0, int z0, int x1, int y1, int z1) {
        this.lists = -1;
        this.level = level;
        this.f30x0 = x0;
        this.f31y0 = y0;
        this.f32z0 = z0;
        this.f33x1 = x1;
        this.f34y1 = y1;
        this.f35z1 = z1;
        this.f36x = (x0 + x1) / 2.0f;
        this.f37y = (y0 + y1) / 2.0f;
        this.f38z = (z0 + z1) / 2.0f;
        this.aabb = new AABB(x0, y0, z0, x1, y1, z1);
        this.lists = GL11.glGenLists(3);
    }

    private void rebuild(int layer) {
        long before = System.nanoTime();
        GL11.glNewList(this.lists + layer, 4864);
        f39t.begin();
        int tiles = 0;
        for (int x = this.f30x0; x < this.f33x1; x++) {
            for (int y = this.f31y0; y < this.f34y1; y++) {
                for (int z = this.f32z0; z < this.f35z1; z++) {
                    int tileId = this.level.getTile(x, y, z);
                    if (tileId > 0) {
                        Tile.tiles[tileId].render(f39t, this.level, layer, x, y, z);
                        tiles++;
                    }
                }
            }
        }
        f39t.end();
        GL11.glEndList();
        long after = System.nanoTime();
        if (tiles > 0) {
            totalTime += after - before;
            totalUpdates++;
        }
    }

    public void rebuild() {
        updates++;
        rebuild(0);
        rebuild(1);
        rebuild(2);
        this.dirty = false;
    }

    public void render(int layer) {
        GL11.glCallList(this.lists + layer);
    }

    public void setDirty() {
        if (!this.dirty) {
            this.dirtiedTime = System.currentTimeMillis();
        }
        this.dirty = true;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public float distanceToSqr(Player player) {
        float xd = player.f3x - this.f36x;
        float yd = player.f4y - this.f37y;
        float zd = player.f5z - this.f38z;
        return (xd * xd) + (yd * yd) + (zd * zd);
    }

    public void reset() {
        this.dirty = true;
        for (int i = 0; i < 3; i++) {
            GL11.glNewList(this.lists + i, 4864);
            GL11.glEndList();
        }
    }
}
