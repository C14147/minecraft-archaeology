package com.mojang.minecraft.p000a;

import com.mojang.minecraft.player.Player;
import java.util.Comparator;

/* JADX INFO: renamed from: com.mojang.minecraft.a.e */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/a/e.class */
public final class C0006e implements Comparator {

    /* JADX INFO: renamed from: a */
    private Player f36a;

    public C0006e(Player player) {
        this.f36a = player;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((C0007f) obj).m14a(this.f36a) < ((C0007f) obj2).m14a(this.f36a) ? -1 : 1;
    }
}
