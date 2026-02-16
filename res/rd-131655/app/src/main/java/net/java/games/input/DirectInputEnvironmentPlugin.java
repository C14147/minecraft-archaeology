package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DirectInputEnvironmentPlugin.class */
public final class DirectInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;
    private final List active_devices = new ArrayList();
    private final DummyWindow window;

    static {
        supported = false;
        String osName = getPrivilegedProperty("os.name", "").trim();
        if (osName.startsWith("Windows")) {
            supported = true;
            if ("x86".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary("jinput-dx8");
            } else {
                loadLibrary("jinput-dx8_64");
            }
        }
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.DirectInputEnvironmentPlugin.1
            private final String val$lib_name;

            {
                this.val$lib_name = lib_name;
            }

            @Override // java.security.PrivilegedAction
            public final Object run() {
                try {
                    String lib_path = System.getProperty("net.java.games.input.librarypath");
                    if (lib_path != null) {
                        System.load(new StringBuffer().append(lib_path).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                    } else {
                        System.loadLibrary(this.val$lib_name);
                    }
                    return null;
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                    boolean unused = DirectInputEnvironmentPlugin.supported = false;
                    return null;
                }
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.DirectInputEnvironmentPlugin.2
            private final String val$property;

            {
                this.val$property = property;
            }

            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(this.val$property);
            }
        });
    }

    static String getPrivilegedProperty(String property, String default_value) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.DirectInputEnvironmentPlugin.3
            private final String val$property;
            private final String val$default_value;

            {
                this.val$property = property;
                this.val$default_value = default_value;
            }

            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(this.val$property, this.val$default_value);
            }
        });
    }

    public DirectInputEnvironmentPlugin() {
        DummyWindow window = null;
        Controller[] controllers = new Controller[0];
        if (isSupported()) {
            try {
                window = new DummyWindow();
                try {
                    controllers = enumControllers(window);
                } catch (IOException e) {
                    window.destroy();
                    throw e;
                }
            } catch (IOException e2) {
                logln(new StringBuffer().append("Failed to enumerate devices: ").append(e2.getMessage()).toString());
            }
            this.window = window;
            this.controllers = controllers;
            AccessController.doPrivileged(new PrivilegedAction(this) { // from class: net.java.games.input.DirectInputEnvironmentPlugin.4
                private final DirectInputEnvironmentPlugin this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.security.PrivilegedAction
                public final Object run() {
                    Runtime.getRuntime().addShutdownHook(new ShutdownHook(this.this$0, null));
                    return null;
                }
            });
            return;
        }
        this.window = null;
        this.controllers = controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public final Controller[] getControllers() {
        return this.controllers;
    }

    private final Component[] createComponents(IDirectInputDevice device, boolean map_mouse_buttons) {
        List device_objects = device.getObjects();
        List controller_components = new ArrayList();
        for (int i = 0; i < device_objects.size(); i++) {
            DIDeviceObject device_object = (DIDeviceObject) device_objects.get(i);
            Component.Identifier identifier = device_object.getIdentifier();
            if (identifier != null) {
                if (map_mouse_buttons && (identifier instanceof Component.Identifier.Button)) {
                    identifier = DIIdentifierMap.mapMouseButtonIdentifier((Component.Identifier.Button) identifier);
                }
                DIComponent component = new DIComponent(identifier, device_object);
                controller_components.add(component);
                device.registerComponent(device_object, component);
            }
        }
        Component[] components = new Component[controller_components.size()];
        controller_components.toArray(components);
        return components;
    }

    private final Mouse createMouseFromDevice(IDirectInputDevice device) {
        Component[] components = createComponents(device, true);
        Mouse mouse = new DIMouse(device, components, new Controller[0], device.getRumblers());
        if (mouse.getX() != null && mouse.getY() != null && mouse.getPrimaryButton() != null) {
            return mouse;
        }
        return null;
    }

    private final AbstractController createControllerFromDevice(IDirectInputDevice device, Controller.Type type) {
        Component[] components = createComponents(device, false);
        AbstractController controller = new DIAbstractController(device, components, new Controller[0], device.getRumblers(), type);
        return controller;
    }

    private final Keyboard createKeyboardFromDevice(IDirectInputDevice device) {
        Component[] components = createComponents(device, false);
        return new DIKeyboard(device, components, new Controller[0], device.getRumblers());
    }

    private final Controller createControllerFromDevice(IDirectInputDevice device) {
        switch (device.getType()) {
            case 18:
                return createMouseFromDevice(device);
            case 19:
                return createKeyboardFromDevice(device);
            case 20:
            case 23:
            case 24:
                return createControllerFromDevice(device, Controller.Type.STICK);
            case 21:
                return createControllerFromDevice(device, Controller.Type.GAMEPAD);
            case 22:
                return createControllerFromDevice(device, Controller.Type.WHEEL);
            default:
                return createControllerFromDevice(device, Controller.Type.UNKNOWN);
        }
    }

    private final Controller[] enumControllers(DummyWindow window) throws IOException {
        List controllers = new ArrayList();
        IDirectInput dinput = new IDirectInput(window);
        try {
            List devices = dinput.getDevices();
            for (int i = 0; i < devices.size(); i++) {
                IDirectInputDevice device = (IDirectInputDevice) devices.get(i);
                Controller controller = createControllerFromDevice(device);
                if (controller != null) {
                    controllers.add(controller);
                    this.active_devices.add(device);
                } else {
                    device.release();
                }
            }
            Controller[] controllers_array = new Controller[controllers.size()];
            controllers.toArray(controllers_array);
            return controllers_array;
        } finally {
            dinput.release();
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DirectInputEnvironmentPlugin$ShutdownHook.class */
    private final class ShutdownHook extends Thread {
        private final DirectInputEnvironmentPlugin this$0;

        private ShutdownHook(DirectInputEnvironmentPlugin directInputEnvironmentPlugin) {
            this.this$0 = directInputEnvironmentPlugin;
        }

        ShutdownHook(DirectInputEnvironmentPlugin x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            for (int i = 0; i < this.this$0.active_devices.size(); i++) {
                IDirectInputDevice device = (IDirectInputDevice) this.this$0.active_devices.get(i);
                device.release();
            }
        }
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return supported;
    }
}
