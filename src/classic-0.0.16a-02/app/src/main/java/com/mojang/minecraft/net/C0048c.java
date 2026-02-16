package com.mojang.minecraft.net;

import com.mojang.minecraft.RunnableC0027d;
import com.mojang.p000a.C0000a;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

/* JADX INFO: renamed from: com.mojang.minecraft.net.c */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/net/c.class */
public final class C0048c {

    /* JADX INFO: renamed from: a */
    public ByteArrayOutputStream f281a;

    /* JADX INFO: renamed from: b */
    public C0000a f282b;

    /* JADX INFO: renamed from: c */
    public RunnableC0027d f283c;

    /* JADX INFO: renamed from: d */
    public HashMap f284d = new HashMap();

    public C0048c(RunnableC0027d runnableC0027d, String str, int i, String str2) {
        this.f282b = new C0000a(str, i);
        this.f282b.f4e = this;
        this.f282b.m2a(C0046a.f256b, (byte) 3, str2, "--");
        this.f283c = runnableC0027d;
        runnableC0027d.m72a("Connecting..");
        runnableC0027d.f186m = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m126a(int i, int i2, int i3, int i4, int i5) {
        this.f282b.m2a(C0046a.f260f, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }
}
