package net.java.games.input;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabContext.class */
public class WinTabContext {
    private DummyWindow window;
    private long hCTX;
    private Controller[] controllers;

    private static final native int nGetNumberOfSupportedDevices();

    private static final native long nOpen(long j);

    private static final native void nClose(long j);

    private static final native WinTabPacket[] nGetPackets(long j);

    public WinTabContext(DummyWindow window) {
        this.window = window;
    }

    public Controller[] getControllers() {
        if (this.hCTX == 0) {
            throw new IllegalStateException("Context must be open before getting the controllers");
        }
        return this.controllers;
    }

    public synchronized void open() {
        this.hCTX = nOpen(this.window.getHwnd());
        List devices = new ArrayList();
        int numSupportedDevices = nGetNumberOfSupportedDevices();
        for (int i = 0; i < numSupportedDevices; i++) {
            WinTabDevice newDevice = WinTabDevice.createDevice(this, i);
            if (newDevice != null) {
                devices.add(newDevice);
            }
        }
        this.controllers = (Controller[]) devices.toArray(new Controller[0]);
    }

    public synchronized void close() {
        nClose(this.hCTX);
    }

    public synchronized void processEvents() {
        WinTabPacket[] packets = nGetPackets(this.hCTX);
        for (WinTabPacket winTabPacket : packets) {
            ((WinTabDevice) getControllers()[0]).processPacket(winTabPacket);
        }
    }
}
