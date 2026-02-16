package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashSet;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/Display.class */
public final class Display {
    private static final DisplayImplementation display_impl;
    private static final DisplayMode initial_mode;
    private static Canvas parent;
    private static DisplayMode current_mode;
    private static ByteBuffer[] cached_icons;
    private static boolean fullscreen;
    private static int swap_interval;
    private static DrawableLWJGL drawable;
    private static boolean window_created;
    private static boolean parent_resized;
    private static boolean window_resized;
    private static boolean window_resizable;
    private static float r;
    private static float g;
    private static float b;
    private static final Thread shutdown_hook = new Thread() { // from class: org.lwjgl.opengl.Display.1
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Display.reset();
        }
    };
    private static int x = -1;
    private static int y = -1;
    private static int width = 0;
    private static int height = 0;
    private static String title = "Game";
    private static final ComponentListener component_listener = new ComponentAdapter() { // from class: org.lwjgl.opengl.Display.2
        public void componentResized(ComponentEvent e) {
            synchronized (GlobalLock.lock) {
                boolean unused = Display.parent_resized = true;
            }
        }
    };

    static {
        Sys.initialize();
        display_impl = createDisplayImplementation();
        try {
            DisplayMode displayModeInit = display_impl.init();
            initial_mode = displayModeInit;
            current_mode = displayModeInit;
            LWJGLUtil.log("Initial mode: " + initial_mode);
        } catch (LWJGLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Drawable getDrawable() {
        return drawable;
    }

    private static DisplayImplementation createDisplayImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                return new LinuxDisplay();
            case 2:
                return new MacOSXDisplay();
            case 3:
                return new WindowsDisplay();
            default:
                throw new IllegalStateException("Unsupported platform");
        }
    }

    private Display() {
    }

    public static DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        synchronized (GlobalLock.lock) {
            DisplayMode[] unfilteredModes = display_impl.getAvailableDisplayModes();
            if (unfilteredModes == null) {
                return new DisplayMode[0];
            }
            HashSet<DisplayMode> modes = new HashSet<>(unfilteredModes.length);
            modes.addAll(Arrays.asList(unfilteredModes));
            DisplayMode[] filteredModes = new DisplayMode[modes.size()];
            modes.toArray(filteredModes);
            LWJGLUtil.log("Removed " + (unfilteredModes.length - filteredModes.length) + " duplicate displaymodes");
            return filteredModes;
        }
    }

    public static DisplayMode getDesktopDisplayMode() {
        return initial_mode;
    }

    public static DisplayMode getDisplayMode() {
        return current_mode;
    }

    public static void setDisplayMode(DisplayMode mode) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (mode == null) {
                throw new NullPointerException("mode must be non-null");
            }
            boolean was_fullscreen = isFullscreen();
            current_mode = mode;
            if (isCreated()) {
                destroyWindow();
                if (was_fullscreen) {
                    try {
                        if (!isFullscreen()) {
                            display_impl.resetDisplayMode();
                        }
                        createWindow();
                        makeCurrentAndSetSwapInterval();
                    } catch (LWJGLException e) {
                        drawable.destroy();
                        display_impl.resetDisplayMode();
                        throw e;
                    }
                }
                if (isFullscreen()) {
                    switchDisplayMode();
                }
                createWindow();
                makeCurrentAndSetSwapInterval();
            }
        }
    }

    private static DisplayMode getEffectiveMode() {
        return (isFullscreen() || parent == null) ? current_mode : new DisplayMode(parent.getWidth(), parent.getHeight());
    }

    private static int getWindowX() {
        if (!isFullscreen() && parent == null) {
            if (x == -1) {
                return Math.max(0, (initial_mode.getWidth() - current_mode.getWidth()) / 2);
            }
            return x;
        }
        return 0;
    }

    private static int getWindowY() {
        if (!isFullscreen() && parent == null) {
            if (y == -1) {
                return Math.max(0, (initial_mode.getHeight() - current_mode.getHeight()) / 2);
            }
            return y;
        }
        return 0;
    }

    private static void createWindow() throws LWJGLException {
        if (window_created) {
            return;
        }
        Canvas tmp_parent = isFullscreen() ? null : parent;
        if (tmp_parent != null && !tmp_parent.isDisplayable()) {
            throw new LWJGLException("Parent.isDisplayable() must be true");
        }
        if (tmp_parent != null) {
            tmp_parent.addComponentListener(component_listener);
        }
        DisplayMode mode = getEffectiveMode();
        display_impl.createWindow(drawable, mode, tmp_parent, getWindowX(), getWindowY());
        window_created = true;
        width = getDisplayMode().getWidth();
        height = getDisplayMode().getHeight();
        setTitle(title);
        initControls();
        if (cached_icons != null) {
            setIcon(cached_icons);
        } else {
            setIcon(new ByteBuffer[]{LWJGLUtil.LWJGLIcon32x32, LWJGLUtil.LWJGLIcon16x16});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseDrawable() {
        try {
            Context context = drawable.getContext();
            if (context != null && context.isCurrent()) {
                context.releaseCurrent();
                context.releaseDrawable();
            }
        } catch (LWJGLException e) {
            LWJGLUtil.log("Exception occurred while trying to release context: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyWindow() {
        if (!window_created) {
            return;
        }
        if (parent != null) {
            parent.removeComponentListener(component_listener);
        }
        releaseDrawable();
        if (Mouse.isCreated()) {
            Mouse.destroy();
        }
        if (Keyboard.isCreated()) {
            Keyboard.destroy();
        }
        display_impl.destroyWindow();
        window_created = false;
    }

    private static void switchDisplayMode() throws LWJGLException {
        if (!current_mode.isFullscreenCapable()) {
            throw new IllegalStateException("Only modes acquired from getAvailableDisplayModes() can be used for fullscreen display");
        }
        display_impl.switchDisplayMode(current_mode);
    }

    public static void setDisplayConfiguration(float gamma, float brightness, float contrast) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new LWJGLException("Display not yet created.");
            }
            if (brightness < -1.0f || brightness > 1.0f) {
                throw new IllegalArgumentException("Invalid brightness value");
            }
            if (contrast < 0.0f) {
                throw new IllegalArgumentException("Invalid contrast value");
            }
            int rampSize = display_impl.getGammaRampLength();
            if (rampSize == 0) {
                throw new LWJGLException("Display configuration not supported");
            }
            FloatBuffer gammaRamp = BufferUtils.createFloatBuffer(rampSize);
            for (int i = 0; i < rampSize; i++) {
                float intensity = i / (rampSize - 1);
                float rampEntry = (((((float) Math.pow(intensity, gamma)) + brightness) - 0.5f) * contrast) + 0.5f;
                if (rampEntry > 1.0f) {
                    rampEntry = 1.0f;
                } else if (rampEntry < 0.0f) {
                    rampEntry = 0.0f;
                }
                gammaRamp.put(i, rampEntry);
            }
            display_impl.setGammaRamp(gammaRamp);
            LWJGLUtil.log("Gamma set, gamma = " + gamma + ", brightness = " + brightness + ", contrast = " + contrast);
        }
    }

    public static void sync(int fps) {
        Sync.sync(fps);
    }

    public static String getTitle() {
        String str;
        synchronized (GlobalLock.lock) {
            str = title;
        }
        return str;
    }

    public static Canvas getParent() {
        Canvas canvas;
        synchronized (GlobalLock.lock) {
            canvas = parent;
        }
        return canvas;
    }

    public static void setParent(Canvas parent2) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (parent != parent2) {
                parent = parent2;
                if (!isCreated()) {
                    return;
                }
                destroyWindow();
                try {
                    if (isFullscreen()) {
                        switchDisplayMode();
                    } else {
                        display_impl.resetDisplayMode();
                    }
                    createWindow();
                    makeCurrentAndSetSwapInterval();
                } catch (LWJGLException e) {
                    drawable.destroy();
                    display_impl.resetDisplayMode();
                    throw e;
                }
            }
        }
    }

    public static void setFullscreen(boolean fullscreen2) throws LWJGLException {
        setDisplayModeAndFullscreenInternal(fullscreen2, current_mode);
    }

    public static void setDisplayModeAndFullscreen(DisplayMode mode) throws LWJGLException {
        setDisplayModeAndFullscreenInternal(mode.isFullscreenCapable(), mode);
    }

    private static void setDisplayModeAndFullscreenInternal(boolean fullscreen2, DisplayMode mode) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (mode == null) {
                throw new NullPointerException("mode must be non-null");
            }
            DisplayMode old_mode = current_mode;
            current_mode = mode;
            boolean was_fullscreen = isFullscreen();
            fullscreen = fullscreen2;
            if (was_fullscreen != isFullscreen() || !mode.equals(old_mode)) {
                if (!isCreated()) {
                    return;
                }
                destroyWindow();
                try {
                    if (isFullscreen()) {
                        switchDisplayMode();
                    } else {
                        display_impl.resetDisplayMode();
                    }
                    createWindow();
                    makeCurrentAndSetSwapInterval();
                } catch (LWJGLException e) {
                    drawable.destroy();
                    display_impl.resetDisplayMode();
                    throw e;
                }
            }
        }
    }

    public static boolean isFullscreen() {
        boolean z;
        synchronized (GlobalLock.lock) {
            z = fullscreen && current_mode.isFullscreenCapable();
        }
        return z;
    }

    public static void setTitle(String newTitle) {
        synchronized (GlobalLock.lock) {
            if (newTitle == null) {
                newTitle = "";
            }
            title = newTitle;
            if (isCreated()) {
                display_impl.setTitle(title);
            }
        }
    }

    public static boolean isCloseRequested() {
        boolean zIsCloseRequested;
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Cannot determine close requested state of uncreated window");
            }
            zIsCloseRequested = display_impl.isCloseRequested();
        }
        return zIsCloseRequested;
    }

    public static boolean isVisible() {
        boolean zIsVisible;
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Cannot determine minimized state of uncreated window");
            }
            zIsVisible = display_impl.isVisible();
        }
        return zIsVisible;
    }

    public static boolean isActive() {
        boolean zIsActive;
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Cannot determine focused state of uncreated window");
            }
            zIsActive = display_impl.isActive();
        }
        return zIsActive;
    }

    public static boolean isDirty() {
        boolean zIsDirty;
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Cannot determine dirty state of uncreated window");
            }
            zIsDirty = display_impl.isDirty();
        }
        return zIsDirty;
    }

    public static void processMessages() {
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Display not created");
            }
            display_impl.update();
        }
        pollDevices();
    }

    public static void swapBuffers() throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Display not created");
            }
            if (LWJGLUtil.DEBUG) {
                drawable.checkGLError();
            }
            drawable.swapBuffers();
        }
    }

    public static void update() {
        update(true);
    }

    public static void update(boolean processMessages) {
        synchronized (GlobalLock.lock) {
            if (!isCreated()) {
                throw new IllegalStateException("Display not created");
            }
            if (display_impl.isVisible() || display_impl.isDirty()) {
                try {
                    swapBuffers();
                } catch (LWJGLException e) {
                    throw new RuntimeException(e);
                }
            }
            window_resized = !isFullscreen() && parent == null && display_impl.wasResized();
            if (window_resized) {
                width = display_impl.getWidth();
                height = display_impl.getHeight();
            }
            if (parent_resized) {
                reshape();
                parent_resized = false;
                window_resized = true;
            }
            if (processMessages) {
                processMessages();
            }
        }
    }

    static void pollDevices() {
        if (Mouse.isCreated()) {
            Mouse.poll();
            Mouse.updateCursor();
        }
        if (Keyboard.isCreated()) {
            Keyboard.poll();
        }
        if (Controllers.isCreated()) {
            Controllers.poll();
        }
    }

    public static void releaseContext() throws LWJGLException {
        drawable.releaseContext();
    }

    public static boolean isCurrent() throws LWJGLException {
        return drawable.isCurrent();
    }

    public static void makeCurrent() throws LWJGLException {
        drawable.makeCurrent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeShutdownHook() {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.Display.3
            @Override // java.security.PrivilegedAction
            public Object run() {
                Runtime.getRuntime().removeShutdownHook(Display.shutdown_hook);
                return null;
            }
        });
    }

    private static void registerShutdownHook() {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.Display.4
            @Override // java.security.PrivilegedAction
            public Object run() {
                Runtime.getRuntime().addShutdownHook(Display.shutdown_hook);
                return null;
            }
        });
    }

    public static void create() throws LWJGLException {
        create(new PixelFormat());
    }

    public static void create(PixelFormat pixel_format) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, (Drawable) null, (ContextAttribs) null);
        }
    }

    public static void create(PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, shared_drawable, (ContextAttribs) null);
        }
    }

    public static void create(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, (Drawable) null, attribs);
        }
    }

    public static void create(PixelFormat pixel_format, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (isCreated()) {
                throw new IllegalStateException("Only one LWJGL context may be instantiated at any one time.");
            }
            if (pixel_format == null) {
                throw new NullPointerException("pixel_format cannot be null");
            }
            removeShutdownHook();
            registerShutdownHook();
            if (isFullscreen()) {
                switchDisplayMode();
            }
            DrawableGL drawable2 = new DrawableGL() { // from class: org.lwjgl.opengl.Display.5
                @Override // org.lwjgl.opengl.DrawableGL, org.lwjgl.opengl.Drawable
                public void destroy() {
                    synchronized (GlobalLock.lock) {
                        if (Display.isCreated()) {
                            Display.releaseDrawable();
                            super.destroy();
                            Display.destroyWindow();
                            int unused = Display.x = Display.y = -1;
                            ByteBuffer[] unused2 = Display.cached_icons = null;
                            Display.reset();
                            Display.removeShutdownHook();
                        }
                    }
                }
            };
            drawable = drawable2;
            try {
                drawable2.setPixelFormat(pixel_format, attribs);
                try {
                    createWindow();
                    try {
                        drawable2.context = new ContextGL(drawable2.peer_info, attribs, shared_drawable != null ? ((DrawableGL) shared_drawable).getContext() : null);
                        try {
                            makeCurrentAndSetSwapInterval();
                            initContext();
                        } catch (LWJGLException e) {
                            drawable2.destroy();
                            throw e;
                        }
                    } catch (LWJGLException e2) {
                        destroyWindow();
                        throw e2;
                    }
                } catch (LWJGLException e3) {
                    drawable2.destroy();
                    throw e3;
                }
            } catch (LWJGLException e4) {
                display_impl.resetDisplayMode();
                throw e4;
            }
        }
    }

    public static void create(PixelFormatLWJGL pixel_format) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, (Drawable) null, (org.lwjgl.opengles.ContextAttribs) null);
        }
    }

    public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, shared_drawable, (org.lwjgl.opengles.ContextAttribs) null);
        }
    }

    public static void create(PixelFormatLWJGL pixel_format, org.lwjgl.opengles.ContextAttribs attribs) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            create(pixel_format, (Drawable) null, attribs);
        }
    }

    public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable, org.lwjgl.opengles.ContextAttribs attribs) throws LWJGLException {
        synchronized (GlobalLock.lock) {
            if (isCreated()) {
                throw new IllegalStateException("Only one LWJGL context may be instantiated at any one time.");
            }
            if (pixel_format == null) {
                throw new NullPointerException("pixel_format cannot be null");
            }
            removeShutdownHook();
            registerShutdownHook();
            if (isFullscreen()) {
                switchDisplayMode();
            }
            DrawableGLES drawable2 = new DrawableGLES() { // from class: org.lwjgl.opengl.Display.6
                @Override // org.lwjgl.opengl.DrawableLWJGL
                public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs2) throws LWJGLException {
                    throw new UnsupportedOperationException();
                }

                @Override // org.lwjgl.opengl.DrawableGLES, org.lwjgl.opengl.Drawable
                public void destroy() {
                    synchronized (GlobalLock.lock) {
                        if (Display.isCreated()) {
                            Display.releaseDrawable();
                            super.destroy();
                            Display.destroyWindow();
                            int unused = Display.x = Display.y = -1;
                            ByteBuffer[] unused2 = Display.cached_icons = null;
                            Display.reset();
                            Display.removeShutdownHook();
                        }
                    }
                }
            };
            drawable = drawable2;
            try {
                drawable2.setPixelFormat(pixel_format);
                try {
                    createWindow();
                    try {
                        drawable2.createContext(attribs, shared_drawable);
                        try {
                            makeCurrentAndSetSwapInterval();
                            initContext();
                        } catch (LWJGLException e) {
                            drawable2.destroy();
                            throw e;
                        }
                    } catch (LWJGLException e2) {
                        destroyWindow();
                        throw e2;
                    }
                } catch (LWJGLException e3) {
                    drawable2.destroy();
                    throw e3;
                }
            } catch (LWJGLException e4) {
                display_impl.resetDisplayMode();
                throw e4;
            }
        }
    }

    public static void setInitialBackground(float red, float green, float blue) {
        r = red;
        g = green;
        b = blue;
    }

    private static void makeCurrentAndSetSwapInterval() throws LWJGLException {
        makeCurrent();
        try {
            drawable.checkGLError();
        } catch (OpenGLException e) {
            LWJGLUtil.log("OpenGL error during context creation: " + e.getMessage());
        }
        setSwapInterval(swap_interval);
    }

    private static void initContext() {
        drawable.initContext(r, g, b);
        update();
    }

    static DisplayImplementation getImplementation() {
        return display_impl;
    }

    static boolean getPrivilegedBoolean(final String property_name) {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: org.lwjgl.opengl.Display.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean(property_name));
            }
        })).booleanValue();
    }

    static String getPrivilegedString(final String property_name) {
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.lwjgl.opengl.Display.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty(property_name);
            }
        });
    }

    private static void initControls() {
        if (!getPrivilegedBoolean("org.lwjgl.opengl.Display.noinput")) {
            if (!Mouse.isCreated() && !getPrivilegedBoolean("org.lwjgl.opengl.Display.nomouse")) {
                try {
                    Mouse.create();
                } catch (LWJGLException e) {
                    if (LWJGLUtil.DEBUG) {
                        e.printStackTrace(System.err);
                    } else {
                        LWJGLUtil.log("Failed to create Mouse: " + e);
                    }
                }
            }
            if (!Keyboard.isCreated() && !getPrivilegedBoolean("org.lwjgl.opengl.Display.nokeyboard")) {
                try {
                    Keyboard.create();
                } catch (LWJGLException e2) {
                    if (LWJGLUtil.DEBUG) {
                        e2.printStackTrace(System.err);
                    } else {
                        LWJGLUtil.log("Failed to create Keyboard: " + e2);
                    }
                }
            }
        }
    }

    public static void destroy() {
        if (isCreated()) {
            drawable.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reset() {
        display_impl.resetDisplayMode();
        current_mode = initial_mode;
    }

    public static boolean isCreated() {
        boolean z;
        synchronized (GlobalLock.lock) {
            z = window_created;
        }
        return z;
    }

    public static void setSwapInterval(int value) {
        synchronized (GlobalLock.lock) {
            swap_interval = value;
            if (isCreated()) {
                drawable.setSwapInterval(swap_interval);
            }
        }
    }

    public static void setVSyncEnabled(boolean sync) {
        synchronized (GlobalLock.lock) {
            setSwapInterval(sync ? 1 : 0);
        }
    }

    public static void setLocation(int new_x, int new_y) {
        synchronized (GlobalLock.lock) {
            x = new_x;
            y = new_y;
            if (isCreated() && !isFullscreen()) {
                reshape();
            }
        }
    }

    private static void reshape() {
        DisplayMode mode = getEffectiveMode();
        display_impl.reshape(getWindowX(), getWindowY(), mode.getWidth(), mode.getHeight());
    }

    public static String getAdapter() {
        String adapter;
        synchronized (GlobalLock.lock) {
            adapter = display_impl.getAdapter();
        }
        return adapter;
    }

    public static String getVersion() {
        String version;
        synchronized (GlobalLock.lock) {
            version = display_impl.getVersion();
        }
        return version;
    }

    public static int setIcon(ByteBuffer[] icons) {
        synchronized (GlobalLock.lock) {
            if (cached_icons != icons) {
                cached_icons = new ByteBuffer[icons.length];
                for (int i = 0; i < icons.length; i++) {
                    cached_icons[i] = BufferUtils.createByteBuffer(icons[i].capacity());
                    int old_position = icons[i].position();
                    cached_icons[i].put(icons[i]);
                    icons[i].position(old_position);
                    cached_icons[i].flip();
                }
            }
            if (isCreated() && parent == null) {
                return display_impl.setIcon(cached_icons);
            }
            return 0;
        }
    }

    public static void setResizable(boolean resizable) {
        window_resizable = resizable;
        if (isCreated()) {
            display_impl.setResizable(resizable);
        }
    }

    public static boolean isResizable() {
        return window_resizable;
    }

    public static boolean wasResized() {
        return window_resized;
    }

    public static int getX() {
        if (isFullscreen()) {
            return 0;
        }
        if (parent != null) {
            return parent.getX();
        }
        return display_impl.getX();
    }

    public static int getY() {
        if (isFullscreen()) {
            return 0;
        }
        if (parent != null) {
            return parent.getY();
        }
        return display_impl.getY();
    }

    public static int getWidth() {
        if (isFullscreen()) {
            return getDisplayMode().getWidth();
        }
        if (parent != null) {
            return parent.getWidth();
        }
        return width;
    }

    public static int getHeight() {
        if (isFullscreen()) {
            return getDisplayMode().getHeight();
        }
        if (parent != null) {
            return parent.getHeight();
        }
        return height;
    }

    public static float getPixelScaleFactor() {
        return display_impl.getPixelScaleFactor();
    }
}
