package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.XRandR;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxDisplay.class */
final class LinuxDisplay implements DisplayImplementation {
    public static final int CurrentTime = 0;
    public static final int GrabSuccess = 0;
    public static final int AutoRepeatModeOff = 0;
    public static final int AutoRepeatModeOn = 1;
    public static final int AutoRepeatModeDefault = 2;
    public static final int None = 0;
    private static final int KeyPressMask = 1;
    private static final int KeyReleaseMask = 2;
    private static final int ButtonPressMask = 4;
    private static final int ButtonReleaseMask = 8;
    private static final int NotifyAncestor = 0;
    private static final int NotifyNonlinear = 3;
    private static final int NotifyPointer = 5;
    private static final int NotifyPointerRoot = 6;
    private static final int NotifyDetailNone = 7;
    private static final int SetModeInsert = 0;
    private static final int SaveSetRoot = 1;
    private static final int SaveSetUnmap = 1;
    private static final int X_SetInputFocus = 42;
    private static final int FULLSCREEN_LEGACY = 1;
    private static final int FULLSCREEN_NETWM = 2;
    private static final int WINDOWED = 3;
    private static int current_window_mode = 3;
    private static final int XRANDR = 10;
    private static final int XF86VIDMODE = 11;
    private static final int NONE = 12;
    private static long display;
    private static long current_window;
    private static long saved_error_handler;
    private static int display_connection_usage_count;
    private long delete_atom;
    private PeerInfo peer_info;
    private ByteBuffer saved_gamma;
    private ByteBuffer current_gamma;
    private DisplayMode saved_mode;
    private DisplayMode current_mode;
    private boolean keyboard_grabbed;
    private boolean pointer_grabbed;
    private boolean input_released;
    private boolean grab;
    private boolean focused;
    private boolean minimized;
    private boolean dirty;
    private boolean close_requested;
    private long current_cursor;
    private long blank_cursor;
    private boolean resizable;
    private boolean resized;
    private int window_x;
    private int window_y;
    private int window_width;
    private int window_height;
    private Canvas parent;
    private long parent_window;
    private static boolean xembedded;
    private long parent_proxy_focus_window;
    private boolean parent_focused;
    private boolean parent_focus_changed;
    private LinuxKeyboard keyboard;
    private LinuxMouse mouse;
    private String wm_class;
    private final LinuxEvent event_buffer = new LinuxEvent();
    private final LinuxEvent tmp_event_buffer = new LinuxEvent();
    private int current_displaymode_extension = 12;
    private boolean mouseInside = true;
    private long last_window_focus = 0;
    private final FocusListener focus_listener = new FocusListener() { // from class: org.lwjgl.opengl.LinuxDisplay.1
        public void focusGained(FocusEvent e) {
            synchronized (GlobalLock.lock) {
                LinuxDisplay.this.parent_focused = true;
                LinuxDisplay.this.parent_focus_changed = true;
            }
        }

        public void focusLost(FocusEvent e) {
            synchronized (GlobalLock.lock) {
                LinuxDisplay.this.parent_focused = false;
                LinuxDisplay.this.parent_focus_changed = true;
            }
        }
    };

    private static native ByteBuffer nGetCurrentGammaRamp(long j, int i) throws LWJGLException;

    private static native boolean nIsXrandrSupported(long j) throws LWJGLException;

    private static native boolean nIsXF86VidModeSupported(long j) throws LWJGLException;

    private static native boolean nIsNetWMFullscreenSupported(long j, int i) throws LWJGLException;

    private static native void nLockAWT() throws LWJGLException;

    private static native void nUnlockAWT() throws LWJGLException;

    private static native int callErrorHandler(long j, long j2, long j3);

    private static native long setErrorHandler();

    private static native long resetErrorHandler(long j);

    private static native void synchronize(long j, boolean z);

    private static native String getErrorText(long j, long j2);

    static native long openDisplay() throws LWJGLException;

    static native void closeDisplay(long j);

    static native int nGetDefaultScreen(long j);

    static native int nUngrabKeyboard(long j);

    static native int nGrabKeyboard(long j, long j2);

    static native int nGrabPointer(long j, long j2, long j3);

    private static native void nSetViewPort(long j, long j2, int i);

    static native int nUngrabPointer(long j);

    private static native void nDefineCursor(long j, long j2, long j3);

    private static native long nCreateWindow(long j, int i, ByteBuffer byteBuffer, DisplayMode displayMode, int i2, int i3, int i4, boolean z, long j2, boolean z2) throws LWJGLException;

    private static native long getRootWindow(long j, int i);

    private static native boolean hasProperty(long j, long j2, long j3);

    private static native long getParentWindow(long j, long j2) throws LWJGLException;

    private static native int getChildCount(long j, long j2) throws LWJGLException;

    private static native void mapRaised(long j, long j2);

    private static native void reparentWindow(long j, long j2, long j3, int i, int i2);

    private static native long nGetInputFocus(long j) throws LWJGLException;

    private static native void nSetInputFocus(long j, long j2, long j3);

    private static native void nSetWindowSize(long j, long j2, int i, int i2, boolean z);

    private static native int nGetX(long j, long j2);

    private static native int nGetY(long j, long j2);

    private static native int nGetWidth(long j, long j2);

    private static native int nGetHeight(long j, long j2);

    static native void nDestroyWindow(long j, long j2);

    private static native void nSwitchDisplayMode(long j, int i, int i2, DisplayMode displayMode) throws LWJGLException;

