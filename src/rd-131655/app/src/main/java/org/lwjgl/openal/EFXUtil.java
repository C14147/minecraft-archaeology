package org.lwjgl.openal;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/openal/EFXUtil.class */
public final class EFXUtil {
    private static final int EFFECT = 1111;
    private static final int FILTER = 2222;

    private EFXUtil() {
    }

    public static boolean isEfxSupported() {
        if (!AL.isCreated()) {
            throw new OpenALException("OpenAL has not been created.");
        }
        return ALC10.alcIsExtensionPresent(AL.getDevice(), EFX10.ALC_EXT_EFX_NAME);
    }

    public static boolean isEffectSupported(int effectType) {
        switch (effectType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 32768:
                return testSupportGeneric(EFFECT, effectType);
            default:
                throw new IllegalArgumentException("Unknown or invalid effect type: " + effectType);
        }
    }

    public static boolean isFilterSupported(int filterType) {
        switch (filterType) {
            case 0:
            case 1:
            case 2:
            case 3:
                return testSupportGeneric(FILTER, filterType);
            default:
                throw new IllegalArgumentException("Unknown or invalid filter type: " + filterType);
        }
    }

    private static boolean testSupportGeneric(int objectType, int typeValue) {
        int genError;
        int setError;
        switch (objectType) {
            case EFFECT /* 1111 */:
            case FILTER /* 2222 */:
                boolean supported = false;
                if (isEfxSupported()) {
                    AL10.alGetError();
                    int testObject = 0;
                    try {
                        switch (objectType) {
                            case EFFECT /* 1111 */:
                                testObject = EFX10.alGenEffects();
                                break;
                            case FILTER /* 2222 */:
                                testObject = EFX10.alGenFilters();
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid objectType: " + objectType);
                        }
                        genError = AL10.alGetError();
                    } catch (OpenALException debugBuildException) {
                        if (debugBuildException.getMessage().contains("AL_OUT_OF_MEMORY")) {
                            genError = 40965;
                        } else {
                            genError = 40964;
                        }
                    }
                    if (genError == 0) {
                        AL10.alGetError();
                        try {
                            switch (objectType) {
                                case EFFECT /* 1111 */:
                                    EFX10.alEffecti(testObject, 32769, typeValue);
                                    break;
                                case FILTER /* 2222 */:
                                    EFX10.alFilteri(testObject, 32769, typeValue);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid objectType: " + objectType);
                            }
                            setError = AL10.alGetError();
                        } catch (OpenALException e) {
                            setError = 40963;
                        }
                        if (setError == 0) {
                            supported = true;
                        }
                        try {
                            switch (objectType) {
                                case EFFECT /* 1111 */:
                                    EFX10.alDeleteEffects(testObject);
                                    break;
                                case FILTER /* 2222 */:
                                    EFX10.alDeleteFilters(testObject);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid objectType: " + objectType);
                            }
                        } catch (OpenALException e2) {
                        }
                    } else if (genError == 40965) {
                        throw new OpenALException(genError);
                    }
                }
                return supported;
            default:
                throw new IllegalArgumentException("Invalid objectType: " + objectType);
        }
    }
}
