package az.rock.lib.domain;

public interface NullValueReference<R> {
    default Boolean isNull(){
        return false;
    }
}
