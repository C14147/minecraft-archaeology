package com.mojang.minecraft.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: renamed from: com.mojang.minecraft.server.e */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/e.class */
final class C0027e extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f147a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ MinecraftServer f148b;

    C0027e(MinecraftServer minecraftServer, String str) {
        this.f148b = minecraftServer;
        this.f147a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://www.minecraft.net/heartbeat.jsp").openConnection();
                httpURLConnection = httpURLConnection2;
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", "" + Integer.toString(this.f147a.getBytes().length));
                httpURLConnection.setRequestProperty("Content-Language", "en-US");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(this.f147a);
                dataOutputStream.flush();
                dataOutputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line = bufferedReader.readLine();
                if (!this.f148b.f120v.equals(line)) {
                    MinecraftServer.f101a.info("To connect directly to this server, surf to: " + line);
                    PrintWriter printWriter = new PrintWriter(new FileWriter("externalurl.txt"));
                    printWriter.println(line);
                    printWriter.close();
                    MinecraftServer.f101a.info("(This is also in externalurl.txt)");
                    this.f148b.f120v = line;
                }
                bufferedReader.close();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e) {
                MinecraftServer.f101a.severe("Failed to assemble heartbeat: " + e);
                e.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
