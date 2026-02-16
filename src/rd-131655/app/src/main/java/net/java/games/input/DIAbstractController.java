package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DIAbstractController.class */
final class DIAbstractController extends AbstractController {
    private final IDirectInputDevice device;
    private final Controller.Type type;

    protected DIAbstractController(IDirectInputDevice device, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type) {
        super(device.getProductName(), components, children, rumblers);
        this.device = device;
        this.type = type;
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

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public final Controller.Type getType() {
        return this.type;
    }
}
