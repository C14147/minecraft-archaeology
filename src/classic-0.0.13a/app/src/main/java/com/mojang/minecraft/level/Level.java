package com.mojang.minecraft.level;

import com.mojang.minecraft.level.tile.Tile;
import com.mojang.minecraft.phys.AABB;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/Level.class */
public class Level {
    private static final int TILE_UPDATE_INTERVAL = 200;
    public int width;
    public int height;
    public int depth;
    byte[] blocks;
    private int[] lightDepths;
    public String name;
    public String creator;
    public long createTime;
    private static final int multiplier = 1664525;
    private static final int addend = 1013904223;
    private ArrayList<LevelListener> levelListeners = new ArrayList<>();
    private Random random = new Random();
    private int randValue = this.random.nextInt();
    int unprocessed = 0;

    public void setData(int w, int d, int h, byte[] blocks) {
        this.width = w;
        this.height = h;
        this.depth = d;
        this.blocks = blocks;
        this.lightDepths = new int[w * h];
        calcLightDepths(0, 0, w, h);
        for (int i = 0; i < this.levelListeners.size(); i++) {
            this.levelListeners.get(i).allChanged();
        }
    }

    public void calcLightDepths(int x0, int y0, int x1, int y1) {
        for (int x = x0; x < x0 + x1; x++) {
            for (int z = y0; z < y0 + y1; z++) {
                int oldDepth = this.lightDepths[x + (z * this.width)];
                int y = this.depth - 1;
                while (y > 0 && !isLightBlocker(x, y, z)) {
                    y--;
                }
                this.lightDepths[x + (z * this.width)] = y + 1;
                if (oldDepth != y) {
                    int yl0 = oldDepth < y ? oldDepth : y;
                    int yl1 = oldDepth > y ? oldDepth : y;
                    for (int i = 0; i < this.levelListeners.size(); i++) {
                        this.levelListeners.get(i).lightColumnChanged(x, z, yl0, yl1);
                    }
                }
            }
        }
    }

    public void addListener(LevelListener levelListener) {
        this.levelListeners.add(levelListener);
    }

    public void removeListener(LevelListener levelListener) {
        this.levelListeners.remove(levelListener);
    }

    public boolean isLightBlocker(int x, int y, int z) {
        Tile tile = Tile.tiles[getTile(x, y, z)];
        if (tile == null) {
            return false;
        }
        return tile.blocksLight();
    }

    public ArrayList<AABB> getCubes(AABB box) {
        AABB aabb;
        AABB aabb2;
        ArrayList<AABB> boxes = new ArrayList<>();
        int x0 = (int) Math.floor(box.f53x0);
        int x1 = (int) Math.floor(box.f56x1 + 1.0f);
        int y0 = (int) Math.floor(box.f54y0);
        int y1 = (int) Math.floor(box.f57y1 + 1.0f);
        int z0 = (int) Math.floor(box.f55z0);
        int z1 = (int) Math.floor(box.f58z1 + 1.0f);
        for (int x = x0; x < x1; x++) {
            for (int y = y0; y < y1; y++) {
                for (int z = z0; z < z1; z++) {
                    if (x >= 0 && y >= 0 && z >= 0 && x < this.width && y < this.depth && z < this.height) {
                        Tile tile = Tile.tiles[getTile(x, y, z)];
                        if (tile != null && (aabb2 = tile.getAABB(x, y, z)) != null) {
                            boxes.add(aabb2);
                        }
                    } else if ((x < 0 || y < 0 || z < 0 || x >= this.width || z >= this.height) && (aabb = Tile.unbreakable.getAABB(x, y, z)) != null) {
                        boxes.add(aabb);
                    }
                }
            }
        }
        return boxes;
    }

