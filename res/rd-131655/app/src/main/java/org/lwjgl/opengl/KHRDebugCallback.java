package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/KHRDebugCallback.class */
public final class KHRDebugCallback extends PointerWrapperAbstract {
    private static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    private static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    private static final int GL_DEBUG_SEVERITY_LOW = 37192;
    private static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    private static final int GL_DEBUG_SOURCE_API = 33350;
    private static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    private static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    private static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    private static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    private static final int GL_DEBUG_SOURCE_OTHER = 33355;
    private static final int GL_DEBUG_TYPE_ERROR = 33356;
    private static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    private static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    private static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    private static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    private static final int GL_DEBUG_TYPE_OTHER = 33361;
    private static final int GL_DEBUG_TYPE_MARKER = 33384;
    private static final long CALLBACK_POINTER;
    private final Handler handler;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/KHRDebugCallback$Handler.class */
    public interface Handler {
        void handleMessage(int i, int i2, int i3, int i4, String str);
    }

    static {
        long pointer = 0;
        try {
            pointer = ((Long) Class.forName("org.lwjgl.opengl.CallbackUtil").getDeclaredMethod("getDebugCallbackKHR", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
        }
        CALLBACK_POINTER = pointer;
    }

    public KHRDebugCallback() {
        this(new Handler() { // from class: org.lwjgl.opengl.KHRDebugCallback.1
            @Override // org.lwjgl.opengl.KHRDebugCallback.Handler
            public void handleMessage(int source, int type, int id, int severity, String message) {
                String description;
                String description2;
                String description3;
                System.err.println("[LWJGL] KHR_debug message");
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
                    case 33384:
                        description2 = "MARKER";
                        break;
                    default:
                        description2 = printUnknownToken(type);
                        break;
                }
                System.err.println("\tType: " + description2);
                switch (severity) {
                    case 33387:
                        description3 = "NOTIFICATION";
                        break;
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

    public KHRDebugCallback(Handler handler) {
        super(CALLBACK_POINTER);
        this.handler = handler;
    }

    Handler getHandler() {
        return this.handler;
    }
}
