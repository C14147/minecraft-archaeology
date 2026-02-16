package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0024a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.j */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/j.class */
public class C0016j extends C0008b {

    /* JADX INFO: renamed from: w */
    protected C0024a f72w;

    /* JADX INFO: renamed from: x */
    protected int f73x;

    /* JADX INFO: renamed from: y */
    protected int f74y;

    protected C0016j(int i, C0024a c0024a) {
        super(i);
        this.f72w = c0024a;
        this.f74y = i;
        this.f73x = i + 1;
        m12a(true);
        if (c0024a == C0024a.f95c) {
            m13a(16);
        }
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo16a(Level level, int i, int i2, int i3) {
        level.addToTickNextTick(i, i2, i3, this.f74y);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public void mo8a(Level level, int i, int i2, int i3, Random random) {
        int i4 = i2;
        boolean zM22e = false;
        do {
            i4--;
            if (level.getTile(i, i4, i3) != 0 || !m21d(level, i, i4, i3)) {
                break;
            }
            boolean tile = level.setTile(i, i4, i3, this.f74y);
            if (tile) {
                zM22e = true;
            }
            if (!tile) {
                break;
            }
        } while (this.f72w != C0024a.f95c);
        int i5 = i4 + 1;
        if (this.f72w == C0024a.f94b || !zM22e) {
            zM22e = zM22e | m22e(level, i - 1, i5, i3) | m22e(level, i + 1, i5, i3) | m22e(level, i, i5, i3 - 1) | m22e(level, i, i5, i3 + 1);
        }
        if (zM22e) {
            level.addToTickNextTick(i, i5, i3, this.f74y);
        } else {
            level.setTileNoUpdate(i, i5, i3, this.f73x);
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m21d(Level level, int i, int i2, int i3) {
        if (this.f72w != C0024a.f94b) {
            return true;
        }
        for (int i4 = i - 2; i4 <= i + 2; i4++) {
            for (int i5 = i2 - 2; i5 <= i2 + 2; i5++) {
                for (int i6 = i3 - 2; i6 <= i3 + 2; i6++) {
                    if (level.getTile(i4, i5, i6) == C0008b.f69t.f71v) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    private boolean m22e(Level level, int i, int i2, int i3) {
        if (level.getTile(i, i2, i3) != 0 || !m21d(level, i, i2, i3) || !level.setTile(i, i2, i3, this.f74y)) {
            return false;
        }
        level.addToTickNextTick(i, i2, i3, this.f74y);
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final AABB mo9a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final boolean mo10a() {
        return true;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: b */
    public final boolean mo11b() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: c */
    public final C0024a mo14c() {
        return this.f72w;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public void mo15a(Level level, int i, int i2, int i3, int i4) {
        if (i4 != 0) {
            C0024a c0024aMo14c = C0008b.f49a[i4].mo14c();
            if ((this.f72w == C0024a.f94b && c0024aMo14c == C0024a.f95c) || (c0024aMo14c == C0024a.f94b && this.f72w == C0024a.f95c)) {
                level.setTile(i, i2, i3, C0008b.f52c.f71v);
                return;
            }
        }
        level.addToTickNextTick(i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: d */
    public final int mo17d() {
        return this.f72w == C0024a.f95c ? 5 : 0;
    }
}
