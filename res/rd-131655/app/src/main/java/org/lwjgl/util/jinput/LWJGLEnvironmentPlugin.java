package org.lwjgl.util.jinput;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLEnvironmentPlugin.class */
public class LWJGLEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private final Controller[] controllers = {new LWJGLKeyboard(), new LWJGLMouse()};

    @Override // net.java.games.input.ControllerEnvironment
    public Controller[] getControllers() {
        return this.controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return true;
    }
}
