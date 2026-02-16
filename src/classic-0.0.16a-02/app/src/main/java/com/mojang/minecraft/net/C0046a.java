package com.mojang.minecraft.net;

/* JADX INFO: renamed from: com.mojang.minecraft.net.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/net/a.class */
public final class C0046a {

    /* JADX INFO: renamed from: a */
    public static final C0046a[] f255a = new C0046a[256];

    /* JADX INFO: renamed from: b */
    public static final C0046a f256b = new C0046a(Byte.TYPE, String.class, String.class);

    /* JADX INFO: renamed from: c */
    public static final C0046a f257c;

    /* JADX INFO: renamed from: d */
    public static final C0046a f258d;

    /* JADX INFO: renamed from: e */
    public static final C0046a f259e;

    /* JADX INFO: renamed from: f */
    public static final C0046a f260f;

    /* JADX INFO: renamed from: g */
    public static final C0046a f261g;

    /* JADX INFO: renamed from: h */
    public static final C0046a f262h;

    /* JADX INFO: renamed from: i */
    public static final C0046a f263i;

    /* JADX INFO: renamed from: j */
    public static final C0046a f264j;

    /* JADX INFO: renamed from: k */
    public static final C0046a f265k;

    /* JADX INFO: renamed from: l */
    public static final C0046a f266l;

    /* JADX INFO: renamed from: m */
    public static final C0046a f267m;

    /* JADX INFO: renamed from: n */
    public static final C0046a f268n;

    /* JADX INFO: renamed from: o */
    public static final C0046a f269o;

    /* JADX INFO: renamed from: p */
    public final int f270p;

    /* JADX INFO: renamed from: s */
    private static int f271s;

    /* JADX INFO: renamed from: q */
    public final byte f272q;

    /* JADX INFO: renamed from: r */
    public Class[] f273r;

    private C0046a(Class... clsArr) {
        int i = f271s;
        f271s = i + 1;
        this.f272q = (byte) i;
        f255a[this.f272q] = this;
        this.f273r = new Class[clsArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            Class cls = clsArr[i3];
            this.f273r[i3] = cls;
            if (cls == Long.TYPE) {
                i2 += 8;
            } else if (cls == Integer.TYPE) {
                i2 += 4;
            } else if (cls == Short.TYPE) {
                i2 += 2;
            } else if (cls == Byte.TYPE) {
                i2++;
            } else if (cls == Float.TYPE) {
                i2 += 4;
            } else if (cls == Double.TYPE) {
                i2 += 8;
            } else if (cls == byte[].class) {
                i2 += 1024;
            }
        }
        this.f270p = i2;
    }

    static {
        new C0046a(new Class[0]);
        f257c = new C0046a(new Class[0]);
        f258d = new C0046a(Short.TYPE, byte[].class, Byte.TYPE);
        f259e = new C0046a(Short.TYPE, Short.TYPE, Short.TYPE);
        f260f = new C0046a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);
        f261g = new C0046a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE);
        f262h = new C0046a(Byte.TYPE, String.class, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);
        f263i = new C0046a(Byte.TYPE, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);
        f264j = new C0046a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);
        f265k = new C0046a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);
        f266l = new C0046a(Byte.TYPE, Byte.TYPE, Byte.TYPE);
        f267m = new C0046a(Byte.TYPE);
        f268n = new C0046a(Byte.TYPE, String.class);
        f269o = new C0046a(String.class);
        f271s = 0;
    }
}
