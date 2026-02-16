package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXHIDDeviceIterator.class */
final class OSXHIDDeviceIterator {
    private final long iterator_address = nCreateIterator();

    private static final native long nCreateIterator();

    private static final native void nReleaseIterator(long j);

    private static final native OSXHIDDevice nNext(long j) throws IOException;

    public final void close() {
        nReleaseIterator(this.iterator_address);
    }

    public final OSXHIDDevice next() throws IOException {
        return nNext(this.iterator_address);
    }
}
