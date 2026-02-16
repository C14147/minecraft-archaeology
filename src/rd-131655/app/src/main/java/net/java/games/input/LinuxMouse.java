package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxMouse.class */
final class LinuxMouse extends Mouse {
    private final Controller.PortType port;
    private final LinuxEventDevice device;

    protected LinuxMouse(LinuxEventDevice device, Component[] components, Controller[] children, Rumbler[] rumblers) throws IOException {
        super(device.getName(), components, children, rumblers);
        this.device = device;
        this.port = device.getPortType();
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
}
