package az.rock.lib.domain;

public abstract class SimpleAggregateRoot <ID> extends RootID<ID> {
    public SimpleAggregateRoot(ID value) {
        super(value);
    }
}
