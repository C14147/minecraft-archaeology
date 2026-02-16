package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.java.games.input.Component;
import net.java.games.input.Controller;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/AbstractController.class */
public abstract class AbstractController implements Controller {
    static final int EVENT_QUEUE_DEPTH = 32;
    private static final Event event = new Event();
    private final String name;
    private final Component[] components;
    private final Controller[] children;
    private final Rumbler[] rumblers;
    private final Map id_to_components = new HashMap();
    private EventQueue event_queue = new EventQueue(32);

    protected abstract boolean getNextDeviceEvent(Event event2) throws IOException;

    protected AbstractController(String name, Component[] components, Controller[] children, Rumbler[] rumblers) {
        this.name = name;
        this.components = components;
        this.children = children;
        this.rumblers = rumblers;
        for (int i = components.length - 1; i >= 0; i--) {
            this.id_to_components.put(components[i].getIdentifier(), components[i]);
        }
    }

    @Override // net.java.games.input.Controller
    public final Controller[] getControllers() {
        return this.children;
    }

    @Override // net.java.games.input.Controller
    public final Component[] getComponents() {
        return this.components;
    }

    @Override // net.java.games.input.Controller
    public final Component getComponent(Component.Identifier id) {
        return (Component) this.id_to_components.get(id);
    }

    @Override // net.java.games.input.Controller
    public final Rumbler[] getRumblers() {
        return this.rumblers;
    }

    @Override // net.java.games.input.Controller
    public Controller.PortType getPortType() {
        return Controller.PortType.UNKNOWN;
    }

    @Override // net.java.games.input.Controller
    public int getPortNumber() {
        return 0;
    }

    @Override // net.java.games.input.Controller
    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    @Override // net.java.games.input.Controller
    public Controller.Type getType() {
        return Controller.Type.UNKNOWN;
    }

    @Override // net.java.games.input.Controller
    public final void setEventQueueSize(int size) throws Throwable {
        try {
            setDeviceEventQueueSize(size);
            this.event_queue = new EventQueue(size);
        } catch (IOException e) {
            ControllerEnvironment.logln(new StringBuffer().append("Failed to create new event queue of size ").append(size).append(": ").append(e).toString());
        }
    }

    protected void setDeviceEventQueueSize(int size) throws IOException {
    }

    @Override // net.java.games.input.Controller
    public final EventQueue getEventQueue() {
        return this.event_queue;
    }

    protected void pollDevice() throws IOException {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0084 A[Catch: IOException -> 0x0093, TryCatch #0 {IOException -> 0x0093, blocks: (B:3:0x0005, B:4:0x000b, B:6:0x0011, B:8:0x001f, B:10:0x002b, B:9:0x0027, B:11:0x0031, B:13:0x003b, B:18:0x005c, B:23:0x007a, B:25:0x0084, B:19:0x0069, B:22:0x0075), top: B:32:0x0005 }] */
    @Override // net.java.games.input.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean poll() throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = r4
            net.java.games.input.Component[] r0 = r0.getComponents()
            r5 = r0
            r0 = r4
            r0.pollDevice()     // Catch: java.io.IOException -> L93
            r0 = 0
            r6 = r0
        Lb:
            r0 = r6
            r1 = r5
            int r1 = r1.length     // Catch: java.io.IOException -> L93
            if (r0 >= r1) goto L31
            r0 = r5
            r1 = r6
            r0 = r0[r1]     // Catch: java.io.IOException -> L93
            net.java.games.input.AbstractComponent r0 = (net.java.games.input.AbstractComponent) r0     // Catch: java.io.IOException -> L93
            r7 = r0
            r0 = r7
            boolean r0 = r0.isRelative()     // Catch: java.io.IOException -> L93
            if (r0 == 0) goto L27
            r0 = r7
            r1 = 0
            r0.setPollData(r1)     // Catch: java.io.IOException -> L93
            goto L2b
        L27:
            r0 = r7
            r0.resetHasPolled()     // Catch: java.io.IOException -> L93
        L2b:
            int r6 = r6 + 1
            goto Lb
        L31:
            r0 = r4
            net.java.games.input.Event r1 = net.java.games.input.AbstractController.event     // Catch: java.io.IOException -> L93
            boolean r0 = r0.getNextDeviceEvent(r1)     // Catch: java.io.IOException -> L93
            if (r0 == 0) goto L91
            net.java.games.input.Event r0 = net.java.games.input.AbstractController.event     // Catch: java.io.IOException -> L93
            net.java.games.input.Component r0 = r0.getComponent()     // Catch: java.io.IOException -> L93
            net.java.games.input.AbstractComponent r0 = (net.java.games.input.AbstractComponent) r0     // Catch: java.io.IOException -> L93
            r6 = r0
            net.java.games.input.Event r0 = net.java.games.input.AbstractController.event     // Catch: java.io.IOException -> L93
            float r0 = r0.getValue()     // Catch: java.io.IOException -> L93
            r7 = r0
            r0 = r6
            boolean r0 = r0.isRelative()     // Catch: java.io.IOException -> L93
            if (r0 == 0) goto L69
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5c
            goto L31
        L5c:
            r0 = r6
            r1 = r6
            float r1 = r1.getPollData()     // Catch: java.io.IOException -> L93
            r2 = r7
            float r1 = r1 + r2
            r0.setPollData(r1)     // Catch: java.io.IOException -> L93
            goto L7a
        L69:
            r0 = r7
            r1 = r6
            float r1 = r1.getEventValue()     // Catch: java.io.IOException -> L93
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L75
            goto L31
        L75:
            r0 = r6
            r1 = r7
            r0.setEventValue(r1)     // Catch: java.io.IOException -> L93
        L7a:
            r0 = r4
            net.java.games.input.EventQueue r0 = r0.event_queue     // Catch: java.io.IOException -> L93
            boolean r0 = r0.isFull()     // Catch: java.io.IOException -> L93
            if (r0 != 0) goto L8e
            r0 = r4
            net.java.games.input.EventQueue r0 = r0.event_queue     // Catch: java.io.IOException -> L93
            net.java.games.input.Event r1 = net.java.games.input.AbstractController.event     // Catch: java.io.IOException -> L93
            r0.add(r1)     // Catch: java.io.IOException -> L93
        L8e:
            goto L31
        L91:
            r0 = 1
            return r0
        L93:
            r6 = move-exception
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "Failed to poll device: "
            java.lang.StringBuffer r0 = r0.append(r1)
            r1 = r6
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            net.java.games.input.ControllerEnvironment.logln(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.java.games.input.AbstractController.poll():boolean");
    }
}
