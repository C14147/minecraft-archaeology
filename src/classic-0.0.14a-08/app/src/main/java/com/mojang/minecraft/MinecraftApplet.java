package com.mojang.minecraft;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;

/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/MinecraftApplet.class */
public class MinecraftApplet extends Applet {
    private Canvas canvas;
    private RunnableC0018c minecraft;
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
        this.minecraft = new RunnableC0018c(this.canvas, getWidth(), getHeight(), false);
        this.minecraft.f108d = getDocumentBase().getHost() + ":" + getDocumentBase().getPort();
        if (getParameter("username") != null && getParameter("sessionid") != null) {
            this.minecraft.f107c = new C0001a(getParameter("username"), getParameter("sessionid"));
        }
        if (getParameter("loadmap_user") != null && getParameter("loadmap_id") != null) {
            this.minecraft.f121h = getParameter("loadmap_user");
            this.minecraft.f122i = Integer.parseInt(getParameter("loadmap_id"));
        }
        this.minecraft.f110e = true;
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
        this.minecraft.f111f = false;
    }

    public void stop() {
        this.minecraft.f111f = true;
    }

    public void destroy() {
        stopGameThread();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.mojang.minecraft.c] */
    public void stopGameThread() {
        if (this.thread == null) {
            return;
        }
        ?? r0 = this.minecraft;
        r0.m49b();
        try {
            r0 = this.thread;
            r0.join(5000L);
        } catch (InterruptedException unused) {
            try {
                r0 = this.minecraft;
                r0.m48a();
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        this.thread = null;
    }
}
