package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AbstractComponent.class */
public abstract class AbstractComponent implements Component {
    private final String name;
    private final Component.Identifier id;
    private boolean has_polled;
    private float value;
    private float event_value;

    protected abstract float poll() throws IOException;

    protected AbstractComponent(String name, Component.Identifier id) {
        this.name = name;
        this.id = id;
    }

    @Override // net.java.games.input.Component
    public Component.Identifier getIdentifier() {
        return this.id;
    }

    @Override // net.java.games.input.Component
    public boolean isAnalog() {
        return false;
    }

    @Override // net.java.games.input.Component
    public float getDeadZone() {
        return 0.0f;
    }

    @Override // net.java.games.input.Component
    public final float getPollData() throws Throwable {
        if (!this.has_polled && !isRelative()) {
            this.has_polled = true;
            try {
                setPollData(poll());
            } catch (IOException e) {
                ControllerEnvironment.log(new StringBuffer().append("Failed to poll component: ").append(e).toString());
            }
        }
        return this.value;
    }

    final void resetHasPolled() {
        this.has_polled = false;
    }

    final void setPollData(float value) {
        this.value = value;
    }

    final float getEventValue() {
        return this.event_value;
    }

    final void setEventValue(float event_value) {
        this.event_value = event_value;
    }

    @Override // net.java.games.input.Component
    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