    static native long nInternAtom(long j, String str, boolean z);

    private static native int nGetGammaRampLength(long j, int i) throws LWJGLException;

    private static native void nSetGammaRamp(long j, int i, ByteBuffer byteBuffer) throws LWJGLException;

    private static native ByteBuffer nConvertToNativeRamp(FloatBuffer floatBuffer, int i, int i2) throws LWJGLException;

    private static native DisplayMode nGetCurrentXRandrMode(long j, int i) throws LWJGLException;

    private static native void nSetTitle(long j, long j2, long j3, int i);

    private static native void nSetClassHint(long j, long j2, long j3, long j4);

    private static native void nReshape(long j, long j2, int i, int i2, int i3, int i4);

    private static native DisplayMode[] nGetAvailableDisplayModes(long j, int i, int i2) throws LWJGLException;

    private static native void nSync(long j, boolean z) throws LWJGLException;

    private static native void nIconifyWindow(long j, long j2, int i);

    private static native int nGetNativeCursorCapabilities(long j) throws LWJGLException;

    private static native int nGetMinCursorSize(long j, long j2);

    private static native int nGetMaxCursorSize(long j, long j2);

    private static native long nCreateCursor(long j, int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, int i6, IntBuffer intBuffer2, int i7) throws LWJGLException;

    static native long nCreateBlankCursor(long j, long j2);

    static native void nDestroyCursor(long j, long j2);

    private static native int nGetPbufferCapabilities(long j, int i);

    private static native void nSetWindowIcon(long j, long j2, ByteBuffer byteBuffer, int i);

    LinuxDisplay() {
    }

