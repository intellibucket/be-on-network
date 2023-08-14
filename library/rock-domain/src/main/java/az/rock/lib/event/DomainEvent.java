package az.rock.lib.event;

public interface DomainEvent<T> {
    default void fire(){}
}
