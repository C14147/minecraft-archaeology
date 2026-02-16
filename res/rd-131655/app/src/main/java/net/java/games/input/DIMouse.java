package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DIMouse.class */
final class DIMouse extends Mouse {
    private final IDirectInputDevice device;

    protected DIMouse(IDirectInputDevice device, Component[] components, Controller[] children, Rumbler[] rumblers) {
        super(device.getProductName(), components, children, rumblers);
        this.device = device;
    }

    @Override // net.java.games.input.AbstractController
    public final void pollDevice() throws IOException {
        this.device.pollAll();
    }

    @Override // net.java.games.input.AbstractController
    protected final boolean getNextDeviceEvent(Event event) throws IOException {
        return DIControllers.getNextDeviceEvent(event, this.device);
    }

    @Override // net.java.games.input.AbstractController
    protected final void setDeviceEventQueueSize(int size) throws Throwable {
        this.device.setBufferSize(size);
    }
}
