package az.rock.lib.util.constant;

import java.util.Locale;

public class InputUtils {
    public static String capitalize(String value){
        return value.substring(0,1).toUpperCase(Locale.ROOT).concat(value.substring(1).toLowerCase(Locale.ROOT));
    }

    public static String toLowerCase(String value){
        return value.toLowerCase(Locale.ROOT);
    }
}
