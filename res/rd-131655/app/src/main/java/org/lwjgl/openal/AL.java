package org.lwjgl.openal;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/openal/AL.class */
public final class AL {
    static ALCdevice device;
    static ALCcontext context;
    private static boolean created;

    private static native void nCreate(String str) throws LWJGLException;

    private static native void nCreateDefault() throws LWJGLException;

    private static native void nDestroy();

    private static native void resetNativeStubs(Class cls);

    static {
        Sys.initialize();
    }

    private AL() {
    }

    public static boolean isCreated() {
        return created;
    }

    public static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized) throws LWJGLException {
        create(deviceArguments, contextFrequency, contextRefresh, contextSynchronized, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0155 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void create(java.lang.String r6, int r7, int r8, boolean r9, boolean r10) throws org.lwjgl.LWJGLException {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.openal.AL.create(java.lang.String, int, int, boolean, boolean):void");
    }

    private static void init(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized, boolean openDevice) throws LWJGLException {
        try {
            AL10.initNativeStubs();
            ALC10.initNativeStubs();
            if (openDevice) {
                device = ALC10.alcOpenDevice(deviceArguments);
                if (device == null) {
                    throw new LWJGLException("Could not open ALC device");
                }
                if (contextFrequency == -1) {
                    context = ALC10.alcCreateContext(device, null);
                } else {
                    context = ALC10.alcCreateContext(device, ALCcontext.createAttributeList(contextFrequency, contextRefresh, contextSynchronized ? 1 : 0));
                }
                ALC10.alcMakeContextCurrent(context);
            }
            ALC11.initialize();
            if (ALC10.alcIsExtensionPresent(device, EFX10.ALC_EXT_EFX_NAME)) {
                EFX10.initNativeStubs();
            }
        } catch (LWJGLException e) {
            destroy();
            throw e;
        }
    }

    public static void create() throws LWJGLException {
        create(null, 44100, 60, false);
    }

    public static void destroy() {
        if (context != null) {
            ALC10.alcMakeContextCurrent(null);
            ALC10.alcDestroyContext(context);
            context = null;
        }
        if (device != null) {
            ALC10.alcCloseDevice(device);
            device = null;
        }
        resetNativeStubs(AL10.class);
        resetNativeStubs(AL11.class);
        resetNativeStubs(ALC10.class);
        resetNativeStubs(ALC11.class);
        resetNativeStubs(EFX10.class);
        if (created) {
            nDestroy();
        }
        created = false;
    }

    public static ALCcontext getContext() {
        return context;
    }

    public static ALCdevice getDevice() {
        return device;
    }
}
