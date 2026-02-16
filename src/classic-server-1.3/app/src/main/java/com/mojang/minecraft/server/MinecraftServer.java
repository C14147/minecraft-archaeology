package com.mojang.minecraft.server;

import com.mojang.minecraft.level.C0006a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p004b.C0017a;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.p000a.C0000a;
import com.mojang.p000a.C0001b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/MinecraftServer.class */
public class MinecraftServer implements Runnable {

    /* JADX INFO: renamed from: a */
    static Logger f101a = Logger.getLogger("MinecraftServer");

    /* JADX INFO: renamed from: b */
    static DateFormat f102b = new SimpleDateFormat("HH:mm:ss");

    /* JADX INFO: renamed from: k */
    private C0000a f103k;

    /* JADX INFO: renamed from: o */
    private int f107o;

    /* JADX INFO: renamed from: c */
    public Level f109c;

    /* JADX INFO: renamed from: q */
    private boolean f110q;

    /* JADX INFO: renamed from: d */
    public String f111d;

    /* JADX INFO: renamed from: e */
    public String f112e;

    /* JADX INFO: renamed from: r */
    private int f113r;

    /* JADX INFO: renamed from: s */
    private C0026d[] f114s;

    /* JADX INFO: renamed from: j */
    public boolean f122j;

    /* JADX INFO: renamed from: l */
    private Map f104l = new HashMap();

    /* JADX INFO: renamed from: m */
    private List f105m = new ArrayList();

    /* JADX INFO: renamed from: n */
    private List f106n = new ArrayList();

    /* JADX INFO: renamed from: p */
    private Properties f108p = new Properties();

    /* JADX INFO: renamed from: f */
    public C0024b f115f = new C0024b("Admins", new File("admins.txt"));

    /* JADX INFO: renamed from: g */
    public C0024b f116g = new C0024b("Banned", new File("banned.txt"));

    /* JADX INFO: renamed from: t */
    private C0024b f117t = new C0024b("Banned (IP)", new File("banned-ip.txt"));

    /* JADX INFO: renamed from: h */
    public C0024b f118h = new C0024b("Players", new File("players.txt"));

    /* JADX INFO: renamed from: u */
    private String f119u = "" + new Random().nextLong();

    /* JADX INFO: renamed from: v */
    private String f120v = "";

    /* JADX INFO: renamed from: i */
    public C0029g f121i = new C0029g(this.f119u);

    public MinecraftServer() {
        this.f110q = false;
        this.f122j = false;
        try {
            this.f108p.load(new FileReader("server.properties"));
        } catch (Exception unused) {
            f101a.warning("Failed to load server.properties!");
        }
        try {
            this.f111d = this.f108p.getProperty("server-name", "Minecraft Server");
            this.f112e = this.f108p.getProperty("motd", "Welcome to my Minecraft Server!");
            this.f113r = Integer.parseInt(this.f108p.getProperty("port", "25565"));
            this.f107o = Integer.parseInt(this.f108p.getProperty("max-players", "16"));
            this.f110q = Boolean.parseBoolean(this.f108p.getProperty("public", "true"));
            this.f122j = Boolean.parseBoolean(this.f108p.getProperty("verify-names", "true"));
            if (this.f107o < 1) {
                this.f107o = 1;
            }
            if (this.f107o > 32) {
                this.f107o = 32;
            }
            this.f108p.setProperty("server-name", this.f111d);
            this.f108p.setProperty("motd", this.f112e);
            this.f108p.setProperty("max-players", "" + this.f107o);
            this.f108p.setProperty("port", "" + this.f113r);
            this.f108p.setProperty("public", "" + this.f110q);
            this.f108p.setProperty("verify-names", "" + this.f122j);
        } catch (Exception unused2) {
            f101a.warning("server.properties is broken! Delete it or fix it!");
            System.exit(0);
        }
        try {
            this.f108p.store(new FileWriter("server.properties"), "Minecraft server properties");
        } catch (Exception unused3) {
            f101a.warning("Failed to save server.properties!");
        }
        this.f114s = new C0026d[this.f107o];
        this.f103k = new C0000a(this.f113r, this);
    }

