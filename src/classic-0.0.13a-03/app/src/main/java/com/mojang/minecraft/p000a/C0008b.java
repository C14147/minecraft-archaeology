package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0033e;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/a/b.class */
public final class C0008b implements Comparator {

    /* JADX INFO: renamed from: a */
    private C0033e f32a;

    public C0008b(C0033e c0033e) {
        this.f32a = c0033e;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0014c c0014c = (C0014c) obj;
        C0014c c0014c2 = (C0014c) obj2;
        boolean z = c0014c.f58b;
        boolean z2 = c0014c2.f58b;
        if (!z || z2) {
            return ((!z2 || z) && c0014c.m38a(this.f32a) < c0014c2.m38a(this.f32a)) ? -1 : 1;
        }
        return -1;
    }
}
