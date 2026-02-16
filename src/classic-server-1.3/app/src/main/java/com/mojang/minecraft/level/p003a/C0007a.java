package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/a.class */
public final class C0007a extends C0008b {
    protected C0007a(int i) {
        super(6);
        m13a(true);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo9a(Level level, int i, int i2, int i3, Random random) {
        int tile = level.getTile(i, i2 - 1, i3);
        if (level.isLit(i, i2, i3) && (tile == C0008b.f54e.f70u || tile == C0008b.f53d.f70u)) {
            return;
        }
        level.setTile(i, i2, i3, 0);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final AABB mo10a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final boolean mo11a() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: b */
    public final boolean mo12b() {
        return false;
    }
}
