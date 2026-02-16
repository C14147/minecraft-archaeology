package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0009c;
import com.mojang.minecraft.p000a.C0012f;
import com.mojang.minecraft.p000a.C0013g;
import com.mojang.minecraft.p000a.p001a.C0003b;
import com.mojang.minecraft.p002b.C0015a;
import com.mojang.minecraft.p002b.C0016b;
import com.mojang.minecraft.p003c.C0019a;
import com.mojang.minecraft.p004d.C0022a;
import com.mojang.minecraft.p005e.C0029a;
import java.awt.Canvas;
import java.awt.Component;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: renamed from: com.mojang.minecraft.c */
/* JADX INFO: loaded from: Classic 0.0.12a 03.jar:com/mojang/minecraft/c.class */
public final class RunnableC0018c implements Runnable {

    /* JADX INFO: renamed from: f */
    private boolean f106f;

    /* JADX INFO: renamed from: j */
    private C0013g f112j;

    /* JADX INFO: renamed from: k */
    private C0012f f113k;

    /* JADX INFO: renamed from: l */
    private C0021d f114l;

    /* JADX INFO: renamed from: n */
    private C0019a f116n;

    /* JADX INFO: renamed from: p */
    private Canvas f118p;

    /* JADX INFO: renamed from: q */
    private Cursor f121q;

    /* JADX INFO: renamed from: t */
    private C0029a f124t;

    /* JADX INFO: renamed from: g */
    private FloatBuffer f109g = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: h */
    private FloatBuffer f110h = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: i */
    private C0000a f111i = new C0000a(20.0f);

    /* JADX INFO: renamed from: m */
    private int f115m = 1;

    /* JADX INFO: renamed from: o */
    private ArrayList f117o = new ArrayList();

    /* JADX INFO: renamed from: c */
    public boolean f119c = false;

    /* JADX INFO: renamed from: d */
    public volatile boolean f120d = false;

    /* JADX INFO: renamed from: r */
    private int f122r = 1;

    /* JADX INFO: renamed from: u */
    private int f125u = 0;

    /* JADX INFO: renamed from: e */
    volatile boolean f126e = false;

    /* JADX INFO: renamed from: v */
    private String f127v = "";

    /* JADX INFO: renamed from: w */
    private boolean f128w = false;

    /* JADX INFO: renamed from: x */
    private IntBuffer f129x = BufferUtils.createIntBuffer(16);

    /* JADX INFO: renamed from: y */
    private IntBuffer f130y = BufferUtils.createIntBuffer(2000);

    /* JADX INFO: renamed from: z */
    private C0028e f131z = null;

    /* JADX INFO: renamed from: A */
    private FloatBuffer f132A = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: a */
    public int f107a = 640;

    /* JADX INFO: renamed from: b */
    public int f108b = 480;

    /* JADX INFO: renamed from: s */
    private C0015a f123s = new C0015a();

    public RunnableC0018c(Canvas canvas, int i, int i2, boolean z) {
        this.f106f = false;
        this.f118p = canvas;
        this.f106f = false;
    }

