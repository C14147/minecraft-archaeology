package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: loaded from: pre-Classic rd-20090515.jar:com/mojang/minecraft/level/tile/GrassTile.class */
public class GrassTile extends Tile {
    protected GrassTile(int id) {
        super(id);
        this.tex = 3;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    protected int getTexture(int face) {
        if (face == 1) {
            return 0;
        }
        return face == 0 ? 2 : 3;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void tick(Level level, int x, int y, int z, Random random) {
        if (!level.isLit(x, y, z)) {
            level.setTile(x, y, z, Tile.dirt.id);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int xt = (x + random.nextInt(3)) - 1;
            int yt = (y + random.nextInt(5)) - 3;
            int zt = (z + random.nextInt(3)) - 1;
            if (level.getTile(xt, yt, zt) == Tile.dirt.id && level.isLit(xt, yt, zt)) {
                level.setTile(xt, yt, zt, Tile.grass.id);
            }
        }
    }
}
