package net.java.games.input;

import java.util.logging.Logger;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import org.lwjgl.opengl.LinuxKeycodes;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/LinuxNativeTypesMap.class */
class LinuxNativeTypesMap {
    private static LinuxNativeTypesMap INSTANCE = new LinuxNativeTypesMap();
    private static Logger log;
    static Class class$net$java$games$input$LinuxNativeTypesMap;
    private final Component.Identifier[] buttonIDs = new Component.Identifier[511];
    private final Component.Identifier[] relAxesIDs = new Component.Identifier[15];
    private final Component.Identifier[] absAxesIDs = new Component.Identifier[63];

    static {
        Class clsClass$;
        if (class$net$java$games$input$LinuxNativeTypesMap == null) {
            clsClass$ = class$("net.java.games.input.LinuxNativeTypesMap");
            class$net$java$games$input$LinuxNativeTypesMap = clsClass$;
        } else {
            clsClass$ = class$net$java$games$input$LinuxNativeTypesMap;
        }
        log = Logger.getLogger(clsClass$.getName());
    }

    static Class class$(String x0) throws Throwable {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    private LinuxNativeTypesMap() {
        reInit();
    }

    private void reInit() {
        this.buttonIDs[1] = Component.Identifier.Key.ESCAPE;
        this.buttonIDs[2] = Component.Identifier.Key._1;
        this.buttonIDs[3] = Component.Identifier.Key._2;
        this.buttonIDs[4] = Component.Identifier.Key._3;
        this.buttonIDs[5] = Component.Identifier.Key._4;
        this.buttonIDs[6] = Component.Identifier.Key._5;
        this.buttonIDs[7] = Component.Identifier.Key._6;
        this.buttonIDs[8] = Component.Identifier.Key._7;
        this.buttonIDs[9] = Component.Identifier.Key._8;
        this.buttonIDs[10] = Component.Identifier.Key._9;
        this.buttonIDs[11] = Component.Identifier.Key._0;
        this.buttonIDs[12] = Component.Identifier.Key.MINUS;
        this.buttonIDs[13] = Component.Identifier.Key.EQUALS;
        this.buttonIDs[14] = Component.Identifier.Key.BACK;
        this.buttonIDs[15] = Component.Identifier.Key.TAB;
        this.buttonIDs[16] = Component.Identifier.Key.Q;
        this.buttonIDs[17] = Component.Identifier.Key.W;
        this.buttonIDs[18] = Component.Identifier.Key.E;
        this.buttonIDs[19] = Component.Identifier.Key.R;
        this.buttonIDs[20] = Component.Identifier.Key.T;
        this.buttonIDs[21] = Component.Identifier.Key.Y;
        this.buttonIDs[22] = Component.Identifier.Key.U;
        this.buttonIDs[23] = Component.Identifier.Key.I;
        this.buttonIDs[24] = Component.Identifier.Key.O;
        this.buttonIDs[25] = Component.Identifier.Key.P;
        this.buttonIDs[26] = Component.Identifier.Key.LBRACKET;
        this.buttonIDs[27] = Component.Identifier.Key.RBRACKET;
        this.buttonIDs[28] = Component.Identifier.Key.RETURN;
        this.buttonIDs[29] = Component.Identifier.Key.LCONTROL;
        this.buttonIDs[30] = Component.Identifier.Key.A;
        this.buttonIDs[31] = Component.Identifier.Key.S;
        this.buttonIDs[32] = Component.Identifier.Key.D;
        this.buttonIDs[33] = Component.Identifier.Key.F;
        this.buttonIDs[34] = Component.Identifier.Key.G;
        this.buttonIDs[35] = Component.Identifier.Key.H;
        this.buttonIDs[36] = Component.Identifier.Key.J;
        this.buttonIDs[37] = Component.Identifier.Key.K;
        this.buttonIDs[38] = Component.Identifier.Key.L;
        this.buttonIDs[39] = Component.Identifier.Key.SEMICOLON;
        this.buttonIDs[40] = Component.Identifier.Key.APOSTROPHE;
        this.buttonIDs[41] = Component.Identifier.Key.GRAVE;
        this.buttonIDs[42] = Component.Identifier.Key.LSHIFT;
        this.buttonIDs[43] = Component.Identifier.Key.BACKSLASH;
        this.buttonIDs[44] = Component.Identifier.Key.Z;
        this.buttonIDs[45] = Component.Identifier.Key.X;
        this.buttonIDs[46] = Component.Identifier.Key.C;
        this.buttonIDs[47] = Component.Identifier.Key.V;
        this.buttonIDs[48] = Component.Identifier.Key.B;
        this.buttonIDs[49] = Component.Identifier.Key.N;
        this.buttonIDs[50] = Component.Identifier.Key.M;
        this.buttonIDs[51] = Component.Identifier.Key.COMMA;
        this.buttonIDs[52] = Component.Identifier.Key.PERIOD;
        this.buttonIDs[53] = Component.Identifier.Key.SLASH;
        this.buttonIDs[54] = Component.Identifier.Key.RSHIFT;
        this.buttonIDs[55] = Component.Identifier.Key.MULTIPLY;
        this.buttonIDs[56] = Component.Identifier.Key.LALT;
        this.buttonIDs[57] = Component.Identifier.Key.SPACE;
        this.buttonIDs[58] = Component.Identifier.Key.CAPITAL;
        this.buttonIDs[59] = Component.Identifier.Key.F1;
        this.buttonIDs[60] = Component.Identifier.Key.F2;
        this.buttonIDs[61] = Component.Identifier.Key.F3;
        this.buttonIDs[62] = Component.Identifier.Key.F4;
        this.buttonIDs[63] = Component.Identifier.Key.F5;
        this.buttonIDs[64] = Component.Identifier.Key.F6;
        this.buttonIDs[65] = Component.Identifier.Key.F7;
        this.buttonIDs[66] = Component.Identifier.Key.F8;
        this.buttonIDs[67] = Component.Identifier.Key.F9;
        this.buttonIDs[68] = Component.Identifier.Key.F10;
        this.buttonIDs[69] = Component.Identifier.Key.NUMLOCK;
        this.buttonIDs[70] = Component.Identifier.Key.SCROLL;
        this.buttonIDs[71] = Component.Identifier.Key.NUMPAD7;
        this.buttonIDs[72] = Component.Identifier.Key.NUMPAD8;
        this.buttonIDs[73] = Component.Identifier.Key.NUMPAD9;
        this.buttonIDs[74] = Component.Identifier.Key.SUBTRACT;
        this.buttonIDs[75] = Component.Identifier.Key.NUMPAD4;
        this.buttonIDs[76] = Component.Identifier.Key.NUMPAD5;
        this.buttonIDs[77] = Component.Identifier.Key.NUMPAD6;
        this.buttonIDs[78] = Component.Identifier.Key.ADD;
        this.buttonIDs[79] = Component.Identifier.Key.NUMPAD1;
        this.buttonIDs[80] = Component.Identifier.Key.NUMPAD2;
        this.buttonIDs[81] = Component.Identifier.Key.NUMPAD3;
        this.buttonIDs[82] = Component.Identifier.Key.NUMPAD0;
        this.buttonIDs[83] = Component.Identifier.Key.DECIMAL;
        this.buttonIDs[183] = Component.Identifier.Key.F13;
        this.buttonIDs[86] = null;
        this.buttonIDs[87] = Component.Identifier.Key.F11;
        this.buttonIDs[88] = Component.Identifier.Key.F12;
        this.buttonIDs[184] = Component.Identifier.Key.F14;
        this.buttonIDs[185] = Component.Identifier.Key.F15;
        this.buttonIDs[186] = null;
        this.buttonIDs[187] = null;
        this.buttonIDs[188] = null;
        this.buttonIDs[189] = null;
        this.buttonIDs[190] = null;
        this.buttonIDs[96] = Component.Identifier.Key.NUMPADENTER;
        this.buttonIDs[97] = Component.Identifier.Key.RCONTROL;
        this.buttonIDs[98] = Component.Identifier.Key.DIVIDE;
        this.buttonIDs[99] = Component.Identifier.Key.SYSRQ;
        this.buttonIDs[100] = Component.Identifier.Key.RALT;
        this.buttonIDs[101] = null;
        this.buttonIDs[102] = Component.Identifier.Key.HOME;
        this.buttonIDs[103] = Component.Identifier.Key.UP;
        this.buttonIDs[104] = Component.Identifier.Key.PAGEUP;
        this.buttonIDs[105] = Component.Identifier.Key.LEFT;
        this.buttonIDs[106] = Component.Identifier.Key.RIGHT;
        this.buttonIDs[107] = Component.Identifier.Key.END;
        this.buttonIDs[108] = Component.Identifier.Key.DOWN;
        this.buttonIDs[109] = Component.Identifier.Key.PAGEDOWN;
        this.buttonIDs[110] = Component.Identifier.Key.INSERT;
        this.buttonIDs[111] = Component.Identifier.Key.DELETE;
        this.buttonIDs[119] = Component.Identifier.Key.PAUSE;
        this.buttonIDs[117] = Component.Identifier.Key.NUMPADEQUAL;
        this.buttonIDs[142] = Component.Identifier.Key.SLEEP;
        this.buttonIDs[240] = Component.Identifier.Key.UNLABELED;
        this.buttonIDs[256] = Component.Identifier.Button._0;
        this.buttonIDs[257] = Component.Identifier.Button._1;
        this.buttonIDs[258] = Component.Identifier.Button._2;
        this.buttonIDs[259] = Component.Identifier.Button._3;
        this.buttonIDs[260] = Component.Identifier.Button._4;
        this.buttonIDs[261] = Component.Identifier.Button._5;
        this.buttonIDs[262] = Component.Identifier.Button._6;
        this.buttonIDs[263] = Component.Identifier.Button._7;
        this.buttonIDs[264] = Component.Identifier.Button._8;
        this.buttonIDs[265] = Component.Identifier.Button._9;
        this.buttonIDs[272] = Component.Identifier.Button.LEFT;
        this.buttonIDs[273] = Component.Identifier.Button.RIGHT;
        this.buttonIDs[274] = Component.Identifier.Button.MIDDLE;
        this.buttonIDs[275] = Component.Identifier.Button.SIDE;
        this.buttonIDs[276] = Component.Identifier.Button.EXTRA;
        this.buttonIDs[277] = Component.Identifier.Button.FORWARD;
        this.buttonIDs[278] = Component.Identifier.Button.BACK;
        this.buttonIDs[288] = Component.Identifier.Button.TRIGGER;
        this.buttonIDs[289] = Component.Identifier.Button.THUMB;
        this.buttonIDs[290] = Component.Identifier.Button.THUMB2;
        this.buttonIDs[291] = Component.Identifier.Button.TOP;
        this.buttonIDs[292] = Component.Identifier.Button.TOP2;
        this.buttonIDs[293] = Component.Identifier.Button.PINKIE;
        this.buttonIDs[294] = Component.Identifier.Button.BASE;
        this.buttonIDs[295] = Component.Identifier.Button.BASE2;
        this.buttonIDs[296] = Component.Identifier.Button.BASE3;
        this.buttonIDs[297] = Component.Identifier.Button.BASE4;
        this.buttonIDs[298] = Component.Identifier.Button.BASE5;
        this.buttonIDs[299] = Component.Identifier.Button.BASE6;
        this.buttonIDs[303] = Component.Identifier.Button.DEAD;
        this.buttonIDs[304] = Component.Identifier.Button.A;
        this.buttonIDs[305] = Component.Identifier.Button.B;
        this.buttonIDs[306] = Component.Identifier.Button.C;
        this.buttonIDs[307] = Component.Identifier.Button.X;
        this.buttonIDs[308] = Component.Identifier.Button.Y;
        this.buttonIDs[309] = Component.Identifier.Button.Z;
        this.buttonIDs[310] = Component.Identifier.Button.LEFT_THUMB;
        this.buttonIDs[311] = Component.Identifier.Button.RIGHT_THUMB;
        this.buttonIDs[312] = Component.Identifier.Button.LEFT_THUMB2;
        this.buttonIDs[313] = Component.Identifier.Button.RIGHT_THUMB2;
        this.buttonIDs[314] = Component.Identifier.Button.SELECT;
        this.buttonIDs[316] = Component.Identifier.Button.MODE;
        this.buttonIDs[317] = Component.Identifier.Button.LEFT_THUMB3;
        this.buttonIDs[318] = Component.Identifier.Button.RIGHT_THUMB3;
        this.buttonIDs[320] = Component.Identifier.Button.TOOL_PEN;
        this.buttonIDs[321] = Component.Identifier.Button.TOOL_RUBBER;
        this.buttonIDs[322] = Component.Identifier.Button.TOOL_BRUSH;
        this.buttonIDs[323] = Component.Identifier.Button.TOOL_PENCIL;
        this.buttonIDs[324] = Component.Identifier.Button.TOOL_AIRBRUSH;
        this.buttonIDs[325] = Component.Identifier.Button.TOOL_FINGER;
        this.buttonIDs[326] = Component.Identifier.Button.TOOL_MOUSE;
        this.buttonIDs[327] = Component.Identifier.Button.TOOL_LENS;
        this.buttonIDs[330] = Component.Identifier.Button.TOUCH;
        this.buttonIDs[331] = Component.Identifier.Button.STYLUS;
        this.buttonIDs[332] = Component.Identifier.Button.STYLUS2;
        this.relAxesIDs[0] = Component.Identifier.Axis.X;
        this.relAxesIDs[1] = Component.Identifier.Axis.Y;
        this.relAxesIDs[2] = Component.Identifier.Axis.Z;
        this.relAxesIDs[8] = Component.Identifier.Axis.Z;
        this.relAxesIDs[6] = Component.Identifier.Axis.SLIDER;
        this.relAxesIDs[7] = Component.Identifier.Axis.SLIDER;
        this.relAxesIDs[9] = Component.Identifier.Axis.SLIDER;
        this.absAxesIDs[0] = Component.Identifier.Axis.X;
        this.absAxesIDs[1] = Component.Identifier.Axis.Y;
        this.absAxesIDs[2] = Component.Identifier.Axis.Z;
        this.absAxesIDs[3] = Component.Identifier.Axis.RX;
        this.absAxesIDs[4] = Component.Identifier.Axis.RY;
        this.absAxesIDs[5] = Component.Identifier.Axis.RZ;
        this.absAxesIDs[6] = Component.Identifier.Axis.SLIDER;
        this.absAxesIDs[7] = Component.Identifier.Axis.RZ;
        this.absAxesIDs[8] = Component.Identifier.Axis.Y;
        this.absAxesIDs[9] = Component.Identifier.Axis.SLIDER;
        this.absAxesIDs[10] = Component.Identifier.Axis.SLIDER;
        this.absAxesIDs[16] = Component.Identifier.Axis.POV;
        this.absAxesIDs[17] = Component.Identifier.Axis.POV;
        this.absAxesIDs[18] = Component.Identifier.Axis.POV;
        this.absAxesIDs[19] = Component.Identifier.Axis.POV;
        this.absAxesIDs[20] = Component.Identifier.Axis.POV;
        this.absAxesIDs[21] = Component.Identifier.Axis.POV;
        this.absAxesIDs[22] = Component.Identifier.Axis.POV;
        this.absAxesIDs[23] = Component.Identifier.Axis.POV;
        this.absAxesIDs[24] = null;
        this.absAxesIDs[25] = null;
        this.absAxesIDs[26] = null;
        this.absAxesIDs[27] = null;
        this.absAxesIDs[40] = null;
    }

    public static final Controller.Type guessButtonTrait(int button_code) {
        switch (button_code) {
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
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case NativeDefinitions.KEY_FIND /* 136 */:
            case NativeDefinitions.KEY_CUT /* 137 */:
            case NativeDefinitions.KEY_HELP /* 138 */:
            case NativeDefinitions.KEY_MENU /* 139 */:
            case NativeDefinitions.KEY_CALC /* 140 */:
            case 141:
            case NativeDefinitions.KEY_SLEEP /* 142 */:
            case NativeDefinitions.KEY_WAKEUP /* 143 */:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case NativeDefinitions.KEY_COFFEE /* 152 */:
            case 153:
            case NativeDefinitions.KEY_CYCLEWINDOWS /* 154 */:
            case NativeDefinitions.KEY_MAIL /* 155 */:
            case 156:
            case 157:
            case NativeDefinitions.KEY_BACK /* 158 */:
            case NativeDefinitions.KEY_FORWARD /* 159 */:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 200:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 227:
            case 228:
            case 229:
            case 230:
            case NativeDefinitions.KEY_OK /* 352 */:
            case NativeDefinitions.KEY_SELECT /* 353 */:
            case NativeDefinitions.KEY_GOTO /* 354 */:
            case NativeDefinitions.KEY_CLEAR /* 355 */:
            case NativeDefinitions.KEY_POWER2 /* 356 */:
            case NativeDefinitions.KEY_OPTION /* 357 */:
            case NativeDefinitions.KEY_INFO /* 358 */:
            case NativeDefinitions.KEY_TIME /* 359 */:
            case NativeDefinitions.KEY_VENDOR /* 360 */:
            case NativeDefinitions.KEY_ARCHIVE /* 361 */:
            case NativeDefinitions.KEY_PROGRAM /* 362 */:
            case NativeDefinitions.KEY_CHANNEL /* 363 */:
            case NativeDefinitions.KEY_FAVORITES /* 364 */:
            case NativeDefinitions.KEY_EPG /* 365 */:
            case NativeDefinitions.KEY_PVR /* 366 */:
            case NativeDefinitions.KEY_MHP /* 367 */:
            case NativeDefinitions.KEY_LANGUAGE /* 368 */:
            case NativeDefinitions.KEY_TITLE /* 369 */:
            case NativeDefinitions.KEY_SUBTITLE /* 370 */:
            case NativeDefinitions.KEY_ANGLE /* 371 */:
            case NativeDefinitions.KEY_ZOOM /* 372 */:
            case NativeDefinitions.KEY_MODE /* 373 */:
            case NativeDefinitions.KEY_KEYBOARD /* 374 */:
            case NativeDefinitions.KEY_SCREEN /* 375 */:
            case NativeDefinitions.KEY_PC /* 376 */:
            case NativeDefinitions.KEY_TV /* 377 */:
            case NativeDefinitions.KEY_TV2 /* 378 */:
            case NativeDefinitions.KEY_VCR /* 379 */:
            case NativeDefinitions.KEY_VCR2 /* 380 */:
            case NativeDefinitions.KEY_SAT /* 381 */:
            case NativeDefinitions.KEY_SAT2 /* 382 */:
            case NativeDefinitions.KEY_CD /* 383 */:
            case NativeDefinitions.KEY_TAPE /* 384 */:
            case NativeDefinitions.KEY_RADIO /* 385 */:
            case NativeDefinitions.KEY_TUNER /* 386 */:
            case NativeDefinitions.KEY_PLAYER /* 387 */:
            case NativeDefinitions.KEY_TEXT /* 388 */:
            case NativeDefinitions.KEY_DVD /* 389 */:
            case NativeDefinitions.KEY_AUX /* 390 */:
            case NativeDefinitions.KEY_MP3 /* 391 */:
            case NativeDefinitions.KEY_AUDIO /* 392 */:
            case NativeDefinitions.KEY_VIDEO /* 393 */:
            case NativeDefinitions.KEY_DIRECTORY /* 394 */:
            case NativeDefinitions.KEY_LIST /* 395 */:
            case NativeDefinitions.KEY_MEMO /* 396 */:
            case NativeDefinitions.KEY_CALENDAR /* 397 */:
            case NativeDefinitions.KEY_RED /* 398 */:
            case NativeDefinitions.KEY_GREEN /* 399 */:
            case NativeDefinitions.KEY_YELLOW /* 400 */:
            case NativeDefinitions.KEY_BLUE /* 401 */:
            case NativeDefinitions.KEY_CHANNELUP /* 402 */:
            case NativeDefinitions.KEY_CHANNELDOWN /* 403 */:
            case NativeDefinitions.KEY_FIRST /* 404 */:
            case NativeDefinitions.KEY_LAST /* 405 */:
            case NativeDefinitions.KEY_AB /* 406 */:
            case NativeDefinitions.KEY_NEXT /* 407 */:
            case NativeDefinitions.KEY_RESTART /* 408 */:
            case NativeDefinitions.KEY_SLOW /* 409 */:
            case NativeDefinitions.KEY_SHUFFLE /* 410 */:
            case NativeDefinitions.KEY_BREAK /* 411 */:
            case NativeDefinitions.KEY_PREVIOUS /* 412 */:
            case NativeDefinitions.KEY_DIGITS /* 413 */:
            case NativeDefinitions.KEY_TEEN /* 414 */:
            case NativeDefinitions.KEY_TWEN /* 415 */:
            case NativeDefinitions.KEY_DEL_EOL /* 448 */:
            case NativeDefinitions.KEY_DEL_EOS /* 449 */:
            case NativeDefinitions.KEY_INS_LINE /* 450 */:
            case NativeDefinitions.KEY_DEL_LINE /* 451 */:
            case NativeDefinitions.KEY_FN /* 464 */:
            case NativeDefinitions.KEY_FN_ESC /* 465 */:
            case NativeDefinitions.KEY_FN_F1 /* 466 */:
            case NativeDefinitions.KEY_FN_F2 /* 467 */:
            case NativeDefinitions.KEY_FN_F3 /* 468 */:
            case NativeDefinitions.KEY_FN_F4 /* 469 */:
            case NativeDefinitions.KEY_FN_F5 /* 470 */:
            case NativeDefinitions.KEY_FN_F6 /* 471 */:
            case NativeDefinitions.KEY_FN_F7 /* 472 */:
            case NativeDefinitions.KEY_FN_F8 /* 473 */:
            case NativeDefinitions.KEY_FN_F9 /* 474 */:
            case NativeDefinitions.KEY_FN_F10 /* 475 */:
            case NativeDefinitions.KEY_FN_F11 /* 476 */:
            case NativeDefinitions.KEY_FN_F12 /* 477 */:
            case NativeDefinitions.KEY_FN_1 /* 478 */:
            case NativeDefinitions.KEY_FN_2 /* 479 */:
            case NativeDefinitions.KEY_FN_D /* 480 */:
            case NativeDefinitions.KEY_FN_E /* 481 */:
            case NativeDefinitions.KEY_FN_F /* 482 */:
            case NativeDefinitions.KEY_FN_S /* 483 */:
            case NativeDefinitions.KEY_FN_B /* 484 */:
                return Controller.Type.KEYBOARD;
            case 84:
            case 120:
            case 181:
            case 182:
            case LinuxKeycodes.XK_Atilde /* 195 */:
            case 196:
            case 197:
            case LinuxKeycodes.XK_AE /* 198 */:
            case 199:
            case LinuxKeycodes.XK_Igrave /* 204 */:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
            case 266:
            case 267:
            case 268:
            case 269:
            case 270:
            case 271:
            case NativeDefinitions.BTN_FORWARD /* 277 */:
            case NativeDefinitions.BTN_BACK /* 278 */:
            case NativeDefinitions.BTN_TASK /* 279 */:
            case 280:
            case 281:
            case 282:
            case 283:
            case 284:
            case 285:
            case 286:
            case 287:
            case 300:
            case 301:
            case 302:
            case NativeDefinitions.BTN_START /* 315 */:
            case 319:
            case 320:
            case NativeDefinitions.BTN_TOOL_RUBBER /* 321 */:
            case NativeDefinitions.BTN_TOOL_BRUSH /* 322 */:
            case NativeDefinitions.BTN_TOOL_PENCIL /* 323 */:
            case NativeDefinitions.BTN_TOOL_AIRBRUSH /* 324 */:
            case NativeDefinitions.BTN_TOOL_FINGER /* 325 */:
            case NativeDefinitions.BTN_TOOL_MOUSE /* 326 */:
            case NativeDefinitions.BTN_TOOL_LENS /* 327 */:
            case 328:
            case 329:
            case NativeDefinitions.BTN_TOUCH /* 330 */:
            case NativeDefinitions.BTN_STYLUS /* 331 */:
            case NativeDefinitions.BTN_STYLUS2 /* 332 */:
            case NativeDefinitions.BTN_TOOL_DOUBLETAP /* 333 */:
            case NativeDefinitions.BTN_TOOL_TRIPLETAP /* 334 */:
            case 335:
            case 336:
            case NativeDefinitions.BTN_GEAR_UP /* 337 */:
            case 338:
            case 339:
            case 340:
            case 341:
            case 342:
            case 343:
            case 344:
            case 345:
            case 346:
            case 347:
            case 348:
            case 349:
            case 350:
            case 351:
            case 416:
            case 417:
            case 418:
            case 419:
            case 420:
            case 421:
            case 422:
            case 423:
            case 424:
            case 425:
            case 426:
            case 427:
            case 428:
            case 429:
            case 430:
            case 431:
            case 432:
            case 433:
            case 434:
            case 435:
            case 436:
            case 437:
            case 438:
            case 439:
            case 440:
            case 441:
            case 442:
            case 443:
            case 444:
            case 445:
            case 446:
            case 447:
            case 452:
            case 453:
            case 454:
            case 455:
            case 456:
            case 457:
            case 458:
            case 459:
            case 460:
            case 461:
            case 462:
            case 463:
            default:
                return Controller.Type.UNKNOWN;
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
            case 261:
            case NativeDefinitions.BTN_6 /* 262 */:
            case NativeDefinitions.BTN_7 /* 263 */:
            case NativeDefinitions.BTN_8 /* 264 */:
            case NativeDefinitions.BTN_9 /* 265 */:
                return Controller.Type.UNKNOWN;
            case 272:
            case NativeDefinitions.BTN_RIGHT /* 273 */:
            case NativeDefinitions.BTN_MIDDLE /* 274 */:
            case NativeDefinitions.BTN_SIDE /* 275 */:
            case NativeDefinitions.BTN_EXTRA /* 276 */:
                return Controller.Type.MOUSE;
            case 288:
            case NativeDefinitions.BTN_THUMB /* 289 */:
            case NativeDefinitions.BTN_THUMB2 /* 290 */:
            case NativeDefinitions.BTN_TOP /* 291 */:
            case NativeDefinitions.BTN_TOP2 /* 292 */:
            case NativeDefinitions.BTN_PINKIE /* 293 */:
            case NativeDefinitions.BTN_BASE /* 294 */:
            case NativeDefinitions.BTN_BASE2 /* 295 */:
            case NativeDefinitions.BTN_BASE3 /* 296 */:
            case NativeDefinitions.BTN_BASE4 /* 297 */:
            case NativeDefinitions.BTN_BASE5 /* 298 */:
            case NativeDefinitions.BTN_BASE6 /* 299 */:
            case NativeDefinitions.BTN_DEAD /* 303 */:
                return Controller.Type.STICK;
            case 304:
            case NativeDefinitions.BTN_B /* 305 */:
            case NativeDefinitions.BTN_C /* 306 */:
            case NativeDefinitions.BTN_X /* 307 */:
            case NativeDefinitions.BTN_Y /* 308 */:
            case NativeDefinitions.BTN_Z /* 309 */:
            case NativeDefinitions.BTN_TL /* 310 */:
            case NativeDefinitions.BTN_TR /* 311 */:
            case NativeDefinitions.BTN_TL2 /* 312 */:
            case NativeDefinitions.BTN_TR2 /* 313 */:
            case NativeDefinitions.BTN_SELECT /* 314 */:
            case NativeDefinitions.BTN_MODE /* 316 */:
            case NativeDefinitions.BTN_THUMBL /* 317 */:
            case NativeDefinitions.BTN_THUMBR /* 318 */:
                return Controller.Type.GAMEPAD;
        }
    }

    public static Controller.PortType getPortType(int nativeid) {
        switch (nativeid) {
            case 3:
                return Controller.PortType.USB;
            case 17:
                return Controller.PortType.I8042;
            case 19:
                return Controller.PortType.SERIAL;
            case 20:
                return Controller.PortType.GAME;
            case 21:
                return Controller.PortType.PARALLEL;
            default:
                return Controller.PortType.UNKNOWN;
        }
    }

    public static Component.Identifier getRelAxisID(int nativeID) {
        Component.Identifier retval = null;
        try {
            retval = INSTANCE.relAxesIDs[nativeID];
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warning(new StringBuffer().append("INSTANCE.relAxesIDis only ").append(INSTANCE.relAxesIDs.length).append(" long, so ").append(nativeID).append(" not contained").toString());
        }
        if (retval == null) {
            retval = Component.Identifier.Axis.SLIDER_VELOCITY;
        }
        return retval;
    }

    public static Component.Identifier getAbsAxisID(int nativeID) {
        Component.Identifier retval = null;
        try {
            retval = INSTANCE.absAxesIDs[nativeID];
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warning(new StringBuffer().append("INSTANCE.absAxesIDs is only ").append(INSTANCE.absAxesIDs.length).append(" long, so ").append(nativeID).append(" not contained").toString());
        }
        if (retval == null) {
            retval = Component.Identifier.Axis.SLIDER;
        }
        return retval;
    }

    public static Component.Identifier getButtonID(int nativeID) {
        Component.Identifier retval = null;
        try {
            retval = INSTANCE.buttonIDs[nativeID];
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warning(new StringBuffer().append("INSTANCE.buttonIDs is only ").append(INSTANCE.buttonIDs.length).append(" long, so ").append(nativeID).append(" not contained").toString());
        }
        if (retval == null) {
            retval = Component.Identifier.Key.UNKNOWN;
        }
        return retval;
    }
}
