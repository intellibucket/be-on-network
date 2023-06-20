package az.rock.lib.util;

import java.util.Locale;

public class StringUtils {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrWhitespace(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isNullOrEmptyOrWhitespace(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }

    public static boolean isNotNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isNotNullOrWhitespace(String str) {
        return str != null && !str.isBlank();
    }

    public static boolean isNotNullOrEmptyOrWhitespace(String str) {
        return str != null && !str.isEmpty() && !str.isBlank();
    }

    public static boolean isNullOrEmpty(String... strs) {
        for (String str : strs) {
            if (str == null || str.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static String capitalize(String str) {
        if (StringUtils.isNullOrEmpty(str)) return str;
        str = str.toLowerCase(Locale.ROOT);
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String lowerCase(String str) {
        if (StringUtils.isNullOrEmpty(str)) return str;
        return str.toLowerCase(Locale.ROOT);
    }
}
