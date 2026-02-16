package com.mojang.minecraft.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.mojang.minecraft.server.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/b.class */
public final class C0026b {

    /* JADX INFO: renamed from: a */
    private static Logger f128a = MinecraftServer.f102a;

    /* JADX INFO: renamed from: b */
    private String f129b;

    /* JADX INFO: renamed from: c */
    private File f130c;

    /* JADX INFO: renamed from: d */
    private Set f131d = new HashSet();

    public C0026b(String str, File file) {
        this.f129b = str;
        this.f130c = file;
        m60a();
    }

    /* JADX INFO: renamed from: a */
    public final void m57a(String str) {
        this.f131d.add(str.toLowerCase());
        m61b();
    }

    /* JADX INFO: renamed from: b */
    public final void m58b(String str) {
        this.f131d.remove(str.toLowerCase());
        m61b();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m59c(String str) {
        return this.f131d.contains(str.toLowerCase());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX INFO: renamed from: a */
    private void m60a() {
        ?? CreateNewFile;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f130c));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    CreateNewFile = bufferedReader;
                    CreateNewFile.close();
                    return;
                } else {
                    this.f131d.add(line.toLowerCase());
                }
            }
        } catch (IOException e) {
            try {
                CreateNewFile = this.f130c.createNewFile();
            } catch (IOException e2) {
                CreateNewFile.printStackTrace();
            }
            f128a.warning("Failed to load player list \"" + this.f129b + "\". (" + e + ")");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m61b() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.f130c));
            Iterator it = this.f131d.iterator();
            while (it.hasNext()) {
                printWriter.println((String) it.next());
            }
            printWriter.close();
        } catch (IOException e) {
            f128a.warning("Failed to save player list \"" + this.f129b + "\". (" + e + ")");
        }
    }
}
