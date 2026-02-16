package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxJoystickDevice.class */
final class LinuxJoystickDevice implements LinuxDevice {
    public static final int JS_EVENT_BUTTON = 1;
    public static final int JS_EVENT_AXIS = 2;
    public static final int JS_EVENT_INIT = 128;
    public static final int AXIS_MAX_VALUE = 32767;
    private final long fd;
    private final String name;
    private final LinuxJoystickButton[] buttons;
    private final LinuxJoystickAxis[] axes;
    private final byte[] axisMap;
    private final char[] buttonMap;
    private EventQueue event_queue;
    private boolean closed;
    private final LinuxJoystickEvent joystick_event = new LinuxJoystickEvent();
    private final Event event = new Event();
    private final Map povXs = new HashMap();
    private final Map povYs = new HashMap();

    private static final native long nOpen(String str) throws IOException;

    private static final native boolean nGetNextEvent(long j, LinuxJoystickEvent linuxJoystickEvent) throws IOException;

    private static final native int nGetNumButtons(long j) throws IOException;

    private static final native int nGetNumAxes(long j) throws IOException;

    private static final native byte[] nGetAxisMap(long j) throws IOException;

    private static final native char[] nGetButtonMap(long j) throws IOException;

    private static final native int nGetVersion(long j) throws IOException;

    private static final native String nGetName(long j) throws IOException;

    private static final native void nClose(long j) throws IOException;

    public LinuxJoystickDevice(String filename) throws IOException {
        this.fd = nOpen(filename);
        try {
            this.name = getDeviceName();
            setBufferSize(32);
            this.buttons = new LinuxJoystickButton[getNumDeviceButtons()];
            this.axes = new LinuxJoystickAxis[getNumDeviceAxes()];
            this.axisMap = getDeviceAxisMap();
            this.buttonMap = getDeviceButtonMap();
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    public final synchronized void setBufferSize(int size) {
        this.event_queue = new EventQueue(size);
    }

    private final void processEvent(LinuxJoystickEvent joystick_event) {
        LinuxJoystickAxis axis;
        LinuxJoystickButton button;
        int index = joystick_event.getNumber();
        int type = joystick_event.getType() & (-129);
        switch (type) {
            case 1:
                if (index < getNumButtons() && (button = this.buttons[index]) != null) {
                    float value = joystick_event.getValue();
                    button.setValue(value);
                    this.event.set(button, value, joystick_event.getNanos());
                } else {
                    return;
                }
                break;
            case 2:
                if (index < getNumAxes() && (axis = this.axes[index]) != null) {
                    float value2 = joystick_event.getValue() / 32767.0f;
                    axis.setValue(value2);
                    if (this.povXs.containsKey(new Integer(index))) {
                        LinuxJoystickPOV pov = (LinuxJoystickPOV) this.povXs.get(new Integer(index));
                        pov.updateValue();
                        this.event.set(pov, pov.getPollData(), joystick_event.getNanos());
                    } else if (this.povYs.containsKey(new Integer(index))) {
                        LinuxJoystickPOV pov2 = (LinuxJoystickPOV) this.povYs.get(new Integer(index));
                        pov2.updateValue();
                        this.event.set(pov2, pov2.getPollData(), joystick_event.getNanos());
                    } else {
                        this.event.set(axis, value2, joystick_event.getNanos());
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
        if (!this.event_queue.isFull()) {
            this.event_queue.add(this.event);
        }
    }

    public final void registerAxis(int index, LinuxJoystickAxis axis) {
        this.axes[index] = axis;
    }

    public final void registerButton(int index, LinuxJoystickButton button) {
        this.buttons[index] = button;
    }

    public final void registerPOV(LinuxJoystickPOV pov) {
        LinuxJoystickAxis xAxis = pov.getYAxis();
        LinuxJoystickAxis yAxis = pov.getXAxis();
        int xIndex = 0;
        while (xIndex < this.axes.length && this.axes[xIndex] != xAxis) {
            xIndex++;
        }
        int yIndex = 0;
        while (yIndex < this.axes.length && this.axes[yIndex] != yAxis) {
            yIndex++;
        }
        this.povXs.put(new Integer(xIndex), pov);
        this.povYs.put(new Integer(yIndex), pov);
    }

    public final synchronized boolean getNextEvent(Event event) throws IOException {
        return this.event_queue.getNextEvent(event);
    }

    public final synchronized void poll() throws IOException {
        checkClosed();
        while (getNextDeviceEvent(this.joystick_event)) {
            processEvent(this.joystick_event);
        }
    }

    private final boolean getNextDeviceEvent(LinuxJoystickEvent joystick_event) throws IOException {
        return nGetNextEvent(this.fd, joystick_event);
    }

    public final int getNumAxes() {
        return this.axes.length;
    }

    public final int getNumButtons() {
        return this.buttons.length;
    }

    public final byte[] getAxisMap() {
        return this.axisMap;
    }

    public final char[] getButtonMap() {
        return this.buttonMap;
    }

    private final int getNumDeviceButtons() throws IOException {
        return nGetNumButtons(this.fd);
    }

    private final int getNumDeviceAxes() throws IOException {
        return nGetNumAxes(this.fd);
    }

    private final byte[] getDeviceAxisMap() throws IOException {
        return nGetAxisMap(this.fd);
    }

    private final char[] getDeviceButtonMap() throws IOException {
        return nGetButtonMap(this.fd);
    }

    private final int getVersion() throws IOException {
        return nGetVersion(this.fd);
    }

    public final String getName() {
        return this.name;
    }

    private final String getDeviceName() throws IOException {
        return nGetName(this.fd);
    }

    @Override // net.java.games.input.LinuxDevice
    public final synchronized void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            nClose(this.fd);
        }
    }

    private final void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Device is closed");
        }
    }

    protected void finalize() throws IOException {
        close();
    }
}
