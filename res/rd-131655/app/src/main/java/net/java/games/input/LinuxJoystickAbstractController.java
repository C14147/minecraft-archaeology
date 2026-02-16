package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickAbstractController.class */
final class LinuxJoystickAbstractController extends AbstractController {
    private final LinuxJoystickDevice device;

    protected LinuxJoystickAbstractController(LinuxJoystickDevice device, Component[] components, Controller[] children, Rumbler[] rumblers) {
        super(device.getName(), components, children, rumblers);
        this.device = device;
    }

    @Override // net.java.games.input.AbstractController
    protected final void setDeviceEventQueueSize(int size) throws IOException {
        this.device.setBufferSize(size);
    }

    @Override // net.java.games.input.AbstractController
    public final void pollDevice() throws IOException {
        this.device.poll();
    }

    @Override // net.java.games.input.AbstractController
    protected final boolean getNextDeviceEvent(Event event) throws IOException {
        return this.device.getNextEvent(event);
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return Controller.Type.STICK;
    }
}
