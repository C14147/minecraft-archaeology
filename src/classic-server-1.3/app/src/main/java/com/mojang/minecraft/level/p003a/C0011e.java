package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.e */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a/e.class */
public final class C0011e extends C0008b {
    public C0011e(int i, int i2) {
        super(i, i2);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo17a(Level level, int i, int i2, int i3) {
        m19b(level, i, i2, i3);
    }

    @Override // com.mojang.minecraft.level.p003a.C0008b
    /* JADX INFO: renamed from: a */
    public final void mo16a(Level level, int i, int i2, int i3, int i4) {
        m19b(level, i, i2, i3);
    }

    /* JADX INFO: renamed from: b */
    private static void m19b(Level level, int i, int i2, int i3) {
        int i4 = i2;
        while (level.getTile(i, i4 - 1, i3) == 0 && i4 > 0) {
            i4--;
        }
        if (i4 != i2) {
            level.swap(i, i2, i3, i, i4, i3);
        }
    }
}
