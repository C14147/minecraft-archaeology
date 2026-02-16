package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.SwingUtilities;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.input.Mouse;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsDisplay.class */
final class WindowsDisplay implements DisplayImplementation {
    private static final int GAMMA_LENGTH = 256;
    private static final int WM_WINDOWPOSCHANGED = 71;
    private static final int WM_MOVE = 3;
    private static final int WM_CANCELMODE = 31;
    private static final int WM_MOUSEMOVE = 512;
    private static final int WM_LBUTTONDOWN = 513;
    private static final int WM_LBUTTONUP = 514;
    private static final int WM_LBUTTONDBLCLK = 515;
    private static final int WM_RBUTTONDOWN = 516;
    private static final int WM_RBUTTONUP = 517;
    private static final int WM_RBUTTONDBLCLK = 518;
    private static final int WM_MBUTTONDOWN = 519;
    private static final int WM_MBUTTONUP = 520;
    private static final int WM_MBUTTONDBLCLK = 521;
    private static final int WM_XBUTTONDOWN = 523;
    private static final int WM_XBUTTONUP = 524;
    private static final int WM_XBUTTONDBLCLK = 525;
    private static final int WM_MOUSEWHEEL = 522;
    private static final int WM_CAPTURECHANGED = 533;
    private static final int WM_MOUSELEAVE = 675;
    private static final int WM_ENTERSIZEMOVE = 561;
    private static final int WM_EXITSIZEMOVE = 562;
    private static final int WM_SIZING = 532;
    private static final int WM_KEYDOWN = 256;
    private static final int WM_KEYUP = 257;
    private static final int WM_SYSKEYUP = 261;
    private static final int WM_SYSKEYDOWN = 260;
    private static final int WM_SYSCHAR = 262;
    private static final int WM_CHAR = 258;
    private static final int WM_GETICON = 127;
    private static final int WM_SETICON = 128;
    private static final int WM_SETCURSOR = 32;
    private static final int WM_MOUSEACTIVATE = 33;
    private static final int WM_QUIT = 18;
    private static final int WM_SYSCOMMAND = 274;
    private static final int WM_PAINT = 15;
    private static final int WM_KILLFOCUS = 8;
    private static final int WM_SETFOCUS = 7;
    private static final int SC_SIZE = 61440;
    private static final int SC_MOVE = 61456;
    private static final int SC_MINIMIZE = 61472;
    private static final int SC_MAXIMIZE = 61488;
    private static final int SC_NEXTWINDOW = 61504;
    private static final int SC_PREVWINDOW = 61520;
    private static final int SC_CLOSE = 61536;
    private static final int SC_VSCROLL = 61552;
    private static final int SC_HSCROLL = 61568;
    private static final int SC_MOUSEMENU = 61584;
    private static final int SC_KEYMENU = 61696;
    private static final int SC_ARRANGE = 61712;
    private static final int SC_RESTORE = 61728;
    private static final int SC_TASKLIST = 61744;
    private static final int SC_SCREENSAVE = 61760;
    private static final int SC_HOTKEY = 61776;
    private static final int SC_DEFAULT = 61792;
    private static final int SC_MONITORPOWER = 61808;
    private static final int SC_CONTEXTHELP = 61824;
    private static final int SC_SEPARATOR = 61455;
    static final int SM_CXCURSOR = 13;
    static final int SM_CYCURSOR = 14;
    static final int SM_CMOUSEBUTTONS = 43;
    static final int SM_MOUSEWHEELPRESENT = 75;
    private static final int SIZE_RESTORED = 0;
    private static final int SIZE_MINIMIZED = 1;
    private static final int SIZE_MAXIMIZED = 2;
    private static final int WM_SIZE = 5;
    private static final int WM_ACTIVATE = 6;
    private static final int WA_INACTIVE = 0;
    private static final int WA_ACTIVE = 1;
    private static final int WA_CLICKACTIVE = 2;
    private static final int SW_NORMAL = 1;
    private static final int SW_SHOWMINNOACTIVE = 7;
    private static final int SW_SHOWDEFAULT = 10;
    private static final int SW_RESTORE = 9;
    private static final int SW_MAXIMIZE = 3;
    private static final int ICON_SMALL = 0;
    private static final int ICON_BIG = 1;
    private static final IntBuffer rect_buffer = BufferUtils.createIntBuffer(4);
    private static final Rect rect = new Rect();
    private static final long HWND_TOP = 0;
    private static final long HWND_BOTTOM = 1;
    private static final long HWND_TOPMOST = -1;
    private static final long HWND_NOTOPMOST = -2;
    private static final int SWP_NOSIZE = 1;
    private static final int SWP_NOMOVE = 2;
    private static final int SWP_NOZORDER = 4;
    private static final int SWP_FRAMECHANGED = 32;
    private static final int GWL_STYLE = -16;
    private static final int GWL_EXSTYLE = -20;
    private static final int WS_THICKFRAME = 262144;
    private static final int WS_MAXIMIZEBOX = 65536;
    private static final int HTCLIENT = 1;
    private static final int MK_XBUTTON1 = 32;
    private static final int MK_XBUTTON2 = 64;
    private static final int XBUTTON1 = 1;
    private static final int XBUTTON2 = 2;
    private static WindowsDisplay current_display;
    private static boolean cursor_clipped;
    private WindowsDisplayPeerInfo peer_info;
    private Object current_cursor;
    private static boolean hasParent;
    private Canvas parent;
    private long parent_hwnd;
    private FocusAdapter parent_focus_tracker;
    private AtomicBoolean parent_focused;
    private WindowsKeyboard keyboard;
    private WindowsMouse mouse;
    private boolean close_requested;
    private boolean is_dirty;
    private ByteBuffer current_gamma;
    private ByteBuffer saved_gamma;
    private DisplayMode current_mode;
    private boolean mode_set;
    private boolean isMinimized;
    private boolean isFocused;
    private boolean redoMakeContextCurrent;
    private boolean inAppActivate;
    private boolean resized;
    private boolean resizable;
    private int x;
    private int y;
    private int width;
    private int height;
    private long hwnd;
    private long hdc;
    private long small_icon;
    private long large_icon;
    private boolean iconsLoaded;
    private int captureMouse = -1;
    private boolean mouseInside;

