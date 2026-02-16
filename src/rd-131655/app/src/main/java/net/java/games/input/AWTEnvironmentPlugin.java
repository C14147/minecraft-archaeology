package net.java.games.input;

import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTEnvironmentPlugin.class */
public class AWTEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private final Controller[] controllers = {new AWTKeyboard(), new AWTMouse()};

    @Override // net.java.games.input.ControllerEnvironment
    public Controller[] getControllers() {
        return this.controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return true;
    }
}
