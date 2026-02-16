package com.mojang.minecraft.player;

/* JADX INFO: renamed from: com.mojang.minecraft.player.b */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/player/b.class */
public final class C0051b extends C0050a {

    /* JADX INFO: renamed from: e */
    private boolean[] f302e = new boolean[10];

    @Override // com.mojang.minecraft.player.C0050a
    /* JADX INFO: renamed from: a */
    public final void mo130a(int i, boolean z) {
        byte b = -1;
        if (i == 200 || i == 17) {
            b = 0;
        }
        if (i == 208 || i == 31) {
            b = 1;
        }
        if (i == 203 || i == 30) {
            b = 2;
        }
        if (i == 205 || i == 32) {
            b = 3;
        }
        if (i == 57 || i == 219) {
            b = 4;
        }
        if (b >= 0) {
            this.f302e[b] = z;
        }
    }

    @Override // com.mojang.minecraft.player.C0050a
    /* JADX INFO: renamed from: b */
    public final void mo129b() {
        for (int i = 0; i < 10; i++) {
            this.f302e[i] = false;
        }
    }

    @Override // com.mojang.minecraft.player.C0050a
    /* JADX INFO: renamed from: a */
    public final void mo128a() {
        this.f298a = 0.0f;
        this.f299b = 0.0f;
        if (this.f302e[0]) {
            this.f299b -= 1.0f;
        }
        if (this.f302e[1]) {
            this.f299b += 1.0f;
        }
        if (this.f302e[2]) {
            this.f298a -= 1.0f;
        }
        if (this.f302e[3]) {
            this.f298a += 1.0f;
        }
        this.f301d = this.f302e[4];
    }
}
