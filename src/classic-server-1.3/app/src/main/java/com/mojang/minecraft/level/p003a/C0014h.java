package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0022a;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.h */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/h.class */
public class C0014h extends C0008b {

    /* JADX INFO: renamed from: v */
    protected C0022a f71v;

    /* JADX INFO: renamed from: w */
    protected int f72w;

    /* JADX INFO: renamed from: x */
    protected int f73x;

    protected C0014h(int i, C0022a c0022a) {
        super(i);
        this.f71v = c0022a;
        this.f73x = i;
        this.f72w = i + 1;
        m13a(true);
        if (c0022a == C0022a.f94c) {
            m14a(16);
        }
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo17a(Level level, int i, int i2, int i3) {
        level.addToTickNextTick(i, i2, i3, this.f73x);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public void mo9a(Level level, int i, int i2, int i3, Random random) {
        int i4 = i2;
        boolean zM20b = false;
        do {
            i4--;
            if (level.getTile(i, i4, i3) == 0) {
                boolean tile = level.setTile(i, i4, i3, this.f73x);
                if (tile) {
                    zM20b = true;
                }
                if (!tile) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f71v != C0022a.f94c);
        int i5 = i4 + 1;
        if (this.f71v == C0022a.f93b || !zM20b) {
            zM20b = zM20b | m20b(level, i - 1, i5, i3) | m20b(level, i + 1, i5, i3) | m20b(level, i, i5, i3 - 1) | m20b(level, i, i5, i3 + 1);
        }
        if (zM20b) {
            level.addToTickNextTick(i, i5, i3, this.f73x);
        } else {
            level.setTileNoUpdate(i, i5, i3, this.f72w);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m20b(Level level, int i, int i2, int i3) {
        if (level.getTile(i, i2, i3) != 0 || !level.setTile(i, i2, i3, this.f73x)) {
            return false;
        }
        level.addToTickNextTick(i, i2, i3, this.f73x);
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final AABB mo10a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final boolean mo11a() {
        return true;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: b */
    public final boolean mo12b() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: c */
    public final C0022a mo15c() {
        return this.f71v;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public void mo16a(Level level, int i, int i2, int i3, int i4) {
        if (i4 != 0) {
            C0022a c0022aMo15c = C0008b.f49a[i4].mo15c();
            if ((this.f71v == C0022a.f93b && c0022aMo15c == C0022a.f94c) || (c0022aMo15c == C0022a.f93b && this.f71v == C0022a.f94c)) {
                level.setTile(i, i2, i3, C0008b.f52c.f70u);
                return;
            }
        }
        level.addToTickNextTick(i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: d */
    public final int mo18d() {
        return this.f71v == C0022a.f94c ? 5 : 0;
    }
}
