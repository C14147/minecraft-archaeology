package com.mojang.minecraft.p006d;

import com.mojang.minecraft.C0033e;
import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p004b.C0019a;
import com.mojang.minecraft.p004b.C0020b;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.d.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/d/a.class */
public final class C0031a {

    /* JADX INFO: renamed from: a */
    public List f176a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private C0019a f177b;

    public C0031a(C0017f c0017f, C0019a c0019a) {
        this.f177b = c0019a;
    }

    /* JADX INFO: renamed from: a */
    public final void m101a(C0033e c0033e, float f, int i) {
        if (this.f176a.size() == 0) {
            return;
        }
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f177b.m55a("/terrain.png", 9728));
        float f2 = -((float) Math.cos((((double) c0033e.f240n) * 3.141592653589793d) / 180.0d));
        float f3 = -((float) Math.sin((((double) c0033e.f240n) * 3.141592653589793d) / 180.0d));
        float fSin = (-f3) * ((float) Math.sin((((double) c0033e.f241o) * 3.141592653589793d) / 180.0d));
        float fSin2 = f2 * ((float) Math.sin((((double) c0033e.f241o) * 3.141592653589793d) / 180.0d));
        float fCos = (float) Math.cos((((double) c0033e.f241o) * 3.141592653589793d) / 180.0d);
        C0020b c0020b = C0020b.f104a;
        GL11.glColor4f(0.8f, 0.8f, 0.8f, 1.0f);
        c0020b.m58b();
        for (int i2 = 0; i2 < this.f176a.size(); i2++) {
            C0032b c0032b = (C0032b) this.f176a.get(i2);
            if (c0032b.m120e() ^ (i == 1)) {
                float f4 = ((c0032b.f181a % 16) + (c0032b.f182b / 4.0f)) / 16.0f;
                float f5 = f4 + 0.015609375f;
                float f6 = ((c0032b.f181a / 16) + (c0032b.f183c / 4.0f)) / 16.0f;
                float f7 = f6 + 0.015609375f;
                float f8 = 0.1f * c0032b.f186d;
                float f9 = c0032b.f231e + ((c0032b.f234h - c0032b.f231e) * f);
                float f10 = c0032b.f232f + ((c0032b.f235i - c0032b.f232f) * f);
                float f11 = c0032b.f233g + ((c0032b.f236j - c0032b.f233g) * f);
                c0020b.m61a((f9 - (f2 * f8)) - (fSin * f8), f10 - (fCos * f8), (f11 - (f3 * f8)) - (fSin2 * f8), f4, f7);
                c0020b.m61a((f9 - (f2 * f8)) + (fSin * f8), f10 + (fCos * f8), (f11 - (f3 * f8)) + (fSin2 * f8), f4, f6);
                c0020b.m61a(f9 + (f2 * f8) + (fSin * f8), f10 + (fCos * f8), f11 + (f3 * f8) + (fSin2 * f8), f5, f6);
                c0020b.m61a((f9 + (f2 * f8)) - (fSin * f8), f10 - (fCos * f8), (f11 + (f3 * f8)) - (fSin2 * f8), f5, f7);
            }
        }
        c0020b.m56a();
        GL11.glDisable(3553);
    }
}
