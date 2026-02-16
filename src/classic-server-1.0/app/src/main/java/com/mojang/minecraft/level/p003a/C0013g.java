package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0024a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.g */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/g.class */
public final class C0013g extends C0016j {
    protected C0013g(int i, C0024a c0024a) {
        super(i, c0024a);
        this.f74y = i - 1;
        this.f73x = i;
        m12a(false);
    }

    @Override // com.mojang.minecraft.level.p003a.C0016j, com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo8a(Level level, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.level.p003a.C0016j, com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo15a(Level level, int i, int i2, int i3, int i4) {
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
            C0024a c0024aMo14c = C0008b.f49a[i4].mo14c();
            if ((this.f72w == C0024a.f94b && c0024aMo14c == C0024a.f95c) || (c0024aMo14c == C0024a.f94b && this.f72w == C0024a.f95c)) {
                level.setTile(i, i2, i3, C0008b.f52c.f71v);
                return;
            }
        }
        if (z) {
            level.setTileNoUpdate(i, i2, i3, this.f74y);
            level.addToTickNextTick(i, i2, i3, this.f74y);
        }
    }
}
