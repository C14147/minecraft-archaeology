package com.mojang.minecraft;

import com.mojang.minecraft.p000a.C0001a;
import com.mojang.minecraft.p000a.C0014c;
import com.mojang.minecraft.p000a.C0016e;
import com.mojang.minecraft.p000a.C0017f;
import com.mojang.minecraft.p000a.p001a.C0002a;
import com.mojang.minecraft.p000a.p002b.C0009a;
import com.mojang.minecraft.p004b.C0019a;
import com.mojang.minecraft.p004b.C0020b;
import com.mojang.minecraft.p005c.C0025c;
import com.mojang.minecraft.p005c.C0026d;
import com.mojang.minecraft.p005c.C0029g;
import com.mojang.minecraft.p006d.C0031a;
import java.awt.Canvas;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c.class */
public final class RunnableC0022c implements Runnable {

    /* JADX INFO: renamed from: m */
    private boolean f113m;

    /* JADX INFO: renamed from: a */
    public int f114a;

    /* JADX INFO: renamed from: b */
    public int f115b;

    /* JADX INFO: renamed from: c */
    public C0017f f119c;

    /* JADX INFO: renamed from: q */
    private C0016e f120q;

    /* JADX INFO: renamed from: r */
    private C0033e f121r;

    /* JADX INFO: renamed from: t */
    private C0031a f123t;

    /* JADX INFO: renamed from: e */
    public String f125e;

    /* JADX INFO: renamed from: v */
    private Canvas f127v;

    /* JADX INFO: renamed from: w */
    private Cursor f130w;

    /* JADX INFO: renamed from: h */
    public C0029g f133h;

    /* JADX INFO: renamed from: n */
    private FloatBuffer f116n = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: o */
    private FloatBuffer f117o = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: p */
    private C0000a f118p = new C0000a(20.0f);

    /* JADX INFO: renamed from: s */
    private int f122s = 1;

    /* JADX INFO: renamed from: d */
    public C0030d f124d = null;

    /* JADX INFO: renamed from: u */
    private ArrayList f126u = new ArrayList();

    /* JADX INFO: renamed from: f */
    public boolean f128f = false;

    /* JADX INFO: renamed from: g */
    public volatile boolean f129g = false;

    /* JADX INFO: renamed from: x */
    private int f131x = 1;

    /* JADX INFO: renamed from: z */
    private int f134z = 0;

    /* JADX INFO: renamed from: A */
    private C0026d f135A = null;

    /* JADX INFO: renamed from: i */
    public C0001a f136i = new C0001a(this);

    /* JADX INFO: renamed from: B */
    private C0009a f137B = new C0009a(this);

    /* JADX INFO: renamed from: j */
    public String f138j = null;

    /* JADX INFO: renamed from: k */
    public int f139k = 0;

    /* JADX INFO: renamed from: l */
    volatile boolean f140l = false;

    /* JADX INFO: renamed from: C */
    private String f141C = "";

    /* JADX INFO: renamed from: D */
    private boolean f142D = false;

    /* JADX INFO: renamed from: E */
    private IntBuffer f143E = BufferUtils.createIntBuffer(16);

    /* JADX INFO: renamed from: F */
    private IntBuffer f144F = BufferUtils.createIntBuffer(2000);

    /* JADX INFO: renamed from: G */
    private C0040f f145G = null;

    /* JADX INFO: renamed from: H */
    private FloatBuffer f146H = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: I */
    private String f147I = "";

    /* JADX INFO: renamed from: J */
    private String f148J = "";

    /* JADX INFO: renamed from: y */
    private C0019a f132y = new C0019a();

