package com.mojang.minecraft;

import java.awt.Canvas;

/* JADX INFO: renamed from: com.mojang.minecraft.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/b.class */
final class C0018b extends Canvas {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ MinecraftApplet f89a;

    C0018b(MinecraftApplet minecraftApplet) {
        this.f89a = minecraftApplet;
    }

    public final void addNotify() {
        super.addNotify();
        MinecraftApplet minecraftApplet = this.f89a;
        if (minecraftApplet.f2b == null) {
            minecraftApplet.f2b = new Thread(minecraftApplet.f1a);
            minecraftApplet.f2b.start();
        }
    }

    public final void removeNotify() {
        this.f89a.m0a();
        super.removeNotify();
    }
}
