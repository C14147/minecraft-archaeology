package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DIComponent.class */
final class DIComponent extends AbstractComponent {
    private final DIDeviceObject object;

    public DIComponent(Component.Identifier identifier, DIDeviceObject object) {
        super(object.getName(), identifier);
        this.object = object;
    }

    @Override // net.java.games.input.Component
    public final boolean isRelative() {
        return this.object.isRelative();
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public final boolean isAnalog() {
        return this.object.isAnalog();
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public final float getDeadZone() {
        return this.object.getDeadzone();
    }

    public final DIDeviceObject getDeviceObject() {
        return this.object;
    }

    @Override // net.java.games.input.AbstractComponent
    protected final float poll() throws IOException {
        return DIControllers.poll(this, this.object);
    }
}
