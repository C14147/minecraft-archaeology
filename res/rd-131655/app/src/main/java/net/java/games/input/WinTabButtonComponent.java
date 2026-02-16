package net.java.games.input;

import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabButtonComponent.class */
public class WinTabButtonComponent extends WinTabComponent {
    private int index;

    protected WinTabButtonComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id, int index) {
        super(context, parentDevice, name, id);
        this.index = index;
    }

    @Override // net.java.games.input.WinTabComponent
    public Event processPacket(WinTabPacket packet) {
        float newValue = (packet.PK_BUTTONS & ((int) Math.pow(2.0d, (double) this.index))) > 0 ? 1.0f : 0.0f;
        if (newValue == getPollData()) {
            return null;
        }
        this.lastKnownValue = newValue;
        Event newEvent = new Event();
        newEvent.set(this, newValue, packet.PK_TIME * 1000);
        return newEvent;
    }
}
