package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Tesselator;
import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/tile/LiquidTile.class */
public class LiquidTile extends Tile {
    protected int liquidType;
    protected int calmTileId;
    protected int tileId;
    protected int spreadSpeed;

    protected LiquidTile(int id, int liquidType) {
        super(id);
        this.spreadSpeed = 1;
        this.liquidType = liquidType;
        this.tex = 14;
        if (liquidType == 2) {
            this.tex = 30;
        }
        if (liquidType == 1) {
            this.spreadSpeed = 8;
        }
        if (liquidType == 2) {
            this.spreadSpeed = 2;
        }
        this.tileId = id;
        this.calmTileId = id + 1;
        setShape(0.0f, 0.0f - 0.1f, 0.0f, 1.0f, 1.0f - 0.1f, 1.0f);
        setTicking(true);
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void tick(Level level, int x, int y, int z, Random random) {
        updateWater(level, x, y, z, 0);
    }

    public boolean updateWater(Level level, int x, int y, int z, int depth) {
        boolean hasChanged = false;
        do {
            y--;
            if (level.getTile(x, y, z) != 0) {
                break;
            }
            boolean change = level.setTile(x, y, z, this.tileId);
            if (change) {
                hasChanged = true;
            }
            if (!change) {
                break;
            }
        } while (this.liquidType != 2);
        int y2 = y + 1;
        if (this.liquidType == 1 || !hasChanged) {
            hasChanged = hasChanged | checkWater(level, x - 1, y2, z, depth) | checkWater(level, x + 1, y2, z, depth) | checkWater(level, x, y2, z - 1, depth) | checkWater(level, x, y2, z + 1, depth);
        }
        if (!hasChanged) {
            level.setTileNoUpdate(x, y2, z, this.calmTileId);
        }
        return hasChanged;
    }

    private boolean checkWater(Level level, int x, int y, int z, int depth) {
        boolean hasChanged = false;
        int type = level.getTile(x, y, z);
        if (type == 0) {
            boolean changed = level.setTile(x, y, z, this.tileId);
            if (changed && depth < this.spreadSpeed) {
                hasChanged = false | updateWater(level, x, y, z, depth + 1);
            }
        }
        return hasChanged;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    protected boolean shouldRenderFace(Level level, int x, int y, int z, int layer, int face) {
        int id;
        if (x < 0 || y < 0 || z < 0 || x >= level.width || z >= level.height) {
            return false;
        }
        if ((layer != 2 && this.liquidType == 1) || (id = level.getTile(x, y, z)) == this.tileId || id == this.calmTileId) {
            return false;
        }
        return super.shouldRenderFace(level, x, y, z, -1, face);
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void renderFace(Tesselator t, int x, int y, int z, int face) {
        super.renderFace(t, x, y, z, face);
        super.renderBackFace(t, x, y, z, face);
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public boolean mayPick() {
        return false;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public AABB getAABB(int x, int y, int z) {
        return null;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public boolean blocksLight() {
        return true;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public boolean isSolid() {
        return false;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public int getLiquidType() {
        return this.liquidType;
    }

    @Override // com.mojang.minecraft.level.tile.Tile
    public void neighborChanged(Level level, int x, int y, int z, int type) {
        if (this.liquidType == 1 && (type == Tile.lava.f47id || type == Tile.calmLava.f47id)) {
            level.setTileNoUpdate(x, y, z, Tile.rock.f47id);
        }
        if (this.liquidType == 2) {
            if (type == Tile.water.f47id || type == Tile.calmWater.f47id) {
                level.setTileNoUpdate(x, y, z, Tile.rock.f47id);
            }
        }
    }
}
