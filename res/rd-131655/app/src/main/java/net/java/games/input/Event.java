package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/Event.class */
public final class Event {
    private Component component;
    private float value;
    private long nanos;

    public final void set(Event other) {
        set(other.getComponent(), other.getValue(), other.getNanos());
    }

    public final void set(Component component, float value, long nanos) {
        this.component = component;
        this.value = value;
        this.nanos = nanos;
    }

    public final Component getComponent() {
        return this.component;
    }

    public final float getValue() {
        return this.value;
    }

    public final long getNanos() {
        return this.nanos;
    }

    public final String toString() {
        return new StringBuffer().append("Event: component = ").append(this.component).append(" | value = ").append(this.value).toString();
    }
}
