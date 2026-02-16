package com.mojang.minecraft.p001b;

import com.mojang.minecraft.RunnableC0018c;
import com.mojang.minecraft.p000a.C0004c;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.c */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/c.class */
public class C0012c {

    /* JADX INFO: renamed from: a */
    protected RunnableC0018c f75a;

    /* JADX INFO: renamed from: b */
    protected int f76b;

    /* JADX INFO: renamed from: c */
    protected int f77c;

    /* JADX INFO: renamed from: d */
    protected List f78d = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void mo34a(int i, int i2) {
        for (int i3 = 0; i3 < this.f78d.size(); i3++) {
            C0013d c0013d = (C0013d) this.f78d.get(i3);
            if (c0013d.f86h) {
                if (c0013d.f85g) {
                    m36a(c0013d.f79a - 1, c0013d.f80b - 1, c0013d.f79a + c0013d.f81c + 1, c0013d.f80b + c0013d.f82d + 1, -16777216);
                    if (i < c0013d.f79a || i2 < c0013d.f80b || i >= c0013d.f79a + c0013d.f81c || i2 >= c0013d.f80b + c0013d.f82d) {
                        m36a(c0013d.f79a, c0013d.f80b, c0013d.f79a + c0013d.f81c, c0013d.f80b + c0013d.f82d, -9408400);
                        m38a(c0013d.f83e, c0013d.f79a + (c0013d.f81c / 2), c0013d.f80b + ((c0013d.f82d - 8) / 2), 14737632);
                    } else {
                        m36a(c0013d.f79a - 1, c0013d.f80b - 1, c0013d.f79a + c0013d.f81c + 1, c0013d.f80b + c0013d.f82d + 1, -6250336);
                        m36a(c0013d.f79a, c0013d.f80b, c0013d.f79a + c0013d.f81c, c0013d.f80b + c0013d.f82d, -8355680);
                        m38a(c0013d.f83e, c0013d.f79a + (c0013d.f81c / 2), c0013d.f80b + ((c0013d.f82d - 8) / 2), 16777120);
                    }
                } else {
                    m36a(c0013d.f79a - 1, c0013d.f80b - 1, c0013d.f79a + c0013d.f81c + 1, c0013d.f80b + c0013d.f82d + 1, -8355680);
                    m36a(c0013d.f79a, c0013d.f80b, c0013d.f79a + c0013d.f81c, c0013d.f80b + c0013d.f82d, -7303024);
                    m38a(c0013d.f83e, c0013d.f79a + (c0013d.f81c / 2), c0013d.f80b + ((c0013d.f82d - 8) / 2), -6250336);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo33a(char c, int i) {
        if (i == 1) {
            this.f75a.m46a((C0012c) null);
            this.f75a.m50c();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo32a(C0013d c0013d) {
    }

    /* JADX INFO: renamed from: a */
    public final void m35a(RunnableC0018c runnableC0018c, int i, int i2) {
        this.f75a = runnableC0018c;
        this.f76b = i;
        this.f77c = i2;
        mo29a();
    }

    /* JADX INFO: renamed from: a */
    public void mo29a() {
    }

    /* JADX INFO: renamed from: a */
    protected static void m36a(int i, int i2, int i3, int i4, int i5) {
        C0004c c0004c = C0004c.f27a;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(((i5 >> 16) & 255) / 255.0f, ((i5 >> 8) & 255) / 255.0f, (i5 & 255) / 255.0f, (i5 >>> 24) / 255.0f);
        c0004c.m3b();
        c0004c.m7b(i, i4, 0.0f);
        c0004c.m7b(i3, i4, 0.0f);
        c0004c.m7b(i3, i2, 0.0f);
        c0004c.m7b(i, i2, 0.0f);
        c0004c.m1a();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    protected static void m37a(int i, int i2, int i3, int i4, int i5, int i6) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glBegin(7);
        GL11.glColor4f(5 / 255.0f, 5 / 255.0f, 0.0f, 96 / 255.0f);
        GL11.glVertex2f(i3, 0.0f);
        GL11.glVertex2f(0.0f, 0.0f);
        GL11.glColor4f(48 / 255.0f, 48 / 255.0f, 96 / 255.0f, 160 / 255.0f);
        GL11.glVertex2f(0.0f, i4);
        GL11.glVertex2f(i3, i4);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    public final void m38a(String str, int i, int i2, int i3) {
        C0017h c0017h = this.f75a.f115g;
        c0017h.m43a(str, i - (c0017h.m45a(str) / 2), i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public final void m39b(String str, int i, int i2, int i3) {
        this.f75a.f115g.m43a(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: d */
    public final void m40d() {
        while (Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                int eventX = (Mouse.getEventX() * this.f76b) / this.f75a.f97a;
                int eventY = (this.f77c - ((Mouse.getEventY() * this.f77c) / this.f75a.f98b)) - 1;
                if (Mouse.getEventButton() == 0) {
                    for (int i = 0; i < this.f78d.size(); i++) {
                        C0013d c0013d = (C0013d) this.f78d.get(i);
                        if (eventX >= c0013d.f79a && eventY >= c0013d.f80b && eventX < c0013d.f79a + c0013d.f81c && eventY < c0013d.f80b + c0013d.f82d) {
                            mo32a(c0013d);
                        }
                    }
                }
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                mo33a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo31c() {
    }

    /* JADX INFO: renamed from: b */
    public void mo30b() {
    }
}
