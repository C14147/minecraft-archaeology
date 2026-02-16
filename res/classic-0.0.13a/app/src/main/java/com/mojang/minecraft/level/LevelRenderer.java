package com.mojang.minecraft.level;

import com.mojang.minecraft.HitResult;
import com.mojang.minecraft.Player;
import com.mojang.minecraft.level.tile.Tile;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.renderer.Frustum;
import com.mojang.minecraft.renderer.Tesselator;
import com.mojang.minecraft.renderer.Textures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/level/LevelRenderer.class */
public class LevelRenderer implements LevelListener {
    public static final int MAX_REBUILDS_PER_FRAME = 4;
    public static final int CHUNK_SIZE = 16;
    private Level level;
    private Chunk[] chunks;
    private Chunk[] sortedChunks;
    private int xChunks;
    private int yChunks;
    private int zChunks;
    private Textures textures;
    private int surroundLists;
    private int drawDistance = 0;

    /* JADX INFO: renamed from: lX */
    float f43lX = 0.0f;

    /* JADX INFO: renamed from: lY */
    float f44lY = 0.0f;

    /* JADX INFO: renamed from: lZ */
    float f45lZ = 0.0f;

    public LevelRenderer(Level level, Textures textures) {
        this.level = level;
        this.textures = textures;
        level.addListener(this);
        this.surroundLists = GL11.glGenLists(2);
        allChanged();
    }

    @Override // com.mojang.minecraft.level.LevelListener
    public void allChanged() {
        this.f43lX = -900000.0f;
        this.f44lY = -900000.0f;
        this.f45lZ = -900000.0f;
        this.xChunks = ((this.level.width + 16) - 1) / 16;
        this.yChunks = ((this.level.depth + 16) - 1) / 16;
        this.zChunks = ((this.level.height + 16) - 1) / 16;
        this.chunks = new Chunk[this.xChunks * this.yChunks * this.zChunks];
        this.sortedChunks = new Chunk[this.xChunks * this.yChunks * this.zChunks];
        for (int x = 0; x < this.xChunks; x++) {
            for (int y = 0; y < this.yChunks; y++) {
                for (int z = 0; z < this.zChunks; z++) {
                    int x0 = x * 16;
                    int y0 = y * 16;
                    int z0 = z * 16;
                    int x1 = (x + 1) * 16;
                    int y1 = (y + 1) * 16;
                    int z1 = (z + 1) * 16;
                    if (x1 > this.level.width) {
                        x1 = this.level.width;
                    }
                    if (y1 > this.level.depth) {
                        y1 = this.level.depth;
                    }
                    if (z1 > this.level.height) {
                        z1 = this.level.height;
                    }
                    this.chunks[((x + (y * this.xChunks)) * this.zChunks) + z] = new Chunk(this.level, x0, y0, z0, x1, y1, z1);
                    this.sortedChunks[((x + (y * this.xChunks)) * this.zChunks) + z] = this.chunks[((x + (y * this.xChunks)) * this.zChunks) + z];
                }
            }
        }
        GL11.glNewList(this.surroundLists + 0, 4864);
        compileSurroundingGround();
        GL11.glEndList();
        GL11.glNewList(this.surroundLists + 1, 4864);
        compileSurroundingWater();
        GL11.glEndList();
        for (int i = 0; i < this.chunks.length; i++) {
            this.chunks[i].reset();
        }
    }

    public List<Chunk> getAllDirtyChunks() {
        ArrayList<Chunk> dirty = null;
        for (int i = 0; i < this.chunks.length; i++) {
            Chunk chunk = this.chunks[i];
            if (chunk.isDirty()) {
                if (dirty == null) {
                    dirty = new ArrayList<>();
                }
                dirty.add(chunk);
            }
        }
        return dirty;
    }

