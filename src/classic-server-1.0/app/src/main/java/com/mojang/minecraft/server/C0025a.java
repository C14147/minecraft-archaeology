package com.mojang.minecraft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.server.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/a.class */
final class C0025a extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ byte[] f126a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0028d f127b;

    C0025a(C0028d c0028d, byte[] bArr) {
        this.f127b = c0028d;
        this.f126a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Thread.sleep(500L);
            byte[] bArr = this.f126a;
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
                Thread.sleep(500L);
                this.f127b.m67a(byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException unused) {
        }
    }
}
