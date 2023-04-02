package az.rock.lib.util;

import java.util.function.Consumer;

public class GObjects<T> {
    public static <T> boolean isNull(T object) {
        return object == null;
    }

    public static <T> void controlWhenTrueCondition(Boolean bool, Consumer<T> consumer, T obj, RuntimeException exception) {
        if (bool) {
            consumer.accept(obj);
        } else throw exception;
    }

    public static <T> void checkCondition(Boolean condition, RuntimeException exception) {
        if (!condition) throw exception;
    }
}
