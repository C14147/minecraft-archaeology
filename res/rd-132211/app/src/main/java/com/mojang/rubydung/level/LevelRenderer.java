package com.mojang.rubydung.level;

import com.mojang.rubydung.HitResult;
import com.mojang.rubydung.Player;
import com.mojang.rubydung.phys.AABB;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: pre-Classic rd-132211.jar:com/mojang/rubydung/level/LevelRenderer.class */
public class LevelRenderer implements LevelListener {
    private static final int CHUNK_SIZE = 16;
    private Level level;
    private Chunk[] chunks;
    private int xChunks;
    private int yChunks;
    private int zChunks;
    Tesselator t = new Tesselator();

    public LevelRenderer(Level level) {
        this.level = level;
        level.addListener(this);
        this.xChunks = level.width / CHUNK_SIZE;
        this.yChunks = level.depth / CHUNK_SIZE;
        this.zChunks = level.height / CHUNK_SIZE;
        this.chunks = new Chunk[this.xChunks * this.yChunks * this.zChunks];
        for (int x = 0; x < this.xChunks; x++) {
            for (int y = 0; y < this.yChunks; y++) {
                for (int z = 0; z < this.zChunks; z++) {
                    int x0 = x * CHUNK_SIZE;
                    int y0 = y * CHUNK_SIZE;
                    int z0 = z * CHUNK_SIZE;
                    int x1 = (x + 1) * CHUNK_SIZE;
                    int y1 = (y + 1) * CHUNK_SIZE;
                    int z1 = (z + 1) * CHUNK_SIZE;
                    x1 = x1 > level.width ? level.width : x1;
                    y1 = y1 > level.depth ? level.depth : y1;
                    if (z1 > level.height) {
                        z1 = level.height;
                    }
                    this.chunks[((x + (y * this.xChunks)) * this.zChunks) + z] = new Chunk(level, x0, y0, z0, x1, y1, z1);
                }
            }
        }
    }

    public void render(Player player, int layer) {
        Chunk.rebuiltThisFrame = 0;
        Frustum frustum = Frustum.getFrustum();
        for (int i = 0; i < this.chunks.length; i++) {
            if (frustum.cubeInFrustum(this.chunks[i].aabb)) {
                this.chunks[i].render(layer);
            }
        }
    }

    public void pick(Player player) {
        AABB box = player.bb.grow(3.0f, 3.0f, 3.0f);
        int x0 = (int) box.x0;
        int x1 = (int) (box.x1 + 1.0f);
        int y0 = (int) box.y0;
        int y1 = (int) (box.y1 + 1.0f);
        int z0 = (int) box.z0;
        int z1 = (int) (box.z1 + 1.0f);
        GL11.glInitNames();
        for (int x = x0; x < x1; x++) {
            GL11.glPushName(x);
            for (int y = y0; y < y1; y++) {
                GL11.glPushName(y);
                for (int z = z0; z < z1; z++) {
                    GL11.glPushName(z);
                    if (this.level.isSolidTile(x, y, z)) {
                        GL11.glPushName(0);
                        for (int i = 0; i < 6; i++) {
                            GL11.glPushName(i);
                            this.t.init();
                            Tile.rock.renderFace(this.t, x, y, z, i);
                            this.t.flush();
                            GL11.glPopName();
                        }
                        GL11.glPopName();
                    }
                    GL11.glPopName();
                }
                GL11.glPopName();
            }
            GL11.glPopName();
        }
    }

    public void renderHit(HitResult h) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f);
        this.t.init();
        Tile.rock.renderFace(this.t, h.x, h.y, h.z, h.f);
        this.t.flush();
        GL11.glDisable(3042);
    }

    public void setDirty(int x0, int y0, int z0, int x1, int y1, int z1) {
        int x02 = x0 / CHUNK_SIZE;
        int x12 = x1 / CHUNK_SIZE;
        int y02 = y0 / CHUNK_SIZE;
        int y12 = y1 / CHUNK_SIZE;
        int z02 = z0 / CHUNK_SIZE;
        int z12 = z1 / CHUNK_SIZE;
        if (x02 < 0) {
            x02 = 0;
        }
        if (y02 < 0) {
            y02 = 0;
        }
        if (z02 < 0) {
            z02 = 0;
        }
        if (x12 >= this.xChunks) {
            x12 = this.xChunks - 1;
        }
        if (y12 >= this.yChunks) {
            y12 = this.yChunks - 1;
        }
        if (z12 >= this.zChunks) {
            z12 = this.zChunks - 1;
        }
        for (int x = x02; x <= x12; x++) {
            for (int y = y02; y <= y12; y++) {
                for (int z = z02; z <= z12; z++) {
                    this.chunks[((x + (y * this.xChunks)) * this.zChunks) + z].setDirty();
                }
            }
        }
    }

    @Override // com.mojang.rubydung.level.LevelListener
    public void tileChanged(int x, int y, int z) {
        setDirty(x - 1, y - 1, z - 1, x + 1, y + 1, z + 1);
    }

    @Override // com.mojang.rubydung.level.LevelListener
    public void lightColumnChanged(int x, int z, int y0, int y1) {
        setDirty(x - 1, y0 - 1, z - 1, x + 1, y1 + 1, z + 1);
    }

    @Override // com.mojang.rubydung.level.LevelListener
    public void allChanged() {
        setDirty(0, 0, 0, this.level.width, this.level.depth, this.level.height);
    }
}
