package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/tile/CalmLiquidTile.class */
public class CalmLiquidTile extends LiquidTile {
    protected CalmLiquidTile(int id, int liquidType) {
        super(id, liquidType);
        this.tileId = id - 1;
        this.calmTileId = id;
        setTicking(false);
    }

    @Override // com.mojang.minecraft.level.tile.LiquidTile, com.mojang.minecraft.level.tile.Tile
    public void tick(Level level, int x, int y, int z, Random random) {
    }

    @Override // com.mojang.minecraft.level.tile.LiquidTile, com.mojang.minecraft.level.tile.Tile
    public void neighborChanged(Level level, int x, int y, int z, int type) {
        boolean hasAirNeighbor = false;
        if (level.getTile(x - 1, y, z) == 0) {
            hasAirNeighbor = true;
        }
        if (level.getTile(x + 1, y, z) == 0) {
            hasAirNeighbor = true;
        }
        if (level.getTile(x, y, z - 1) == 0) {
            hasAirNeighbor = true;
        }
        if (level.getTile(x, y, z + 1) == 0) {
            hasAirNeighbor = true;
        }
        if (level.getTile(x, y - 1, z) == 0) {
            hasAirNeighbor = true;
        }
        if (hasAirNeighbor) {
            level.setTileNoUpdate(x, y, z, this.tileId);
        }
        if (this.liquidType == 1 && type == Tile.lava.f47id) {
            level.setTileNoUpdate(x, y, z, Tile.rock.f47id);
        }
        if (this.liquidType == 2 && type == Tile.water.f47id) {
            level.setTileNoUpdate(x, y, z, Tile.rock.f47id);
        }
    }
}
