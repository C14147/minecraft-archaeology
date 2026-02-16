package org.lwjgl.opengl;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/GLContext.class */
public final class GLContext {
    private static final ThreadLocal<ContextCapabilities> current_capabilities = new ThreadLocal<>();
    private static CapabilitiesCacheEntry fast_path_cache = new CapabilitiesCacheEntry();
    private static final ThreadLocal<CapabilitiesCacheEntry> thread_cache_entries = new ThreadLocal<>();
    private static final Map<Object, ContextCapabilities> capability_cache = new WeakHashMap();
    private static int gl_ref_count;
    private static boolean did_auto_load;

    private static native long ngetFunctionAddress(long j);

    private static native void nLoadOpenGLLibrary() throws LWJGLException;

    private static native void nUnloadOpenGLLibrary();

    static native void resetNativeStubs(Class cls);

    static {
        Sys.initialize();
    }

    public static ContextCapabilities getCapabilities() {
        ContextCapabilities caps = getCapabilitiesImpl();
        if (caps == null) {
            throw new RuntimeException("No OpenGL context found in the current thread.");
        }
        return caps;
    }

    private static ContextCapabilities getCapabilitiesImpl() {
        CapabilitiesCacheEntry recent_cache_entry = fast_path_cache;
        if (recent_cache_entry.owner == Thread.currentThread()) {
            return recent_cache_entry.capabilities;
        }
        return getThreadLocalCapabilities();
    }

    static ContextCapabilities getCapabilities(Object context) {
        return capability_cache.get(context);
    }

    private static ContextCapabilities getThreadLocalCapabilities() {
        return current_capabilities.get();
    }

    static void setCapabilities(ContextCapabilities capabilities) {
        current_capabilities.set(capabilities);
        CapabilitiesCacheEntry thread_cache_entry = thread_cache_entries.get();
        if (thread_cache_entry == null) {
            thread_cache_entry = new CapabilitiesCacheEntry();
            thread_cache_entries.set(thread_cache_entry);
        }
        thread_cache_entry.owner = Thread.currentThread();
        thread_cache_entry.capabilities = capabilities;
        fast_path_cache = thread_cache_entry;
    }

