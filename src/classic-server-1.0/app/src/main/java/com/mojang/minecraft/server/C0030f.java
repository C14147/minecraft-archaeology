package com.mojang.minecraft.server;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: renamed from: com.mojang.minecraft.server.f */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/f.class */
final class C0030f extends Formatter {
    C0030f() {
    }

    @Override // java.util.logging.Formatter
    public final String format(LogRecord logRecord) {
        Level level = logRecord.getLevel();
        String str = level == Level.WARNING ? "  !" : "   ";
        if (level == Level.SEVERE) {
            str = "***";
        }
        return str + "  " + MinecraftServer.f103b.format(Long.valueOf(logRecord.getMillis())) + "  " + logRecord.getMessage() + "\n";
    }
}
