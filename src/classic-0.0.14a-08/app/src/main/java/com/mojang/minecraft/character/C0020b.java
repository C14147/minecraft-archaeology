package com.mojang.minecraft.character;

/* JADX INFO: renamed from: com.mojang.minecraft.character.b */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/character/b.class */
public final class C0020b {

    /* JADX INFO: renamed from: a */
    public C0023e[] f148a;

    private C0020b(C0023e[] c0023eArr) {
        this.f148a = c0023eArr;
    }

    public C0020b(C0023e[] c0023eArr, int i, int i2, int i3, int i4) {
        this(c0023eArr);
        c0023eArr[0] = c0023eArr[0].m68a(i3, i2);
        c0023eArr[1] = c0023eArr[1].m68a(i, i2);
        c0023eArr[2] = c0023eArr[2].m68a(i, i4);
        c0023eArr[3] = c0023eArr[3].m68a(i3, i4);
    }
}
