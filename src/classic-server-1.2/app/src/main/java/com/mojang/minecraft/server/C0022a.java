package com.mojang.minecraft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mojang.minecraft.server.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/a.class */
final class C0022a extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ byte[] f114a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0025d f115b;

    C0022a(C0025d c0025d, byte[] bArr) {
        this.f115b = c0025d;
        this.f114a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Thread.sleep(500L);
            byte[] bArr = this.f114a;
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
                Thread.sleep(500L);
                this.f115b.m58a(byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException unused) {
        }
    }
}
