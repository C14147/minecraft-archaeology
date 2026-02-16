package com.mojang.minecraft.p001a;

import com.mojang.minecraft.player.Player;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.e */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/a/e.class */
public final class C0007e implements Comparator {

    /* JADX INFO: renamed from: a */
    private Player f44a;

    public C0007e(Player player) {
        this.f44a = player;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((C0008f) obj).m18a(this.f44a) < ((C0008f) obj2).m18a(this.f44a) ? -1 : 1;
    }
}
