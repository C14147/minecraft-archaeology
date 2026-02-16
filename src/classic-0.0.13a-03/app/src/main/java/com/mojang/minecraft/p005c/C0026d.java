package com.mojang.minecraft.p005c;

import com.mojang.minecraft.RunnableC0022c;
import com.mojang.minecraft.p004b.C0020b;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/* JADX INFO: renamed from: com.mojang.minecraft.c.d */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c/d.class */
public class C0026d {

    /* JADX INFO: renamed from: a */
    protected RunnableC0022c f162a;

    /* JADX INFO: renamed from: b */
    protected int f163b;

    /* JADX INFO: renamed from: c */
    protected int f164c;

    /* JADX INFO: renamed from: d */
    protected List f165d = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void mo89a(int i, int i2) {
        for (int i3 = 0; i3 < this.f165d.size(); i3++) {
            C0024b c0024b = (C0024b) this.f165d.get(i3);
            if (c0024b.f161h) {
                if (c0024b.f160g) {
                    m91a(c0024b.f154a - 1, c0024b.f155b - 1, c0024b.f154a + c0024b.f156c + 1, c0024b.f155b + c0024b.f157d + 1, -16777216);
                    if (i < c0024b.f154a || i2 < c0024b.f155b || i >= c0024b.f154a + c0024b.f156c || i2 >= c0024b.f155b + c0024b.f157d) {
                        m91a(c0024b.f154a, c0024b.f155b, c0024b.f154a + c0024b.f156c, c0024b.f155b + c0024b.f157d, -9408400);
                        m93a(c0024b.f158e, c0024b.f154a + (c0024b.f156c / 2), c0024b.f155b + ((c0024b.f157d - 8) / 2), 14737632);
                    } else {
                        m91a(c0024b.f154a - 1, c0024b.f155b - 1, c0024b.f154a + c0024b.f156c + 1, c0024b.f155b + c0024b.f157d + 1, -6250336);
                        m91a(c0024b.f154a, c0024b.f155b, c0024b.f154a + c0024b.f156c, c0024b.f155b + c0024b.f157d, -8355680);
                        m93a(c0024b.f158e, c0024b.f154a + (c0024b.f156c / 2), c0024b.f155b + ((c0024b.f157d - 8) / 2), 16777120);
                    }
                } else {
                    m91a(c0024b.f154a - 1, c0024b.f155b - 1, c0024b.f154a + c0024b.f156c + 1, c0024b.f155b + c0024b.f157d + 1, -8355680);
                    m91a(c0024b.f154a, c0024b.f155b, c0024b.f154a + c0024b.f156c, c0024b.f155b + c0024b.f157d, -7303024);
                    m93a(c0024b.f158e, c0024b.f154a + (c0024b.f156c / 2), c0024b.f155b + ((c0024b.f157d - 8) / 2), -6250336);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo88a(char c, int i) {
        if (i == 1) {
            this.f162a.m68a((C0026d) null);
            this.f162a.m72b();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo87a(C0024b c0024b) {
    }

    /* JADX INFO: renamed from: a */
    public final void m90a(RunnableC0022c runnableC0022c, int i, int i2) {
        this.f162a = runnableC0022c;
        this.f163b = i;
        this.f164c = i2;
        mo84a();
    }

    /* JADX INFO: renamed from: a */
    public void mo84a() {
    }

    /* JADX INFO: renamed from: a */
    protected static void m91a(int i, int i2, int i3, int i4, int i5) {
        C0020b c0020b = C0020b.f104a;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(((i5 >> 16) & 255) / 255.0f, ((i5 >> 8) & 255) / 255.0f, (i5 & 255) / 255.0f, (i5 >>> 24) / 255.0f);
        c0020b.m58b();
        c0020b.m62a(i, i4, 0.0f);
        c0020b.m62a(i3, i4, 0.0f);
        c0020b.m62a(i3, i2, 0.0f);
        c0020b.m62a(i, i2, 0.0f);
        c0020b.m56a();
        GL11.glDisable(3042);
    }

    /* JADX INFO: renamed from: a */
    protected static void m92a(int i, int i2, int i3, int i4, int i5, int i6) {
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
    public final void m93a(String str, int i, int i2, int i3) {
        C0029g c0029g = this.f162a.f133h;
        c0029g.m98a(str, i - (c0029g.m100a(str) / 2), i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public final void m94b(String str, int i, int i2, int i3) {
        this.f162a.f133h.m98a(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: d */
    public final void m95d() {
        while (Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                int eventX = (Mouse.getEventX() * this.f163b) / this.f162a.f114a;
                int eventY = (this.f164c - ((Mouse.getEventY() * this.f164c) / this.f162a.f115b)) - 1;
                if (Mouse.getEventButton() == 0) {
                    for (int i = 0; i < this.f165d.size(); i++) {
                        C0024b c0024b = (C0024b) this.f165d.get(i);
                        if (eventX >= c0024b.f154a && eventY >= c0024b.f155b && eventX < c0024b.f154a + c0024b.f156c && eventY < c0024b.f155b + c0024b.f157d) {
                            mo87a(c0024b);
                        }
                    }
                }
            }
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                mo88a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo86c() {
    }

    /* JADX INFO: renamed from: b */
    public void mo85b() {
    }
}
