package com.mojang.minecraft.server;

import com.mojang.minecraft.level.C0006a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p004b.C0019a;
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
    static Logger f102a = Logger.getLogger("MinecraftServer");

    /* JADX INFO: renamed from: b */
    static DateFormat f103b = new SimpleDateFormat("HH:mm:ss");

    /* JADX INFO: renamed from: k */
    private C0000a f104k;

    /* JADX INFO: renamed from: o */
    private int f108o;

    /* JADX INFO: renamed from: c */
    public Level f110c;

    /* JADX INFO: renamed from: q */
    private boolean f111q;

    /* JADX INFO: renamed from: d */
    public String f112d;

    /* JADX INFO: renamed from: e */
    public String f113e;

    /* JADX INFO: renamed from: r */
    private int f114r;

    /* JADX INFO: renamed from: s */
    private C0028d[] f115s;

    /* JADX INFO: renamed from: j */
    public boolean f124j;

    /* JADX INFO: renamed from: x */
    private int f125x;

    /* JADX INFO: renamed from: l */
    private Map f105l = new HashMap();

    /* JADX INFO: renamed from: m */
    private List f106m = new ArrayList();

    /* JADX INFO: renamed from: n */
    private List f107n = new ArrayList();

    /* JADX INFO: renamed from: p */
    private Properties f109p = new Properties();

    /* JADX INFO: renamed from: f */
    public C0026b f116f = new C0026b("Admins", new File("admins.txt"));

    /* JADX INFO: renamed from: g */
    public C0026b f117g = new C0026b("Banned", new File("banned.txt"));

    /* JADX INFO: renamed from: t */
    private C0026b f118t = new C0026b("Banned (IP)", new File("banned-ip.txt"));

    /* JADX INFO: renamed from: h */
    public C0026b f119h = new C0026b("Players", new File("players.txt"));

    /* JADX INFO: renamed from: u */
    private List f120u = new ArrayList();

    /* JADX INFO: renamed from: v */
    private String f121v = "" + new Random().nextLong();

    /* JADX INFO: renamed from: w */
    private String f122w = "";

    /* JADX INFO: renamed from: i */
    public C0031g f123i = new C0031g(this.f121v);

    public MinecraftServer() {
        this.f111q = false;
        this.f124j = false;
        try {
            this.f109p.load(new FileReader("server.properties"));
        } catch (Exception unused) {
            f102a.warning("Failed to load server.properties!");
        }
        try {
            this.f112d = this.f109p.getProperty("server-name", "Minecraft Server");
            this.f113e = this.f109p.getProperty("motd", "Welcome to my Minecraft Server!");
            this.f114r = Integer.parseInt(this.f109p.getProperty("port", "25565"));
            this.f108o = Integer.parseInt(this.f109p.getProperty("max-players", "16"));
            this.f111q = Boolean.parseBoolean(this.f109p.getProperty("public", "true"));
            this.f124j = Boolean.parseBoolean(this.f109p.getProperty("verify-names", "true"));
            if (this.f108o < 1) {
                this.f108o = 1;
            }
            if (this.f108o > 32) {
                this.f108o = 32;
            }
            this.f125x = Integer.parseInt(this.f109p.getProperty("max-connections", "3"));
            this.f109p.setProperty("server-name", this.f112d);
            this.f109p.setProperty("motd", this.f113e);
            this.f109p.setProperty("max-players", "" + this.f108o);
            this.f109p.setProperty("port", "" + this.f114r);
            this.f109p.setProperty("public", "" + this.f111q);
            this.f109p.setProperty("verify-names", "" + this.f124j);
            this.f109p.setProperty("max-connections", "3");
        } catch (Exception unused2) {
            f102a.warning("server.properties is broken! Delete it or fix it!");
            System.exit(0);
        }
        try {
            this.f109p.store(new FileWriter("server.properties"), "Minecraft server properties");
        } catch (Exception unused3) {
            f102a.warning("Failed to save server.properties!");
        }
        this.f115s = new C0028d[this.f108o];
        this.f104k = new C0000a(this.f114r, this);
        new C0033i(this).start();
    }

    /* JADX INFO: renamed from: a */
    public final void m33a(C0001b c0001b) {
        C0028d c0028d = (C0028d) this.f105l.get(c0001b);
        if (c0028d != null) {
            this.f119h.m58b(c0028d.f139b);
            f102a.info(c0028d + " disconnected");
            this.f105l.remove(c0028d.f135a);
            this.f106m.remove(c0028d);
            if (c0028d.f140c >= 0) {
                this.f115s[c0028d.f140c] = null;
            }
            m37a(C0003a.f36n, Integer.valueOf(c0028d.f140c));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m34b(C0001b c0001b) {
        this.f107n.add(new C0027c(c0001b, 100));
    }

    /* JADX INFO: renamed from: a */
    public final void m35a(C0028d c0028d) {
        this.f107n.add(new C0027c(c0028d.f135a, 100));
    }

    /* JADX INFO: renamed from: b */
    public static void m36b(C0028d c0028d) {
        c0028d.f135a.m0a();
    }

    /* JADX INFO: renamed from: a */
    public final void m37a(C0003a c0003a, Object... objArr) {
        for (int i = 0; i < this.f106m.size(); i++) {
            try {
                ((C0028d) this.f106m.get(i)).m69b(c0003a, objArr);
            } catch (Exception e) {
                ((C0028d) this.f106m.get(i)).m70a(e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m38a(C0028d c0028d, C0003a c0003a, Object... objArr) {
        for (int i = 0; i < this.f106m.size(); i++) {
            if (this.f106m.get(i) != c0028d) {
                try {
                    ((C0028d) this.f106m.get(i)).m69b(c0003a, objArr);
                } catch (Exception e) {
                    ((C0028d) this.f106m.get(i)).m70a(e);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        f102a.info("Now accepting input on " + this.f114r);
        try {
            long jNanoTime = System.nanoTime();
            long jNanoTime2 = System.nanoTime();
            int i = 0;
            while (true) {
                m43c();
                while (System.nanoTime() - jNanoTime2 > 50000000) {
                    jNanoTime2 += (long) 50000000;
                    m40b();
                    if (i % 1200 == 0) {
                        try {
                            new C0006a(this);
                            C0006a.m7a(this.f110c, new FileOutputStream("server_level.dat"));
                        } catch (Exception e) {
                            f102a.severe("Failed to save the level! " + e);
                        }
                        f102a.info("Level saved! Load: " + this.f106m.size() + "/" + this.f108o);
                    }
                    if (i % 900 == 0) {
                        HashMap map = new HashMap();
                        map.put("name", this.f112d);
                        map.put("users", Integer.valueOf(this.f106m.size()));
                        map.put("max", Integer.valueOf(this.f108o));
                        map.put("public", Boolean.valueOf(this.f111q));
                        map.put("port", Integer.valueOf(this.f114r));
                        map.put("salt", this.f121v);
                        map.put("version", (byte) 5);
                        new C0032h(this, m39a(map)).start();
                    }
                    i++;
                }
                while (System.nanoTime() - jNanoTime > 500000000) {
                    jNanoTime += (long) 500000000;
                    m37a(C0003a.f25c, new Object[0]);
                }
                Thread.sleep(5L);
            }
        } catch (Exception e2) {
            f102a.log(java.util.logging.Level.SEVERE, "Error in main loop, server shutting down!", (Throwable) e2);
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, java.lang.Exception] */
    /* JADX INFO: renamed from: a */
    private static String m39a(Map map) {
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
    private void m40b() {
        for (C0028d c0028d : this.f106m) {
            try {
                c0028d.m68a();
            } catch (Exception e) {
                c0028d.m70a(e);
            }
        }
        this.f110c.tick();
        int i = 0;
        while (i < this.f107n.size()) {
            C0027c c0027c = (C0027c) this.f107n.get(i);
            m33a(c0027c.f132a);
            try {
                C0001b c0001b = c0027c.f132a;
                try {
                    if (c0001b.f6d.position() > 0) {
                        c0001b.f6d.flip();
                        c0001b.f4b.write(c0001b.f6d);
                        c0001b.f6d.compact();
                    }
                } catch (IOException unused) {
                }
                int i2 = c0027c.f133b;
                c0027c.f133b = i2 - 1;
                if (i2 <= 0) {
                    try {
                        c0027c.f132a.m0a();
                    } catch (Exception unused2) {
                    }
                    int i3 = i;
                    i--;
                    this.f107n.remove(i3);
                }
            } catch (Exception unused3) {
                try {
                    c0027c.f132a.m0a();
                } catch (Exception unused4) {
                }
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m41a(String str) {
        f102a.info(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m42b(String str) {
        f102a.fine(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:44|(2:83|45)|(2:46|(2:48|(8:50|(4:114|52|53|109)(2:54|(5:56|(2:59|57)|117|60|(1:62)(1:116))(2:115|63))|86|72|(1:74)|75|111|78)(1:113))(1:112))|64|(1:66)|67|86|72|(0)|75|111|78|42) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0337, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0319 A[Catch: Exception -> 0x0336, IOException -> 0x0342, TryCatch #2 {Exception -> 0x0336, blocks: (B:72:0x0310, B:74:0x0319), top: B:86:0x0310, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v138 */
    /* JADX WARN: Type inference failed for: r0v139 */
    /* JADX WARN: Type inference failed for: r0v140 */
    /* JADX WARN: Type inference failed for: r0v141 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v29, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m43c() {
        /*
            Method dump skipped, instruction units count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.server.MinecraftServer.m43c():void");
    }

    /* JADX INFO: renamed from: a */
    public final void m44a(C0028d c0028d, String str) {
        f102a.info((c0028d == null ? "[console]" : c0028d.f139b) + " admins: " + str);
        String[] strArrSplit = str.split(" ");
        if (strArrSplit[0].toLowerCase().equals("ban") && strArrSplit.length > 1) {
            m49e(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("kick") && strArrSplit.length > 1) {
            m48d(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("banip") && strArrSplit.length > 1) {
            m52h(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("unban") && strArrSplit.length > 1) {
            this.f117g.m58b(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("op") && strArrSplit.length > 1) {
            m50f(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("deop") && strArrSplit.length > 1) {
            m51g(strArrSplit[1]);
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("setspawn")) {
            if (c0028d != null) {
                this.f110c.setSpawnPos(c0028d.f145d / 32, c0028d.f146e / 32, c0028d.f147f / 32, (c0028d.f149h * 320) / 256);
                return;
            } else {
                f102a.info("Can't set spawn from console!");
                return;
            }
        }
        if (strArrSplit[0].toLowerCase().equals("broadcast") && strArrSplit.length > 1) {
            m37a(C0003a.f37o, -1, str.substring("broadcast ".length()).trim());
            return;
        }
        if (strArrSplit[0].toLowerCase().equals("say") && strArrSplit.length > 1) {
            m37a(C0003a.f37o, -1, str.substring("say ".length()).trim());
            return;
        }
        if (!strArrSplit[0].toLowerCase().equals("teleport") || strArrSplit.length <= 1) {
            if (c0028d != null) {
                c0028d.m69b(C0003a.f37o, -1, "Unknown command!");
            }
        } else {
            if (c0028d == null) {
                f102a.info("Can't teleport from console!");
                return;
            }
            C0028d c0028dM53c = m53c(strArrSplit[1]);
            if (c0028dM53c != null) {
                c0028d.f135a.m1a(C0003a.f32j, -1, Integer.valueOf(c0028dM53c.f145d), Integer.valueOf(c0028dM53c.f146e), Integer.valueOf(c0028dM53c.f147f), Integer.valueOf(c0028dM53c.f149h), Integer.valueOf(c0028dM53c.f148g));
            } else {
                c0028d.m69b(C0003a.f37o, -1, "No such player");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m45a(int i, int i2, int i3) {
        m37a(C0003a.f30h, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.f110c.getTile(i, i2, i3)));
    }

    /* JADX INFO: renamed from: d */
    private int m46d() {
        for (int i = 0; i < this.f108o; i++) {
            if (this.f115s[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final List m47a() {
        return this.f106m;
    }

    /* JADX INFO: renamed from: d */
    private void m48d(String str) {
        boolean z = false;
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str)) {
                z = true;
                c0028d.m64a("You were kicked");
            }
        }
        if (z) {
            m37a(C0003a.f37o, -1, str + " got kicked from the server!");
        }
    }

    /* JADX INFO: renamed from: e */
    private void m49e(String str) {
        this.f117g.m57a(str);
        boolean z = false;
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str)) {
                z = true;
                c0028d.m64a("You were banned");
            }
        }
        if (z) {
            m37a(C0003a.f37o, -1, str + " got banned!");
        }
    }

    /* JADX INFO: renamed from: f */
    private void m50f(String str) {
        this.f116f.m57a(str);
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str)) {
                c0028d.m66b("You're now op!");
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m51g(String str) {
        this.f116f.m58b(str);
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str)) {
                c0028d.m66b("You're no longer op!");
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m52h(String str) {
        boolean z = false;
        String str2 = "";
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str) || c0028d.f135a.f10f.equalsIgnoreCase(str) || c0028d.f135a.f10f.equalsIgnoreCase("/" + str)) {
                this.f118t.m57a(c0028d.f135a.f10f);
                c0028d.m64a("You were banned");
                if (str2 == "") {
                    str2 = str2 + ", ";
                }
                str2 = str2 + c0028d.f139b;
                z = true;
            }
        }
        if (z) {
            m37a(C0003a.f37o, -1, str2 + " got ip banned!");
        }
    }

    /* JADX INFO: renamed from: c */
    public final C0028d m53c(String str) {
        for (C0028d c0028d : this.f106m) {
            if (c0028d.f139b.equalsIgnoreCase(str)) {
                return c0028d;
            }
        }
        return null;
    }

    public static void main(String[] strArr) {
        try {
            MinecraftServer minecraftServer = new MinecraftServer();
            f102a.info("Setting up");
            File file = new File("server_level.dat");
            if (file.exists()) {
                try {
                    minecraftServer.f110c = new C0006a(minecraftServer).m6a(new FileInputStream(file));
                } catch (Exception e) {
                    f102a.warning("Failed to load level. Generating a new level");
                    e.printStackTrace();
                }
            } else {
                f102a.warning("No level file found. Generating a new level");
            }
            if (minecraftServer.f110c == null) {
                minecraftServer.f110c = new C0019a(minecraftServer).m23a("--", 256, 256, 64);
            }
            try {
                new C0006a(minecraftServer);
                C0006a.m7a(minecraftServer.f110c, new FileOutputStream("server_level.dat"));
            } catch (Exception unused) {
            }
            minecraftServer.f110c.addListener$74652038(minecraftServer);
            new Thread(minecraftServer).start();
        } catch (Exception e2) {
            f102a.severe("Failed to start the server!");
            e2.printStackTrace();
        }
    }

    static {
        C0030f c0030f = new C0030f();
        for (Handler handler : f102a.getParent().getHandlers()) {
            f102a.getParent().removeHandler(handler);
        }
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(c0030f);
        f102a.addHandler(consoleHandler);
        try {
            C0029e c0029e = new C0029e(new FileOutputStream("server.log"), c0030f);
            c0029e.setFormatter(c0030f);
            f102a.addHandler(c0029e);
        } catch (Exception e) {
            f102a.warning("Failed to open file server.log for writing: " + e);
        }
    }
}
