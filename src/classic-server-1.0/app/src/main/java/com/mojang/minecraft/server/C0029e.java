package com.mojang.minecraft.server;

import java.io.OutputStream;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/* JADX INFO: renamed from: com.mojang.minecraft.server.e */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/e.class */
final class C0029e extends StreamHandler {
    C0029e(OutputStream outputStream, Formatter formatter) {
        super(outputStream, formatter);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public final synchronized void publish(LogRecord logRecord) {
        super.publish(logRecord);
        flush();
    }
}
