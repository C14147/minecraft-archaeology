package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxPOV.class */
final class LinuxPOV extends LinuxComponent {
    private final LinuxEventComponent component_x;
    private final LinuxEventComponent component_y;
    private float last_x;
    private float last_y;

    public LinuxPOV(LinuxEventComponent component_x, LinuxEventComponent component_y) {
        super(component_x);
        this.component_x = component_x;
        this.component_y = component_y;
    }

    @Override // net.java.games.input.LinuxComponent, net.java.games.input.AbstractComponent
    protected final float poll() throws IOException {
        this.last_x = LinuxControllers.poll(this.component_x);
        this.last_y = LinuxControllers.poll(this.component_y);
        return convertValue(0.0f, null);
    }

    @Override // net.java.games.input.LinuxComponent
    public float convertValue(float value, LinuxAxisDescriptor descriptor) {
        if (descriptor == this.component_x.getDescriptor()) {
            this.last_x = value;
        }
        if (descriptor == this.component_y.getDescriptor()) {
            this.last_y = value;
        }
        if (this.last_x == -1.0f && this.last_y == -1.0f) {
            return 0.125f;
        }
        if (this.last_x == -1.0f && this.last_y == 0.0f) {
            return 1.0f;
        }
        if (this.last_x == -1.0f && this.last_y == 1.0f) {
            return 0.875f;
        }
        if (this.last_x == 0.0f && this.last_y == -1.0f) {
            return 0.25f;
        }
        if (this.last_x == 0.0f && this.last_y == 0.0f) {
            return 0.0f;
        }
        if (this.last_x == 0.0f && this.last_y == 1.0f) {
            return 0.75f;
        }
        if (this.last_x == 1.0f && this.last_y == -1.0f) {
            return 0.375f;
        }
        if (this.last_x == 1.0f && this.last_y == 0.0f) {
            return 0.5f;
        }
        if (this.last_x == 1.0f && this.last_y == 1.0f) {
            return 0.625f;
        }
        LinuxEnvironmentPlugin.logln(new StringBuffer().append("Unknown values x = ").append(this.last_x).append(" | y = ").append(this.last_y).toString());
        return 0.0f;
    }
}
