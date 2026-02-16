package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxAbstractController.class */
final class LinuxAbstractController extends AbstractController {
    private final Controller.PortType port;
    private final LinuxEventDevice device;
    private final Controller.Type type;

    protected LinuxAbstractController(LinuxEventDevice device, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type) throws IOException {
        super(device.getName(), components, children, rumblers);
        this.device = device;
        this.port = device.getPortType();
        this.type = type;
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public final Controller.PortType getPortType() {
        return this.port;
    }

    @Override // net.java.games.input.AbstractController
    public final void pollDevice() throws IOException {
        this.device.pollKeyStates();
    }

    @Override // net.java.games.input.AbstractController
    protected final boolean getNextDeviceEvent(Event event) throws IOException {
        return LinuxControllers.getNextDeviceEvent(event, this.device);
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return this.type;
    }
}
