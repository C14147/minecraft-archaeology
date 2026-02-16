package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.java.games.input.Component;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabComponent.class */
public class WinTabComponent extends AbstractComponent {
    public static final int XAxis = 1;
    public static final int YAxis = 2;
    public static final int ZAxis = 3;
    public static final int NPressureAxis = 4;
    public static final int TPressureAxis = 5;
    public static final int OrientationAxis = 6;
    public static final int RotationAxis = 7;
    private int min;
    private int max;
    protected float lastKnownValue;
    private boolean analog;
    static Class class$net$java$games$input$Component$Identifier$Button;

    protected WinTabComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id, int min, int max) {
        super(name, id);
        this.min = min;
        this.max = max;
        this.analog = true;
    }

    protected WinTabComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id) {
        super(name, id);
        this.min = 0;
        this.max = 1;
        this.analog = false;
    }

    @Override // net.java.games.input.AbstractComponent
    protected float poll() throws IOException {
        return this.lastKnownValue;
    }

    @Override // net.java.games.input.AbstractComponent, net.java.games.input.Component
    public boolean isAnalog() {
        return this.analog;
    }

    @Override // net.java.games.input.Component
    public boolean isRelative() {
        return false;
    }

    public static List createComponents(WinTabContext context, int parentDevice, int axisId, int[] axisRanges) {
        List components = new ArrayList();
        switch (axisId) {
            case 1:
                Component.Identifier id = Component.Identifier.Axis.X;
                components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
                break;
            case 2:
                Component.Identifier id2 = Component.Identifier.Axis.Y;
                components.add(new WinTabComponent(context, parentDevice, id2.getName(), id2, axisRanges[0], axisRanges[1]));
                break;
            case 3:
                Component.Identifier id3 = Component.Identifier.Axis.Z;
                components.add(new WinTabComponent(context, parentDevice, id3.getName(), id3, axisRanges[0], axisRanges[1]));
                break;
            case 4:
                Component.Identifier id4 = Component.Identifier.Axis.X_FORCE;
                components.add(new WinTabComponent(context, parentDevice, id4.getName(), id4, axisRanges[0], axisRanges[1]));
                break;
            case 5:
                Component.Identifier id5 = Component.Identifier.Axis.Y_FORCE;
                components.add(new WinTabComponent(context, parentDevice, id5.getName(), id5, axisRanges[0], axisRanges[1]));
                break;
            case 6:
                Component.Identifier id6 = Component.Identifier.Axis.RX;
                components.add(new WinTabComponent(context, parentDevice, id6.getName(), id6, axisRanges[0], axisRanges[1]));
                Component.Identifier id7 = Component.Identifier.Axis.RY;
                components.add(new WinTabComponent(context, parentDevice, id7.getName(), id7, axisRanges[2], axisRanges[3]));
                Component.Identifier id8 = Component.Identifier.Axis.RZ;
                components.add(new WinTabComponent(context, parentDevice, id8.getName(), id8, axisRanges[4], axisRanges[5]));
                break;
            case 7:
                Component.Identifier id9 = Component.Identifier.Axis.RX;
                components.add(new WinTabComponent(context, parentDevice, id9.getName(), id9, axisRanges[0], axisRanges[1]));
                Component.Identifier id10 = Component.Identifier.Axis.RY;
                components.add(new WinTabComponent(context, parentDevice, id10.getName(), id10, axisRanges[2], axisRanges[3]));
                Component.Identifier id11 = Component.Identifier.Axis.RZ;
                components.add(new WinTabComponent(context, parentDevice, id11.getName(), id11, axisRanges[4], axisRanges[5]));
                break;
        }
        return components;
    }

    public static Collection createButtons(WinTabContext context, int deviceIndex, int numberOfButtons) throws Throwable {
        Class clsClass$;
        List buttons = new ArrayList();
        for (int i = 0; i < numberOfButtons; i++) {
            try {
                if (class$net$java$games$input$Component$Identifier$Button == null) {
                    clsClass$ = class$("net.java.games.input.Component$Identifier$Button");
                    class$net$java$games$input$Component$Identifier$Button = clsClass$;
                } else {
                    clsClass$ = class$net$java$games$input$Component$Identifier$Button;
                }
                Class buttonIdClass = clsClass$;
                Field idField = buttonIdClass.getField(new StringBuffer().append("_").append(i).toString());
                Component.Identifier id = (Component.Identifier) idField.get(null);
                buttons.add(new WinTabButtonComponent(context, deviceIndex, id.getName(), id, i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (SecurityException e4) {
                e4.printStackTrace();
            }
        }
        return buttons;
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    public Event processPacket(WinTabPacket packet) {
        float newValue = this.lastKnownValue;
        if (getIdentifier() == Component.Identifier.Axis.X) {
            newValue = normalise(packet.PK_X);
        }
        if (getIdentifier() == Component.Identifier.Axis.Y) {
            newValue = normalise(packet.PK_Y);
        }
        if (getIdentifier() == Component.Identifier.Axis.Z) {
            newValue = normalise(packet.PK_Z);
        }
        if (getIdentifier() == Component.Identifier.Axis.X_FORCE) {
            newValue = normalise(packet.PK_NORMAL_PRESSURE);
        }
        if (getIdentifier() == Component.Identifier.Axis.Y_FORCE) {
            newValue = normalise(packet.PK_TANGENT_PRESSURE);
        }
        if (getIdentifier() == Component.Identifier.Axis.RX) {
            newValue = normalise(packet.PK_ORIENTATION_ALT);
        }
        if (getIdentifier() == Component.Identifier.Axis.RY) {
            newValue = normalise(packet.PK_ORIENTATION_AZ);
        }
        if (getIdentifier() == Component.Identifier.Axis.RZ) {
            newValue = normalise(packet.PK_ORIENTATION_TWIST);
        }
        if (newValue != getPollData()) {
            this.lastKnownValue = newValue;
            Event newEvent = new Event();
            newEvent.set(this, newValue, packet.PK_TIME * 1000);
            return newEvent;
        }
        return null;
    }

    private float normalise(float value) {
        if (this.max == this.min) {
            return value;
        }
        float bottom = this.max - this.min;
        return (value - this.min) / bottom;
    }

    public static Collection createCursors(WinTabContext context, int deviceIndex, String[] cursorNames) {
        Component.Identifier identifier;
        List cursors = new ArrayList();
        for (int i = 0; i < cursorNames.length; i++) {
            if (cursorNames[i].matches("Puck")) {
                identifier = Component.Identifier.Button.TOOL_FINGER;
            } else if (cursorNames[i].matches("Eraser.*")) {
                identifier = Component.Identifier.Button.TOOL_RUBBER;
            } else {
                identifier = Component.Identifier.Button.TOOL_PEN;
            }
            Component.Identifier id = identifier;
            cursors.add(new WinTabCursorComponent(context, deviceIndex, id.getName(), id, i));
        }
        return cursors;
    }
}
