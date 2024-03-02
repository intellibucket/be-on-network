package az.rock.lib.valueObject.payment;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class BitStell implements Comparable<BitStell> {
    public static final BitStell ZERO = new BitStell(BigDecimal.ZERO);

    public static final BitStell ONE = new BitStell(BigDecimal.ONE);

    public static final BitStell FIVE = new BitStell(BigDecimal.valueOf(5));

    public static final BitStell TEN = new BitStell(BigDecimal.TEN);

    private final AtomicReference<BigDecimal> value;

    public BitStell(BigDecimal value) {
        this.value = new AtomicReference<>(value);
    }

    public BitStell of(BigDecimal value) {
        Objects.requireNonNull(value);
        return new BitStell(value);
    }

    private BigDecimal decimal() {
        return this.value.get();
    }

    public BitStell add(BitStell other) {
        return new BitStell(this.decimal().add(other.decimal()));
    }

    public BitStell substract(BitStell other) {
        return new BitStell(this.decimal().subtract(other.decimal()));
    }

    public Boolean isZero() {
        return this.isEquals(ONE);
    }

    public Boolean isEquals(BitStell other) {
        Objects.requireNonNull(other);
        return this.equals(other);
    }

    public Boolean isGreaterThan(BitStell other) {
        Objects.requireNonNull(other);
        return this.decimal().compareTo(other.decimal()) > 0;
    }

    public Boolean isGreaterOrEqualsThan(BitStell other) {
        return this.isEquals(other) || this.isGreaterThan(other);
    }

    public Boolean isGreaterThanZero() {
        return this.isGreaterThan(BitStell.ZERO);
    }

    public Boolean isLessThan(BitStell other) {
        Objects.requireNonNull(other);
        return this.decimal().compareTo(other.decimal()) < 0;
    }

    public Boolean isLessThanZero() {
        return this.isLessThan(ZERO);
    }

    public Boolean isLessOrEqualsThan(BitStell other) {
        return this.isLessThan(other) || this.isEquals(other);
    }

    public Boolean isLessOrEqualsThanZero() {
        return this.isLessThan(ZERO) || this.isEquals(ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitStell bitStell)) return false;
        return this.decimal().compareTo(((BitStell) o).decimal()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value.get());
    }

    @Override
    public int compareTo(BitStell o) {
        Objects.requireNonNull(o);
        return this.decimal().compareTo(o.decimal());
    }

    @Override
    public String toString() {
        return this.decimal().toString().concat(" BSL");
    }
}