    private static native long nCreateWindow(int i, int i2, int i3, int i4, boolean z, boolean z2, long j) throws LWJGLException;

    private static native void nReleaseDC(long j, long j2);

    private static native void nDestroyWindow(long j);

    private static native void clipCursor(IntBuffer intBuffer) throws LWJGLException;

    private static native void nSwitchDisplayMode(DisplayMode displayMode) throws LWJGLException;

    private static native void showWindow(long j, int i);

    private static native void setForegroundWindow(long j);

    private static native void setFocus(long j);

    private static native void nResetDisplayMode();

    private static native ByteBuffer convertToNativeRamp(FloatBuffer floatBuffer) throws LWJGLException;

    private static native ByteBuffer getCurrentGammaRamp() throws LWJGLException;

    private static native void nSetGammaRamp(ByteBuffer byteBuffer) throws LWJGLException;

    private native WindowsFileVersion nGetVersion(String str);

    private static native DisplayMode getCurrentDisplayMode() throws LWJGLException;

    private static native void nSetTitle(long j, long j2);

    private static native void nUpdate();

    private static native void nReshape(long j, int i, int i2, int i3, int i4, boolean z, boolean z2);

    @Override // org.lwjgl.opengl.DisplayImplementation
    public native DisplayMode[] getAvailableDisplayModes() throws LWJGLException;

    private static native void nSetCursorPosition(int i, int i2);

    static native void nSetNativeCursor(long j, Object obj) throws LWJGLException;

    static native int getSystemMetrics(int i);

