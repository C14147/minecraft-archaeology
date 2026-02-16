package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXHIDQueue.class */
final class OSXHIDQueue {
    private final Map map = new HashMap();
    private final long queue_address;
    private boolean released;

    private static final native void nOpen(long j, int i) throws IOException;

    private static final native void nClose(long j) throws IOException;

    private static final native void nStart(long j) throws IOException;

    private static final native void nStop(long j) throws IOException;

    private static final native void nReleaseQueue(long j) throws IOException;

    private static final native void nAddElement(long j, long j2) throws IOException;

    private static final native void nRemoveElement(long j, long j2) throws IOException;

    private static final native boolean nGetNextEvent(long j, OSXEvent oSXEvent) throws IOException;

    public OSXHIDQueue(long address, int queue_depth) throws IOException {
        this.queue_address = address;
        try {
            createQueue(queue_depth);
        } catch (IOException e) {
            release();
            throw e;
        }
    }

    public final synchronized void setQueueDepth(int queue_depth) throws IOException {
        checkReleased();
        stop();
        close();
        createQueue(queue_depth);
    }

    private final void createQueue(int queue_depth) throws IOException {
        open(queue_depth);
        try {
            start();
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    public final OSXComponent mapEvent(OSXEvent event) {
        return (OSXComponent) this.map.get(new Long(event.getCookie()));
    }

    private final void open(int queue_depth) throws IOException {
        nOpen(this.queue_address, queue_depth);
    }

    private final void close() throws IOException {
        nClose(this.queue_address);
    }

    private final void start() throws IOException {
        nStart(this.queue_address);
    }

    private final void stop() throws IOException {
        nStop(this.queue_address);
    }

    public final synchronized void release() throws IOException {
        if (!this.released) {
            this.released = true;
            try {
                stop();
                close();
                nReleaseQueue(this.queue_address);
            } catch (Throwable th) {
                nReleaseQueue(this.queue_address);
                throw th;
            }
        }
    }

    public final void addElement(OSXHIDElement element, OSXComponent component) throws IOException {
        nAddElement(this.queue_address, element.getCookie());
        this.map.put(new Long(element.getCookie()), component);
    }

    public final void removeElement(OSXHIDElement element) throws IOException {
        nRemoveElement(this.queue_address, element.getCookie());
        this.map.remove(new Long(element.getCookie()));
    }

    public final synchronized boolean getNextEvent(OSXEvent event) throws IOException {
        checkReleased();
        return nGetNextEvent(this.queue_address, event);
    }

    private final void checkReleased() throws IOException {
        if (this.released) {
            throw new IOException("Queue is released");
        }
    }
}
