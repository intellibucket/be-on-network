package az.rock.lib.valueObject.payment;

import az.rock.lib.valueObject.DecimalValue;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class BitSteel implements Comparable<BitSteel>, DecimalValue {
    public static final BitSteel ZERO = new BitSteel(BigDecimal.ZERO);

    public static final BitSteel ONE = new BitSteel(BigDecimal.ONE);

    public static final BitSteel FIVE = new BitSteel(BigDecimal.valueOf(5));

    public static final BitSteel TEN = new BitSteel(BigDecimal.TEN);

    private final AtomicReference<BigDecimal> value;

    public BitSteel(BigDecimal value) {
        this.value = new AtomicReference<>(value);
    }

    public BitSteel of(BigDecimal value) {
        Objects.requireNonNull(value);
        return new BitSteel(value);
    }

    private BigDecimal decimal() {
        return this.value.get();
    }

    public BitSteel add(BitSteel other) {
        return new BitSteel(this.decimal().add(other.decimal()));
    }

    public BitSteel substract(BitSteel other) {
        return new BitSteel(this.decimal().subtract(other.decimal()));
    }

    public Boolean isZero() {
        return this.isEquals(ONE);
    }

    public Boolean isEquals(BitSteel other) {
        Objects.requireNonNull(other);
        return this.equals(other);
    }

    public Boolean isGreaterThan(BitSteel other) {
        Objects.requireNonNull(other);
        return this.decimal().compareTo(other.decimal()) > 0;
    }

    public Boolean isGreaterOrEqualsThan(BitSteel other) {
        return this.isEquals(other) || this.isGreaterThan(other);
    }

    public Boolean isGreaterThanZero() {
        return this.isGreaterThan(BitSteel.ZERO);
    }

    public Boolean isLessThan(BitSteel other) {
        Objects.requireNonNull(other);
        return this.decimal().compareTo(other.decimal()) < 0;
    }

    public Boolean isLessThanZero() {
        return this.isLessThan(ZERO);
    }

    public Boolean isLessOrEqualsThan(BitSteel other) {
        return this.isLessThan(other) || this.isEquals(other);
    }

    public Boolean isLessOrEqualsThanZero() {
        return this.isLessThan(ZERO) || this.isEquals(ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitSteel bitSteel)) return false;
        return this.decimal().compareTo(((BitSteel) o).decimal()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value.get());
    }

    @Override
    public int compareTo(BitSteel o) {
        Objects.requireNonNull(o);
        return this.decimal().compareTo(o.decimal());
    }

    @Override
    public String toString() {
        return this.decimal().toString().concat(" BSL");
    }

    @Override
    public BigDecimal toDecimal() {
        return this.decimal();
    }
}
