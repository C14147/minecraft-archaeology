package com.mojang.minecraft;

import com.mojang.minecraft.character.Zombie;
import com.mojang.minecraft.level.C0029a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.p003a.C0030a;
import com.mojang.minecraft.level.p004b.C0040a;
import com.mojang.minecraft.level.p006c.C0045a;
import com.mojang.minecraft.net.C0046a;
import com.mojang.minecraft.net.C0048c;
import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.p001a.C0005c;
import com.mojang.minecraft.p001a.C0008f;
import com.mojang.minecraft.p001a.C0009g;
import com.mojang.minecraft.p002b.C0012b;
import com.mojang.minecraft.p002b.C0013c;
import com.mojang.minecraft.p002b.C0014d;
import com.mojang.minecraft.p002b.C0018h;
import com.mojang.minecraft.p002b.C0020j;
import com.mojang.minecraft.particle.C0049a;
import com.mojang.minecraft.particle.Particle;
import com.mojang.minecraft.phys.AABB;
import com.mojang.minecraft.player.C0051b;
import com.mojang.minecraft.player.Player;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
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

/* JADX INFO: renamed from: com.mojang.minecraft.d */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/d.class */
public final class RunnableC0027d implements Runnable {

    /* JADX INFO: renamed from: n */
    private boolean f136n;

    /* JADX INFO: renamed from: a */
    public int f137a;

    /* JADX INFO: renamed from: b */
    public int f138b;

    /* JADX INFO: renamed from: c */
    public Level f142c;

    /* JADX INFO: renamed from: r */
    private C0009g f143r;

    /* JADX INFO: renamed from: d */
    public Player f144d;

    /* JADX INFO: renamed from: t */
    private C0049a f146t;

    /* JADX INFO: renamed from: f */
    public String f148f;

    /* JADX INFO: renamed from: u */
    private Canvas f149u;

    /* JADX INFO: renamed from: v */
    private Cursor f152v;

    /* JADX INFO: renamed from: i */
    public C0020j f155i;

    /* JADX INFO: renamed from: D */
    private Robot f163D;

    /* JADX INFO: renamed from: l */
    public C0048c f164l;

    /* JADX INFO: renamed from: F */
    private static final int[] f166F = {C0030a.f200c.f219v, C0030a.f202e.f219v, C0030a.f203f.f219v, C0030a.f204g.f219v, C0030a.f205h.f219v, C0030a.f216s.f219v, C0030a.f217t.f219v, C0030a.f211n.f219v, C0030a.f212o.f219v};

    /* JADX INFO: renamed from: o */
    private FloatBuffer f139o = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: p */
    private FloatBuffer f140p = BufferUtils.createFloatBuffer(4);

    /* JADX INFO: renamed from: q */
    private C0021c f141q = new C0021c(20.0f);

    /* JADX INFO: renamed from: s */
    private int f145s = 1;

    /* JADX INFO: renamed from: e */
    public C0002a f147e = null;

    /* JADX INFO: renamed from: g */
    public boolean f150g = false;

    /* JADX INFO: renamed from: h */
    public volatile boolean f151h = false;

    /* JADX INFO: renamed from: w */
    private int f153w = 1;

    /* JADX INFO: renamed from: y */
    private int f156y = 0;

    /* JADX INFO: renamed from: z */
    private C0014d f157z = null;

    /* JADX INFO: renamed from: A */
    private C0029a f158A = new C0029a(this);

    /* JADX INFO: renamed from: B */
    private C0040a f159B = new C0040a(this);

    /* JADX INFO: renamed from: C */
    private int f160C = 0;

    /* JADX INFO: renamed from: j */
    public String f161j = null;

    /* JADX INFO: renamed from: k */
    public int f162k = 0;

    /* JADX INFO: renamed from: E */
    private List f165E = new ArrayList();

    /* JADX INFO: renamed from: G */
    private String f167G = null;

    /* JADX INFO: renamed from: H */
    private int f168H = 0;

    /* JADX INFO: renamed from: I */
    private float f169I = 0.5f;

