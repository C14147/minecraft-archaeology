package com.mojang.minecraft;

import com.mojang.minecraft.character.Zombie;
import com.mojang.minecraft.level.C0025a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p002a.C0026a;
import com.mojang.minecraft.level.p003b.C0036a;
import com.mojang.minecraft.p000a.C0002a;
import com.mojang.minecraft.p000a.C0004c;
import com.mojang.minecraft.p000a.C0007f;
import com.mojang.minecraft.p000a.C0008g;
import com.mojang.minecraft.p001b.C0011b;
import com.mojang.minecraft.p001b.C0012c;
import com.mojang.minecraft.p001b.C0017h;
import com.mojang.minecraft.particle.C0041a;
import com.mojang.minecraft.particle.Particle;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.player.C0043b;
import com.mojang.minecraft.player.Player;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.swing.JOptionPane;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/* JADX INFO: renamed from: com.mojang.minecraft.c */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/c.class */
public final class RunnableC0018c implements Runnable {

    /* JADX INFO: renamed from: j */
    private boolean f96j;

    /* JADX INFO: renamed from: a */
    public int f97a;

    /* JADX INFO: renamed from: b */
    public int f98b;

    /* JADX INFO: renamed from: n */
    private Level f102n;

    /* JADX INFO: renamed from: o */
    private C0008g f103o;

    /* JADX INFO: renamed from: p */
    private Player f104p;

    /* JADX INFO: renamed from: r */
    private C0041a f106r;

    /* JADX INFO: renamed from: d */
    public String f108d;

    /* JADX INFO: renamed from: s */
    private Canvas f109s;

    /* JADX INFO: renamed from: t */
    private Cursor f112t;

    /* JADX INFO: renamed from: g */
    public C0017h f115g;

    /* JADX INFO: renamed from: B */
    private Robot f123B;

    /* JADX INFO: renamed from: C */
    private static final int[] f124C = {C0026a.f179c.f198v, C0026a.f181e.f198v, C0026a.f182f.f198v, C0026a.f183g.f198v, C0026a.f184h.f198v, C0026a.f195s.f198v, C0026a.f196t.f198v, C0026a.f190n.f198v, C0026a.f191o.f198v};

    /* JADX INFO: renamed from: k */
    private FloatBuffer f99k = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: l */
    private FloatBuffer f100l = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: m */
    private C0009b f101m = new C0009b(20.0f);

    /* JADX INFO: renamed from: q */
    private int f105q = 1;

    /* JADX INFO: renamed from: c */
    public C0001a f107c = null;

    /* JADX INFO: renamed from: e */
    public boolean f110e = false;

    /* JADX INFO: renamed from: f */
    public volatile boolean f111f = false;

    /* JADX INFO: renamed from: u */
    private int f113u = 1;

    /* JADX INFO: renamed from: w */
    private int f116w = 0;

    /* JADX INFO: renamed from: x */
    private C0012c f117x = null;

    /* JADX INFO: renamed from: y */
    private C0025a f118y = new C0025a(this);

    /* JADX INFO: renamed from: z */
    private C0036a f119z = new C0036a(this);

    /* JADX INFO: renamed from: A */
    private int f120A = 0;

    /* JADX INFO: renamed from: h */
    public String f121h = null;

    /* JADX INFO: renamed from: i */
    public int f122i = 0;

    /* JADX INFO: renamed from: D */
    private float f125D = 0.5f;

    /* JADX INFO: renamed from: E */
    private float f126E = 0.8f;

    /* JADX INFO: renamed from: F */
    private float f127F = 1.0f;

    /* JADX INFO: renamed from: G */
    private volatile boolean f128G = false;

    /* JADX INFO: renamed from: H */
    private String f129H = "";

    /* JADX INFO: renamed from: I */
    private boolean f130I = false;

    /* JADX INFO: renamed from: J */
    private int f131J = 0;

    /* JADX INFO: renamed from: K */
    private float f132K = 0.0f;

    /* JADX INFO: renamed from: L */
    private IntBuffer f133L = BufferUtils.createIntBuffer(16);

    /* JADX INFO: renamed from: M */
    private IntBuffer f134M = BufferUtils.createIntBuffer(2000);

