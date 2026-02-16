package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Robot;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/MacOSXDisplay.class */
final class MacOSXDisplay implements DisplayImplementation {
    private static final int PBUFFER_HANDLE_SIZE = 24;
    private static final int GAMMA_LENGTH = 256;
    private Canvas canvas;
    private Robot robot;
    private MacOSXMouseEventQueue mouse_queue;
    private KeyboardEventQueue keyboard_queue;
    private DisplayMode requested_mode;
    private MacOSXNativeMouse mouse;
    private MacOSXNativeKeyboard keyboard;
    private ByteBuffer window;
    private ByteBuffer context;
    private static final IntBuffer current_viewport = BufferUtils.createIntBuffer(16);
    private boolean mouseInsideWindow;
    private boolean close_requested;
    private boolean skipViewportValue = false;
    private boolean native_mode = true;
    private boolean updateNativeCursor = false;
    private long currentNativeCursor = 0;
    private boolean enableHighDPI = false;
    private float scaleFactor = 1.0f;

    private native ByteBuffer nCreateWindow(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private native Object nGetCurrentDisplayMode();

    private native void nGetDisplayModes(Object obj);

    private native boolean nIsMiniaturized(ByteBuffer byteBuffer);

    private native boolean nIsFocused(ByteBuffer byteBuffer);

    private native void nSetResizable(ByteBuffer byteBuffer, boolean z);

    private native void nResizeWindow(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    private native boolean nWasResized(ByteBuffer byteBuffer);

    private native int nGetX(ByteBuffer byteBuffer);

    private native int nGetY(ByteBuffer byteBuffer);

    private native int nGetWidth(ByteBuffer byteBuffer);

    private native int nGetHeight(ByteBuffer byteBuffer);

    private native boolean nIsNativeMode(ByteBuffer byteBuffer);

    public native void nDestroyCALayer(ByteBuffer byteBuffer);

    public native void nDestroyWindow(ByteBuffer byteBuffer);

    @Override // org.lwjgl.opengl.DisplayImplementation
    public native void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException;

    private native void restoreGamma();

    private native void nSetTitle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    MacOSXDisplay() {
    }

    private static boolean isUndecorated() {
        return Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated");
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void createWindow(DrawableLWJGL drawable, DisplayMode mode, Canvas parent, int x, int y) throws LWJGLException {
        boolean fullscreen = Display.isFullscreen();
        boolean resizable = Display.isResizable();
        boolean parented = (parent == null || fullscreen) ? false : true;
        boolean enableFullscreenModeAPI = LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 7) && parent == null && !Display.getPrivilegedBoolean("org.lwjgl.opengl.Display.disableOSXFullscreenModeAPI");
        this.enableHighDPI = LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 7) && parent == null && (Display.getPrivilegedBoolean("org.lwjgl.opengl.Display.enableHighDPI") || fullscreen);
        if (parented) {
            this.canvas = parent;
        } else {
            this.canvas = null;
        }
        this.close_requested = false;
        DrawableGL gl_drawable = (DrawableGL) Display.getDrawable();
        PeerInfo peer_info = gl_drawable.peer_info;
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        ByteBuffer window_handle = parented ? ((MacOSXCanvasPeerInfo) peer_info).window_handle : this.window;
        try {
            try {
                this.window = nCreateWindow(x, y, mode.getWidth(), mode.getHeight(), fullscreen, isUndecorated(), resizable, parented, enableFullscreenModeAPI, this.enableHighDPI, peer_handle, window_handle);
                if (fullscreen) {
                    this.skipViewportValue = true;
                    current_viewport.put(2, mode.getWidth());
                    current_viewport.put(3, mode.getHeight());
                }
                this.native_mode = nIsNativeMode(peer_handle);
                if (!this.native_mode) {
                    this.robot = AWTUtil.createRobot(this.canvas);
                }
            } catch (LWJGLException e) {
                destroyWindow();
                throw e;
            }
        } finally {
            peer_info.unlock();
        }
    }

    public void doHandleQuit() {
        synchronized (this) {
            this.close_requested = true;
        }
    }

    public void mouseInsideWindow(boolean inside) {
        synchronized (this) {
            this.mouseInsideWindow = inside;
        }
        this.updateNativeCursor = true;
    }

    public void setScaleFactor(float scale) {
        synchronized (this) {
            this.scaleFactor = scale;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void destroyWindow() {
        if (!this.native_mode) {
            DrawableGL gl_drawable = (DrawableGL) Display.getDrawable();
            PeerInfo peer_info = gl_drawable.peer_info;
            if (peer_info != null) {
                ByteBuffer peer_handle = peer_info.getHandle();
                nDestroyCALayer(peer_handle);
            }
            this.robot = null;
        }
        nDestroyWindow(this.window);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getGammaRampLength() {
        return 256;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getAdapter() {
        return null;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getVersion() {
        return null;
    }

    private static boolean equals(DisplayMode mode1, DisplayMode mode2) {
        return mode1.getWidth() == mode2.getWidth() && mode1.getHeight() == mode2.getHeight() && mode1.getBitsPerPixel() == mode2.getBitsPerPixel() && mode1.getFrequency() == mode2.getFrequency();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void switchDisplayMode(DisplayMode mode) throws LWJGLException {
        DisplayMode[] modes = getAvailableDisplayModes();
        for (DisplayMode available_mode : modes) {
            if (equals(available_mode, mode)) {
                this.requested_mode = available_mode;
                return;
            }
        }
        throw new LWJGLException(mode + " is not supported");
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void resetDisplayMode() {
        this.requested_mode = null;
        restoreGamma();
    }

    public Object createDisplayMode(int width, int height, int bitsPerPixel, int refreshRate) {
        return new DisplayMode(width, height, bitsPerPixel, refreshRate);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public DisplayMode init() throws LWJGLException {
        return (DisplayMode) nGetCurrentDisplayMode();
    }

    public void addDisplayMode(Object modesList, int width, int height, int bitsPerPixel, int refreshRate) {
        List<DisplayMode> modes = (List) modesList;
        DisplayMode displayMode = new DisplayMode(width, height, bitsPerPixel, refreshRate);
        modes.add(displayMode);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        List<DisplayMode> modes = new ArrayList<>();
        nGetDisplayModes(modes);
        modes.add(Display.getDesktopDisplayMode());
        return (DisplayMode[]) modes.toArray(new DisplayMode[modes.size()]);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setTitle(String title) {
        ByteBuffer buffer = MemoryUtil.encodeUTF8(title);
        nSetTitle(this.window, buffer);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isCloseRequested() {
        boolean result;
        synchronized (this) {
            result = this.close_requested;
            this.close_requested = false;
        }
        return result;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isVisible() {
        return true;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isActive() {
        if (this.native_mode) {
            return nIsFocused(this.window);
        }
        return Display.getParent().hasFocus();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isDirty() {
        return false;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPeerInfo(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        try {
            return new MacOSXDisplayPeerInfo(pixel_format, attribs, true);
        } catch (LWJGLException e) {
            return new MacOSXDisplayPeerInfo(pixel_format, attribs, false);
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void update() {
        DrawableGL drawable = (DrawableGL) Display.getDrawable();
        if (1 != 0) {
            if (this.skipViewportValue) {
                this.skipViewportValue = false;
            } else {
                GL11.glGetInteger(GL11.GL_VIEWPORT, current_viewport);
            }
            drawable.context.update();
            GL11.glViewport(current_viewport.get(0), current_viewport.get(1), current_viewport.get(2), current_viewport.get(3));
        }
        if (this.native_mode && this.updateNativeCursor) {
            this.updateNativeCursor = false;
            try {
                setNativeCursor(Long.valueOf(this.currentNativeCursor));
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void reshape(int x, int y, int width, int height) {
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public boolean hasWheel() {
        return AWTUtil.hasWheel();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getButtonCount() {
        return AWTUtil.getButtonCount();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createMouse() throws LWJGLException {
        if (this.native_mode) {
            this.mouse = new MacOSXNativeMouse(this, this.window);
            this.mouse.register();
        } else {
            this.mouse_queue = new MacOSXMouseEventQueue(this.canvas);
            this.mouse_queue.register();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyMouse() {
        if (this.native_mode) {
            try {
                MacOSXNativeMouse.setCursor(0L);
            } catch (LWJGLException e) {
            }
            grabMouse(false);
            if (this.mouse != null) {
                this.mouse.unregister();
            }
            this.mouse = null;
            return;
        }
        if (this.mouse_queue != null) {
            MacOSXMouseEventQueue.nGrabMouse(false);
            this.mouse_queue.unregister();
        }
        this.mouse_queue = null;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons_buffer) {
        if (this.native_mode) {
            this.mouse.poll(coord_buffer, buttons_buffer);
        } else {
            this.mouse_queue.poll(coord_buffer, buttons_buffer);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readMouse(ByteBuffer buffer) {
        if (this.native_mode) {
            this.mouse.copyEvents(buffer);
        } else {
            this.mouse_queue.copyEvents(buffer);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void grabMouse(boolean grab) {
        if (this.native_mode) {
            this.mouse.setGrabbed(grab);
        } else {
            this.mouse_queue.setGrabbed(grab);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getNativeCursorCapabilities() {
        if (this.native_mode) {
            return 7;
        }
        return AWTUtil.getNativeCursorCapabilities();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setCursorPosition(int x, int y) {
        if (this.native_mode && this.mouse != null) {
            this.mouse.setCursorPosition(x, y);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setNativeCursor(Object handle) throws LWJGLException {
        if (this.native_mode) {
            this.currentNativeCursor = getCursorHandle(handle);
            if (Display.isCreated()) {
                if (!this.mouseInsideWindow) {
                    MacOSXNativeMouse.setCursor(0L);
                } else {
                    MacOSXNativeMouse.setCursor(this.currentNativeCursor);
                }
            }
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMinCursorSize() {
        return 1;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMaxCursorSize() {
        DisplayMode dm = Display.getDesktopDisplayMode();
        return Math.min(dm.getWidth(), dm.getHeight()) / 2;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createKeyboard() throws LWJGLException {
        if (this.native_mode) {
            this.keyboard = new MacOSXNativeKeyboard(this.window);
            this.keyboard.register();
        } else {
            this.keyboard_queue = new KeyboardEventQueue(this.canvas);
            this.keyboard_queue.register();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyKeyboard() {
        if (this.native_mode) {
            if (this.keyboard != null) {
                this.keyboard.unregister();
            }
            this.keyboard = null;
        } else {
            if (this.keyboard_queue != null) {
                this.keyboard_queue.unregister();
            }
            this.keyboard_queue = null;
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollKeyboard(ByteBuffer keyDownBuffer) {
        if (this.native_mode) {
            this.keyboard.poll(keyDownBuffer);
        } else {
            this.keyboard_queue.poll(keyDownBuffer);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readKeyboard(ByteBuffer buffer) {
        if (this.native_mode) {
            this.keyboard.copyEvents(buffer);
        } else {
            this.keyboard_queue.copyEvents(buffer);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        if (this.native_mode) {
            long cursor = MacOSXNativeMouse.createCursor(width, height, xHotspot, yHotspot, numImages, images, delays);
            return Long.valueOf(cursor);
        }
        return AWTUtil.createCursor(width, height, xHotspot, yHotspot, numImages, images, delays);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyCursor(Object cursor_handle) {
        long handle = getCursorHandle(cursor_handle);
        if (this.currentNativeCursor == handle) {
            this.currentNativeCursor = 0L;
        }
        MacOSXNativeMouse.destroyCursor(handle);
    }

    private static long getCursorHandle(Object cursor_handle) {
        if (cursor_handle != null) {
            return ((Long) cursor_handle).longValue();
        }
        return 0L;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getPbufferCapabilities() {
        return 1;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isBufferLost(PeerInfo handle) {
        return false;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, ContextAttribs attribs, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        return new MacOSXPbufferPeerInfo(width, height, pixel_format, attribs);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setPbufferAttrib(PeerInfo handle, int attrib, int value) {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void bindTexImageToPbuffer(PeerInfo handle, int buffer) {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void releaseTexImageFromPbuffer(PeerInfo handle, int buffer) {
        throw new UnsupportedOperationException();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int setIcon(ByteBuffer[] icons) {
        return 0;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getX() {
        return nGetX(this.window);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getY() {
        return nGetY(this.window);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getWidth() {
        return nGetWidth(this.window);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getHeight() {
        return nGetHeight(this.window);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public boolean isInsideWindow() {
        return this.mouseInsideWindow;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setResizable(boolean resizable) {
        nSetResizable(this.window, resizable);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean wasResized() {
        return nWasResized(this.window);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public float getPixelScaleFactor() {
        if (!this.enableHighDPI || Display.isFullscreen()) {
            return 1.0f;
        }
        return this.scaleFactor;
    }
}
