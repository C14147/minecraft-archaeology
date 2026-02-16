package com.mojang.minecraft.level;

import com.mojang.minecraft.RunnableC0027d;
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
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/level/a.class */
public final class C0029a {

    /* JADX INFO: renamed from: a */
    private RunnableC0027d f196a;

    public C0029a(RunnableC0027d runnableC0027d) {
        this.f196a = runnableC0027d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX INFO: renamed from: a */
    public final boolean m85a(Level level, String str, String str2, String str3, String str4, int i) {
        if (str3 == null) {
            str3 = "";
        }
        RunnableC0027d runnableC0027d = this.f196a;
        ?? r0 = runnableC0027d;
        if (runnableC0027d != null) {
            RunnableC0027d runnableC0027d2 = this.f196a;
            r0 = runnableC0027d2;
            if (runnableC0027d2 != null) {
                RunnableC0027d runnableC0027d3 = this.f196a;
                runnableC0027d3.m72a("Saving level");
                r0 = runnableC0027d3;
            }
        }
        try {
            if (this.f196a != null && this.f196a != null) {
                this.f196a.m73b("Compressing..");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m89a(level, byteArrayOutputStream);
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (this.f196a != null && this.f196a != null) {
                this.f196a.m73b("Connecting..");
            }
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
            if (this.f196a != null) {
                this.f196a.m73b("Saving..");
            }
            dataOutputStream.write(byteArray);
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            if (bufferedReader.readLine().equalsIgnoreCase("ok")) {
                bufferedReader.close();
                return true;
            }
            if (this.f196a != null) {
                this.f196a.m73b("Failed: " + bufferedReader.readLine());
            }
            bufferedReader.close();
            Thread.sleep(1000L);
            return false;
        } catch (Exception e) {
            r0.printStackTrace();
            if (this.f196a != null) {
                this.f196a.m73b("Failed!");
            }
            try {
                Thread.sleep(1000L);
                return false;
            } catch (InterruptedException unused) {
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.mojang.minecraft.level.a] */
    /* JADX INFO: renamed from: a */
    public final Level m86a(String str, String str2, int i) {
        RunnableC0027d runnableC0027d = this.f196a;
        ?? r0 = runnableC0027d;
        if (runnableC0027d != null) {
            RunnableC0027d runnableC0027d2 = this.f196a;
            runnableC0027d2.m72a("Loading level");
            r0 = runnableC0027d2;
        }
        try {
            if (this.f196a != null) {
                this.f196a.m73b("Connecting..");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + str + "/level/load.html?id=" + i + "&user=" + str2).openConnection();
            httpURLConnection.setDoInput(true);
            if (this.f196a != null) {
                this.f196a.m73b("Loading..");
            }
            DataInputStream dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
            if (dataInputStream.readUTF().equalsIgnoreCase("ok")) {
                return m87a(dataInputStream);
            }
            if (this.f196a != null) {
                this.f196a.m73b("Failed: " + dataInputStream.readUTF());
            }
            dataInputStream.close();
            Thread.sleep(1000L);
            return null;
        } catch (Exception e) {
            r0.printStackTrace();
            if (this.f196a != null) {
                this.f196a.m73b("Failed!");
            }
            try {
                Thread.sleep(3000L);
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX INFO: renamed from: a */
    public final Level m87a(InputStream inputStream) {
        byte b;
        if (this.f196a != null) {
            this.f196a.m72a("Loading level");
        }
        RunnableC0027d runnableC0027d = this.f196a;
        ?? r0 = runnableC0027d;
        if (runnableC0027d != null) {
            RunnableC0027d runnableC0027d2 = this.f196a;
            runnableC0027d2.m73b("Reading..");
            r0 = runnableC0027d2;
        }
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
    /* JADX WARN: Type inference failed for: r0v24, types: [com.mojang.minecraft.level.Level] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Exception] */
    /* JADX INFO: renamed from: b */
    public final Level m88b(InputStream inputStream) {
        if (this.f196a != null) {
            this.f196a.m72a("Loading level");
        }
        RunnableC0027d runnableC0027d = this.f196a;
        ?? r0 = runnableC0027d;
        if (runnableC0027d != null) {
            RunnableC0027d runnableC0027d2 = this.f196a;
            runnableC0027d2.m73b("Reading..");
            r0 = runnableC0027d2;
        }
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
    public static void m89a(Level level, OutputStream outputStream) {
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

    /* JADX INFO: renamed from: c */
    public static byte[] m90c(InputStream inputStream) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            return bArr;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
