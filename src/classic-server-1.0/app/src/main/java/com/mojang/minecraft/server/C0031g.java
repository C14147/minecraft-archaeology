package com.mojang.minecraft.server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: renamed from: com.mojang.minecraft.server.g */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/minecraft/server/g.class */
public final class C0031g {

    /* JADX INFO: renamed from: a */
    private String f154a;

    public C0031g(String str) {
        this.f154a = str;
    }

    /* JADX INFO: renamed from: a */
    public final String m71a(String str) {
        try {
            String str2 = this.f154a + str;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str2.getBytes(), 0, str2.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
