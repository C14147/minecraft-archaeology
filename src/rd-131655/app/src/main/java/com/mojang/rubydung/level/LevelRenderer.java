package com.mojang.rubydung.level;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:com/mojang/rubydung/level/LevelRenderer.class */
public class LevelRenderer {
    private static final int CHUNK_SIZE = 8;
    private final Chunk[] chunks;
    private final int chunkAmountX;
    private final int chunkAmountY;
    private final int chunkAmountZ;

    public LevelRenderer(Level level) {
        this.chunkAmountX = level.width / 8;
        this.chunkAmountY = level.depth / 8;
        this.chunkAmountZ = level.height / 8;
        this.chunks = new Chunk[this.chunkAmountX * this.chunkAmountY * this.chunkAmountZ];
        for (int x = 0; x < this.chunkAmountX; x++) {
            for (int y = 0; y < this.chunkAmountY; y++) {
                for (int z = 0; z < this.chunkAmountZ; z++) {
                    int minChunkX = x * 8;
                    int minChunkY = y * 8;
                    int minChunkZ = z * 8;
                    int maxChunkX = (x + 1) * 8;
                    int maxChunkY = (y + 1) * 8;
                    int maxChunkZ = (z + 1) * 8;
                    Chunk chunk = new Chunk(level, minChunkX, minChunkY, minChunkZ, Math.min(level.width, maxChunkX), Math.min(level.depth, maxChunkY), Math.min(level.height, maxChunkZ));
                    this.chunks[((x + (y * this.chunkAmountX)) * this.chunkAmountZ) + z] = chunk;
                }
            }
        }
    }

    public void render(int layer) {
        Frustum frustum = Frustum.getFrustum();
        Chunk.rebuiltThisFrame = 0;
        for (Chunk chunk : this.chunks) {
            if (frustum.cubeInFrustum(chunk.boundingBox)) {
                chunk.render(layer);
            }
        }
    }

    public void setDirty(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        int minX2 = Math.max(minX / 8, 0);
        int minY2 = Math.max(minY / 8, 0);
        int minZ2 = Math.max(minZ / 8, 0);
        int maxX2 = Math.min(maxX / 8, this.chunkAmountX - 1);
        int maxY2 = Math.min(maxY / 8, this.chunkAmountY - 1);
        int maxZ2 = Math.min(maxZ / 8, this.chunkAmountZ - 1);
        for (int x = minX2; x <= maxX2; x++) {
            for (int y = minY2; y <= maxY2; y++) {
                for (int z = minZ2; z <= maxZ2; z++) {
                    Chunk chunk = this.chunks[((x + (y * this.chunkAmountX)) * this.chunkAmountZ) + z];
                    chunk.setDirty();
                }
            }
        }
    }
}
