package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.i */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/i.class */
public final class C0014i extends C0007b {
    protected C0014i(int i) {
        super(2);
        m13a(true);
    }

    @Override // com.mojang.minecraft.level.p003a.C0007b
    /* JADX INFO: renamed from: a */
    public final void mo9a(Level level, int i, int i2, int i3, Random random) {
        if (random.nextInt(4) != 0) {
            return;
        }
        if (!level.isLit(i, i2 + 1, i3)) {
            level.setTile(i, i2, i3, C0007b.f53e.f66r);
            return;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int iNextInt = (i + random.nextInt(3)) - 1;
            int iNextInt2 = (i2 + random.nextInt(5)) - 3;
            int iNextInt3 = (i3 + random.nextInt(3)) - 1;
            if (level.getTile(iNextInt, iNextInt2, iNextInt3) == C0007b.f53e.f66r && level.isLit(iNextInt, iNextInt2 + 1, iNextInt3)) {
                level.setTile(iNextInt, iNextInt2, iNextInt3, C0007b.f52d.f66r);
            }
        }
    }
}
