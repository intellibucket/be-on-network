package az.rock.lib.jresponse;


import az.rock.lib.jexception.JRuntimeException;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JDataTransfer<D> extends JTransfer {
    private D data;

    private final static JDataTransfer<?> EMPTY = new JDataTransfer<>(null);

    public JDataTransfer() {
        super();
    }

    public JDataTransfer(D data) {
        super();
        this.data = data;
    }

    public JDataTransfer(JHeader header, D data) {
        super(header);
        this.data = data;
    }


    @SuppressWarnings("unchecked")
    public static <D> JDataTransfer<D> ofNullable(D value) {
        return value == null ? (JDataTransfer<D>) EMPTY : new JDataTransfer<>(value);
    }

    public static <D> JDataTransfer<D> EMPTY() {
        @SuppressWarnings("unchecked")
        JDataTransfer<D> object = (JDataTransfer<D>) EMPTY;
        return object;
    }

    public static <D> JDataTransfer<D> of(D data) {
        return new JDataTransfer<>(Objects.requireNonNull(data));
    }

    public D get() {
        return this.data;
    }

    public D getThrow(JRuntimeException exception) {
        if (Objects.isNull(this.data)) throw exception;
        return this.data;
    }

    public D getElse(D defaultValue) {
        return Objects.requireNonNullElse(this.data, defaultValue);
    }

    public void ifPresent(Consumer<? super D> action) {
        if (!Objects.isNull(data)) {
            action.accept(data);
        }
    }

    public void ifPresentOrElse(Consumer<? super D> action, Runnable emptyAction) {
        if (!Objects.isNull(data)) action.accept(data);
        else emptyAction.run();
    }


    public boolean isPresent() {
        return !Objects.isNull(data);
    }

    public JDataTransfer<D> filter(Predicate<? super D> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        } else {
            return predicate.test(data) ? this : JDataTransfer.EMPTY();
        }
    }

    public <U> JDataTransfer<U> map(Function<? super D, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) return EMPTY();
        else return JDataTransfer.ofNullable(mapper.apply(data));

    }

    public JDataTransfer<D> or(Supplier<? extends JDataTransfer<? extends D>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) return this;
        else {
            @SuppressWarnings("unchecked")
            JDataTransfer<D> r = (JDataTransfer<D>) supplier.get();
            return Objects.requireNonNull(r);
        }
    }

    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
