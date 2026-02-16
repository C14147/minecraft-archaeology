package com.mojang.minecraft;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;

/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/MinecraftApplet.class */
public class MinecraftApplet extends Applet {
    private Canvas canvas;
    private RunnableC0027d minecraft;
    private Thread thread = null;

    public void init() {
        this.canvas = new Canvas() { // from class: com.mojang.minecraft.MinecraftApplet.1
            public final void addNotify() {
                super.addNotify();
                MinecraftApplet.this.startGameThread();
            }

            public final void removeNotify() {
                MinecraftApplet.this.stopGameThread();
                super.removeNotify();
            }
        };
        this.minecraft = new RunnableC0027d(this.canvas, getWidth(), getHeight(), false);
        this.minecraft.f148f = getDocumentBase().getHost();
        if (getDocumentBase().getPort() > 0) {
            StringBuilder sb = new StringBuilder();
            RunnableC0027d runnableC0027d = this.minecraft;
            runnableC0027d.f148f = sb.append(runnableC0027d.f148f).append(":").append(getDocumentBase().getPort()).toString();
        }
        if (getParameter("username") != null && getParameter("sessionid") != null) {
            this.minecraft.f147e = new C0002a(getParameter("username"), getParameter("sessionid"));
        }
        if (getParameter("loadmap_user") != null && getParameter("loadmap_id") != null) {
            this.minecraft.f161j = getParameter("loadmap_user");
            this.minecraft.f162k = Integer.parseInt(getParameter("loadmap_id"));
        } else if (getParameter("server") != null && getParameter("port") != null) {
            this.minecraft.m56a(getParameter("server"), Integer.parseInt(getParameter("port")));
        }
        this.minecraft.f150g = true;
        setLayout(new BorderLayout());
        add(this.canvas, "Center");
        this.canvas.setFocusable(true);
        validate();
    }

    public void startGameThread() {
        if (this.thread != null) {
            return;
        }
        this.thread = new Thread(this.minecraft);
        this.thread.start();
    }

    public void start() {
        this.minecraft.f151h = false;
    }

    public void stop() {
        this.minecraft.f151h = true;
    }

    public void destroy() {
        stopGameThread();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.d] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.mojang.minecraft.d] */
    public void stopGameThread() {
        if (this.thread == null) {
            return;
        }
        ?? r0 = this.minecraft;
        r0.m60b();
        try {
            r0 = this.thread;
            r0.join(5000L);
        } catch (InterruptedException unused) {
            try {
                r0 = this.minecraft;
                r0.m59a();
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        this.thread = null;
    }
}
