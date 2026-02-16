package com.mojang.minecraft.comm;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/comm/ServerListener.class */
public interface ServerListener {
    void clientConnected(SocketConnection socketConnection);

    void clientException(SocketConnection socketConnection, Exception exc);
}
