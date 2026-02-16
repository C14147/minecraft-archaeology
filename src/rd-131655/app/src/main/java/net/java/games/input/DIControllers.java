package net.java.games.input;

import java.io.IOException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DIControllers.class */
final class DIControllers {
    private static final DIDeviceObjectData di_event = new DIDeviceObjectData();

    DIControllers() {
    }

    public static final synchronized boolean getNextDeviceEvent(Event event, IDirectInputDevice device) throws IOException {
        DIDeviceObject object;
        DIComponent component;
        int event_value;
        if (!device.getNextEvent(di_event) || (component = device.mapObject((object = device.mapEvent(di_event)))) == null) {
            return false;
        }
        if (object.isRelative()) {
            event_value = object.getRelativeEventValue(di_event.getData());
        } else {
            event_value = di_event.getData();
        }
        event.set(component, component.getDeviceObject().convertValue(event_value), di_event.getNanos());
        return true;
    }

    public static final float poll(Component component, DIDeviceObject object) throws IOException {
        float result;
        int poll_data = object.getDevice().getPollData(object);
        if (object.isRelative()) {
            result = object.getRelativePollValue(poll_data);
        } else {
            result = poll_data;
        }
        return object.convertValue(result);
    }
}
