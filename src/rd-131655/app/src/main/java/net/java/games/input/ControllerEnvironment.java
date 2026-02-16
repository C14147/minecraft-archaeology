package net.java.games.input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/ControllerEnvironment.class */
public abstract class ControllerEnvironment {
    private static ControllerEnvironment defaultEnvironment;
    protected final ArrayList controllerListeners = new ArrayList();
    static Class class$net$java$games$input$ControllerEnvironment;
    static final boolean $assertionsDisabled;

    public abstract Controller[] getControllers();

    public abstract boolean isSupported();

    static {
        Class clsClass$;
        if (class$net$java$games$input$ControllerEnvironment == null) {
            clsClass$ = class$("net.java.games.input.ControllerEnvironment");
            class$net$java$games$input$ControllerEnvironment = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$ControllerEnvironment;
        }
        $assertionsDisabled = !clsClass$.desiredAssertionStatus();
        defaultEnvironment = new DefaultControllerEnvironment();
    }

    static void logln(String msg) throws Throwable {
        log(new StringBuffer().append(msg).append("\n").toString());
    }

    static void log(String msg) throws Throwable {
        Class clsClass$;
        if (class$net$java$games$input$ControllerEnvironment == null) {
            clsClass$ = class$("net.java.games.input.ControllerEnvironment");
            class$net$java$games$input$ControllerEnvironment = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$ControllerEnvironment;
        }
        Logger.getLogger(clsClass$.getName()).info(msg);
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    protected ControllerEnvironment() {
    }

    public void addControllerListener(ControllerListener l) {
        if (!$assertionsDisabled && l == null) {
            throw new AssertionError();
        }
        this.controllerListeners.add(l);
    }

    public void removeControllerListener(ControllerListener l) {
        if (!$assertionsDisabled && l == null) {
            throw new AssertionError();
        }
        this.controllerListeners.remove(l);
    }

    protected void fireControllerAdded(Controller c) {
        ControllerEvent ev = new ControllerEvent(c);
        Iterator it = this.controllerListeners.iterator();
        while (it.hasNext()) {
            ((ControllerListener) it.next()).controllerAdded(ev);
        }
    }

    protected void fireControllerRemoved(Controller c) {
        ControllerEvent ev = new ControllerEvent(c);
        Iterator it = this.controllerListeners.iterator();
        while (it.hasNext()) {
            ((ControllerListener) it.next()).controllerRemoved(ev);
        }
    }

    public static ControllerEnvironment getDefaultEnvironment() {
        return defaultEnvironment;
    }
}
