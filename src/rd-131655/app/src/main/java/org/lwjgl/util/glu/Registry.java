package org.lwjgl.util.glu;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/Registry.class */
public class Registry extends Util {
    private static final String versionString = "1.3";
    private static final String extensionString = "GLU_EXT_nurbs_tessellator GLU_EXT_object_space_tess ";

    public static String gluGetString(int name) {
        if (name == 100800) {
            return versionString;
        }
        if (name == 100801) {
            return extensionString;
        }
        return null;
    }

    public static boolean gluCheckExtension(String extName, String extString) {
        return (extString == null || extName == null || extString.indexOf(extName) == -1) ? false : true;
    }
}
