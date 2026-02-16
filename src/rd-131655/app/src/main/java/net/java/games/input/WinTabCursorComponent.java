package net.java.games.input;

import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabCursorComponent.class */
public class WinTabCursorComponent extends WinTabComponent {
    private int index;

    protected WinTabCursorComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id, int index) {
        super(context, parentDevice, name, id);
        this.index = index;
    }

    @Override // net.java.games.input.WinTabComponent
    public Event processPacket(WinTabPacket packet) {
        Event newEvent = null;
        if (packet.PK_CURSOR == this.index && this.lastKnownValue == 0.0f) {
            this.lastKnownValue = 1.0f;
            newEvent = new Event();
            newEvent.set(this, this.lastKnownValue, packet.PK_TIME * 1000);
        } else if (packet.PK_CURSOR != this.index && this.lastKnownValue == 1.0f) {
            this.lastKnownValue = 0.0f;
            newEvent = new Event();
            newEvent.set(this, this.lastKnownValue, packet.PK_TIME * 1000);
        }
        return newEvent;
    }
}
