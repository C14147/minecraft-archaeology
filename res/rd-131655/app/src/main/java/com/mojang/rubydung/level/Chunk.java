package com.mojang.rubydung.level;

import com.mojang.rubydung.Textures;
import com.mojang.rubydung.phys.AABB;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/Chunk.class */
public class Chunk {
    private static final int TEXTURE = Textures.loadTexture("/terrain.png", GL11.GL_NEAREST);
    private static final Tessellator TESSELLATOR = new Tessellator();
    public static int rebuiltThisFrame;
    public static int updates;
    private final Level level;
    public AABB boundingBox;
    private final int minX;
    private final int minY;
    private final int minZ;
    private final int maxX;
    private final int maxY;
    private final int maxZ;
    private boolean dirty = true;
    private final int lists = GL11.glGenLists(2);

    public Chunk(Level level, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        this.level = level;
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.boundingBox = new AABB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public void rebuild(int layer) {
        if (rebuiltThisFrame == 2) {
            return;
        }
        updates++;
        rebuiltThisFrame++;
        this.dirty = false;
        GL11.glNewList(this.lists + layer, GL11.GL_COMPILE);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE, TEXTURE);
        TESSELLATOR.init();
        for (int x = this.minX; x < this.maxX; x++) {
            for (int y = this.minY; y < this.maxY; y++) {
                for (int z = this.minZ; z < this.maxZ; z++) {
                    if (this.level.isTile(x, y, z)) {
                        if (y > this.level.depth - 7 && this.level.getBrightness(x, y, z) == 1.0f) {
                            Tile.grass.render(TESSELLATOR, this.level, layer, x, y, z);
                        } else {
                            Tile.rock.render(TESSELLATOR, this.level, layer, x, y, z);
                        }
                    }
                }
            }
        }
        TESSELLATOR.flush();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEndList();
    }

    public void render(int layer) {
        if (this.dirty) {
            rebuild(0);
            rebuild(1);
        }
        GL11.glCallList(this.lists + layer);
    }

    public void setDirty() {
        this.dirty = true;
    }
}
