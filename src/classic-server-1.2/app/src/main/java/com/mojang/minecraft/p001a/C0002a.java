package com.mojang.minecraft.p001a;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/a/a.class */
public final class C0002a {

    /* JADX INFO: renamed from: q */
    public final int f38q;

    /* JADX INFO: renamed from: r */
    public final byte f40r;

    /* JADX INFO: renamed from: s */
    public Class[] f41s;

    /* JADX INFO: renamed from: a */
    public static final C0002a[] f22a = new C0002a[256];

    /* JADX INFO: renamed from: b */
    public static final C0002a f23b = new C0002a(Byte.TYPE, String.class, String.class);

    /* JADX INFO: renamed from: c */
    public static final C0002a f24c = new C0002a(new Class[0]);

    /* JADX INFO: renamed from: d */
    public static final C0002a f25d = new C0002a(new Class[0]);

    /* JADX INFO: renamed from: e */
    public static final C0002a f26e = new C0002a(Short.TYPE, byte[].class, Byte.TYPE);

    /* JADX INFO: renamed from: f */
    public static final C0002a f27f = new C0002a(Short.TYPE, Short.TYPE, Short.TYPE);

    /* JADX INFO: renamed from: g */
    public static final C0002a f28g = new C0002a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: h */
    public static final C0002a f29h = new C0002a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: i */
    public static final C0002a f30i = new C0002a(Byte.TYPE, String.class, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: j */
    public static final C0002a f31j = new C0002a(Byte.TYPE, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: k */
    public static final C0002a f32k = new C0002a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: l */
    public static final C0002a f33l = new C0002a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: m */
    public static final C0002a f34m = new C0002a(Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: n */
    public static final C0002a f35n = new C0002a(Byte.TYPE);

    /* JADX INFO: renamed from: o */
    public static final C0002a f36o = new C0002a(Byte.TYPE, String.class);

    /* JADX INFO: renamed from: p */
    public static final C0002a f37p = new C0002a(String.class);

    /* JADX INFO: renamed from: t */
    private static int f39t = 0;

    private C0002a(Class... clsArr) {
        int i = f39t;
        f39t = i + 1;
        this.f40r = (byte) i;
        f22a[this.f40r] = this;
        this.f41s = new Class[clsArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            Class cls = clsArr[i3];
            this.f41s[i3] = cls;
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
        this.f38q = i2;
    }
}
