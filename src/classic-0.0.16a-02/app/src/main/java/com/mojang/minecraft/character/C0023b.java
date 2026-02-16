package com.mojang.minecraft.character;

/* JADX INFO: renamed from: com.mojang.minecraft.character.b */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/character/b.class */
public final class C0023b {

    /* JADX INFO: renamed from: a */
    public C0026e[] f117a;

    private C0023b(C0026e[] c0026eArr) {
        this.f117a = c0026eArr;
    }

    public C0023b(C0026e[] c0026eArr, int i, int i2, int i3, int i4) {
        this(c0026eArr);
        c0026eArr[0] = c0026eArr[0].m55a(i3, i2);
        c0026eArr[1] = c0026eArr[1].m55a(i, i2);
        c0026eArr[2] = c0026eArr[2].m55a(i, i4);
        c0026eArr[3] = c0026eArr[3].m55a(i3, i4);
    }
}
