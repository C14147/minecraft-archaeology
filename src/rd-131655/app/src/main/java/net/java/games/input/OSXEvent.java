package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXEvent.class */
class OSXEvent {
    private long type;
    private long cookie;
    private int value;
    private long nanos;

    OSXEvent() {
    }

    public void set(long type, long cookie, int value, long nanos) {
        this.type = type;
        this.cookie = cookie;
        this.value = value;
        this.nanos = nanos;
    }

    public long getType() {
        return this.type;
    }

    public long getCookie() {
        return this.cookie;
    }

    public int getValue() {
        return this.value;
    }

    public long getNanos() {
        return this.nanos;
    }
}
