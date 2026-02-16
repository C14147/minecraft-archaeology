package net.java.games.input;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/PluginClassLoader.class */
class PluginClassLoader extends ClassLoader {
    private static String pluginDirectory;
    private static final FileFilter JAR_FILTER;
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$PluginClassLoader;

    /* JADX INFO: renamed from: net.java.games.input.PluginClassLoader$1, reason: invalid class name */
    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/PluginClassLoader$1.class */
    static class AnonymousClass1 {
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    static {
        Class clsClass$;
        if (class$net$java$games$input$PluginClassLoader == null) {
            clsClass$ = class$("net.java.games.input.PluginClassLoader");
            class$net$java$games$input$PluginClassLoader = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$PluginClassLoader;
        }
        $assertionsDisabled = !clsClass$.desiredAssertionStatus();
        JAR_FILTER = new JarFileFilter(null);
    }

    public PluginClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    @Override // java.lang.ClassLoader
    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException {
        if (pluginDirectory == null) {
            pluginDirectory = new StringBuffer().append(DefaultControllerEnvironment.libPath).append(File.separator).append("controller").toString();
        }
        try {
            return loadClassFromDirectory(name);
        } catch (Exception e) {
            try {
                return loadClassFromJAR(name);
            } catch (IOException e2) {
                throw new ClassNotFoundException(name, e2);
            }
        }
    }

    private byte[] loadClassFromDirectory(String name) throws ClassNotFoundException, IOException {
        StringTokenizer tokenizer = new StringTokenizer(name, ".");
        StringBuffer path = new StringBuffer(pluginDirectory);
        while (tokenizer.hasMoreTokens()) {
            path.append(File.separator);
            path.append(tokenizer.nextToken());
        }
        path.append(".class");
        File file = new File(path.toString());
        if (!file.exists()) {
            throw new ClassNotFoundException(name);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        if (!$assertionsDisabled && file.length() > 2147483647L) {
            throw new AssertionError();
        }
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        int length2 = fileInputStream.read(bytes);
        if ($assertionsDisabled || length == length2) {
            return bytes;
        }
        throw new AssertionError();
    }

    private byte[] loadClassFromJAR(String name) throws ClassNotFoundException, IOException {
        File dir = new File(pluginDirectory);
        File[] jarFiles = dir.listFiles(JAR_FILTER);
        if (jarFiles == null) {
            throw new ClassNotFoundException(new StringBuffer().append("Could not find class ").append(name).toString());
        }
        for (File file : jarFiles) {
            JarFile jarfile = new JarFile(file);
            JarEntry jarentry = jarfile.getJarEntry(new StringBuffer().append(name).append(".class").toString());
            if (jarentry != null) {
                InputStream jarInputStream = jarfile.getInputStream(jarentry);
                if (!$assertionsDisabled && jarentry.getSize() > 2147483647L) {
                    throw new AssertionError();
                }
                int length = (int) jarentry.getSize();
                if (!$assertionsDisabled && length < 0) {
                    throw new AssertionError();
                }
                byte[] bytes = new byte[length];
                int length2 = jarInputStream.read(bytes);
                if ($assertionsDisabled || length == length2) {
                    return bytes;
                }
                throw new AssertionError();
            }
        }
        throw new FileNotFoundException(name);
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/PluginClassLoader$JarFileFilter.class */
    private static class JarFileFilter implements FileFilter {
        private JarFileFilter() {
        }

        JarFileFilter(AnonymousClass1 x0) {
            this();
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().toUpperCase().endsWith(".JAR");
        }
    }
}
