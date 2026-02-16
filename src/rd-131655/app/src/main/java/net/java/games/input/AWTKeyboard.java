package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTKeyboard.class */
final class AWTKeyboard extends Keyboard implements AWTEventListener {
    private final List awt_events;
    private Event[] processed_events;
    private int processed_events_index;
    static Class class$java$awt$event$KeyEvent;

    protected AWTKeyboard() {
        super("AWTKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
        this.awt_events = new ArrayList();
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 8L);
        resizeEventQueue(32);
    }

    private static final Component[] createComponents() throws Throwable {
        Class clsClass$;
        List components = new ArrayList();
        if (class$java$awt$event$KeyEvent == null) {
            clsClass$ = class$("java.awt.event.KeyEvent");
            class$java$awt$event$KeyEvent = clsClass$;
        } else {
            clsClass$ = class$java$awt$event$KeyEvent;
        }
        Field[] vkey_fields = clsClass$.getFields();
        for (Field vkey_field : vkey_fields) {
            try {
                if (Modifier.isStatic(vkey_field.getModifiers()) && vkey_field.getType() == Integer.TYPE && vkey_field.getName().startsWith("VK_")) {
                    int vkey_code = vkey_field.getInt(null);
                    Component.Identifier.Key key_id = AWTKeyMap.mapKeyCode(vkey_code);
                    if (key_id != Component.Identifier.Key.UNKNOWN) {
                        components.add(new Key(key_id));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        components.add(new Key(Component.Identifier.Key.RCONTROL));
        components.add(new Key(Component.Identifier.Key.LCONTROL));
        components.add(new Key(Component.Identifier.Key.RSHIFT));
        components.add(new Key(Component.Identifier.Key.LSHIFT));
        components.add(new Key(Component.Identifier.Key.RALT));
        components.add(new Key(Component.Identifier.Key.LALT));
        components.add(new Key(Component.Identifier.Key.NUMPADENTER));
        components.add(new Key(Component.Identifier.Key.RETURN));
        components.add(new Key(Component.Identifier.Key.NUMPADCOMMA));
        components.add(new Key(Component.Identifier.Key.COMMA));
        return (Component[]) components.toArray(new Component[0]);
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    private final void resizeEventQueue(int size) {
        this.processed_events = new Event[size];
        for (int i = 0; i < this.processed_events.length; i++) {
            this.processed_events[i] = new Event();
        }
        this.processed_events_index = 0;
    }

    @Override // net.java.games.input.AbstractController
    protected final void setDeviceEventQueueSize(int size) throws IOException {
        resizeEventQueue(size);
    }

    public final synchronized void eventDispatched(AWTEvent event) {
        if (event instanceof KeyEvent) {
            this.awt_events.add(event);
        }
    }

    @Override // net.java.games.input.AbstractController
    public final synchronized void pollDevice() throws IOException {
        for (int i = 0; i < this.awt_events.size(); i++) {
            KeyEvent event = (KeyEvent) this.awt_events.get(i);
            processEvent(event);
        }
        this.awt_events.clear();
    }

    private final void processEvent(KeyEvent event) {
        Key key;
        Component.Identifier.Key key_id = AWTKeyMap.map(event);
        if (key_id == null || (key = (Key) getComponent(key_id)) == null) {
            return;
        }
        long nanos = event.getWhen() * 1000000;
        if (event.getID() == 401) {
            addEvent(key, 1.0f, nanos);
            return;
        }
        if (event.getID() == 402) {
            KeyEvent nextPress = Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent(NativeDefinitions.KEY_BLUE);
            if (nextPress == null || nextPress.getWhen() != event.getWhen()) {
                addEvent(key, 0.0f, nanos);
            }
        }
    }

    private final void addEvent(Key key, float value, long nanos) {
        key.setValue(value);
        if (this.processed_events_index < this.processed_events.length) {
            Event[] eventArr = this.processed_events;
            int i = this.processed_events_index;
            this.processed_events_index = i + 1;
            eventArr[i].set(key, value, nanos);
        }
    }

    @Override // net.java.games.input.AbstractController
    protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        if (this.processed_events_index == 0) {
            return false;
        }
        this.processed_events_index--;
        event.set(this.processed_events[0]);
        Event tmp = this.processed_events[0];
        this.processed_events[0] = this.processed_events[this.processed_events_index];
        this.processed_events[this.processed_events_index] = tmp;
        return true;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTKeyboard$Key.class */
    private static final class Key extends AbstractComponent {
        private float value;

        public Key(Component.Identifier.Key key_id) {
            super(key_id.getName(), key_id);
        }

        public final void setValue(float value) {
            this.value = value;
        }

        @Override // net.java.games.input.AbstractComponent
        protected final float poll() {
            return this.value;
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
