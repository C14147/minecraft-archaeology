package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p001a.C0005c;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.h */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/h.class */
public final class C0037h extends C0030a {
    protected C0037h(int i) {
        super(6);
        this.f218u = 15;
        m91a(true);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final void mo107a(Level level, int i, int i2, int i3, Random random) {
        int tile = level.getTile(i, i2 - 1, i3);
        if (level.isLit(i, i2, i3) && (tile == C0030a.f202e.f219v || tile == C0030a.f201d.f219v)) {
            return;
        }
        level.setTile(i, i2, i3, 0);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final boolean mo94a(C0005c c0005c, Level level, int i, int i2, int i3, int i4) {
        if (level.isLit(i2, i3, i4) ^ (i != 1)) {
            return false;
        }
        int iB = mo98b(15);
        float f = (iB % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iB / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        c0005c.m9a(255, 255, 255);
        for (int i5 = 0; i5 < 2; i5++) {
            float fSin = (float) (Math.sin(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float fCos = (float) (Math.cos(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float f5 = (i2 + 0.5f) - fSin;
            float f6 = i2 + 0.5f + fSin;
            float f7 = i3;
            float f8 = i3 + 1.0f;
            float f9 = (i4 + 0.5f) - fCos;
            float f10 = i4 + 0.5f + fCos;
            c0005c.m10a(f5, f8, f9, f2, f3);
            c0005c.m10a(f6, f8, f10, f, f3);
            c0005c.m10a(f6, f7, f10, f, f4);
            c0005c.m10a(f5, f7, f9, f2, f4);
            c0005c.m10a(f6, f8, f10, f2, f3);
            c0005c.m10a(f5, f8, f9, f, f3);
            c0005c.m10a(f5, f7, f9, f, f4);
            c0005c.m10a(f6, f7, f10, f2, f4);
        }
        return true;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final AABB mo103b(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final boolean mo104a() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final boolean mo105b() {
        return false;
    }
}
