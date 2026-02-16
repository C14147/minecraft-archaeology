package net.java.games.input;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawInputEventQueue.class */
final class RawInputEventQueue {
    private final Object monitor = new Object();
    private List devices;

    private final native void nPoll(long j) throws IOException;

    private static final native void nRegisterDevices(int i, long j, RawDeviceInfo[] rawDeviceInfoArr) throws IOException;

    RawInputEventQueue() {
    }

    public final void start(List devices) throws IOException {
        this.devices = devices;
        QueueThread queue = new QueueThread(this);
        synchronized (this.monitor) {
            queue.start();
            while (!queue.isInitialized()) {
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        if (queue.getException() != null) {
            throw queue.getException();
        }
    }

    private final RawDevice lookupDevice(long handle) {
        for (int i = 0; i < this.devices.size(); i++) {
            RawDevice device = (RawDevice) this.devices.get(i);
            if (device.getHandle() == handle) {
                return device;
            }
        }
        return null;
    }

    private final void addMouseEvent(long handle, long millis, int flags, int button_flags, int button_data, long raw_buttons, long last_x, long last_y, long extra_information) {
        RawDevice device = lookupDevice(handle);
        if (device == null) {
            return;
        }
        device.addMouseEvent(millis, flags, button_flags, button_data, raw_buttons, last_x, last_y, extra_information);
    }

    private final void addKeyboardEvent(long handle, long millis, int make_code, int flags, int vkey, int message, long extra_information) {
        RawDevice device = lookupDevice(handle);
        if (device == null) {
            return;
        }
        device.addKeyboardEvent(millis, make_code, flags, vkey, message, extra_information);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void poll(DummyWindow window) throws IOException {
        nPoll(window.getHwnd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerDevices(DummyWindow window, RawDeviceInfo[] devices) throws IOException {
        nRegisterDevices(0, window.getHwnd(), devices);
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawInputEventQueue$QueueThread.class */
    private final class QueueThread extends Thread {
        private boolean initialized;
        private DummyWindow window;
        private IOException exception;
        private final RawInputEventQueue this$0;

        public QueueThread(RawInputEventQueue rawInputEventQueue) {
            this.this$0 = rawInputEventQueue;
            setDaemon(true);
        }

        public final boolean isInitialized() {
            return this.initialized;
        }

        public final IOException getException() {
            return this.exception;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                this.window = new DummyWindow();
            } catch (IOException e) {
                this.exception = e;
            }
            this.initialized = true;
            synchronized (this.this$0.monitor) {
                this.this$0.monitor.notify();
            }
            if (this.exception != null) {
                return;
            }
            Set active_infos = new HashSet();
            for (int i = 0; i < this.this$0.devices.size(); i++) {
                try {
                    RawDevice device = (RawDevice) this.this$0.devices.get(i);
                    active_infos.add(device.getInfo());
                } catch (IOException e2) {
                    this.exception = e2;
                    return;
                }
            }
            RawDeviceInfo[] active_infos_array = new RawDeviceInfo[active_infos.size()];
            active_infos.toArray(active_infos_array);
            try {
                RawInputEventQueue.registerDevices(this.window, active_infos_array);
                while (!isInterrupted()) {
                    this.this$0.poll(this.window);
                }
                this.window.destroy();
            } catch (Throwable th) {
                this.window.destroy();
                throw th;
            }
        }
    }
}
