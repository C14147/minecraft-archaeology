package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxCombinedController.class */
public class LinuxCombinedController extends AbstractController {
    private LinuxAbstractController eventController;
    private LinuxJoystickAbstractController joystickController;

    LinuxCombinedController(LinuxAbstractController eventController, LinuxJoystickAbstractController joystickController) {
        super(eventController.getName(), joystickController.getComponents(), eventController.getControllers(), eventController.getRumblers());
        this.eventController = eventController;
        this.joystickController = joystickController;
    }

    @Override // net.java.games.input.AbstractController
    protected boolean getNextDeviceEvent(Event event) throws IOException {
        return this.joystickController.getNextDeviceEvent(event);
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public final Controller.PortType getPortType() {
        return this.eventController.getPortType();
    }

    @Override // net.java.games.input.AbstractController
    public final void pollDevice() throws IOException {
        this.eventController.pollDevice();
        this.joystickController.pollDevice();
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return this.eventController.getType();
    }
}
