package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0021d;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.e */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/e.class */
public final class C0011e implements Comparator {

    /* JADX INFO: renamed from: a */
    private C0021d f58a;

    public C0011e(C0021d c0021d) {
        this.f58a = c0021d;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((C0009c) obj).m26a(this.f58a) < ((C0009c) obj2).m26a(this.f58a) ? -1 : 1;
    }
}
