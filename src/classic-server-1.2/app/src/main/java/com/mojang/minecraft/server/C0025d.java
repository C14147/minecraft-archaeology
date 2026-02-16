package com.mojang.minecraft.server;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0007b;
import com.mojang.minecraft.p001a.C0002a;
import com.mojang.p000a.C0001b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.mojang.minecraft.server.d */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/d.class */
public final class C0025d {

    /* JADX INFO: renamed from: d */
    private static Logger f123d = MinecraftServer.f97a;

    /* JADX INFO: renamed from: a */
    public final C0001b f124a;

    /* JADX INFO: renamed from: e */
    private final MinecraftServer f125e;

    /* JADX INFO: renamed from: f */
    private boolean f126f;

    /* JADX INFO: renamed from: c */
    public final int f129c;

    /* JADX INFO: renamed from: i */
    private int f131i;

    /* JADX INFO: renamed from: j */
    private int f132j;

    /* JADX INFO: renamed from: k */
    private int f133k;

    /* JADX INFO: renamed from: l */
    private int f134l;

    /* JADX INFO: renamed from: m */
    private int f135m;

    /* JADX INFO: renamed from: g */
    private boolean f127g = false;

    /* JADX INFO: renamed from: b */
    public String f128b = "";

    /* JADX INFO: renamed from: h */
    private ArrayList f130h = new ArrayList();

    /* JADX INFO: renamed from: n */
    private int f136n = 0;

    /* JADX INFO: renamed from: o */
    private volatile byte[] f137o = null;

    public C0025d(MinecraftServer minecraftServer, C0001b c0001b, int i) {
        this.f126f = false;
        this.f125e = minecraftServer;
        this.f124a = c0001b;
        this.f129c = i;
        c0001b.f7e = this;
        Level level = minecraftServer.f105c;
        this.f131i = (level.xSpawn << 5) + 16;
        this.f132j = (level.ySpawn << 5) + 16;
        this.f133k = (level.zSpawn << 5) + 16;
        this.f135m = (int) ((level.rotSpawn * 256.0f) / 360.0f);
        this.f134l = 0;
        if (i == -1) {
            this.f126f = false;
        }
    }

    public final String toString() {
        return !this.f126f ? this.f124a.f10f : this.f128b + " (" + this.f124a.f10f + ")";
    }

