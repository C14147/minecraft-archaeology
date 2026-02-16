package org.lwjgl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.DisplayMode;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/Display.class */
public final class Display {
    private static final boolean DEBUG = false;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Display.class.desiredAssertionStatus();
    }

    public static DisplayMode[] getAvailableDisplayModes(int minWidth, int minHeight, int maxWidth, int maxHeight, int minBPP, int maxBPP, int minFreq, int maxFreq) throws LWJGLException {
        DisplayMode[] modes = org.lwjgl.opengl.Display.getAvailableDisplayModes();
        if (LWJGLUtil.DEBUG) {
            System.out.println("Available screen modes:");
            for (DisplayMode mode : modes) {
                System.out.println(mode);
            }
        }
        ArrayList<DisplayMode> matches = new ArrayList<>(modes.length);
        for (int i = 0; i < modes.length; i++) {
            if (!$assertionsDisabled && modes[i] == null) {
                throw new AssertionError("" + i + " " + modes.length);
            }
            if ((minWidth == -1 || modes[i].getWidth() >= minWidth) && ((maxWidth == -1 || modes[i].getWidth() <= maxWidth) && ((minHeight == -1 || modes[i].getHeight() >= minHeight) && ((maxHeight == -1 || modes[i].getHeight() <= maxHeight) && ((minBPP == -1 || modes[i].getBitsPerPixel() >= minBPP) && ((maxBPP == -1 || modes[i].getBitsPerPixel() <= maxBPP) && (modes[i].getFrequency() == 0 || ((minFreq == -1 || modes[i].getFrequency() >= minFreq) && (maxFreq == -1 || modes[i].getFrequency() <= maxFreq))))))))) {
                matches.add(modes[i]);
            }
        }
        DisplayMode[] ret = new DisplayMode[matches.size()];
        matches.toArray(ret);
        if (LWJGLUtil.DEBUG) {
        }
        return ret;
    }

    /* JADX INFO: renamed from: org.lwjgl.util.Display$1FieldAccessor, reason: invalid class name */
    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/Display$1FieldAccessor.class */
    class C1FieldAccessor {
        final String fieldName;
        final int order;
        final int preferred;
        final boolean usePreferred;

        C1FieldAccessor(String fieldName, int order, int preferred, boolean usePreferred) {
            this.fieldName = fieldName;
            this.order = order;
            this.preferred = preferred;
            this.usePreferred = usePreferred;
        }

        int getInt(DisplayMode mode) {
            if ("width".equals(this.fieldName)) {
                return mode.getWidth();
            }
            if ("height".equals(this.fieldName)) {
                return mode.getHeight();
            }
            if ("freq".equals(this.fieldName)) {
                return mode.getFrequency();
            }
            if ("bpp".equals(this.fieldName)) {
                return mode.getBitsPerPixel();
            }
            throw new IllegalArgumentException("Unknown field " + this.fieldName);
        }
    }

    public static DisplayMode setDisplayMode(DisplayMode[] dm, final String[] param) throws Exception {
        Arrays.sort(dm, new Comparator<DisplayMode>() { // from class: org.lwjgl.util.Display.1Sorter
            final C1FieldAccessor[] accessors;

            {
                this.accessors = new C1FieldAccessor[param.length];
                for (int i = 0; i < this.accessors.length; i++) {
                    int idx = param[i].indexOf(61);
                    if (idx > 0) {
                        this.accessors[i] = new C1FieldAccessor(param[i].substring(0, idx), 0, Integer.parseInt(param[i].substring(idx + 1, param[i].length())), true);
                    } else if (param[i].charAt(0) == '-') {
                        this.accessors[i] = new C1FieldAccessor(param[i].substring(1), -1, 0, false);
                    } else {
                        this.accessors[i] = new C1FieldAccessor(param[i], 1, 0, false);
                    }
                }
            }

            @Override // java.util.Comparator
            public int compare(DisplayMode dm1, DisplayMode dm2) {
                C1FieldAccessor[] arr$ = this.accessors;
                for (C1FieldAccessor accessor : arr$) {
                    int f1 = accessor.getInt(dm1);
                    int f2 = accessor.getInt(dm2);
                    if (accessor.usePreferred && f1 != f2) {
                        if (f1 == accessor.preferred) {
                            return -1;
                        }
                        if (f2 == accessor.preferred) {
                            return 1;
                        }
                        int absf1 = Math.abs(f1 - accessor.preferred);
                        int absf2 = Math.abs(f2 - accessor.preferred);
                        if (absf1 < absf2) {
                            return -1;
                        }
                        if (absf1 > absf2) {
                            return 1;
                        }
                    } else {
                        if (f1 < f2) {
                            return accessor.order;
                        }
                        if (f1 != f2) {
                            return -accessor.order;
                        }
                    }
                }
                return 0;
            }
        });
        if (LWJGLUtil.DEBUG) {
            System.out.println("Sorted display modes:");
            for (DisplayMode displayMode : dm) {
                System.out.println(displayMode);
            }
        }
        for (DisplayMode aDm : dm) {
            try {
                if (LWJGLUtil.DEBUG) {
                    System.out.println("Attempting to set displaymode: " + aDm);
                }
                org.lwjgl.opengl.Display.setDisplayMode(aDm);
                return aDm;
            } catch (Exception e) {
                if (LWJGLUtil.DEBUG) {
                    System.out.println("Failed to set display mode to " + aDm);
                    e.printStackTrace();
                }
            }
        }
        throw new Exception("Failed to set display mode.");
    }
}
