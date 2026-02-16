package com.mojang.minecraft.level;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/level/LevelListener.class */
public interface LevelListener {
    void tileChanged(int i, int i2, int i3);

    void lightColumnChanged(int i, int i2, int i3, int i4);

    void allChanged();
}