    /* JADX INFO: renamed from: N */
    private C0024d f135N = null;

    /* JADX INFO: renamed from: O */
    private volatile int f136O = 0;

    /* JADX INFO: renamed from: P */
    private volatile int f137P = 0;

    /* JADX INFO: renamed from: Q */
    private FloatBuffer f138Q = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: R */
    private String f139R = "";

    /* JADX INFO: renamed from: S */
    private String f140S = "";

    /* JADX INFO: renamed from: v */
    private C0002a f114v = new C0002a();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.awt.AWTException] */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.mojang.minecraft.c] */
    public RunnableC0018c(Canvas canvas, int i, int i2, boolean z) {
        this.f96j = false;
        this.f109s = canvas;
        this.f97a = i;
        this.f98b = i2;
        this.f96j = false;
        ?? r0 = canvas;
        if (r0 != 0) {
            try {
                r0 = this;
                r0.f123B = new Robot();
            } catch (AWTException e) {
                r0.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m46a(C0012c c0012c) {
        if (this.f117x != null) {
            this.f117x.mo30b();
        }
        this.f117x = c0012c;
        if (c0012c != null) {
            c0012c.m35a(this, (this.f97a * 240) / this.f98b, (this.f98b * 240) / this.f98b);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m47c(String str) {
        int iGlGetError = GL11.glGetError();
        if (iGlGetError != 0) {
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + str);
            System.out.println(iGlGetError + ": " + strGluErrorString);
            System.exit(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.mojang.minecraft.level.Level] */
    /* JADX INFO: renamed from: a */
    public final void m48a() {
        ?? r0 = this.f110e;
        if (r0 == 0) {
            try {
                r0 = this.f102n;
                C0025a.m78a(r0, new FileOutputStream(new File("level.dat")));
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v136 */
    /* JADX WARN: Type inference failed for: r0v139 */
    /* JADX WARN: Type inference failed for: r0v140 */
    /* JADX WARN: Type inference failed for: r0v141 */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v57, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v58, types: [org.lwjgl.LWJGLException] */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.mojang.minecraft.c] */
    /* JADX WARN: Type inference failed for: r0v60, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v66, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v69, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r0v98, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.mojang.minecraft.level.Level] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0;
        ?? r02 = this;
        r02.f128G = true;
        try {
            this.f99k.put(new float[]{this.f125D, this.f126E, this.f127F, 1.0f});
            this.f99k.flip();
            this.f100l.put(new float[]{14 / 255.0f, 11 / 255.0f, 10 / 255.0f, 1.0f});
            this.f100l.flip();
            if (this.f109s != null) {
                Display.setParent(this.f109s);
            } else if (this.f96j) {
                Display.setFullscreen(true);
                this.f97a = Display.getDisplayMode().getWidth();
                this.f98b = Display.getDisplayMode().getHeight();
            } else {
                Display.setDisplayMode(new DisplayMode(this.f97a, this.f98b));
            }
            r02 = "Minecraft 0.0.14a_08";
            Display.setTitle("Minecraft 0.0.14a_08");
            try {
                Display.create();
                r02 = r02;
            } catch (LWJGLException e) {
                "Minecraft 0.0.14a_08".printStackTrace();
                try {
                    r0 = 1000;
                    r02 = 1000;
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    r0 = r02;
                }
                Display.create();
                r02 = r0;
            }
            Keyboard.create();
            Mouse.create();
            try {
                Controllers.create();
            } catch (Exception e2) {
                r02.printStackTrace();
            }
            m47c("Pre startup");
            GL11.glEnable(3553);
            GL11.glShadeModel(7425);
            GL11.glClearDepth(1.0d);
            GL11.glEnable(2929);
            GL11.glDepthFunc(515);
            GL11.glEnable(3008);
            GL11.glAlphaFunc(516, 0.0f);
            GL11.glCullFace(1029);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            m47c("Startup");
            this.f115g = new C0017h("/default.gif", this.f114v);
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(256);
            intBufferCreateIntBuffer.clear().limit(256);
            GL11.glViewport(0, 0, this.f97a, this.f98b);
            r02 = 0;
            boolean zM63a = false;
            try {
                if (this.f121h != null) {
                    zM63a = m63a(this.f121h, this.f122i);
                } else if (!this.f110e) {
                    Level levelM76a = this.f118y.m76a(new FileInputStream(new File("level.dat")));
                    Level level = levelM76a;
                    boolean z = levelM76a != null;
                    zM63a = z;
                    if (!z) {
                        Level levelM77b = this.f118y.m77b(new FileInputStream(new File("level.dat")));
                        level = levelM77b;
                        zM63a = levelM77b != null;
                    }
                    m64a(level);
                }
            } catch (Exception e3) {
                (false ? 1 : 0).printStackTrace();
                zM63a = false;
            }
            if (!zM63a) {
                m61b(1);
            }
            this.f103o = new C0008g(this.f114v);
            this.f106r = new C0041a(this.f102n, this.f114v);
            ?? r3 = this.f102n;
            this.f104p = new Player(r3, new C0043b());
            this.f104p.resetPos();
            if (this.f102n != null) {
                this.f103o.m20a(this.f102n);
            }
            r02 = this.f110e;
            ?? r32 = r3;
            if (r02 != 0) {
                try {
                    r02 = this;
                    r32 = 16;
                    r3 = 16;
                    r02.f112t = new Cursor(16, 16, 0, 0, 1, intBufferCreateIntBuffer, (IntBuffer) null);
                } catch (LWJGLException e4) {
                    r02.printStackTrace();
                    r32 = r3;
                }
            }
            r02 = "Post startup";
            m47c("Post startup");
            long jCurrentTimeMillis = System.currentTimeMillis();
            ?? r03 = 0;
            int i = 0;
            while (true) {
                try {
                    r03 = this.f128G;
                    if (r03 == 0) {
                        return;
                    }
                    if (this.f111f) {
                        r03 = 100;
                        Thread.sleep(100L);
                    } else {
                        if (this.f109s == null && Display.isCloseRequested()) {
                            this.f128G = false;
                        }
                        C0009b c0009b = this.f101m;
                        long jNanoTime = System.nanoTime();
                        long j = jNanoTime - c0009b.f65b;
                        c0009b.f65b = jNanoTime;
                        if (j < 0) {
                            j = 0;
                        }
                        if (j > 1000000000) {
                            j = 1000000000;
                        }
                        r32 = 1315859240;
                        c0009b.f69f += ((j * c0009b.f68e) * c0009b.f64a) / 1.0E9f;
                        c0009b.f66c = (int) c0009b.f69f;
                        if (c0009b.f66c > 100) {
                            c0009b.f66c = 100;
                        }
                        c0009b.f69f -= c0009b.f66c;
                        c0009b.f67d = c0009b.f69f;
                        for (int i2 = 0; i2 < this.f101m.f66c; i2++) {
                            this.f120A++;
                            m53f();
                        }
                        m47c("Pre render");
                        m55b(this.f101m.f67d);
                        m47c("Post render");
                        i++;
                        while (true) {
                            r03 = (System.currentTimeMillis() > (jCurrentTimeMillis + 1000) ? 1 : (System.currentTimeMillis() == (jCurrentTimeMillis + 1000) ? 0 : -1));
                            if (r03 >= 0) {
                                this.f129H = i + " fps, " + C0007f.f40a + " chunk updates";
                                C0007f.f40a = 0;
                                jCurrentTimeMillis += 1000;
                                i = 0;
                            }
                        }
                    }
                } catch (Exception e5) {
                    r03.printStackTrace();
                    return;
                } finally {
                    m48a();
                }
            }
        } catch (Exception e6) {
            r02.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e6.toString(), "Failed to start Minecraft", 0);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m49b() {
        this.f128G = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX INFO: renamed from: c */
    public final void m50c() {
        if (this.f130I) {
            return;
        }
        this.f130I = true;
        LWJGLException lWJGLException = this.f110e;
        if (lWJGLException != 0) {
            try {
                Mouse.setNativeCursor(this.f112t);
                lWJGLException = this.f97a / 2;
                Mouse.setCursorPosition((int) lWJGLException, this.f98b / 2);
            } catch (LWJGLException e) {
                lWJGLException.printStackTrace();
            }
        } else {
            Mouse.setGrabbed(true);
        }
        m46a((C0012c) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v9, types: [org.lwjgl.input.Cursor] */
    /* JADX INFO: renamed from: d */
    private void m51d() {
        if (this.f130I) {
            this.f104p.releaseAllKeys();
            this.f130I = false;
            LWJGLException nativeCursor = this.f110e;
            if (nativeCursor != 0) {
                try {
                    nativeCursor = Mouse.setNativeCursor((Cursor) null);
                } catch (LWJGLException e) {
                    nativeCursor.printStackTrace();
                }
            } else {
                Mouse.setGrabbed(false);
            }
            m46a(new C0011b());
        }
    }

    /* JADX INFO: renamed from: e */
    private void m52e() {
        if (this.f135N == null) {
            return;
        }
        C0026a c0026a = C0026a.f177a[this.f102n.getTile(this.f135N.f167a, this.f135N.f168b, this.f135N.f169c)];
        if (this.f116w == 0) {
            boolean tile = this.f102n.setTile(this.f135N.f167a, this.f135N.f168b, this.f135N.f169c, 0);
            if (c0026a == null || !tile) {
                return;
            }
            c0026a.m94a(this.f102n, this.f135N.f167a, this.f135N.f168b, this.f135N.f169c, this.f106r);
            return;
        }
        int i = this.f135N.f167a;
        int i2 = this.f135N.f168b;
        int i3 = this.f135N.f169c;
        if (this.f135N.f170d == 0) {
            i2--;
        }
        if (this.f135N.f170d == 1) {
            i2++;
        }
        if (this.f135N.f170d == 2) {
            i3--;
        }
        if (this.f135N.f170d == 3) {
            i3++;
        }
        if (this.f135N.f170d == 4) {
            i--;
        }
        if (this.f135N.f170d == 5) {
            i++;
        }
        C0026a c0026a2 = C0026a.f177a[this.f102n.getTile(i, i2, i3)];
        if (c0026a2 == null || c0026a2 == C0026a.f186j || c0026a2 == C0026a.f187k || c0026a2 == C0026a.f188l || c0026a2 == C0026a.f189m) {
            AABB aabbMo89b = C0026a.f177a[this.f105q].mo89b(i, i2, i3);
            if (aabbMo89b != null) {
                if (!(this.f104p.f9bb.intersects(aabbMo89b) ? false : this.f102n.isFree(aabbMo89b))) {
                    return;
                }
            }
            this.f102n.setTile(i, i2, i3, this.f105q);
            C0026a.f177a[this.f105q].mo97a(this.f102n, i, i2, i3);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m53f() {
        int length;
        if (this.f117x == null) {
            while (Mouse.next()) {
                int eventDWheel = Mouse.getEventDWheel();
                if (eventDWheel != 0) {
                    int i = eventDWheel;
                    if (i > 0) {
                        i = 1;
                    }
                    if (i < 0) {
                        i = -1;
                    }
                    int i2 = 0;
                    for (int i3 = 0; i3 < f124C.length; i3++) {
                        if (f124C[i3] == this.f105q) {
                            i2 = i3;
                        }
                    }
                    int i4 = i2;
                    int length2 = i;
                    while (true) {
                        length = i4 + length2;
                        if (length >= 0) {
                            break;
                        }
                        i4 = length;
                        length2 = f124C.length;
                    }
                    while (length >= f124C.length) {
                        length -= f124C.length;
                    }
                    this.f105q = f124C[length];
                }
                if (this.f130I || !Mouse.getEventButtonState()) {
                    if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                        m52e();
                        this.f131J = this.f120A;
                    }
                    if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                        this.f116w = (this.f116w + 1) % 2;
                    }
                    if (Mouse.getEventButton() == 2 && Mouse.getEventButtonState() && this.f135N != null) {
                        int tile = this.f102n.getTile(this.f135N.f167a, this.f135N.f168b, this.f135N.f169c);
                        int i5 = tile;
                        if (tile == C0026a.f180d.f198v) {
                            i5 = C0026a.f181e.f198v;
                        }
                        for (int i6 = 0; i6 < f124C.length; i6++) {
                            if (i5 == f124C[i6]) {
                                this.f105q = f124C[i6];
                            }
                        }
                    }
                } else {
                    m50c();
                }
            }
            while (Keyboard.next()) {
                this.f104p.setKey(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    if (Keyboard.getEventKey() == 1) {
                        m51d();
                    }
                    if (Keyboard.getEventKey() == 19) {
                        this.f104p.resetPos();
                    }
                    if (Keyboard.getEventKey() == 28) {
                        this.f102n.setSpawnPos((int) this.f104p.f3x, (int) this.f104p.f4y, (int) this.f104p.f5z, this.f104p.yRot);
                        this.f104p.resetPos();
                    }
                    for (int i7 = 0; i7 < 9; i7++) {
                        if (Keyboard.getEventKey() == i7 + 2) {
                            this.f105q = f124C[i7];
                        }
                    }
                    if (Keyboard.getEventKey() == 21) {
                        this.f113u = -this.f113u;
                    }
                    if (Keyboard.getEventKey() == 34 && this.f102n.entities.size() < 256) {
                        this.f102n.entities.add(new Zombie(this.f102n, this.f104p.f3x, this.f104p.f4y, this.f104p.f5z));
                    }
                    if (Keyboard.getEventKey() == 33) {
                        C0008g c0008g = this.f103o;
                        c0008g.f52c = (c0008g.f52c + 1) % 4;
                    }
                }
            }
            if (Mouse.isButtonDown(0) && this.f120A - this.f131J >= this.f101m.f64a / 4.0f && this.f130I) {
                m52e();
                this.f131J = this.f120A;
            }
        } else {
            this.f131J = this.f120A + 10000;
        }
        if (this.f117x != null) {
            this.f117x.m40d();
            if (this.f117x != null) {
                this.f117x.mo31c();
            }
        }
        this.f103o.f60f++;
        this.f102n.tick();
        C0041a c0041a = this.f106r;
        int i8 = 0;
        while (i8 < c0041a.f229a.size()) {
            Particle particle = (Particle) c0041a.f229a.get(i8);
            particle.tick();
            if (particle.removed) {
                int i9 = i8;
                i8--;
                c0041a.f229a.remove(i9);
            }
            i8++;
        }
        this.f104p.tick();
    }

    /* JADX INFO: renamed from: a */
    private void m54a(float f) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.f104p.xRot - (this.f104p.xRotI * (1.0f - f)), 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.f104p.yRot - (this.f104p.yRotI * (1.0f - f)), 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-(this.f104p.f0xo + ((this.f104p.f3x - this.f104p.f0xo) * f)), -(this.f104p.f1yo + ((this.f104p.f4y - this.f104p.f1yo) * f)), -(this.f104p.f2zo + ((this.f104p.f5z - this.f104p.f2zo) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0334  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55b(float r14) {
        /*
            Method dump skipped, instruction units count: 2031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0018c.m55b(float):void");
    }

    /* JADX INFO: renamed from: c */
    private void m56c(int i) {
        if (i == -1) {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, this.f132K);
            GL11.glFog(2918, m57a(this.f125D, this.f126E, this.f127F, 1.0f));
            GL11.glLightModel(2899, m57a(1.0f, 1.0f, 1.0f, 1.0f));
            return;
        }
        C0026a c0026a = C0026a.f177a[this.f102n.getTile((int) this.f104p.f3x, (int) (this.f104p.f4y + 0.12f), (int) this.f104p.f5z)];
        if (c0026a != null && c0026a.mo95d() == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1f);
            GL11.glFog(2918, m57a(0.02f, 0.02f, 0.2f, 1.0f));
            GL11.glLightModel(2899, m57a(0.3f, 0.3f, 0.7f, 1.0f));
        } else if (c0026a != null && c0026a.mo95d() == 2) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0f);
            GL11.glFog(2918, m57a(0.6f, 0.1f, 0.0f, 1.0f));
            GL11.glLightModel(2899, m57a(0.4f, 0.3f, 0.3f, 1.0f));
        } else if (i == 0) {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, this.f132K);
            GL11.glFog(2918, m57a(this.f125D, this.f126E, this.f127F, 1.0f));
            GL11.glLightModel(2899, m57a(1.0f, 1.0f, 1.0f, 1.0f));
        } else if (i == 1) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.01f);
            GL11.glFog(2918, this.f100l);
            GL11.glLightModel(2899, m57a(0.6f, 0.6f, 0.6f, 1.0f));
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
        GL11.glEnable(2896);
    }

    /* JADX INFO: renamed from: a */
    private FloatBuffer m57a(float f, float f2, float f3, float f4) {
        this.f138Q.clear();
        this.f138Q.put(f).put(f2).put(f3).put(1.0f);
        this.f138Q.flip();
        return this.f138Q;
    }

    /* JADX INFO: renamed from: a */
    public final void m58a(String str) {
        this.f139R = str;
        int i = (this.f97a * 240) / this.f98b;
        int i2 = (this.f98b * 240) / this.f98b;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, i, i2, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    /* JADX INFO: renamed from: b */
    public final void m59b(String str) {
        this.f140S = str;
        m60a(-1);
    }

    /* JADX INFO: renamed from: a */
    public final void m60a(int i) {
        int i2 = (this.f97a * 240) / this.f98b;
        int i3 = (this.f98b * 240) / this.f98b;
        GL11.glClear(16640);
        C0004c c0004c = C0004c.f27a;
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f114v.m0a("/dirt.png", 9728));
        c0004c.m3b();
        c0004c.m8a(4210752);
        c0004c.m6a(0.0f, i3, 0.0f, 0.0f, i3 / 32.0f);
        c0004c.m6a(i2, i3, 0.0f, i2 / 32.0f, i3 / 32.0f);
        c0004c.m6a(i2, 0.0f, 0.0f, i2 / 32.0f, 0.0f);
        c0004c.m6a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        c0004c.m1a();
        if (i >= 0) {
            int i4 = (i2 / 2) - 50;
            int i5 = (i3 / 2) + 16;
            GL11.glDisable(3553);
            c0004c.m3b();
            c0004c.m8a(8421504);
            c0004c.m7b(i4, i5, 0.0f);
            c0004c.m7b(i4, i5 + 2, 0.0f);
            c0004c.m7b(i4 + 100, i5 + 2, 0.0f);
            c0004c.m7b(i4 + 100, i5, 0.0f);
            c0004c.m8a(8454016);
            c0004c.m7b(i4, i5, 0.0f);
            c0004c.m7b(i4, i5 + 2, 0.0f);
            c0004c.m7b(i4 + i, i5 + 2, 0.0f);
            c0004c.m7b(i4 + i, i5, 0.0f);
            c0004c.m1a();
            GL11.glEnable(3553);
        }
        this.f115g.m43a(this.f139R, (i2 - this.f115g.m45a(this.f139R)) / 2, ((i3 / 2) - 4) - 16, 16777215);
        this.f115g.m43a(this.f140S, (i2 - this.f115g.m45a(this.f140S)) / 2, ((i3 / 2) - 4) + 8, 16777215);
        Display.update();
        try {
            Thread.yield();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m61b(int i) {
        m64a(this.f119z.m100a(this.f107c != null ? this.f107c.f10a : "anonymous", 128 << i, 128 << i, 64));
    }

    /* JADX INFO: renamed from: a */
    public final boolean m62a(int i, String str) {
        return this.f118y.m74a(this.f102n, this.f108d, this.f107c.f10a, this.f107c.f11b, str, i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m63a(String str, int i) {
        Level levelM75a = this.f118y.m75a(this.f108d, str, i);
        if (!(levelM75a != null)) {
            return false;
        }
        m64a(levelM75a);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m64a(Level level) {
        this.f102n = level;
        if (this.f103o != null) {
            this.f103o.m20a(level);
        }
        if (this.f106r != null) {
            this.f106r.f229a.clear();
        }
        if (this.f104p != null) {
            this.f104p.setLevel(level);
            this.f104p.resetPos();
        }
        System.gc();
    }
}