    /* JADX INFO: renamed from: J */
    private float f170J = 0.8f;

    /* JADX INFO: renamed from: K */
    private float f171K = 1.0f;

    /* JADX INFO: renamed from: L */
    private volatile boolean f172L = false;

    /* JADX INFO: renamed from: M */
    private String f173M = "";

    /* JADX INFO: renamed from: N */
    private boolean f174N = false;

    /* JADX INFO: renamed from: O */
    private int f175O = 0;

    /* JADX INFO: renamed from: P */
    private float f176P = 0.0f;

    /* JADX INFO: renamed from: Q */
    private IntBuffer f177Q = BufferUtils.createIntBuffer(16);

    /* JADX INFO: renamed from: R */
    private IntBuffer f178R = BufferUtils.createIntBuffer(2000);

    /* JADX INFO: renamed from: S */
    private C0028e f179S = null;

    /* JADX INFO: renamed from: T */
    private float f180T = 1.0f;

    /* JADX INFO: renamed from: U */
    private volatile int f181U = 0;

    /* JADX INFO: renamed from: V */
    private volatile int f182V = 0;

    /* JADX INFO: renamed from: W */
    private FloatBuffer f183W = BufferUtils.createFloatBuffer(16);

    /* JADX INFO: renamed from: X */
    private String f184X = "";

    /* JADX INFO: renamed from: Y */
    private String f185Y = "";

    /* JADX INFO: renamed from: m */
    public boolean f186m = false;

