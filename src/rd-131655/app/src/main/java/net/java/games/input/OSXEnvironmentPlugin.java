package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/OSXEnvironmentPlugin.class */
public final class OSXEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;

    static {
        supported = false;
        String osName = getPrivilegedProperty("os.name", "").trim();
        if (osName.equals("Mac OS X")) {
            supported = true;
            loadLibrary("jinput-osx");
        }
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.OSXEnvironmentPlugin.1
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
                    boolean unused = OSXEnvironmentPlugin.supported = false;
                    return null;
                }
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.OSXEnvironmentPlugin.2
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
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.OSXEnvironmentPlugin.3
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

    private static final boolean isMacOSXEqualsOrBetterThan(int major_required, int minor_required) {
        String os_version = System.getProperty("os.version");
        StringTokenizer version_tokenizer = new StringTokenizer(os_version, ".");
        try {
            String major_str = version_tokenizer.nextToken();
            String minor_str = version_tokenizer.nextToken();
            int major = Integer.parseInt(major_str);
            int minor = Integer.parseInt(minor_str);
            return major > major_required || (major == major_required && minor >= minor_required);
        } catch (Exception e) {
            logln(new StringBuffer().append("Exception occurred while trying to determine OS version: ").append(e).toString());
            return false;
        }
    }

    public OSXEnvironmentPlugin() {
        if (isSupported()) {
            this.controllers = enumerateControllers();
        } else {
            this.controllers = new Controller[0];
        }
    }

    @Override // net.java.games.input.ControllerEnvironment
    public final Controller[] getControllers() {
        return this.controllers;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return supported;
    }

    private static final void addElements(OSXHIDQueue queue, List elements, List components, boolean map_mouse_buttons) throws IOException {
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            OSXHIDElement element = (OSXHIDElement) it.next();
            Component.Identifier id = element.getIdentifier();
            if (id != null) {
                if (map_mouse_buttons) {
                    if (id == Component.Identifier.Button._0) {
                        id = Component.Identifier.Button.LEFT;
                    } else if (id == Component.Identifier.Button._1) {
                        id = Component.Identifier.Button.RIGHT;
                    } else if (id == Component.Identifier.Button._2) {
                        id = Component.Identifier.Button.MIDDLE;
                    }
                }
                OSXComponent component = new OSXComponent(id, element);
                components.add(component);
                queue.addElement(element, component);
            }
        }
    }

    private static final Keyboard createKeyboardFromDevice(OSXHIDDevice device, List elements) throws IOException {
        List components = new ArrayList();
        OSXHIDQueue queue = device.createQueue(32);
        try {
            addElements(queue, elements, components, false);
            Component[] components_array = new Component[components.size()];
            components.toArray(components_array);
            Keyboard keyboard = new OSXKeyboard(device, queue, components_array, new Controller[0], new Rumbler[0]);
            return keyboard;
        } catch (IOException e) {
            queue.release();
            throw e;
        }
    }

    private static final Mouse createMouseFromDevice(OSXHIDDevice device, List elements) throws IOException {
        List components = new ArrayList();
        OSXHIDQueue queue = device.createQueue(32);
        try {
            addElements(queue, elements, components, true);
            Component[] components_array = new Component[components.size()];
            components.toArray(components_array);
            Mouse mouse = new OSXMouse(device, queue, components_array, new Controller[0], new Rumbler[0]);
            if (mouse.getPrimaryButton() != null && mouse.getX() != null && mouse.getY() != null) {
                return mouse;
            }
            queue.release();
            return null;
        } catch (IOException e) {
            queue.release();
            throw e;
        }
    }

    private static final AbstractController createControllerFromDevice(OSXHIDDevice device, List elements, Controller.Type type) throws IOException {
        List components = new ArrayList();
        OSXHIDQueue queue = device.createQueue(32);
        try {
            addElements(queue, elements, components, false);
            Component[] components_array = new Component[components.size()];
            components.toArray(components_array);
            AbstractController controller = new OSXAbstractController(device, queue, components_array, new Controller[0], new Rumbler[0], type);
            return controller;
        } catch (IOException e) {
            queue.release();
            throw e;
        }
    }

    private static final void createControllersFromDevice(OSXHIDDevice device, List controllers) throws IOException {
        AbstractController abstractControllerCreateControllerFromDevice;
        UsagePair usage_pair = device.getUsagePair();
        if (usage_pair == null) {
            return;
        }
        List elements = device.getElements();
        if (usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP && (usage_pair.getUsage() == GenericDesktopUsage.MOUSE || usage_pair.getUsage() == GenericDesktopUsage.POINTER)) {
            Mouse mouseCreateMouseFromDevice = createMouseFromDevice(device, elements);
            if (mouseCreateMouseFromDevice != null) {
                controllers.add(mouseCreateMouseFromDevice);
                return;
            }
            return;
        }
        if (usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP && (usage_pair.getUsage() == GenericDesktopUsage.KEYBOARD || usage_pair.getUsage() == GenericDesktopUsage.KEYPAD)) {
            Keyboard keyboardCreateKeyboardFromDevice = createKeyboardFromDevice(device, elements);
            if (keyboardCreateKeyboardFromDevice != null) {
                controllers.add(keyboardCreateKeyboardFromDevice);
                return;
            }
            return;
        }
        if (usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP && usage_pair.getUsage() == GenericDesktopUsage.JOYSTICK) {
            AbstractController abstractControllerCreateControllerFromDevice2 = createControllerFromDevice(device, elements, Controller.Type.STICK);
            if (abstractControllerCreateControllerFromDevice2 != null) {
                controllers.add(abstractControllerCreateControllerFromDevice2);
                return;
            }
            return;
        }
        if (usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP && usage_pair.getUsage() == GenericDesktopUsage.MULTI_AXIS_CONTROLLER) {
            AbstractController abstractControllerCreateControllerFromDevice3 = createControllerFromDevice(device, elements, Controller.Type.STICK);
            if (abstractControllerCreateControllerFromDevice3 != null) {
                controllers.add(abstractControllerCreateControllerFromDevice3);
                return;
            }
            return;
        }
        if (usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP && usage_pair.getUsage() == GenericDesktopUsage.GAME_PAD && (abstractControllerCreateControllerFromDevice = createControllerFromDevice(device, elements, Controller.Type.GAMEPAD)) != null) {
            controllers.add(abstractControllerCreateControllerFromDevice);
        }
    }

    /* JADX WARN: Finally extract failed */
    private static final Controller[] enumerateControllers() {
        OSXHIDDevice device;
        List controllers = new ArrayList();
        try {
            OSXHIDDeviceIterator it = new OSXHIDDeviceIterator();
            while (true) {
                try {
                    try {
                        device = it.next();
                    } catch (Throwable th) {
                        it.close();
                        throw th;
                    }
                } catch (IOException e) {
                    logln(new StringBuffer().append("Failed to enumerate device: ").append(e.getMessage()).toString());
                }
                if (device != null) {
                    boolean device_used = false;
                    try {
                        int old_size = controllers.size();
                        createControllersFromDevice(device, controllers);
                        device_used = old_size != controllers.size();
                    } catch (IOException e2) {
                        logln(new StringBuffer().append("Failed to create controllers from device: ").append(device.getProductName()).toString());
                    }
                    if (!device_used) {
                        device.release();
                    }
                } else {
                    it.close();
                    Controller[] controllers_array = new Controller[controllers.size()];
                    controllers.toArray(controllers_array);
                    return controllers_array;
                }
            }
        } catch (IOException e3) {
            log(new StringBuffer().append("Failed to enumerate devices: ").append(e3.getMessage()).toString());
            return new Controller[0];
        }
    }
}
