package net.java.games.input;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:net/java/games/input/Version.class */
public final class Version {
    private static final String apiVersion = "2.0.5";
    private static final String buildNumber = "1088";
    private static final String antBuildNumberToken = "@BUILD_NUMBER@";
    private static final String antAPIVersionToken = "@API_VERSION@";

    private Version() {
    }

    public static String getVersion() {
        String version = "Unversioned";
        if (!antAPIVersionToken.equals(apiVersion)) {
            version = apiVersion;
        }
        if (!antBuildNumberToken.equals(buildNumber)) {
            version = new StringBuffer().append(version).append("-b1088").toString();
        }
        return version;
    }
}
