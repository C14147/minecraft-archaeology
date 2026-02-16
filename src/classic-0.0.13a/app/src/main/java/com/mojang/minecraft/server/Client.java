package com.mojang.minecraft.server;

import com.mojang.minecraft.comm.ConnectionListener;
import com.mojang.minecraft.comm.SocketConnection;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/server/Client.class */
public class Client implements ConnectionListener {
    public final SocketConnection serverConnection;
    private final MinecraftServer server;

    public Client(MinecraftServer server, SocketConnection serverConnection) {
        this.server = server;
        this.serverConnection = serverConnection;
        serverConnection.setConnectionListener(this);
    }

    @Override // com.mojang.minecraft.comm.ConnectionListener
    public void command(byte cmd, int remaining, ByteBuffer in) {
    }

    @Override // com.mojang.minecraft.comm.ConnectionListener
    public void handleException(Exception e) {
        disconnect();
    }

    public void disconnect() {
        this.server.disconnect(this);
    }
}
