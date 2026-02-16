package org.lwjgl.input;

import java.util.ArrayList;
import java.util.Iterator;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import org.lwjgl.LWJGLException;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/input/Controllers.class */
public class Controllers {
    private static int controllerCount;
    private static ControllerEvent event;
    private static boolean created;
    private static ArrayList<JInputController> controllers = new ArrayList<>();
    private static ArrayList<ControllerEvent> events = new ArrayList<>();

    public static void create() throws LWJGLException {
        if (created) {
            return;
        }
        try {
            ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
            net.java.games.input.Controller[] found = env.getControllers();
            ArrayList<net.java.games.input.Controller> lollers = new ArrayList<>();
            for (net.java.games.input.Controller c : found) {
                if (!c.getType().equals(Controller.Type.KEYBOARD) && !c.getType().equals(Controller.Type.MOUSE)) {
                    lollers.add(c);
                }
            }
            Iterator<net.java.games.input.Controller> it = lollers.iterator();
            while (it.hasNext()) {
                createController(it.next());
            }
            created = true;
        } catch (Throwable e) {
            throw new LWJGLException("Failed to initialise controllers", e);
        }
    }

    private static void createController(net.java.games.input.Controller c) {
        net.java.games.input.Controller[] subControllers = c.getControllers();
        if (subControllers.length == 0) {
            JInputController controller = new JInputController(controllerCount, c);
            controllers.add(controller);
            controllerCount++;
        } else {
            for (net.java.games.input.Controller sub : subControllers) {
                createController(sub);
            }
        }
    }

    public static Controller getController(int index) {
        return controllers.get(index);
    }

    public static int getControllerCount() {
        return controllers.size();
    }

    public static void poll() {
        for (int i = 0; i < controllers.size(); i++) {
            getController(i).poll();
        }
    }

    public static void clearEvents() {
        events.clear();
    }

    public static boolean next() {
        if (events.size() == 0) {
            event = null;
            return false;
        }
        event = events.remove(0);
        return event != null;
    }

    public static boolean isCreated() {
        return created;
    }

    public static void destroy() {
    }

    public static Controller getEventSource() {
        return event.getSource();
    }

    public static int getEventControlIndex() {
        return event.getControlIndex();
    }

    public static boolean isEventButton() {
        return event.isButton();
    }

    public static boolean isEventAxis() {
        return event.isAxis();
    }

    public static boolean isEventXAxis() {
        return event.isXAxis();
    }

    public static boolean isEventYAxis() {
        return event.isYAxis();
    }

    public static boolean isEventPovX() {
        return event.isPovX();
    }

    public static boolean isEventPovY() {
        return event.isPovY();
    }

    public static long getEventNanoseconds() {
        return event.getTimeStamp();
    }

    public static boolean getEventButtonState() {
        return event.getButtonState();
    }

    public static float getEventXAxisValue() {
        return event.getXAxisValue();
    }

    public static float getEventYAxisValue() {
        return event.getYAxisValue();
    }

    static void addEvent(ControllerEvent event2) {
        if (event2 != null) {
            events.add(event2);
        }
    }
}
