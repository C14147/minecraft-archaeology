package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickAxis.class */
class LinuxJoystickAxis extends AbstractComponent {
    private float value;
    private boolean analog;

    public LinuxJoystickAxis(Component.Identifier.Axis axis_id) {
        this(axis_id, true);
    }

    public LinuxJoystickAxis(Component.Identifier.Axis axis_id, boolean analog) {
        super(axis_id.getName(), axis_id);
        this.analog = analog;
    }

    @Override // net.java.games.input.Component
    public final boolean isRelative() {
        return false;
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public final boolean isAnalog() {
        return this.analog;
    }

    final void setValue(float value) {
        this.value = value;
        resetHasPolled();
    }

    @Override // net.java.games.input.AbstractComponent
    protected final float poll() throws IOException {
        return this.value;
    }
}
