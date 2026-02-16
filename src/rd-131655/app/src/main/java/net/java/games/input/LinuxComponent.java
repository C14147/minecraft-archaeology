package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxComponent.class */
class LinuxComponent extends AbstractComponent {
    private final LinuxEventComponent component;

    public LinuxComponent(LinuxEventComponent component) {
        super(component.getIdentifier().getName(), component.getIdentifier());
        this.component = component;
    }

    @Override // net.java.games.input.Component
    public final boolean isRelative() {
        return this.component.isRelative();
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public final boolean isAnalog() {
        return this.component.isAnalog();
    }

    @Override // net.java.games.input.AbstractComponent
    protected float poll() throws IOException {
        return convertValue(LinuxControllers.poll(this.component), this.component.getDescriptor());
    }

    float convertValue(float value, LinuxAxisDescriptor descriptor) {
        return getComponent().convertValue(value);
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public final float getDeadZone() {
        return this.component.getDeadZone();
    }

    public final LinuxEventComponent getComponent() {
        return this.component;
    }
}
