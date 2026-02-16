package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXComponent.class */
class OSXComponent extends AbstractComponent {
    private final OSXHIDElement element;

    public OSXComponent(Component.Identifier id, OSXHIDElement element) {
        super(id.getName(), id);
        this.element = element;
    }

    @Override // net.java.games.input.Component
    public final boolean isRelative() {
        return this.element.isRelative();
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public boolean isAnalog() {
        return this.element.isAnalog();
    }

    public final OSXHIDElement getElement() {
        return this.element;
    }

    @Override // net.java.games.input.AbstractComponent
    protected float poll() throws IOException {
        return OSXControllers.poll(this.element);
    }
}
