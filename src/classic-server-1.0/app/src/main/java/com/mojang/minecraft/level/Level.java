package com.mojang.minecraft.level;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.p003a.C0008b;
import com.mojang.minecraft.level.p006c.C0024a;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.server.MinecraftServer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/Level.class */
public class Level implements Serializable {
    public static final long serialVersionUID = 0;
    public int width;
    public int height;
    public int depth;
    public byte[] blocks;
    public String name;
    public String creator;
    public long createTime;
    public int xSpawn;
    public int ySpawn;
    public int zSpawn;
    public float rotSpawn;

    /* JADX INFO: renamed from: b */
    private transient int[] f44b;

    /* JADX INFO: renamed from: a */
    private transient ArrayList f43a = new ArrayList();

    /* JADX INFO: renamed from: c */
    private transient Random f45c = new Random();

    /* JADX INFO: renamed from: d */
    private transient int f46d = this.f45c.nextInt();

    /* JADX INFO: renamed from: e */
    private transient ArrayList f47e = new ArrayList();
    public ArrayList entities = new ArrayList();
    private boolean networkMode = false;
    int unprocessed = 0;
    private int tickCount = 0;

    public void initTransient() {
        if (this.blocks == null) {
            throw new RuntimeException("The level is corrupt!");
        }
        this.f43a = new ArrayList();
        this.f44b = new int[this.width * this.height];
        Arrays.fill(this.f44b, this.depth);
        calcLightDepths(0, 0, this.width, this.height);
        this.f45c = new Random();
        this.f46d = this.f45c.nextInt();
        this.f47e = new ArrayList();
        if (this.entities == null) {
            this.entities = new ArrayList();
        }
        if (this.xSpawn == 0 && this.ySpawn == 0 && this.zSpawn == 0) {
            findSpawn();
        }
    }

    public void setData(int i, int i2, int i3, byte[] bArr) {
        this.width = i;
        this.height = i3;
        this.depth = i2;
        this.blocks = bArr;
        this.f44b = new int[i * i3];
        Arrays.fill(this.f44b, this.depth);
        calcLightDepths(0, 0, i, i3);
        for (int i4 = 0; i4 < this.f43a.size(); i4++) {
            this.f43a.get(i4);
        }
        this.f47e.clear();
        findSpawn();
        System.gc();
    }

    public void findSpawn() {
        int iNextInt;
        int iNextInt2;
        int highestTile;
        Random random = new Random();
        int i = 0;
        do {
            i++;
            iNextInt = random.nextInt(this.width / 2) + (this.width / 4);
            iNextInt2 = random.nextInt(this.height / 2) + (this.height / 4);
            highestTile = getHighestTile(iNextInt, iNextInt2) + 1;
            if (i == 10000) {
                this.xSpawn = iNextInt;
                this.ySpawn = -100;
                this.zSpawn = iNextInt2;
                return;
            }
        } while (highestTile <= getWaterLevel());
        this.xSpawn = iNextInt;
        this.ySpawn = highestTile;
        this.zSpawn = iNextInt2;
    }

