package net.java.games.input;

import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/Rumbler.class */
public interface Rumbler {
    void rumble(float f);

    String getAxisName();

    Component.Identifier getAxisIdentifier();
}
