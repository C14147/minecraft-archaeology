package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p002b.C0016b;
import com.mojang.minecraft.p006f.C0031a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.e */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/a/e.class */
public class C0006e extends C0003b {

    /* JADX INFO: renamed from: m */
    protected int f31m;

    /* JADX INFO: renamed from: n */
    protected int f32n;

    /* JADX INFO: renamed from: o */
    protected int f33o;

    /* JADX INFO: renamed from: p */
    private int f34p;

    protected C0006e(int i, int i2) {
        super(i);
        this.f34p = 1;
        this.f31m = i2;
        this.f23k = 14;
        if (i2 == 2) {
            this.f23k = 30;
        }
        if (i2 == 1) {
            this.f34p = 8;
        }
        if (i2 == 2) {
            this.f34p = 2;
        }
        this.f33o = i;
        this.f32n = i + 1;
        m8a(0.0f, 0.0f - 0.1f, 0.0f, 1.0f, 1.0f - 0.1f, 1.0f);
        m7a(true);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public void mo2a(C0013g c0013g, int i, int i2, int i3, Random random) {
        m19c(c0013g, i, i2, i3, 0);
    }

    /* JADX INFO: renamed from: c */
    private boolean m19c(C0013g c0013g, int i, int i2, int i3, int i4) {
        boolean zM20d = false;
        do {
            i2--;
            if (c0013g.m42b(i, i2, i3) == 0) {
                boolean zM38a = c0013g.m38a(i, i2, i3, this.f33o);
                if (zM38a) {
                    zM20d = true;
                }
                if (!zM38a) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f31m != 2);
        int i5 = i2 + 1;
        if (this.f31m == 1 || !zM20d) {
            zM20d = zM20d | m20d(c0013g, i - 1, i5, i3, i4) | m20d(c0013g, i + 1, i5, i3, i4) | m20d(c0013g, i, i5, i3 - 1, i4) | m20d(c0013g, i, i5, i3 + 1, i4);
        }
        if (!zM20d) {
            c0013g.m39b(i, i5, i3, this.f32n);
        }
        return zM20d;
    }

    /* JADX INFO: renamed from: d */
    private boolean m20d(C0013g c0013g, int i, int i2, int i3, int i4) {
        boolean zM19c = false;
        if (c0013g.m42b(i, i2, i3) == 0 && c0013g.m38a(i, i2, i3, this.f33o) && i4 < this.f34p) {
            zM19c = false | m19c(c0013g, i, i2, i3, i4 + 1);
        }
        return zM19c;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    protected final boolean mo9a(C0013g c0013g, int i, int i2, int i3, int i4) {
        int iM42b;
        if (i4 != 2 || (iM42b = c0013g.m42b(i, i2, i3)) == this.f33o || iM42b == this.f32n) {
            return false;
        }
        return super.mo9a(c0013g, i, i2, i3, -1);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final void mo11a(C0016b c0016b, int i, int i2, int i3, int i4) {
        super.mo11a(c0016b, i, i2, i3, i4);
        super.m12b(c0016b, i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: c */
    public final boolean mo15c() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final C0031a mo4a(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: a */
    public final boolean mo5a() {
        return true;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: b */
    public final boolean mo6b() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: d */
    public final int mo17d() {
        return this.f31m;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0003b
    /* JADX INFO: renamed from: b */
    public void mo18b(C0013g c0013g, int i, int i2, int i3, int i4) {
        if (this.f31m == 1 && i4 == C0003b.f21i.f24l) {
            c0013g.m39b(i, i2, i3, C0003b.f15c.f24l);
        }
        if (this.f31m == 2 && i4 == C0003b.f19g.f24l) {
            c0013g.m39b(i, i2, i3, C0003b.f15c.f24l);
        }
    }
}