    /* JADX INFO: renamed from: a */
    private static void m58a(String str) {
        int iGlGetError = GL11.glGetError();
        if (iGlGetError != 0) {
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + str);
            System.out.println(iGlGetError + ": " + strGluErrorString);
            System.exit(0);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m59a() {
        try {
            this.f112j.m36b();
        } catch (Exception unused) {
        }
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v54, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v55, types: [org.lwjgl.LWJGLException] */
    /* JADX WARN: Type inference failed for: r0v56, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v57, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v66, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v95, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r3;
        ?? r0 = this;
        r0.f126e = true;
        try {
            this.f109g.put(new float[]{0.5f, 0.8f, 1.0f, 1.0f});
            this.f109g.flip();
            this.f110h.put(new float[]{14 / 255.0f, 11 / 255.0f, 10 / 255.0f, 1.0f});
            this.f110h.flip();
            if (this.f118p != null) {
                Display.setParent(this.f118p);
            } else if (this.f106f) {
                Display.setFullscreen(true);
                this.f107a = Display.getDisplayMode().getWidth();
                this.f108b = Display.getDisplayMode().getHeight();
            } else {
                Display.setDisplayMode(new DisplayMode(this.f107a, this.f108b));
            }
            r0 = "Minecraft 0.0.12a_03";
            Display.setTitle("Minecraft 0.0.12a_03");
            try {
                Display.create();
            } catch (LWJGLException e) {
                "Minecraft 0.0.12a_03".printStackTrace();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                Display.create();
            }
            Keyboard.create();
            Mouse.create();
            m58a("Pre startup");
            GL11.glEnable(3553);
            GL11.glShadeModel(7425);
            GL11.glClearColor(0.5f, 0.8f, 1.0f, 0.0f);
            GL11.glClearDepth(1.0d);
            GL11.glEnable(2929);
            GL11.glDepthFunc(515);
            GL11.glEnable(3008);
            GL11.glAlphaFunc(516, 0.0f);
            GL11.glCullFace(1029);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            m58a("Startup");
            this.f124t = new C0029a("/default.gif", this.f123s);
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(256);
            intBufferCreateIntBuffer.clear().limit(256);
            GL11.glViewport(0, 0, this.f107a, this.f108b);
            this.f112j = new C0013g(this, 256, 256, 64);
            this.f113k = new C0012f(this.f112j, this.f123s);
            this.f114l = new C0021d(this.f112j);
            C0013g c0013g = this.f112j;
            this.f116n = new C0019a(c0013g, this.f123s);
            int i = 0;
            ?? r32 = c0013g;
            while (i < 10) {
                C0013g c0013g2 = this.f112j;
                C0015a c0015a = this.f123s;
                C0022a c0022a = new C0022a(c0013g2, c0015a, 128.0f, 0.0f, 128.0f);
                c0022a.m79b();
                this.f117o.add(c0022a);
                i++;
                r32 = c0015a;
            }
            r0 = this.f119c;
            if (r0 != 0) {
                try {
                    r0 = this;
                    r3 = 16;
                    r32 = 16;
                    r0.f121q = new Cursor(16, 16, 0, 0, 1, intBufferCreateIntBuffer, (IntBuffer) null);
                } catch (LWJGLException e2) {
                    r0.printStackTrace();
                    r3 = r32;
                }
            } else {
                m60b();
                r3 = r32;
            }
            r0 = "Post startup";
            m58a("Post startup");
            long jCurrentTimeMillis = System.currentTimeMillis();
            ?? r02 = 0;
            int i2 = 0;
            while (true) {
                try {
                    r02 = this.f126e;
                    if (r02 == 0) {
                        return;
                    }
                    if (this.f120d) {
                        r02 = 100;
                        Thread.sleep(100L);
                    } else {
                        if (this.f118p == null && Display.isCloseRequested()) {
                            this.f126e = false;
                        }
                        C0000a c0000a = this.f111i;
                        long jNanoTime = System.nanoTime();
                        long j = jNanoTime - c0000a.f4b;
                        c0000a.f4b = jNanoTime;
                        if (j < 0) {
                            j = 0;
                        }
                        if (j > 1000000000) {
                            j = 1000000000;
                        }
                        r3 = 1315859240;
                        c0000a.f8f += ((j * c0000a.f7e) * c0000a.f3a) / 1.0E9f;
                        c0000a.f5c = (int) c0000a.f8f;
                        if (c0000a.f5c > 100) {
                            c0000a.f5c = 100;
                        }
                        c0000a.f8f -= c0000a.f5c;
                        c0000a.f6d = c0000a.f8f;
                        for (int i3 = 0; i3 < this.f111i.f5c; i3++) {
                            m62d();
                        }
                        m58a("Pre render");
                        m64b(this.f111i.f6d);
                        m58a("Post render");
                        i2++;
                        while (true) {
                            r02 = (System.currentTimeMillis() > (jCurrentTimeMillis + 1000) ? 1 : (System.currentTimeMillis() == (jCurrentTimeMillis + 1000) ? 0 : -1));
                            if (r02 >= 0) {
                                this.f127v = i2 + " fps, " + C0009c.f51c + " chunk updates";
                                C0009c.f51c = 0;
                                jCurrentTimeMillis += 1000;
                                i2 = 0;
                            }
                        }
                    }
                } catch (Exception e3) {
                    r02.printStackTrace();
                    return;
                } finally {
                    m59a();
                }
            }
        } catch (Exception e4) {
            r0.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e4.toString(), "Failed to start Minecraft", 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX INFO: renamed from: b */
    private void m60b() {
        if (this.f128w) {
            return;
        }
        this.f128w = true;
        LWJGLException lWJGLException = this.f119c;
        if (lWJGLException == 0) {
            Mouse.setGrabbed(true);
            return;
        }
        try {
            Mouse.setNativeCursor(this.f121q);
            lWJGLException = this.f107a / 2;
            Mouse.setCursorPosition((int) lWJGLException, this.f108b / 2);
        } catch (LWJGLException e) {
            lWJGLException.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.lwjgl.input.Cursor] */
    /* JADX INFO: renamed from: c */
    private void m61c() {
        if (this.f128w) {
            this.f128w = false;
            LWJGLException nativeCursor = this.f119c;
            if (nativeCursor == 0) {
                Mouse.setGrabbed(false);
                return;
            }
            try {
                nativeCursor = Mouse.setNativeCursor((Cursor) null);
            } catch (LWJGLException e) {
                nativeCursor.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0179  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m62d() {
        /*
            Method dump skipped, instruction units count: 1022
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0018c.m62d():void");
    }

    /* JADX INFO: renamed from: a */
    private void m63a(float f) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.f114l.f192o, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.f114l.f191n, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-(this.f114l.f182e + ((this.f114l.f185h - this.f114l.f182e) * f)), -(this.f114l.f183f + ((this.f114l.f186i - this.f114l.f183f) * f)), -(this.f114l.f184g + ((this.f114l.f187j - this.f114l.f184g) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0388  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m64b(float r14) {
        /*
            Method dump skipped, instruction units count: 1967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0018c.m64b(float):void");
    }

    /* JADX INFO: renamed from: a */
    private void m65a(int i) {
        C0003b c0003b = C0003b.f13a[this.f112j.m42b((int) this.f114l.f185h, (int) this.f114l.f186i, (int) this.f114l.f187j)];
        if (c0003b != null && c0003b.mo17d() == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1f);
            GL11.glFog(2918, m66a(0.02f, 0.02f, 0.2f, 1.0f));
            GL11.glLightModel(2899, m66a(0.3f, 0.3f, 0.5f, 1.0f));
        } else if (c0003b != null && c0003b.mo17d() == 2) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.2f);
            GL11.glFog(2918, m66a(0.5f, 0.3f, 0.0f, 1.0f));
            GL11.glLightModel(2899, m66a(0.4f, 0.3f, 0.3f, 1.0f));
        } else if (i == 0) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.001f);
            GL11.glFog(2918, this.f109g);
            GL11.glLightModel(2899, m66a(1.0f, 1.0f, 1.0f, 1.0f));
        } else if (i == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.01f);
            GL11.glFog(2918, this.f110h);
            GL11.glLightModel(2899, m66a(0.6f, 0.6f, 0.6f, 1.0f));
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
        GL11.glEnable(2896);
    }

    /* JADX INFO: renamed from: a */
    private FloatBuffer m66a(float f, float f2, float f3, float f4) {
        this.f132A.clear();
        this.f132A.put(f).put(f2).put(f3).put(1.0f);
        this.f132A.flip();
        return this.f132A;
    }

    /* JADX INFO: renamed from: a */
    public final void m67a(String str, String str2) {
        int i = (this.f107a * 240) / this.f108b;
        int i2 = (this.f108b * 240) / this.f108b;
        GL11.glClear(16640);
        C0016b c0016b = C0016b.f97a;
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f123s.m45a("/dirt.png", 9728));
        c0016b.m48b();
        c0016b.m53a(8421504);
        c0016b.m51a(0.0f, i2, 0.0f, 0.0f, i2 / 32.0f);
        c0016b.m51a(i, i2, 0.0f, i / 32.0f, i2 / 32.0f);
        c0016b.m51a(i, 0.0f, 0.0f, i / 32.0f, 0.0f);
        c0016b.m51a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        c0016b.m46a();
        GL11.glEnable(3553);
        this.f124t.m76a(str, (i - this.f124t.m78a(str)) / 2, ((i2 / 2) - 4) - 8, 16777215);
        this.f124t.m76a(str2, (i - this.f124t.m78a(str2)) / 2, ((i2 / 2) - 4) + 4, 16777215);
        Display.update();
        try {
            Thread.sleep(200L);
        } catch (Exception unused) {
        }
    }
}
