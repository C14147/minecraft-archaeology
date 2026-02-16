package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/RawInputEnvironmentPlugin.class */
public final class RawInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;

    private static final native void enumerateDevices(RawInputEventQueue rawInputEventQueue, List list) throws IOException;

    private static final native void nEnumSetupAPIDevices(byte[] bArr, List list) throws IOException;

    private static final native byte[] getKeyboardClassGUID();

    private static final native byte[] getMouseClassGUID();

    static {
        supported = false;
        String osName = getPrivilegedProperty("os.name", "").trim();
        if (osName.startsWith("Windows")) {
            supported = true;
            if ("x86".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary("jinput-raw");
            } else {
                loadLibrary("jinput-raw_64");
            }
        }
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.RawInputEnvironmentPlugin.1
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
                    boolean unused = RawInputEnvironmentPlugin.supported = false;
                    return null;
                }
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.RawInputEnvironmentPlugin.2
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
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.RawInputEnvironmentPlugin.3
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

    public RawInputEnvironmentPlugin() {
        Controller[] controllers = new Controller[0];
        if (isSupported()) {
            try {
                RawInputEventQueue queue = new RawInputEventQueue();
                controllers = enumControllers(queue);
            } catch (IOException e) {
                logln(new StringBuffer().append("Failed to enumerate devices: ").append(e.getMessage()).toString());
            }
        }
        this.controllers = controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public final Controller[] getControllers() {
        return this.controllers;
    }

    private static final SetupAPIDevice lookupSetupAPIDevice(String device_name, List setupapi_devices) {
        String device_name2 = device_name.replaceAll("#", "\\\\").toUpperCase();
        for (int i = 0; i < setupapi_devices.size(); i++) {
            SetupAPIDevice device = (SetupAPIDevice) setupapi_devices.get(i);
            if (device_name2.indexOf(device.getInstanceId().toUpperCase()) != -1) {
                return device;
            }
        }
        return null;
    }

    private static final void createControllersFromDevices(RawInputEventQueue queue, List controllers, List devices, List setupapi_devices) throws IOException {
        List active_devices = new ArrayList();
        for (int i = 0; i < devices.size(); i++) {
            RawDevice device = (RawDevice) devices.get(i);
            SetupAPIDevice setupapi_device = lookupSetupAPIDevice(device.getName(), setupapi_devices);
            if (setupapi_device != null) {
                RawDeviceInfo info = device.getInfo();
                Controller controller = info.createControllerFromDevice(device, setupapi_device);
                if (controller != null) {
                    controllers.add(controller);
                    active_devices.add(device);
                }
            }
        }
        queue.start(active_devices);
    }

    private final Controller[] enumControllers(RawInputEventQueue queue) throws IOException {
        List controllers = new ArrayList();
        List devices = new ArrayList();
        enumerateDevices(queue, devices);
        List setupapi_devices = enumSetupAPIDevices();
        createControllersFromDevices(queue, controllers, devices, setupapi_devices);
        Controller[] controllers_array = new Controller[controllers.size()];
        controllers.toArray(controllers_array);
        return controllers_array;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return supported;
    }

    private static final List enumSetupAPIDevices() throws IOException {
        List devices = new ArrayList();
        nEnumSetupAPIDevices(getKeyboardClassGUID(), devices);
        nEnumSetupAPIDevices(getMouseClassGUID(), devices);
        return devices;
    }
}
