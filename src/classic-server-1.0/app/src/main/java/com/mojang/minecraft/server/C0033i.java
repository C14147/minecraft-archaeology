package com.mojang.minecraft.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.mojang.minecraft.server.i */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/i.class */
final class C0033i extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ MinecraftServer f157a;

    C0033i(MinecraftServer minecraftServer) {
        this.f157a = minecraftServer;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    MinecraftServer.f102a.warning("stdin: end of file! No more direct console input is possible.");
                    return;
                } else {
                    synchronized (this.f157a.f120u) {
                        this.f157a.f120u.add(line);
                    }
                }
            }
        } catch (IOException e) {
            MinecraftServer.f102a.warning("stdin: ioexception! No more direct console input is possible.");
            e.printStackTrace();
        }
    }
}
