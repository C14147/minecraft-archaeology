package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/AWTGLCanvas.class */
public class AWTGLCanvas extends Canvas implements DrawableLWJGL, ComponentListener, HierarchyListener {
    private static final long serialVersionUID = 1;
    private static final AWTCanvasImplementation implementation;
    private boolean update_context;
    private Object SYNC_LOCK;
    private final PixelFormat pixel_format;
    private final Drawable drawable;
    private final ContextAttribs attribs;
    private PeerInfo peer_info;
    private ContextGL context;
    private int reentry_count;
    private boolean first_run;

    static {
        Sys.initialize();
        implementation = createImplementation();
    }

    static AWTCanvasImplementation createImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                return new LinuxCanvasImplementation();
            case 2:
                return new MacOSXCanvasImplementation();
            case 3:
                return new WindowsCanvasImplementation();
            default:
                throw new IllegalStateException("Unsupported platform");
        }
    }

    private void setUpdate() {
        synchronized (this.SYNC_LOCK) {
            this.update_context = true;
        }
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public PixelFormatLWJGL getPixelFormat() {
        return this.pixel_format;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public ContextGL getContext() {
        return this.context;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public ContextGL createSharedContext() throws LWJGLException {
        ContextGL contextGL;
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            contextGL = new ContextGL(this.peer_info, this.context.getContextAttribs(), this.context);
        }
        return contextGL;
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void checkGLError() {
        Util.checkGLError();
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void initContext(float r, float g, float b) {
        GL11.glClearColor(r, g, b, 0.0f);
        GL11.glClear(16384);
    }

    public AWTGLCanvas() throws LWJGLException {
        this(new PixelFormat());
    }

    public AWTGLCanvas(PixelFormat pixel_format) throws LWJGLException {
        this(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(), pixel_format);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        this(device, pixel_format, null);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable) throws LWJGLException {
        this(device, pixel_format, drawable, null);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable, ContextAttribs attribs) throws LWJGLException {
        super(implementation.findConfiguration(device, pixel_format));
        this.SYNC_LOCK = new Object();
        if (pixel_format == null) {
            throw new NullPointerException("Pixel format must be non-null");
        }
        addHierarchyListener(this);
        addComponentListener(this);
        this.drawable = drawable;
        this.pixel_format = pixel_format;
        this.attribs = attribs;
    }

    public void addNotify() {
        super.addNotify();
    }

    public void removeNotify() {
        synchronized (this.SYNC_LOCK) {
            destroy();
            super.removeNotify();
        }
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void setSwapInterval(int swap_interval) {
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            ContextGL.setSwapInterval(swap_interval);
        }
    }

    public void setVSyncEnabled(boolean enabled) {
        setSwapInterval(enabled ? 1 : 0);
    }

    @Override // org.lwjgl.opengl.DrawableLWJGL
    public void swapBuffers() throws LWJGLException {
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            ContextGL.swapBuffers();
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public boolean isCurrent() throws LWJGLException {
        boolean zIsCurrent;
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            zIsCurrent = this.context.isCurrent();
        }
        return zIsCurrent;
    }

    @Override // org.lwjgl.opengl.Drawable
    public void makeCurrent() throws LWJGLException {
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            this.context.makeCurrent();
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public void releaseContext() throws LWJGLException {
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            if (this.context.isCurrent()) {
                this.context.releaseCurrent();
            }
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public final void destroy() {
        synchronized (this.SYNC_LOCK) {
            try {
                if (this.context != null) {
                    this.context.forceDestroy();
                    this.context = null;
                    this.reentry_count = 0;
                    this.peer_info.destroy();
                    this.peer_info = null;
                }
            } catch (LWJGLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // org.lwjgl.opengl.Drawable
    public final void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
        synchronized (this.SYNC_LOCK) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            this.context.setCLSharingProperties(properties);
        }
    }

    protected void initGL() {
    }

    protected void paintGL() {
    }

    /* JADX WARN: Finally extract failed */
    public final void paint(Graphics g) {
        LWJGLException exception = null;
        synchronized (this.SYNC_LOCK) {
            if (isDisplayable()) {
                try {
                    if (this.peer_info == null) {
                        this.peer_info = implementation.createPeerInfo(this, this.pixel_format, this.attribs);
                    }
                    this.peer_info.lockAndGetHandle();
                } catch (LWJGLException e) {
                    exception = e;
                }
                try {
                    if (this.context == null) {
                        this.context = new ContextGL(this.peer_info, this.attribs, this.drawable != null ? (ContextGL) ((DrawableLWJGL) this.drawable).getContext() : null);
                        this.first_run = true;
                    }
                    if (this.reentry_count == 0) {
                        this.context.makeCurrent();
                    }
                    this.reentry_count++;
                    try {
                        if (this.update_context) {
                            this.context.update();
                            this.update_context = false;
                        }
                        if (this.first_run) {
                            this.first_run = false;
                            initGL();
                        }
                        paintGL();
                        this.reentry_count--;
                        if (this.reentry_count == 0) {
                            this.context.releaseCurrent();
                        }
                        this.peer_info.unlock();
                        if (exception != null) {
                            exceptionOccurred(exception);
                        }
                    } catch (Throwable th) {
                        this.reentry_count--;
                        if (this.reentry_count == 0) {
                            this.context.releaseCurrent();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.peer_info.unlock();
                    throw th2;
                }
            }
        }
    }

    protected void exceptionOccurred(LWJGLException exception) {
        LWJGLUtil.log("Unhandled exception occurred, skipping paint(): " + exception);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        setUpdate();
    }

    public void componentMoved(ComponentEvent e) {
        setUpdate();
    }

    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        setUpdate();
    }

    public void setLocation(Point p) {
        super.setLocation(p);
        setUpdate();
    }

    public void setSize(Dimension d) {
        super.setSize(d);
        setUpdate();
    }

    public void setSize(int width, int height) {
        super.setSize(width, height);
        setUpdate();
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        setUpdate();
    }

    public void hierarchyChanged(HierarchyEvent e) {
        setUpdate();
    }
}
