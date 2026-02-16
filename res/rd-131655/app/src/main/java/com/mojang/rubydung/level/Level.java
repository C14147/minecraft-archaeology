package com.mojang.rubydung.level;

import com.mojang.rubydung.phys.AABB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/Level.class */
public class Level {
    public final int width;
    public final int height;
    public final int depth;
    private final byte[] blocks;
    private final int[] lightDepths;

    public Level(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.blocks = new byte[width * height * depth];
        this.lightDepths = new int[width * height];
        File levelFile = new File("level.dat");
        if (levelFile.exists()) {
            load();
            return;
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < depth; y++) {
                for (int z = 0; z < height; z++) {
                    this.blocks[(((y * this.height) + z) * this.width) + x] = 1;
                }
            }
        }
        for (int i = 0; i < 10000; i++) {
            int caveSize = ((int) (Math.random() * 7.0d)) + 1;
            int caveX = (int) (Math.random() * ((double) width));
            int caveY = (int) (Math.random() * ((double) depth));
            int caveZ = (int) (Math.random() * ((double) height));
            for (int radius = 0; radius < caveSize; radius++) {
                for (int sphere = 0; sphere < 1000; sphere++) {
                    int offsetX = (int) (((Math.random() * ((double) radius)) * 2.0d) - ((double) radius));
                    int offsetY = (int) (((Math.random() * ((double) radius)) * 2.0d) - ((double) radius));
                    int offsetZ = (int) (((Math.random() * ((double) radius)) * 2.0d) - ((double) radius));
                    double distance = Math.pow(offsetX, 2.0d) + Math.pow(offsetY, 2.0d) + Math.pow(offsetZ, 2.0d);
                    if (distance <= radius * radius) {
                        int tileX = caveX + offsetX;
                        int tileY = caveY + offsetY;
                        int tileZ = caveZ + offsetZ;
                        int index = (((tileY * this.height) + tileZ) * this.width) + tileX;
                        if (index >= 0 && index < this.blocks.length && tileX > 0 && tileY > 0 && tileZ > 0 && tileX < this.width - 1 && tileY < this.depth && tileZ < this.height - 1) {
                            this.blocks[index] = 0;
                        }
                    }
                }
            }
        }
        calcLightDepths(0, 0, width, height);
    }

    public void load() {
        try {
            DataInputStream dis = new DataInputStream(new GZIPInputStream(new FileInputStream("level.dat")));
            dis.readFully(this.blocks);
            calcLightDepths(0, 0, this.width, this.height);
            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(new FileOutputStream("level.dat")));
            dos.write(this.blocks);
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calcLightDepths(int minX, int minZ, int maxX, int maxZ) {
        for (int x = minX; x < minX + maxX; x++) {
            for (int z = minZ; z < minZ + maxZ; z++) {
                int i = this.lightDepths[x + (z * this.width)];
                int depth = this.depth - 1;
                while (depth > 0 && !isLightBlocker(x, depth, z)) {
                    depth--;
                }
                this.lightDepths[x + (z * this.width)] = depth;
            }
        }
    }

    public boolean isTile(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height) {
            return false;
        }
        int index = (((y * this.height) + z) * this.width) + x;
        return this.blocks[index] != 0;
    }

    public boolean isSolidTile(int x, int y, int z) {
        return isTile(x, y, z);
    }

    public boolean isLightBlocker(int x, int y, int z) {
        return isSolidTile(x, y, z);
    }

    public float getBrightness(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= this.width || y >= this.depth || z >= this.height) {
            return 1.0f;
        }
        if (y < this.lightDepths[x + (z * this.width)]) {
            return 0.8f;
        }
        return 1.0f;
    }

    public ArrayList<AABB> getCubes(AABB boundingBox) {
        ArrayList<AABB> boundingBoxList = new ArrayList<>();
        int minX = (int) (Math.floor(boundingBox.minX) - 1.0d);
        int maxX = (int) (Math.ceil(boundingBox.maxX) + 1.0d);
        int minY = (int) (Math.floor(boundingBox.minY) - 1.0d);
        int maxY = (int) (Math.ceil(boundingBox.maxY) + 1.0d);
        int minZ = (int) (Math.floor(boundingBox.minZ) - 1.0d);
        int maxZ = (int) (Math.ceil(boundingBox.maxZ) + 1.0d);
        int minX2 = Math.max(0, minX);
        int minY2 = Math.max(0, minY);
        int minZ2 = Math.max(0, minZ);
        int maxX2 = Math.min(this.width, maxX);
        int maxY2 = Math.min(this.depth, maxY);
        int maxZ2 = Math.min(this.height, maxZ);
        for (int x = minX2; x < maxX2; x++) {
            for (int y = minY2; y < maxY2; y++) {
                for (int z = minZ2; z < maxZ2; z++) {
                    if (isSolidTile(x, y, z)) {
                        boundingBoxList.add(new AABB(x, y, z, x + 1, y + 1, z + 1));
                    }
                }
            }
        }
        return boundingBoxList;
    }
}
