package com.mojang.minecraft;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;

/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/MinecraftApplet.class */
public class MinecraftApplet extends Applet {

    /* JADX INFO: renamed from: c */
    private Canvas f0c;

    /* JADX INFO: renamed from: a */
    RunnableC0022c f1a;

    /* JADX INFO: renamed from: b */
    Thread f2b = null;

    public void init() {
        this.f0c = new C0018b(this);
        this.f1a = new RunnableC0022c(this.f0c, getWidth(), getHeight(), false);
        this.f1a.f125e = getDocumentBase().getHost() + ":" + getDocumentBase().getPort();
        if (getParameter("username") != null && getParameter("sessionid") != null) {
            this.f1a.f124d = new C0030d(getParameter("username"), getParameter("sessionid"));
        }
        if (getParameter("loadmap_user") != null && getParameter("loadmap_id") != null) {
            this.f1a.f138j = getParameter("loadmap_user");
            this.f1a.f139k = Integer.parseInt(getParameter("loadmap_id"));
        }
        this.f1a.f128f = true;
        setLayout(new BorderLayout());
        add(this.f0c, "Center");
        this.f0c.setFocusable(true);
        validate();
    }

    public void start() {
        this.f1a.f129g = false;
    }

    public void stop() {
        this.f1a.f129g = true;
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
        r0.f140l = false;
        try {
            r0 = this.f2b;
            r0.join(5000L);
        } catch (InterruptedException unused) {
            try {
                r0 = this.f1a;
                r0.m71a();
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        this.f2b = null;
    }
}
