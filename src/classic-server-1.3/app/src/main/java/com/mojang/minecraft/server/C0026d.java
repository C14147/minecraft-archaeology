package com.mojang.minecraft.server;

import com.mojang.minecraft.C0002a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0008b;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.p000a.C0001b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.mojang.minecraft.server.d */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/d.class */
public final class C0026d {

    /* JADX INFO: renamed from: d */
    private static Logger f131d = MinecraftServer.f101a;

    /* JADX INFO: renamed from: a */
    public final C0001b f132a;

    /* JADX INFO: renamed from: e */
    private final MinecraftServer f133e;

    /* JADX INFO: renamed from: c */
    public final int f137c;

    /* JADX INFO: renamed from: j */
    private int f140j;

    /* JADX INFO: renamed from: k */
    private int f141k;

    /* JADX INFO: renamed from: l */
    private int f142l;

    /* JADX INFO: renamed from: m */
    private int f143m;

    /* JADX INFO: renamed from: n */
    private int f144n;

    /* JADX INFO: renamed from: f */
    private boolean f134f = false;

    /* JADX INFO: renamed from: g */
    private boolean f135g = false;

    /* JADX INFO: renamed from: b */
    public String f136b = "";

    /* JADX INFO: renamed from: h */
    private ArrayList f138h = new ArrayList();

    /* JADX INFO: renamed from: o */
    private int f145o = 0;

    /* JADX INFO: renamed from: p */
    private volatile byte[] f146p = null;

    /* JADX INFO: renamed from: i */
    private long f139i = System.currentTimeMillis();

    public C0026d(MinecraftServer minecraftServer, C0001b c0001b, int i) {
        this.f133e = minecraftServer;
        this.f132a = c0001b;
        this.f137c = i;
        c0001b.f7e = this;
        Level level = minecraftServer.f109c;
        this.f140j = (level.xSpawn << 5) + 16;
        this.f141k = (level.ySpawn << 5) + 16;
        this.f142l = (level.zSpawn << 5) + 16;
        this.f144n = (int) ((level.rotSpawn * 256.0f) / 360.0f);
        this.f143m = 0;
    }

    public final String toString() {
        return !this.f134f ? this.f132a.f10f : this.f136b + " (" + this.f132a.f10f + ")";
    }

