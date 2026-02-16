package net.java.games.util.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/util/plugins/Plugins.class */
public class Plugins {
    static final boolean DEBUG = true;
    List pluginList = new ArrayList();

    public Plugins(File pluginRoot) throws IOException {
        scanPlugins(pluginRoot);
    }

    private void scanPlugins(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files == null) {
            throw new FileNotFoundException(new StringBuffer().append("Plugin directory ").append(dir.getName()).append(" not found.").toString());
        }
        for (File f : files) {
            if (f.getName().endsWith(".jar")) {
                processJar(f);
            } else if (f.isDirectory()) {
                scanPlugins(f);
            }
        }
    }

    private void processJar(File f) {
        try {
            System.out.println(new StringBuffer().append("Scanning jar: ").append(f.getName()).toString());
            PluginLoader loader = new PluginLoader(f);
            JarFile jf = new JarFile(f);
            Enumeration<JarEntry> enumerationEntries = jf.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry je = enumerationEntries.nextElement();
                System.out.println(new StringBuffer().append("Examining file : ").append(je.getName()).toString());
                if (je.getName().endsWith("Plugin.class")) {
                    System.out.println(new StringBuffer().append("Found candidate class: ").append(je.getName()).toString());
                    String cname = je.getName();
                    Class pc = loader.loadClass(cname.substring(0, cname.length() - 6).replace('/', '.'));
                    if (loader.attemptPluginDefine(pc)) {
                        System.out.println(new StringBuffer().append("Adding class to plugins:").append(pc.getName()).toString());
                        this.pluginList.add(pc);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Class[] get() {
        Class[] pluginArray = new Class[this.pluginList.size()];
        return (Class[]) this.pluginList.toArray(pluginArray);
    }

    public Class[] getImplementsAny(Class[] interfaces) {
        List matchList = new ArrayList(this.pluginList.size());
        Set interfaceSet = new HashSet();
        for (Class cls : interfaces) {
            interfaceSet.add(cls);
        }
        for (Class pluginClass : this.pluginList) {
            if (classImplementsAny(pluginClass, interfaceSet)) {
                matchList.add(pluginClass);
            }
        }
        Class[] pluginArray = new Class[matchList.size()];
        return (Class[]) matchList.toArray(pluginArray);
    }

    private boolean classImplementsAny(Class testClass, Set interfaces) {
        if (testClass == null) {
            return false;
        }
        Class<?>[] interfaces2 = testClass.getInterfaces();
        for (Class<?> cls : interfaces2) {
            if (interfaces.contains(cls)) {
                return true;
            }
        }
        for (Class<?> cls2 : interfaces2) {
            if (classImplementsAny(cls2, interfaces)) {
                return true;
            }
        }
        return classImplementsAny(testClass.getSuperclass(), interfaces);
    }

    public Class[] getImplementsAll(Class[] interfaces) {
        List matchList = new ArrayList(this.pluginList.size());
        Set interfaceSet = new HashSet();
        for (Class cls : interfaces) {
            interfaceSet.add(cls);
        }
        for (Class pluginClass : this.pluginList) {
            if (classImplementsAll(pluginClass, interfaceSet)) {
                matchList.add(pluginClass);
            }
        }
        Class[] pluginArray = new Class[matchList.size()];
        return (Class[]) matchList.toArray(pluginArray);
    }

    private boolean classImplementsAll(Class testClass, Set interfaces) {
        if (testClass == null) {
            return false;
        }
        Class<?>[] interfaces2 = testClass.getInterfaces();
        for (int i = 0; i < interfaces2.length; i++) {
            if (interfaces.contains(interfaces2[i])) {
                interfaces.remove(interfaces2[i]);
                if (interfaces.size() == 0) {
                    return true;
                }
            }
        }
        for (Class<?> cls : interfaces2) {
            if (classImplementsAll(cls, interfaces)) {
                return true;
            }
        }
        return classImplementsAll(testClass.getSuperclass(), interfaces);
    }

    public Class[] getExtends(Class superclass) {
        List matchList = new ArrayList(this.pluginList.size());
        for (Class pluginClass : this.pluginList) {
            if (classExtends(pluginClass, superclass)) {
                matchList.add(pluginClass);
            }
        }
        Class[] pluginArray = new Class[matchList.size()];
        return (Class[]) matchList.toArray(pluginArray);
    }

    private boolean classExtends(Class testClass, Class superclass) {
        if (testClass == null) {
            return false;
        }
        if (testClass == superclass) {
            return true;
        }
        return classExtends(testClass.getSuperclass(), superclass);
    }
}
