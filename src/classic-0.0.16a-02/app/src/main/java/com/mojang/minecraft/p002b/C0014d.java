package com.mojang.minecraft.p002b;

import com.mojang.minecraft.RunnableC0027d;
import com.mojang.minecraft.p001a.C0005c;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.b.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/d.class */
public class C0014d {

    /* JADX INFO: renamed from: a */
    protected RunnableC0027d f81a;

    /* JADX INFO: renamed from: b */
    protected int f82b;

    /* JADX INFO: renamed from: c */
    protected int f83c;

    /* JADX INFO: renamed from: d */
    protected List f84d = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void mo38a(int i, int i2) {
        for (int i3 = 0; i3 < this.f84d.size(); i3++) {
            C0015e c0015e = (C0015e) this.f84d.get(i3);
            if (c0015e.f92h) {
                if (c0015e.f91g) {
                    m40a(c0015e.f85a - 1, c0015e.f86b - 1, c0015e.f85a + c0015e.f87c + 1, c0015e.f86b + c0015e.f88d + 1, -16777216);
                    if (i < c0015e.f85a || i2 < c0015e.f86b || i >= c0015e.f85a + c0015e.f87c || i2 >= c0015e.f86b + c0015e.f88d) {
                        m40a(c0015e.f85a, c0015e.f86b, c0015e.f85a + c0015e.f87c, c0015e.f86b + c0015e.f88d, -9408400);
                        m42a(c0015e.f89e, c0015e.f85a + (c0015e.f87c / 2), c0015e.f86b + ((c0015e.f88d - 8) / 2), 14737632);
                    } else {
                        m40a(c0015e.f85a - 1, c0015e.f86b - 1, c0015e.f85a + c0015e.f87c + 1, c0015e.f86b + c0015e.f88d + 1, -6250336);
                        m40a(c0015e.f85a, c0015e.f86b, c0015e.f85a + c0015e.f87c, c0015e.f86b + c0015e.f88d, -8355680);
                        m42a(c0015e.f89e, c0015e.f85a + (c0015e.f87c / 2), c0015e.f86b + ((c0015e.f88d - 8) / 2), 16777120);
                    }
                } else {
                    m40a(c0015e.f85a - 1, c0015e.f86b - 1, c0015e.f85a + c0015e.f87c + 1, c0015e.f86b + c0015e.f88d + 1, -8355680);
                    m40a(c0015e.f85a, c0015e.f86b, c0015e.f85a + c0015e.f87c, c0015e.f86b + c0015e.f88d, -7303024);
                    m42a(c0015e.f89e, c0015e.f85a + (c0015e.f87c / 2), c0015e.f86b + ((c0015e.f88d - 8) / 2), -6250336);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo37a(char c, int i) {
        if (i == 1) {
            this.f81a.m57a((C0014d) null);
            this.f81a.m61c();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo36a(C0015e c0015e) {
    }

    /* JADX INFO: renamed from: a */
    public final void m39a(RunnableC0027d runnableC0027d, int i, int i2) {
        this.f81a = runnableC0027d;
        this.f82b = i;
        this.f83c = i2;
        mo33a();
    }

    /* JADX INFO: renamed from: a */
    public void mo33a() {
    }

    /* JADX INFO: renamed from: a */
    protected static void m40a(int i, int i2, int i3, int i4, int i5) {
        C0005c c0005c = C0005c.f35a;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(((i5 >> 16) & 255) / 255.0f, ((i5 >> 8) & 255) / 255.0f, (i5 & 255) / 255.0f, (i5 >>> 24) / 255.0f);
        c0005c.m7b();
        c0005c.m11b(i, i4, 0.0f);
        c0005c.m11b(i3, i4, 0.0f);
        c0005c.m11b(i3, i2, 0.0f);
        c0005c.m11b(i, i2, 0.0f);
        c0005c.m5a();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    protected static void m41a(int i, int i2, int i3, int i4, int i5, int i6) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glBegin(7);
        GL11.glColor4f(((i5 >> 16) & 255) / 255.0f, ((i5 >> 8) & 255) / 255.0f, (i5 & 255) / 255.0f, (i5 >>> 24) / 255.0f);
        GL11.glVertex2f(i3, 0.0f);
        GL11.glVertex2f(0.0f, 0.0f);
        GL11.glColor4f(((i6 >> 16) & 255) / 255.0f, ((i6 >> 8) & 255) / 255.0f, (i6 & 255) / 255.0f, (i6 >>> 24) / 255.0f);
        GL11.glVertex2f(0.0f, i4);
        GL11.glVertex2f(i3, i4);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    public final void m42a(String str, int i, int i2, int i3) {
        C0020j c0020j = this.f81a.f155i;
        c0020j.m47a(str, i - (c0020j.m50a(str) / 2), i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public final void m43b(String str, int i, int i2, int i3) {
        this.f81a.f155i.m47a(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: d */
    public final void m44d() {
        while (Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                int eventX = (Mouse.getEventX() * this.f82b) / this.f81a.f137a;
                int eventY = (this.f83c - ((Mouse.getEventY() * this.f83c) / this.f81a.f138b)) - 1;
                if (Mouse.getEventButton() == 0) {
                    for (int i = 0; i < this.f84d.size(); i++) {
                        C0015e c0015e = (C0015e) this.f84d.get(i);
                        if (eventX >= c0015e.f85a && eventY >= c0015e.f86b && eventX < c0015e.f85a + c0015e.f87c && eventY < c0015e.f86b + c0015e.f88d) {
                            mo36a(c0015e);
                        }
                    }
                }
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                mo37a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo35c() {
    }

    /* JADX INFO: renamed from: b */
    public void mo34b() {
    }
}
