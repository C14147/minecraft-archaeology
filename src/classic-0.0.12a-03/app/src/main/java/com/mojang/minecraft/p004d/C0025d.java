package com.mojang.minecraft.p004d;

/* JADX INFO: renamed from: com.mojang.minecraft.d.d */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/d/d.class */
public final class C0025d {

    /* JADX INFO: renamed from: a */
    public C0026e[] f168a;

    private C0025d(C0026e[] c0026eArr) {
        this.f168a = c0026eArr;
    }

    public C0025d(C0026e[] c0026eArr, int i, int i2, int i3, int i4) {
        this(c0026eArr);
        c0026eArr[0] = c0026eArr[0].m74a(i3, i2);
        c0026eArr[1] = c0026eArr[1].m74a(i, i2);
        c0026eArr[2] = c0026eArr[2].m74a(i, i4);
        c0026eArr[3] = c0026eArr[3].m74a(i3, i4);
    }
}
