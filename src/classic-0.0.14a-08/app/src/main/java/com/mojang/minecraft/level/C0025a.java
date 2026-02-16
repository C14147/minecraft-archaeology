package com.mojang.minecraft.level;

import com.mojang.minecraft.RunnableC0018c;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/level/a.class */
public final class C0025a {

    /* JADX INFO: renamed from: a */
    private RunnableC0018c f176a;

    public C0025a(RunnableC0018c runnableC0018c) {
        this.f176a = runnableC0018c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX INFO: renamed from: a */
    public final boolean m74a(Level level, String str, String str2, String str3, String str4, int i) {
        if (str3 == null) {
            str3 = "";
        }
        ?? r0 = this.f176a;
        r0.m58a("Saving level");
        try {
            this.f176a.m59b("Compressing..");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m78a(level, byteArrayOutputStream);
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f176a.m59b("Connecting..");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + str + "/level/save.html").openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeUTF(str2);
            dataOutputStream.writeUTF(str3);
            dataOutputStream.writeUTF(str4);
            dataOutputStream.writeByte(i);
            dataOutputStream.writeInt(byteArray.length);
            this.f176a.m59b("Saving..");
            dataOutputStream.write(byteArray);
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            if (bufferedReader.readLine().equalsIgnoreCase("ok")) {
                bufferedReader.close();
                return true;
            }
            this.f176a.m59b("Failed: " + bufferedReader.readLine());
            r0 = bufferedReader;
            r0.close();
            try {
                r0 = 1000;
                r0 = 1000;
                Thread.sleep(1000L);
                return false;
            } catch (InterruptedException e) {
                r0.printStackTrace();
                return false;
            }
        } catch (Exception e2) {
            r0.printStackTrace();
            ?? r02 = this.f176a;
            r02.m59b("Failed!");
            try {
                r02 = 1000;
                Thread.sleep(1000L);
                return false;
            } catch (InterruptedException e3) {
                r02.printStackTrace();
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.mojang.minecraft.level.a] */
    /* JADX INFO: renamed from: a */
    public final Level m75a(String str, String str2, int i) {
        ?? r0 = this.f176a;
        r0.m58a("Loading level");
        try {
            this.f176a.m59b("Connecting..");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + str + "/level/load.html?id=" + i + "&user=" + str2).openConnection();
            httpURLConnection.setDoInput(true);
            this.f176a.m59b("Loading..");
            DataInputStream dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
            if (dataInputStream.readUTF().equalsIgnoreCase("ok")) {
                return m76a(dataInputStream);
            }
            this.f176a.m59b("Failed: " + dataInputStream.readUTF());
            r0 = dataInputStream;
            r0.close();
            try {
                r0 = 1000;
                r0 = 1000;
                Thread.sleep(1000L);
                return null;
            } catch (InterruptedException e) {
                r0.printStackTrace();
                return null;
            }
        } catch (Exception e2) {
            r0.printStackTrace();
            ?? r02 = this.f176a;
            r02.m59b("Failed!");
            try {
                r02 = 3000;
                Thread.sleep(3000L);
                return null;
            } catch (InterruptedException e3) {
                r02.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    public final Level m76a(InputStream inputStream) {
        byte b;
        this.f176a.m58a("Loading level");
        ?? r0 = this.f176a;
        r0.m59b("Reading..");
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
            if (dataInputStream.readInt() != 656127880 || (b = dataInputStream.readByte()) > 2) {
                return null;
            }
            if (b > 1) {
                ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
                Level level = (Level) objectInputStream.readObject();
                level.initTransient();
                objectInputStream.close();
                return level;
            }
            System.out.println("Version is 1!");
            String utf = dataInputStream.readUTF();
            String utf2 = dataInputStream.readUTF();
            long j = dataInputStream.readLong();
            short s = dataInputStream.readShort();
            short s2 = dataInputStream.readShort();
            short s3 = dataInputStream.readShort();
            byte[] bArr = new byte[s * s2 * s3];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            Level level2 = new Level();
            level2.setData(s, s3, s2, bArr);
            level2.name = utf;
            level2.creator = utf2;
            level2.createTime = j;
            return level2;
        } catch (Exception e) {
            r0.printStackTrace();
            String str = "Failed to load level: " + e.toString();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.mojang.minecraft.level.Level] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX INFO: renamed from: b */
    public final Level m77b(InputStream inputStream) {
        this.f176a.m58a("Loading level");
        ?? r0 = this.f176a;
        r0.m59b("Reading..");
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
            byte[] bArr = new byte[(256 << 8) << 6];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            Level level = new Level();
            level.setData(256, 64, 256, bArr);
            level.name = "--";
            level.creator = "unknown";
            level.createTime = 0L;
            r0 = level;
            return r0;
        } catch (Exception e) {
            r0.printStackTrace();
            String str = "Failed to load level: " + e.toString();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ObjectOutputStream, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    public static void m78a(Level level, OutputStream outputStream) {
        ?? objectOutputStream;
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
            dataOutputStream.writeInt(656127880);
            dataOutputStream.writeByte(2);
            objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(level);
            objectOutputStream.close();
        } catch (Exception e) {
            objectOutputStream.printStackTrace();
        }
    }
}
