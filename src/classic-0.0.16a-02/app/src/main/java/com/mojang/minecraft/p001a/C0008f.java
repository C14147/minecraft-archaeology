package com.mojang.minecraft.p001a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.player.Player;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.f */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/f.class */
public final class C0008f {

    /* JADX INFO: renamed from: c */
    private Level f45c;

    /* JADX INFO: renamed from: d */
    private int f46d;

    /* JADX INFO: renamed from: e */
    private static C0005c f47e = C0005c.f35a;

    /* JADX INFO: renamed from: a */
    public static int f48a = 0;

    /* JADX INFO: renamed from: f */
    private int f49f;

    /* JADX INFO: renamed from: g */
    private int f50g;

    /* JADX INFO: renamed from: h */
    private int f51h;

    /* JADX INFO: renamed from: l */
    private boolean[] f55l = new boolean[2];

    /* JADX INFO: renamed from: b */
    public boolean f56b = false;

    /* JADX INFO: renamed from: k */
    private int f54k = 16;

    /* JADX INFO: renamed from: j */
    private int f53j = 16;

    /* JADX INFO: renamed from: i */
    private int f52i = 16;

    public C0008f(Level level, int i, int i2, int i3, int i4) {
        this.f46d = -1;
        this.f45c = level;
        this.f49f = i;
        this.f50g = i2;
        this.f51h = i3;
        Math.sqrt((this.f52i * this.f52i) + (this.f53j * this.f53j) + (this.f54k * this.f54k));
        this.f46d = GL11.glGenLists(2);
        m19c();
    }

    /* JADX INFO: renamed from: a */
    public final float m18a(Player player) {
        float f = player.f11x - this.f49f;
        float f2 = player.f12y - this.f50g;
        float f3 = player.f13z - this.f51h;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    /* JADX INFO: renamed from: c */
    private void m19c() {
        for (int i = 0; i < 2; i++) {
            GL11.glNewList(this.f46d + i, 4864);
            GL11.glEndList();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m20a() {
        GL11.glDeleteLists(this.f46d, 2);
        this.f45c = null;
    }

    /* JADX INFO: renamed from: b */
    public final void m21b() {
        f48a++;
        for (int i = 0; i < 2; i++) {
            int i2 = i;
            int i3 = this.f49f;
            int i4 = this.f50g;
            int i5 = this.f51h;
            int i6 = this.f49f + this.f52i;
            int i7 = this.f50g + this.f53j;
            int i8 = this.f51h + this.f54k;
            GL11.glNewList(this.f46d + i2, 4864);
            f47e.m7b();
            boolean zMo94a = false;
            for (int i9 = i3; i9 < i6; i9++) {
                for (int i10 = i4; i10 < i7; i10++) {
                    for (int i11 = i5; i11 < i8; i11++) {
                        int tile = this.f45c.getTile(i9, i10, i11);
                        if (tile > 0) {
                            zMo94a |= C0030a.f197a[tile].mo94a(f47e, this.f45c, i2, i9, i10, i11);
                        }
                    }
                }
            }
            f47e.m5a();
            GL11.glEndList();
            if (this.f55l[i2] != (!zMo94a)) {
                this.f55l[i2] = !zMo94a;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m22a(IntBuffer intBuffer, int i) {
        if (!this.f56b || this.f55l[i]) {
            return;
        }
        intBuffer.put(this.f46d + i);
    }

    /* JADX INFO: renamed from: a */
    public final void m23a(C0006d c0006d) {
        this.f56b = c0006d.m16a(this.f49f, this.f50g, this.f51h, this.f49f + this.f52i, this.f50g + this.f53j, this.f51h + this.f54k);
    }
}
