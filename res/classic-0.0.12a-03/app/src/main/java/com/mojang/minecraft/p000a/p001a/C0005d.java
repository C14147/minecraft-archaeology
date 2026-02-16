package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0013g;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.d */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/a/d.class */
public final class C0005d extends C0006e {
    protected C0005d(int i, int i2) {
        super(i, i2);
        this.f33o = i - 1;
        this.f32n = i;
        m7a(false);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0006e, com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final void mo2a(C0013g c0013g, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0006e, com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: b */
    public final void mo18b(C0013g c0013g, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (c0013g.m42b(i - 1, i2, i3) == 0) {
            z = true;
        }
        if (c0013g.m42b(i + 1, i2, i3) == 0) {
            z = true;
        }
        if (c0013g.m42b(i, i2, i3 - 1) == 0) {
            z = true;
        }
        if (c0013g.m42b(i, i2, i3 + 1) == 0) {
            z = true;
        }
        if (c0013g.m42b(i, i2 - 1, i3) == 0) {
            z = true;
        }
        if (z) {
            c0013g.m39b(i, i2, i3, this.f33o);
        }
        if (this.f31m == 1 && i4 == C0003b.f21i.f24l) {
            c0013g.m39b(i, i2, i3, C0003b.f15c.f24l);
        }
        if (this.f31m == 2 && i4 == C0003b.f19g.f24l) {
            c0013g.m39b(i, i2, i3, C0003b.f15c.f24l);
        }
    }
}
