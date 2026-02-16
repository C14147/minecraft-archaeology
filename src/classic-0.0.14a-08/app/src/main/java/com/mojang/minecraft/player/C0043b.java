package com.mojang.minecraft.player;

/* JADX INFO: renamed from: com.mojang.minecraft.player.b */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/player/b.class */
public final class C0043b extends C0042a {

    /* JADX INFO: renamed from: e */
    private boolean[] f241e = new boolean[10];

    @Override // com.mojang.minecraft.player.C0042a
    /* JADX INFO: renamed from: a */
    public final void mo114a(int i, boolean z) {
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
            this.f241e[b] = z;
        }
    }

    @Override // com.mojang.minecraft.player.C0042a
    /* JADX INFO: renamed from: b */
    public final void mo113b() {
        for (int i = 0; i < 10; i++) {
            this.f241e[i] = false;
        }
    }

    @Override // com.mojang.minecraft.player.C0042a
    /* JADX INFO: renamed from: a */
    public final void mo112a() {
        this.f237a = 0.0f;
        this.f238b = 0.0f;
        if (this.f241e[0]) {
            this.f238b -= 1.0f;
        }
        if (this.f241e[1]) {
            this.f238b += 1.0f;
        }
        if (this.f241e[2]) {
            this.f237a -= 1.0f;
        }
        if (this.f241e[3]) {
            this.f237a += 1.0f;
        }
        this.f240d = this.f241e[4];
    }
}