    public RunnableC0022c(Canvas canvas, int i, int i2, boolean z) {
        this.f113m = false;
        this.f127v = canvas;
        this.f114a = i;
        this.f115b = i2;
        this.f113m = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m68a(C0026d c0026d) {
        if (this.f135A != null) {
            this.f135A.mo85b();
        }
        this.f135A = c0026d;
        if (c0026d != null) {
            c0026d.m90a(this, (this.f114a * 240) / this.f115b, (this.f115b * 240) / this.f115b);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m69c(String str) {
        int iGlGetError = GL11.glGetError();
        if (iGlGetError != 0) {
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + str);
            System.out.println(iGlGetError + ": " + strGluErrorString);
            System.exit(0);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.mojang.minecraft.a.f, java.lang.Exception] */
    /* JADX INFO: renamed from: d */
    private void m70d() throws FileNotFoundException {
        ?? r0;
        try {
            r0 = this.f119c;
            C0001a.m5a((C0017f) r0, new FileOutputStream(new File("level.dat")));
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m71a() throws FileNotFoundException {
        m70d();
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v55, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v56, types: [org.lwjgl.LWJGLException] */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v67, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v96, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v20, types: [com.mojang.minecraft.a.f] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    @Override // java.lang.Runnable
    public final void run() throws FileNotFoundException {
        boolean zM4b;
        ?? r0 = this;
        r0.f140l = true;
        try {
            this.f116n.put(new float[]{0.5f, 0.8f, 1.0f, 1.0f});
            this.f116n.flip();
            this.f117o.put(new float[]{14 / 255.0f, 11 / 255.0f, 10 / 255.0f, 1.0f});
            this.f117o.flip();
            if (this.f127v != null) {
                Display.setParent(this.f127v);
            } else if (this.f113m) {
                Display.setFullscreen(true);
                this.f114a = Display.getDisplayMode().getWidth();
                this.f115b = Display.getDisplayMode().getHeight();
            } else {
                Display.setDisplayMode(new DisplayMode(this.f114a, this.f115b));
            }
            r0 = "Minecraft 0.0.13a_03";
            Display.setTitle("Minecraft 0.0.13a_03");
            try {
                Display.create();
            } catch (LWJGLException e) {
                "Minecraft 0.0.13a_03".printStackTrace();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                Display.create();
            }
            Keyboard.create();
            Mouse.create();
            m69c("Pre startup");
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
            m69c("Startup");
            this.f133h = new C0029g("/default.gif", this.f132y);
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(256);
            intBufferCreateIntBuffer.clear().limit(256);
            GL11.glViewport(0, 0, this.f114a, this.f115b);
            this.f119c = new C0017f();
            try {
                if (this.f138j != null) {
                    zM4b = m83a(this.f138j, this.f139k);
                } else {
                    boolean zM3a = this.f136i.m3a(this.f119c, new FileInputStream(new File("level.dat")));
                    zM4b = zM3a;
                    if (!zM3a) {
                        zM4b = this.f136i.m4b(this.f119c, new FileInputStream(new File("level.dat")));
                    }
                }
            } catch (Exception unused2) {
                zM4b = false;
            }
            if (!zM4b) {
                this.f137B.m25a(this.f119c, this.f124d != null ? this.f124d.f174a : "anonymous", 256, 256, 64);
            }
            this.f120q = new C0016e(this.f119c, this.f132y);
            this.f121r = new C0033e(this.f119c);
            ?? r3 = this.f119c;
            this.f123t = new C0031a(r3, this.f132y);
            r0 = this.f128f;
            ?? r32 = r3;
            if (r0 != 0) {
                try {
                    r0 = this;
                    r32 = 16;
                    r3 = 16;
                    r0.f130w = new Cursor(16, 16, 0, 0, 1, intBufferCreateIntBuffer, (IntBuffer) null);
                } catch (LWJGLException e2) {
                    r0.printStackTrace();
                    r32 = r3;
                }
            }
            r0 = "Post startup";
            m69c("Post startup");
            long jCurrentTimeMillis = System.currentTimeMillis();
            ?? r02 = 0;
            int i = 0;
            while (true) {
                try {
                    r02 = this.f140l;
                    if (r02 == 0) {
                        return;
                    }
                    if (this.f129g) {
                        r02 = 100;
                        Thread.sleep(100L);
                    } else {
                        if (this.f127v == null && Display.isCloseRequested()) {
                            this.f140l = false;
                        }
                        C0000a c0000a = this.f118p;
                        long jNanoTime = System.nanoTime();
                        long j = jNanoTime - c0000a.f4b;
                        c0000a.f4b = jNanoTime;
                        if (j < 0) {
                            j = 0;
                        }
                        if (j > 1000000000) {
                            j = 1000000000;
                        }
                        r32 = 1315859240;
                        c0000a.f8f += ((j * c0000a.f7e) * c0000a.f3a) / 1.0E9f;
                        c0000a.f5c = (int) c0000a.f8f;
                        if (c0000a.f5c > 100) {
                            c0000a.f5c = 100;
                        }
                        c0000a.f8f -= c0000a.f5c;
                        c0000a.f6d = c0000a.f8f;
                        for (int i2 = 0; i2 < this.f118p.f5c; i2++) {
                            m74f();
                        }
                        m69c("Pre render");
                        m76b(this.f118p.f6d);
                        m69c("Post render");
                        i++;
                        while (true) {
                            r02 = (System.currentTimeMillis() > (jCurrentTimeMillis + 1000) ? 1 : (System.currentTimeMillis() == (jCurrentTimeMillis + 1000) ? 0 : -1));
                            if (r02 >= 0) {
                                this.f141C = i + " fps, " + C0014c.f61d + " chunk updates";
                                C0014c.f61d = 0;
                                jCurrentTimeMillis += 1000;
                                i = 0;
                            }
                        }
                    }
                } catch (Exception e3) {
                    r02.printStackTrace();
                    return;
                } finally {
                    m71a();
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
    public final void m72b() {
        if (this.f142D) {
            return;
        }
        this.f142D = true;
        LWJGLException lWJGLException = this.f128f;
        if (lWJGLException != 0) {
            try {
                Mouse.setNativeCursor(this.f130w);
                lWJGLException = this.f114a / 2;
                Mouse.setCursorPosition((int) lWJGLException, this.f115b / 2);
            } catch (LWJGLException e) {
                lWJGLException.printStackTrace();
            }
        } else {
            Mouse.setGrabbed(true);
        }
        m68a((C0026d) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [org.lwjgl.input.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8, types: [boolean] */
    /* JADX INFO: renamed from: e */
    private void m73e() {
        if (this.f142D) {
            C0033e c0033e = this.f121r;
            for (int i = 0; i < 10; i++) {
                c0033e.f187a[i] = false;
            }
            this.f142D = false;
            LWJGLException nativeCursor = this.f128f;
            if (nativeCursor != 0) {
                try {
                    nativeCursor = Mouse.setNativeCursor((Cursor) null);
                } catch (LWJGLException e) {
                    nativeCursor.printStackTrace();
                }
            } else {
                Mouse.setGrabbed(false);
            }
            m68a(new C0025c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0180  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m74f() throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instruction units count: 1117
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0022c.m74f():void");
    }

    /* JADX INFO: renamed from: a */
    private void m75a(float f) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.f121r.f241o, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.f121r.f240n, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-(this.f121r.f231e + ((this.f121r.f234h - this.f121r.f231e) * f)), -(this.f121r.f232f + ((this.f121r.f235i - this.f121r.f232f) * f)), -(this.f121r.f233g + ((this.f121r.f236j - this.f121r.f233g) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0354  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m76b(float r14) {
        /*
            Method dump skipped, instruction units count: 2054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0022c.m76b(float):void");
    }

    /* JADX INFO: renamed from: b */
    private void m77b(int i) {
        C0002a c0002a = C0002a.f10a[this.f119c.m53b((int) this.f121r.f234h, (int) (this.f121r.f235i + 0.12f), (int) this.f121r.f236j)];
        if (c0002a != null && c0002a.mo21d() == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1f);
            GL11.glFog(2918, m78a(0.02f, 0.02f, 0.2f, 1.0f));
            GL11.glLightModel(2899, m78a(0.3f, 0.3f, 0.7f, 1.0f));
        } else if (c0002a != null && c0002a.mo21d() == 2) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0f);
            GL11.glFog(2918, m78a(0.6f, 0.1f, 0.0f, 1.0f));
            GL11.glLightModel(2899, m78a(0.4f, 0.3f, 0.3f, 1.0f));
        } else if (i == 0) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.001f);
            GL11.glFog(2918, this.f116n);
            GL11.glLightModel(2899, m78a(1.0f, 1.0f, 1.0f, 1.0f));
        } else if (i == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.01f);
            GL11.glFog(2918, this.f117o);
            GL11.glLightModel(2899, m78a(0.6f, 0.6f, 0.6f, 1.0f));
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
        GL11.glEnable(2896);
    }

    /* JADX INFO: renamed from: a */
    private FloatBuffer m78a(float f, float f2, float f3, float f4) {
        this.f146H.clear();
        this.f146H.put(f).put(f2).put(f3).put(1.0f);
        this.f146H.flip();
        return this.f146H;
    }

    /* JADX INFO: renamed from: a */
    public final void m79a(String str) {
        this.f147I = str;
        int i = (this.f114a * 240) / this.f115b;
        int i2 = (this.f115b * 240) / this.f115b;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, i, i2, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    /* JADX INFO: renamed from: b */
    public final void m80b(String str) {
        this.f148J = str;
        m81a(-1);
    }

    /* JADX INFO: renamed from: a */
    public final void m81a(int i) {
        int i2 = (this.f114a * 240) / this.f115b;
        int i3 = (this.f115b * 240) / this.f115b;
        GL11.glClear(16640);
        C0020b c0020b = C0020b.f104a;
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f132y.m55a("/dirt.png", 9728));
        c0020b.m58b();
        c0020b.m63a(4210752);
        c0020b.m61a(0.0f, i3, 0.0f, 0.0f, i3 / 32.0f);
        c0020b.m61a(i2, i3, 0.0f, i2 / 32.0f, i3 / 32.0f);
        c0020b.m61a(i2, 0.0f, 0.0f, i2 / 32.0f, 0.0f);
        c0020b.m61a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        c0020b.m56a();
        if (i >= 0) {
            int i4 = (i2 / 2) - 50;
            int i5 = (i3 / 2) + 16;
            GL11.glDisable(3553);
            c0020b.m58b();
            c0020b.m63a(8421504);
            c0020b.m62a(i4, i5, 0.0f);
            c0020b.m62a(i4, i5 + 2, 0.0f);
            c0020b.m62a(i4 + 100, i5 + 2, 0.0f);
            c0020b.m62a(i4 + 100, i5, 0.0f);
            c0020b.m63a(8454016);
            c0020b.m62a(i4, i5, 0.0f);
            c0020b.m62a(i4, i5 + 2, 0.0f);
            c0020b.m62a(i4 + i, i5 + 2, 0.0f);
            c0020b.m62a(i4 + i, i5, 0.0f);
            c0020b.m56a();
            GL11.glEnable(3553);
        }
        this.f133h.m98a(this.f147I, (i2 - this.f133h.m100a(this.f147I)) / 2, ((i3 / 2) - 4) - 16, 16777215);
        this.f133h.m98a(this.f148J, (i2 - this.f133h.m100a(this.f148J)) / 2, ((i3 / 2) - 4) + 8, 16777215);
        Display.update();
        try {
            Thread.yield();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m82c() {
        this.f137B.m25a(this.f119c, this.f124d != null ? this.f124d.f174a : "anonymous", 256, 256, 64);
        this.f121r.m112b();
        while (0 < this.f126u.size()) {
            this.f126u.remove(0);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m83a(String str, int i) {
        if (!this.f136i.m2a(this.f119c, this.f125e, str, i)) {
            return false;
        }
        if (this.f121r != null) {
            this.f121r.m112b();
        }
        if (this.f126u == null) {
            return true;
        }
        while (0 < this.f126u.size()) {
            this.f126u.remove(0);
        }
        return true;
    }
}