    /* JADX INFO: renamed from: x */
    private C0003a f154x = new C0003a();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.awt.AWTException] */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.mojang.minecraft.d] */
    public RunnableC0027d(Canvas canvas, int i, int i2, boolean z) {
        this.f136n = false;
        this.f149u = canvas;
        this.f137a = i;
        this.f138b = i2;
        this.f136n = false;
        ?? r0 = canvas;
        if (r0 != 0) {
            try {
                r0 = this;
                r0.f163D = new Robot();
            } catch (AWTException e) {
                r0.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m56a(String str, int i) {
        this.f167G = str;
        this.f168H = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v26, types: [org.lwjgl.input.Cursor] */
    /* JADX INFO: renamed from: a */
    public final void m57a(C0014d c0014d) {
        if (this.f157z instanceof C0018h) {
            return;
        }
        if (this.f157z != null) {
            this.f157z.mo34b();
        }
        this.f157z = c0014d;
        if (c0014d == null) {
            m61c();
            return;
        }
        if (this.f174N) {
            this.f144d.releaseAllKeys();
            this.f174N = false;
            LWJGLException nativeCursor = this.f150g;
            if (nativeCursor != 0) {
                try {
                    nativeCursor = Mouse.setNativeCursor((Cursor) null);
                } catch (LWJGLException e) {
                    nativeCursor.printStackTrace();
                }
            } else {
                Mouse.setGrabbed(false);
            }
        }
        c0014d.m39a(this, (this.f137a * 240) / this.f138b, (this.f138b * 240) / this.f138b);
    }

    /* JADX INFO: renamed from: d */
    private static void m58d(String str) {
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
    public final void m59a() {
        ?? r0 = this.f150g;
        if (r0 == 0) {
            try {
                r0 = this.f142c;
                C0029a.m89a(r0, new FileOutputStream(new File("level.dat")));
            } catch (Exception e) {
                r0.printStackTrace();
            }
        }
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.mojang.minecraft.d] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v182 */
    /* JADX WARN: Type inference failed for: r0v208 */
    /* JADX WARN: Type inference failed for: r0v211 */
    /* JADX WARN: Type inference failed for: r0v212 */
    /* JADX WARN: Type inference failed for: r0v213 */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v50, types: [com.mojang.minecraft.d] */
    /* JADX WARN: Type inference failed for: r0v59, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v60, types: [org.lwjgl.LWJGLException] */
    /* JADX WARN: Type inference failed for: r0v61, types: [com.mojang.minecraft.d] */
    /* JADX WARN: Type inference failed for: r0v62, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v71, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v81, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.mojang.minecraft.level.Level] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0;
        int i;
        ?? r02 = this;
        r02.f172L = true;
        try {
            this.f139o.put(new float[]{this.f169I, this.f170J, this.f171K, 1.0f});
            this.f139o.flip();
            this.f140p.put(new float[]{14 / 255.0f, 11 / 255.0f, 10 / 255.0f, 1.0f});
            this.f140p.flip();
            if (this.f149u != null) {
                Display.setParent(this.f149u);
            } else if (this.f136n) {
                Display.setFullscreen(true);
                this.f137a = Display.getDisplayMode().getWidth();
                this.f138b = Display.getDisplayMode().getHeight();
            } else {
                Display.setDisplayMode(new DisplayMode(this.f137a, this.f138b));
            }
            r02 = "Minecraft 0.0.16a_02";
            Display.setTitle("Minecraft 0.0.16a_02");
            try {
                Display.create();
                r02 = r02;
            } catch (LWJGLException e) {
                "Minecraft 0.0.16a_02".printStackTrace();
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
            m58d("Pre startup");
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
            m58d("Startup");
            this.f155i = new C0020j("/default.gif", this.f154x);
            IntBuffer intBufferCreateIntBuffer = BufferUtils.createIntBuffer(256);
            intBufferCreateIntBuffer.clear().limit(256);
            GL11.glViewport(0, 0, this.f137a, this.f138b);
            r02 = this.f167G;
            if (r02 != 0) {
                try {
                    r02 = this;
                    r02.f164l = new C0048c(this, this.f167G, this.f168H, this.f147e != null ? this.f147e.f18a : "guest");
                } catch (IOException unused2) {
                    m57a(new C0018h("Failed to connect", "You failed to connect to the server. It's probably down!"));
                }
                this.f142c = null;
            } else {
                r02 = 0;
                boolean zM77b = false;
                try {
                    if (this.f161j != null) {
                        zM77b = m77b(this.f161j, this.f162k);
                    } else if (!this.f150g) {
                        Level levelM87a = this.f158A.m87a(new FileInputStream(new File("level.dat")));
                        Level level = levelM87a;
                        boolean z = levelM87a != null;
                        zM77b = z;
                        if (!z) {
                            Level levelM88b = this.f158A.m88b(new FileInputStream(new File("level.dat")));
                            level = levelM88b;
                            zM77b = levelM88b != null;
                        }
                        m78a(level);
                    }
                } catch (Exception e3) {
                    (false ? 1 : 0).printStackTrace();
                    zM77b = false;
                }
                if (!zM77b) {
                    m75b(1);
                }
            }
            this.f143r = new C0009g(this.f154x);
            this.f146t = new C0049a(this.f142c, this.f154x);
            ?? r3 = this.f142c;
            this.f144d = new Player(r3, new C0051b());
            this.f144d.resetPos();
            if (this.f142c != null) {
                this.f143r.m24a(this.f142c);
            }
            r02 = this.f150g;
            ?? r32 = r3;
            if (r02 != 0) {
                try {
                    r02 = this;
                    r32 = 16;
                    r3 = 16;
                    r02.f152v = new Cursor(16, 16, 0, 0, 1, intBufferCreateIntBuffer, (IntBuffer) null);
                } catch (LWJGLException e4) {
                    r02.printStackTrace();
                    r32 = r3;
                }
            }
            r02 = "Post startup";
            m58d("Post startup");
            long jCurrentTimeMillis = System.currentTimeMillis();
            ?? r03 = 0;
            int i2 = 0;
            while (true) {
                try {
                    r03 = this.f172L;
                    if (r03 == 0) {
                        return;
                    }
                    if (this.f151h) {
                        r03 = 100;
                        Thread.sleep(100L);
                    } else {
                        if (this.f149u == null && Display.isCloseRequested()) {
                            this.f172L = false;
                        }
                        try {
                            C0021c c0021c = this.f141q;
                            long jNanoTime = System.nanoTime();
                            long j = jNanoTime - c0021c.f105b;
                            c0021c.f105b = jNanoTime;
                            if (j < 0) {
                                j = 0;
                            }
                            if (j > 1000000000) {
                                j = 1000000000;
                            }
                            int i3 = 1315859240;
                            c0021c.f109f += ((j * c0021c.f108e) * c0021c.f104a) / 1.0E9f;
                            c0021c.f106c = (int) c0021c.f109f;
                            if (c0021c.f106c > 100) {
                                c0021c.f106c = 100;
                            }
                            c0021c.f109f -= c0021c.f106c;
                            c0021c.f107d = c0021c.f109f;
                            for (int i4 = 0; i4 < this.f141q.f106c; i4++) {
                                this.f160C++;
                                m64f();
                            }
                            m58d("Pre render");
                            float f = this.f141q.f107d;
                            if (!Display.isActive()) {
                                m62d();
                            }
                            if (this.f174N) {
                                int dx = 0;
                                int dy = 0;
                                if (!this.f150g) {
                                    dx = Mouse.getDX();
                                    dy = Mouse.getDY();
                                } else if (this.f149u != null) {
                                    Point locationOnScreen = this.f149u.getLocationOnScreen();
                                    int i5 = locationOnScreen.x + (this.f137a / 2);
                                    int i6 = locationOnScreen.y + (this.f138b / 2);
                                    Point location = MouseInfo.getPointerInfo().getLocation();
                                    dx = location.x - i5;
                                    dy = -(location.y - i6);
                                    this.f163D.mouseMove(i5, i6);
                                } else {
                                    Mouse.setCursorPosition(this.f137a / 2, this.f138b / 2);
                                }
                                int i7 = this.f153w;
                                this.f144d.turn(dx, dy * i7);
                                i3 = i7;
                            }
                            int i8 = i3;
                            if (!this.f186m) {
                                if (this.f142c != null) {
                                    m67b(f);
                                    m69i();
                                    m58d("Rendered gui");
                                    i = i3;
                                } else {
                                    GL11.glViewport(0, 0, this.f137a, this.f138b);
                                    i = 0;
                                    GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                                    GL11.glClear(16640);
                                    GL11.glMatrixMode(5889);
                                    GL11.glLoadIdentity();
                                    GL11.glMatrixMode(5888);
                                    GL11.glLoadIdentity();
                                    m68h();
                                }
                                if (this.f157z != null) {
                                    int i9 = (this.f137a * 240) / this.f138b;
                                    int i10 = (this.f138b * 240) / this.f138b;
                                    this.f157z.mo38a((Mouse.getX() * i9) / this.f137a, (i10 - ((Mouse.getY() * i10) / this.f138b)) - 1);
                                }
                                Display.update();
                                i8 = i;
                            }
                            m58d("Post render");
                            i2++;
                            r32 = i8;
                        } catch (Exception e5) {
                            m57a(new C0018h("Client error", "The game broke! [" + e5 + "]"));
                            r32 = "Client error";
                        }
                        while (true) {
                            r03 = (System.currentTimeMillis() > (jCurrentTimeMillis + 1000) ? 1 : (System.currentTimeMillis() == (jCurrentTimeMillis + 1000) ? 0 : -1));
                            if (r03 >= 0) {
                                this.f173M = i2 + " fps, " + C0008f.f48a + " chunk updates";
                                C0008f.f48a = 0;
                                jCurrentTimeMillis += 1000;
                                i2 = 0;
                            }
                        }
                    }
                } catch (Exception e6) {
                    r03.printStackTrace();
                    return;
                } finally {
                    m59a();
                }
            }
        } catch (Exception e7) {
            r02.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e7.toString(), "Failed to start Minecraft", 0);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m60b() {
        this.f172L = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX INFO: renamed from: c */
    public final void m61c() {
        if (this.f174N) {
            return;
        }
        this.f174N = true;
        LWJGLException lWJGLException = this.f150g;
        if (lWJGLException != 0) {
            try {
                Mouse.setNativeCursor(this.f152v);
                lWJGLException = this.f137a / 2;
                Mouse.setCursorPosition((int) lWJGLException, this.f138b / 2);
            } catch (LWJGLException e) {
                lWJGLException.printStackTrace();
            }
        } else {
            Mouse.setGrabbed(true);
        }
        m57a((C0014d) null);
        this.f175O = this.f160C + 10000;
    }

    /* JADX INFO: renamed from: d */
    private void m62d() {
        m57a(new C0013c());
    }

    /* JADX INFO: renamed from: e */
    private void m63e() {
        if (this.f179S == null) {
            return;
        }
        int i = this.f179S.f187a;
        int i2 = this.f179S.f188b;
        int i3 = this.f179S.f189c;
        if (this.f156y != 0) {
            if (this.f179S.f190d == 0) {
                i2--;
            }
            if (this.f179S.f190d == 1) {
                i2++;
            }
            if (this.f179S.f190d == 2) {
                i3--;
            }
            if (this.f179S.f190d == 3) {
                i3++;
            }
            if (this.f179S.f190d == 4) {
                i--;
            }
            if (this.f179S.f190d == 5) {
                i++;
            }
        }
        C0030a c0030a = C0030a.f197a[this.f142c.getTile(i, i2, i3)];
        if (this.f156y == 0) {
            boolean tile = this.f142c.setTile(i, i2, i3, 0);
            if (c0030a == null || !tile) {
                return;
            }
            if (m65g()) {
                this.f164l.m126a(i, i2, i3, this.f156y, this.f145s);
            }
            c0030a.m108a(this.f142c, i, i2, i3, this.f146t);
            return;
        }
        C0030a c0030a2 = C0030a.f197a[this.f142c.getTile(i, i2, i3)];
        if (c0030a2 == null || c0030a2 == C0030a.f207j || c0030a2 == C0030a.f208k || c0030a2 == C0030a.f209l || c0030a2 == C0030a.f210m) {
            AABB aabbMo103b = C0030a.f197a[this.f145s].mo103b(i, i2, i3);
            if (aabbMo103b != null) {
                if (!(this.f144d.f17bb.intersects(aabbMo103b) ? false : this.f142c.isFree(aabbMo103b))) {
                    return;
                }
            }
            if (m65g()) {
                this.f164l.m126a(i, i2, i3, this.f156y, this.f145s);
            }
            this.f142c.setTile(i, i2, i3, this.f145s);
            C0030a.f197a[this.f145s].mo111b(this.f142c, i, i2, i3);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m64f() {
        int length;
        int i = 0;
        while (i < this.f165E.size()) {
            C0010b c0010b = (C0010b) this.f165E.get(i);
            int i2 = c0010b.f73b;
            c0010b.f73b = i2 + 1;
            if (i2 >= this.f141q.f104a * 10.0f) {
                int i3 = i;
                i--;
                this.f165E.remove(i3);
            }
            i++;
        }
        if (this.f164l != null) {
            C0048c c0048c = this.f164l;
            if (c0048c.f282b.f0a) {
                try {
                    c0048c.f282b.m1b();
                } catch (Exception e) {
                    c0048c.f283c.m57a(new C0018h("Disconnected!", "You've lost connection to the server"));
                    c0048c.f283c.f186m = false;
                    e.printStackTrace();
                    c0048c.f282b.m0a();
                    c0048c.f283c.f164l = null;
                }
            }
            C0048c c0048c2 = this.f164l;
            Player player = this.f144d;
            c0048c2.f282b.m2a(C0046a.f263i, -1, Integer.valueOf((int) (player.f11x * 32.0f)), Integer.valueOf((int) (player.f12y * 32.0f)), Integer.valueOf((int) (player.f13z * 32.0f)), Integer.valueOf(((int) ((player.yRot * 256.0f) / 360.0f)) & 255), Integer.valueOf(((int) ((player.xRot * 256.0f) / 360.0f)) & 255));
        }
        if (this.f157z == null) {
            while (Mouse.next()) {
                int eventDWheel = Mouse.getEventDWheel();
                if (eventDWheel != 0) {
                    int i4 = eventDWheel;
                    if (i4 > 0) {
                        i4 = 1;
                    }
                    if (i4 < 0) {
                        i4 = -1;
                    }
                    int i5 = 0;
                    for (int i6 = 0; i6 < f166F.length; i6++) {
                        if (f166F[i6] == this.f145s) {
                            i5 = i6;
                        }
                    }
                    int i7 = i5;
                    int length2 = i4;
                    while (true) {
                        length = i7 + length2;
                        if (length >= 0) {
                            break;
                        }
                        i7 = length;
                        length2 = f166F.length;
                    }
                    while (length >= f166F.length) {
                        length -= f166F.length;
                    }
                    this.f145s = f166F[length];
                }
                if (this.f174N || !Mouse.getEventButtonState()) {
                    if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                        m63e();
                        this.f175O = this.f160C;
                    }
                    if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                        this.f156y = (this.f156y + 1) % 2;
                    }
                    if (Mouse.getEventButton() == 2 && Mouse.getEventButtonState() && this.f179S != null) {
                        int tile = this.f142c.getTile(this.f179S.f187a, this.f179S.f188b, this.f179S.f189c);
                        int i8 = tile;
                        if (tile == C0030a.f201d.f219v) {
                            i8 = C0030a.f202e.f219v;
                        }
                        for (int i9 = 0; i9 < f166F.length; i9++) {
                            if (i8 == f166F[i9]) {
                                this.f145s = f166F[i9];
                            }
                        }
                    }
                } else {
                    m61c();
                }
            }
            while (Keyboard.next()) {
                this.f144d.setKey(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    if (Keyboard.getEventKey() == 1) {
                        m62d();
                    }
                    if (Keyboard.getEventKey() == 19) {
                        this.f144d.resetPos();
                    }
                    if (Keyboard.getEventKey() == 28) {
                        this.f142c.setSpawnPos((int) this.f144d.f11x, (int) this.f144d.f12y, (int) this.f144d.f13z, this.f144d.yRot);
                        this.f144d.resetPos();
                    }
                    for (int i10 = 0; i10 < 9; i10++) {
                        if (Keyboard.getEventKey() == i10 + 2) {
                            this.f145s = f166F[i10];
                        }
                    }
                    if (Keyboard.getEventKey() == 21) {
                        this.f153w = -this.f153w;
                    }
                    if (Keyboard.getEventKey() == 34 && this.f164l == null && this.f142c.entities.size() < 256) {
                        this.f142c.entities.add(new Zombie(this.f142c, this.f144d.f11x, this.f144d.f12y, this.f144d.f13z));
                    }
                    if (Keyboard.getEventKey() == 33) {
                        C0009g c0009g = this.f143r;
                        c0009g.f60d = (c0009g.f60d + 1) % 4;
                    }
                    if (Keyboard.getEventKey() == 20) {
                        this.f144d.releaseAllKeys();
                        m57a(new C0012b());
                    }
                }
            }
            if (Mouse.isButtonDown(0) && this.f160C - this.f175O >= this.f141q.f104a / 4.0f && this.f174N) {
                m63e();
                this.f175O = this.f160C;
            }
        } else {
            this.f175O = this.f160C + 10000;
        }
        if (this.f157z != null) {
            this.f157z.m44d();
            if (this.f157z != null) {
                this.f157z.mo35c();
            }
        }
        if (this.f142c != null) {
            this.f143r.f68h++;
            this.f142c.tickEntities();
            if (!m65g()) {
                this.f142c.tick();
            }
            C0049a c0049a = this.f146t;
            int i11 = 0;
            while (i11 < c0049a.f290a.size()) {
                Particle particle = (Particle) c0049a.f290a.get(i11);
                particle.tick();
                if (particle.removed) {
                    int i12 = i11;
                    i11--;
                    c0049a.f290a.remove(i12);
                }
                i11++;
            }
            this.f144d.tick();
        }
    }

    /* JADX INFO: renamed from: g */
    private boolean m65g() {
        return this.f164l != null;
    }

    /* JADX INFO: renamed from: a */
    private void m66a(float f) {
        GL11.glTranslatef(0.0f, 0.0f, -0.3f);
        GL11.glRotatef(this.f144d.xRotO + ((this.f144d.xRot - this.f144d.xRotO) * f), 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this.f144d.yRotO + ((this.f144d.yRot - this.f144d.yRotO) * f), 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-(this.f144d.f8xo + ((this.f144d.f11x - this.f144d.f8xo) * f)), -(this.f144d.f9yo + ((this.f144d.f12y - this.f144d.f9yo) * f)), -(this.f144d.f10zo + ((this.f144d.f13z - this.f144d.f10zo) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0391  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m67b(float r11) {
        /*
            Method dump skipped, instruction units count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mojang.minecraft.RunnableC0027d.m67b(float):void");
    }

    /* JADX INFO: renamed from: h */
    private void m68h() {
        int i = (this.f137a * 240) / this.f138b;
        int i2 = (this.f138b * 240) / this.f138b;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, i, i2, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    /* JADX INFO: renamed from: i */
    private void m69i() {
        int i = (this.f137a * 240) / this.f138b;
        int i2 = (this.f138b * 240) / this.f138b;
        m68h();
        m58d("GUI: Init");
        GL11.glPushMatrix();
        GL11.glTranslatef(i - 16, 16.0f, -50.0f);
        C0005c c0005c = C0005c.f35a;
        GL11.glScalef(16.0f, 16.0f, 16.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-1.5f, 0.5f, 0.5f);
        GL11.glScalef(-1.0f, -1.0f, -1.0f);
        GL11.glBindTexture(3553, this.f154x.m4a("/terrain.png", 9728));
        GL11.glEnable(3553);
        c0005c.m7b();
        C0030a.f197a[this.f145s].mo94a(c0005c, this.f142c, 0, -2, 0, 0);
        c0005c.m5a();
        GL11.glDisable(3553);
        GL11.glPopMatrix();
        m58d("GUI: Draw selected");
        this.f155i.m47a("0.0.16a_02", 2, 2, 16777215);
        this.f155i.m47a(this.f173M, 2, 12, 16777215);
        for (int i3 = 0; i3 < this.f165E.size(); i3++) {
            this.f155i.m47a(((C0010b) this.f165E.get(i3)).f72a, 2, (((i2 - 4) - (this.f165E.size() << 3)) + (i3 << 3)) - 16, 16777215);
        }
        m58d("GUI: Draw text");
        int i4 = i / 2;
        int i5 = i2 / 2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        c0005c.m7b();
        c0005c.m11b(i4 + 1, i5 - 4, 0.0f);
        c0005c.m11b(i4, i5 - 4, 0.0f);
        c0005c.m11b(i4, i5 + 5, 0.0f);
        c0005c.m11b(i4 + 1, i5 + 5, 0.0f);
        c0005c.m11b(i4 + 5, i5, 0.0f);
        c0005c.m11b(i4 - 4, i5, 0.0f);
        c0005c.m11b(i4 - 4, i5 + 1, 0.0f);
        c0005c.m11b(i4 + 5, i5 + 1, 0.0f);
        c0005c.m5a();
        m58d("GUI: Draw crosshair");
    }

    /* JADX INFO: renamed from: j */
    private void m70j() {
        GL11.glFog(2918, m71a(this.f169I, this.f170J, this.f171K, 1.0f));
        C0030a c0030a = C0030a.f197a[this.f142c.getTile((int) this.f144d.f11x, (int) (this.f144d.f12y + 0.12f), (int) this.f144d.f13z)];
        if (c0030a == null || c0030a.mo109d() == C0045a.f248a) {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, this.f176P);
            GL11.glLightModel(2899, m71a(1.0f, 1.0f, 1.0f, 1.0f));
        } else {
            C0045a c0045aMo109d = c0030a.mo109d();
            GL11.glFogi(2917, 2048);
            if (c0045aMo109d == C0045a.f249b) {
                GL11.glFogf(2914, 0.1f);
                GL11.glLightModel(2899, m71a(0.4f, 0.4f, 0.9f, 1.0f));
            } else if (c0045aMo109d == C0045a.f250c) {
                GL11.glFogf(2914, 2.0f);
                GL11.glLightModel(2899, m71a(0.4f, 0.3f, 0.3f, 1.0f));
            }
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
        GL11.glEnable(2896);
    }

    /* JADX INFO: renamed from: a */
    private FloatBuffer m71a(float f, float f2, float f3, float f4) {
        this.f183W.clear();
        this.f183W.put(f).put(f2).put(f3).put(1.0f);
        this.f183W.flip();
        return this.f183W;
    }

    /* JADX INFO: renamed from: a */
    public final void m72a(String str) {
        this.f184X = str;
        int i = (this.f137a * 240) / this.f138b;
        int i2 = (this.f138b * 240) / this.f138b;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, i, i2, 0.0d, 100.0d, 300.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    /* JADX INFO: renamed from: b */
    public final void m73b(String str) {
        this.f185Y = str;
        m74a(-1);
    }

    /* JADX INFO: renamed from: a */
    public final void m74a(int i) {
        int i2 = (this.f137a * 240) / this.f138b;
        int i3 = (this.f138b * 240) / this.f138b;
        GL11.glClear(16640);
        C0005c c0005c = C0005c.f35a;
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, this.f154x.m4a("/dirt.png", 9728));
        c0005c.m7b();
        c0005c.m12a(4210752);
        c0005c.m10a(0.0f, i3, 0.0f, 0.0f, i3 / 32.0f);
        c0005c.m10a(i2, i3, 0.0f, i2 / 32.0f, i3 / 32.0f);
        c0005c.m10a(i2, 0.0f, 0.0f, i2 / 32.0f, 0.0f);
        c0005c.m10a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        c0005c.m5a();
        if (i >= 0) {
            int i4 = (i2 / 2) - 50;
            int i5 = (i3 / 2) + 16;
            GL11.glDisable(3553);
            c0005c.m7b();
            c0005c.m12a(8421504);
            c0005c.m11b(i4, i5, 0.0f);
            c0005c.m11b(i4, i5 + 2, 0.0f);
            c0005c.m11b(i4 + 100, i5 + 2, 0.0f);
            c0005c.m11b(i4 + 100, i5, 0.0f);
            c0005c.m12a(8454016);
            c0005c.m11b(i4, i5, 0.0f);
            c0005c.m11b(i4, i5 + 2, 0.0f);
            c0005c.m11b(i4 + i, i5 + 2, 0.0f);
            c0005c.m11b(i4 + i, i5, 0.0f);
            c0005c.m5a();
            GL11.glEnable(3553);
        }
        this.f155i.m47a(this.f184X, (i2 - this.f155i.m50a(this.f184X)) / 2, ((i3 / 2) - 4) - 16, 16777215);
        this.f155i.m47a(this.f185Y, (i2 - this.f155i.m50a(this.f185Y)) / 2, ((i3 / 2) - 4) + 8, 16777215);
        Display.update();
        try {
            Thread.yield();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m75b(int i) {
        m78a(this.f159B.m115a(this.f147e != null ? this.f147e.f18a : "anonymous", 128 << i, 128 << i, 64));
    }

    /* JADX INFO: renamed from: a */
    public final boolean m76a(int i, String str) {
        return this.f158A.m85a(this.f142c, this.f148f, this.f147e.f18a, this.f147e.f19b, str, i);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m77b(String str, int i) {
        Level levelM86a = this.f158A.m86a(this.f148f, str, i);
        if (!(levelM86a != null)) {
            return false;
        }
        m78a(levelM86a);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m78a(Level level) {
        this.f142c = level;
        if (this.f143r != null) {
            this.f143r.m24a(level);
        }
        if (this.f146t != null) {
            this.f146t.f290a.clear();
        }
        if (this.f144d != null) {
            this.f144d.setLevel(level);
            this.f144d.resetPos();
        }
        System.gc();
    }

    /* JADX INFO: renamed from: c */
    public final void m79c(String str) {
        this.f165E.add(new C0010b(str));
        while (this.f165E.size() > 8) {
            this.f165E.remove(0);
        }
    }
}
