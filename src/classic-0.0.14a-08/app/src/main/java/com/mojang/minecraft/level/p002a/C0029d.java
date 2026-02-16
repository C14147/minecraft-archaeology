package com.mojang.minecraft.level.p002a;

import com.mojang.minecraft.level.Level;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.d */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/a/d.class */
public final class C0029d extends C0026a {
    public C0029d(int i, int i2) {
        super(i, i2);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public final void mo97a(Level level, int i, int i2, int i3) {
        m98b(level, i, i2, i3);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: b */
    public final void mo96b(Level level, int i, int i2, int i3, int i4) {
        m98b(level, i, i2, i3);
    }

    /* JADX INFO: renamed from: b */
    private static void m98b(Level level, int i, int i2, int i3) {
        int i4 = i2;
        while (level.getTile(i, i4 - 1, i3) == 0 && i4 > 0) {
            i4--;
        }
        if (i4 != i2) {
            level.swap(i, i2, i3, i, i4, i3);
        }
    }
}
