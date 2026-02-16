package com.mojang.minecraft.comm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: client.jar:com/mojang/minecraft/comm/SocketServer.class */
public class SocketServer {
    private ServerSocketChannel ssc;
    private ServerListener serverListener;
    private List<SocketConnection> connections = new LinkedList();

    public SocketServer(byte[] ips, int port, ServerListener serverListener) throws IOException {
        this.serverListener = serverListener;
        InetAddress hostip = InetAddress.getByAddress(ips);
        this.ssc = ServerSocketChannel.open();
        this.ssc.socket().bind(new InetSocketAddress(hostip, port));
        this.ssc.configureBlocking(false);
    }

    public void tick() throws IOException {
        while (true) {
            SocketChannel socketChannel = this.ssc.accept();
            if (socketChannel == null) {
                break;
            }
            try {
                socketChannel.configureBlocking(false);
                SocketConnection socketConnection = new SocketConnection(socketChannel);
                this.connections.add(socketConnection);
                this.serverListener.clientConnected(socketConnection);
            } catch (IOException e) {
                socketChannel.close();
                throw e;
            }
        }
        int i = 0;
        while (i < this.connections.size()) {
            SocketConnection socketConnection2 = this.connections.get(i);
            if (!socketConnection2.isConnected()) {
                socketConnection2.disconnect();
                int i2 = i;
                i--;
                this.connections.remove(i2);
            } else {
                try {
                    socketConnection2.tick();
                } catch (Exception e2) {
                    socketConnection2.disconnect();
                    this.serverListener.clientException(socketConnection2, e2);
                }
            }
            i++;
        }
    }
}
