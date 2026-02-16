package com.mojang.minecraft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.server.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/a.class */
final class C0023a extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ byte[] f123a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0026d f124b;

    C0023a(C0026d c0026d, byte[] bArr) {
        this.f124b = c0026d;
        this.f123a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Thread.sleep(500L);
            byte[] bArr = this.f123a;
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
                Thread.sleep(500L);
                this.f124b.m64a(byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException unused) {
        }
    }
}
