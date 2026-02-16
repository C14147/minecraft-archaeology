package com.mojang.minecraft.level;

import com.mojang.minecraft.Entity;
import com.mojang.minecraft.level.p002a.C0026a;
import com.mojang.minecraft.p000a.C0008g;
import com.mojang.minecraft.phys.AABB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/Level.class */
public class Level implements Serializable {
    public static final long serialVersionUID = 0;
    public int width;
    public int height;
    public int depth;
    byte[] blocks;
    public String name;
    public String creator;
    public long createTime;
    public int xSpawn;
    public int ySpawn;
    public int zSpawn;
    public float rotSpawn;

    /* JADX INFO: renamed from: b */
    private transient int[] f172b;

    /* JADX INFO: renamed from: a */
    private transient ArrayList f171a = new ArrayList();

    /* JADX INFO: renamed from: c */
    private transient Random f173c = new Random();

    /* JADX INFO: renamed from: d */
    private transient int f174d = this.f173c.nextInt();

    /* JADX INFO: renamed from: e */
    private transient ArrayList f175e = new ArrayList();
    public ArrayList entities = new ArrayList();
    int unprocessed = 0;
    private int tickCount = 0;

    public void initTransient() {
        if (this.blocks == null) {
            throw new RuntimeException("The level is corrupt!");
        }
        this.f171a = new ArrayList();
        this.f172b = new int[this.width * this.height];
        calcLightDepths(0, 0, this.width, this.height);
        this.f173c = new Random();
        this.f174d = this.f173c.nextInt();
        this.f175e = new ArrayList();
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
        this.f172b = new int[i * i3];
        calcLightDepths(0, 0, i, i3);
        for (int i4 = 0; i4 < this.f171a.size(); i4++) {
            ((C0008g) this.f171a.get(i4)).m21a();
        }
        this.f175e.clear();
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
                int i7 = this.f172b[i5 + (i6 * this.width)];
                int i8 = this.depth - 1;
                while (i8 > 0 && !isLightBlocker(i5, i8, i6)) {
                    i8--;
                }
                this.f172b[i5 + (i6 * this.width)] = i8 + 1;
                if (i7 != i8) {
                    int i9 = i7 < i8 ? i7 : i8;
                    int i10 = i7 > i8 ? i7 : i8;
                    for (int i11 = 0; i11 < this.f171a.size(); i11++) {
                        int i12 = i5;
                        int i13 = i6;
                        ((C0008g) this.f171a.get(i11)).m28a(i12 - 1, i9 - 1, i13 - 1, i12 + 1, i10 + 1, i13 + 1);
                    }
                }
            }
        }
    }

    public void addListener$74652038(C0008g c0008g) {
        this.f171a.add(c0008g);
    }

    public void finalize() {
    }

    public void removeListener$74652038(C0008g c0008g) {
        this.f171a.remove(c0008g);
    }

    public boolean isLightBlocker(int i, int i2, int i3) {
        C0026a c0026a = C0026a.f177a[getTile(i, i2, i3)];
        if (c0026a == null) {
            return false;
        }
        return c0026a.mo90a();
    }

    public ArrayList getCubes(AABB aabb) {
        AABB aabbMo89b;
        AABB aabbMo89b2;
        ArrayList arrayList = new ArrayList();
        int i = (int) aabb.f231x0;
        int i2 = ((int) aabb.f234x1) + 1;
        int i3 = (int) aabb.f232y0;
        int i4 = ((int) aabb.f235y1) + 1;
        int i5 = (int) aabb.f233z0;
        int i6 = ((int) aabb.f236z1) + 1;
        if (aabb.f231x0 < 0.0f) {
            i--;
        }
        if (aabb.f232y0 < 0.0f) {
            i3--;
        }
        if (aabb.f233z0 < 0.0f) {
            i5--;
        }
        for (int i7 = i; i7 < i2; i7++) {
            for (int i8 = i3; i8 < i4; i8++) {
                for (int i9 = i5; i9 < i6; i9++) {
                    if (i7 >= 0 && i8 >= 0 && i9 >= 0 && i7 < this.width && i8 < this.depth && i9 < this.height) {
                        C0026a c0026a = C0026a.f177a[getTile(i7, i8, i9)];
                        if (c0026a != null && (aabbMo89b2 = c0026a.mo89b(i7, i8, i9)) != null) {
                            arrayList.add(aabbMo89b2);
                        }
                    } else if ((i7 < 0 || i8 < 0 || i9 < 0 || i7 >= this.width || i9 >= this.height) && (aabbMo89b = C0026a.f185i.mo89b(i7, i8, i9)) != null) {
                        arrayList.add(aabbMo89b);
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
        m70a(i, i2, i3, tile2);
        m70a(i4, i5, i6, tile);
    }

    public boolean setTileNoNeighborChange(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        if (i4 == 0 && ((i == 0 || i3 == 0 || i == this.width - 1 || i3 == this.height - 1) && i2 >= getGroundLevel() && i2 < getWaterLevel())) {
            i4 = C0026a.f186j.f198v;
        }
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        calcLightDepths(i, i3, 1, 1);
        for (int i5 = 0; i5 < this.f171a.size(); i5++) {
            ((C0008g) this.f171a.get(i5)).m28a(i - 1, i2 - 1, i3 - 1, i + 1, i2 + 1, i3 + 1);
        }
        return true;
    }

    public boolean setTile(int i, int i2, int i3, int i4) {
        if (!setTileNoNeighborChange(i, i2, i3, i4)) {
            return false;
        }
        m70a(i, i2, i3, i4);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m70a(int i, int i2, int i3, int i4) {
        m71b(i - 1, i2, i3, i4);
        m71b(i + 1, i2, i3, i4);
        m71b(i, i2 - 1, i3, i4);
        m71b(i, i2 + 1, i3, i4);
        m71b(i, i2, i3 - 1, i4);
        m71b(i, i2, i3 + 1, i4);
    }

    public boolean setTileNoUpdate(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i4 == this.blocks[(((i2 * this.height) + i3) * this.width) + i]) {
            return false;
        }
        this.blocks[(((i2 * this.height) + i3) * this.width) + i] = (byte) i4;
        return true;
    }

    /* JADX INFO: renamed from: b */
    private void m71b(int i, int i2, int i3, int i4) {
        C0026a c0026a;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || (c0026a = C0026a.f177a[this.blocks[(((i2 * this.height) + i3) * this.width) + i]]) == null) {
            return;
        }
        c0026a.mo96b(this, i, i2, i3, i4);
    }

    public boolean isLit(int i, int i2, int i3) {
        return i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height || i2 >= this.f172b[i + (i3 * this.width)];
    }

    public int getTile(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i >= this.width || i2 >= this.depth || i3 >= this.height) {
            return 0;
        }
        return this.blocks[(((i2 * this.height) + i3) * this.width) + i];
    }

    public boolean isSolidTile(int i, int i2, int i3) {
        C0026a c0026a = C0026a.f177a[getTile(i, i2, i3)];
        if (c0026a == null) {
            return false;
        }
        return c0026a.mo91b();
    }

    public void tick() {
        byte b;
        this.tickCount++;
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
        int i3 = 1;
        int i4 = 1;
        while ((1 << i3) < this.width) {
            i3++;
        }
        while ((1 << i4) < this.height) {
            i4++;
        }
        int i5 = this.height - 1;
        int i6 = this.width - 1;
        int i7 = this.depth - 1;
        if (this.tickCount % 5 == 0) {
            int size = this.f175e.size();
            for (int i8 = 0; i8 < size; i8++) {
                C0035b c0035b = (C0035b) this.f175e.remove(0);
                if (m72a(c0035b.f208a, c0035b.f209b, c0035b.f210c) && (b = this.blocks[(((c0035b.f209b * this.height) + c0035b.f210c) * this.width) + c0035b.f208a]) == c0035b.f211d && b > 0) {
                    C0026a.f177a[b].mo93a(this, c0035b.f208a, c0035b.f209b, c0035b.f210c, this.f173c);
                }
            }
        }
        this.unprocessed += this.width * this.height * this.depth;
        int i9 = this.unprocessed / 200;
        this.unprocessed -= i9 * 200;
        for (int i10 = 0; i10 < i9; i10++) {
            this.f174d = (this.f174d * 3) + 1013904223;
            int i11 = this.f174d >> 2;
            int i12 = i11 & i6;
            int i13 = (i11 >> i3) & i5;
            int i14 = (i11 >> (i3 + i4)) & i7;
            byte b2 = this.blocks[(((i14 * this.height) + i13) * this.width) + i12];
            if (C0026a.f178b[b2]) {
                C0026a.f177a[b2].mo93a(this, i12, i14, i13, this.f173c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m72a(int i, int i2, int i3) {
        return i >= 0 && i2 >= 0 && i3 >= 0 && i < this.width && i2 < this.depth && i3 < this.height;
    }

    public float getGroundLevel() {
        return (this.depth / 2) - 2;
    }

    public float getWaterLevel() {
        return this.depth / 2;
    }

    public boolean containsAnyLiquid(AABB aabb) {
        int i = (int) aabb.f231x0;
        int i2 = ((int) aabb.f234x1) + 1;
        int i3 = (int) aabb.f232y0;
        int i4 = ((int) aabb.f235y1) + 1;
        int i5 = (int) aabb.f233z0;
        int i6 = ((int) aabb.f236z1) + 1;
        if (aabb.f231x0 < 0.0f) {
            i--;
        }
        if (aabb.f232y0 < 0.0f) {
            i3--;
        }
        if (aabb.f233z0 < 0.0f) {
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
                    C0026a c0026a = C0026a.f177a[getTile(i7, i8, i9)];
                    if (c0026a != null && c0026a.mo95d() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsLiquid(AABB aabb, int i) {
        int i2 = (int) aabb.f231x0;
        int i3 = ((int) aabb.f234x1) + 1;
        int i4 = (int) aabb.f232y0;
        int i5 = ((int) aabb.f235y1) + 1;
        int i6 = (int) aabb.f233z0;
        int i7 = ((int) aabb.f236z1) + 1;
        if (aabb.f231x0 < 0.0f) {
            i2--;
        }
        if (aabb.f232y0 < 0.0f) {
            i4--;
        }
        if (aabb.f233z0 < 0.0f) {
            i6--;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        if (i6 < 0) {
            i6 = 0;
        }
        if (i3 > this.width) {
            i3 = this.width;
        }
        if (i5 > this.depth) {
            i5 = this.depth;
        }
        if (i7 > this.height) {
            i7 = this.height;
        }
        for (int i8 = i2; i8 < i3; i8++) {
            for (int i9 = i4; i9 < i5; i9++) {
                for (int i10 = i6; i10 < i7; i10++) {
                    C0026a c0026a = C0026a.f177a[getTile(i8, i9, i10)];
                    if (c0026a != null && c0026a.mo95d() == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addToTickNextTick(int i, int i2, int i3, int i4) {
        this.f175e.add(new C0035b(i, i2, i3, i4));
    }

    public boolean isFree(AABB aabb) {
        for (int i = 0; i < this.entities.size(); i++) {
            if (((Entity) this.entities.get(i)).f9bb.intersects(aabb)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSolid(float f, float f2, float f3, float f4) {
        return m73a(f - f4, f2 - f4, f3 - f4) || m73a(f - f4, f2 - f4, f3 + f4) || m73a(f - f4, f2 + f4, f3 - f4) || m73a(f - f4, f2 + f4, f3 + f4) || m73a(f + f4, f2 - f4, f3 - f4) || m73a(f + f4, f2 - f4, f3 + f4) || m73a(f + f4, f2 + f4, f3 - f4) || m73a(f + f4, f2 + f4, f3 + f4);
    }

    /* JADX INFO: renamed from: a */
    private boolean m73a(float f, float f2, float f3) {
        int tile = getTile((int) f, (int) f2, (int) f3);
        return tile > 0 && C0026a.f177a[tile].mo91b();
    }

    public int getHighestTile(int i, int i2) {
        int i3 = this.depth;
        while (true) {
            if ((getTile(i, i3 - 1, i2) != 0 && C0026a.f177a[getTile(i, i3 - 1, i2)].mo95d() == 0) || i3 <= 0) {
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
        return isLit(i, i2, i3) ? 1.0f : 0.5f;
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
                if (m72a(i4, i2, i5) && !isSolidTile(i4, i2, i5)) {
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
        float f = entity.f3x;
        float f2 = entity.f4y;
        float f3 = entity.f5z;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i = 0; i <= 10; i++) {
            float f6 = ((i / 10) - 0.5f) * 2.0f;
            for (int i2 = 0; i2 <= 10; i2++) {
                float f7 = ((i2 / 10) - 0.5f) * 1.6f;
                float f8 = (fCos2 * f7) + fSin2;
                float f9 = fCos2 - (fSin2 * f7);
                float f10 = (fCos * f6) + (fSin * f9);
                float f11 = (fCos * f9) - (fSin * f6);
                for (int i3 = 0; i3 < 20; i3++) {
                    float f12 = f + (f10 * i3 * 0.8f);
                    float f13 = f2 + (f8 * i3 * 0.8f);
                    float f14 = f3 + (f11 * i3 * 0.8f);
                    if (!m73a(f12, f13, f14)) {
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
}
