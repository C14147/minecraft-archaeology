package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickButton.class */
final class LinuxJoystickButton extends AbstractComponent {
    private float value;

    public LinuxJoystickButton(Component.Identifier button_id) {
        super(button_id.getName(), button_id);
    }

    @Override // net.java.games.input.Component
    public final boolean isRelative() {
        return false;
    }

    final void setValue(float value) {
        this.value = value;
    }

    @Override // net.java.games.input.AbstractComponent
    protected final float poll() throws IOException {
        return this.value;
    }
}
