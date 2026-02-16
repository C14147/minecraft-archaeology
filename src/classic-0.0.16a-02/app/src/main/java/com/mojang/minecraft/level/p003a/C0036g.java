package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.g */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/g.class */
public final class C0036g extends C0030a {
    protected C0036g(int i) {
        super(2);
        this.f218u = 3;
        m91a(true);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    protected final int mo98b(int i) {
        if (i == 1) {
            return 0;
        }
        return i == 0 ? 2 : 3;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final void mo107a(Level level, int i, int i2, int i3, Random random) {
        if (random.nextInt(4) != 0) {
            return;
        }
        if (!level.isLit(i, i2 + 1, i3)) {
            level.setTile(i, i2, i3, C0030a.f202e.f219v);
            return;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int iNextInt = (i + random.nextInt(3)) - 1;
            int iNextInt2 = (i2 + random.nextInt(5)) - 3;
            int iNextInt3 = (i3 + random.nextInt(3)) - 1;
            if (level.getTile(iNextInt, iNextInt2, iNextInt3) == C0030a.f202e.f219v && level.isLit(iNextInt, iNextInt2 + 1, iNextInt3)) {
                level.setTile(iNextInt, iNextInt2, iNextInt3, C0030a.f201d.f219v);
            }
        }
    }
}
