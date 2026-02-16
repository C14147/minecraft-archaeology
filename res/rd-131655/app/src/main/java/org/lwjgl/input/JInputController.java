package org.lwjgl.input;

import java.util.ArrayList;
import net.java.games.input.Component;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Rumbler;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/JInputController.class */
class JInputController implements Controller {
    private net.java.games.input.Controller target;
    private int index;
    private ArrayList<Component> buttons = new ArrayList<>();
    private ArrayList<Component> axes = new ArrayList<>();
    private ArrayList<Component> pov = new ArrayList<>();
    private Rumbler[] rumblers;
    private boolean[] buttonState;
    private float[] povValues;
    private float[] axesValue;
    private float[] axesMax;
    private float[] deadZones;
    private int xaxis;
    private int yaxis;
    private int zaxis;
    private int rxaxis;
    private int ryaxis;
    private int rzaxis;

    JInputController(int index, net.java.games.input.Controller target) {
        this.xaxis = -1;
        this.yaxis = -1;
        this.zaxis = -1;
        this.rxaxis = -1;
        this.ryaxis = -1;
        this.rzaxis = -1;
        this.target = target;
        this.index = index;
        Component[] sourceAxes = target.getComponents();
        for (Component sourceAxis : sourceAxes) {
            if (sourceAxis.getIdentifier() instanceof Component.Identifier.Button) {
                this.buttons.add(sourceAxis);
            } else if (sourceAxis.getIdentifier().equals(Component.Identifier.Axis.POV)) {
                this.pov.add(sourceAxis);
            } else {
                this.axes.add(sourceAxis);
            }
        }
        this.buttonState = new boolean[this.buttons.size()];
        this.povValues = new float[this.pov.size()];
        this.axesValue = new float[this.axes.size()];
        int buttonsCount = 0;
        int axesCount = 0;
        for (Component sourceAxis2 : sourceAxes) {
            if (sourceAxis2.getIdentifier() instanceof Component.Identifier.Button) {
                this.buttonState[buttonsCount] = sourceAxis2.getPollData() != 0.0f;
                buttonsCount++;
            } else if (!sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.POV)) {
                this.axesValue[axesCount] = sourceAxis2.getPollData();
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.X)) {
                    this.xaxis = axesCount;
                }
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.Y)) {
                    this.yaxis = axesCount;
                }
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.Z)) {
                    this.zaxis = axesCount;
                }
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.RX)) {
                    this.rxaxis = axesCount;
                }
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.RY)) {
                    this.ryaxis = axesCount;
                }
                if (sourceAxis2.getIdentifier().equals(Component.Identifier.Axis.RZ)) {
                    this.rzaxis = axesCount;
                }
                axesCount++;
            }
        }
        this.axesMax = new float[this.axes.size()];
        this.deadZones = new float[this.axes.size()];
        for (int i = 0; i < this.axesMax.length; i++) {
            this.axesMax[i] = 1.0f;
            this.deadZones[i] = 0.05f;
        }
        this.rumblers = target.getRumblers();
    }

    @Override // org.lwjgl.input.Controller
    public String getName() {
        String name = this.target.getName();
        return name;
    }

    @Override // org.lwjgl.input.Controller
    public int getIndex() {
        return this.index;
    }

    @Override // org.lwjgl.input.Controller
    public int getButtonCount() {
        return this.buttons.size();
    }

    @Override // org.lwjgl.input.Controller
    public String getButtonName(int index) {
        return this.buttons.get(index).getName();
    }

    @Override // org.lwjgl.input.Controller
    public boolean isButtonPressed(int index) {
        return this.buttonState[index];
    }

    @Override // org.lwjgl.input.Controller
    public void poll() {
        this.target.poll();
        Event event = new Event();
        EventQueue queue = this.target.getEventQueue();
        while (queue.getNextEvent(event)) {
            if (this.buttons.contains(event.getComponent())) {
                Component button = event.getComponent();
                int buttonIndex = this.buttons.indexOf(button);
                this.buttonState[buttonIndex] = event.getValue() != 0.0f;
                Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 1, buttonIndex, this.buttonState[buttonIndex], false, false, 0.0f, 0.0f));
            }
            if (this.pov.contains(event.getComponent())) {
                Component povComponent = event.getComponent();
                int povIndex = this.pov.indexOf(povComponent);
                float prevX = getPovX();
                float prevY = getPovY();
                this.povValues[povIndex] = event.getValue();
                if (prevX != getPovX()) {
                    Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 3, 0, false, false));
                }
                if (prevY != getPovY()) {
                    Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 4, 0, false, false));
                }
            }
            if (this.axes.contains(event.getComponent())) {
                Component axis = event.getComponent();
                int axisIndex = this.axes.indexOf(axis);
                float value = axis.getPollData();
                float xaxisValue = 0.0f;
                float yaxisValue = 0.0f;
                if (Math.abs(value) < this.deadZones[axisIndex]) {
                    value = 0.0f;
                }
                if (Math.abs(value) < axis.getDeadZone()) {
                    value = 0.0f;
                }
                if (Math.abs(value) > this.axesMax[axisIndex]) {
                    this.axesMax[axisIndex] = Math.abs(value);
                }
                float value2 = value / this.axesMax[axisIndex];
                if (axisIndex == this.xaxis) {
                    xaxisValue = value2;
                }
                if (axisIndex == this.yaxis) {
                    yaxisValue = value2;
                }
                Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 2, axisIndex, false, axisIndex == this.xaxis, axisIndex == this.yaxis, xaxisValue, yaxisValue));
                this.axesValue[axisIndex] = value2;
            }
        }
    }

    @Override // org.lwjgl.input.Controller
    public int getAxisCount() {
        return this.axes.size();
    }

    @Override // org.lwjgl.input.Controller
    public String getAxisName(int index) {
        return this.axes.get(index).getName();
    }

    @Override // org.lwjgl.input.Controller
    public float getAxisValue(int index) {
        return this.axesValue[index];
    }

    @Override // org.lwjgl.input.Controller
    public float getXAxisValue() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.xaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getYAxisValue() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.yaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getXAxisDeadZone() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.xaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getYAxisDeadZone() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.yaxis);
    }

    @Override // org.lwjgl.input.Controller
    public void setXAxisDeadZone(float zone) {
        setDeadZone(this.xaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public void setYAxisDeadZone(float zone) {
        setDeadZone(this.yaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public float getDeadZone(int index) {
        return this.deadZones[index];
    }

    @Override // org.lwjgl.input.Controller
    public void setDeadZone(int index, float zone) {
        this.deadZones[index] = zone;
    }

    @Override // org.lwjgl.input.Controller
    public float getZAxisValue() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.zaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getZAxisDeadZone() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.zaxis);
    }

    @Override // org.lwjgl.input.Controller
    public void setZAxisDeadZone(float zone) {
        setDeadZone(this.zaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public float getRXAxisValue() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.rxaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getRXAxisDeadZone() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.rxaxis);
    }

    @Override // org.lwjgl.input.Controller
    public void setRXAxisDeadZone(float zone) {
        setDeadZone(this.rxaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public float getRYAxisValue() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.ryaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getRYAxisDeadZone() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.ryaxis);
    }

    @Override // org.lwjgl.input.Controller
    public void setRYAxisDeadZone(float zone) {
        setDeadZone(this.ryaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public float getRZAxisValue() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.rzaxis);
    }

    @Override // org.lwjgl.input.Controller
    public float getRZAxisDeadZone() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.rzaxis);
    }

    @Override // org.lwjgl.input.Controller
    public void setRZAxisDeadZone(float zone) {
        setDeadZone(this.rzaxis, zone);
    }

    @Override // org.lwjgl.input.Controller
    public float getPovX() {
        if (this.pov.size() == 0) {
            return 0.0f;
        }
        float value = this.povValues[0];
        if (value == 0.875f || value == 0.125f || value == 1.0f) {
            return -1.0f;
        }
        if (value == 0.625f || value == 0.375f || value == 0.5f) {
            return 1.0f;
        }
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public float getPovY() {
        if (this.pov.size() == 0) {
            return 0.0f;
        }
        float value = this.povValues[0];
        if (value == 0.875f || value == 0.625f || value == 0.75f) {
            return 1.0f;
        }
        if (value == 0.125f || value == 0.375f || value == 0.25f) {
            return -1.0f;
        }
        return 0.0f;
    }

    @Override // org.lwjgl.input.Controller
    public int getRumblerCount() {
        return this.rumblers.length;
    }

    @Override // org.lwjgl.input.Controller
    public String getRumblerName(int index) {
        return this.rumblers[index].getAxisName();
    }

    @Override // org.lwjgl.input.Controller
    public void setRumblerStrength(int index, float strength) {
        this.rumblers[index].rumble(strength);
    }
}
