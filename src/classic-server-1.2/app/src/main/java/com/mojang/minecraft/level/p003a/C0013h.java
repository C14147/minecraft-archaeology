package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0021a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.h */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/h.class */
public class C0013h extends C0007b {

    /* JADX INFO: renamed from: s */
    protected C0021a f67s;

    /* JADX INFO: renamed from: t */
    protected int f68t;

    /* JADX INFO: renamed from: u */
    protected int f69u;

    protected C0013h(int i, C0021a c0021a) {
        super(i);
        this.f67s = c0021a;
        this.f69u = i;
        this.f68t = i + 1;
        m13a(true);
        if (c0021a == C0021a.f90c) {
            m14a(16);
        }
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public final void mo17a(Level level, int i, int i2, int i3) {
        level.addToTickNextTick(i, i2, i3, this.f69u);
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public void mo9a(Level level, int i, int i2, int i3, Random random) {
        int i4 = i2;
        boolean zM20b = false;
        do {
            i4--;
            if (level.getTile(i, i4, i3) == 0) {
                boolean tile = level.setTile(i, i4, i3, this.f69u);
                if (tile) {
                    zM20b = true;
                }
                if (!tile) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f67s != C0021a.f90c);
        int i5 = i4 + 1;
        if (this.f67s == C0021a.f89b || !zM20b) {
            zM20b = zM20b | m20b(level, i - 1, i5, i3) | m20b(level, i + 1, i5, i3) | m20b(level, i, i5, i3 - 1) | m20b(level, i, i5, i3 + 1);
        }
        if (zM20b) {
            level.addToTickNextTick(i, i5, i3, this.f69u);
        } else {
            level.setTileNoUpdate(i, i5, i3, this.f68t);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m20b(Level level, int i, int i2, int i3) {
        if (level.getTile(i, i2, i3) != 0 || !level.setTile(i, i2, i3, this.f69u)) {
            return false;
        }
        level.addToTickNextTick(i, i2, i3, this.f69u);
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public final AABB mo10a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public final boolean mo11a() {
        return true;
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: b */
    public final boolean mo12b() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: c */
    public final C0021a mo15c() {
        return this.f67s;
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public void mo16a(Level level, int i, int i2, int i3, int i4) {
        if (i4 != 0) {
            C0021a c0021aMo15c = C0007b.f48a[i4].mo15c();
            if ((this.f67s == C0021a.f89b && c0021aMo15c == C0021a.f90c) || (c0021aMo15c == C0021a.f89b && this.f67s == C0021a.f90c)) {
                level.setTile(i, i2, i3, C0007b.f51c.f66r);
                return;
            }
        }
        level.addToTickNextTick(i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: d */
    public final int mo18d() {
        return this.f67s == C0021a.f90c ? 5 : 0;
    }
}