    /* JADX INFO: renamed from: a */
    public final void m59a(C0003a c0003a, Object[] objArr) {
        if (c0003a == C0003a.f24b) {
            byte bByteValue = ((Byte) objArr[0]).byteValue();
            String strTrim = ((String) objArr[1]).trim();
            String str = (String) objArr[2];
            if (this.f133e.f122j && !str.equals(this.f133e.f121i.m68a(strTrim))) {
                m60a("Illegal name.");
                return;
            }
            C0026d c0026dM51i = this.f133e.m51i(strTrim);
            if (c0026dM51i != null) {
                c0026dM51i.m60a("You logged in from another computer.");
            }
            f131d.info(this + " logged in as " + strTrim);
            if (bByteValue != 4) {
                m60a("Wrong protocol version.");
                return;
            }
            if (this.f133e.f116g.m56c(strTrim)) {
                m60a("You're banned!");
                return;
            }
            this.f134f = true;
            this.f136b = strTrim;
            this.f132a.m1a(C0003a.f24b, (byte) 4, this.f133e.f111d, this.f133e.f112e);
            new C0023a(this, this.f133e.f109c.copyBlocks()).start();
            this.f133e.f118h.m54a(strTrim);
            return;
        }
        if (c0003a == C0003a.f25c) {
            return;
        }
        if (c0003a == C0003a.f29g) {
            m61a(((Short) objArr[0]).shortValue(), ((Short) objArr[1]).shortValue(), ((Short) objArr[2]).shortValue(), ((Byte) objArr[3]).byteValue(), ((Byte) objArr[4]).byteValue());
            return;
        }
        if (c0003a == C0003a.f37o) {
            String strTrim2 = objArr[1].toString().trim();
            if (strTrim2.length() > 0) {
                if (!strTrim2.startsWith("/")) {
                    f131d.info(this.f136b + " says: " + strTrim2);
                    this.f133e.m35a(C0003a.f37o, Integer.valueOf(this.f137c), this.f136b + ": " + strTrim2);
                    return;
                }
                if (!this.f133e.f115f.m56c(this.f136b)) {
                    m66b(C0003a.f37o, -1, "You're not a server admin!");
                    return;
                }
                String[] strArrSplit = strTrim2.split(" ");
                if (strArrSplit[0].toLowerCase().equals("/ban")) {
                    this.f133e.m46d(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/kick")) {
                    this.f133e.m45c(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/banip")) {
                    this.f133e.m50h(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/unban")) {
                    this.f133e.m49g(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/op")) {
                    this.f133e.m47e(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/deop")) {
                    this.f133e.m48f(strArrSplit[1]);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/setspawn")) {
                    this.f133e.f109c.setSpawnPos(this.f140j / 32, this.f141k / 32, this.f142l / 32, (this.f144n * 320) / 256);
                    return;
                }
                if (strArrSplit[0].toLowerCase().equals("/broadcast")) {
                    this.f133e.m35a(C0003a.f37o, -1, strTrim2.substring("/broadcast ".length()).trim());
                    return;
                } else if (strArrSplit[0].toLowerCase().equals("/say")) {
                    this.f133e.m35a(C0003a.f37o, -1, strTrim2.substring("/say ".length()).trim());
                    return;
                } else {
                    m66b(C0003a.f37o, -1, "Unknown command!");
                    return;
                }
            }
            return;
        }
        if (c0003a == C0003a.f32j && this.f135g) {
            ((Byte) objArr[0]).byteValue();
            short sShortValue = ((Short) objArr[1]).shortValue();
            short sShortValue2 = ((Short) objArr[2]).shortValue();
            short sShortValue3 = ((Short) objArr[3]).shortValue();
            byte bByteValue2 = ((Byte) objArr[4]).byteValue();
            byte bByteValue3 = ((Byte) objArr[5]).byteValue();
            int i = this.f145o;
            this.f145o = i + 1;
            if (i % 2 == 0) {
                if (sShortValue == this.f140j && sShortValue2 == this.f141k && sShortValue3 == this.f142l && bByteValue2 == this.f144n && bByteValue3 == this.f143m) {
                    return;
                }
                int i2 = sShortValue - this.f140j;
                int i3 = sShortValue2 - this.f141k;
                int i4 = sShortValue3 - this.f142l;
                if (i2 >= 128 || i2 < -128 || i3 >= 128 || i3 < -128 || i4 >= 128 || i4 < -128 || this.f145o % 20 <= 1) {
                    this.f140j = sShortValue;
                    this.f141k = sShortValue2;
                    this.f142l = sShortValue3;
                    this.f144n = bByteValue2;
                    this.f143m = bByteValue3;
                    this.f133e.m36a(this, C0003a.f32j, Integer.valueOf(this.f137c), Short.valueOf(sShortValue), Short.valueOf(sShortValue2), Short.valueOf(sShortValue3), Byte.valueOf(bByteValue2), Byte.valueOf(bByteValue3));
                    return;
                }
                if (sShortValue == this.f140j && sShortValue2 == this.f141k && sShortValue3 == this.f142l) {
                    this.f144n = bByteValue2;
                    this.f143m = bByteValue3;
                    this.f133e.m36a(this, C0003a.f35m, Integer.valueOf(this.f137c), Byte.valueOf(bByteValue2), Byte.valueOf(bByteValue3));
                } else {
                    if (bByteValue2 == this.f144n && bByteValue3 == this.f143m) {
                        this.f140j = sShortValue;
                        this.f141k = sShortValue2;
                        this.f142l = sShortValue3;
                        this.f133e.m36a(this, C0003a.f34l, Integer.valueOf(this.f137c), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        return;
                    }
                    this.f140j = sShortValue;
                    this.f141k = sShortValue2;
                    this.f142l = sShortValue3;
                    this.f144n = bByteValue2;
                    this.f143m = bByteValue3;
                    this.f133e.m36a(this, C0003a.f33k, Integer.valueOf(this.f137c), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Byte.valueOf(bByteValue2), Byte.valueOf(bByteValue3));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m60a(String str) {
        this.f132a.m1a(C0003a.f38p, str);
        f131d.info("Kicking " + this + ": " + str);
        this.f133e.m33a(this);
    }

    /* JADX INFO: renamed from: a */
    private void m61a(int i, int i2, int i3, int i4, int i5) {
        Level level = this.f133e.f109c;
        float f = i - (this.f140j / 32.0f);
        float f2 = i2 - ((this.f141k / 32.0f) - 1.62f);
        float f3 = i3 - (this.f142l / 32.0f);
        float f4 = (f * f) + (f2 * f2) + (f3 * f3);
        if (f4 >= 8.0f * 8.0f) {
            System.out.println("Distance: " + Math.sqrt(f4));
            m62c("Distance");
            return;
        }
        boolean z = false;
        for (int i6 = 0; i6 < C0002a.f22a.length && !z; i6++) {
            if (C0002a.f22a[i6] == i5) {
                z = true;
            }
        }
        if (!z) {
            m62c("Tile type");
            return;
        }
        if (i4 == 0) {
            level.setTile(i, i2, i3, 0);
            return;
        }
        C0008b c0008b = C0008b.f49a[level.getTile(i, i2, i3)];
        if (c0008b == null || c0008b == C0008b.f59j || c0008b == C0008b.f60k || c0008b == C0008b.f61l || c0008b == C0008b.f62m) {
            level.setTile(i, i2, i3, i5);
            C0008b.f49a[i5].mo17a(level, i, i2, i3);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m62c(String str) {
        m60a("Cheat detected: " + str);
    }

    /* JADX INFO: renamed from: b */
    public final void m63b(String str) {
        m66b(C0003a.f37o, -1, str);
    }

    /* JADX INFO: renamed from: a */
    public final void m64a(byte[] bArr) {
        this.f146p = bArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m65a() {
        if (!this.f134f && System.currentTimeMillis() - this.f139i > 5000) {
            m60a("You need to log in!");
            return;
        }
        if (this.f146p == null) {
            return;
        }
        Level level = this.f133e.f109c;
        byte[] bArr = new byte[1024];
        int i = 0;
        int length = this.f146p.length;
        this.f132a.m1a(C0003a.f26d, new Object[0]);
        while (length > 0) {
            int i2 = length;
            int length2 = i2;
            if (i2 > bArr.length) {
                length2 = bArr.length;
            }
            System.arraycopy(this.f146p, i, bArr, 0, length2);
            this.f132a.m1a(C0003a.f27e, Integer.valueOf(length2), bArr, Integer.valueOf(((i + length2) * 100) / this.f146p.length));
            length -= length2;
            i += length2;
        }
        this.f132a.m1a(C0003a.f28f, Integer.valueOf(level.width), Integer.valueOf(level.depth), Integer.valueOf(level.height));
        this.f132a.m1a(C0003a.f31i, -1, this.f136b, Integer.valueOf(this.f140j), Integer.valueOf(this.f141k), Integer.valueOf(this.f142l), Integer.valueOf(this.f144n), Integer.valueOf(this.f143m));
        this.f133e.m36a(this, C0003a.f31i, Integer.valueOf(this.f137c), this.f136b, Integer.valueOf((level.xSpawn << 5) + 16), Integer.valueOf((level.ySpawn << 5) + 16), Integer.valueOf((level.zSpawn << 5) + 16), Integer.valueOf((int) ((level.rotSpawn * 256.0f) / 360.0f)), 0);
        this.f133e.m35a(C0003a.f37o, -1, this.f136b + " joined the game");
        for (C0026d c0026d : this.f133e.m44a()) {
            if (c0026d != null && c0026d != this && c0026d.f134f) {
                this.f132a.m1a(C0003a.f31i, Integer.valueOf(c0026d.f137c), c0026d.f136b, Integer.valueOf(c0026d.f140j), Integer.valueOf(c0026d.f141k), Integer.valueOf(c0026d.f142l), Integer.valueOf(c0026d.f144n), Integer.valueOf(c0026d.f143m));
            }
        }
        this.f135g = true;
        int i3 = 0;
        while (i3 < this.f138h.size()) {
            int i4 = i3;
            int i5 = i3 + 1;
            i3 = i5 + 1;
            m66b((C0003a) this.f138h.get(i4), (Object[]) this.f138h.get(i5));
        }
        this.f138h = null;
        this.f146p = null;
    }

    /* JADX INFO: renamed from: b */
    public final void m66b(C0003a c0003a, Object... objArr) {
        if (this.f135g) {
            this.f132a.m1a(c0003a, objArr);
        } else {
            this.f138h.add(c0003a);
            this.f138h.add(objArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m67a(Exception exc) {
        if (exc instanceof IOException) {
            f131d.info(this + " lost connection suddenly. (" + exc + ")");
        } else {
            f131d.warning(this + ":" + exc);
            f131d.log(java.util.logging.Level.WARNING, "Exception handling " + this + "!", (Throwable) exc);
        }
        this.f133e.m36a(this, C0003a.f37o, -1, this.f136b + " left the game");
        MinecraftServer.m34b(this);
    }
}
