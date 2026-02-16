package org.lwjgl.util.mapped;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/mapped/MappedObjectClassLoader.class */
public class MappedObjectClassLoader extends URLClassLoader {
    static final String MAPPEDOBJECT_PACKAGE_PREFIX = MappedObjectClassLoader.class.getPackage().getName() + ".";
    static boolean FORKED;
    private static long total_time_transforming;

    public static boolean fork(Class<?> mainClass, String[] args) {
        if (FORKED) {
            return false;
        }
        FORKED = true;
        try {
            MappedObjectClassLoader loader = new MappedObjectClassLoader(mainClass);
            loader.loadMappedObject();
            Class<?> replacedMainClass = loader.loadClass(mainClass.getName());
            Method mainMethod = replacedMainClass.getMethod("main", String[].class);
            mainMethod.invoke(null, args);
            return true;
        } catch (InvocationTargetException exc) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), exc.getCause());
            return true;
        } catch (Throwable cause) {
            throw new Error("failed to fork", cause);
        }
    }

    private MappedObjectClassLoader(Class<?> mainClass) {
        super(((URLClassLoader) mainClass.getClassLoader()).getURLs());
    }

    protected synchronized Class<?> loadMappedObject() throws ClassNotFoundException {
        String name = MappedObject.class.getName();
        String className = name.replace('.', '/');
        byte[] bytecode = readStream(getResourceAsStream(className.concat(".class")));
        long t0 = System.nanoTime();
        byte[] bytecode2 = MappedObjectTransformer.transformMappedObject(bytecode);
        long t1 = System.nanoTime();
        total_time_transforming += t1 - t0;
        if (MappedObjectTransformer.PRINT_ACTIVITY) {
            printActivity(className, t0, t1);
        }
        Class<?> clazz = super.defineClass(name, bytecode2, 0, bytecode2.length);
        resolveClass(clazz);
        return clazz;
    }

    @Override // java.lang.ClassLoader
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("sun.") || name.startsWith("sunw.") || name.startsWith("org.objectweb.asm.")) {
            return super.loadClass(name, resolve);
        }
        String className = name.replace('.', '/');
        boolean inThisPackage = name.startsWith(MAPPEDOBJECT_PACKAGE_PREFIX);
        if (inThisPackage && (name.equals(MappedObjectClassLoader.class.getName()) || name.equals(MappedObjectTransformer.class.getName()) || name.equals(CacheUtil.class.getName()))) {
            return super.loadClass(name, resolve);
        }
        byte[] bytecode = readStream(getResourceAsStream(className.concat(".class")));
        if (!inThisPackage || name.substring(MAPPEDOBJECT_PACKAGE_PREFIX.length()).indexOf(46) != -1) {
            long t0 = System.nanoTime();
            byte[] newBytecode = MappedObjectTransformer.transformMappedAPI(className, bytecode);
            long t1 = System.nanoTime();
            total_time_transforming += t1 - t0;
            if (bytecode != newBytecode) {
                bytecode = newBytecode;
                if (MappedObjectTransformer.PRINT_ACTIVITY) {
                    printActivity(className, t0, t1);
                }
            }
        }
        Class<?> clazz = super.defineClass(name, bytecode, 0, bytecode.length);
        if (resolve) {
            resolveClass(clazz);
        }
        return clazz;
    }

    private static void printActivity(String className, long t0, long t1) {
        StringBuilder msg = new StringBuilder(MappedObjectClassLoader.class.getSimpleName() + ": " + className);
        if (MappedObjectTransformer.PRINT_TIMING) {
            msg.append("\n\ttransforming took " + ((t1 - t0) / 1000) + " micros (total: " + ((total_time_transforming / 1000) / 1000) + "ms)");
        }
        LWJGLUtil.log(msg);
    }

    private static byte[] readStream(InputStream in) {
        byte[] bytecode = new byte[256];
        int len = 0;
        while (true) {
            try {
                if (bytecode.length == len) {
                    bytecode = copyOf(bytecode, len * 2);
                }
                int got = in.read(bytecode, len, bytecode.length - len);
                if (got == -1) {
                    break;
                }
                len += got;
            } catch (IOException e) {
                try {
                    in.close();
                } catch (IOException e2) {
                }
            } catch (Throwable th) {
                try {
                    in.close();
                } catch (IOException e3) {
                }
                throw th;
            }
        }
        try {
            in.close();
        } catch (IOException e4) {
        }
        return copyOf(bytecode, len);
    }

    private static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }
}
