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
public final class C0023b {

    /* JADX INFO: renamed from: a */
    private static Logger f116a = MinecraftServer.f97a;

    /* JADX INFO: renamed from: b */
    private String f117b;

    /* JADX INFO: renamed from: c */
    private File f118c;

    /* JADX INFO: renamed from: e */
    private Set f120e = new HashSet();

    /* JADX INFO: renamed from: d */
    private boolean f119d = false;

    public C0023b(String str, File file, boolean z) {
        this.f117b = str;
        this.f118c = file;
        m53a();
    }

    /* JADX INFO: renamed from: a */
    public final void m50a(String str) {
        if (!this.f119d) {
            str = str.toLowerCase();
        }
        this.f120e.add(str);
        m54b();
    }

    /* JADX INFO: renamed from: b */
    public final void m51b(String str) {
        if (!this.f119d) {
            str = str.toLowerCase();
        }
        this.f120e.remove(str);
        m54b();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m52c(String str) {
        if (!this.f119d) {
            str = str.toLowerCase();
        }
        return this.f120e.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX INFO: renamed from: a */
    private void m53a() {
        ?? CreateNewFile;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f118c));
            while (true) {
                String line = bufferedReader.readLine();
                String lowerCase = line;
                if (line == null) {
                    CreateNewFile = bufferedReader;
                    CreateNewFile.close();
                    return;
                } else {
                    if (!this.f119d) {
                        lowerCase = lowerCase.toLowerCase();
                    }
                    this.f120e.add(lowerCase);
                }
            }
        } catch (IOException e) {
            try {
                CreateNewFile = this.f118c.createNewFile();
            } catch (IOException e2) {
                CreateNewFile.printStackTrace();
            }
            f116a.warning("Failed to load player list \"" + this.f117b + "\". (" + e + ")");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m54b() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.f118c));
            Iterator it = this.f120e.iterator();
            while (it.hasNext()) {
                printWriter.println((String) it.next());
            }
            printWriter.close();
        } catch (IOException e) {
            f116a.warning("Failed to save player list \"" + this.f117b + "\". (" + e + ")");
        }
    }
}