    private static native long getDllInstance();

    private static native long getDC(long j);

    private static native long getDesktopWindow();

    private static native long getForegroundWindow();

    public static native ByteBuffer nCreateCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, int i6, IntBuffer intBuffer2, int i7) throws LWJGLException;

    static native void doDestroyCursor(Object obj);

    private native int nGetPbufferCapabilities(PixelFormat pixelFormat) throws LWJGLException;

    private static native long createIcon(int i, int i2, IntBuffer intBuffer);

    private static native void destroyIcon(long j);

    private static native long sendMessage(long j, long j2, long j3, long j4);

    private static native long setWindowLongPtr(long j, int i, long j2);

    private static native long getWindowLongPtr(long j, int i);

    private static native boolean setWindowPos(long j, long j2, int i, int i2, int i3, int i4, long j3);

    private static native long nSetCapture(long j);

    private static native boolean nReleaseCapture();

    private static native void getClientRect(long j, IntBuffer intBuffer);

    private static native void clientToScreen(long j, IntBuffer intBuffer);

    private static native void setWindowProc(Method method);

    private static native long defWindowProc(long j, int i, long j2, long j3);

    private native boolean getWindowRect(long j, IntBuffer intBuffer);

    private native boolean nTrackMouseEvent(long j);

    private native boolean adjustWindowRectEx(IntBuffer intBuffer, int i, boolean z, int i2);

    static {
        try {
            Method windowProc = WindowsDisplay.class.getDeclaredMethod("handleMessage", Long.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE, Long.TYPE);
            setWindowProc(windowProc);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    WindowsDisplay() {
        current_display = this;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void createWindow(DrawableLWJGL drawable, DisplayMode mode, Canvas parent, int x, int y) throws LWJGLException {
        this.parent = parent;
        hasParent = parent != null;
        this.parent_hwnd = parent != null ? getHwnd(parent) : HWND_TOP;
        this.hwnd = nCreateWindow(x, y, mode.getWidth(), mode.getHeight(), Display.isFullscreen() || isUndecorated(), parent != null, this.parent_hwnd);
        if (Display.isResizable() && parent == null) {
            setResizable(true);
        }
        if (this.hwnd == HWND_TOP) {
            throw new LWJGLException("Failed to create window");
        }
        this.hdc = getDC(this.hwnd);
        if (this.hdc == HWND_TOP) {
            nDestroyWindow(this.hwnd);
            throw new LWJGLException("Failed to get dc");
        }
        try {
            if (drawable instanceof DrawableGL) {
                int format = WindowsPeerInfo.choosePixelFormat(getHdc(), 0, 0, (PixelFormat) drawable.getPixelFormat(), null, true, true, false, true);
                WindowsPeerInfo.setPixelFormat(getHdc(), format);
            } else {
                this.peer_info = new WindowsDisplayPeerInfo(true);
                ((DrawableGLES) drawable).initialize(this.hwnd, this.hdc, 4, (org.lwjgl.opengles.PixelFormat) drawable.getPixelFormat());
            }
            this.peer_info.initDC(getHwnd(), getHdc());
            showWindow(getHwnd(), 10);
            updateWidthAndHeight();
            if (parent == null) {
                setForegroundWindow(getHwnd());
            } else {
                this.parent_focused = new AtomicBoolean(false);
                FocusAdapter focusAdapter = new FocusAdapter() { // from class: org.lwjgl.opengl.WindowsDisplay.1
                    public void focusGained(FocusEvent e) {
                        WindowsDisplay.this.parent_focused.set(true);
                        WindowsDisplay.this.clearAWTFocus();
                    }
                };
                this.parent_focus_tracker = focusAdapter;
                parent.addFocusListener(focusAdapter);
                SwingUtilities.invokeLater(new Runnable() { // from class: org.lwjgl.opengl.WindowsDisplay.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WindowsDisplay.this.clearAWTFocus();
                    }
                });
            }
            grabFocus();
        } catch (LWJGLException e) {
            nReleaseDC(this.hwnd, this.hdc);
            nDestroyWindow(this.hwnd);
            throw e;
        }
    }

    private void updateWidthAndHeight() {
        getClientRect(this.hwnd, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        this.width = rect.right - rect.left;
        this.height = rect.bottom - rect.top;
    }

    private static boolean isUndecorated() {
        return Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated");
    }

    private static long getHwnd(Canvas parent) throws LWJGLException {
        AWTCanvasImplementation awt_impl = AWTGLCanvas.createImplementation();
        WindowsPeerInfo parent_peer_info = (WindowsPeerInfo) awt_impl.createPeerInfo(parent, null, null);
        parent_peer_info.lockAndGetHandle();
        try {
            long hwnd = parent_peer_info.getHwnd();
            parent_peer_info.unlock();
            return hwnd;
        } catch (Throwable th) {
            parent_peer_info.unlock();
            throw th;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void destroyWindow() {
        if (this.parent != null) {
            this.parent.removeFocusListener(this.parent_focus_tracker);
            this.parent_focus_tracker = null;
        }
        nReleaseDC(this.hwnd, this.hdc);
        nDestroyWindow(this.hwnd);
        freeLargeIcon();
        freeSmallIcon();
        resetCursorClipping();
        this.close_requested = false;
        this.is_dirty = false;
        this.isMinimized = false;
        this.isFocused = false;
        this.redoMakeContextCurrent = false;
        this.mouseInside = false;
    }

    static void resetCursorClipping() {
        if (cursor_clipped) {
            try {
                clipCursor(null);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to reset cursor clipping: " + e);
            }
            cursor_clipped = false;
        }
    }

    private static void getGlobalClientRect(long hwnd, Rect rect2) {
        rect_buffer.put(0, 0).put(1, 0);
        clientToScreen(hwnd, rect_buffer);
        int offset_x = rect_buffer.get(0);
        int offset_y = rect_buffer.get(1);
        getClientRect(hwnd, rect_buffer);
        rect2.copyFromBuffer(rect_buffer);
        rect2.offset(offset_x, offset_y);
    }

    static void setupCursorClipping(long hwnd) throws LWJGLException {
        cursor_clipped = true;
        getGlobalClientRect(hwnd, rect);
        rect.copyToBuffer(rect_buffer);
        clipCursor(rect_buffer);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void switchDisplayMode(DisplayMode mode) throws LWJGLException {
        nSwitchDisplayMode(mode);
        this.current_mode = mode;
        this.mode_set = true;
    }

    private void appActivate(boolean active, long millis) {
        if (this.inAppActivate) {
            return;
        }
        this.inAppActivate = true;
        this.isFocused = active;
        if (active) {
            if (Display.isFullscreen()) {
                restoreDisplayMode();
            }
            if (this.parent == null) {
                setForegroundWindow(getHwnd());
            }
            setFocus(getHwnd());
            this.redoMakeContextCurrent = true;
            if (Display.isFullscreen()) {
                updateClipping();
            }
        } else {
            if (this.keyboard != null) {
                this.keyboard.releaseAll(millis);
            }
            if (Display.isFullscreen()) {
                showWindow(getHwnd(), 7);
                resetDisplayMode();
            } else {
                updateClipping();
            }
        }
        updateCursor();
        this.inAppActivate = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAWTFocus() {
        this.parent.setFocusable(false);
        this.parent.setFocusable(true);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
    }

    private void grabFocus() {
        if (this.parent == null) {
            setFocus(getHwnd());
        } else {
            SwingUtilities.invokeLater(new Runnable() { // from class: org.lwjgl.opengl.WindowsDisplay.3
                @Override // java.lang.Runnable
                public void run() {
                    WindowsDisplay.this.parent.requestFocus();
                }
            });
        }
    }

    private void restoreDisplayMode() {
        try {
            doSetGammaRamp(this.current_gamma);
        } catch (LWJGLException e) {
            LWJGLUtil.log("Failed to restore gamma: " + e.getMessage());
        }
        if (!this.mode_set) {
            this.mode_set = true;
            try {
                nSwitchDisplayMode(this.current_mode);
            } catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to restore display mode: " + e2.getMessage());
            }
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void resetDisplayMode() {
        try {
            doSetGammaRamp(this.saved_gamma);
        } catch (LWJGLException e) {
            LWJGLUtil.log("Failed to reset gamma ramp: " + e.getMessage());
        }
        this.current_gamma = this.saved_gamma;
        if (this.mode_set) {
            this.mode_set = false;
            nResetDisplayMode();
        }
        resetCursorClipping();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getGammaRampLength() {
        return 256;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setGammaRamp(FloatBuffer gammaRamp) throws LWJGLException {
        doSetGammaRamp(convertToNativeRamp(gammaRamp));
    }

    private void doSetGammaRamp(ByteBuffer native_gamma) throws LWJGLException {
        nSetGammaRamp(native_gamma);
        this.current_gamma = native_gamma;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getAdapter() {
        try {
            String maxObjNo = WindowsRegistry.queryRegistrationKey(3, "HARDWARE\\DeviceMap\\Video", "MaxObjectNumber");
            int maxObjectNumber = maxObjNo.charAt(0);
            String vga_driver_value = "";
            for (int i = 0; i < maxObjectNumber; i++) {
                String adapter_string = WindowsRegistry.queryRegistrationKey(3, "HARDWARE\\DeviceMap\\Video", "\\Device\\Video" + i);
                if (adapter_string.toLowerCase().startsWith("\\registry\\machine\\")) {
                    String driver_value = WindowsRegistry.queryRegistrationKey(3, adapter_string.substring("\\registry\\machine\\".length()), "InstalledDisplayDrivers");
                    if (driver_value.toUpperCase().startsWith("VGA")) {
                        vga_driver_value = driver_value;
                    } else if (!driver_value.toUpperCase().startsWith("RDP") && !driver_value.toUpperCase().startsWith("NMNDD")) {
                        return driver_value;
                    }
                }
            }
            if (!vga_driver_value.equals("")) {
                return vga_driver_value;
            }
            return null;
        } catch (LWJGLException e) {
            LWJGLUtil.log("Exception occurred while querying registry: " + e);
            return null;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getVersion() {
        WindowsFileVersion version;
        String driver = getAdapter();
        if (driver != null) {
            String[] drivers = driver.split(",");
            if (drivers.length > 0 && (version = nGetVersion(drivers[0] + ".dll")) != null) {
                return version.toString();
            }
            return null;
        }
        return null;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public DisplayMode init() throws LWJGLException {
        ByteBuffer currentGammaRamp = getCurrentGammaRamp();
        this.saved_gamma = currentGammaRamp;
        this.current_gamma = currentGammaRamp;
        DisplayMode currentDisplayMode = getCurrentDisplayMode();
        this.current_mode = currentDisplayMode;
        return currentDisplayMode;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setTitle(String title) {
        ByteBuffer buffer = MemoryUtil.encodeUTF16(title);
        nSetTitle(this.hwnd, MemoryUtil.getAddress0(buffer));
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isCloseRequested() {
        boolean saved = this.close_requested;
        this.close_requested = false;
        return saved;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isVisible() {
        return !this.isMinimized;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isActive() {
        return this.isFocused;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isDirty() {
        boolean saved = this.is_dirty;
        this.is_dirty = false;
        return saved;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPeerInfo(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        this.peer_info = new WindowsDisplayPeerInfo(false);
        return this.peer_info;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void update() {
        nUpdate();
        if (!this.isFocused && this.parent != null && this.parent_focused.compareAndSet(true, false)) {
            setFocus(getHwnd());
        }
        if (this.redoMakeContextCurrent) {
            this.redoMakeContextCurrent = false;
            try {
                Context context = ((DrawableLWJGL) Display.getDrawable()).getContext();
                if (context != null && context.isCurrent()) {
                    context.makeCurrent();
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred while trying to make context current: " + e);
            }
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void reshape(int x, int y, int width, int height) {
        nReshape(getHwnd(), x, y, width, height, Display.isFullscreen() || isUndecorated(), this.parent != null);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public boolean hasWheel() {
        return this.mouse.hasWheel();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createMouse() throws LWJGLException {
        this.mouse = new WindowsMouse(getHwnd());
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyMouse() {
        if (this.mouse != null) {
            this.mouse.destroy();
        }
        this.mouse = null;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons) {
        this.mouse.poll(coord_buffer, buttons, this);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readMouse(ByteBuffer buffer) {
        this.mouse.read(buffer);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void grabMouse(boolean grab) {
        this.mouse.grab(grab, shouldGrab());
        updateCursor();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getNativeCursorCapabilities() {
        return 1;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setCursorPosition(int x, int y) {
        getGlobalClientRect(getHwnd(), rect);
        int transformed_x = rect.left + x;
        int transformed_y = (rect.bottom - 1) - y;
        nSetCursorPosition(transformed_x, transformed_y);
        setMousePosition(x, y);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setNativeCursor(Object handle) throws LWJGLException {
        this.current_cursor = handle;
        updateCursor();
    }

    private void updateCursor() {
        try {
            if (this.mouse != null && shouldGrab()) {
                nSetNativeCursor(getHwnd(), this.mouse.getBlankCursor());
            } else {
                nSetNativeCursor(getHwnd(), this.current_cursor);
            }
        } catch (LWJGLException e) {
            LWJGLUtil.log("Failed to update cursor: " + e);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMinCursorSize() {
        return getSystemMetrics(13);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMaxCursorSize() {
        return getSystemMetrics(13);
    }

    private long getHwnd() {
        return this.hwnd;
    }

    private long getHdc() {
        return this.hdc;
    }

    static void centerCursor(long hwnd) {
        if (getForegroundWindow() != hwnd && !hasParent) {
            return;
        }
        getGlobalClientRect(hwnd, rect);
        int local_offset_x = rect.left;
        int local_offset_y = rect.top;
        int center_x = (rect.left + rect.right) / 2;
        int center_y = (rect.top + rect.bottom) / 2;
        nSetCursorPosition(center_x, center_y);
        int local_x = center_x - local_offset_x;
        int local_y = center_y - local_offset_y;
        if (current_display != null) {
            current_display.setMousePosition(local_x, transformY(hwnd, local_y));
        }
    }

    private void setMousePosition(int x, int y) {
        if (this.mouse != null) {
            this.mouse.setPosition(x, y);
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createKeyboard() throws LWJGLException {
        this.keyboard = new WindowsKeyboard();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyKeyboard() {
        this.keyboard = null;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollKeyboard(ByteBuffer keyDownBuffer) {
        this.keyboard.poll(keyDownBuffer);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readKeyboard(ByteBuffer buffer) {
        this.keyboard.read(buffer);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        return doCreateCursor(width, height, xHotspot, yHotspot, numImages, images, delays);
    }

    static Object doCreateCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        return nCreateCursor(width, height, xHotspot, yHotspot, numImages, images, images.position(), delays, delays != null ? delays.position() : -1);
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyCursor(Object cursorHandle) {
        doDestroyCursor(cursorHandle);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getPbufferCapabilities() {
        try {
            return nGetPbufferCapabilities(new PixelFormat(0, 0, 0, 0, 0, 0, 0, 0, false));
        } catch (LWJGLException e) {
            LWJGLUtil.log("Exception occurred while determining pbuffer capabilities: " + e);
            return 0;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isBufferLost(PeerInfo handle) {
        return ((WindowsPbufferPeerInfo) handle).isBufferLost();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, ContextAttribs attribs, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        return new WindowsPbufferPeerInfo(width, height, pixel_format, pixelFormatCaps, pBufferAttribs);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setPbufferAttrib(PeerInfo handle, int attrib, int value) {
        ((WindowsPbufferPeerInfo) handle).setPbufferAttrib(attrib, value);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void bindTexImageToPbuffer(PeerInfo handle, int buffer) {
        ((WindowsPbufferPeerInfo) handle).bindTexImageToPbuffer(buffer);
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void releaseTexImageFromPbuffer(PeerInfo handle, int buffer) {
        ((WindowsPbufferPeerInfo) handle).releaseTexImageFromPbuffer(buffer);
    }

    private void freeSmallIcon() {
        if (this.small_icon != HWND_TOP) {
            destroyIcon(this.small_icon);
            this.small_icon = HWND_TOP;
        }
    }

    private void freeLargeIcon() {
        if (this.large_icon != HWND_TOP) {
            destroyIcon(this.large_icon);
            this.large_icon = HWND_TOP;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int setIcon(ByteBuffer[] icons) {
        boolean done_small = false;
        boolean done_large = false;
        int used = 0;
        for (ByteBuffer icon : icons) {
            int size = icon.limit() / 4;
            if (((int) Math.sqrt(size)) == 16 && !done_small) {
                long small_new_icon = createIcon(16, 16, icon.asIntBuffer());
                sendMessage(this.hwnd, 128L, HWND_TOP, small_new_icon);
                freeSmallIcon();
                this.small_icon = small_new_icon;
                used++;
                done_small = true;
            }
            if (((int) Math.sqrt(size)) == 32 && !done_large) {
                long large_new_icon = createIcon(32, 32, icon.asIntBuffer());
                sendMessage(this.hwnd, 128L, HWND_BOTTOM, large_new_icon);
                freeLargeIcon();
                this.large_icon = large_new_icon;
                used++;
                done_large = true;
                this.iconsLoaded = false;
                long time = System.nanoTime();
                while (true) {
                    nUpdate();
                    if (this.iconsLoaded || 500000000 < System.nanoTime() - time) {
                        break;
                    }
                    Thread.yield();
                }
            }
        }
        return used;
    }

    private void handleMouseButton(int button, int state, long millis) {
        if (this.mouse != null) {
            this.mouse.handleMouseButton((byte) button, (byte) state, millis);
            if (this.captureMouse == -1 && button != -1 && state == 1) {
                this.captureMouse = button;
                nSetCapture(this.hwnd);
            }
            if (this.captureMouse != -1 && button == this.captureMouse && state == 0) {
                this.captureMouse = -1;
                nReleaseCapture();
            }
        }
    }

    private boolean shouldGrab() {
        return !this.isMinimized && this.isFocused && Mouse.isGrabbed();
    }

    private void handleMouseScrolled(int amount, long millis) {
        if (this.mouse != null) {
            this.mouse.handleMouseScrolled(amount, millis);
        }
    }

    private void handleChar(long wParam, long lParam, long millis) {
        byte previous_state = (byte) ((lParam >>> 30) & HWND_BOTTOM);
        byte state = (byte) (HWND_BOTTOM - ((lParam >>> 31) & HWND_BOTTOM));
        boolean repeat = state == previous_state;
        if (this.keyboard != null) {
            this.keyboard.handleChar((int) (wParam & 65535), millis, repeat);
        }
    }

    private void handleKeyButton(long wParam, long lParam, long millis) {
        if (this.keyboard == null) {
            return;
        }
        byte previous_state = (byte) ((lParam >>> 30) & HWND_BOTTOM);
        byte state = (byte) (HWND_BOTTOM - ((lParam >>> 31) & HWND_BOTTOM));
        boolean repeat = state == previous_state;
        byte extended = (byte) ((lParam >>> 24) & HWND_BOTTOM);
        int scan_code = (int) ((lParam >>> 16) & 255);
        this.keyboard.handleKey((int) wParam, scan_code, extended != 0, state, millis, repeat);
    }

    private static int transformY(long hwnd, int y) {
        getClientRect(hwnd, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        return ((rect.bottom - rect.top) - 1) - y;
    }

    private static long handleMessage(long hwnd, int msg, long wParam, long lParam, long millis) {
        if (current_display != null) {
            return current_display.doHandleMessage(hwnd, msg, wParam, lParam, millis);
        }
        return defWindowProc(hwnd, msg, wParam, lParam);
    }

    private void updateClipping() {
        if ((Display.isFullscreen() || (this.mouse != null && this.mouse.isGrabbed())) && !this.isMinimized && this.isFocused && (getForegroundWindow() == getHwnd() || hasParent)) {
            try {
                setupCursorClipping(getHwnd());
                return;
            } catch (LWJGLException e) {
                LWJGLUtil.log("setupCursorClipping failed: " + e.getMessage());
                return;
            }
        }
        resetCursorClipping();
    }

    private void setMinimized(boolean m) {
        if (m != this.isMinimized) {
            this.isMinimized = m;
            updateClipping();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long doHandleMessage(long r10, int r12, long r13, long r15, long r17) {
        /*
            Method dump skipped, instruction units count: 969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.WindowsDisplay.doHandleMessage(long, int, long, long, long):long");
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getX() {
        return this.x;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getY() {
        return this.y;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getWidth() {
        return this.width;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getHeight() {
        return this.height;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public boolean isInsideWindow() {
        return this.mouseInside;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setResizable(boolean resizable) {
        if (this.resizable == resizable) {
            return;
        }
        this.resized = false;
        this.resizable = resizable;
        int style = (int) getWindowLongPtr(this.hwnd, -16);
        int styleex = (int) getWindowLongPtr(this.hwnd, GWL_EXSTYLE);
        long j = this.hwnd;
        int style2 = (!resizable || Display.isFullscreen()) ? style & (-327681) : style | 327680;
        setWindowLongPtr(j, -16, style2);
        getGlobalClientRect(this.hwnd, rect);
        rect.copyToBuffer(rect_buffer);
        adjustWindowRectEx(rect_buffer, style2, false, styleex);
        rect.copyFromBuffer(rect_buffer);
        setWindowPos(this.hwnd, HWND_TOP, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, 36L);
        updateWidthAndHeight();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean wasResized() {
        if (this.resized) {
            this.resized = false;
            return true;
        }
        return false;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public float getPixelScaleFactor() {
        return 1.0f;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/WindowsDisplay$Rect.class */
    private static final class Rect {
        public int left;
        public int top;
        public int right;
        public int bottom;

        private Rect() {
        }

        public void copyToBuffer(IntBuffer buffer) {
            buffer.put(0, this.left).put(1, this.top).put(2, this.right).put(3, this.bottom);
        }

        public void copyFromBuffer(IntBuffer buffer) {
            this.left = buffer.get(0);
            this.top = buffer.get(1);
            this.right = buffer.get(2);
            this.bottom = buffer.get(3);
        }

        public void offset(int offset_x, int offset_y) {
            this.left += offset_x;
            this.top += offset_y;
            this.right += offset_x;
            this.bottom += offset_y;
        }

        public static void intersect(Rect r1, Rect r2, Rect dst) {
            dst.left = Math.max(r1.left, r2.left);
            dst.top = Math.max(r1.top, r2.top);
            dst.right = Math.min(r1.right, r2.right);
            dst.bottom = Math.min(r1.bottom, r2.bottom);
        }

        public String toString() {
            return "Rect: left = " + this.left + " top = " + this.top + " right = " + this.right + " bottom = " + this.bottom + ", width: " + (this.right - this.left) + ", height: " + (this.bottom - this.top);
        }
    }
}
