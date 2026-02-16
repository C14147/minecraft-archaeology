package com.mojang.minecraft.level;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.level.p006c.C0045a;
import com.mojang.minecraft.p001a.C0009g;
import com.mojang.minecraft.phys.AABB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/Level.class */
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
    private transient int[] f192b;

    /* JADX INFO: renamed from: a */
    private transient ArrayList f191a = new ArrayList();

    /* JADX INFO: renamed from: c */
    private transient Random f193c = new Random();

    /* JADX INFO: renamed from: d */
    private transient int f194d = this.f193c.nextInt();

    /* JADX INFO: renamed from: e */
    private transient ArrayList f195e = new ArrayList();
    public ArrayList entities = new ArrayList();
    int unprocessed = 0;
    private int tickCount = 0;

    public void initTransient() {
        if (this.blocks == null) {
            throw new RuntimeException("The level is corrupt!");
        }
        this.f191a = new ArrayList();
        this.f192b = new int[this.width * this.height];
        Arrays.fill(this.f192b, this.depth);
        calcLightDepths(0, 0, this.width, this.height);
        this.f193c = new Random();
        this.f194d = this.f193c.nextInt();
        this.f195e = new ArrayList();
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
        this.f192b = new int[i * i3];
        Arrays.fill(this.f192b, this.depth);
        calcLightDepths(0, 0, i, i3);
        for (int i4 = 0; i4 < this.f191a.size(); i4++) {
            ((C0009g) this.f191a.get(i4)).m25a();
        }
        this.f195e.clear();
        findSpawn();
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
                int i7 = this.f192b[i5 + (i6 * this.width)];
                int i8 = this.depth - 1;
                while (i8 > 0 && !isLightBlocker(i5, i8, i6)) {
                    i8--;
                }
                this.f192b[i5 + (i6 * this.width)] = i8 + 1;
                if (i7 != i8) {
                    int i9 = i7 < i8 ? i7 : i8;
                    int i10 = i7 > i8 ? i7 : i8;
                    for (int i11 = 0; i11 < this.f191a.size(); i11++) {
                        int i12 = i5;
                        int i13 = i6;
                        ((C0009g) this.f191a.get(i11)).m32a(i12 - 1, i9 - 1, i13 - 1, i12 + 1, i10 + 1, i13 + 1);
                    }
                }
            }
        }
    }

    public void addListener$74652038(C0009g c0009g) {
        this.f191a.add(c0009g);
    }

    public void finalize() {
    }

    public void removeListener$74652038(C0009g c0009g) {
        this.f191a.remove(c0009g);
    }

    public boolean isLightBlocker(int i, int i2, int i3) {
        C0030a c0030a = C0030a.f197a[getTile(i, i2, i3)];
        if (c0030a == null) {
            return false;
        }
        return c0030a.mo104a();
    }

    public ArrayList getCubes(AABB aabb) {
        AABB aabbMo103b;
        AABB aabbMo103b2;
        ArrayList arrayList = new ArrayList();
        int i = (int) aabb.f292x0;
        int i2 = ((int) aabb.f295x1) + 1;
        int i3 = (int) aabb.f293y0;
        int i4 = ((int) aabb.f296y1) + 1;
        int i5 = (int) aabb.f294z0;
        int i6 = ((int) aabb.f297z1) + 1;
        if (aabb.f292x0 < 0.0f) {
            i--;
        }
        if (aabb.f293y0 < 0.0f) {
            i3--;
        }
        if (aabb.f294z0 < 0.0f) {
            i5--;
        }
        for (int i7 = i; i7 < i2; i7++) {
            for (int i8 = i3; i8 < i4; i8++) {
                for (int i9 = i5; i9 < i6; i9++) {
                    if (i7 >= 0 && i8 >= 0 && i9 >= 0 && i7 < this.width && i8 < this.depth && i9 < this.height) {
                        C0030a c0030a = C0030a.f197a[getTile(i7, i8, i9)];
                        if (c0030a != null && (aabbMo103b2 = c0030a.mo103b(i7, i8, i9)) != null) {
                            arrayList.add(aabbMo103b2);
                        }
                    } else if ((i7 < 0 || i8 < 0 || i9 < 0 || i7 >= this.width || i9 >= this.height) && (aabbMo103b = C0030a.f206i.mo103b(i7, i8, i9)) != null) {
                        arrayList.add(aabbMo103b);
                    }
                }
            }
        }
        return arrayList;
    }

    public void swap(int i, int i2, int i3, int i4, int i5, int i6) {
        int tile = getTile(i, i2, i3);
        int tile2 = getTile(i4, i5, i6);
        setTileNoNeighborChange(i, i2, i3, tile2);
        setTileNoNeighborChange(i4, i5, i6, tile);
        m81a(i, i2, i3, tile2);
        m81a(i4, i5, i6, tile);
    }

    public boolean setTileNoNeighborChange(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        if (i4 == 0 && ((i == 0 || i3 == 0 || i == this.width - 1 || i3 == this.height - 1) && i2 >= getGroundLevel() && i2 < getWaterLevel())) {
            i4 = C0030a.f207j.f219v;
        }
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        calcLightDepths(i, i3, 1, 1);
        for (int i5 = 0; i5 < this.f191a.size(); i5++) {
            ((C0009g) this.f191a.get(i5)).m32a(i - 1, i2 - 1, i3 - 1, i + 1, i2 + 1, i3 + 1);
        }
        return true;
    }

    public boolean setTile(int i, int i2, int i3, int i4) {
        if (!setTileNoNeighborChange(i, i2, i3, i4)) {
            return false;
        }
        m81a(i, i2, i3, i4);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m81a(int i, int i2, int i3, int i4) {
        m82b(i - 1, i2, i3, i4);
        m82b(i + 1, i2, i3, i4);
        m82b(i, i2 - 1, i3, i4);
        m82b(i, i2 + 1, i3, i4);
        m82b(i, i2, i3 - 1, i4);
        m82b(i, i2, i3 + 1, i4);
    }

    public boolean setTileNoUpdate(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        return true;
    }

    /* JADX INFO: renamed from: b */
    private void m82b(int i, int i2, int i3, int i4) {
        C0030a c0030a;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || (c0030a = C0030a.f197a[this.blocks[(((i2 * this.height) + i3) * this.width) + i]]) == null) {
            return;
        }
        c0030a.mo110b(this, i, i2, i3, i4);
    }

    public boolean isLit(int i, int i2, int i3) {
        return i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i2 >= this.f192b[i + (i3 * this.width)];
    }

    public int getTile(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height) {
            return 0;
        }
        return this.blocks[(((i2 * this.height) + i3) * this.width) + i];
    }

    public boolean isSolidTile(int i, int i2, int i3) {
        C0030a c0030a = C0030a.f197a[getTile(i, i2, i3)];
        if (c0030a == null) {
            return false;
        }
        return c0030a.mo105b();
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
            int size = this.f195e.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0039b c0039b = (C0039b) this.f195e.remove(0);
                if (c0039b.f234e > 0) {
                    c0039b.f234e--;
                    this.f195e.add(c0039b);
                } else if (m83a(c0039b.f230a, c0039b.f231b, c0039b.f232c) && (b = this.blocks[(((c0039b.f231b * this.height) + c0039b.f232c) * this.width) + c0039b.f230a]) == c0039b.f233d && b > 0) {
                    C0030a.f197a[b].mo107a(this, c0039b.f230a, c0039b.f231b, c0039b.f232c, this.f193c);
                }
            }
        }
        this.unprocessed += this.width * this.height * this.depth;
        int i7 = this.unprocessed / 200;
        this.unprocessed -= i7 * 200;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f194d = (this.f194d * 3) + 1013904223;
            int i9 = this.f194d >> 2;
            int i10 = i9 & i4;
            int i11 = (i9 >> i) & i3;
            int i12 = (i9 >> (i + i2)) & i5;
            byte b2 = this.blocks[(((i12 * this.height) + i11) * this.width) + i10];
            if (C0030a.f198b[b2]) {
                C0030a.f197a[b2].mo107a(this, i10, i12, i11, this.f193c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m83a(int i, int i2, int i3) {
        return i >= 0 && i2 >= 0 && i3 >= 0 && i < this.width && i2 < this.depth && i3 < this.height;
    }

    public float getGroundLevel() {
        return (this.depth / 2) - 2;
    }

    public float getWaterLevel() {
        return this.depth / 2;
    }

    public boolean containsAnyLiquid(AABB aabb) {
        int i = (int) aabb.f292x0;
        int i2 = ((int) aabb.f295x1) + 1;
        int i3 = (int) aabb.f293y0;
        int i4 = ((int) aabb.f296y1) + 1;
        int i5 = (int) aabb.f294z0;
        int i6 = ((int) aabb.f297z1) + 1;
        if (aabb.f292x0 < 0.0f) {
            i--;
        }
        if (aabb.f293y0 < 0.0f) {
            i3--;
        }
        if (aabb.f294z0 < 0.0f) {
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
                    C0030a c0030a = C0030a.f197a[getTile(i7, i8, i9)];
                    if (c0030a != null && c0030a.mo109d() != C0045a.f248a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsLiquid(AABB aabb, C0045a c0045a) {
        int i = (int) aabb.f292x0;
        int i2 = ((int) aabb.f295x1) + 1;
        int i3 = (int) aabb.f293y0;
        int i4 = ((int) aabb.f296y1) + 1;
        int i5 = (int) aabb.f294z0;
        int i6 = ((int) aabb.f297z1) + 1;
        if (aabb.f292x0 < 0.0f) {
            i--;
        }
        if (aabb.f293y0 < 0.0f) {
            i3--;
        }
        if (aabb.f294z0 < 0.0f) {
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
                    C0030a c0030a = C0030a.f197a[getTile(i7, i8, i9)];
                    if (c0030a != null && c0030a.mo109d() == c0045a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addToTickNextTick(int i, int i2, int i3, int i4) {
        C0039b c0039b = new C0039b(i, i2, i3, i4);
        if (i4 > 0) {
            c0039b.f234e = C0030a.f197a[i4].mo112e();
        }
        this.f195e.add(c0039b);
    }

    public boolean isFree(AABB aabb) {
        for (int i = 0; i < this.entities.size(); i++) {
            if (((Entity) this.entities.get(i)).f17bb.intersects(aabb)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSolid(float f, float f2, float f3, float f4) {
        return m84a(f - f4, f2 - f4, f3 - f4) || m84a(f - f4, f2 - f4, f3 + f4) || m84a(f - f4, f2 + f4, f3 - f4) || m84a(f - f4, f2 + f4, f3 + f4) || m84a(f + f4, f2 - f4, f3 - f4) || m84a(f + f4, f2 - f4, f3 + f4) || m84a(f + f4, f2 + f4, f3 - f4) || m84a(f + f4, f2 + f4, f3 + f4);
    }

    /* JADX INFO: renamed from: a */
    private boolean m84a(float f, float f2, float f3) {
        int tile = getTile((int) f, (int) f2, (int) f3);
        return tile > 0 && C0030a.f197a[tile].mo105b();
    }

    public int getHighestTile(int i, int i2) {
        int i3 = this.depth;
        while (true) {
            if ((getTile(i, i3 - 1, i2) != 0 && C0030a.f197a[getTile(i, i3 - 1, i2)].mo109d() == C0045a.f248a) || i3 <= 0) {
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
                if (m83a(i4, i2, i5) && !isSolidTile(i4, i2, i5)) {
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
        float f = entity.f11x;
        float f2 = entity.f12y;
        float f3 = entity.f13z;
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
                    if (!m84a(f12, f13, f14)) {
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
}
