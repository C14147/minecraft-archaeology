package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.Player;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.particle.Particle;
import com.mojang.minecraft.particle.ParticleEngine;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Tesselator;
import java.util.Random;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/tile/Tile.class */
public class Tile {
    public static final int NOT_LIQUID = 0;
    public static final int LIQUID_WATER = 1;
    public static final int LIQUID_LAVA = 2;
    public static final Tile[] tiles = new Tile[256];
    public static final boolean[] shouldTick = new boolean[256];
    public static final Tile empty = null;
    public static final Tile rock = new Tile(1, 1);
    public static final Tile grass = new GrassTile(2);
    public static final Tile dirt = new DirtTile(3, 2);
    public static final Tile stoneBrick = new Tile(4, 16);
    public static final Tile wood = new Tile(5, 4);
    public static final Tile bush = new Bush(6);
    public static final Tile unbreakable = new Tile(7, 17);
    public static final Tile water = new LiquidTile(8, 1);
    public static final Tile calmWater = new CalmLiquidTile(9, 1);
    public static final Tile lava = new LiquidTile(10, 2);
    public static final Tile calmLava = new CalmLiquidTile(11, 2);
    public int tex;

    /* JADX INFO: renamed from: id */
    public final int f47id;
    protected float xx0;
    protected float yy0;
    protected float zz0;
    protected float xx1;
    protected float yy1;
    protected float zz1;

