package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.Tesselator;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: loaded from: pre-Classic rd-161348.jar:com/mojang/minecraft/level/tile/Bush.class */
public class Bush extends Tile {
    protected Bush(int id) {
        super(id);
        this.tex = 15;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void tick(Level level, int x, int y, int z, Random random) {
        int below = level.getTile(x, y - 1, z);
        if (!level.isLit(x, y, z) || (below != Tile.dirt.id && below != Tile.grass.id)) {
            level.setTile(x, y, z, 0);
        }
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void render(Tesselator t, Level level, int layer, int x, int y, int z) {
        if (level.isLit(x, y, z) ^ (layer != 1)) {
            return;
        }
        int tex = getTexture(15);
        float u0 = (tex % 16) / 16.0f;
        float u1 = u0 + 0.0624375f;
        float v0 = (tex / 16) / 16.0f;
        float v1 = v0 + 0.0624375f;
        t.color(1.0f, 1.0f, 1.0f);
        for (int r = 0; r < 2; r++) {
            float xa = (float) (Math.sin(((((double) r) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float za = (float) (Math.cos(((((double) r) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float x0 = (x + 0.5f) - xa;
            float x1 = x + 0.5f + xa;
            float y0 = y + 0.0f;
            float y1 = y + 1.0f;
            float z0 = (z + 0.5f) - za;
            float z1 = z + 0.5f + za;
            t.vertexUV(x0, y1, z0, u1, v0);
            t.vertexUV(x1, y1, z1, u0, v0);
            t.vertexUV(x1, y0, z1, u0, v1);
            t.vertexUV(x0, y0, z0, u1, v1);
            t.vertexUV(x1, y1, z1, u0, v0);
            t.vertexUV(x0, y1, z0, u1, v0);
            t.vertexUV(x0, y0, z0, u1, v1);
            t.vertexUV(x1, y0, z1, u0, v1);
        }
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public AABB getAABB(int x, int y, int z) {
        return null;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public boolean blocksLight() {
        return false;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public boolean isSolid() {
        return false;
    }
}
