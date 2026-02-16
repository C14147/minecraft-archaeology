package org.lwjgl.util.jinput;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.java.games.input.Rumbler;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLKeyboard.class */
final class LWJGLKeyboard extends Keyboard {
    LWJGLKeyboard() {
        super("LWJGLKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
    }

    private static Component[] createComponents() {
        int vkey_code;
        Component.Identifier.Key key_id;
        List<Key> components = new ArrayList<>();
        Field[] vkey_fields = org.lwjgl.input.Keyboard.class.getFields();
        for (Field vkey_field : vkey_fields) {
            try {
                if (Modifier.isStatic(vkey_field.getModifiers()) && vkey_field.getType() == Integer.TYPE && vkey_field.getName().startsWith("KEY_") && (key_id = KeyMap.map((vkey_code = vkey_field.getInt(null)))) != Component.Identifier.Key.UNKNOWN) {
                    components.add(new Key(key_id, vkey_code));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return (Component[]) components.toArray(new Component[components.size()]);
    }

    @Override // net.java.games.input.AbstractController
    public synchronized void pollDevice() throws IOException {
        if (!org.lwjgl.input.Keyboard.isCreated()) {
            return;
        }
        org.lwjgl.input.Keyboard.poll();
        Component[] arr$ = getComponents();
        for (Component component : arr$) {
            Key key = (Key) component;
            key.update();
        }
    }

    @Override // net.java.games.input.AbstractController
    protected synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        int lwjgl_key;
        Component.Identifier.Key key_id;
        Component key;
        if (!org.lwjgl.input.Keyboard.isCreated() || !org.lwjgl.input.Keyboard.next() || (lwjgl_key = org.lwjgl.input.Keyboard.getEventKey()) == 0 || (key_id = KeyMap.map(lwjgl_key)) == null || (key = getComponent(key_id)) == null) {
            return false;
        }
        float value = org.lwjgl.input.Keyboard.getEventKeyState() ? 1.0f : 0.0f;
        event.set(key, value, org.lwjgl.input.Keyboard.getEventNanoseconds());
        return true;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLKeyboard$Key.class */
    private static final class Key extends AbstractComponent {
        private final int lwjgl_key;
        private float value;

        Key(Component.Identifier.Key key_id, int lwjgl_key) {
            super(key_id.getName(), key_id);
            this.lwjgl_key = lwjgl_key;
        }

        public void update() {
            this.value = org.lwjgl.input.Keyboard.isKeyDown(this.lwjgl_key) ? 1.0f : 0.0f;
        }

        @Override // net.java.games.input.AbstractComponent
        protected float poll() {
            return this.value;
        }

        @Override // net.java.games.input.Component
        public boolean isRelative() {
            return false;
        }

        @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
        public boolean isAnalog() {
            return false;
        }
    }
}
