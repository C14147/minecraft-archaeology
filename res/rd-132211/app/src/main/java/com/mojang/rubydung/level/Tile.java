package com.mojang.rubydung.level;

/* JADX INFO: loaded from: pre-Classic rd-132211.jar:com/mojang/rubydung/level/Tile.class */
public class Tile {
    public static Tile rock = new Tile(0);
    public static Tile grass = new Tile(1);
    private int tex;

    private Tile(int tex) {
        this.tex = 0;
        this.tex = tex;
    }

    public void render(Tesselator t, Level level, int layer, int x, int y, int z) {
        float u0 = this.tex / 16.0f;
        float u1 = u0 + 0.0624375f;
        float v1 = 0.0f + 0.0624375f;
        float x0 = x + 0.0f;
        float x1 = x + 1.0f;
        float y0 = y + 0.0f;
        float y1 = y + 1.0f;
        float z0 = z + 0.0f;
        float z1 = z + 1.0f;
        if (!level.isSolidTile(x, y - 1, z)) {
            float br = level.getBrightness(x, y - 1, z) * 1.0f;
            if ((br == 1.0f) ^ (layer == 1)) {
                t.color(br, br, br);
                t.tex(u0, v1);
                t.vertex(x0, y0, z1);
                t.tex(u0, 0.0f);
                t.vertex(x0, y0, z0);
                t.tex(u1, 0.0f);
                t.vertex(x1, y0, z0);
                t.tex(u1, v1);
                t.vertex(x1, y0, z1);
            }
        }
        if (!level.isSolidTile(x, y + 1, z)) {
            float br2 = level.getBrightness(x, y, z) * 1.0f;
            if ((br2 == 1.0f) ^ (layer == 1)) {
                t.color(br2, br2, br2);
                t.tex(u1, v1);
                t.vertex(x1, y1, z1);
                t.tex(u1, 0.0f);
                t.vertex(x1, y1, z0);
                t.tex(u0, 0.0f);
                t.vertex(x0, y1, z0);
                t.tex(u0, v1);
                t.vertex(x0, y1, z1);
            }
        }
        if (!level.isSolidTile(x, y, z - 1)) {
            float br3 = level.getBrightness(x, y, z - 1) * 0.8f;
            if ((br3 == 0.8f) ^ (layer == 1)) {
                t.color(br3, br3, br3);
                t.tex(u1, 0.0f);
                t.vertex(x0, y1, z0);
                t.tex(u0, 0.0f);
                t.vertex(x1, y1, z0);
                t.tex(u0, v1);
                t.vertex(x1, y0, z0);
                t.tex(u1, v1);
                t.vertex(x0, y0, z0);
            }
        }
        if (!level.isSolidTile(x, y, z + 1)) {
            float br4 = level.getBrightness(x, y, z + 1) * 0.8f;
            if ((br4 == 0.8f) ^ (layer == 1)) {
                t.color(br4, br4, br4);
                t.tex(u0, 0.0f);
                t.vertex(x0, y1, z1);
                t.tex(u0, v1);
                t.vertex(x0, y0, z1);
                t.tex(u1, v1);
                t.vertex(x1, y0, z1);
                t.tex(u1, 0.0f);
                t.vertex(x1, y1, z1);
            }
        }
        if (!level.isSolidTile(x - 1, y, z)) {
            float br5 = level.getBrightness(x - 1, y, z) * 0.6f;
            if ((br5 == 0.6f) ^ (layer == 1)) {
                t.color(br5, br5, br5);
                t.tex(u1, 0.0f);
                t.vertex(x0, y1, z1);
                t.tex(u0, 0.0f);
                t.vertex(x0, y1, z0);
                t.tex(u0, v1);
                t.vertex(x0, y0, z0);
                t.tex(u1, v1);
                t.vertex(x0, y0, z1);
            }
        }
        if (!level.isSolidTile(x + 1, y, z)) {
            float br6 = level.getBrightness(x + 1, y, z) * 0.6f;
            if ((br6 == 0.6f) ^ (layer == 1)) {
                t.color(br6, br6, br6);
                t.tex(u0, v1);
                t.vertex(x1, y0, z1);
                t.tex(u1, v1);
                t.vertex(x1, y0, z0);
                t.tex(u1, 0.0f);
                t.vertex(x1, y1, z0);
                t.tex(u0, 0.0f);
                t.vertex(x1, y1, z1);
            }
        }
    }

    public void renderFace(Tesselator t, int x, int y, int z, int face) {
        float x0 = x + 0.0f;
        float x1 = x + 1.0f;
        float y0 = y + 0.0f;
        float y1 = y + 1.0f;
        float z0 = z + 0.0f;
        float z1 = z + 1.0f;
        if (face == 0) {
            t.vertex(x0, y0, z1);
            t.vertex(x0, y0, z0);
            t.vertex(x1, y0, z0);
            t.vertex(x1, y0, z1);
        }
        if (face == 1) {
            t.vertex(x1, y1, z1);
            t.vertex(x1, y1, z0);
            t.vertex(x0, y1, z0);
            t.vertex(x0, y1, z1);
        }
        if (face == 2) {
            t.vertex(x0, y1, z0);
            t.vertex(x1, y1, z0);
            t.vertex(x1, y0, z0);
            t.vertex(x0, y0, z0);
        }
        if (face == 3) {
            t.vertex(x0, y1, z1);
            t.vertex(x0, y0, z1);
            t.vertex(x1, y0, z1);
            t.vertex(x1, y1, z1);
        }
        if (face == 4) {
            t.vertex(x0, y1, z1);
            t.vertex(x0, y1, z0);
            t.vertex(x0, y0, z0);
            t.vertex(x0, y0, z1);
        }
        if (face == 5) {
            t.vertex(x1, y0, z1);
            t.vertex(x1, y0, z0);
            t.vertex(x1, y1, z0);
            t.vertex(x1, y1, z1);
        }
    }
}
