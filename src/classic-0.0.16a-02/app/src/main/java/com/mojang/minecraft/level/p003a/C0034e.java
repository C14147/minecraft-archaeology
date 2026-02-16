package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0045a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.e */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/e.class */
public final class C0034e extends C0038i {
    protected C0034e(int i, C0045a c0045a) {
        super(i, c0045a);
        this.f229z = i - 1;
        this.f228y = i;
        m91a(false);
    }

    @Override // com.mojang.minecraft.level.p003a.C0038i, com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final void mo107a(Level level, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.level.p003a.C0038i, com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final void mo110b(Level level, int i, int i2, int i3, int i4) {
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
            C0045a c0045aMo109d = C0030a.f197a[i4].mo109d();
            if ((this.f227x == C0045a.f249b && c0045aMo109d == C0045a.f250c) || (c0045aMo109d == C0045a.f249b && this.f227x == C0045a.f250c)) {
                level.setTile(i, i2, i3, C0030a.f200c.f219v);
                return;
            }
        }
        if (z) {
            level.setTileNoUpdate(i, i2, i3, this.f229z);
            level.addToTickNextTick(i, i2, i3, this.f229z);
        }
    }
}
