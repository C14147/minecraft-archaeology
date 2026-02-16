package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0017f;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.f */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a/f.class */
public final class C0007f extends C0002a {
    protected C0007f(int i) {
        super(2);
        this.f20k = 3;
        m6a(true);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    protected final int mo10a(int i) {
        if (i == 1) {
            return 0;
        }
        return i == 0 ? 2 : 3;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final void mo19a(C0017f c0017f, int i, int i2, int i3, Random random) {
        if (random.nextInt(4) != 0) {
            return;
        }
        if (!c0017f.m52a(i, i2 + 1, i3)) {
            c0017f.m49a(i, i2, i3, C0002a.f14e.f21l);
            return;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int iNextInt = (i + random.nextInt(3)) - 1;
            int iNextInt2 = (i2 + random.nextInt(5)) - 3;
            int iNextInt3 = (i3 + random.nextInt(3)) - 1;
            if (c0017f.m53b(iNextInt, iNextInt2, iNextInt3) == C0002a.f14e.f21l && c0017f.m52a(iNextInt, iNextInt2 + 1, iNextInt3)) {
                c0017f.m49a(iNextInt, iNextInt2, iNextInt3, C0002a.f13d.f21l);
            }
        }
    }
}
