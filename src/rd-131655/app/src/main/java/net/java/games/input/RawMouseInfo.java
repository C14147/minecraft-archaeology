package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;
import net.java.games.input.RawMouse;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawMouseInfo.class */
class RawMouseInfo extends RawDeviceInfo {
    private final RawDevice device;
    private final int id;
    private final int num_buttons;
    private final int sample_rate;

    public RawMouseInfo(RawDevice device, int id, int num_buttons, int sample_rate) {
        this.device = device;
        this.id = id;
        this.num_buttons = num_buttons;
        this.sample_rate = sample_rate;
    }

    @Override // net.java.games.input.RawDeviceInfo
    public final int getUsage() {
        return 2;
    }

    @Override // net.java.games.input.RawDeviceInfo
    public final int getUsagePage() {
        return 1;
    }

    @Override // net.java.games.input.RawDeviceInfo
    public final long getHandle() {
        return this.device.getHandle();
    }

    @Override // net.java.games.input.RawDeviceInfo
    public final Controller createControllerFromDevice(RawDevice device, SetupAPIDevice setupapi_device) throws IOException {
        if (this.num_buttons == 0) {
            return null;
        }
        Component[] components = new Component[3 + this.num_buttons];
        int index = 0 + 1;
        components[0] = new RawMouse.Axis(device, Component.Identifier.Axis.X);
        int index2 = index + 1;
        components[index] = new RawMouse.Axis(device, Component.Identifier.Axis.Y);
        int index3 = index2 + 1;
        components[index2] = new RawMouse.Axis(device, Component.Identifier.Axis.Z);
        for (int i = 0; i < this.num_buttons; i++) {
            Component.Identifier.Button id = DIIdentifierMap.mapMouseButtonIdentifier(DIIdentifierMap.getButtonIdentifier(i));
            int i2 = index3;
            index3++;
            components[i2] = new RawMouse.Button(device, id, i);
        }
        Controller mouse = new RawMouse(setupapi_device.getName(), device, components, new Controller[0], new Rumbler[0]);
        return mouse;
    }
}
