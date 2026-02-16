package com.mojang.minecraft.server;

import com.mojang.minecraft.C0002a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0008b;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.p000a.C0001b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.mojang.minecraft.server.d */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/d.class */
public final class C0028d {

    /* JADX INFO: renamed from: i */
    private static Logger f134i = MinecraftServer.f102a;

    /* JADX INFO: renamed from: a */
    public final C0001b f135a;

    /* JADX INFO: renamed from: j */
    private final MinecraftServer f136j;

    /* JADX INFO: renamed from: c */
    public final int f140c;

    /* JADX INFO: renamed from: d */
    public int f145d;

    /* JADX INFO: renamed from: e */
    public int f146e;

    /* JADX INFO: renamed from: f */
    public int f147f;

    /* JADX INFO: renamed from: g */
    public int f148g;

    /* JADX INFO: renamed from: h */
    public int f149h;

    /* JADX INFO: renamed from: k */
    private boolean f137k = false;

    /* JADX INFO: renamed from: l */
    private boolean f138l = false;

    /* JADX INFO: renamed from: b */
    public String f139b = "";

    /* JADX INFO: renamed from: m */
    private ArrayList f141m = new ArrayList();

    /* JADX INFO: renamed from: o */
    private List f143o = new ArrayList();

    /* JADX INFO: renamed from: p */
    private int f144p = 0;

    /* JADX INFO: renamed from: q */
    private boolean f150q = false;

    /* JADX INFO: renamed from: r */
    private int f151r = 0;

    /* JADX INFO: renamed from: s */
    private int f152s = 0;

    /* JADX INFO: renamed from: t */
    private volatile byte[] f153t = null;

    /* JADX INFO: renamed from: n */
    private long f142n = System.currentTimeMillis();

    public C0028d(MinecraftServer minecraftServer, C0001b c0001b, int i) {
        this.f136j = minecraftServer;
        this.f135a = c0001b;
        this.f140c = i;
        c0001b.f7e = this;
        Level level = minecraftServer.f110c;
        this.f145d = (level.xSpawn << 5) + 16;
        this.f146e = (level.ySpawn << 5) + 16;
        this.f147f = (level.zSpawn << 5) + 16;
        this.f149h = (int) ((level.rotSpawn * 256.0f) / 360.0f);
        this.f148g = 0;
    }

    public final String toString() {
        return !this.f137k ? this.f135a.f10f : this.f139b + " (" + this.f135a.f10f + ")";
    }

