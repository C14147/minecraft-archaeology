package com.mojang.rubydung.level;

/* JADX INFO: loaded from: pre-Classic rd-132328.jar:com/mojang/rubydung/level/LevelListener.class */
public interface LevelListener {
    void tileChanged(int i, int i2, int i3);

    void lightColumnChanged(int i, int i2, int i3, int i4);

    void allChanged();
}
