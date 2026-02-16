package com.mojang.minecraft.level;

import com.mojang.minecraft.level.tile.Tile;
import java.util.Random;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/level/LevelGen.class */
public class LevelGen {
    private int width;
    private int height;
    private int depth;
    private Random random = new Random();

    public LevelGen(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public byte[] generateMap() {
        int w = this.width;
        int h = this.height;
        int d = this.depth;
        int[] heightmap1 = new NoiseMap(0).read(w, h);
        int[] heightmap2 = new NoiseMap(0).read(w, h);
        int[] cf = new NoiseMap(1).read(w, h);
        int[] rockMap = new NoiseMap(1).read(w, h);
        byte[] blocks = new byte[this.width * this.height * this.depth];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < d; y++) {
                for (int z = 0; z < h; z++) {
                    int dh1 = heightmap1[x + (z * this.width)];
                    int dh2 = heightmap2[x + (z * this.width)];
                    int cfh = cf[x + (z * this.width)];
                    if (cfh < 128) {
                        dh2 = dh1;
                    }
                    int dh = dh1;
                    if (dh2 > dh) {
                        dh = dh2;
                    }
                    int dh3 = (dh / 8) + (d / 3);
                    int rh = (rockMap[x + (z * this.width)] / 8) + (d / 3);
                    if (rh > dh3 - 2) {
                        rh = dh3 - 2;
                    }
                    int i = (((y * this.height) + z) * this.width) + x;
                    int id = y == dh3 ? Tile.grass.id : 0;
                    if (y < dh3) {
                        id = Tile.dirt.id;
                    }
                    if (y <= rh) {
                        id = Tile.rock.id;
                    }
                    blocks[i] = (byte) id;
                }
            }
        }
        int count = (((w * h) * d) / 256) / 64;
        for (int i2 = 0; i2 < count; i2++) {
            float x2 = this.random.nextFloat() * w;
            float y2 = this.random.nextFloat() * d;
            float z2 = this.random.nextFloat() * h;
            int length = (int) (this.random.nextFloat() + (this.random.nextFloat() * 150.0f));
            float dir1 = (float) (((double) this.random.nextFloat()) * 3.141592653589793d * 2.0d);
            float dira1 = 0.0f;
            float dir2 = (float) (((double) this.random.nextFloat()) * 3.141592653589793d * 2.0d);
            float dira2 = 0.0f;
            for (int l = 0; l < length; l++) {
                x2 = (float) (((double) x2) + (Math.sin(dir1) * Math.cos(dir2)));
                z2 = (float) (((double) z2) + (Math.cos(dir1) * Math.cos(dir2)));
                y2 = (float) (((double) y2) + Math.sin(dir2));
                dir1 += dira1 * 0.2f;
                dira1 = (dira1 * 0.9f) + (this.random.nextFloat() - this.random.nextFloat());
                dir2 = (dir2 + (dira2 * 0.5f)) * 0.5f;
                dira2 = (dira2 * 0.9f) + (this.random.nextFloat() - this.random.nextFloat());
                float size = (float) ((Math.sin((((double) l) * 3.141592653589793d) / ((double) length)) * 2.5d) + 1.0d);
                for (int xx = (int) (x2 - size); xx <= ((int) (x2 + size)); xx++) {
                    for (int yy = (int) (y2 - size); yy <= ((int) (y2 + size)); yy++) {
                        for (int zz = (int) (z2 - size); zz <= ((int) (z2 + size)); zz++) {
                            float xd = xx - x2;
                            float yd = yy - y2;
                            float zd = zz - z2;
                            float dd = (xd * xd) + (yd * yd * 2.0f) + (zd * zd);
                            if (dd < size * size && xx >= 1 && yy >= 1 && zz >= 1 && xx < this.width - 1 && yy < this.depth - 1 && zz < this.height - 1) {
                                int ii = (((yy * this.height) + zz) * this.width) + xx;
                                if (blocks[ii] == Tile.rock.id) {
                                    blocks[ii] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return blocks;
    }
}
