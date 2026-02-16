package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.e */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/e.class */
public final class C0011e extends C0008b {
    protected C0011e(int i) {
        super(19);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: b */
    public final void mo18b(Level level, int i, int i2, int i3) {
        for (int i4 = i - 2; i4 <= i + 2; i4++) {
            for (int i5 = i2 - 2; i5 <= i2 + 2; i5++) {
                for (int i6 = i3 - 2; i6 <= i3 + 2; i6++) {
                    if (level.isWater(i4, i5, i6)) {
                        level.setTileNoNeighborChange(i4, i5, i6, 0);
                    }
                }
            }
        }
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: c */
    public final void mo19c(Level level, int i, int i2, int i3) {
        for (int i4 = i - 2; i4 <= i + 2; i4++) {
            for (int i5 = i2 - 2; i5 <= i2 + 2; i5++) {
                for (int i6 = i3 - 2; i6 <= i3 + 2; i6++) {
                    level.updateNeighborsAt(i4, i5, i6, level.getTile(i4, i5, i6));
                }
            }
        }
    }
}
