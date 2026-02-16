package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawKeyboard.class */
final class RawKeyboard extends Keyboard {
    private final RawKeyboardEvent raw_event;
    private final RawDevice device;
    static Class class$net$java$games$input$RawIdentifierMap;

    protected RawKeyboard(String name, RawDevice device, Controller[] children, Rumbler[] rumblers) throws IOException {
        super(name, createKeyboardComponents(device), children, rumblers);
        this.raw_event = new RawKeyboardEvent();
        this.device = device;
    }

    private static final Component[] createKeyboardComponents(RawDevice device) throws Throwable {
        Class clsClass$;
        int vkey_code;
        Component.Identifier.Key key_id;
        List components = new ArrayList();
        if (class$net$java$games$input$RawIdentifierMap == null) {
            clsClass$ = class$("net.java.games.input.RawIdentifierMap");
            class$net$java$games$input$RawIdentifierMap = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$RawIdentifierMap;
        }
        Field[] vkey_fields = clsClass$.getFields();
        for (Field vkey_field : vkey_fields) {
            try {
                if (Modifier.isStatic(vkey_field.getModifiers()) && vkey_field.getType() == Integer.TYPE && (key_id = RawIdentifierMap.mapVKey((vkey_code = vkey_field.getInt(null)))) != Component.Identifier.Key.UNKNOWN) {
                    components.add(new Key(device, vkey_code, key_id));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return (Component[]) components.toArray(new Component[0]);
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    @Override // net.java.games.input.AbstractController
    protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        while (this.device.getNextKeyboardEvent(this.raw_event)) {
            int vkey = this.raw_event.getVKey();
            Component.Identifier.Key key_id = RawIdentifierMap.mapVKey(vkey);
            Component key = getComponent(key_id);
            if (key != null) {
                int message = this.raw_event.getMessage();
                if (message == 256 || message == 260) {
                    event.set(key, 1.0f, this.raw_event.getNanos());
                    return true;
                }
                if (message == 257 || message == 261) {
                    event.set(key, 0.0f, this.raw_event.getNanos());
                    return true;
                }
            }
        }
        return false;
    }

    @Override // net.java.games.input.AbstractController
    public final void pollDevice() throws IOException {
        this.device.pollKeyboard();
    }

    @Override // net.java.games.input.AbstractController
    protected final void setDeviceEventQueueSize(int size) throws Throwable {
        this.device.setBufferSize(size);
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawKeyboard$Key.class */
    static final class Key extends AbstractComponent {
        private final RawDevice device;
        private final int vkey_code;

        public Key(RawDevice device, int vkey_code, Component.Identifier.Key key_id) {
            super(key_id.getName(), key_id);
            this.device = device;
            this.vkey_code = vkey_code;
        }

        @Override // net.java.games.input.AbstractComponent
        protected final float poll() throws IOException {
            return this.device.isKeyDown(this.vkey_code) ? 1.0f : 0.0f;
        }

        @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
        public final boolean isAnalog() {
            return false;
        }

        @Override // net.java.games.input.Component
        public final boolean isRelative() {
            return false;
        }
    }
}
