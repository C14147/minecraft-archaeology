package com.mojang.minecraft;

import com.mojang.minecraft.player.Player;

/* JADX INFO: renamed from: com.mojang.minecraft.d */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/d.class */
public final class C0024d {

    /* JADX INFO: renamed from: a */
    public int f167a;

    /* JADX INFO: renamed from: b */
    public int f168b;

    /* JADX INFO: renamed from: c */
    public int f169c;

    /* JADX INFO: renamed from: d */
    public int f170d;

    public C0024d(int i, int i2, int i3, int i4, int i5) {
        this.f167a = i2;
        this.f168b = i3;
        this.f169c = i4;
        this.f170d = i5;
    }

    /* JADX INFO: renamed from: a */
    float m69a(Player player, int i) {
        int i2 = this.f167a;
        int i3 = this.f168b;
        int i4 = this.f169c;
        if (i == 1) {
            if (this.f170d == 0) {
                i3--;
            }
            if (this.f170d == 1) {
                i3++;
            }
            if (this.f170d == 2) {
                i4--;
            }
            if (this.f170d == 3) {
                i4++;
            }
            if (this.f170d == 4) {
                i2--;
            }
            if (this.f170d == 5) {
                i2++;
            }
        }
        float f = i2 - player.f3x;
        float f2 = i3 - player.f4y;
        float f3 = i4 - player.f5z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }
}
