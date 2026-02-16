package net.java.games.input;

import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DirectAndRawInputEnvironmentPlugin.class */
public class DirectAndRawInputEnvironmentPlugin extends ControllerEnvironment {
    private Controller[] controllers = null;
    private DirectInputEnvironmentPlugin dinputPlugin = new DirectInputEnvironmentPlugin();
    private RawInputEnvironmentPlugin rawPlugin = new RawInputEnvironmentPlugin();

    @Override // net.java.games.input.ControllerEnvironment
    public Controller[] getControllers() {
        if (this.controllers == null) {
            boolean rawKeyboardFound = false;
            boolean rawMouseFound = false;
            List tempControllers = new ArrayList();
            Controller[] dinputControllers = this.dinputPlugin.getControllers();
            Controller[] rawControllers = this.rawPlugin.getControllers();
            for (int i = 0; i < rawControllers.length; i++) {
                tempControllers.add(rawControllers[i]);
                if (rawControllers[i].getType() == Controller.Type.KEYBOARD) {
                    rawKeyboardFound = true;
                } else if (rawControllers[i].getType() == Controller.Type.MOUSE) {
                    rawMouseFound = true;
                }
            }
            for (int i2 = 0; i2 < dinputControllers.length; i2++) {
                if (dinputControllers[i2].getType() == Controller.Type.KEYBOARD) {
                    if (!rawKeyboardFound) {
                        tempControllers.add(dinputControllers[i2]);
                    }
                } else if (dinputControllers[i2].getType() == Controller.Type.MOUSE) {
                    if (!rawMouseFound) {
                        tempControllers.add(dinputControllers[i2]);
                    }
                } else {
                    tempControllers.add(dinputControllers[i2]);
                }
            }
            this.controllers = (Controller[]) tempControllers.toArray(new Controller[0]);
        }
        return this.controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return this.rawPlugin.isSupported() || this.dinputPlugin.isSupported();
    }
}
