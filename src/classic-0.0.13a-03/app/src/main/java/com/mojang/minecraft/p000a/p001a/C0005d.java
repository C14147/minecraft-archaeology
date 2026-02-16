package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0017f;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.d */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a/d.class */
public final class C0005d extends C0006e {
    protected C0005d(int i, int i2) {
        super(i, i2);
        this.f30o = i - 1;
        this.f29n = i;
        m6a(false);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0006e, com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final void mo19a(C0017f c0017f, int i, int i2, int i3, Random random) {
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0006e, com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final void mo22a(C0017f c0017f, int i, int i2, int i3, int i4) {
        boolean z = false;
        if (c0017f.m53b(i - 1, i2, i3) == 0) {
            z = true;
        }
        if (c0017f.m53b(i + 1, i2, i3) == 0) {
            z = true;
        }
        if (c0017f.m53b(i, i2, i3 - 1) == 0) {
            z = true;
        }
        if (c0017f.m53b(i, i2, i3 + 1) == 0) {
            z = true;
        }
        if (c0017f.m53b(i, i2 - 1, i3) == 0) {
            z = true;
        }
        if (z) {
            c0017f.m50b(i, i2, i3, this.f30o);
        }
        if (this.f28m == 1 && i4 == C0002a.f18i.f21l) {
            c0017f.m50b(i, i2, i3, C0002a.f12c.f21l);
        }
        if (this.f28m == 2 && i4 == C0002a.f16g.f21l) {
            c0017f.m50b(i, i2, i3, C0002a.f12c.f21l);
        }
    }
}
