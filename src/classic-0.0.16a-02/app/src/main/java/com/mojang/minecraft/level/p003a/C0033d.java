package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/d.class */
public final class C0033d extends C0030a {
    public C0033d(int i, int i2) {
        super(i, i2);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final void mo111b(Level level, int i, int i2, int i3) {
        m113c(level, i, i2, i3);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final void mo110b(Level level, int i, int i2, int i3, int i4) {
        m113c(level, i, i2, i3);
    }

    /* JADX INFO: renamed from: c */
    private static void m113c(Level level, int i, int i2, int i3) {
        int i4 = i2;
        while (level.getTile(i, i4 - 1, i3) == 0 && i4 > 0) {
            i4--;
        }
        if (i4 != i2) {
            level.swap(i, i2, i3, i, i4, i3);
        }
    }
}
