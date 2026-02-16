package com.mojang.minecraft.level.p002a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.p000a.C0004c;
import com.mojang.minecraft.phys.AABB;
import java.util.Random;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a.i */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/a/i.class */
public class C0034i extends C0026a {

    /* JADX INFO: renamed from: w */
    protected int f205w;

    /* JADX INFO: renamed from: x */
    protected int f206x;

    /* JADX INFO: renamed from: y */
    protected int f207y;

    protected C0034i(int i, int i2) {
        super(i);
        this.f205w = i2;
        this.f197u = 14;
        if (i2 == 2) {
            this.f197u = 30;
        }
        this.f207y = i;
        this.f206x = i + 1;
        m80a(0.0f, 0.0f - 0.1f, 0.0f, 1.0f, 1.0f - 0.1f, 1.0f);
        m79a(true);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public final void mo97a(Level level, int i, int i2, int i3) {
        level.addToTickNextTick(i, i2, i3, this.f207y);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public void mo93a(Level level, int i, int i2, int i3, Random random) {
        int i4 = i2;
        boolean zM99b = false;
        do {
            i4--;
            if (level.getTile(i, i4, i3) == 0) {
                boolean tile = level.setTile(i, i4, i3, this.f207y);
                if (tile) {
                    zM99b = true;
                }
                if (!tile) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f205w != 2);
        int i5 = i4 + 1;
        if (this.f205w == 1 || !zM99b) {
            zM99b = zM99b | m99b(level, i - 1, i5, i3) | m99b(level, i + 1, i5, i3) | m99b(level, i, i5, i3 - 1) | m99b(level, i, i5, i3 + 1);
        }
        if (zM99b) {
            level.addToTickNextTick(i, i5, i3, this.f207y);
        } else {
            level.setTileNoUpdate(i, i5, i3, this.f206x);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m99b(Level level, int i, int i2, int i3) {
        if (level.getTile(i, i2, i3) != 0 || !level.setTile(i, i2, i3, this.f207y)) {
            return false;
        }
        level.addToTickNextTick(i, i2, i3, this.f207y);
        return false;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    protected final boolean mo83a(Level level, int i, int i2, int i3, int i4, int i5) {
        int tile;
        if (i < 0 || i2 < 0 || i3 < 0 || i >= level.width || i3 >= level.height) {
            return false;
        }
        if ((i4 != 1 && this.f205w == 1) || (tile = level.getTile(i, i2, i3)) == this.f207y || tile == this.f206x) {
            return false;
        }
        return super.mo83a(level, i, i2, i3, -1, i5);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public final void mo85a(C0004c c0004c, int i, int i2, int i3, int i4) {
        super.mo85a(c0004c, i, i2, i3, i4);
        super.m86b(c0004c, i, i2, i3, i4);
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: c */
    public final boolean mo92c() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: b */
    public final AABB mo89b(int i, int i2, int i3) {
        return null;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: a */
    public final boolean mo90a() {
        return true;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: b */
    public final boolean mo91b() {
        return false;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: d */
    public final int mo95d() {
        return this.f205w;
    }

    @Override // com.mojang.minecraft.level.p002a.C0026a
    /* JADX INFO: renamed from: b */
    public void mo96b(Level level, int i, int i2, int i3, int i4) {
        if (this.f205w == 1 && (i4 == C0026a.f188l.f198v || i4 == C0026a.f189m.f198v)) {
            level.setTileNoUpdate(i, i2, i3, C0026a.f179c.f198v);
        }
        if (this.f205w == 2 && (i4 == C0026a.f186j.f198v || i4 == C0026a.f187k.f198v)) {
            level.setTileNoUpdate(i, i2, i3, C0026a.f179c.f198v);
        }
        level.addToTickNextTick(i, i2, i3, i4);
    }
}
