package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBDebugOutputCallback.class */
public final class ARBDebugOutputCallback extends PointerWrapperAbstract {
    private static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
    private static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
    private static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;
    private static final int GL_DEBUG_SOURCE_API_ARB = 33350;
    private static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
    private static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
    private static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
    private static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
    private static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
    private static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
    private static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
    private static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
    private static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
    private static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
    private static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
    private static final long CALLBACK_POINTER;
    private final Handler handler;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ARBDebugOutputCallback$Handler.class */
    public interface Handler {
        void handleMessage(int i, int i2, int i3, int i4, String str);
    }

    static {
        long pointer = 0;
        try {
            pointer = ((Long) Class.forName("org.lwjgl.opengl.CallbackUtil").getDeclaredMethod("getDebugOutputCallbackARB", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
        }
        CALLBACK_POINTER = pointer;
    }

    public ARBDebugOutputCallback() {
        this(new Handler() { // from class: org.lwjgl.opengl.ARBDebugOutputCallback.1
            @Override // org.lwjgl.opengl.ARBDebugOutputCallback.Handler
            public void handleMessage(int source, int type, int id, int severity, String message) {
                String description;
                String description2;
                String description3;
                System.err.println("[LWJGL] ARB_debug_output message");
                System.err.println("\tID: " + id);
                switch (source) {
                    case 33350:
                        description = "API";
                        break;
                    case 33351:
                        description = "WINDOW SYSTEM";
                        break;
                    case 33352:
                        description = "SHADER COMPILER";
                        break;
                    case 33353:
                        description = "THIRD PARTY";
                        break;
                    case 33354:
                        description = "APPLICATION";
                        break;
                    case 33355:
                        description = "OTHER";
                        break;
                    default:
                        description = printUnknownToken(source);
                        break;
                }
                System.err.println("\tSource: " + description);
                switch (type) {
                    case 33356:
                        description2 = "ERROR";
                        break;
                    case 33357:
                        description2 = "DEPRECATED BEHAVIOR";
                        break;
                    case 33358:
                        description2 = "UNDEFINED BEHAVIOR";
                        break;
                    case 33359:
                        description2 = "PORTABILITY";
                        break;
                    case 33360:
                        description2 = "PERFORMANCE";
                        break;
                    case 33361:
                        description2 = "OTHER";
                        break;
                    default:
                        description2 = printUnknownToken(type);
                        break;
                }
                System.err.println("\tType: " + description2);
                switch (severity) {
                    case 37190:
                        description3 = "HIGH";
                        break;
                    case 37191:
                        description3 = "MEDIUM";
                        break;
                    case 37192:
                        description3 = "LOW";
                        break;
                    default:
                        description3 = printUnknownToken(severity);
                        break;
                }
                System.err.println("\tSeverity: " + description3);
                System.err.println("\tMessage: " + message);
            }

            private String printUnknownToken(int token) {
                return "Unknown (0x" + Integer.toHexString(token).toUpperCase() + ")";
            }
        });
    }

    public ARBDebugOutputCallback(Handler handler) {
        super(CALLBACK_POINTER);
        this.handler = handler;
    }

    Handler getHandler() {
        return this.handler;
    }
}
