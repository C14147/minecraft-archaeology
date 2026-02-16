package com.mojang.minecraft.server;

import com.mojang.minecraft.level.C0005a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p004b.C0016a;
import com.mojang.minecraft.p001a.C0002a;
import com.mojang.p000a.C0000a;
import com.mojang.p000a.C0001b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/MinecraftServer.class */
public class MinecraftServer implements Runnable {

    /* JADX INFO: renamed from: a */
    static Logger f97a = Logger.getLogger("MinecraftServer");

    /* JADX INFO: renamed from: b */
    static DateFormat f98b = new SimpleDateFormat("HH:mm:ss");

    /* JADX INFO: renamed from: h */
    private C0000a f99h;

    /* JADX INFO: renamed from: l */
    private int f103l;

    /* JADX INFO: renamed from: c */
    public Level f105c;

    /* JADX INFO: renamed from: n */
    private boolean f106n;

    /* JADX INFO: renamed from: d */
    public String f107d;

    /* JADX INFO: renamed from: e */
    public String f108e;

    /* JADX INFO: renamed from: o */
    private int f109o;

    /* JADX INFO: renamed from: p */
    private C0025d[] f110p;

    /* JADX INFO: renamed from: i */
    private Map f100i = new HashMap();

    /* JADX INFO: renamed from: j */
    private List f101j = new ArrayList();

    /* JADX INFO: renamed from: k */
    private List f102k = new ArrayList();

    /* JADX INFO: renamed from: m */
    private Properties f104m = new Properties();

    /* JADX INFO: renamed from: f */
    public C0023b f111f = new C0023b("Admins", new File("admins.txt"), false);

    /* JADX INFO: renamed from: g */
    public C0023b f112g = new C0023b("Banned", new File("banned.txt"), false);

    /* JADX INFO: renamed from: q */
    private C0023b f113q = new C0023b("Banned (IP)", new File("banned-ip.txt"), false);

    public MinecraftServer() {
        this.f106n = false;
        try {
            this.f104m.load(new FileReader("server.properties"));
        } catch (Exception unused) {
            f97a.warning("Failed to load server.properties!");
        }
        try {
            this.f107d = this.f104m.getProperty("server-name", "Minecraft Server");
            this.f108e = this.f104m.getProperty("motd", "Welcome to my Minecraft Server!");
            this.f109o = Integer.parseInt(this.f104m.getProperty("port", "25565"));
            this.f103l = Integer.parseInt(this.f104m.getProperty("max-players", "16"));
            this.f106n = Boolean.parseBoolean(this.f104m.getProperty("public", "true"));
            if (this.f103l < 1) {
                this.f103l = 1;
            }
            if (this.f103l > 32) {
                this.f103l = 32;
            }
            this.f104m.setProperty("server-name", this.f107d);
            this.f104m.setProperty("motd", this.f108e);
            this.f104m.setProperty("max-players", "" + this.f103l);
            this.f104m.setProperty("port", "" + this.f109o);
            this.f104m.setProperty("public", "" + this.f106n);
        } catch (Exception unused2) {
            f97a.warning("server.properties is broken! Delete it or fix it!");
            System.exit(0);
        }
        try {
            this.f104m.store(new FileWriter("server.properties"), "Minecraft server properties");
        } catch (Exception unused3) {
            f97a.warning("Failed to save server.properties!");
        }
        this.f110p = new C0025d[this.f103l];
        this.f99h = new C0000a(this.f109o, this);
    }

