package com.mojang.minecraft.level;

import com.mojang.minecraft.server.MinecraftServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.level.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/level/a.class */
public final class C0005a {

    /* JADX INFO: renamed from: a */
    private MinecraftServer f47a;

    public C0005a(MinecraftServer minecraftServer) {
        this.f47a = minecraftServer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX INFO: renamed from: a */
    public final Level m7a(InputStream inputStream) {
        byte b;
        if (this.f47a != null) {
            this.f47a.m38a("Loading level");
        }
        MinecraftServer minecraftServer = this.f47a;
        ?? r0 = minecraftServer;
        if (minecraftServer != null) {
            MinecraftServer minecraftServer2 = this.f47a;
            minecraftServer2.m39b("Reading..");
            r0 = minecraftServer2;
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

    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ObjectOutputStream, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    public static void m8a(Level level, OutputStream outputStream) {
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
