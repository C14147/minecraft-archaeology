package com.mojang.minecraft;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;

/* JADX INFO: loaded from: Classic 0.0.11a.jar:com/mojang/minecraft/MinecraftApplet.class */
public class MinecraftApplet extends Applet {
    private Canvas canvas;
    private Minecraft minecraft;
    private Thread thread = null;

    public void init() {
        this.canvas = new Canvas() { // from class: com.mojang.minecraft.MinecraftApplet.1
            public void addNotify() {
                super.addNotify();
                MinecraftApplet.this.startGameThread();
            }

            public void removeNotify() {
                MinecraftApplet.this.stopGameThread();
                super.removeNotify();
            }
        };
        this.minecraft = new Minecraft(this.canvas, 640, 480, false);
        this.minecraft.appletMode = true;
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
        this.minecraft.pause = false;
    }

    public void stop() {
        this.minecraft.pause = true;
    }

    public void destroy() {
        stopGameThread();
    }

    public void stopGameThread() {
        if (this.thread == null) {
            return;
        }
        this.minecraft.stop();
        try {
            this.thread.join(5000L);
        } catch (InterruptedException e) {
            try {
                this.minecraft.destroy();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        this.thread = null;
    }
}