    /* JADX INFO: renamed from: a */
    public final void m31a(C0001b c0001b) {
        C0026d c0026d = (C0026d) this.f104l.get(c0001b);
        if (c0026d != null) {
            this.f118h.m55b(c0026d.f136b);
            f101a.info(c0026d + " disconnected");
            this.f104l.remove(c0026d.f132a);
            this.f105m.remove(c0026d);
            if (c0026d.f137c >= 0) {
                this.f114s[c0026d.f137c] = null;
            }
            m35a(C0003a.f36n, Integer.valueOf(c0026d.f137c));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m32b(C0001b c0001b) {
        this.f106n.add(new C0025c(c0001b, 100));
    }

    /* JADX INFO: renamed from: a */
    public final void m33a(C0026d c0026d) {
        this.f106n.add(new C0025c(c0026d.f132a, 100));
    }

    /* JADX INFO: renamed from: b */
    public static void m34b(C0026d c0026d) {
        c0026d.f132a.m0a();
    }

    /* JADX INFO: renamed from: a */
    public final void m35a(C0003a c0003a, Object... objArr) {
        for (int i = 0; i < this.f105m.size(); i++) {
            try {
                ((C0026d) this.f105m.get(i)).m66b(c0003a, objArr);
            } catch (Exception e) {
                ((C0026d) this.f105m.get(i)).m67a(e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m36a(C0026d c0026d, C0003a c0003a, Object... objArr) {
        for (int i = 0; i < this.f105m.size(); i++) {
            if (this.f105m.get(i) != c0026d) {
                try {
                    ((C0026d) this.f105m.get(i)).m66b(c0003a, objArr);
                } catch (Exception e) {
                    ((C0026d) this.f105m.get(i)).m67a(e);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        f101a.info("Now accepting input on " + this.f113r);
        try {
            long jNanoTime = System.nanoTime();
            long jNanoTime2 = System.nanoTime();
            int i = 0;
            while (true) {
                m41c();
                while (System.nanoTime() - jNanoTime2 > 50000000) {
                    jNanoTime2 += (long) 50000000;
                    m38b();
                    if (i % 1200 == 0) {
                        f101a.info("Saving level");
                        f101a.info("Load: " + this.f105m.size() + "/" + this.f107o);
                        try {
                            new C0006a(this);
                            C0006a.m8a(this.f109c, new FileOutputStream("server_level.dat"));
                        } catch (Exception e) {
                            f101a.severe("Failed to save the level! " + e);
                        }
                    }
                    if (i % 900 == 0) {
                        f101a.info("Sending heartbeat");
                        HashMap map = new HashMap();
                        map.put("name", this.f111d);
                        map.put("users", Integer.valueOf(this.f105m.size()));
                        map.put("max", Integer.valueOf(this.f107o));
                        map.put("public", Boolean.valueOf(this.f110q));
                        map.put("port", Integer.valueOf(this.f113r));
                        map.put("salt", this.f119u);
                        map.put("version", (byte) 4);
                        new C0027e(this, m37a(map)).start();
                    }
                    i++;
                }
                while (System.nanoTime() - jNanoTime > 500000000) {
                    jNanoTime += (long) 500000000;
                    m35a(C0003a.f25c, new Object[0]);
                }
                Thread.sleep(5L);
            }
        } catch (Exception e2) {
            f101a.log(java.util.logging.Level.SEVERE, "Error in main loop, server shutting down!", (Throwable) e2);
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    private static String m37a(Map map) {
        ?? HasNext;
        try {
            String str = "";
            Iterator it = map.keySet().iterator();
            while (true) {
                HasNext = it.hasNext();
                if (HasNext == 0) {
                    return str;
                }
                String str2 = (String) it.next();
                if (str != "") {
                    str = str + "&";
                }
                str = str + str2 + "=" + URLEncoder.encode(map.get(str2).toString(), "UTF-8");
            }
        } catch (Exception e) {
            HasNext.printStackTrace();
            throw new RuntimeException("Failed to assemble heartbeat! This is pretty fatal");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m38b() {
        this.f109c.tick();
        int i = 0;
        while (i < this.f106n.size()) {
            C0025c c0025c = (C0025c) this.f106n.get(i);
            m31a(c0025c.f129a);
            try {
                C0001b c0001b = c0025c.f129a;
                try {
                    if (c0001b.f6d.position() > 0) {
                        c0001b.f6d.flip();
                        c0001b.f4b.write(c0001b.f6d);
                        c0001b.f6d.compact();
                    }
                } catch (IOException unused) {
                }
                int i2 = c0025c.f130b;
                c0025c.f130b = i2 - 1;
                if (i2 <= 0) {
                    try {
                        c0025c.f129a.m0a();
                    } catch (Exception unused2) {
                    }
                    int i3 = i;
                    i--;
                    this.f106n.remove(i3);
                }
            } catch (Exception unused3) {
                try {
                    c0025c.f129a.m0a();
                } catch (Exception unused4) {
                }
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m39a(String str) {
        f101a.info(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m40b(String str) {
        f101a.fine(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:38|84|39|(2:40|(2:42|(8:44|(4:110|46|47|105)(2:48|(5:50|(2:53|51)|113|54|(1:56)(1:112))(2:111|57))|78|66|(1:68)|69|107|72)(1:109))(1:108))|58|(1:60)|61|78|66|(0)|69|107|72|36) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x032f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0311 A[Catch: Exception -> 0x032e, IOException -> 0x033a, TryCatch #1 {Exception -> 0x032e, blocks: (B:66:0x0308, B:68:0x0311), top: B:78:0x0308, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v138 */
    /* JADX WARN: Type inference failed for: r0v139 */
    /* JADX WARN: Type inference failed for: r0v140 */
    /* JADX WARN: Type inference failed for: r0v141 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m41c() {
        /*
            Method dump skipped, instruction units count: 838
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.server.MinecraftServer.m41c():void");
    }

    /* JADX INFO: renamed from: a */
    public final void m42a(int i, int i2, int i3) {
        m35a(C0003a.f30h, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.f109c.getTile(i, i2, i3)));
    }

    /* JADX INFO: renamed from: d */
    private int m43d() {
        for (int i = 0; i < this.f107o; i++) {
            if (this.f114s[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final List m44a() {
        return this.f105m;
    }

    /* JADX INFO: renamed from: c */
    public final void m45c(String str) {
        boolean z = false;
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str)) {
                z = true;
                c0026d.m60a("You were kicked");
            }
        }
        if (z) {
            m35a(C0003a.f37o, -1, str + " got kicked from the server!");
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m46d(String str) {
        this.f116g.m54a(str);
        boolean z = false;
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str)) {
                z = true;
                c0026d.m60a("You were banned");
            }
        }
        if (z) {
            m35a(C0003a.f37o, -1, str + " got banned!");
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m47e(String str) {
        this.f115f.m54a(str);
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str)) {
                c0026d.m63b("You're now op!");
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m48f(String str) {
        this.f115f.m55b(str);
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str)) {
                c0026d.m63b("You're no longer op!");
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m49g(String str) {
        this.f116g.m55b(str);
    }

    /* JADX INFO: renamed from: h */
    public final void m50h(String str) {
        boolean z = false;
        String str2 = "";
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str) || c0026d.f132a.f10f.equalsIgnoreCase(str) || c0026d.f132a.f10f.equalsIgnoreCase("/" + str)) {
                this.f117t.m54a(c0026d.f132a.f10f);
                c0026d.m60a("You were banned");
                if (str2 == "") {
                    str2 = str2 + ", ";
                }
                str2 = str2 + c0026d.f136b;
                z = true;
            }
        }
        if (z) {
            m35a(C0003a.f37o, -1, str2 + " got ip banned!");
        }
    }

    /* JADX INFO: renamed from: i */
    public final C0026d m51i(String str) {
        for (C0026d c0026d : this.f105m) {
            if (c0026d.f136b.equalsIgnoreCase(str)) {
                return c0026d;
            }
        }
        return null;
    }

    public static void main(String[] strArr) {
        try {
            MinecraftServer minecraftServer = new MinecraftServer();
            f101a.info("Setting up");
            File file = new File("server_level.dat");
            if (file.exists()) {
                try {
                    minecraftServer.f109c = new C0006a(minecraftServer).m7a(new FileInputStream(file));
                } catch (Exception e) {
                    f101a.warning("Failed to load level. Generating a new level");
                    e.printStackTrace();
                }
            } else {
                f101a.warning("No level file found. Generating a new level");
            }
            if (minecraftServer.f109c == null) {
                minecraftServer.f109c = new C0017a(minecraftServer).m21a("--", 256, 256, 64);
            }
            try {
                new C0006a(minecraftServer);
                C0006a.m8a(minecraftServer.f109c, new FileOutputStream("server_level.dat"));
            } catch (Exception unused) {
            }
            minecraftServer.f109c.addListener$74652038(minecraftServer);
            new Thread(minecraftServer).start();
        } catch (Exception e2) {
            f101a.severe("Failed to start the server!");
            e2.printStackTrace();
        }
    }

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new C0028f());
        for (Handler handler : f101a.getParent().getHandlers()) {
            f101a.getParent().removeHandler(handler);
        }
        f101a.addHandler(consoleHandler);
    }
}
