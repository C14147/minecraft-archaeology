package com.mojang.minecraft.p001a;

import com.mojang.minecraft.player.Player;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/b.class */
public final class C0004b implements Comparator {

    /* JADX INFO: renamed from: a */
    private Player f21a;

    public C0004b(Player player) {
        this.f21a = player;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0008f c0008f = (C0008f) obj;
        C0008f c0008f2 = (C0008f) obj2;
        boolean z = c0008f.f56b;
        boolean z2 = c0008f2.f56b;
        if (!z || z2) {
            return ((!z2 || z) && c0008f.m18a(this.f21a) < c0008f2.m18a(this.f21a)) ? -1 : 1;
        }
        return -1;
    }
}