    public void render(Player player, int layer) {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.textures.loadTexture("/terrain.png", 9728));
        float xd = player.f3x - this.f43lX;
        float yd = player.f4y - this.f44lY;
        float zd = player.f5z - this.f45lZ;
        if ((xd * xd) + (yd * yd) + (zd * zd) > 64.0f) {
            this.f43lX = player.f3x;
            this.f44lY = player.f4y;
            this.f45lZ = player.f5z;
            Arrays.sort(this.sortedChunks, new DistanceSorter(player));
        }
        for (int i = 0; i < this.sortedChunks.length; i++) {
            if (this.sortedChunks[i].visible) {
                float dd = 256 / (1 << this.drawDistance);
                if (this.drawDistance == 0 || this.sortedChunks[i].distanceToSqr(player) < dd * dd) {
                    this.sortedChunks[i].render(layer);
                }
            }
        }
        GL11.glDisable(3553);
    }

    public void renderSurroundingGround() {
        GL11.glCallList(this.surroundLists + 0);
    }

    public void compileSurroundingGround() {
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.textures.loadTexture("/rock.png", 9728));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Tesselator t = Tesselator.instance;
        float y = this.level.getGroundLevel() - 2.0f;
        int s = 128;
        if (128 > this.level.width) {
            s = this.level.width;
        }
        if (s > this.level.height) {
            s = this.level.height;
        }
        t.begin();
        int i = (-s) * 5;
        while (true) {
            int xx = i;
            if (xx >= this.level.width + (s * 5)) {
                break;
            }
            int i2 = (-s) * 5;
            while (true) {
                int zz = i2;
                if (zz >= this.level.height + (s * 5)) {
                    break;
                }
                float yy = y;
                if (xx >= 0 && zz >= 0 && xx < this.level.width && zz < this.level.height) {
                    yy = 0.0f;
                }
                t.vertexUV(xx + 0, yy, zz + s, 0.0f, s);
                t.vertexUV(xx + s, yy, zz + s, s, s);
                t.vertexUV(xx + s, yy, zz + 0, s, 0.0f);
                t.vertexUV(xx + 0, yy, zz + 0, 0.0f, 0.0f);
                i2 = zz + s;
            }
            i = xx + s;
        }
        t.end();
        GL11.glBindTexture(3553, this.textures.loadTexture("/rock.png", 9728));
        GL11.glColor3f(0.8f, 0.8f, 0.8f);
        t.begin();
        int i3 = 0;
        while (true) {
            int xx2 = i3;
            if (xx2 >= this.level.width) {
                break;
            }
            t.vertexUV(xx2 + 0, 0.0f, 0.0f, 0.0f, 0.0f);
            t.vertexUV(xx2 + s, 0.0f, 0.0f, s, 0.0f);
            t.vertexUV(xx2 + s, y, 0.0f, s, y);
            t.vertexUV(xx2 + 0, y, 0.0f, 0.0f, y);
            t.vertexUV(xx2 + 0, y, this.level.height, 0.0f, y);
            t.vertexUV(xx2 + s, y, this.level.height, s, y);
            t.vertexUV(xx2 + s, 0.0f, this.level.height, s, 0.0f);
            t.vertexUV(xx2 + 0, 0.0f, this.level.height, 0.0f, 0.0f);
            i3 = xx2 + s;
        }
        GL11.glColor3f(0.6f, 0.6f, 0.6f);
        int i4 = 0;
        while (true) {
            int zz2 = i4;
            if (zz2 < this.level.height) {
                t.vertexUV(0.0f, y, zz2 + 0, 0.0f, 0.0f);
                t.vertexUV(0.0f, y, zz2 + s, s, 0.0f);
                t.vertexUV(0.0f, 0.0f, zz2 + s, s, y);
                t.vertexUV(0.0f, 0.0f, zz2 + 0, 0.0f, y);
                t.vertexUV(this.level.width, 0.0f, zz2 + 0, 0.0f, y);
                t.vertexUV(this.level.width, 0.0f, zz2 + s, s, y);
                t.vertexUV(this.level.width, y, zz2 + s, s, 0.0f);
                t.vertexUV(this.level.width, y, zz2 + 0, 0.0f, 0.0f);
                i4 = zz2 + s;
            } else {
                t.end();
                GL11.glDisable(3042);
                GL11.glDisable(3553);
                return;
            }
        }
    }

    public void renderSurroundingWater() {
        GL11.glCallList(this.surroundLists + 1);
    }

    public void compileSurroundingWater() {
        GL11.glEnable(3553);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.textures.loadTexture("/water.png", 9728));
        float y = this.level.getGroundLevel();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Tesselator t = Tesselator.instance;
        int s = 128;
        if (128 > this.level.width) {
            s = this.level.width;
        }
        if (s > this.level.height) {
            s = this.level.height;
        }
        t.begin();
        int i = (-s) * 5;
        while (true) {
            int xx = i;
            if (xx < this.level.width + (s * 5)) {
                int i2 = (-s) * 5;
                while (true) {
                    int zz = i2;
                    if (zz >= this.level.height + (s * 5)) {
                        break;
                    }
                    float yy = y - 0.1f;
                    if (xx < 0 || zz < 0 || xx >= this.level.width || zz >= this.level.height) {
                        t.vertexUV(xx + 0, yy, zz + s, 0.0f, s);
                        t.vertexUV(xx + s, yy, zz + s, s, s);
                        t.vertexUV(xx + s, yy, zz + 0, s, 0.0f);
                        t.vertexUV(xx + 0, yy, zz + 0, 0.0f, 0.0f);
                        t.vertexUV(xx + 0, yy, zz + 0, 0.0f, 0.0f);
                        t.vertexUV(xx + s, yy, zz + 0, s, 0.0f);
                        t.vertexUV(xx + s, yy, zz + s, s, s);
                        t.vertexUV(xx + 0, yy, zz + s, 0.0f, s);
                    }
                    i2 = zz + s;
                }
                i = xx + s;
            } else {
                t.end();
                GL11.glDisable(3042);
                GL11.glDisable(3553);
                return;
            }
        }
    }

    public void updateDirtyChunks(Player player) {
        List<Chunk> dirty = getAllDirtyChunks();
        if (dirty == null) {
            return;
        }
        Collections.sort(dirty, new DirtyChunkSorter(player));
        for (int i = 0; i < 4 && i < dirty.size(); i++) {
            dirty.get(i).rebuild();
        }
    }

    public void pick(Player player, Frustum frustum) {
        Tesselator t = Tesselator.instance;
        AABB box = player.f9bb.grow(2.5f, 2.5f, 2.5f);
        int x0 = (int) box.f53x0;
        int x1 = (int) (box.f56x1 + 1.0f);
        int y0 = (int) box.f54y0;
        int y1 = (int) (box.f57y1 + 1.0f);
        int z0 = (int) box.f55z0;
        int z1 = (int) (box.f58z1 + 1.0f);
        GL11.glInitNames();
        GL11.glPushName(0);
        GL11.glPushName(0);
        for (int x = x0; x < x1; x++) {
            GL11.glLoadName(x);
            GL11.glPushName(0);
            for (int y = y0; y < y1; y++) {
                GL11.glLoadName(y);
                GL11.glPushName(0);
                for (int z = z0; z < z1; z++) {
                    Tile tile = Tile.tiles[this.level.getTile(x, y, z)];
                    if (tile != null && tile.mayPick() && frustum.isVisible(tile.getTileAABB(x, y, z))) {
                        GL11.glLoadName(z);
                        GL11.glPushName(0);
                        for (int i = 0; i < 6; i++) {
                            GL11.glLoadName(i);
                            t.begin();
                            tile.renderFaceNoTexture(player, t, x, y, z, i);
                            t.end();
                        }
                        GL11.glPopName();
                    }
                }
                GL11.glPopName();
            }
            GL11.glPopName();
        }
        GL11.glPopName();
        GL11.glPopName();
    }

    public void renderHit(Player player, HitResult h, int mode, int tileType) {
        Tesselator t = Tesselator.instance;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, ((((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.4f) * 0.5f);
        if (mode == 0) {
            t.begin();
            for (int i = 0; i < 6; i++) {
                Tile.rock.renderFaceNoTexture(player, t, h.f10x, h.f11y, h.f12z, i);
            }
            t.end();
        } else {
            GL11.glBlendFunc(770, 771);
            float br = (((float) Math.sin(System.currentTimeMillis() / 100.0d)) * 0.2f) + 0.8f;
            GL11.glColor4f(br, br, br, (((float) Math.sin(System.currentTimeMillis() / 200.0d)) * 0.2f) + 0.5f);
            GL11.glEnable(3553);
            int id = this.textures.loadTexture("/terrain.png", 9728);
            GL11.glBindTexture(3553, id);
            int x = h.f10x;
            int y = h.f11y;
            int z = h.f12z;
            if (h.f13f == 0) {
                y--;
            }
            if (h.f13f == 1) {
                y++;
            }
            if (h.f13f == 2) {
                z--;
            }
            if (h.f13f == 3) {
                z++;
            }
            if (h.f13f == 4) {
                x--;
            }
            if (h.f13f == 5) {
                x++;
            }
            t.begin();
            t.noColor();
            Tile.tiles[tileType].render(t, this.level, 0, x, y, z);
            Tile.tiles[tileType].render(t, this.level, 1, x, y, z);
            t.end();
            GL11.glDisable(3553);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void renderHitOutline(Player player, HitResult h, int mode, int tileType) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
        float x = h.f10x;
        float y = h.f11y;
        float z = h.f12z;
        if (mode == 1) {
            if (h.f13f == 0) {
                y -= 1.0f;
            }
            if (h.f13f == 1) {
                y += 1.0f;
            }
            if (h.f13f == 2) {
                z -= 1.0f;
            }
            if (h.f13f == 3) {
                z += 1.0f;
            }
            if (h.f13f == 4) {
                x -= 1.0f;
            }
            if (h.f13f == 5) {
                x += 1.0f;
            }
        }
        GL11.glBegin(3);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1.0f, y, z);
        GL11.glVertex3f(x + 1.0f, y, z + 1.0f);
        GL11.glVertex3f(x, y, z + 1.0f);
        GL11.glVertex3f(x, y, z);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glVertex3f(x, y + 1.0f, z);
        GL11.glVertex3f(x + 1.0f, y + 1.0f, z);
        GL11.glVertex3f(x + 1.0f, y + 1.0f, z + 1.0f);
        GL11.glVertex3f(x, y + 1.0f, z + 1.0f);
        GL11.glVertex3f(x, y + 1.0f, z);
        GL11.glEnd();
        GL11.glBegin(1);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x, y + 1.0f, z);
        GL11.glVertex3f(x + 1.0f, y, z);
        GL11.glVertex3f(x + 1.0f, y + 1.0f, z);
        GL11.glVertex3f(x + 1.0f, y, z + 1.0f);
        GL11.glVertex3f(x + 1.0f, y + 1.0f, z + 1.0f);
        GL11.glVertex3f(x, y, z + 1.0f);
        GL11.glVertex3f(x, y + 1.0f, z + 1.0f);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    public void setDirty(int x0, int y0, int z0, int x1, int y1, int z1) {
        int x02 = x0 / 16;
        int x12 = x1 / 16;
        int y02 = y0 / 16;
        int y12 = y1 / 16;
        int z02 = z0 / 16;
        int z12 = z1 / 16;
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

    @Override // com.mojang.minecraft.level.LevelListener
    public void tileChanged(int x, int y, int z) {
        setDirty(x - 1, y - 1, z - 1, x + 1, y + 1, z + 1);
    }

    @Override // com.mojang.minecraft.level.LevelListener
    public void lightColumnChanged(int x, int z, int y0, int y1) {
        setDirty(x - 1, y0 - 1, z - 1, x + 1, y1 + 1, z + 1);
    }

    public void toggleDrawDistance() {
        this.drawDistance = (this.drawDistance + 1) % 4;
    }

    public void cull(Frustum frustum) {
        for (int i = 0; i < this.chunks.length; i++) {
            this.chunks[i].visible = frustum.isVisible(this.chunks[i].aabb);
        }
    }
}
