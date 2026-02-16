package com.mojang.minecraft;

import com.mojang.minecraft.player.Player;

/* JADX INFO: renamed from: com.mojang.minecraft.e */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/e.class */
public final class C0028e {

    /* JADX INFO: renamed from: a */
    public int f187a;

    /* JADX INFO: renamed from: b */
    public int f188b;

    /* JADX INFO: renamed from: c */
    public int f189c;

    /* JADX INFO: renamed from: d */
    public int f190d;

    public C0028e(int i, int i2, int i3, int i4, int i5) {
        this.f187a = i2;
        this.f188b = i3;
        this.f189c = i4;
        this.f190d = i5;
    }

    /* JADX INFO: renamed from: a */
    float m80a(Player player, int i) {
        int i2 = this.f187a;
        int i3 = this.f188b;
        int i4 = this.f189c;
        if (i == 1) {
            if (this.f190d == 0) {
                i3--;
            }
            if (this.f190d == 1) {
                i3++;
            }
            if (this.f190d == 2) {
                i4--;
            }
            if (this.f190d == 3) {
                i4++;
            }
            if (this.f190d == 4) {
                i2--;
            }
            if (this.f190d == 5) {
                i2++;
            }
        }
        float f = i2 - player.f11x;
        float f2 = i3 - player.f12y;
        float f3 = i4 - player.f13z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }
}
