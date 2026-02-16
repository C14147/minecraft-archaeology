package com.mojang.minecraft.p000a;

import com.mojang.minecraft.C0021d;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/a/b.class */
public final class C0008b implements Comparator {

    /* JADX INFO: renamed from: a */
    private C0021d f35a;

    public C0008b(C0021d c0021d) {
        this.f35a = c0021d;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0009c c0009c = (C0009c) obj;
        C0009c c0009c2 = (C0009c) obj2;
        boolean z = c0009c.f49b;
        boolean z2 = c0009c2.f49b;
        if (!z || z2) {
            return ((!z2 || z) && c0009c.m26a(this.f35a) < c0009c2.m26a(this.f35a)) ? -1 : 1;
        }
        return -1;
    }
}
