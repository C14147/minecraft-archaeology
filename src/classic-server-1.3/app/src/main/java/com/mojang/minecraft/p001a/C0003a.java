package com.mojang.minecraft.p001a;

/* JADX INFO: renamed from: com.mojang.minecraft.a.a */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/a/a.class */
public final class C0003a {

    /* JADX INFO: renamed from: q */
    public final int f39q;

    /* JADX INFO: renamed from: r */
    public final byte f41r;

    /* JADX INFO: renamed from: s */
    public Class[] f42s;

    /* JADX INFO: renamed from: a */
    public static final C0003a[] f23a = new C0003a[256];

    /* JADX INFO: renamed from: b */
    public static final C0003a f24b = new C0003a(Byte.TYPE, String.class, String.class);

    /* JADX INFO: renamed from: c */
    public static final C0003a f25c = new C0003a(new Class[0]);

    /* JADX INFO: renamed from: d */
    public static final C0003a f26d = new C0003a(new Class[0]);

    /* JADX INFO: renamed from: e */
    public static final C0003a f27e = new C0003a(Short.TYPE, byte[].class, Byte.TYPE);

    /* JADX INFO: renamed from: f */
    public static final C0003a f28f = new C0003a(Short.TYPE, Short.TYPE, Short.TYPE);

    /* JADX INFO: renamed from: g */
    public static final C0003a f29g = new C0003a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: h */
    public static final C0003a f30h = new C0003a(Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: i */
    public static final C0003a f31i = new C0003a(Byte.TYPE, String.class, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: j */
    public static final C0003a f32j = new C0003a(Byte.TYPE, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: k */
    public static final C0003a f33k = new C0003a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: l */
    public static final C0003a f34l = new C0003a(Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: m */
    public static final C0003a f35m = new C0003a(Byte.TYPE, Byte.TYPE, Byte.TYPE);

    /* JADX INFO: renamed from: n */
    public static final C0003a f36n = new C0003a(Byte.TYPE);

    /* JADX INFO: renamed from: o */
    public static final C0003a f37o = new C0003a(Byte.TYPE, String.class);

    /* JADX INFO: renamed from: p */
    public static final C0003a f38p = new C0003a(String.class);

    /* JADX INFO: renamed from: t */
    private static int f40t = 0;

    private C0003a(Class... clsArr) {
        int i = f40t;
        f40t = i + 1;
        this.f41r = (byte) i;
        f23a[this.f41r] = this;
        this.f42s = new Class[clsArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            Class cls = clsArr[i3];
            this.f42s[i3] = cls;
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
        this.f39q = i2;
    }
}
