package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTMouse.class */
final class AWTMouse extends Mouse implements AWTEventListener {
    private static final int EVENT_X = 1;
    private static final int EVENT_Y = 2;
    private static final int EVENT_BUTTON = 4;
    private final List awt_events;
    private final List processed_awt_events;
    private int event_state;

    protected AWTMouse() {
        super("AWTMouse", createComponents(), new Controller[0], new Rumbler[0]);
        this.awt_events = new ArrayList();
        this.processed_awt_events = new ArrayList();
        this.event_state = 1;
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 131120L);
    }

    private static final Component[] createComponents() {
        return new Component[]{new Axis(Component.Identifier.Axis.X), new Axis(Component.Identifier.Axis.Y), new Axis(Component.Identifier.Axis.Z), new Button(Component.Identifier.Button.LEFT), new Button(Component.Identifier.Button.MIDDLE), new Button(Component.Identifier.Button.RIGHT)};
    }

    private final void processButtons(int button_enum, float value) {
        Button button = getButton(button_enum);
        if (button != null) {
            button.setValue(value);
        }
    }

    private final Button getButton(int button_enum) {
        switch (button_enum) {
            case 0:
            default:
                return null;
            case 1:
                return (Button) getLeft();
            case 2:
                return (Button) getMiddle();
            case 3:
                return (Button) getRight();
        }
    }

    private final void processEvent(AWTEvent event) throws IOException {
        if (event instanceof MouseWheelEvent) {
            MouseWheelEvent mwe = (MouseWheelEvent) event;
            Axis wheel = (Axis) getWheel();
            wheel.setValue(wheel.poll() + mwe.getWheelRotation());
        } else if (event instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) event;
            Axis x = (Axis) getX();
            Axis y = (Axis) getY();
            x.setValue(me.getX());
            y.setValue(me.getY());
            switch (me.getID()) {
                case 501:
                    processButtons(me.getButton(), 1.0f);
                    break;
                case 502:
                    processButtons(me.getButton(), 0.0f);
                    break;
            }
        }
    }

    @Override // net.java.games.input.AbstractController
    public final synchronized void pollDevice() throws IOException {
        Axis wheel = (Axis) getWheel();
        wheel.setValue(0.0f);
        for (int i = 0; i < this.awt_events.size(); i++) {
            AWTEvent event = (AWTEvent) this.awt_events.get(i);
            processEvent(event);
            this.processed_awt_events.add(event);
        }
        this.awt_events.clear();
    }

    @Override // net.java.games.input.AbstractController
    protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        while (!this.processed_awt_events.isEmpty()) {
            MouseEvent mouseEvent = (AWTEvent) this.processed_awt_events.get(0);
            if (mouseEvent instanceof MouseWheelEvent) {
                MouseWheelEvent awt_wheel_event = (MouseWheelEvent) mouseEvent;
                event.set(getWheel(), awt_wheel_event.getWheelRotation(), awt_wheel_event.getWhen() * 1000000);
                this.processed_awt_events.remove(0);
            } else if (mouseEvent instanceof MouseEvent) {
                MouseEvent mouse_event = mouseEvent;
                long nanos = mouse_event.getWhen() * 1000000;
                switch (this.event_state) {
                    case 1:
                        this.event_state = 2;
                        event.set(getX(), mouse_event.getX(), nanos);
                        return true;
                    case 2:
                        this.event_state = 4;
                        event.set(getY(), mouse_event.getY(), nanos);
                        return true;
                    case 3:
                    default:
                        throw new RuntimeException(new StringBuffer().append("Unknown event state: ").append(this.event_state).toString());
                    case 4:
                        this.processed_awt_events.remove(0);
                        this.event_state = 1;
                        Button button = getButton(mouse_event.getButton());
                        if (button == null) {
                            continue;
                        } else {
                            switch (mouse_event.getID()) {
                                case 501:
                                    event.set(button, 1.0f, nanos);
                                    return true;
                                case 502:
                                    event.set(button, 0.0f, nanos);
                                    return true;
                            }
                        }
                        break;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final synchronized void eventDispatched(AWTEvent event) {
        this.awt_events.add(event);
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTMouse$Axis.class */
    static final class Axis extends AbstractComponent {
        private float value;

        public Axis(Component.Identifier.Axis axis_id) {
            super(axis_id.getName(), axis_id);
        }

        @Override // net.java.games.input.Component
        public final boolean isRelative() {
            return false;
        }

        @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
        public final boolean isAnalog() {
            return true;
        }

        protected final void setValue(float value) {
            this.value = value;
        }

        @Override // net.java.games.input.AbstractComponent
        protected final float poll() throws IOException {
            return this.value;
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AWTMouse$Button.class */
    static final class Button extends AbstractComponent {
        private float value;

        public Button(Component.Identifier.Button button_id) {
            super(button_id.getName(), button_id);
        }

        protected final void setValue(float value) {
            this.value = value;
        }

        @Override // net.java.games.input.AbstractComponent
        protected final float poll() throws IOException {
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
