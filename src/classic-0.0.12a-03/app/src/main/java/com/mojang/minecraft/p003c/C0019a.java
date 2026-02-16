package com.mojang.minecraft.p003c;

import com.mojang.minecraft.C0021d;
import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p002b.C0015a;
import com.mojang.minecraft.p002b.C0016b;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.c.a */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/c/a.class */
public final class C0019a {

    /* JADX INFO: renamed from: a */
    public List f133a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private C0015a f134b;

    public C0019a(C0013g c0013g, C0015a c0015a) {
        this.f134b = c0015a;
    }

    /* JADX INFO: renamed from: a */
    public final void m68a(C0021d c0021d, float f, int i) {
        if (this.f133a.size() == 0) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f134b.m45a("/terrain.png", 9728));
        float f2 = -((float) Math.cos((((double) c0021d.f191n) * 3.141592653589793d) / 180.0d));
        float f3 = -((float) Math.sin((((double) c0021d.f191n) * 3.141592653589793d) / 180.0d));
        float fSin = (-f3) * ((float) Math.sin((((double) c0021d.f192o) * 3.141592653589793d) / 180.0d));
        float fSin2 = f2 * ((float) Math.sin((((double) c0021d.f192o) * 3.141592653589793d) / 180.0d));
        float fCos = (float) Math.cos((((double) c0021d.f192o) * 3.141592653589793d) / 180.0d);
        C0016b c0016b = C0016b.f97a;
        GL11.glColor4f(0.8f, 0.8f, 0.8f, 1.0f);
        c0016b.m48b();
        for (int i2 = 0; i2 < this.f133a.size(); i2++) {
            C0020b c0020b = (C0020b) this.f133a.get(i2);
            if (c0020b.m86e() ^ (i == 1)) {
                float f4 = ((c0020b.f138a % 16) + (c0020b.f139b / 4.0f)) / 16.0f;
                float f5 = f4 + 0.015609375f;
                float f6 = ((c0020b.f138a / 16) + (c0020b.f140c / 4.0f)) / 16.0f;
                float f7 = f6 + 0.015609375f;
                float f8 = 0.1f * c0020b.f143d;
                float f9 = c0020b.f182e + ((c0020b.f185h - c0020b.f182e) * f);
                float f10 = c0020b.f183f + ((c0020b.f186i - c0020b.f183f) * f);
                float f11 = c0020b.f184g + ((c0020b.f187j - c0020b.f184g) * f);
                c0016b.m51a((f9 - (f2 * f8)) - (fSin * f8), f10 - (fCos * f8), (f11 - (f3 * f8)) - (fSin2 * f8), f4, f7);
                c0016b.m51a((f9 - (f2 * f8)) + (fSin * f8), f10 + (fCos * f8), (f11 - (f3 * f8)) + (fSin2 * f8), f4, f6);
                c0016b.m51a(f9 + (f2 * f8) + (fSin * f8), f10 + (fCos * f8), f11 + (f3 * f8) + (fSin2 * f8), f5, f6);
                c0016b.m51a((f9 + (f2 * f8)) - (fSin * f8), f10 - (fCos * f8), (f11 + (f3 * f8)) - (fSin2 * f8), f5, f7);
            }
        }
        c0016b.m46a();
        GL11.glDisable(3553);
    }
}
