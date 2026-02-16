package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXAbstractController.class */
final class OSXAbstractController extends AbstractController {
    private final Controller.PortType port;
    private final OSXHIDQueue queue;
    private final Controller.Type type;

    protected OSXAbstractController(OSXHIDDevice device, OSXHIDQueue queue, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type) {
        super(device.getProductName(), components, children, rumblers);
        this.queue = queue;
        this.type = type;
        this.port = device.getPortType();
    }

    @Override // net.java.games.input.AbstractController
    protected final boolean getNextDeviceEvent(Event event) throws IOException {
        return OSXControllers.getNextDeviceEvent(event, this.queue);
    }

    @Override // net.java.games.input.AbstractController
    protected final void setDeviceEventQueueSize(int size) throws IOException {
        this.queue.setQueueDepth(size);
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return this.type;
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public final Controller.PortType getPortType() {
        return this.port;
    }
}