    public void calcLightDepths(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                int i7 = this.f44b[i5 + (i6 * this.width)];
                int i8 = this.depth - 1;
                while (i8 > 0 && !isLightBlocker(i5, i8, i6)) {
                    i8--;
                }
                this.f44b[i5 + (i6 * this.width)] = i8 + 1;
                if (i7 != i8) {
                    for (int i9 = 0; i9 < this.f43a.size(); i9++) {
                        this.f43a.get(i9);
                    }
                }
            }
        }
    }

    public void addListener$74652038(MinecraftServer minecraftServer) {
        this.f43a.add(minecraftServer);
    }

    public void finalize() {
    }

    public void removeListener$74652038(MinecraftServer minecraftServer) {
        this.f43a.remove(minecraftServer);
    }

    public boolean isLightBlocker(int i, int i2, int i3) {
        C0008b c0008b = C0008b.f49a[getTile(i, i2, i3)];
        if (c0008b == null) {
            return false;
        }
        return c0008b.mo10a();
    }

    public ArrayList getCubes(AABB aabb) {
        AABB aabbMo9a;
        AABB aabbMo9a2;
        ArrayList arrayList = new ArrayList();
        int i = (int) aabb.f96x0;
        int i2 = ((int) aabb.f99x1) + 1;
        int i3 = (int) aabb.f97y0;
        int i4 = ((int) aabb.f100y1) + 1;
        int i5 = (int) aabb.f98z0;
        int i6 = ((int) aabb.f101z1) + 1;
        if (aabb.f96x0 < 0.0f) {
            i--;
        }
        if (aabb.f97y0 < 0.0f) {
            i3--;
        }
        if (aabb.f98z0 < 0.0f) {
            i5--;
        }
        for (int i7 = i; i7 < i2; i7++) {
            for (int i8 = i3; i8 < i4; i8++) {
                for (int i9 = i5; i9 < i6; i9++) {
                    if (i7 >= 0 && i8 >= 0 && i9 >= 0 && i7 < this.width && i8 < this.depth && i9 < this.height) {
                        C0008b c0008b = C0008b.f49a[getTile(i7, i8, i9)];
                        if (c0008b != null && (aabbMo9a2 = c0008b.mo9a(i7, i8, i9)) != null) {
                            arrayList.add(aabbMo9a2);
                        }
                    } else if ((i7 < 0 || i8 < 0 || i9 < 0 || i7 >= this.width || i9 >= this.height) && (aabbMo9a = C0008b.f57h.mo9a(i7, i8, i9)) != null) {
                        arrayList.add(aabbMo9a);
                    }
                }
            }
        }
        return arrayList;
    }

    public void swap(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.networkMode) {
            return;
        }
        int tile = getTile(i, i2, i3);
        int tile2 = getTile(i4, i5, i6);
        setTileNoNeighborChange(i, i2, i3, tile2);
        setTileNoNeighborChange(i4, i5, i6, tile);
        updateNeighborsAt(i, i2, i3, tile2);
        updateNeighborsAt(i4, i5, i6, tile);
    }

    public boolean setTileNoNeighborChange(int i, int i2, int i3, int i4) {
        if (this.networkMode) {
            return false;
        }
        return netSetTileNoNeighborChange(i, i2, i3, i4);
    }

    public boolean netSetTileNoNeighborChange(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        if (i4 == 0 && ((i == 0 || i3 == 0 || i == this.width - 1 || i3 == this.height - 1) && i2 >= getGroundLevel() && i2 < getWaterLevel())) {
            i4 = C0008b.f58i.f71v;
        }
        byte b = this.blocks[(((i2 * this.height) + i3) * this.width) + i];
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        if (b != 0) {
            C0008b.f49a[b].mo19c(this, i, i2, i3);
        }
        if (i4 != 0) {
            C0008b.f49a[i4].mo18b(this, i, i2, i3);
        }
        calcLightDepths(i, i3, 1, 1);
        for (int i5 = 0; i5 < this.f43a.size(); i5++) {
            ((MinecraftServer) this.f43a.get(i5)).m45a(i, i2, i3);
        }
        return true;
    }

    public boolean setTile(int i, int i2, int i3, int i4) {
        if (this.networkMode || !setTileNoNeighborChange(i, i2, i3, i4)) {
            return false;
        }
        updateNeighborsAt(i, i2, i3, i4);
        return true;
    }

    public boolean netSetTile(int i, int i2, int i3, int i4) {
        if (!netSetTileNoNeighborChange(i, i2, i3, i4)) {
            return false;
        }
        updateNeighborsAt(i, i2, i3, i4);
        return true;
    }

    public void updateNeighborsAt(int i, int i2, int i3, int i4) {
        m3a(i - 1, i2, i3, i4);
        m3a(i + 1, i2, i3, i4);
        m3a(i, i2 - 1, i3, i4);
        m3a(i, i2 + 1, i3, i4);
        m3a(i, i2, i3 - 1, i4);
        m3a(i, i2, i3 + 1, i4);
    }

    public boolean setTileNoUpdate(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m3a(int i, int i2, int i3, int i4) {
        C0008b c0008b;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || (c0008b = C0008b.f49a[this.blocks[(((i2 * this.height) + i3) * this.width) + i]]) == null) {
            return;
        }
        c0008b.mo15a(this, i, i2, i3, i4);
    }

    public boolean isLit(int i, int i2, int i3) {
        return i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i2 >= this.f44b[i + (i3 * this.width)];
    }

    public int getTile(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height) {
            return 0;
        }
        return this.blocks[(((i2 * this.height) + i3) * this.width) + i] & 255;
    }

    public boolean isSolidTile(int i, int i2, int i3) {
        C0008b c0008b = C0008b.f49a[getTile(i, i2, i3)];
        if (c0008b == null) {
            return false;
        }
        return c0008b.mo11b();
    }

    public void tickEntities() {
        int i = 0;
        while (i < this.entities.size()) {
            ((Entity) this.entities.get(i)).tick();
            if (((Entity) this.entities.get(i)).removed) {
                int i2 = i;
                i--;
                this.entities.remove(i2);
            }
            i++;
        }
    }

    public void tick() {
        byte b;
        this.tickCount++;
        int i = 1;
        int i2 = 1;
        while ((1 << i) < this.width) {
            i++;
        }
        while ((1 << i2) < this.height) {
            i2++;
        }
        int i3 = this.height - 1;
        int i4 = this.width - 1;
        int i5 = this.depth - 1;
        if (this.tickCount % 5 == 0) {
            int size = this.f47e.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0018b c0018b = (C0018b) this.f47e.remove(0);
                if (c0018b.f79e > 0) {
                    c0018b.f79e--;
                    this.f47e.add(c0018b);
                } else if (m4a(c0018b.f75a, c0018b.f76b, c0018b.f77c) && (b = this.blocks[(((c0018b.f76b * this.height) + c0018b.f77c) * this.width) + c0018b.f75a]) == c0018b.f78d && b > 0) {
                    C0008b.f49a[b].mo8a(this, c0018b.f75a, c0018b.f76b, c0018b.f77c, this.f45c);
                }
            }
        }
        this.unprocessed += this.width * this.height * this.depth;
        int i7 = this.unprocessed / 200;
        this.unprocessed -= i7 * 200;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f46d = (this.f46d * 3) + 1013904223;
            int i9 = this.f46d >> 2;
            int i10 = i9 & i4;
            int i11 = (i9 >> i) & i3;
            int i12 = (i9 >> (i + i2)) & i5;
            byte b2 = this.blocks[(((i12 * this.height) + i11) * this.width) + i10];
            if (C0008b.f50b[b2]) {
                C0008b.f49a[b2].mo8a(this, i10, i12, i11, this.f45c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m4a(int i, int i2, int i3) {
        return i >= 0 && i2 >= 0 && i3 >= 0 && i < this.width && i2 < this.depth && i3 < this.height;
    }

    public float getGroundLevel() {
        return (this.depth / 2) - 2;
    }

    public float getWaterLevel() {
        return this.depth / 2;
    }

    public boolean containsAnyLiquid(AABB aabb) {
        int i = (int) aabb.f96x0;
        int i2 = ((int) aabb.f99x1) + 1;
        int i3 = (int) aabb.f97y0;
        int i4 = ((int) aabb.f100y1) + 1;
        int i5 = (int) aabb.f98z0;
        int i6 = ((int) aabb.f101z1) + 1;
        if (aabb.f96x0 < 0.0f) {
            i--;
        }
        if (aabb.f97y0 < 0.0f) {
            i3--;
        }
        if (aabb.f98z0 < 0.0f) {
            i5--;
        }
        if (i < 0) {
            i = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i2 > this.width) {
            i2 = this.width;
        }
        if (i4 > this.depth) {
            i4 = this.depth;
        }
        if (i6 > this.height) {
            i6 = this.height;
        }
        for (int i7 = i; i7 < i2; i7++) {
            for (int i8 = i3; i8 < i4; i8++) {
                for (int i9 = i5; i9 < i6; i9++) {
                    C0008b c0008b = C0008b.f49a[getTile(i7, i8, i9)];
                    if (c0008b != null && c0008b.mo14c() != C0024a.f93a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsLiquid(AABB aabb, C0024a c0024a) {
        int i = (int) aabb.f96x0;
        int i2 = ((int) aabb.f99x1) + 1;
        int i3 = (int) aabb.f97y0;
        int i4 = ((int) aabb.f100y1) + 1;
        int i5 = (int) aabb.f98z0;
        int i6 = ((int) aabb.f101z1) + 1;
        if (aabb.f96x0 < 0.0f) {
            i--;
        }
        if (aabb.f97y0 < 0.0f) {
            i3--;
        }
        if (aabb.f98z0 < 0.0f) {
            i5--;
        }
        if (i < 0) {
            i = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i2 > this.width) {
            i2 = this.width;
        }
        if (i4 > this.depth) {
            i4 = this.depth;
        }
        if (i6 > this.height) {
            i6 = this.height;
        }
        for (int i7 = i; i7 < i2; i7++) {
            for (int i8 = i3; i8 < i4; i8++) {
                for (int i9 = i5; i9 < i6; i9++) {
                    C0008b c0008b = C0008b.f49a[getTile(i7, i8, i9)];
                    if (c0008b != null && c0008b.mo14c() == c0024a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addToTickNextTick(int i, int i2, int i3, int i4) {
        if (this.networkMode) {
            return;
        }
        C0018b c0018b = new C0018b(i, i2, i3, i4);
        if (i4 > 0) {
            c0018b.f79e = C0008b.f49a[i4].mo17d();
        }
        this.f47e.add(c0018b);
    }

    public boolean isFree(AABB aabb) {
        for (int i = 0; i < this.entities.size(); i++) {
            if (((Entity) this.entities.get(i)).f21bb.intersects(aabb)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSolid(float f, float f2, float f3, float f4) {
        return m5a(f - f4, f2 - f4, f3 - f4) || m5a(f - f4, f2 - f4, f3 + f4) || m5a(f - f4, f2 + f4, f3 - f4) || m5a(f - f4, f2 + f4, f3 + f4) || m5a(f + f4, f2 - f4, f3 - f4) || m5a(f + f4, f2 - f4, f3 + f4) || m5a(f + f4, f2 + f4, f3 - f4) || m5a(f + f4, f2 + f4, f3 + f4);
    }

    /* JADX INFO: renamed from: a */
    private boolean m5a(float f, float f2, float f3) {
        int tile = getTile((int) f, (int) f2, (int) f3);
        return tile > 0 && C0008b.f49a[tile].mo11b();
    }

    public int getHighestTile(int i, int i2) {
        int i3 = this.depth;
        while (true) {
            if ((getTile(i, i3 - 1, i2) != 0 && C0008b.f49a[getTile(i, i3 - 1, i2)].mo14c() == C0024a.f93a) || i3 <= 0) {
                break;
            }
            i3--;
        }
        return i3;
    }

    public void setSpawnPos(int i, int i2, int i3, float f) {
        this.xSpawn = i;
        this.ySpawn = i2;
        this.zSpawn = i3;
        this.rotSpawn = f;
    }

    public float getBrightness(int i, int i2, int i3) {
        return isLit(i, i2, i3) ? 1.0f : 0.6f;
    }

    public float getCaveness(float f, float f2, float f3, float f4) {
        float f5;
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = (int) f3;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i4 = i - 6; i4 <= i + 6; i4++) {
            for (int i5 = i3 - 6; i5 <= i3 + 6; i5++) {
                if (m4a(i4, i2, i5) && !isSolidTile(i4, i2, i5)) {
                    float f8 = (i5 + 0.5f) - f3;
                    double dAtan2 = Math.atan2(f8, (i4 + 0.5f) - f) - ((((double) f4) * 3.141592653589793d) / 180.0d);
                    double d = 1.5707963267948966d;
                    while (true) {
                        f5 = (float) (dAtan2 + d);
                        if (f5 >= -3.141592653589793d) {
                            break;
                        }
                        dAtan2 = f5;
                        d = 6.283185307179586d;
                    }
                    while (f5 >= 3.141592653589793d) {
                        f5 = (float) (((double) f5) - 6.283185307179586d);
                    }
                    if (f5 < 0.0f) {
                        f5 = -f5;
                    }
                    float fSqrt = 1.0f / ((float) Math.sqrt(((r0 * r0) + 4.0f) + (f8 * f8)));
                    if (f5 > 1.0f) {
                        fSqrt = 0.0f;
                    }
                    if (fSqrt < 0.0f) {
                        fSqrt = 0.0f;
                    }
                    f7 += fSqrt;
                    if (isLit(i4, i2, i5)) {
                        f6 += fSqrt;
                    }
                }
            }
        }
        if (f7 == 0.0f) {
            return 0.0f;
        }
        return f6 / f7;
    }

    public float getCaveness(Entity entity) {
        float fCos = (float) Math.cos(((((double) (-entity.yRot)) * 3.141592653589793d) / 180.0d) + 3.141592653589793d);
        float fSin = (float) Math.sin(((((double) (-entity.yRot)) * 3.141592653589793d) / 180.0d) + 3.141592653589793d);
        float fCos2 = (float) Math.cos((((double) (-entity.xRot)) * 3.141592653589793d) / 180.0d);
        float fSin2 = (float) Math.sin((((double) (-entity.xRot)) * 3.141592653589793d) / 180.0d);
        float f = entity.f15x;
        float f2 = entity.f16y;
        float f3 = entity.f17z;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i = 0; i <= 200; i++) {
            float f6 = ((i / 200) - 0.5f) * 2.0f;
            for (int i2 = 0; i2 <= 200; i2++) {
                float f7 = ((i2 / 200) - 0.5f) * 1.6f;
                float f8 = (fCos2 * f7) + fSin2;
                float f9 = fCos2 - (fSin2 * f7);
                float f10 = (fCos * f6) + (fSin * f9);
                float f11 = (fCos * f9) - (fSin * f6);
                for (int i3 = 0; i3 < 10; i3++) {
                    float f12 = f + (f10 * i3 * 0.8f);
                    float f13 = f2 + (f8 * i3 * 0.8f);
                    float f14 = f3 + (f11 * i3 * 0.8f);
                    if (!m5a(f12, f13, f14)) {
                        f4 += 1.0f;
                        if (isLit((int) f12, (int) f13, (int) f14)) {
                            f5 += 1.0f;
                        }
                    }
                }
            }
        }
        if (f4 == 0.0f) {
            return 0.0f;
        }
        float f15 = (f5 / f4) / 0.1f;
        float f16 = f15;
        if (f15 > 1.0f) {
            f16 = 1.0f;
        }
        float f17 = 1.0f - f16;
        return 1.0f - ((f17 * f17) * f17);
    }

    public byte[] copyBlocks() {
        return Arrays.copyOf(this.blocks, this.blocks.length);
    }

    public boolean isWater(int i, int i2, int i3) {
        int tile = getTile(i, i2, i3);
        return tile > 0 && C0008b.f49a[tile].mo14c() == C0024a.f94b;
    }

    public void setNetworkMode(boolean z) {
        this.networkMode = z;
    }
}
