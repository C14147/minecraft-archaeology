package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/tile/GrassTile.class */
public class GrassTile extends Tile {
    protected GrassTile(int id) {
        super(id);
        this.tex = 3;
        setTicking(true);
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
        if (random.nextInt(4) != 0) {
            return;
        }
        if (!level.isLit(x, y + 1, z)) {
            level.setTile(x, y, z, Tile.dirt.f47id);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int xt = (x + random.nextInt(3)) - 1;
            int yt = (y + random.nextInt(5)) - 3;
            int zt = (z + random.nextInt(3)) - 1;
            if (level.getTile(xt, yt, zt) == Tile.dirt.f47id && level.isLit(xt, yt + 1, zt)) {
                level.setTile(xt, yt, zt, Tile.grass.f47id);
            }
        }
    }
}
