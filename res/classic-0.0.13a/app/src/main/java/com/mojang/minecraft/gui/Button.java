package com.mojang.minecraft.gui;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/gui/Button.class */
public class Button {

    /* JADX INFO: renamed from: x */
    public int f25x;

    /* JADX INFO: renamed from: y */
    public int f26y;

    /* JADX INFO: renamed from: w */
    public int f27w;

    /* JADX INFO: renamed from: h */
    public int f28h;
    public String msg;

    /* JADX INFO: renamed from: id */
    public int f29id;

    public Button(int id, int x, int y, int w, int h, String msg) {
        this.f29id = id;
        this.f25x = x;
        this.f26y = y;
        this.f27w = w;
        this.f28h = h;
        this.msg = msg;
    }
}
