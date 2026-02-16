package com.mojang.minecraft;

import java.awt.Canvas;

/* JADX INFO: renamed from: com.mojang.minecraft.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/b.class */
final class C0014b extends Canvas {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ MinecraftApplet f82a;

    C0014b(MinecraftApplet minecraftApplet) {
        this.f82a = minecraftApplet;
    }

    public final void addNotify() {
        super.addNotify();
        MinecraftApplet minecraftApplet = this.f82a;
        if (minecraftApplet.f2b == null) {
            minecraftApplet.f2b = new Thread(minecraftApplet.f1a);
            minecraftApplet.f2b.start();
        }
    }

    public final void removeNotify() {
        this.f82a.m0a();
        super.removeNotify();
    }
}
