package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/IDirectInput.class */
final class IDirectInput {
    private final List devices = new ArrayList();
    private final long idirectinput_address = createIDirectInput();
    private final DummyWindow window;

    private static final native long createIDirectInput() throws IOException;

    private final native void nEnumDevices(long j) throws IOException;

    private static final native void nRelease(long j);

    public IDirectInput(DummyWindow window) throws IOException {
        this.window = window;
        try {
            enumDevices();
        } catch (IOException e) {
            releaseDevices();
            release();
            throw e;
        }
    }

    public final List getDevices() {
        return this.devices;
    }

    private final void enumDevices() throws IOException {
        nEnumDevices(this.idirectinput_address);
    }

    private final void addDevice(long address, byte[] instance_guid, byte[] product_guid, int dev_type, int dev_subtype, String instance_name, String product_name) throws IOException {
        try {
            IDirectInputDevice device = new IDirectInputDevice(this.window, address, instance_guid, product_guid, dev_type, dev_subtype, instance_name, product_name);
            this.devices.add(device);
        } catch (IOException e) {
            DirectInputEnvironmentPlugin.logln(new StringBuffer().append("Failed to initialize device ").append(product_name).append(" because of: ").append(e).toString());
        }
    }

    public final void releaseDevices() {
        for (int i = 0; i < this.devices.size(); i++) {
            IDirectInputDevice device = (IDirectInputDevice) this.devices.get(i);
            device.release();
        }
    }

    public final void release() {
        nRelease(this.idirectinput_address);
    }
}