    /* JADX INFO: renamed from: a */
    public final void m55a(C0002a c0002a, Object[] objArr) {
        if (c0002a == C0002a.f23b) {
            byte bByteValue = ((Byte) objArr[0]).byteValue();
            String strTrim = ((String) objArr[1]).trim();
            f123d.info(this + " logged in as " + strTrim);
            if (bByteValue != 3) {
                m56a("Wrong protocol version.");
                return;
            }
            if (this.f125e.f112g.m52c(strTrim)) {
                m56a("You're banned!");
                return;
            }
            this.f126f = true;
            this.f128b = strTrim;
            this.f124a.m1a(C0002a.f23b, (byte) 3, this.f125e.f107d, this.f125e.f108e);
            new C0022a(this, this.f125e.f105c.copyBlocks()).start();
            return;
        }
        if (c0002a == C0002a.f24c) {
            return;
        }
        if (c0002a == C0002a.f28g) {
            short sShortValue = ((Short) objArr[0]).shortValue();
            short sShortValue2 = ((Short) objArr[1]).shortValue();
            short sShortValue3 = ((Short) objArr[2]).shortValue();
            byte bByteValue2 = ((Byte) objArr[3]).byteValue();
            byte bByteValue3 = ((Byte) objArr[4]).byteValue();
            Level level = this.f125e.f105c;
            if (bByteValue2 == 0) {
                level.setTile(sShortValue, sShortValue2, sShortValue3, 0);
                return;
            }
            C0007b c0007b = C0007b.f48a[level.getTile(sShortValue, sShortValue2, sShortValue3)];
            if (c0007b == null || c0007b == C0007b.f55g || c0007b == C0007b.f56h || c0007b == C0007b.f57i || c0007b == C0007b.f58j) {
                level.setTile(sShortValue, sShortValue2, sShortValue3, bByteValue3);
                C0007b.f48a[bByteValue3].mo17a(level, sShortValue, sShortValue2, sShortValue3);
                return;
            }
            return;
        }
        if (c0002a == C0002a.f36o) {
            String strTrim2 = objArr[1].toString().trim();
            if (strTrim2.length() > 0) {
                if (!strTrim2.startsWith("/")) {
                    f123d.info(this.f128b + " says: " + strTrim2);
                    this.f125e.m35a(C0002a.f36o, Integer.valueOf(this.f129c), this.f128b + ": " + strTrim2);
                    return;
                }
                if (!this.f125e.f111f.m52c(this.f128b)) {
                    m60b(C0002a.f36o, -1, "You're not a server admin!");
                    return;
                }
                String[] strArrSplit = strTrim2.split(" ");
                if (strArrSplit[0].toLowerCase().equals("/ban")) {
                    this.f125e.m45d(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/kick")) {
                    this.f125e.m44c(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/banip")) {
                    this.f125e.m49h(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/unban")) {
                    this.f125e.m48g(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/op")) {
                    this.f125e.m46e(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/deop")) {
                    this.f125e.m47f(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/broadcast")) {
                    this.f125e.m35a(C0002a.f36o, -1, strTrim2.substring("/broadcast ".length()).trim());
                    return;
                } else if (strArrSplit[0].toLowerCase().equals("/say")) {
                    this.f125e.m35a(C0002a.f36o, -1, strTrim2.substring("/say ".length()).trim());
                    return;
                } else {
                    m60b(C0002a.f36o, -1, "Unknown command!");
                    return;
                }
            }
            return;
        }
        if (c0002a == C0002a.f31j && this.f127g) {
            ((Byte) objArr[0]).byteValue();
            short sShortValue4 = ((Short) objArr[1]).shortValue();
            short sShortValue5 = ((Short) objArr[2]).shortValue();
            short sShortValue6 = ((Short) objArr[3]).shortValue();
            byte bByteValue4 = ((Byte) objArr[4]).byteValue();
            byte bByteValue5 = ((Byte) objArr[5]).byteValue();
            int i = this.f136n;
            this.f136n = i + 1;
            if (i % 2 == 0) {
                if (sShortValue4 == this.f131i && sShortValue5 == this.f132j && sShortValue6 == this.f133k && bByteValue4 == this.f135m && bByteValue5 == this.f134l) {
                    return;
                }
                int i2 = sShortValue4 - this.f131i;
                int i3 = sShortValue5 - this.f132j;
                int i4 = sShortValue6 - this.f133k;
                if (i2 >= 128 || i2 < -128 || i3 >= 128 || i3 < -128 || i4 >= 128 || i4 < -128 || this.f136n % 20 <= 1) {
                    this.f131i = sShortValue4;
                    this.f132j = sShortValue5;
                    this.f133k = sShortValue6;
                    this.f135m = bByteValue4;
                    this.f134l = bByteValue5;
                    this.f125e.m36a(this, C0002a.f31j, Integer.valueOf(this.f129c), Short.valueOf(sShortValue4), Short.valueOf(sShortValue5), Short.valueOf(sShortValue6), Byte.valueOf(bByteValue4), Byte.valueOf(bByteValue5));
                    return;
                }
                if (sShortValue4 == this.f131i && sShortValue5 == this.f132j && sShortValue6 == this.f133k) {
                    this.f135m = bByteValue4;
                    this.f134l = bByteValue5;
                    this.f125e.m36a(this, C0002a.f34m, Integer.valueOf(this.f129c), Byte.valueOf(bByteValue4), Byte.valueOf(bByteValue5));
                } else {
                    if (bByteValue4 == this.f135m && bByteValue5 == this.f134l) {
                        this.f131i = sShortValue4;
                        this.f132j = sShortValue5;
                        this.f133k = sShortValue6;
                        this.f125e.m36a(this, C0002a.f33l, Integer.valueOf(this.f129c), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        return;
                    }
                    this.f131i = sShortValue4;
                    this.f132j = sShortValue5;
                    this.f133k = sShortValue6;
                    this.f135m = bByteValue4;
                    this.f134l = bByteValue5;
                    this.f125e.m36a(this, C0002a.f32k, Integer.valueOf(this.f129c), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Byte.valueOf(bByteValue4), Byte.valueOf(bByteValue5));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m56a(String str) {
        this.f124a.m1a(C0002a.f37p, str);
        f123d.info("Kicking " + this + ": " + str);
        this.f125e.m33a(this);
    }

    /* JADX INFO: renamed from: b */
    public final void m57b(String str) {
        m60b(C0002a.f36o, -1, str);
    }

    /* JADX INFO: renamed from: a */
    public final void m58a(byte[] bArr) {
        this.f137o = bArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m59a() {
        if (this.f137o == null) {
            return;
        }
        Level level = this.f125e.f105c;
        byte[] bArr = new byte[1024];
        int i = 0;
        int length = this.f137o.length;
        this.f124a.m1a(C0002a.f25d, new Object[0]);
        while (length > 0) {
            int i2 = length;
            int length2 = i2;
            if (i2 > bArr.length) {
                length2 = bArr.length;
            }
            System.arraycopy(this.f137o, i, bArr, 0, length2);
            this.f124a.m1a(C0002a.f26e, Integer.valueOf(length2), bArr, Integer.valueOf(((i + length2) * 100) / this.f137o.length));
            length -= length2;
            i += length2;
        }
        this.f124a.m1a(C0002a.f27f, Integer.valueOf(level.width), Integer.valueOf(level.depth), Integer.valueOf(level.height));
        this.f124a.m1a(C0002a.f30i, -1, this.f128b, Integer.valueOf(this.f131i), Integer.valueOf(this.f132j), Integer.valueOf(this.f133k), Integer.valueOf(this.f135m), Integer.valueOf(this.f134l));
        this.f125e.m36a(this, C0002a.f30i, Integer.valueOf(this.f129c), this.f128b, Integer.valueOf((level.xSpawn << 5) + 16), Integer.valueOf((level.ySpawn << 5) + 16), Integer.valueOf((level.zSpawn << 5) + 16), Integer.valueOf((int) ((level.rotSpawn * 256.0f) / 360.0f)), 0);
        this.f125e.m35a(C0002a.f36o, -1, this.f128b + " joined the game");
        for (C0025d c0025d : this.f125e.m43a()) {
            if (c0025d != null && c0025d != this && c0025d.f126f) {
                this.f124a.m1a(C0002a.f30i, Integer.valueOf(c0025d.f129c), c0025d.f128b, Integer.valueOf(c0025d.f131i), Integer.valueOf(c0025d.f132j), Integer.valueOf(c0025d.f133k), Integer.valueOf(c0025d.f135m), Integer.valueOf(c0025d.f134l));
            }
        }
        this.f127g = true;
        int i3 = 0;
        while (i3 < this.f130h.size()) {
            int i4 = i3;
            int i5 = i3 + 1;
            i3 = i5 + 1;
            m60b((C0002a) this.f130h.get(i4), (Object[]) this.f130h.get(i5));
        }
        this.f130h = null;
        this.f137o = null;
    }

    /* JADX INFO: renamed from: b */
    public final void m60b(C0002a c0002a, Object... objArr) {
        if (this.f127g) {
            this.f124a.m1a(c0002a, objArr);
        } else {
            this.f130h.add(c0002a);
            this.f130h.add(objArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m61a(Exception exc) {
        if (exc instanceof IOException) {
            f123d.info(this + " lost connection suddenly. (" + exc + ")");
        } else {
            f123d.warning(this + ":" + exc);
            f123d.log(java.util.logging.Level.WARNING, "Exception handling " + this + "!", (Throwable) exc);
        }
        this.f125e.m36a(this, C0002a.f36o, -1, this.f128b + " left the game");
        MinecraftServer.m34b(this);
    }
}
