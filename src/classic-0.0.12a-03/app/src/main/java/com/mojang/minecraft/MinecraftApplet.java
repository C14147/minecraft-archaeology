package com.mojang.minecraft;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;

/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/MinecraftApplet.class */
public class MinecraftApplet extends Applet {

    /* JADX INFO: renamed from: c */
    private Canvas f0c;

    /* JADX INFO: renamed from: a */
    RunnableC0018c f1a;

    /* JADX INFO: renamed from: b */
    Thread f2b = null;

    public void init() {
        this.f0c = new C0014b(this);
        this.f1a = new RunnableC0018c(this.f0c, 640, 480, false);
        this.f1a.f119c = true;
        setLayout(new BorderLayout());
        add(this.f0c, "Center");
        this.f0c.setFocusable(true);
        validate();
    }

    public void start() {
        this.f1a.f120d = false;
    }

    public void stop() {
        this.f1a.f120d = true;
    }

    public void destroy() {
        m0a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.mojang.minecraft.c] */
    /* JADX INFO: renamed from: a */
    public final void m0a() {
        if (this.f2b == null) {
            return;
        }
        ?? r0 = this.f1a;
        r0.f126e = false;
        try {
            r0 = this.f2b;
            r0.join(5000L);
        } catch (InterruptedException unused) {
            try {
                r0 = this.f1a;
                r0.m59a();
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        this.f2b = null;
    }
}