    protected Tile(int id) {
        tiles[id] = this;
        this.f47id = id;
        setShape(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    protected void setTicking(boolean tick) {
        shouldTick[this.f47id] = tick;
    }

    protected void setShape(float x0, float y0, float z0, float x1, float y1, float z1) {
        this.xx0 = x0;
        this.yy0 = y0;
        this.zz0 = z0;
        this.xx1 = x1;
        this.yy1 = y1;
        this.zz1 = z1;
    }

    protected Tile(int id, int tex) {
        this(id);
        this.tex = tex;
    }

    public void render(Tesselator t, Level level, int layer, int x, int y, int z) {
        if (shouldRenderFace(level, x, y - 1, z, layer, 0)) {
            t.color((byte) -1, (byte) -1, (byte) -1);
            renderFace(t, x, y, z, 0);
        }
        if (shouldRenderFace(level, x, y + 1, z, layer, 1)) {
            t.color((byte) -1, (byte) -1, (byte) -1);
            renderFace(t, x, y, z, 1);
        }
        if (shouldRenderFace(level, x, y, z - 1, layer, 2)) {
            t.color((byte) -52, (byte) -52, (byte) -52);
            renderFace(t, x, y, z, 2);
        }
        if (shouldRenderFace(level, x, y, z + 1, layer, 3)) {
            t.color((byte) -52, (byte) -52, (byte) -52);
            renderFace(t, x, y, z, 3);
        }
        if (shouldRenderFace(level, x - 1, y, z, layer, 4)) {
            t.color((byte) -103, (byte) -103, (byte) -103);
            renderFace(t, x, y, z, 4);
        }
        if (shouldRenderFace(level, x + 1, y, z, layer, 5)) {
            t.color((byte) -103, (byte) -103, (byte) -103);
            renderFace(t, x, y, z, 5);
        }
    }

    protected boolean shouldRenderFace(Level level, int x, int y, int z, int layer, int face) {
        boolean layerOk = true;
        if (layer == 2) {
            return false;
        }
        if (layer >= 0) {
            layerOk = level.isLit(x, y, z) ^ (layer == 1);
        }
        return !level.isSolidTile(x, y, z) && layerOk;
    }

    protected int getTexture(int face) {
        return this.tex;
    }

    public void renderFace(Tesselator t, int x, int y, int z, int face) {
        int tex = getTexture(face);
        int xt = (tex % 16) * 16;
        int yt = (tex / 16) * 16;
        float u0 = xt / 256.0f;
        float u1 = (xt + 15.99f) / 256.0f;
        float v0 = yt / 256.0f;
        float v1 = (yt + 15.99f) / 256.0f;
        float x0 = x + this.xx0;
        float x1 = x + this.xx1;
        float y0 = y + this.yy0;
        float y1 = y + this.yy1;
        float z0 = z + this.zz0;
        float z1 = z + this.zz1;
        if (face == 0) {
            t.vertexUV(x0, y0, z1, u0, v1);
            t.vertexUV(x0, y0, z0, u0, v0);
            t.vertexUV(x1, y0, z0, u1, v0);
            t.vertexUV(x1, y0, z1, u1, v1);
            return;
        }
        if (face == 1) {
            t.vertexUV(x1, y1, z1, u1, v1);
            t.vertexUV(x1, y1, z0, u1, v0);
            t.vertexUV(x0, y1, z0, u0, v0);
            t.vertexUV(x0, y1, z1, u0, v1);
            return;
        }
        if (face == 2) {
            t.vertexUV(x0, y1, z0, u1, v0);
            t.vertexUV(x1, y1, z0, u0, v0);
            t.vertexUV(x1, y0, z0, u0, v1);
            t.vertexUV(x0, y0, z0, u1, v1);
            return;
        }
        if (face == 3) {
            t.vertexUV(x0, y1, z1, u0, v0);
            t.vertexUV(x0, y0, z1, u0, v1);
            t.vertexUV(x1, y0, z1, u1, v1);
            t.vertexUV(x1, y1, z1, u1, v0);
            return;
        }
        if (face == 4) {
            t.vertexUV(x0, y1, z1, u1, v0);
            t.vertexUV(x0, y1, z0, u0, v0);
            t.vertexUV(x0, y0, z0, u0, v1);
            t.vertexUV(x0, y0, z1, u1, v1);
            return;
        }
        if (face == 5) {
            t.vertexUV(x1, y0, z1, u0, v1);
            t.vertexUV(x1, y0, z0, u1, v1);
            t.vertexUV(x1, y1, z0, u1, v0);
            t.vertexUV(x1, y1, z1, u0, v0);
        }
    }

    public void renderBackFace(Tesselator t, int x, int y, int z, int face) {
        int tex = getTexture(face);
        float u0 = (tex % 16) / 16.0f;
        float u1 = u0 + 0.0624375f;
        float v0 = (tex / 16) / 16.0f;
        float v1 = v0 + 0.0624375f;
        float x0 = x + this.xx0;
        float x1 = x + this.xx1;
        float y0 = y + this.yy0;
        float y1 = y + this.yy1;
        float z0 = z + this.zz0;
        float z1 = z + this.zz1;
        if (face == 0) {
            t.vertexUV(x1, y0, z1, u1, v1);
            t.vertexUV(x1, y0, z0, u1, v0);
            t.vertexUV(x0, y0, z0, u0, v0);
            t.vertexUV(x0, y0, z1, u0, v1);
        }
        if (face == 1) {
            t.vertexUV(x0, y1, z1, u0, v1);
            t.vertexUV(x0, y1, z0, u0, v0);
            t.vertexUV(x1, y1, z0, u1, v0);
            t.vertexUV(x1, y1, z1, u1, v1);
        }
        if (face == 2) {
            t.vertexUV(x0, y0, z0, u1, v1);
            t.vertexUV(x1, y0, z0, u0, v1);
            t.vertexUV(x1, y1, z0, u0, v0);
            t.vertexUV(x0, y1, z0, u1, v0);
        }
        if (face == 3) {
            t.vertexUV(x1, y1, z1, u1, v0);
            t.vertexUV(x1, y0, z1, u1, v1);
            t.vertexUV(x0, y0, z1, u0, v1);
            t.vertexUV(x0, y1, z1, u0, v0);
        }
        if (face == 4) {
            t.vertexUV(x0, y0, z1, u1, v1);
            t.vertexUV(x0, y0, z0, u0, v1);
            t.vertexUV(x0, y1, z0, u0, v0);
            t.vertexUV(x0, y1, z1, u1, v0);
        }
        if (face == 5) {
            t.vertexUV(x1, y1, z1, u0, v0);
            t.vertexUV(x1, y1, z0, u1, v0);
            t.vertexUV(x1, y0, z0, u1, v1);
            t.vertexUV(x1, y0, z1, u0, v1);
        }
    }

    public void renderFaceNoTexture(Player player, Tesselator t, int x, int y, int z, int face) {
        float x0 = x + 0.0f;
        float x1 = x + 1.0f;
        float y0 = y + 0.0f;
        float y1 = y + 1.0f;
        float z0 = z + 0.0f;
        float z1 = z + 1.0f;
        if (face == 0 && y > player.f4y) {
            t.vertex(x0, y0, z1);
            t.vertex(x0, y0, z0);
            t.vertex(x1, y0, z0);
            t.vertex(x1, y0, z1);
        }
        if (face == 1 && y < player.f4y) {
            t.vertex(x1, y1, z1);
            t.vertex(x1, y1, z0);
            t.vertex(x0, y1, z0);
            t.vertex(x0, y1, z1);
        }
        if (face == 2 && z > player.f5z) {
            t.vertex(x0, y1, z0);
            t.vertex(x1, y1, z0);
            t.vertex(x1, y0, z0);
            t.vertex(x0, y0, z0);
        }
        if (face == 3 && z < player.f5z) {
            t.vertex(x0, y1, z1);
            t.vertex(x0, y0, z1);
            t.vertex(x1, y0, z1);
            t.vertex(x1, y1, z1);
        }
        if (face == 4 && x > player.f3x) {
            t.vertex(x0, y1, z1);
            t.vertex(x0, y1, z0);
            t.vertex(x0, y0, z0);
            t.vertex(x0, y0, z1);
        }
        if (face == 5 && x < player.f3x) {
            t.vertex(x1, y0, z1);
            t.vertex(x1, y0, z0);
            t.vertex(x1, y1, z0);
            t.vertex(x1, y1, z1);
        }
    }

    public final AABB getTileAABB(int x, int y, int z) {
        return new AABB(x, y, z, x + 1, y + 1, z + 1);
    }

    public AABB getAABB(int x, int y, int z) {
        return new AABB(x, y, z, x + 1, y + 1, z + 1);
    }

    public boolean blocksLight() {
        return true;
    }

    public boolean isSolid() {
        return true;
    }

    public boolean mayPick() {
        return true;
    }

    public void tick(Level level, int x, int y, int z, Random random) {
    }

    public void destroy(Level level, int x, int y, int z, ParticleEngine particleEngine) {
        for (int xx = 0; xx < 4; xx++) {
            for (int yy = 0; yy < 4; yy++) {
                for (int zz = 0; zz < 4; zz++) {
                    float xp = x + ((xx + 0.5f) / 4);
                    float yp = y + ((yy + 0.5f) / 4);
                    float zp = z + ((zz + 0.5f) / 4);
                    particleEngine.add(new Particle(level, xp, yp, zp, (xp - x) - 0.5f, (yp - y) - 0.5f, (zp - z) - 0.5f, this.tex));
                }
            }
        }
    }

    public int getLiquidType() {
        return 0;
    }

    public void neighborChanged(Level level, int x, int y, int z, int type) {
    }
}
