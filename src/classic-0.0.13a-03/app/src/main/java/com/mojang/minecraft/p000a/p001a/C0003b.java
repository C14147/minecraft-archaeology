package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p004b.C0020b;
import com.mojang.minecraft.p008f.C0041a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a/b.class */
public final class C0003b extends C0002a {
    protected C0003b(int i) {
        super(6);
        this.f20k = 15;
        m6a(true);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final void mo19a(C0017f c0017f, int i, int i2, int i3, Random random) {
        int iM53b = c0017f.m53b(i, i2 - 1, i3);
        if (c0017f.m52a(i, i2, i3) && (iM53b == C0002a.f14e.f21l || iM53b == C0002a.f13d.f21l)) {
            return;
        }
        c0017f.m49a(i, i2, i3, 0);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final boolean mo8a(C0020b c0020b, C0017f c0017f, int i, int i2, int i3, int i4) {
        if (c0017f.m52a(i2, i3, i4) ^ (i != 1)) {
            return false;
        }
        int iA = mo10a(15);
        float f = (iA % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iA / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        c0020b.m59a(255, 255, 255);
        for (int i5 = 0; i5 < 2; i5++) {
            float fSin = (float) (Math.sin(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float fCos = (float) (Math.cos(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float f5 = (i2 + 0.5f) - fSin;
            float f6 = i2 + 0.5f + fSin;
            float f7 = i3;
            float f8 = i3 + 1.0f;
            float f9 = (i4 + 0.5f) - fCos;
            float f10 = i4 + 0.5f + fCos;
            c0020b.m61a(f5, f8, f9, f2, f3);
            c0020b.m61a(f6, f8, f10, f, f3);
            c0020b.m61a(f6, f7, f10, f, f4);
            c0020b.m61a(f5, f7, f9, f2, f4);
            c0020b.m61a(f6, f8, f10, f2, f3);
            c0020b.m61a(f5, f8, f9, f, f3);
            c0020b.m61a(f5, f7, f9, f, f4);
            c0020b.m61a(f6, f7, f10, f2, f4);
        }
        return true;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: b */
    public final C0041a mo15b(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final boolean mo16a() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: b */
    public final boolean mo17b() {
        return false;
    }
}
