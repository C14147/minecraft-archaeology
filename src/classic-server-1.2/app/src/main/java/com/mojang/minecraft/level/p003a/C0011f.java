package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0021a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.f */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/f.class */
public final class C0011f extends C0013h {
    protected C0011f(int i, C0021a c0021a) {
        super(i, c0021a);
        this.f69u = i - 1;
        this.f68t = i;
        m13a(false);
    }

    @Override // com.mojang.minecraft.level.p003a.C0013h, com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public final void mo9a(Level level, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.level.p003a.C0013h, com.mojang.minecraft.level.p003a.C0007b
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
            C0021a c0021aMo15c = C0007b.f48a[i4].mo15c();
            if ((this.f67s == C0021a.f89b && c0021aMo15c == C0021a.f90c) || (c0021aMo15c == C0021a.f89b && this.f67s == C0021a.f90c)) {
                level.setTile(i, i2, i3, C0007b.f51c.f66r);
                return;
            }
        }
        if (z) {
            level.setTileNoUpdate(i, i2, i3, this.f69u);
            level.addToTickNextTick(i, i2, i3, this.f69u);
        }
    }
}
