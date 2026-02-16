package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import net.java.games.util.plugins.Plugins;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/DefaultControllerEnvironment.class */
class DefaultControllerEnvironment extends ControllerEnvironment {
    static String libPath;
    private static Logger log;
    private ArrayList controllers;
    private Collection loadedPlugins = new ArrayList();
    static Class class$net$java$games$input$DefaultControllerEnvironment;
    static Class class$net$java$games$input$ControllerEnvironment;

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    static {
        Class clsClass$;
        if (class$net$java$games$input$DefaultControllerEnvironment == null) {
            clsClass$ = class$("net.java.games.input.DefaultControllerEnvironment");
            class$net$java$games$input$DefaultControllerEnvironment = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$DefaultControllerEnvironment;
        }
        log = Logger.getLogger(clsClass$.getName());
    }

    static void loadLibrary(String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(lib_name) { // from class: net.java.games.input.DefaultControllerEnvironment.1
            private final String val$lib_name;

            {
                this.val$lib_name = lib_name;
            }

            @Override // java.security.PrivilegedAction
            public final Object run() {
                String lib_path = System.getProperty("net.java.games.input.librarypath");
                if (lib_path != null) {
                    System.load(new StringBuffer().append(lib_path).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                    return null;
                }
                System.loadLibrary(this.val$lib_name);
                return null;
            }
        });
    }

    static String getPrivilegedProperty(String property) {
        return (String) AccessController.doPrivileged(new PrivilegedAction(property) { // from class: net.java.games.input.DefaultControllerEnvironment.2
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
        return (String) AccessController.doPrivileged(new PrivilegedAction(property, default_value) { // from class: net.java.games.input.DefaultControllerEnvironment.3
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

    @Override // net.java.games.input.ControllerEnvironment
    public Controller[] getControllers() {
        if (this.controllers == null) {
            this.controllers = new ArrayList();
            AccessController.doPrivileged(new PrivilegedAction(this) { // from class: net.java.games.input.DefaultControllerEnvironment.4
                private final DefaultControllerEnvironment this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.security.PrivilegedAction
                public Object run() throws Throwable {
                    this.this$0.scanControllers();
                    return null;
                }
            });
            String pluginClasses = new StringBuffer().append(getPrivilegedProperty("jinput.plugins", "")).append(" ").append(getPrivilegedProperty("net.java.games.input.plugins", "")).toString();
            if (!getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false") && !getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) {
                String osName = getPrivilegedProperty("os.name", "").trim();
                if (osName.equals("Linux")) {
                    pluginClasses = new StringBuffer().append(pluginClasses).append(" net.java.games.input.LinuxEnvironmentPlugin").toString();
                } else if (osName.equals("Mac OS X")) {
                    pluginClasses = new StringBuffer().append(pluginClasses).append(" net.java.games.input.OSXEnvironmentPlugin").toString();
                } else if (osName.equals("Windows XP") || osName.equals("Windows Vista") || osName.equals("Windows 7")) {
                    pluginClasses = new StringBuffer().append(pluginClasses).append(" net.java.games.input.DirectAndRawInputEnvironmentPlugin").toString();
                } else if (osName.equals("Windows 98") || osName.equals("Windows 2000")) {
                    pluginClasses = new StringBuffer().append(pluginClasses).append(" net.java.games.input.DirectInputEnvironmentPlugin").toString();
                } else if (osName.startsWith("Windows")) {
                    log.warning(new StringBuffer().append("Found unknown Windows version: ").append(osName).toString());
                    log.info("Attempting to use default windows plug-in.");
                    pluginClasses = new StringBuffer().append(pluginClasses).append(" net.java.games.input.DirectAndRawInputEnvironmentPlugin").toString();
                } else {
                    log.info(new StringBuffer().append("Trying to use default plugin, OS name ").append(osName).append(" not recognised").toString());
                }
            }
            StringTokenizer pluginClassTok = new StringTokenizer(pluginClasses, " \t\n\r\f,;:");
            while (pluginClassTok.hasMoreTokens()) {
                String className = pluginClassTok.nextToken();
                try {
                    if (!this.loadedPlugins.contains(className)) {
                        log.info(new StringBuffer().append("Loading: ").append(className).toString());
                        Class<?> cls = Class.forName(className);
                        ControllerEnvironment ce = (ControllerEnvironment) cls.newInstance();
                        if (ce.isSupported()) {
                            addControllers(ce.getControllers());
                            this.loadedPlugins.add(ce.getClass().getName());
                        } else {
                            logln(new StringBuffer().append(cls.getName()).append(" is not supported").toString());
                        }
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        Controller[] ret = new Controller[this.controllers.size()];
        Iterator it = this.controllers.iterator();
        int i = 0;
        while (it.hasNext()) {
            ret[i] = (Controller) it.next();
            i++;
        }
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanControllers() throws Throwable {
        String pluginPathName = getPrivilegedProperty("jinput.controllerPluginPath");
        if (pluginPathName == null) {
            pluginPathName = "controller";
        }
        scanControllersAt(new StringBuffer().append(getPrivilegedProperty("java.home")).append(File.separator).append("lib").append(File.separator).append(pluginPathName).toString());
        scanControllersAt(new StringBuffer().append(getPrivilegedProperty("user.dir")).append(File.separator).append(pluginPathName).toString());
    }

    private void scanControllersAt(String path) throws Throwable {
        Class clsClass$;
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        try {
            Plugins plugins = new Plugins(file);
            if (class$net$java$games$input$ControllerEnvironment == null) {
                clsClass$ = class$("net.java.games.input.ControllerEnvironment");
                class$net$java$games$input$ControllerEnvironment = clsClass$;
            } else {
                clsClass$ = class$net$java$games$input$ControllerEnvironment;
            }
            Class[] envClasses = plugins.getExtends(clsClass$);
            for (int i = 0; i < envClasses.length; i++) {
                try {
                    ControllerEnvironment.logln(new StringBuffer().append("ControllerEnvironment ").append(envClasses[i].getName()).append(" loaded by ").append(envClasses[i].getClassLoader()).toString());
                    ControllerEnvironment ce = (ControllerEnvironment) envClasses[i].newInstance();
                    if (ce.isSupported()) {
                        addControllers(ce.getControllers());
                        this.loadedPlugins.add(ce.getClass().getName());
                    } else {
                        logln(new StringBuffer().append(envClasses[i].getName()).append(" is not supported").toString());
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addControllers(Controller[] c) {
        for (Controller controller : c) {
            this.controllers.add(controller);
        }
    }

    @Override // net.java.games.input.ControllerEnvironment
    public boolean isSupported() {
        return true;
    }
}
