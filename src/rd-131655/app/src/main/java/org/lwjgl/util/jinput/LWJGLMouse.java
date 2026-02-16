package org.lwjgl.util.jinput;

import java.io.IOException;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Mouse;
import net.java.games.input.Rumbler;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLMouse.class */
final class LWJGLMouse extends Mouse {
    private static final int EVENT_X = 1;
    private static final int EVENT_Y = 2;
    private static final int EVENT_WHEEL = 3;
    private static final int EVENT_BUTTON = 4;
    private static final int EVENT_DONE = 5;
    private int event_state;

    LWJGLMouse() {
        super("LWJGLMouse", createComponents(), new Controller[0], new Rumbler[0]);
        this.event_state = 5;
    }

    private static Component[] createComponents() {
        return new Component[]{new Axis(Component.Identifier.Axis.X), new Axis(Component.Identifier.Axis.Y), new Axis(Component.Identifier.Axis.Z), new Button(Component.Identifier.Button.LEFT), new Button(Component.Identifier.Button.MIDDLE), new Button(Component.Identifier.Button.RIGHT)};
    }

    @Override // net.java.games.input.AbstractController
    public synchronized void pollDevice() throws IOException {
        if (!org.lwjgl.input.Mouse.isCreated()) {
            return;
        }
        org.lwjgl.input.Mouse.poll();
        for (int i = 0; i < 3; i++) {
            setButtonState(i);
        }
    }

    private Button map(int lwjgl_button) {
        switch (lwjgl_button) {
            case 0:
                return (Button) getLeft();
            case 1:
                return (Button) getRight();
            case 2:
                return (Button) getMiddle();
            default:
                return null;
        }
    }

    private void setButtonState(int lwjgl_button) {
        Button button = map(lwjgl_button);
        if (button != null) {
            button.setValue(org.lwjgl.input.Mouse.isButtonDown(lwjgl_button) ? 1.0f : 0.0f);
        }
    }

    @Override // net.java.games.input.AbstractController
    protected synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        Button button;
        if (!org.lwjgl.input.Mouse.isCreated()) {
            return false;
        }
        while (true) {
            long nanos = org.lwjgl.input.Mouse.getEventNanoseconds();
            switch (this.event_state) {
                case 1:
                    this.event_state = 2;
                    int dx = org.lwjgl.input.Mouse.getEventDX();
                    if (dx != 0) {
                        event.set(getX(), dx, nanos);
                        return true;
                    }
                    break;
                case 2:
                    this.event_state = 3;
                    int dy = -org.lwjgl.input.Mouse.getEventDY();
                    if (dy != 0) {
                        event.set(getY(), dy, nanos);
                        return true;
                    }
                    break;
                case 3:
                    this.event_state = 4;
                    int dwheel = org.lwjgl.input.Mouse.getEventDWheel();
                    if (dwheel != 0) {
                        event.set(getWheel(), dwheel, nanos);
                        return true;
                    }
                    break;
                case 4:
                    this.event_state = 5;
                    int lwjgl_button = org.lwjgl.input.Mouse.getEventButton();
                    if (lwjgl_button != -1 && (button = map(lwjgl_button)) != null) {
                        event.set(button, org.lwjgl.input.Mouse.getEventButtonState() ? 1.0f : 0.0f, nanos);
                        return true;
                    }
                    break;
                    break;
                case 5:
                    if (!org.lwjgl.input.Mouse.next()) {
                        return false;
                    }
                    this.event_state = 1;
                    break;
                    break;
            }
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLMouse$Axis.class */
    static final class Axis extends AbstractComponent {
        Axis(Component.Identifier.Axis axis_id) {
            super(axis_id.getName(), axis_id);
        }

        @Override // net.java.games.input.Component
        public boolean isRelative() {
            return true;
        }

        @Override // net.java.games.input.AbstractComponent
        protected float poll() throws IOException {
            return 0.0f;
        }

        @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
        public boolean isAnalog() {
            return true;
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/jinput/LWJGLMouse$Button.class */
    static final class Button extends AbstractComponent {
        private float value;

        Button(Component.Identifier.Button button_id) {
            super(button_id.getName(), button_id);
        }

        void setValue(float value) {
            this.value = value;
        }

        @Override // net.java.games.input.AbstractComponent
        protected float poll() throws IOException {
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
