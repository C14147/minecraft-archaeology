package net.java.games.input;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxEnvironmentPlugin.class */
public final class LinuxEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static final String LIBNAME = "jinput-linux";
    private static final String POSTFIX64BIT = "64";
    private static boolean supported;
    private final Controller[] controllers;
    private final List devices = new ArrayList();
    private static final LinuxDeviceThread device_thread = new LinuxDeviceThread();

    static {
        supported = false;
        String osName = getPrivilegedProperty("os.name", "").trim();
        if (osName.equals("Linux")) {
            supported = true;
            if ("i386".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary(LIBNAME);
            } else {
                loadLibrary("jinput-linux64");
            }
        }
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.LinuxEnvironmentPlugin.1
            private final String val$lib_name;

            {
                this.val$lib_name = lib_name;
            }

            @Override // java.security.PrivilegedAction
            public final Object run() throws Throwable {
                String lib_path = System.getProperty("net.java.games.input.librarypath");
                try {
                    if (lib_path != null) {
                        System.load(new StringBuffer().append(lib_path).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                    } else {
                        System.loadLibrary(this.val$lib_name);
                    }
                    return null;
                } catch (UnsatisfiedLinkError e) {
                    ControllerEnvironment.logln(new StringBuffer().append("Failed to load library: ").append(e.getMessage()).toString());
                    e.printStackTrace();
                    boolean unused = LinuxEnvironmentPlugin.supported = false;
                    return null;
                }
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.LinuxEnvironmentPlugin.2
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
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.LinuxEnvironmentPlugin.3
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

    public static final Object execute(LinuxDeviceTask task) throws IOException {
        return device_thread.execute(task);
    }

    public LinuxEnvironmentPlugin() {
        if (isSupported()) {
            this.controllers = enumerateControllers();
            logln(new StringBuffer().append("Linux plugin claims to have found ").append(this.controllers.length).append(" controllers").toString());
            AccessController.doPrivileged(new PrivilegedAction(this) { // from class: net.java.games.input.LinuxEnvironmentPlugin.4
                private final LinuxEnvironmentPlugin this$0;

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
        this.controllers = new Controller[0];
    }

    @Override // net.java.games.input.ControllerEnvironment
    public final Controller[] getControllers() {
        return this.controllers;
    }

    private static final Component[] createComponents(List event_components, LinuxEventDevice device) {
        LinuxEventComponent[][] povs = new LinuxEventComponent[4][2];
        List components = new ArrayList();
        for (int i = 0; i < event_components.size(); i++) {
            LinuxEventComponent event_component = (LinuxEventComponent) event_components.get(i);
            Component.Identifier identifier = event_component.getIdentifier();
            if (identifier == Component.Identifier.Axis.POV) {
                int native_code = event_component.getDescriptor().getCode();
                switch (native_code) {
                    case 16:
                        povs[0][0] = event_component;
                        break;
                    case 17:
                        povs[0][1] = event_component;
                        break;
                    case 18:
                        povs[1][0] = event_component;
                        break;
                    case 19:
                        povs[1][1] = event_component;
                        break;
                    case 20:
                        povs[2][0] = event_component;
                        break;
                    case 21:
                        povs[2][1] = event_component;
                        break;
                    case 22:
                        povs[3][0] = event_component;
                        break;
                    case 23:
                        povs[3][1] = event_component;
                        break;
                    default:
                        logln(new StringBuffer().append("Unknown POV instance: ").append(native_code).toString());
                        break;
                }
            } else if (identifier != null) {
                LinuxComponent component = new LinuxComponent(event_component);
                components.add(component);
                device.registerComponent(event_component.getDescriptor(), component);
            }
        }
        for (int i2 = 0; i2 < povs.length; i2++) {
            LinuxEventComponent x = povs[i2][0];
            LinuxEventComponent y = povs[i2][1];
            if (x != null && y != null) {
                LinuxPOV linuxPOV = new LinuxPOV(x, y);
                components.add(linuxPOV);
                device.registerComponent(x.getDescriptor(), linuxPOV);
                device.registerComponent(y.getDescriptor(), linuxPOV);
            }
        }
        Component[] components_array = new Component[components.size()];
        components.toArray(components_array);
        return components_array;
    }

    private static final Mouse createMouseFromDevice(LinuxEventDevice device, Component[] components) throws IOException {
        Mouse mouse = new LinuxMouse(device, components, new Controller[0], device.getRumblers());
        if (mouse.getX() != null && mouse.getY() != null && mouse.getPrimaryButton() != null) {
            return mouse;
        }
        return null;
    }

    private static final Keyboard createKeyboardFromDevice(LinuxEventDevice device, Component[] components) throws IOException {
        Keyboard keyboard = new LinuxKeyboard(device, components, new Controller[0], device.getRumblers());
        return keyboard;
    }

    private static final Controller createJoystickFromDevice(LinuxEventDevice device, Component[] components, Controller.Type type) throws IOException {
        Controller joystick = new LinuxAbstractController(device, components, new Controller[0], device.getRumblers(), type);
        return joystick;
    }

    private static final Controller createControllerFromDevice(LinuxEventDevice device) throws IOException {
        List event_components = device.getComponents();
        Component[] components = createComponents(event_components, device);
        Controller.Type type = device.getType();
        if (type == Controller.Type.MOUSE) {
            return createMouseFromDevice(device, components);
        }
        if (type == Controller.Type.KEYBOARD) {
            return createKeyboardFromDevice(device, components);
        }
        if (type == Controller.Type.STICK || type == Controller.Type.GAMEPAD) {
            return createJoystickFromDevice(device, components, type);
        }
        return null;
    }

    private final Controller[] enumerateControllers() {
        List controllers = new ArrayList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        enumerateEventControllers(arrayList);
        enumerateJoystickControllers(arrayList2);
        int i = 0;
        while (i < arrayList.size()) {
            int j = 0;
            while (true) {
                if (j < arrayList2.size()) {
                    Controller evController = (Controller) arrayList.get(i);
                    Controller jsController = (Controller) arrayList2.get(j);
                    if (evController.getName().equals(jsController.getName())) {
                        Component[] evComponents = evController.getComponents();
                        Component[] jsComponents = jsController.getComponents();
                        if (evComponents.length == jsComponents.length) {
                            boolean foundADifference = false;
                            for (int k = 0; k < evComponents.length; k++) {
                                if (evComponents[k].getIdentifier() != jsComponents[k].getIdentifier()) {
                                    foundADifference = true;
                                }
                            }
                            if (!foundADifference) {
                                controllers.add(new LinuxCombinedController((LinuxAbstractController) arrayList.remove(i), (LinuxJoystickAbstractController) arrayList2.remove(j)));
                                i--;
                                int i2 = j - 1;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        controllers.addAll(arrayList);
        controllers.addAll(arrayList2);
        Controller[] controllers_array = new Controller[controllers.size()];
        controllers.toArray(controllers_array);
        return controllers_array;
    }

    private static final Component.Identifier.Button getButtonIdentifier(int index) {
        switch (index) {
            case 0:
                return Component.Identifier.Button._0;
            case 1:
                return Component.Identifier.Button._1;
            case 2:
                return Component.Identifier.Button._2;
            case 3:
                return Component.Identifier.Button._3;
            case 4:
                return Component.Identifier.Button._4;
            case 5:
                return Component.Identifier.Button._5;
            case 6:
                return Component.Identifier.Button._6;
            case 7:
                return Component.Identifier.Button._7;
            case 8:
                return Component.Identifier.Button._8;
            case 9:
                return Component.Identifier.Button._9;
            case 10:
                return Component.Identifier.Button._10;
            case 11:
                return Component.Identifier.Button._11;
            case 12:
                return Component.Identifier.Button._12;
            case 13:
                return Component.Identifier.Button._13;
            case 14:
                return Component.Identifier.Button._14;
            case 15:
                return Component.Identifier.Button._15;
            case 16:
                return Component.Identifier.Button._16;
            case 17:
                return Component.Identifier.Button._17;
            case 18:
                return Component.Identifier.Button._18;
            case 19:
                return Component.Identifier.Button._19;
            case 20:
                return Component.Identifier.Button._20;
            case 21:
                return Component.Identifier.Button._21;
            case 22:
                return Component.Identifier.Button._22;
            case 23:
                return Component.Identifier.Button._23;
            case 24:
                return Component.Identifier.Button._24;
            case 25:
                return Component.Identifier.Button._25;
            case 26:
                return Component.Identifier.Button._26;
            case 27:
                return Component.Identifier.Button._27;
            case 28:
                return Component.Identifier.Button._28;
            case 29:
                return Component.Identifier.Button._29;
            case 30:
                return Component.Identifier.Button._30;
            case 31:
                return Component.Identifier.Button._31;
            default:
                return null;
        }
    }

    private static final Controller createJoystickFromJoystickDevice(LinuxJoystickDevice device) {
        List components = new ArrayList();
        byte[] axisMap = device.getAxisMap();
        char[] buttonMap = device.getButtonMap();
        LinuxJoystickAxis[] hatBits = new LinuxJoystickAxis[6];
        for (int i = 0; i < device.getNumButtons(); i++) {
            Component.Identifier button_id = LinuxNativeTypesMap.getButtonID(buttonMap[i]);
            if (button_id != null) {
                LinuxJoystickButton button = new LinuxJoystickButton(button_id);
                device.registerButton(i, button);
                components.add(button);
            }
        }
        for (int i2 = 0; i2 < device.getNumAxes(); i2++) {
            Component.Identifier.Axis axis_id = (Component.Identifier.Axis) LinuxNativeTypesMap.getAbsAxisID(axisMap[i2]);
            LinuxJoystickAxis axis = new LinuxJoystickAxis(axis_id);
            device.registerAxis(i2, axis);
            if (axisMap[i2] == 16) {
                hatBits[0] = axis;
            } else if (axisMap[i2] == 17) {
                hatBits[1] = axis;
                LinuxJoystickPOV linuxJoystickPOV = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[0], hatBits[1]);
                device.registerPOV(linuxJoystickPOV);
                components.add(linuxJoystickPOV);
            } else if (axisMap[i2] == 18) {
                hatBits[2] = axis;
            } else if (axisMap[i2] == 19) {
                hatBits[3] = axis;
                LinuxJoystickPOV linuxJoystickPOV2 = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[2], hatBits[3]);
                device.registerPOV(linuxJoystickPOV2);
                components.add(linuxJoystickPOV2);
            } else if (axisMap[i2] == 20) {
                hatBits[4] = axis;
            } else if (axisMap[i2] == 21) {
                hatBits[5] = axis;
                LinuxJoystickPOV linuxJoystickPOV3 = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[4], hatBits[5]);
                device.registerPOV(linuxJoystickPOV3);
                components.add(linuxJoystickPOV3);
            } else {
                components.add(axis);
            }
        }
        return new LinuxJoystickAbstractController(device, (Component[]) components.toArray(new Component[0]), new Controller[0], new Rumbler[0]);
    }

    private final void enumerateJoystickControllers(List controllers) {
        File[] joystick_device_files = enumerateJoystickDeviceFiles("/dev/input");
        if (joystick_device_files == null || joystick_device_files.length == 0) {
            joystick_device_files = enumerateJoystickDeviceFiles("/dev");
            if (joystick_device_files == null) {
                return;
            }
        }
        for (File event_file : joystick_device_files) {
            try {
                String path = getAbsolutePathPrivileged(event_file);
                LinuxJoystickDevice device = new LinuxJoystickDevice(path);
                Controller controller = createJoystickFromJoystickDevice(device);
                if (controller != null) {
                    controllers.add(controller);
                    this.devices.add(device);
                } else {
                    device.close();
                }
            } catch (IOException e) {
                logln(new StringBuffer().append("Failed to open device (").append(event_file).append("): ").append(e.getMessage()).toString());
            }
        }
    }

    private static final File[] enumerateJoystickDeviceFiles(String dev_path) {
        File dev = new File(dev_path);
        return listFilesPrivileged(dev, new FilenameFilter() { // from class: net.java.games.input.LinuxEnvironmentPlugin.5
            @Override // java.io.FilenameFilter
            public final boolean accept(File dir, String name) {
                return name.startsWith("js");
            }
        });
    }

    private static String getAbsolutePathPrivileged(File file) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(file) { // from class: net.java.games.input.LinuxEnvironmentPlugin.6
            private final File val$file;

            {
                this.val$file = file;
            }

            @Override // java.security.PrivilegedAction
            public Object run() {
                return this.val$file.getAbsolutePath();
            }
        });
    }

    private static File[] listFilesPrivileged(File dir, FilenameFilter filter) {
        return (File[]) AccessController.doPrivileged(new PrivilegedAction(dir, filter) { // from class: net.java.games.input.LinuxEnvironmentPlugin.7
            private final File val$dir;
            private final FilenameFilter val$filter;

            {
                this.val$dir = dir;
                this.val$filter = filter;
            }

            @Override // java.security.PrivilegedAction
            public Object run() {
                File[] files = this.val$dir.listFiles(this.val$filter);
                Arrays.sort(files, new Comparator(this) { // from class: net.java.games.input.LinuxEnvironmentPlugin.7.1
                    private final AnonymousClass7 this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.util.Comparator
                    public int compare(Object f1, Object f2) {
                        return ((File) f1).getName().compareTo(((File) f2).getName());
                    }
                });
                return files;
            }
        });
    }

    private final void enumerateEventControllers(List controllers) {
        File dev = new File("/dev/input");
        File[] event_device_files = listFilesPrivileged(dev, new FilenameFilter(this) { // from class: net.java.games.input.LinuxEnvironmentPlugin.8
            private final LinuxEnvironmentPlugin this$0;

            {
                this.this$0 = this;
            }

            @Override // java.io.FilenameFilter
            public final boolean accept(File dir, String name) {
                return name.startsWith("event");
            }
        });
        if (event_device_files == null) {
            return;
        }
        for (File event_file : event_device_files) {
            try {
                String path = getAbsolutePathPrivileged(event_file);
                LinuxEventDevice device = new LinuxEventDevice(path);
                try {
                    Controller controller = createControllerFromDevice(device);
                    if (controller != null) {
                        controllers.add(controller);
                        this.devices.add(device);
                    } else {
                        device.close();
                    }
                } catch (IOException e) {
                    logln(new StringBuffer().append("Failed to create Controller: ").append(e.getMessage()).toString());
                    device.close();
                }
            } catch (IOException e2) {
                logln(new StringBuffer().append("Failed to open device (").append(event_file).append("): ").append(e2.getMessage()).toString());
            }
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxEnvironmentPlugin$ShutdownHook.class */
    private final class ShutdownHook extends Thread {
        private final LinuxEnvironmentPlugin this$0;

        private ShutdownHook(LinuxEnvironmentPlugin linuxEnvironmentPlugin) {
            this.this$0 = linuxEnvironmentPlugin;
        }

        ShutdownHook(LinuxEnvironmentPlugin x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws Throwable {
            for (int i = 0; i < this.this$0.devices.size(); i++) {
                try {
                    LinuxDevice device = (LinuxDevice) this.this$0.devices.get(i);
                    device.close();
                } catch (IOException e) {
                    ControllerEnvironment.logln(new StringBuffer().append("Failed to close device: ").append(e.getMessage()).toString());
                }
            }
        }
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return supported;
    }
}