    static long getPlatformSpecificFunctionAddress(String function_prefix, String[] os_prefixes, String[] os_function_prefixes, String function) {
        String os_name = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.lwjgl.opengl.GLContext.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty("os.name");
            }
        });
        for (int i = 0; i < os_prefixes.length; i++) {
            if (os_name.startsWith(os_prefixes[i])) {
                String platform_function_name = function.replaceFirst(function_prefix, os_function_prefixes[i]);
                long address = getFunctionAddress(platform_function_name);
                return address;
            }
        }
        return 0L;
    }

    static long getFunctionAddress(String[] aliases) {
        for (String alias : aliases) {
            long address = getFunctionAddress(alias);
            if (address != 0) {
                return address;
            }
        }
        return 0L;
    }

    static long getFunctionAddress(String name) {
        ByteBuffer buffer = MemoryUtil.encodeASCII(name);
        return ngetFunctionAddress(MemoryUtil.getAddress(buffer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int getSupportedExtensions(Set<String> supported_extensions) {
        String version = GL11.glGetString(GL11.GL_VERSION);
        if (version == null) {
            throw new IllegalStateException("glGetString(GL_VERSION) returned null - possibly caused by missing current context.");
        }
        StringTokenizer version_tokenizer = new StringTokenizer(version, ". ");
        String major_string = version_tokenizer.nextToken();
        String minor_string = version_tokenizer.nextToken();
        int majorVersion = 0;
        int minorVersion = 0;
        try {
            majorVersion = Integer.parseInt(major_string);
            minorVersion = Integer.parseInt(minor_string);
        } catch (NumberFormatException e) {
            LWJGLUtil.log("The major and/or minor OpenGL version is malformed: " + e.getMessage());
        }
        int[] iArr = {new int[]{1, 2, 3, 4, 5}, new int[]{0, 1}, new int[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3, 4, 5}};
        for (int major = 1; major <= iArr.length; major++) {
            for (byte b : iArr[major - 1]) {
                if (major < majorVersion || (major == majorVersion && b <= minorVersion)) {
                    supported_extensions.add("OpenGL" + Integer.toString(major) + Integer.toString(b));
                }
            }
        }
        int profileMask = 0;
        if (majorVersion < 3) {
            String extensions_string = GL11.glGetString(GL11.GL_EXTENSIONS);
            if (extensions_string == null) {
                throw new IllegalStateException("glGetString(GL_EXTENSIONS) returned null - is there a context current?");
            }
            StringTokenizer tokenizer = new StringTokenizer(extensions_string);
            while (tokenizer.hasMoreTokens()) {
                supported_extensions.add(tokenizer.nextToken());
            }
        } else {
            int extensionCount = GL11.glGetInteger(GL30.GL_NUM_EXTENSIONS);
            for (int i = 0; i < extensionCount; i++) {
                supported_extensions.add(GL30.glGetStringi(GL11.GL_EXTENSIONS, i));
            }
            if (3 < majorVersion || 2 <= minorVersion) {
                Util.checkGLError();
                try {
                    profileMask = GL11.glGetInteger(37158);
                    Util.checkGLError();
                } catch (OpenGLException e2) {
                    LWJGLUtil.log("Failed to retrieve CONTEXT_PROFILE_MASK");
                }
            }
        }
        return profileMask;
    }

    static void initNativeStubs(final Class<?> extension_class, Set supported_extensions, String ext_name) {
        resetNativeStubs(extension_class);
        if (supported_extensions.contains(ext_name)) {
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.lwjgl.opengl.GLContext.2
                    @Override // java.security.PrivilegedExceptionAction
                    public Object run() throws Exception {
                        Method init_stubs_method = extension_class.getDeclaredMethod("initNativeStubs", new Class[0]);
                        init_stubs_method.invoke(null, new Object[0]);
                        return null;
                    }
                });
            } catch (Exception e) {
                LWJGLUtil.log("Failed to initialize extension " + extension_class + " - exception: " + e);
                supported_extensions.remove(ext_name);
            }
        }
    }

    public static synchronized void useContext(Object context) throws LWJGLException {
        useContext(context, false);
    }

    public static synchronized void useContext(Object context, boolean forwardCompatible) throws LWJGLException {
        if (context == null) {
            ContextCapabilities.unloadAllStubs();
            setCapabilities(null);
            if (did_auto_load) {
                unloadOpenGLLibrary();
                return;
            }
            return;
        }
        if (gl_ref_count == 0) {
            loadOpenGLLibrary();
            did_auto_load = true;
        }
        try {
            ContextCapabilities capabilities = capability_cache.get(context);
            if (capabilities == null) {
                new ContextCapabilities(forwardCompatible);
                capability_cache.put(context, getCapabilities());
            } else {
                setCapabilities(capabilities);
            }
        } catch (LWJGLException e) {
            if (did_auto_load) {
                unloadOpenGLLibrary();
            }
            throw e;
        }
    }

    public static synchronized void loadOpenGLLibrary() throws LWJGLException {
        if (gl_ref_count == 0) {
            nLoadOpenGLLibrary();
        }
        gl_ref_count++;
    }

    public static synchronized void unloadOpenGLLibrary() {
        gl_ref_count--;
        if (gl_ref_count == 0 && LWJGLUtil.getPlatform() != 1) {
            nUnloadOpenGLLibrary();
        }
    }

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/GLContext$CapabilitiesCacheEntry.class */
    private static final class CapabilitiesCacheEntry {
        Thread owner;
        ContextCapabilities capabilities;

        private CapabilitiesCacheEntry() {
        }
    }
}
