package com.mojang.minecraft.level.p002a;

import com.mojang.minecraft.level.Level;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.e */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/a/e.class */
public final class C0030e extends C0034i {
    protected C0030e(int i, int i2) {
        super(i, i2);
        this.f207y = i - 1;
        this.f206x = i;
        m79a(false);
    }

    @Override // com.mojang.minecraft.level.p002a.C0034i, com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public final void mo93a(Level level, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.level.p002a.C0034i, com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: b */
    public final void mo96b(Level level, int i, int i2, int i3, int i4) {
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
        if (this.f205w == 1 && i4 == C0026a.f188l.f198v) {
            level.setTileNoUpdate(i, i2, i3, C0026a.f179c.f198v);
            return;
        }
        if (this.f205w == 2 && i4 == C0026a.f186j.f198v) {
            level.setTileNoUpdate(i, i2, i3, C0026a.f179c.f198v);
        } else if (z) {
            level.setTileNoUpdate(i, i2, i3, this.f207y);
            level.addToTickNextTick(i, i2, i3, this.f207y);
        }
    }
}
