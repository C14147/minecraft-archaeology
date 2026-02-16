package com.mojang.minecraft.server;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

/* JADX INFO: renamed from: com.mojang.minecraft.server.e */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/e.class */
final class C0026e extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ HttpURLConnection f138a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f139b;

    C0026e(MinecraftServer minecraftServer, HttpURLConnection httpURLConnection, String str) {
        this.f138a = httpURLConnection;
        this.f139b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f138a.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(this.f138a.getOutputStream());
            dataOutputStream.writeBytes(this.f139b);
            dataOutputStream.flush();
            dataOutputStream.close();
            this.f138a.getInputStream();
        } catch (Exception e) {
            MinecraftServer.f97a.warning("Failed to send heartbeat: " + e);
            e.printStackTrace();
        } finally {
            this.f138a.disconnect();
        }
    }
}
