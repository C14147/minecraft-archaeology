package com.mojang.minecraft.p000a.p001a;

import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p004b.C0020b;
import com.mojang.minecraft.p008f.C0041a;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a.e */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a/e.class */
public class C0006e extends C0002a {

    /* JADX INFO: renamed from: m */
    protected int f28m;

    /* JADX INFO: renamed from: n */
    protected int f29n;

    /* JADX INFO: renamed from: o */
    protected int f30o;

    /* JADX INFO: renamed from: p */
    private int f31p;

    protected C0006e(int i, int i2) {
        super(i);
        this.f31p = 1;
        this.f28m = i2;
        this.f20k = 14;
        if (i2 == 2) {
            this.f20k = 30;
        }
        if (i2 == 1) {
            this.f31p = 8;
        }
        if (i2 == 2) {
            this.f31p = 2;
        }
        this.f30o = i;
        this.f29n = i + 1;
        m7a(0.0f, 0.0f - 0.1f, 0.0f, 1.0f, 1.0f - 0.1f, 1.0f);
        m6a(true);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public void mo19a(C0017f c0017f, int i, int i2, int i3, Random random) {
        m23b(c0017f, i, i2, i3, 0);
    }

    /* JADX INFO: renamed from: b */
    private boolean m23b(C0017f c0017f, int i, int i2, int i3, int i4) {
        boolean zM24c = false;
        do {
            i2--;
            if (c0017f.m53b(i, i2, i3) == 0) {
                boolean zM49a = c0017f.m49a(i, i2, i3, this.f30o);
                if (zM49a) {
                    zM24c = true;
                }
                if (!zM49a) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f28m != 2);
        int i5 = i2 + 1;
        if (this.f28m == 1 || !zM24c) {
            zM24c = zM24c | m24c(c0017f, i - 1, i5, i3, i4) | m24c(c0017f, i + 1, i5, i3, i4) | m24c(c0017f, i, i5, i3 - 1, i4) | m24c(c0017f, i, i5, i3 + 1, i4);
        }
        if (!zM24c) {
            c0017f.m50b(i, i5, i3, this.f29n);
        }
        return zM24c;
    }

    /* JADX INFO: renamed from: c */
    private boolean m24c(C0017f c0017f, int i, int i2, int i3, int i4) {
        boolean zM23b = false;
        if (c0017f.m53b(i, i2, i3) == 0 && c0017f.m49a(i, i2, i3, this.f30o) && i4 < this.f31p) {
            zM23b = false | m23b(c0017f, i, i2, i3, i4 + 1);
        }
        return zM23b;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    protected final boolean mo9a(C0017f c0017f, int i, int i2, int i3, int i4, int i5) {
        int iM53b;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= c0017f.f77a || i3 >= c0017f.f78b) {
            return false;
        }
        if ((i4 != 2 && this.f28m == 1) || (iM53b = c0017f.m53b(i, i2, i3)) == this.f30o || iM53b == this.f29n) {
            return false;
        }
        return super.mo9a(c0017f, i, i2, i3, -1, i5);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final void mo11a(C0020b c0020b, int i, int i2, int i3, int i4) {
        super.mo11a(c0020b, i, i2, i3, i4);
        super.m12b(c0020b, i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: c */
    public final boolean mo18c() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: b */
    public final C0041a mo15b(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public final boolean mo16a() {
        return true;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: b */
    public final boolean mo17b() {
        return false;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: d */
    public final int mo21d() {
        return this.f28m;
    }

    @Override // com.mojang.minecraft.p000a.p001a.C0002a
    /* JADX INFO: renamed from: a */
    public void mo22a(C0017f c0017f, int i, int i2, int i3, int i4) {
        if (this.f28m == 1 && (i4 == C0002a.f18i.f21l || i4 == C0002a.f19j.f21l)) {
            c0017f.m50b(i, i2, i3, C0002a.f12c.f21l);
        }
        if (this.f28m == 2) {
            if (i4 == C0002a.f16g.f21l || i4 == C0002a.f17h.f21l) {
                c0017f.m50b(i, i2, i3, C0002a.f12c.f21l);
            }
        }
    }
}
