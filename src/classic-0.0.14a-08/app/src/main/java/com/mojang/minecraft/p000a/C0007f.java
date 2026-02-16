package com.mojang.minecraft.p000a;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p002a.C0026a;
import com.mojang.minecraft.player.Player;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.a.f */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/f.class */
public final class C0007f {

    /* JADX INFO: renamed from: c */
    private Level f37c;

    /* JADX INFO: renamed from: d */
    private int f38d;

    /* JADX INFO: renamed from: e */
    private static C0004c f39e = C0004c.f27a;

    /* JADX INFO: renamed from: a */
    public static int f40a = 0;

    /* JADX INFO: renamed from: f */
    private int f41f;

    /* JADX INFO: renamed from: g */
    private int f42g;

    /* JADX INFO: renamed from: h */
    private int f43h;

    /* JADX INFO: renamed from: l */
    private boolean[] f47l = new boolean[2];

    /* JADX INFO: renamed from: b */
    public boolean f48b = false;

    /* JADX INFO: renamed from: k */
    private int f46k = 16;

    /* JADX INFO: renamed from: j */
    private int f45j = 16;

    /* JADX INFO: renamed from: i */
    private int f44i = 16;

    public C0007f(Level level, int i, int i2, int i3, int i4) {
        this.f38d = -1;
        this.f37c = level;
        this.f41f = i;
        this.f42g = i2;
        this.f43h = i3;
        Math.sqrt((this.f44i * this.f44i) + (this.f45j * this.f45j) + (this.f46k * this.f46k));
        this.f38d = GL11.glGenLists(2);
        m15c();
    }

    /* JADX INFO: renamed from: a */
    public final float m14a(Player player) {
        float f = player.f3x - this.f41f;
        float f2 = player.f4y - this.f42g;
        float f3 = player.f5z - this.f43h;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    /* JADX INFO: renamed from: c */
    private void m15c() {
        for (int i = 0; i < 2; i++) {
            GL11.glNewList(this.f38d + i, 4864);
            GL11.glEndList();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m16a() {
        GL11.glDeleteLists(this.f38d, 2);
        this.f37c = null;
    }

    /* JADX INFO: renamed from: b */
    public final void m17b() {
        f40a++;
        for (int i = 0; i < 2; i++) {
            int i2 = i;
            int i3 = this.f41f;
            int i4 = this.f42g;
            int i5 = this.f43h;
            int i6 = this.f41f + this.f44i;
            int i7 = this.f42g + this.f45j;
            int i8 = this.f43h + this.f46k;
            GL11.glNewList(this.f38d + i2, 4864);
            f39e.m3b();
            boolean zMo81a = false;
            for (int i9 = i3; i9 < i6; i9++) {
                for (int i10 = i4; i10 < i7; i10++) {
                    for (int i11 = i5; i11 < i8; i11++) {
                        int tile = this.f37c.getTile(i9, i10, i11);
                        if (tile > 0) {
                            zMo81a |= C0026a.f177a[tile].mo81a(f39e, this.f37c, i2, i9, i10, i11);
                        }
                    }
                }
            }
            f39e.m1a();
            GL11.glEndList();
            if (this.f47l[i2] != (!zMo81a)) {
                this.f47l[i2] = !zMo81a;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m18a(IntBuffer intBuffer, int i) {
        if (!this.f48b || this.f47l[i]) {
            return;
        }
        intBuffer.put(this.f38d + i);
    }

    /* JADX INFO: renamed from: a */
    public final void m19a(C0005d c0005d) {
        this.f48b = c0005d.m12a(this.f41f, this.f42g, this.f43h, this.f41f + this.f44i, this.f42g + this.f45j, this.f43h + this.f46k);
    }
}
