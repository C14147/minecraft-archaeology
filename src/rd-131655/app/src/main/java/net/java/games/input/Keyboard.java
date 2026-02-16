package net.java.games.input;

import net.java.games.input.Component;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/Keyboard.class */
public abstract class Keyboard extends AbstractController {
    protected Keyboard(String name, Component[] keys, Controller[] children, Rumbler[] rumblers) {
        super(name, keys, children, rumblers);
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return Controller.Type.KEYBOARD;
    }

    public final boolean isKeyDown(Component.Identifier.Key key_id) {
        Component key = getComponent(key_id);
        return (key == null || key.getPollData() == 0.0f) ? false : true;
    }
}
