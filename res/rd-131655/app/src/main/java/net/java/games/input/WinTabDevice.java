package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabDevice.class */
public class WinTabDevice extends AbstractController {
    private WinTabContext context;
    private List eventList;

    private static final native String nGetName(int i);

    private static final native int[] nGetAxisDetails(int i, int i2);

    private static final native String[] nGetCursorNames(int i);

    private static final native int nGetMaxButtonCount(int i);

    private WinTabDevice(WinTabContext context, int index, String name, Component[] components) {
        super(name, components, new Controller[0], new Rumbler[0]);
        this.eventList = new ArrayList();
        this.context = context;
    }

    @Override // net.java.games.input.AbstractController
    protected boolean getNextDeviceEvent(Event event) throws IOException {
        if (this.eventList.size() > 0) {
            Event ourEvent = (Event) this.eventList.remove(0);
            event.set(ourEvent);
            return true;
        }
        return false;
    }

    @Override // net.java.games.input.AbstractController
    protected void pollDevice() throws IOException {
        this.context.processEvents();
        super.pollDevice();
    }

    @Override // net.java.games.input.AbstractController, net.java.games.input.Controller
    public Controller.Type getType() {
        return Controller.Type.TRACKPAD;
    }

    public void processPacket(WinTabPacket packet) {
        Component[] components = getComponents();
        for (Component component : components) {
            Event event = ((WinTabComponent) component).processPacket(packet);
            if (event != null) {
                this.eventList.add(event);
            }
        }
    }

    public static WinTabDevice createDevice(WinTabContext context, int deviceIndex) {
        String name = nGetName(deviceIndex);
        WinTabEnvironmentPlugin.logln(new StringBuffer().append("Device ").append(deviceIndex).append(", name: ").append(name).toString());
        List componentsList = new ArrayList();
        int[] axisDetails = nGetAxisDetails(deviceIndex, 1);
        if (axisDetails.length == 0) {
            WinTabEnvironmentPlugin.logln("ZAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("Xmin: ").append(axisDetails[0]).append(", Xmax: ").append(axisDetails[1]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 1, axisDetails));
        }
        int[] axisDetails2 = nGetAxisDetails(deviceIndex, 2);
        if (axisDetails2.length == 0) {
            WinTabEnvironmentPlugin.logln("YAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("Ymin: ").append(axisDetails2[0]).append(", Ymax: ").append(axisDetails2[1]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 2, axisDetails2));
        }
        int[] axisDetails3 = nGetAxisDetails(deviceIndex, 3);
        if (axisDetails3.length == 0) {
            WinTabEnvironmentPlugin.logln("ZAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("Zmin: ").append(axisDetails3[0]).append(", Zmax: ").append(axisDetails3[1]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 3, axisDetails3));
        }
        int[] axisDetails4 = nGetAxisDetails(deviceIndex, 4);
        if (axisDetails4.length == 0) {
            WinTabEnvironmentPlugin.logln("NPressureAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("NPressMin: ").append(axisDetails4[0]).append(", NPressMax: ").append(axisDetails4[1]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 4, axisDetails4));
        }
        int[] axisDetails5 = nGetAxisDetails(deviceIndex, 5);
        if (axisDetails5.length == 0) {
            WinTabEnvironmentPlugin.logln("TPressureAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("TPressureAxismin: ").append(axisDetails5[0]).append(", TPressureAxismax: ").append(axisDetails5[1]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 5, axisDetails5));
        }
        int[] axisDetails6 = nGetAxisDetails(deviceIndex, 6);
        if (axisDetails6.length == 0) {
            WinTabEnvironmentPlugin.logln("OrientationAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("OrientationAxis mins/maxs: ").append(axisDetails6[0]).append(",").append(axisDetails6[1]).append(", ").append(axisDetails6[2]).append(",").append(axisDetails6[3]).append(", ").append(axisDetails6[4]).append(",").append(axisDetails6[5]).toString());
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 6, axisDetails6));
        }
        int[] axisDetails7 = nGetAxisDetails(deviceIndex, 7);
        if (axisDetails7.length == 0) {
            WinTabEnvironmentPlugin.logln("RotationAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln("RotationAxis is supported (by the device, not by this plugin)");
            componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 7, axisDetails7));
        }
        String[] cursorNames = nGetCursorNames(deviceIndex);
        componentsList.addAll(WinTabComponent.createCursors(context, deviceIndex, cursorNames));
        for (int i = 0; i < cursorNames.length; i++) {
            WinTabEnvironmentPlugin.logln(new StringBuffer().append("Cursor ").append(i).append("'s name: ").append(cursorNames[i]).toString());
        }
        int numberOfButtons = nGetMaxButtonCount(deviceIndex);
        WinTabEnvironmentPlugin.logln(new StringBuffer().append("Device has ").append(numberOfButtons).append(" buttons").toString());
        componentsList.addAll(WinTabComponent.createButtons(context, deviceIndex, numberOfButtons));
        Component[] components = (Component[]) componentsList.toArray(new Component[0]);
        return new WinTabDevice(context, deviceIndex, name, components);
    }
}
