package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p002b.C0016b;
import com.mojang.minecraft.p006f.C0031a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/a/a.class */
public final class C0002a extends C0003b {
    protected C0002a(int i) {
        super(6);
        this.f23k = 15;
        m7a(true);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final void mo2a(C0013g c0013g, int i, int i2, int i3, Random random) {
        int iM42b = c0013g.m42b(i, i2 - 1, i3);
        if (c0013g.m41a(i, i2, i3) && (iM42b == C0003b.f17e.f24l || iM42b == C0003b.f16d.f24l)) {
            return;
        }
        c0013g.m38a(i, i2, i3, 0);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final void mo3a(C0016b c0016b, C0013g c0013g, int i, int i2, int i3, int i4) {
        if (c0013g.m41a(i2, i3, i4) ^ (i != 1)) {
            return;
        }
        int iA = mo10a(15);
        float f = (iA % 16) / 16.0f;
        float f2 = f + 0.0624375f;
        float f3 = (iA / 16) / 16.0f;
        float f4 = f3 + 0.0624375f;
        c0016b.m49a(255, 255, 255);
        for (int i5 = 0; i5 < 2; i5++) {
            float fSin = (float) (Math.sin(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float fCos = (float) (Math.cos(((((double) i5) * 3.141592653589793d) / ((double) 2)) + 0.7853981633974483d) * 0.5d);
            float f5 = (i2 + 0.5f) - fSin;
            float f6 = i2 + 0.5f + fSin;
            float f7 = i3;
            float f8 = i3 + 1.0f;
            float f9 = (i4 + 0.5f) - fCos;
            float f10 = i4 + 0.5f + fCos;
            c0016b.m51a(f5, f8, f9, f2, f3);
            c0016b.m51a(f6, f8, f10, f, f3);
            c0016b.m51a(f6, f7, f10, f, f4);
            c0016b.m51a(f5, f7, f9, f2, f4);
            c0016b.m51a(f6, f8, f10, f, f3);
            c0016b.m51a(f5, f8, f9, f2, f3);
            c0016b.m51a(f5, f7, f9, f2, f4);
            c0016b.m51a(f6, f7, f10, f, f4);
        }
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final C0031a mo4a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final boolean mo5a() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: b */
    public final boolean mo6b() {
        return false;
    }
}
