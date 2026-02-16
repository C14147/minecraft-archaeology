package com.mojang.minecraft.p000a;

import com.mojang.minecraft.player.Player;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.b */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/b.class */
public final class C0003b implements Comparator {

    /* JADX INFO: renamed from: a */
    private Player f13a;

    public C0003b(Player player) {
        this.f13a = player;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0007f c0007f = (C0007f) obj;
        C0007f c0007f2 = (C0007f) obj2;
        boolean z = c0007f.f48b;
        boolean z2 = c0007f2.f48b;
        if (!z || z2) {
            return ((!z2 || z) && c0007f.m14a(this.f13a) < c0007f2.m14a(this.f13a)) ? -1 : 1;
        }
        return -1;
    }
}