    public boolean setTile(int x, int y, int z, int type) {
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height || type == this.blocks[(((y * this.height) + z) * this.width) + x]) {
            return false;
        }
        this.blocks[(((y * this.height) + z) * this.width) + x] = (byte) type;
        neighborChanged(x - 1, y, z, type);
        neighborChanged(x + 1, y, z, type);
        neighborChanged(x, y - 1, z, type);
        neighborChanged(x, y + 1, z, type);
        neighborChanged(x, y, z - 1, type);
        neighborChanged(x, y, z + 1, type);
        calcLightDepths(x, z, 1, 1);
        for (int i = 0; i < this.levelListeners.size(); i++) {
            this.levelListeners.get(i).tileChanged(x, y, z);
        }
        return true;
    }

    public boolean setTileNoUpdate(int x, int y, int z, int type) {
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height || type == this.blocks[(((y * this.height) + z) * this.width) + x]) {
            return false;
        }
        this.blocks[(((y * this.height) + z) * this.width) + x] = (byte) type;
        return true;
    }

    private void neighborChanged(int x, int y, int z, int type) {
        Tile tile;
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height || (tile = Tile.tiles[this.blocks[(((y * this.height) + z) * this.width) + x]]) == null) {
            return;
        }
        tile.neighborChanged(this, x, y, z, type);
    }

    public boolean isLit(int x, int y, int z) {
        return x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height || y >= this.lightDepths[x + (z * this.width)];
    }

    public int getTile(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height) {
            return 0;
        }
        return this.blocks[(((y * this.height) + z) * this.width) + x];
    }

    public boolean isSolidTile(int x, int y, int z) {
        Tile tile = Tile.tiles[getTile(x, y, z)];
        if (tile == null) {
            return false;
        }
        return tile.isSolid();
    }

    public void tick() {
        this.unprocessed += this.width * this.height * this.depth;
        int ticks = this.unprocessed / TILE_UPDATE_INTERVAL;
        this.unprocessed -= ticks * TILE_UPDATE_INTERVAL;
        for (int i = 0; i < ticks; i++) {
            this.randValue = (this.randValue * multiplier) + addend;
            int x = (this.randValue >> 16) & (this.width - 1);
            this.randValue = (this.randValue * multiplier) + addend;
            int y = (this.randValue >> 16) & (this.depth - 1);
            this.randValue = (this.randValue * multiplier) + addend;
            int z = (this.randValue >> 16) & (this.height - 1);
            byte b = this.blocks[(((y * this.height) + z) * this.width) + x];
            if (Tile.shouldTick[b]) {
                Tile.tiles[b].tick(this, x, y, z, this.random);
            }
        }
    }

    public float getGroundLevel() {
        return 32.0f;
    }

    public boolean containsAnyLiquid(AABB box) {
        int x0 = (int) Math.floor(box.f53x0);
        int x1 = (int) Math.floor(box.f56x1 + 1.0f);
        int y0 = (int) Math.floor(box.f54y0);
        int y1 = (int) Math.floor(box.f57y1 + 1.0f);
        int z0 = (int) Math.floor(box.f55z0);
        int z1 = (int) Math.floor(box.f58z1 + 1.0f);
        if (x0 < 0) {
            x0 = 0;
        }
        if (y0 < 0) {
            y0 = 0;
        }
        if (z0 < 0) {
            z0 = 0;
        }
        if (x1 > this.width) {
            x1 = this.width;
        }
        if (y1 > this.depth) {
            y1 = this.depth;
        }
        if (z1 > this.height) {
            z1 = this.height;
        }
        for (int x = x0; x < x1; x++) {
            for (int y = y0; y < y1; y++) {
                for (int z = z0; z < z1; z++) {
                    Tile tile = Tile.tiles[getTile(x, y, z)];
                    if (tile != null && tile.getLiquidType() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsLiquid(AABB box, int liquidId) {
        int x0 = (int) Math.floor(box.f53x0);
        int x1 = (int) Math.floor(box.f56x1 + 1.0f);
        int y0 = (int) Math.floor(box.f54y0);
        int y1 = (int) Math.floor(box.f57y1 + 1.0f);
        int z0 = (int) Math.floor(box.f55z0);
        int z1 = (int) Math.floor(box.f58z1 + 1.0f);
        if (x0 < 0) {
            x0 = 0;
        }
        if (y0 < 0) {
            y0 = 0;
        }
        if (z0 < 0) {
            z0 = 0;
        }
        if (x1 > this.width) {
            x1 = this.width;
        }
        if (y1 > this.depth) {
            y1 = this.depth;
        }
        if (z1 > this.height) {
            z1 = this.height;
        }
        for (int x = x0; x < x1; x++) {
            for (int y = y0; y < y1; y++) {
                for (int z = z0; z < z1; z++) {
                    Tile tile = Tile.tiles[getTile(x, y, z)];
                    if (tile != null && tile.getLiquidType() == liquidId) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
