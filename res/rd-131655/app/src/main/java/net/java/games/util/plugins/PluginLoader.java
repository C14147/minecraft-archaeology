package net.java.games.util.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/util/plugins/PluginLoader.class */
public class PluginLoader extends URLClassLoader {
    static final boolean DEBUG = false;
    File parentDir;
    boolean localDLLs;
    static Class class$net$java$games$util$plugins$Plugin;

    public PluginLoader(File jf) throws MalformedURLException {
        super(new URL[]{jf.toURL()}, Thread.currentThread().getContextClassLoader());
        this.localDLLs = true;
        this.parentDir = jf.getParentFile();
        if (System.getProperty("net.java.games.util.plugins.nolocalnative") != null) {
            this.localDLLs = false;
        }
    }

    @Override // java.lang.ClassLoader
    protected String findLibrary(String libname) {
        if (this.localDLLs) {
            String libpath = new StringBuffer().append(this.parentDir.getPath()).append(File.separator).append(System.mapLibraryName(libname)).toString();
            return libpath;
        }
        return super.findLibrary(libname);
    }

    public boolean attemptPluginDefine(Class pc) {
        return !pc.isInterface() && classImplementsPlugin(pc);
    }

    private boolean classImplementsPlugin(Class testClass) throws Throwable {
        Class<?> clsClass$;
        if (testClass == null) {
            return false;
        }
        Class<?>[] interfaces = testClass.getInterfaces();
        for (Class<?> cls : interfaces) {
            if (class$net$java$games$util$plugins$Plugin == null) {
                clsClass$ = class$("net.java.games.util.plugins.Plugin");
                class$net$java$games$util$plugins$Plugin = clsClass$;
            } else {
                clsClass$ = class$net$java$games$util$plugins$Plugin;
            }
            if (cls == clsClass$) {
                return true;
            }
        }
        for (Class<?> cls2 : interfaces) {
            if (classImplementsPlugin(cls2)) {
                return true;
            }
        }
        return classImplementsPlugin(testClass.getSuperclass());
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }
}
