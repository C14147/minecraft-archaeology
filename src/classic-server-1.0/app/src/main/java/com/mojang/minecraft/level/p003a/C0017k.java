package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.k */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/k.class */
public final class C0017k extends C0008b {
    protected C0017k(int i) {
        super(2);
        m12a(true);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo8a(Level level, int i, int i2, int i3, Random random) {
        if (random.nextInt(4) != 0) {
            return;
        }
        if (!level.isLit(i, i2 + 1, i3)) {
            level.setTile(i, i2, i3, C0008b.f54e.f71v);
            return;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int iNextInt = (i + random.nextInt(3)) - 1;
            int iNextInt2 = (i2 + random.nextInt(5)) - 3;
            int iNextInt3 = (i3 + random.nextInt(3)) - 1;
            if (level.getTile(iNextInt, iNextInt2, iNextInt3) == C0008b.f54e.f71v && level.isLit(iNextInt, iNextInt2 + 1, iNextInt3)) {
                level.setTile(iNextInt, iNextInt2, iNextInt3, C0008b.f53d.f71v);
            }
        }
    }
}
