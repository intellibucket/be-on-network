package az.rock.lib.util;

public class DFSUtil {
    public static String generateFileName(String fileName) {
        var names = fileName.split("\\.");
        return names[0]
                .concat("_")
                .concat(String.valueOf(System.currentTimeMillis()))
                .concat(".")
                .concat(names[1]);
    }
}