    /* JADX INFO: renamed from: a */
    public final void m62a(C0003a c0003a, Object[] objArr) {
        if (this.f150q) {
            return;
        }
        if (c0003a != C0003a.f24b) {
            if (c0003a != C0003a.f25c && this.f137k && this.f138l) {
                if (c0003a == C0003a.f29g) {
                    if (this.f143o.size() > 400) {
                        m65d("Too much lag");
                        return;
                    } else {
                        this.f143o.add(objArr);
                        return;
                    }
                }
                if (c0003a == C0003a.f37o) {
                    String strTrim = objArr[1].toString().trim();
                    if (strTrim.length() > 0) {
                        m63c(strTrim);
                        return;
                    }
                    return;
                }
                if (c0003a == C0003a.f32j) {
                    if (this.f143o.size() > 400) {
                        m65d("Too much lag");
                        return;
                    } else {
                        this.f143o.add(objArr);
                        return;
                    }
                }
                return;
            }
            return;
        }
        byte bByteValue = ((Byte) objArr[0]).byteValue();
        String strTrim2 = ((String) objArr[1]).trim();
        String str = (String) objArr[2];
        char[] charArray = strTrim2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < ' ' || charArray[i] > 127) {
                m65d("Bad name!");
                return;
            }
        }
        if (this.f136j.f124j && !str.equals(this.f136j.f123i.m71a(strTrim2))) {
            m64a("Illegal name.");
            return;
        }
        C0028d c0028dM53c = this.f136j.m53c(strTrim2);
        if (c0028dM53c != null) {
            c0028dM53c.m64a("You logged in from another computer.");
        }
        f134i.info(this + " logged in as " + strTrim2);
        if (bByteValue != 5) {
            m64a("Wrong protocol version.");
            return;
        }
        if (this.f136j.f117g.m59c(strTrim2)) {
            m64a("You're banned!");
            return;
        }
        this.f137k = true;
        this.f139b = strTrim2;
        this.f135a.m1a(C0003a.f24b, (byte) 5, this.f136j.f112d, this.f136j.f113e);
        new C0025a(this, this.f136j.f110c.copyBlocks()).start();
        this.f136j.f119h.m57a(strTrim2);
    }

    /* JADX INFO: renamed from: c */
    private void m63c(String str) {
        String strTrim = str.trim();
        this.f144p += (strTrim.length() + 15) << 2;
        if (this.f144p > 600) {
            this.f144p = 760;
            m69b(C0003a.f37o, -1, "Too much chatter! Muted for eight seconds.");
            f134i.info("Muting " + this.f139b + " for chatting too much");
            return;
        }
        char[] charArray = strTrim.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < ' ' || charArray[i] > 127) {
                m65d("Bad chat message!");
                return;
            }
        }
        if (!strTrim.startsWith("/")) {
            f134i.info(this.f139b + " says: " + strTrim);
            this.f136j.m37a(C0003a.f37o, Integer.valueOf(this.f140c), this.f139b + ": " + strTrim);
        } else if (this.f136j.f116f.m59c(this.f139b)) {
            this.f136j.m44a(this, strTrim.substring(1));
        } else {
            m69b(C0003a.f37o, -1, "You're not a server admin!");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m64a(String str) {
        this.f135a.m1a(C0003a.f38p, str);
        f134i.info("Kicking " + this + ": " + str);
        this.f136j.m35a(this);
        this.f150q = true;
    }

    /* JADX INFO: renamed from: d */
    private void m65d(String str) {
        m64a("Cheat detected: " + str);
    }

    /* JADX INFO: renamed from: b */
    public final void m66b(String str) {
        m69b(C0003a.f37o, -1, str);
    }

    /* JADX INFO: renamed from: a */
    public final void m67a(byte[] bArr) {
        this.f153t = bArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m68a() {
        if (this.f151r >= 2) {
            this.f151r -= 2;
        }
        if (this.f144p > 0) {
            this.f144p--;
            if (this.f144p == 600) {
                m69b(C0003a.f37o, -1, "You can now talk again.");
                this.f144p = 300;
            }
        }
        if (this.f143o.size() > 0) {
            boolean z = true;
            while (true) {
                boolean z2 = z;
                if (this.f143o.size() <= 0 || !z2) {
                    break;
                }
                Object[] objArr = (Object[]) this.f143o.remove(0);
                if (objArr[0] instanceof Short) {
                    short sShortValue = ((Short) objArr[0]).shortValue();
                    short sShortValue2 = ((Short) objArr[1]).shortValue();
                    short sShortValue3 = ((Short) objArr[2]).shortValue();
                    byte bByteValue = ((Byte) objArr[3]).byteValue();
                    byte bByteValue2 = ((Byte) objArr[4]).byteValue();
                    this.f151r++;
                    if (this.f151r == 100) {
                        m65d("Too much clicking!");
                    } else {
                        Level level = this.f136j.f110c;
                        float f = sShortValue - (this.f145d / 32.0f);
                        float f2 = sShortValue2 - ((this.f146e / 32.0f) - 1.62f);
                        float f3 = sShortValue3 - (this.f147f / 32.0f);
                        float f4 = (f * f) + (f2 * f2) + (f3 * f3);
                        if (f4 >= 8.0f * 8.0f) {
                            System.out.println("Distance: " + Math.sqrt(f4));
                            m65d("Distance");
                        } else {
                            boolean z3 = false;
                            for (int i = 0; i < C0002a.f22a.length && !z3; i++) {
                                if (C0002a.f22a[i] == bByteValue2) {
                                    z3 = true;
                                }
                            }
                            if (!z3) {
                                m65d("Tile type");
                            } else if (sShortValue >= 0 && sShortValue2 >= 0 && sShortValue3 >= 0 && sShortValue < level.width && sShortValue2 < level.depth && sShortValue3 < level.height) {
                                if (bByteValue == 0) {
                                    level.setTile(sShortValue, sShortValue2, sShortValue3, 0);
                                } else {
                                    C0008b c0008b = C0008b.f49a[level.getTile(sShortValue, sShortValue2, sShortValue3)];
                                    if (c0008b == null || c0008b == C0008b.f58i || c0008b == C0008b.f59j || c0008b == C0008b.f60k || c0008b == C0008b.f61l) {
                                        level.setTile(sShortValue, sShortValue2, sShortValue3, bByteValue2);
                                        C0008b.f49a[bByteValue2].mo16a(level, sShortValue, sShortValue2, sShortValue3);
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                } else {
                    ((Byte) objArr[0]).byteValue();
                    short sShortValue4 = ((Short) objArr[1]).shortValue();
                    short sShortValue5 = ((Short) objArr[2]).shortValue();
                    short sShortValue6 = ((Short) objArr[3]).shortValue();
                    byte bByteValue3 = ((Byte) objArr[4]).byteValue();
                    byte bByteValue4 = ((Byte) objArr[5]).byteValue();
                    if (sShortValue4 == this.f145d && sShortValue5 == this.f146e && sShortValue6 == this.f147f && bByteValue3 == this.f149h && bByteValue4 == this.f148g) {
                        z = true;
                    } else {
                        boolean z4 = sShortValue4 == this.f145d && sShortValue5 == this.f146e && sShortValue6 == this.f147f;
                        int i2 = this.f152s;
                        this.f152s = i2 + 1;
                        if (i2 % 2 == 0) {
                            int i3 = sShortValue4 - this.f145d;
                            int i4 = sShortValue5 - this.f146e;
                            int i5 = sShortValue6 - this.f147f;
                            if (i3 >= 128 || i3 < -128 || i4 >= 128 || i4 < -128 || i5 >= 128 || i5 < -128 || this.f152s % 20 <= 1) {
                                this.f145d = sShortValue4;
                                this.f146e = sShortValue5;
                                this.f147f = sShortValue6;
                                this.f149h = bByteValue3;
                                this.f148g = bByteValue4;
                                this.f136j.m38a(this, C0003a.f32j, Integer.valueOf(this.f140c), Short.valueOf(sShortValue4), Short.valueOf(sShortValue5), Short.valueOf(sShortValue6), Byte.valueOf(bByteValue3), Byte.valueOf(bByteValue4));
                                z = false;
                            } else {
                                if (sShortValue4 == this.f145d && sShortValue5 == this.f146e && sShortValue6 == this.f147f) {
                                    this.f149h = bByteValue3;
                                    this.f148g = bByteValue4;
                                    this.f136j.m38a(this, C0003a.f35m, Integer.valueOf(this.f140c), Byte.valueOf(bByteValue3), Byte.valueOf(bByteValue4));
                                } else if (bByteValue3 == this.f149h && bByteValue4 == this.f148g) {
                                    this.f145d = sShortValue4;
                                    this.f146e = sShortValue5;
                                    this.f147f = sShortValue6;
                                    this.f136j.m38a(this, C0003a.f34l, Integer.valueOf(this.f140c), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                                } else {
                                    this.f145d = sShortValue4;
                                    this.f146e = sShortValue5;
                                    this.f147f = sShortValue6;
                                    this.f149h = bByteValue3;
                                    this.f148g = bByteValue4;
                                    this.f136j.m38a(this, C0003a.f33k, Integer.valueOf(this.f140c), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Byte.valueOf(bByteValue3), Byte.valueOf(bByteValue4));
                                }
                                z = z4;
                            }
                        } else {
                            z = z4;
                        }
                    }
                }
            }
        }
        if (!this.f137k && System.currentTimeMillis() - this.f142n > 5000) {
            m64a("You need to log in!");
            return;
        }
        if (this.f153t == null) {
            return;
        }
        Level level2 = this.f136j.f110c;
        byte[] bArr = new byte[1024];
        int i6 = 0;
        int length = this.f153t.length;
        this.f135a.m1a(C0003a.f26d, new Object[0]);
        while (length > 0) {
            int i7 = length;
            int length2 = i7;
            if (i7 > bArr.length) {
                length2 = bArr.length;
            }
            System.arraycopy(this.f153t, i6, bArr, 0, length2);
            this.f135a.m1a(C0003a.f27e, Integer.valueOf(length2), bArr, Integer.valueOf(((i6 + length2) * 100) / this.f153t.length));
            length -= length2;
            i6 += length2;
        }
        this.f135a.m1a(C0003a.f28f, Integer.valueOf(level2.width), Integer.valueOf(level2.depth), Integer.valueOf(level2.height));
        this.f135a.m1a(C0003a.f31i, -1, this.f139b, Integer.valueOf(this.f145d), Integer.valueOf(this.f146e), Integer.valueOf(this.f147f), Integer.valueOf(this.f149h), Integer.valueOf(this.f148g));
        this.f136j.m38a(this, C0003a.f31i, Integer.valueOf(this.f140c), this.f139b, Integer.valueOf((level2.xSpawn << 5) + 16), Integer.valueOf((level2.ySpawn << 5) + 16), Integer.valueOf((level2.zSpawn << 5) + 16), Integer.valueOf((int) ((level2.rotSpawn * 256.0f) / 360.0f)), 0);
        this.f136j.m37a(C0003a.f37o, -1, this.f139b + " joined the game");
        for (C0028d c0028d : this.f136j.m47a()) {
            if (c0028d != null && c0028d != this && c0028d.f137k) {
                this.f135a.m1a(C0003a.f31i, Integer.valueOf(c0028d.f140c), c0028d.f139b, Integer.valueOf(c0028d.f145d), Integer.valueOf(c0028d.f146e), Integer.valueOf(c0028d.f147f), Integer.valueOf(c0028d.f149h), Integer.valueOf(c0028d.f148g));
            }
        }
        this.f138l = true;
        int i8 = 0;
        while (i8 < this.f141m.size()) {
            int i9 = i8;
            int i10 = i8 + 1;
            i8 = i10 + 1;
            m69b((C0003a) this.f141m.get(i9), (Object[]) this.f141m.get(i10));
        }
        this.f141m = null;
        this.f153t = null;
    }

    /* JADX INFO: renamed from: b */
    public final void m69b(C0003a c0003a, Object... objArr) {
        if (this.f138l) {
            this.f135a.m1a(c0003a, objArr);
        } else {
            this.f141m.add(c0003a);
            this.f141m.add(objArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m70a(Exception exc) {
        if (exc instanceof IOException) {
            f134i.info(this + " lost connection suddenly. (" + exc + ")");
        } else {
            f134i.warning(this + ":" + exc);
            f134i.log(java.util.logging.Level.WARNING, "Exception handling " + this + "!", (Throwable) exc);
            exc.printStackTrace();
        }
        this.f136j.m38a(this, C0003a.f37o, -1, this.f139b + " left the game");
        MinecraftServer.m36b(this);
    }
}
