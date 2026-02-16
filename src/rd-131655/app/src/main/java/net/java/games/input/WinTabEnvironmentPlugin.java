package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabEnvironmentPlugin.class */
public class WinTabEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;
    private final List active_devices = new ArrayList();
    private final WinTabContext winTabContext;

    static {
        supported = false;
        String osName = getPrivilegedProperty("os.name", "").trim();
        if (osName.startsWith("Windows")) {
            supported = true;
            loadLibrary("jinput-wintab");
        }
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.WinTabEnvironmentPlugin.1
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
                    boolean unused = WinTabEnvironmentPlugin.supported = false;
                    return null;
                }
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.WinTabEnvironmentPlugin.2
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
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.WinTabEnvironmentPlugin.3
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

    public WinTabEnvironmentPlugin() {
        if (isSupported()) {
            WinTabContext winTabContext = null;
            Controller[] controllers = new Controller[0];
            try {
                DummyWindow window = new DummyWindow();
                winTabContext = new WinTabContext(window);
                try {
                    winTabContext.open();
                    controllers = winTabContext.getControllers();
                } catch (Exception e) {
                    window.destroy();
                    throw e;
                }
            } catch (Exception e2) {
                logln(new StringBuffer().append("Failed to enumerate devices: ").append(e2.getMessage()).toString());
                e2.printStackTrace();
            }
            this.controllers = controllers;
            this.winTabContext = winTabContext;
            AccessController.doPrivileged(new PrivilegedAction(this) { // from class: net.java.games.input.WinTabEnvironmentPlugin.4
                private final WinTabEnvironmentPlugin this$0;

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
        this.winTabContext = null;
        this.controllers = new Controller[0];
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return supported;
    }

    @Override // net.java.games.input.ControllerEnvironment
    public Controller[] getControllers() {
        return this.controllers;
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/WinTabEnvironmentPlugin$ShutdownHook.class */
    private final class ShutdownHook extends Thread {
        private final WinTabEnvironmentPlugin this$0;

        private ShutdownHook(WinTabEnvironmentPlugin winTabEnvironmentPlugin) {
            this.this$0 = winTabEnvironmentPlugin;
        }

        ShutdownHook(WinTabEnvironmentPlugin x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            for (int i = 0; i < this.this$0.active_devices.size(); i++) {
            }
            this.this$0.winTabContext.close();
        }
    }
}
