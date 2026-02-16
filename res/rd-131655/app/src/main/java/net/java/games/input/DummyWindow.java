package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DummyWindow.class */
final class DummyWindow {
    private final long hwnd_address = createWindow();

    private static final native long createWindow() throws IOException;

    private static final native void nDestroy(long j) throws IOException;

    public final void destroy() throws IOException {
        nDestroy(this.hwnd_address);
    }

    public final long getHwnd() {
        return this.hwnd_address;
    }
}
