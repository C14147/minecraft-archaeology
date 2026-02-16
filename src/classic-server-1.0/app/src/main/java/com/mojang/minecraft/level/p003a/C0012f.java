package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.f */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/f.class */
public final class C0012f extends C0008b {
    public C0012f(int i, int i2) {
        super(i, i2);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo16a(Level level, int i, int i2, int i3) {
        m20d(level, i, i2, i3);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo15a(Level level, int i, int i2, int i3, int i4) {
        m20d(level, i, i2, i3);
    }

    /* JADX INFO: renamed from: d */
    private static void m20d(Level level, int i, int i2, int i3) {
        int i4 = i2;
        while (level.getTile(i, i4 - 1, i3) == 0 && i4 > 0) {
            i4--;
        }
        if (i4 != i2) {
            level.swap(i, i2, i3, i, i4, i3);
        }
    }
}
