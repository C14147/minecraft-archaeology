package com.mojang.minecraft.p007e;

/* JADX INFO: renamed from: com.mojang.minecraft.e.d */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/e/d.class */
public final class C0037d {

    /* JADX INFO: renamed from: a */
    public C0038e[] f212a;

    private C0037d(C0038e[] c0038eArr) {
        this.f212a = c0038eArr;
    }

    public C0037d(C0038e[] c0038eArr, int i, int i2, int i3, int i4) {
        this(c0038eArr);
        c0038eArr[0] = c0038eArr[0].m107a(i3, i2);
        c0038eArr[1] = c0038eArr[1].m107a(i, i2);
        c0038eArr[2] = c0038eArr[2].m107a(i, i4);
        c0038eArr[3] = c0038eArr[3].m107a(i3, i4);
    }
}
