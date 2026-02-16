package com.mojang.minecraft.p000a;

import com.mojang.minecraft.RunnableC0022c;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/a.class */
public final class C0001a {

    /* JADX INFO: renamed from: a */
    private RunnableC0022c f9a;

    public C0001a(RunnableC0022c runnableC0022c) {
        this.f9a = runnableC0022c;
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
    public final boolean m1a(C0017f c0017f, String str, String str2, String str3, String str4, int i) {
        if (str3 == null) {
            str3 = "";
        }
        ?? r0 = this.f9a;
        r0.m79a("Saving level");
        try {
            this.f9a.m80b("Compressing..");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m5a(c0017f, byteArrayOutputStream);
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f9a.m80b("Connecting..");
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
            this.f9a.m80b("Saving..");
            dataOutputStream.write(byteArray);
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            if (bufferedReader.readLine().equalsIgnoreCase("ok")) {
                bufferedReader.close();
                return true;
            }
            this.f9a.m80b("Failed: " + bufferedReader.readLine());
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
            ?? r02 = this.f9a;
            r02.m80b("Failed!");
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
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.mojang.minecraft.a.a] */
    /* JADX INFO: renamed from: a */
    public final boolean m2a(C0017f c0017f, String str, String str2, int i) {
        ?? r0 = this.f9a;
        r0.m79a("Loading level");
        try {
            this.f9a.m80b("Connecting..");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + str + "/level/load.html?id=" + i + "&user=" + str2).openConnection();
            httpURLConnection.setDoInput(true);
            this.f9a.m80b("Loading..");
            DataInputStream dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
            if (dataInputStream.readUTF().equalsIgnoreCase("ok")) {
                m3a(c0017f, dataInputStream);
                return true;
            }
            this.f9a.m80b("Failed: " + dataInputStream.readUTF());
            r0 = dataInputStream;
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
            ?? r02 = this.f9a;
            r02.m80b("Failed!");
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
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    public final boolean m3a(C0017f c0017f, InputStream inputStream) {
        this.f9a.m79a("Loading level");
        ?? r0 = this.f9a;
        r0.m80b("Reading..");
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
            if (dataInputStream.readInt() != 656127880 || dataInputStream.readByte() > 1) {
                return false;
            }
            String utf = dataInputStream.readUTF();
            String utf2 = dataInputStream.readUTF();
            long j = dataInputStream.readLong();
            short s = dataInputStream.readShort();
            short s2 = dataInputStream.readShort();
            short s3 = dataInputStream.readShort();
            byte[] bArr = new byte[s * s2 * s3];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            c0017f.m46a(s, s3, s2, bArr);
            c0017f.f85h = utf;
            c0017f.f86i = utf2;
            c0017f.f87j = j;
            r0 = 1;
            return true;
        } catch (Exception e) {
            r0.printStackTrace();
            String str = "Failed to load level: " + e.toString();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX INFO: renamed from: b */
    public final boolean m4b(C0017f c0017f, InputStream inputStream) {
        this.f9a.m79a("Loading level");
        ?? r0 = this.f9a;
        r0.m80b("Reading..");
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
            byte[] bArr = new byte[(256 << 8) << 6];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            c0017f.m46a(256, 64, 256, bArr);
            c0017f.f85h = "--";
            c0017f.f86i = "unknown";
            c0017f.f87j = 0L;
            r0 = 1;
            return true;
        } catch (Exception e) {
            r0.printStackTrace();
            String str = "Failed to load level: " + e.toString();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.DataOutputStream, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    public static void m5a(C0017f c0017f, OutputStream outputStream) {
        ?? dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
            dataOutputStream.writeInt(656127880);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeUTF(c0017f.f85h);
            dataOutputStream.writeUTF(c0017f.f86i);
            dataOutputStream.writeLong(c0017f.f87j);
            dataOutputStream.writeShort(c0017f.f77a);
            dataOutputStream.writeShort(c0017f.f78b);
            dataOutputStream.writeShort(c0017f.f79c);
            dataOutputStream.write(c0017f.f80d);
            dataOutputStream.close();
        } catch (Exception e) {
            dataOutputStream.printStackTrace();
        }
    }
}
