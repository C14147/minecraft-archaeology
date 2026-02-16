package com.mojang.rubydung.level;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/Tile.class */
public class Tile {
    public static Tile grass = new Tile(0);
    public static Tile rock = new Tile(1);
    private final int textureId;

    public Tile(int textureId) {
        this.textureId = textureId;
    }

    public void render(Tessellator tessellator, Level level, int layer, int x, int y, int z) {
        float minU = this.textureId / 16.0f;
        float maxU = minU + 0.0625f;
        float maxV = 0.0f + 0.0625f;
        float minX = x + 0.0f;
        float maxX = x + 1.0f;
        float minY = y + 0.0f;
        float maxY = y + 1.0f;
        float minZ = z + 0.0f;
        float maxZ = z + 1.0f;
        if (!level.isSolidTile(x, y - 1, z)) {
            float brightness = level.getBrightness(x, y - 1, z) * 1.0f;
            if ((layer == 1) ^ (brightness == 1.0f)) {
                tessellator.color(brightness, brightness, brightness);
                tessellator.texture(minU, maxV);
                tessellator.vertex(minX, minY, maxZ);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(minX, minY, minZ);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(maxX, minY, minZ);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(maxX, minY, maxZ);
            }
        }
        if (!level.isSolidTile(x, y + 1, z)) {
            float brightness2 = level.getBrightness(x, y + 1, z) * 1.0f;
            if ((layer == 1) ^ (brightness2 == 1.0f)) {
                tessellator.color(brightness2, brightness2, brightness2);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(maxX, maxY, maxZ);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(maxX, maxY, minZ);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(minX, maxY, minZ);
                tessellator.texture(minU, maxV);
                tessellator.vertex(minX, maxY, maxZ);
            }
        }
        if (!level.isSolidTile(x, y, z - 1)) {
            float brightness3 = level.getBrightness(x, y, z - 1) * 0.8f;
            if ((layer == 1) ^ (brightness3 == 0.8f)) {
                tessellator.color(brightness3, brightness3, brightness3);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(minX, maxY, minZ);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(maxX, maxY, minZ);
                tessellator.texture(minU, maxV);
                tessellator.vertex(maxX, minY, minZ);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(minX, minY, minZ);
            }
        }
        if (!level.isSolidTile(x, y, z + 1)) {
            float brightness4 = level.getBrightness(x, y, z + 1) * 0.8f;
            if ((layer == 1) ^ (brightness4 == 0.8f)) {
                tessellator.color(brightness4, brightness4, brightness4);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(minX, maxY, maxZ);
                tessellator.texture(minU, maxV);
                tessellator.vertex(minX, minY, maxZ);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(maxX, minY, maxZ);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(maxX, maxY, maxZ);
            }
        }
        if (!level.isSolidTile(x - 1, y, z)) {
            float brightness5 = level.getBrightness(x - 1, y, z) * 0.6f;
            if ((layer == 1) ^ (brightness5 == 0.6f)) {
                tessellator.color(brightness5, brightness5, brightness5);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(minX, maxY, maxZ);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(minX, maxY, minZ);
                tessellator.texture(minU, maxV);
                tessellator.vertex(minX, minY, minZ);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(minX, minY, maxZ);
            }
        }
        if (!level.isSolidTile(x + 1, y, z)) {
            float brightness6 = level.getBrightness(x + 1, y, z) * 0.6f;
            if ((layer == 1) ^ (brightness6 == 0.6f)) {
                tessellator.color(brightness6, brightness6, brightness6);
                tessellator.texture(minU, maxV);
                tessellator.vertex(maxX, minY, maxZ);
                tessellator.texture(maxU, maxV);
                tessellator.vertex(maxX, minY, minZ);
                tessellator.texture(maxU, 0.0f);
                tessellator.vertex(maxX, maxY, minZ);
                tessellator.texture(minU, 0.0f);
                tessellator.vertex(maxX, maxY, maxZ);
            }
        }
    }
}
