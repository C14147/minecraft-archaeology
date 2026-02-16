package com.mojang.minecraft.comm;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/comm/ConnectionListener.class */
public interface ConnectionListener {
    void handleException(Exception exc);

    void command(byte b, int i, ByteBuffer byteBuffer);
}