    private static ByteBuffer getCurrentGammaRamp() throws LWJGLException {
        lockAWT();
        try {
            incDisplay();
            try {
                if (isXF86VidModeSupported()) {
                    ByteBuffer byteBufferNGetCurrentGammaRamp = nGetCurrentGammaRamp(getDisplay(), getDefaultScreen());
                    decDisplay();
                    unlockAWT();
                    return byteBufferNGetCurrentGammaRamp;
                }
                decDisplay();
                unlockAWT();
                return null;
            } catch (Throwable th) {
                decDisplay();
                throw th;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    private static int getBestDisplayModeExtension() {
        int result;
        if (isXrandrSupported()) {
            LWJGLUtil.log("Using Xrandr for display mode switching");
            result = 10;
        } else if (isXF86VidModeSupported()) {
            LWJGLUtil.log("Using XF86VidMode for display mode switching");
            result = 11;
        } else {
            LWJGLUtil.log("No display mode extensions available");
            result = 12;
        }
        return result;
    }

    private static boolean isXrandrSupported() {
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_XRANDR")) {
            return false;
        }
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    boolean zNIsXrandrSupported = nIsXrandrSupported(getDisplay());
                    decDisplay();
                    unlockAWT();
                    return zNIsXrandrSupported;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Got exception while querying Xrandr support: " + e);
                unlockAWT();
                return false;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    private static boolean isXF86VidModeSupported() {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    boolean zNIsXF86VidModeSupported = nIsXF86VidModeSupported(getDisplay());
                    decDisplay();
                    unlockAWT();
                    return zNIsXF86VidModeSupported;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Got exception while querying XF86VM support: " + e);
                unlockAWT();
                return false;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    private static boolean isNetWMFullscreenSupported() throws LWJGLException {
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_NETWM")) {
            return false;
        }
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    boolean zNIsNetWMFullscreenSupported = nIsNetWMFullscreenSupported(getDisplay(), getDefaultScreen());
                    decDisplay();
                    unlockAWT();
                    return zNIsNetWMFullscreenSupported;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Got exception while querying NetWM support: " + e);
                unlockAWT();
                return false;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    static void lockAWT() {
        try {
            nLockAWT();
        } catch (LWJGLException e) {
            LWJGLUtil.log("Caught exception while locking AWT: " + e);
        }
    }

    static void unlockAWT() {
        try {
            nUnlockAWT();
        } catch (LWJGLException e) {
            LWJGLUtil.log("Caught exception while unlocking AWT: " + e);
        }
    }

    static void incDisplay() throws LWJGLException {
        if (display_connection_usage_count == 0) {
            try {
                GLContext.loadOpenGLLibrary();
                org.lwjgl.opengles.GLContext.loadOpenGLLibrary();
            } catch (Throwable th) {
            }
            saved_error_handler = setErrorHandler();
            display = openDisplay();
        }
        display_connection_usage_count++;
    }

    private static int globalErrorHandler(long display2, long event_ptr, long error_display, long serial, long error_code, long request_code, long minor_code) throws LWJGLException {
        if (xembedded && request_code == 42) {
            return 0;
        }
        if (display2 == getDisplay()) {
            String error_msg = getErrorText(display2, error_code);
            throw new LWJGLException("X Error - disp: 0x" + Long.toHexString(error_display) + " serial: " + serial + " error: " + error_msg + " request_code: " + request_code + " minor_code: " + minor_code);
        }
        if (saved_error_handler != 0) {
            return callErrorHandler(saved_error_handler, display2, event_ptr);
        }
        return 0;
    }

    static void decDisplay() {
    }

    private int getWindowMode(boolean fullscreen) throws LWJGLException {
        if (fullscreen) {
            if (this.current_displaymode_extension == 10 && isNetWMFullscreenSupported()) {
                LWJGLUtil.log("Using NetWM for fullscreen window");
                return 2;
            }
            LWJGLUtil.log("Using legacy mode for fullscreen window");
            return 1;
        }
        return 3;
    }

    static long getDisplay() {
        if (display_connection_usage_count <= 0) {
            throw new InternalError("display_connection_usage_count = " + display_connection_usage_count);
        }
        return display;
    }

    static int getDefaultScreen() {
        return nGetDefaultScreen(getDisplay());
    }

    static long getWindow() {
        return current_window;
    }

    private void ungrabKeyboard() {
        if (this.keyboard_grabbed) {
            nUngrabKeyboard(getDisplay());
            this.keyboard_grabbed = false;
        }
    }

    private void grabKeyboard() {
        if (!this.keyboard_grabbed) {
            int res = nGrabKeyboard(getDisplay(), getWindow());
            if (res == 0) {
                this.keyboard_grabbed = true;
            }
        }
    }

    private void grabPointer() {
        if (!this.pointer_grabbed) {
            int result = nGrabPointer(getDisplay(), getWindow(), 0L);
            if (result == 0) {
                this.pointer_grabbed = true;
                if (isLegacyFullscreen()) {
                    nSetViewPort(getDisplay(), getWindow(), getDefaultScreen());
                }
            }
        }
    }

    private void ungrabPointer() {
        if (this.pointer_grabbed) {
            this.pointer_grabbed = false;
            nUngrabPointer(getDisplay());
        }
    }

    private static boolean isFullscreen() {
        return current_window_mode == 1 || current_window_mode == 2;
    }

    private boolean shouldGrab() {
        return (this.input_released || !this.grab || this.mouse == null) ? false : true;
    }

    private void updatePointerGrab() {
        if (isFullscreen() || shouldGrab()) {
            grabPointer();
        } else {
            ungrabPointer();
        }
        updateCursor();
    }

    private void updateCursor() {
        long cursor;
        if (shouldGrab()) {
            cursor = this.blank_cursor;
        } else {
            cursor = this.current_cursor;
        }
        nDefineCursor(getDisplay(), getWindow(), cursor);
    }

    private static boolean isLegacyFullscreen() {
        return current_window_mode == 1;
    }

    private void updateKeyboardGrab() {
        if (isLegacyFullscreen()) {
            grabKeyboard();
        } else {
            ungrabKeyboard();
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // org.lwjgl.opengl.DisplayImplementation
    public void createWindow(DrawableLWJGL drawable, DisplayMode mode, Canvas parent, int x, int y) throws LWJGLException {
        lockAWT();
        try {
            incDisplay();
            try {
                if (drawable instanceof DrawableGLES) {
                    this.peer_info = new LinuxDisplayPeerInfo();
                }
                ByteBuffer handle = this.peer_info.lockAndGetHandle();
                try {
                    current_window_mode = getWindowMode(Display.isFullscreen());
                    if (current_window_mode != 3) {
                        Compiz.setLegacyFullscreenSupport(true);
                    }
                    boolean undecorated = Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated") || (current_window_mode != 3 && Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated_fs"));
                    this.parent = parent;
                    this.parent_window = parent != null ? getHandle(parent) : getRootWindow(getDisplay(), getDefaultScreen());
                    this.resizable = Display.isResizable();
                    this.resized = false;
                    this.window_x = x;
                    this.window_y = y;
                    this.window_width = mode.getWidth();
                    this.window_height = mode.getHeight();
                    if (mode.isFullscreenCapable() && this.current_displaymode_extension == 10) {
                        XRandR.Screen primaryScreen = XRandR.DisplayModetoScreen(Display.getDisplayMode());
                        x = primaryScreen.xPos;
                        y = primaryScreen.yPos;
                    }
                    current_window = nCreateWindow(getDisplay(), getDefaultScreen(), handle, mode, current_window_mode, x, y, undecorated, this.parent_window, this.resizable);
                    this.wm_class = Display.getPrivilegedString("LWJGL_WM_CLASS");
                    if (this.wm_class == null) {
                        this.wm_class = Display.getTitle();
                    }
                    setClassHint(Display.getTitle(), this.wm_class);
                    mapRaised(getDisplay(), current_window);
                    xembedded = parent != null && isAncestorXEmbedded(this.parent_window);
                    this.blank_cursor = createBlankCursor();
                    this.current_cursor = 0L;
                    this.focused = false;
                    this.input_released = false;
                    this.pointer_grabbed = false;
                    this.keyboard_grabbed = false;
                    this.close_requested = false;
                    this.grab = false;
                    this.minimized = false;
                    this.dirty = true;
                    if (drawable instanceof DrawableGLES) {
                        ((DrawableGLES) drawable).initialize(current_window, getDisplay(), 4, (org.lwjgl.opengles.PixelFormat) drawable.getPixelFormat());
                    }
                    if (parent != null) {
                        parent.addFocusListener(this.focus_listener);
                        this.parent_focused = parent.isFocusOwner();
                        this.parent_focus_changed = true;
                    }
                    this.peer_info.unlock();
                } catch (Throwable th) {
                    this.peer_info.unlock();
                    throw th;
                }
            } catch (LWJGLException e) {
                decDisplay();
                throw e;
            }
        } finally {
            unlockAWT();
        }
    }

    private static boolean isAncestorXEmbedded(long window) throws LWJGLException {
        long xembed_atom = internAtom("_XEMBED_INFO", true);
        if (xembed_atom != 0) {
            long parentWindow = window;
            while (true) {
                long w = parentWindow;
                if (w != 0) {
                    if (hasProperty(getDisplay(), w, xembed_atom)) {
                        return true;
                    }
                    parentWindow = getParentWindow(getDisplay(), w);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private static long getHandle(Canvas parent) throws LWJGLException {
        AWTCanvasImplementation awt_impl = AWTGLCanvas.createImplementation();
        LinuxPeerInfo parent_peer_info = (LinuxPeerInfo) awt_impl.createPeerInfo(parent, null, null);
        parent_peer_info.lockAndGetHandle();
        try {
            long drawable = parent_peer_info.getDrawable();
            parent_peer_info.unlock();
            return drawable;
        } catch (Throwable th) {
            parent_peer_info.unlock();
            throw th;
        }
    }

    private void updateInputGrab() {
        updatePointerGrab();
        updateKeyboardGrab();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void destroyWindow() {
        lockAWT();
        try {
            if (this.parent != null) {
                this.parent.removeFocusListener(this.focus_listener);
            }
            try {
                setNativeCursor(null);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to reset cursor: " + e.getMessage());
            }
            nDestroyCursor(getDisplay(), this.blank_cursor);
            this.blank_cursor = 0L;
            ungrabKeyboard();
            nDestroyWindow(getDisplay(), getWindow());
            decDisplay();
            if (current_window_mode != 3) {
                Compiz.setLegacyFullscreenSupport(false);
            }
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void switchDisplayMode(DisplayMode mode) throws LWJGLException {
        lockAWT();
        try {
            switchDisplayModeOnTmpDisplay(mode);
            this.current_mode = mode;
        } finally {
            unlockAWT();
        }
    }

    private void switchDisplayModeOnTmpDisplay(DisplayMode mode) throws LWJGLException {
        if (this.current_displaymode_extension == 10) {
            XRandR.setConfiguration(false, XRandR.DisplayModetoScreen(mode));
            return;
        }
        incDisplay();
        try {
            nSwitchDisplayMode(getDisplay(), getDefaultScreen(), this.current_displaymode_extension, mode);
        } finally {
            decDisplay();
        }
    }

    private static long internAtom(String atom_name, boolean only_if_exists) throws LWJGLException {
        incDisplay();
        try {
            long jNInternAtom = nInternAtom(getDisplay(), atom_name, only_if_exists);
            decDisplay();
            return jNInternAtom;
        } catch (Throwable th) {
            decDisplay();
            throw th;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void resetDisplayMode() {
        lockAWT();
        try {
            if (this.current_displaymode_extension == 10) {
                AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.LinuxDisplay.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        XRandR.restoreConfiguration();
                        return null;
                    }
                });
            } else {
                switchDisplayMode(this.saved_mode);
            }
            if (isXF86VidModeSupported()) {
                doSetGamma(this.saved_gamma);
            }
            Compiz.setLegacyFullscreenSupport(false);
        } catch (LWJGLException e) {
            LWJGLUtil.log("Caught exception while resetting mode: " + e);
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getGammaRampLength() {
        if (!isXF86VidModeSupported()) {
            return 0;
        }
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    try {
                        int iNGetGammaRampLength = nGetGammaRampLength(getDisplay(), getDefaultScreen());
                        decDisplay();
                        unlockAWT();
                        return iNGetGammaRampLength;
                    } catch (LWJGLException e) {
                        LWJGLUtil.log("Got exception while querying gamma length: " + e);
                        decDisplay();
                        unlockAWT();
                        return 0;
                    }
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to get gamma ramp length: " + e2);
                unlockAWT();
                return 0;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setGammaRamp(FloatBuffer gammaRamp) throws LWJGLException {
        if (!isXF86VidModeSupported()) {
            throw new LWJGLException("No gamma ramp support (Missing XF86VM extension)");
        }
        doSetGamma(convertToNativeRamp(gammaRamp));
    }

    private void doSetGamma(ByteBuffer native_gamma) throws LWJGLException {
        lockAWT();
        try {
            setGammaRampOnTmpDisplay(native_gamma);
            this.current_gamma = native_gamma;
        } finally {
            unlockAWT();
        }
    }

    private static void setGammaRampOnTmpDisplay(ByteBuffer native_gamma) throws LWJGLException {
        incDisplay();
        try {
            nSetGammaRamp(getDisplay(), getDefaultScreen(), native_gamma);
        } finally {
            decDisplay();
        }
    }

    private static ByteBuffer convertToNativeRamp(FloatBuffer ramp) throws LWJGLException {
        return nConvertToNativeRamp(ramp, ramp.position(), ramp.remaining());
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getAdapter() {
        return null;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public String getVersion() {
        return null;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public DisplayMode init() throws LWJGLException {
        lockAWT();
        try {
            Compiz.init();
            this.delete_atom = internAtom("WM_DELETE_WINDOW", false);
            this.current_displaymode_extension = getBestDisplayModeExtension();
            if (this.current_displaymode_extension == 12) {
                throw new LWJGLException("No display mode extension is available");
            }
            DisplayMode[] modes = getAvailableDisplayModes();
            if (modes == null || modes.length == 0) {
                throw new LWJGLException("No modes available");
            }
            switch (this.current_displaymode_extension) {
                case 10:
                    this.saved_mode = (DisplayMode) AccessController.doPrivileged(new PrivilegedAction<DisplayMode>() { // from class: org.lwjgl.opengl.LinuxDisplay.3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedAction
                        public DisplayMode run() {
                            XRandR.saveConfiguration();
                            return XRandR.ScreentoDisplayMode(XRandR.getConfiguration());
                        }
                    });
                    break;
                case 11:
                    this.saved_mode = modes[0];
                    break;
                default:
                    throw new LWJGLException("Unknown display mode extension: " + this.current_displaymode_extension);
            }
            this.current_mode = this.saved_mode;
            this.saved_gamma = getCurrentGammaRamp();
            this.current_gamma = this.saved_gamma;
            DisplayMode displayMode = this.saved_mode;
            unlockAWT();
            return displayMode;
        } catch (Throwable th) {
            unlockAWT();
            throw th;
        }
    }

    private static DisplayMode getCurrentXRandrMode() throws LWJGLException {
        lockAWT();
        try {
            incDisplay();
            try {
                DisplayMode displayModeNGetCurrentXRandrMode = nGetCurrentXRandrMode(getDisplay(), getDefaultScreen());
                decDisplay();
                unlockAWT();
                return displayModeNGetCurrentXRandrMode;
            } catch (Throwable th) {
                decDisplay();
                throw th;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void setTitle(String title) {
        lockAWT();
        try {
            ByteBuffer titleText = MemoryUtil.encodeUTF8(title);
            nSetTitle(getDisplay(), getWindow(), MemoryUtil.getAddress(titleText), titleText.remaining() - 1);
        } finally {
            unlockAWT();
        }
    }

    private void setClassHint(String wm_name, String wm_class) {
        lockAWT();
        try {
            ByteBuffer nameText = MemoryUtil.encodeUTF8(wm_name);
            ByteBuffer classText = MemoryUtil.encodeUTF8(wm_class);
            nSetClassHint(getDisplay(), getWindow(), MemoryUtil.getAddress(nameText), MemoryUtil.getAddress(classText));
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isCloseRequested() {
        boolean result = this.close_requested;
        this.close_requested = false;
        return result;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isVisible() {
        return !this.minimized;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isActive() {
        return this.focused || isLegacyFullscreen();
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isDirty() {
        boolean result = this.dirty;
        this.dirty = false;
        return result;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPeerInfo(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
        this.peer_info = new LinuxDisplayPeerInfo(pixel_format);
        return this.peer_info;
    }

    private void relayEventToParent(LinuxEvent event_buffer, int event_mask) {
        this.tmp_event_buffer.copyFrom(event_buffer);
        this.tmp_event_buffer.setWindow(this.parent_window);
        this.tmp_event_buffer.sendEvent(getDisplay(), this.parent_window, true, event_mask);
    }

    private void relayEventToParent(LinuxEvent event_buffer) {
        if (this.parent == null) {
        }
        switch (event_buffer.getType()) {
            case 2:
                relayEventToParent(event_buffer, 1);
                break;
            case 3:
                relayEventToParent(event_buffer, 1);
                break;
            case 4:
                if (xembedded || !this.focused) {
                    relayEventToParent(event_buffer, 1);
                }
                break;
            case 5:
                if (xembedded || !this.focused) {
                    relayEventToParent(event_buffer, 1);
                }
                break;
        }
    }

    private void processEvents() {
        while (LinuxEvent.getPending(getDisplay()) > 0) {
            this.event_buffer.nextEvent(getDisplay());
            long event_window = this.event_buffer.getWindow();
            relayEventToParent(this.event_buffer);
            if (event_window == getWindow() && !this.event_buffer.filterEvent(event_window) && (this.mouse == null || !this.mouse.filterEvent(this.grab, shouldWarpPointer(), this.event_buffer))) {
                if (this.keyboard == null || !this.keyboard.filterEvent(this.event_buffer)) {
                    switch (this.event_buffer.getType()) {
                        case 7:
                            this.mouseInside = true;
                            break;
                        case 8:
                            this.mouseInside = false;
                            break;
                        case 9:
                            setFocused(true, this.event_buffer.getFocusDetail());
                            break;
                        case 10:
                            setFocused(false, this.event_buffer.getFocusDetail());
                            break;
                        case 12:
                            this.dirty = true;
                            break;
                        case 18:
                            this.dirty = true;
                            this.minimized = true;
                            break;
                        case 19:
                            this.dirty = true;
                            this.minimized = false;
                            break;
                        case 22:
                            int x = nGetX(getDisplay(), getWindow());
                            int y = nGetY(getDisplay(), getWindow());
                            int width = nGetWidth(getDisplay(), getWindow());
                            int height = nGetHeight(getDisplay(), getWindow());
                            this.window_x = x;
                            this.window_y = y;
                            if (this.window_width != width || this.window_height != height) {
                                this.resized = true;
                                this.window_width = width;
                                this.window_height = height;
                            }
                            break;
                        case 33:
                            if (this.event_buffer.getClientFormat() == 32 && this.event_buffer.getClientData(0) == this.delete_atom) {
                                this.close_requested = true;
                            }
                            break;
                    }
                }
            }
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void update() {
        lockAWT();
        try {
            processEvents();
            checkInput();
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public void reshape(int x, int y, int width, int height) {
        lockAWT();
        try {
            nReshape(getDisplay(), getWindow(), x, y, width, height);
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        lockAWT();
        try {
            incDisplay();
            if (this.current_displaymode_extension == 10) {
                DisplayMode[] nDisplayModes = nGetAvailableDisplayModes(getDisplay(), getDefaultScreen(), this.current_displaymode_extension);
                int bpp = 24;
                if (nDisplayModes.length > 0) {
                    bpp = nDisplayModes[0].getBitsPerPixel();
                }
                XRandR.Screen[] resolutions = XRandR.getResolutions(XRandR.getScreenNames()[0]);
                DisplayMode[] modes = new DisplayMode[resolutions.length];
                for (int i = 0; i < modes.length; i++) {
                    modes[i] = new DisplayMode(resolutions[i].width, resolutions[i].height, bpp, resolutions[i].freq);
                }
                unlockAWT();
                return modes;
            }
            try {
                DisplayMode[] modes2 = nGetAvailableDisplayModes(getDisplay(), getDefaultScreen(), this.current_displaymode_extension);
                decDisplay();
                unlockAWT();
                return modes2;
            } catch (Throwable th) {
                decDisplay();
                throw th;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public boolean hasWheel() {
        return true;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createMouse() throws LWJGLException {
        lockAWT();
        try {
            this.mouse = new LinuxMouse(getDisplay(), getWindow(), getWindow());
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyMouse() {
        this.mouse = null;
        updateInputGrab();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons) {
        lockAWT();
        try {
            this.mouse.poll(this.grab, coord_buffer, buttons);
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readMouse(ByteBuffer buffer) {
        lockAWT();
        try {
            this.mouse.read(buffer);
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setCursorPosition(int x, int y) {
        lockAWT();
        try {
            this.mouse.setCursorPosition(x, y);
        } finally {
            unlockAWT();
        }
    }

    private void checkInput() {
        if (this.parent == null) {
            return;
        }
        if (!xembedded) {
            if (this.parent_focus_changed && this.parent_focused) {
                setInputFocusUnsafe(getWindow());
                this.parent_focus_changed = false;
                return;
            }
            return;
        }
        if (this.last_window_focus != 0 || this.parent_focused != this.focused) {
            if (isParentWindowActive(0L)) {
                if (this.parent_focused) {
                    nSetInputFocus(getDisplay(), current_window, 0L);
                    this.last_window_focus = current_window;
                    this.focused = true;
                    return;
                } else {
                    nSetInputFocus(getDisplay(), this.parent_proxy_focus_window, 0L);
                    this.last_window_focus = this.parent_proxy_focus_window;
                    this.focused = false;
                    return;
                }
            }
            this.last_window_focus = 0L;
            this.focused = false;
        }
    }

    private void setInputFocusUnsafe(long window) {
        try {
            nSetInputFocus(getDisplay(), window, 0L);
            nSync(getDisplay(), false);
        } catch (LWJGLException e) {
            LWJGLUtil.log("Got exception while trying to focus: " + e);
        }
    }

    private boolean isParentWindowActive(long window) {
        try {
            if (window == current_window) {
                return true;
            }
            if (getChildCount(getDisplay(), window) != 0) {
                return false;
            }
            long parent_window = getParentWindow(getDisplay(), window);
            if (parent_window == 0) {
                return false;
            }
            long w = current_window;
            while (w != 0) {
                w = getParentWindow(getDisplay(), w);
                if (w == parent_window) {
                    this.parent_proxy_focus_window = window;
                    return true;
                }
            }
            return false;
        } catch (LWJGLException e) {
            LWJGLUtil.log("Failed to detect if parent window is active: " + e.getMessage());
            return true;
        }
    }

    private void setFocused(boolean got_focus, int focus_detail) {
        if (this.focused == got_focus || focus_detail == 7 || focus_detail == 5 || focus_detail == 6 || xembedded) {
            return;
        }
        this.focused = got_focus;
        if (this.focused) {
            acquireInput();
        } else {
            releaseInput();
        }
    }

    private void releaseInput() {
        if (isLegacyFullscreen() || this.input_released) {
            return;
        }
        if (this.keyboard != null) {
            this.keyboard.releaseAll();
        }
        this.input_released = true;
        updateInputGrab();
        if (current_window_mode == 2) {
            nIconifyWindow(getDisplay(), getWindow(), getDefaultScreen());
            try {
                if (this.current_displaymode_extension == 10) {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.LinuxDisplay.4
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            XRandR.restoreConfiguration();
                            return null;
                        }
                    });
                } else {
                    switchDisplayModeOnTmpDisplay(this.saved_mode);
                }
                setGammaRampOnTmpDisplay(this.saved_gamma);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to restore saved mode: " + e.getMessage());
            }
        }
    }

    private void acquireInput() {
        if (isLegacyFullscreen() || !this.input_released) {
            return;
        }
        this.input_released = false;
        updateInputGrab();
        if (current_window_mode == 2) {
            try {
                switchDisplayModeOnTmpDisplay(this.current_mode);
                setGammaRampOnTmpDisplay(this.current_gamma);
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to restore mode: " + e.getMessage());
            }
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void grabMouse(boolean new_grab) {
        lockAWT();
        try {
            if (new_grab != this.grab) {
                this.grab = new_grab;
                updateInputGrab();
                this.mouse.changeGrabbed(this.grab, shouldWarpPointer());
            }
        } finally {
            unlockAWT();
        }
    }

    private boolean shouldWarpPointer() {
        return this.pointer_grabbed && shouldGrab();
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getNativeCursorCapabilities() {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    int iNGetNativeCursorCapabilities = nGetNativeCursorCapabilities(getDisplay());
                    decDisplay();
                    unlockAWT();
                    return iNGetNativeCursorCapabilities;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void setNativeCursor(Object handle) throws LWJGLException {
        this.current_cursor = getCursorHandle(handle);
        lockAWT();
        try {
            updateCursor();
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMinCursorSize() {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    int iNGetMinCursorSize = nGetMinCursorSize(getDisplay(), getWindow());
                    decDisplay();
                    unlockAWT();
                    return iNGetMinCursorSize;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred in getMinCursorSize: " + e);
                unlockAWT();
                return 0;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public int getMaxCursorSize() {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    int iNGetMaxCursorSize = nGetMaxCursorSize(getDisplay(), getWindow());
                    decDisplay();
                    unlockAWT();
                    return iNGetMaxCursorSize;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred in getMaxCursorSize: " + e);
                unlockAWT();
                return 0;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void createKeyboard() throws LWJGLException {
        lockAWT();
        try {
            this.keyboard = new LinuxKeyboard(getDisplay(), getWindow());
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyKeyboard() {
        lockAWT();
        try {
            this.keyboard.destroy(getDisplay());
            this.keyboard = null;
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void pollKeyboard(ByteBuffer keyDownBuffer) {
        lockAWT();
        try {
            this.keyboard.poll(keyDownBuffer);
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void readKeyboard(ByteBuffer buffer) {
        lockAWT();
        try {
            this.keyboard.read(buffer);
        } finally {
            unlockAWT();
        }
    }

    private static long createBlankCursor() {
        return nCreateBlankCursor(getDisplay(), getWindow());
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        lockAWT();
        try {
            incDisplay();
            try {
                long cursor = nCreateCursor(getDisplay(), width, height, xHotspot, yHotspot, numImages, images, images.position(), delays, delays != null ? delays.position() : -1);
                Long lValueOf = Long.valueOf(cursor);
                unlockAWT();
                return lValueOf;
            } catch (LWJGLException e) {
                decDisplay();
                throw e;
            }
        } catch (Throwable th) {
            unlockAWT();
            throw th;
        }
    }

    private static long getCursorHandle(Object cursor_handle) {
        if (cursor_handle != null) {
            return ((Long) cursor_handle).longValue();
        }
        return 0L;
    }

    @Override // org.lwjgl.opengl.InputImplementation
    public void destroyCursor(Object cursorHandle) {
        lockAWT();
        try {
            nDestroyCursor(getDisplay(), getCursorHandle(cursorHandle));
            decDisplay();
        } finally {
            unlockAWT();
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getPbufferCapabilities() {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    int iNGetPbufferCapabilities = nGetPbufferCapabilities(getDisplay(), getDefaultScreen());
                    decDisplay();
                    unlockAWT();
                    return iNGetPbufferCapabilities;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Exception occurred in getPbufferCapabilities: " + e);
                unlockAWT();
                return 0;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public boolean isBufferLost(PeerInfo handle) {
        return false;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, ContextAttribs attribs, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        return new LinuxPbufferPeerInfo(width, height, pixel_format);
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

    private static ByteBuffer convertIcons(ByteBuffer[] icons) {
        int bufferSize = 0;
        for (ByteBuffer byteBuffer : icons) {
            int size = byteBuffer.limit() / 4;
            int dimension = (int) Math.sqrt(size);
            if (dimension > 0) {
                bufferSize = bufferSize + 8 + (dimension * dimension * 4);
            }
        }
        if (bufferSize == 0) {
            return null;
        }
        ByteBuffer icon_argb = BufferUtils.createByteBuffer(bufferSize);
        icon_argb.order(ByteOrder.BIG_ENDIAN);
        for (ByteBuffer icon : icons) {
            int size2 = icon.limit() / 4;
            int dimension2 = (int) Math.sqrt(size2);
            icon_argb.putInt(dimension2);
            icon_argb.putInt(dimension2);
            for (int y = 0; y < dimension2; y++) {
                for (int x = 0; x < dimension2; x++) {
                    byte r = icon.get((x * 4) + (y * dimension2 * 4));
                    byte g = icon.get((x * 4) + (y * dimension2 * 4) + 1);
                    byte b = icon.get((x * 4) + (y * dimension2 * 4) + 2);
                    byte a = icon.get((x * 4) + (y * dimension2 * 4) + 3);
                    icon_argb.put(a);
                    icon_argb.put(r);
                    icon_argb.put(g);
                    icon_argb.put(b);
                }
            }
        }
        return icon_argb;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int setIcon(ByteBuffer[] icons) {
        lockAWT();
        try {
            try {
                incDisplay();
                try {
                    ByteBuffer icons_data = convertIcons(icons);
                    if (icons_data != null) {
                        nSetWindowIcon(getDisplay(), getWindow(), icons_data, icons_data.capacity());
                        int length = icons.length;
                        decDisplay();
                        unlockAWT();
                        return length;
                    }
                    decDisplay();
                    unlockAWT();
                    return 0;
                } catch (Throwable th) {
                    decDisplay();
                    throw th;
                }
            } catch (LWJGLException e) {
                LWJGLUtil.log("Failed to set display icon: " + e);
                unlockAWT();
                return 0;
            }
        } catch (Throwable th2) {
            unlockAWT();
            throw th2;
        }
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getX() {
        return this.window_x;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation
    public int getY() {
        return this.window_y;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getWidth() {
        return this.window_width;
    }

    @Override // org.lwjgl.opengl.DisplayImplementation, org.lwjgl.opengl.InputImplementation
    public int getHeight() {
        return this.window_height;
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
        this.resizable = resizable;
        nSetWindowSize(getDisplay(), getWindow(), this.window_width, this.window_height, resizable);
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

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxDisplay$Compiz.class */
    private static final class Compiz {
        private static boolean applyFix;
        private static Provider provider;

        /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/LinuxDisplay$Compiz$Provider.class */
        private interface Provider {
            boolean hasLegacyFullscreenSupport() throws LWJGLException;

            void setLegacyFullscreenSupport(boolean z) throws LWJGLException;
        }

        private Compiz() {
        }

        static void init() {
            if (Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.nocompiz_lfs")) {
                return;
            }
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.LinuxDisplay.Compiz.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        if (Compiz.isProcessActive("compiz")) {
                            Provider unused = Compiz.provider = null;
                            String providerName = null;
                            if (Compiz.isProcessActive("dbus-daemon")) {
                                providerName = "Dbus";
                                Provider unused2 = Compiz.provider = new Provider() { // from class: org.lwjgl.opengl.LinuxDisplay.Compiz.1.1
                                    private static final String KEY = "/org/freedesktop/compiz/workarounds/allscreens/legacy_fullscreen";

                                    @Override // org.lwjgl.opengl.LinuxDisplay.Compiz.Provider
                                    public boolean hasLegacyFullscreenSupport() throws LWJGLException {
                                        List output = Compiz.run("dbus-send", "--print-reply", "--type=method_call", "--dest=org.freedesktop.compiz", KEY, "org.freedesktop.compiz.get");
                                        if (output == null || output.size() < 2) {
                                            throw new LWJGLException("Invalid Dbus reply.");
                                        }
                                        if (!((String) output.get(0)).startsWith("method return")) {
                                            throw new LWJGLException("Invalid Dbus reply.");
                                        }
                                        String line = ((String) output.get(1)).trim();
                                        if (!line.startsWith("boolean") || line.length() < 12) {
                                            throw new LWJGLException("Invalid Dbus reply.");
                                        }
                                        return "true".equalsIgnoreCase(line.substring("boolean".length() + 1));
                                    }

                                    @Override // org.lwjgl.opengl.LinuxDisplay.Compiz.Provider
                                    public void setLegacyFullscreenSupport(boolean state) throws LWJGLException {
                                        if (Compiz.run("dbus-send", "--type=method_call", "--dest=org.freedesktop.compiz", KEY, "org.freedesktop.compiz.set", "boolean:" + Boolean.toString(state)) == null) {
                                            throw new LWJGLException("Failed to apply Compiz LFS workaround.");
                                        }
                                    }
                                };
                            } else {
                                try {
                                    Runtime.getRuntime().exec("gconftool");
                                    providerName = "gconftool";
                                    Provider unused3 = Compiz.provider = new Provider() { // from class: org.lwjgl.opengl.LinuxDisplay.Compiz.1.2
                                        private static final String KEY = "/apps/compiz/plugins/workarounds/allscreens/options/legacy_fullscreen";

                                        @Override // org.lwjgl.opengl.LinuxDisplay.Compiz.Provider
                                        public boolean hasLegacyFullscreenSupport() throws LWJGLException {
                                            List output = Compiz.run("gconftool", "-g", KEY);
                                            if (output == null || output.size() == 0) {
                                                throw new LWJGLException("Invalid gconftool reply.");
                                            }
                                            return Boolean.parseBoolean(((String) output.get(0)).trim());
                                        }

                                        @Override // org.lwjgl.opengl.LinuxDisplay.Compiz.Provider
                                        public void setLegacyFullscreenSupport(boolean state) throws LWJGLException {
                                            if (Compiz.run("gconftool", "-s", KEY, "-s", Boolean.toString(state), "-t", "bool") == null) {
                                                throw new LWJGLException("Failed to apply Compiz LFS workaround.");
                                            }
                                            if (state) {
                                                try {
                                                    Thread.sleep(200L);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    };
                                } catch (IOException e) {
                                }
                            }
                            if (Compiz.provider != null && !Compiz.provider.hasLegacyFullscreenSupport()) {
                                boolean unused4 = Compiz.applyFix = true;
                                LWJGLUtil.log("Using " + providerName + " to apply Compiz LFS workaround.");
                                return null;
                            }
                            return null;
                        }
                        return null;
                    } catch (LWJGLException e2) {
                        return null;
                    } catch (Throwable th) {
                        return null;
                    }
                }
            });
        }

        static void setLegacyFullscreenSupport(final boolean enabled) {
            if (!applyFix) {
                return;
            }
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.lwjgl.opengl.LinuxDisplay.Compiz.2
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Compiz.provider.setLegacyFullscreenSupport(enabled);
                        return null;
                    } catch (LWJGLException e) {
                        LWJGLUtil.log("Failed to change Compiz Legacy Fullscreen Support. Reason: " + e.getMessage());
                        return null;
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static List<String> run(String... command) throws LWJGLException {
            List<String> output = new ArrayList<>();
            try {
                Process p = Runtime.getRuntime().exec(command);
                try {
                    int exitValue = p.waitFor();
                    if (exitValue != 0) {
                        return null;
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while (true) {
                        String line = br.readLine();
                        if (line != null) {
                            output.add(line);
                        } else {
                            br.close();
                            return output;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new LWJGLException("Process interrupted.", e);
                }
            } catch (IOException e2) {
                throw new LWJGLException("Process failed.", e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isProcessActive(String processName) throws LWJGLException {
            List<String> output = run("ps", "-C", processName);
            if (output == null) {
                return false;
            }
            for (String line : output) {
                if (line.contains(processName)) {
                    return true;
                }
            }
            return false;
        }
    }
}