    /* JADX INFO: renamed from: a */
    public final void m31a(C0001b c0001b) {
        C0025d c0025d = (C0025d) this.f100i.get(c0001b);
        if (c0025d != null) {
            f97a.info(c0025d + " disconnected");
            this.f100i.remove(c0025d.f124a);
            this.f101j.remove(c0025d);
            if (c0025d.f129c >= 0) {
                this.f110p[c0025d.f129c] = null;
            }
            m35a(C0002a.f35n, Integer.valueOf(c0025d.f129c));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m32b(C0001b c0001b) {
        this.f102k.add(new C0024c(c0001b, 40));
    }

    /* JADX INFO: renamed from: a */
    public final void m33a(C0025d c0025d) {
        this.f102k.add(new C0024c(c0025d.f124a, 40));
    }

    /* JADX INFO: renamed from: b */
    public static void m34b(C0025d c0025d) {
        c0025d.f124a.m0a();
    }

    /* JADX INFO: renamed from: a */
    public final void m35a(C0002a c0002a, Object... objArr) {
        for (int i = 0; i < this.f101j.size(); i++) {
            try {
                ((C0025d) this.f101j.get(i)).m60b(c0002a, objArr);
            } catch (Exception e) {
                ((C0025d) this.f101j.get(i)).m61a(e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m36a(C0025d c0025d, C0002a c0002a, Object... objArr) {
        for (int i = 0; i < this.f101j.size(); i++) {
            if (this.f101j.get(i) != c0025d) {
                try {
                    ((C0025d) this.f101j.get(i)).m60b(c0002a, objArr);
                } catch (Exception e) {
                    ((C0025d) this.f101j.get(i)).m61a(e);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        f97a.info("Now accepting input on " + this.f109o);
        try {
            long jNanoTime = System.nanoTime();
            long jNanoTime2 = System.nanoTime();
            int i = 0;
            while (true) {
                m40c();
                while (System.nanoTime() - jNanoTime2 > 50000000) {
                    jNanoTime2 += (long) 50000000;
                    m37b();
                    if (i % 1200 == 0) {
                        f97a.info("Saving level");
                        f97a.info("Load: " + this.f101j.size() + "/" + this.f103l);
                        try {
                            new C0005a(this);
                            C0005a.m8a(this.f105c, new FileOutputStream("server_level.dat"));
                        } catch (Exception e) {
                            f97a.severe("Failed to save the level! " + e);
                        }
                    }
                    if (i % 600 == 0) {
                        f97a.info("Sending heartbeat");
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.minecraft.net/heartbeat.jsp").openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            String str = "name=" + URLEncoder.encode(this.f107d, "UTF-8") + "&users=" + URLEncoder.encode("" + this.f101j.size(), "UTF-8") + "&max=" + URLEncoder.encode("" + this.f103l, "UTF-8") + "&public=" + URLEncoder.encode("" + this.f106n, "UTF-8") + "&port=" + URLEncoder.encode("" + this.f109o, "UTF-8");
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.setRequestProperty("Content-Length", "" + Integer.toString(str.getBytes().length));
                            httpURLConnection.setRequestProperty("Content-Language", "en-US");
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            new C0026e(this, httpURLConnection, str).start();
                        } catch (Exception e2) {
                            f97a.severe("Failed to assemble heartbeat: " + e2);
                            e2.printStackTrace();
                        }
                    }
                    i++;
                }
                while (System.nanoTime() - jNanoTime > 500000000) {
                    jNanoTime += (long) 500000000;
                    m35a(C0002a.f24c, new Object[0]);
                }
                Thread.sleep(5L);
            }
        } catch (Exception e3) {
            f97a.log(java.util.logging.Level.SEVERE, "Error in main loop, server shutting down!", (Throwable) e3);
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m37b() {
        this.f105c.tick();
        int i = 0;
        while (i < this.f102k.size()) {
            C0024c c0024c = (C0024c) this.f102k.get(i);
            m31a(c0024c.f121a);
            try {
                C0001b c0001b = c0024c.f121a;
                try {
                    if (c0001b.f6d.position() > 0) {
                        c0001b.f6d.flip();
                        c0001b.f4b.write(c0001b.f6d);
                        c0001b.f6d.compact();
                    }
                } catch (IOException unused) {
                }
                int i2 = c0024c.f122b;
                c0024c.f122b = i2 - 1;
                if (i2 <= 0) {
                    try {
                        c0024c.f121a.m0a();
                    } catch (Exception unused2) {
                    }
                    int i3 = i;
                    i--;
                    this.f102k.remove(i3);
                }
            } catch (Exception unused3) {
                try {
                    c0024c.f121a.m0a();
                } catch (Exception unused4) {
                }
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m38a(String str) {
        f97a.info(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m39b(String str) {
        f97a.fine(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:28|(2:67|29)|(2:30|(2:32|(8:34|(4:93|36|37|89)(2:38|(5:40|(2:43|41)|97|44|(1:46)(1:95))(2:94|47))|70|56|(1:58)|59|91|62)(1:92))(1:96))|48|(1:50)|51|70|56|(0)|59|91|62|26) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02ae, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0290 A[Catch: Exception -> 0x02ad, IOException -> 0x02b9, TryCatch #2 {Exception -> 0x02ad, blocks: (B:56:0x0287, B:58:0x0290), top: B:70:0x0287, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v122 */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r0v124 */
    /* JADX WARN: Type inference failed for: r0v125 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m40c() {
        /*
            Method dump skipped, instruction units count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.server.MinecraftServer.m40c():void");
    }

    /* JADX INFO: renamed from: a */
    public final void m41a(int i, int i2, int i3) {
        m35a(C0002a.f29h, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.f105c.getTile(i, i2, i3)));
    }

    /* JADX INFO: renamed from: d */
    private int m42d() {
        for (int i = 0; i < this.f103l; i++) {
            if (this.f110p[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final List m43a() {
        return this.f101j;
    }

    /* JADX INFO: renamed from: c */
    public final void m44c(String str) {
        boolean z = false;
        for (C0025d c0025d : this.f101j) {
            if (c0025d.f128b.equalsIgnoreCase(str)) {
                z = true;
                c0025d.m56a("You were kicked");
            }
        }
        if (z) {
            m35a(C0002a.f36o, -1, str + " got kicked from the server!");
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m45d(String str) {
        this.f112g.m50a(str);
        boolean z = false;
        for (C0025d c0025d : this.f101j) {
            if (c0025d.f128b.equalsIgnoreCase(str)) {
                z = true;
                c0025d.m56a("You were banned");
            }
        }
        if (z) {
            m35a(C0002a.f36o, -1, str + " got banned!");
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m46e(String str) {
        this.f111f.m50a(str);
        for (C0025d c0025d : this.f101j) {
            if (c0025d.f128b.equalsIgnoreCase(str)) {
                c0025d.m57b("You're now op!");
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m47f(String str) {
        this.f111f.m51b(str);
        for (C0025d c0025d : this.f101j) {
            if (c0025d.f128b.equalsIgnoreCase(str)) {
                c0025d.m57b("You're no longer op!");
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m48g(String str) {
        this.f112g.m51b(str);
    }

    /* JADX INFO: renamed from: h */
    public final void m49h(String str) {
        boolean z = false;
        for (C0025d c0025d : this.f101j) {
            if (c0025d.f128b.equalsIgnoreCase(str)) {
                this.f113q.m50a(c0025d.f124a.f10f);
                c0025d.m56a("You were banned");
                z = true;
            }
        }
        if (z) {
            m35a(C0002a.f36o, -1, str + " got banned!");
        }
    }

    public static void main(String[] strArr) {
        try {
            MinecraftServer minecraftServer = new MinecraftServer();
            f97a.info("Setting up");
            try {
                minecraftServer.f105c = new C0005a(minecraftServer).m7a(new FileInputStream("server_level.dat"));
            } catch (Exception e) {
                f97a.warning("Failed to load level. Generating a new level");
                e.printStackTrace();
            }
            if (minecraftServer.f105c == null) {
                minecraftServer.f105c = new C0016a(minecraftServer).m21a("--", 256, 256, 64);
            }
            try {
                new C0005a(minecraftServer);
                C0005a.m8a(minecraftServer.f105c, new FileOutputStream("server_level.dat"));
            } catch (Exception unused) {
            }
            minecraftServer.f105c.addListener$74652038(minecraftServer);
            new Thread(minecraftServer).start();
        } catch (Exception e2) {
            f97a.severe("Failed to start the server!");
            e2.printStackTrace();
        }
    }

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new C0027f());
        for (Handler handler : f97a.getParent().getHandlers()) {
            f97a.getParent().removeHandler(handler);
        }
        f97a.addHandler(consoleHandler);
    }
}
