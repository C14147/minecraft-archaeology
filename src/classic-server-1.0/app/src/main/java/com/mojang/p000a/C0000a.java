package com.mojang.p000a;

import com.mojang.minecraft.server.MinecraftServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: com.mojang.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/a/a.class */
public final class C0000a {

    /* JADX INFO: renamed from: b */
    public MinecraftServer f1b;

    /* JADX INFO: renamed from: c */
    public List f2c = new LinkedList();

    /* JADX INFO: renamed from: a */
    public ServerSocketChannel f0a = ServerSocketChannel.open();

    public C0000a(int i, MinecraftServer minecraftServer) throws IOException {
        this.f1b = minecraftServer;
        this.f0a.socket().bind(new InetSocketAddress(i));
        this.f0a.configureBlocking(false);
    }
}
