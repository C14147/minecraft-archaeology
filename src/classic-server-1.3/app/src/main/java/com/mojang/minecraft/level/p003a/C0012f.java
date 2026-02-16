package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0022a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.f */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/f.class */
public final class C0012f extends C0014h {
    protected C0012f(int i, C0022a c0022a) {
        super(i, c0022a);
        this.f73x = i - 1;
        this.f72w = i;
        m13a(false);
    }

    @Override // com.mojang.minecraft.level.p003a.C0014h, com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo9a(Level level, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.level.p003a.C0014h, com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo16a(Level level, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (level.getTile(i - 1, i2, i3) == 0) {
            z = true;
        }
        if (level.getTile(i + 1, i2, i3) == 0) {
            z = true;
        }
        if (level.getTile(i, i2, i3 - 1) == 0) {
            z = true;
        }
        if (level.getTile(i, i2, i3 + 1) == 0) {
            z = true;
        }
        if (level.getTile(i, i2 - 1, i3) == 0) {
            z = true;
        }
        if (i4 != 0) {
            C0022a c0022aMo15c = C0008b.f49a[i4].mo15c();
            if ((this.f71v == C0022a.f93b && c0022aMo15c == C0022a.f94c) || (c0022aMo15c == C0022a.f93b && this.f71v == C0022a.f94c)) {
                level.setTile(i, i2, i3, C0008b.f52c.f70u);
                return;
            }
        }
        if (z) {
            level.setTileNoUpdate(i, i2, i3, this.f73x);
            level.addToTickNextTick(i, i2, i3, this.f73x);
        }
    }
}
