package com.mojang.minecraft.comm;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/comm/ServerListener.class */
public interface ServerListener {
    void clientConnected(SocketConnection socketConnection);

    void clientException(SocketConnection socketConnection, Exception exc);
}
