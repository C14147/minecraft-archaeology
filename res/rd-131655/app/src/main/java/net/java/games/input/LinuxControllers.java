package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxControllers.class */
final class LinuxControllers {
    private static final LinuxEvent linux_event = new LinuxEvent();
    private static final LinuxAbsInfo abs_info = new LinuxAbsInfo();

    LinuxControllers() {
    }

    public static final synchronized boolean getNextDeviceEvent(Event event, LinuxEventDevice device) throws IOException {
        while (device.getNextEvent(linux_event)) {
            LinuxAxisDescriptor descriptor = linux_event.getDescriptor();
            LinuxComponent component = device.mapDescriptor(descriptor);
            if (component != null) {
                float value = component.convertValue(linux_event.getValue(), descriptor);
                event.set(component, value, linux_event.getNanos());
                return true;
            }
        }
        return false;
    }

    public static final synchronized float poll(LinuxEventComponent event_component) throws IOException {
        int native_type = event_component.getDescriptor().getType();
        switch (native_type) {
            case 1:
                int native_code = event_component.getDescriptor().getCode();
                float state = event_component.getDevice().isKeySet(native_code) ? 1.0f : 0.0f;
                return state;
            case 3:
                event_component.getAbsInfo(abs_info);
                return abs_info.getValue();
            default:
                throw new RuntimeException(new StringBuffer().append("Unkown native_type: ").append(native_type).toString());
        }
    }
}
