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
public final class C0024b {

    /* JADX INFO: renamed from: a */
    private static Logger f125a = MinecraftServer.f101a;

    /* JADX INFO: renamed from: b */
    private String f126b;

    /* JADX INFO: renamed from: c */
    private File f127c;

    /* JADX INFO: renamed from: d */
    private Set f128d = new HashSet();

    public C0024b(String str, File file) {
        this.f126b = str;
        this.f127c = file;
        m57a();
    }

    /* JADX INFO: renamed from: a */
    public final void m54a(String str) {
        this.f128d.add(str.toLowerCase());
        m58b();
    }

    /* JADX INFO: renamed from: b */
    public final void m55b(String str) {
        this.f128d.remove(str.toLowerCase());
        m58b();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m56c(String str) {
        return this.f128d.contains(str.toLowerCase());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX INFO: renamed from: a */
    private void m57a() {
        ?? CreateNewFile;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f127c));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    CreateNewFile = bufferedReader;
                    CreateNewFile.close();
                    return;
                } else {
                    this.f128d.add(line.toLowerCase());
                }
            }
        } catch (IOException e) {
            try {
                CreateNewFile = this.f127c.createNewFile();
            } catch (IOException e2) {
                CreateNewFile.printStackTrace();
            }
            f125a.warning("Failed to load player list \"" + this.f126b + "\". (" + e + ")");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m58b() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.f127c));
            Iterator it = this.f128d.iterator();
            while (it.hasNext()) {
                printWriter.println((String) it.next());
            }
            printWriter.close();
        } catch (IOException e) {
            f125a.warning("Failed to save player list \"" + this.f126b + "\". (" + e + ")");
        }
    }
}
