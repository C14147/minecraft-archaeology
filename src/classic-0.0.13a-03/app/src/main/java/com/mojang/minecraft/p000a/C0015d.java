package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0033e;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.d */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/d.class */
public final class C0015d implements Comparator {

    /* JADX INFO: renamed from: a */
    private C0033e f63a;

    public C0015d(C0033e c0033e) {
        this.f63a = c0033e;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((C0014c) obj).m38a(this.f63a) < ((C0014c) obj2).m38a(this.f63a) ? -1 : 1;
    }
}
