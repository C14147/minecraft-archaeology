package com.mojang.minecraft.level.p003a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p006c.C0045a;
import com.mojang.minecraft.p001a.C0005c;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.i */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a/i.class */
public class C0038i extends C0030a {

    /* JADX INFO: renamed from: x */
    protected C0045a f227x;

    /* JADX INFO: renamed from: y */
    protected int f228y;

    /* JADX INFO: renamed from: z */
    protected int f229z;

    protected C0038i(int i, C0045a c0045a) {
        super(i);
        this.f227x = c0045a;
        this.f218u = 14;
        if (c0045a == C0045a.f250c) {
            this.f218u = 30;
        }
        this.f229z = i;
        this.f228y = i + 1;
        m92a(0.0f, 0.0f - 0.1f, 0.0f, 1.0f, 1.0f - 0.1f, 1.0f);
        m91a(true);
        if (c0045a == C0045a.f250c) {
            m93a(16);
        }
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final void mo111b(Level level, int i, int i2, int i3) {
        level.addToTickNextTick(i, i2, i3, this.f229z);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public void mo107a(Level level, int i, int i2, int i3, Random random) {
        int i4 = i2;
        boolean zM114c = false;
        do {
            i4--;
            if (level.getTile(i, i4, i3) == 0) {
                boolean tile = level.setTile(i, i4, i3, this.f229z);
                if (tile) {
                    zM114c = true;
                }
                if (!tile) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f227x != C0045a.f250c);
        int i5 = i4 + 1;
        if (this.f227x == C0045a.f249b || !zM114c) {
            zM114c = zM114c | m114c(level, i - 1, i5, i3) | m114c(level, i + 1, i5, i3) | m114c(level, i, i5, i3 - 1) | m114c(level, i, i5, i3 + 1);
        }
        if (zM114c) {
            level.addToTickNextTick(i, i5, i3, this.f229z);
        } else {
            level.setTileNoUpdate(i, i5, i3, this.f228y);
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m114c(Level level, int i, int i2, int i3) {
        if (level.getTile(i, i2, i3) != 0 || !level.setTile(i, i2, i3, this.f229z)) {
            return false;
        }
        level.addToTickNextTick(i, i2, i3, this.f229z);
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    protected final float mo95a(Level level, int i, int i2, int i3) {
        if (this.f227x == C0045a.f250c) {
            return 100.0f;
        }
        return level.getBrightness(i, i2, i3);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    protected final boolean mo97a(Level level, int i, int i2, int i3, int i4, int i5) {
        int tile;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= level.width || i3 >= level.height) {
            return false;
        }
        if ((i4 != 1 && this.f227x == C0045a.f249b) || (tile = level.getTile(i, i2, i3)) == this.f229z || tile == this.f228y) {
            return false;
        }
        if (i5 == 1 && (level.getTile(i - 1, i2, i3) == 0 || level.getTile(i + 1, i2, i3) == 0 || level.getTile(i, i2, i3 - 1) == 0 || level.getTile(i, i2, i3 + 1) == 0)) {
            return true;
        }
        return super.mo97a(level, i, i2, i3, -1, i5);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final void mo99a(C0005c c0005c, int i, int i2, int i3, int i4) {
        super.mo99a(c0005c, i, i2, i3, i4);
        super.m100b(c0005c, i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: c */
    public final boolean mo106c() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final AABB mo103b(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: a */
    public final boolean mo104a() {
        return true;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public final boolean mo105b() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: d */
    public final C0045a mo109d() {
        return this.f227x;
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: b */
    public void mo110b(Level level, int i, int i2, int i3, int i4) {
        if (i4 != 0) {
            C0045a c0045aMo109d = C0030a.f197a[i4].mo109d();
            if ((this.f227x == C0045a.f249b && c0045aMo109d == C0045a.f250c) || (c0045aMo109d == C0045a.f249b && this.f227x == C0045a.f250c)) {
                level.setTile(i, i2, i3, C0030a.f200c.f219v);
                return;
            }
        }
        level.addToTickNextTick(i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p003a.C0030a
    /* JADX INFO: renamed from: e */
    public final int mo112e() {
        return this.f227x == C0045a.f250c ? 5 : 0;
    }
}
