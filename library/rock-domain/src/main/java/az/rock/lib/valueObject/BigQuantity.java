package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigInteger;
import java.util.Objects;

@ValueObject
public class BigQuantity  {
    public static final BigQuantity ZERO = new BigQuantity(BigInteger.ZERO);
    private final BigInteger value;

    public static BigQuantity of(BigInteger value) {
        return new BigQuantity(value);
    }

    public static BigQuantity of(long value) {
        return new BigQuantity(BigInteger.valueOf(value));
    }

    public static BigQuantity of(int value) {
        return new BigQuantity(BigInteger.valueOf(value));
    }

    public static BigQuantity of(String value) {
        return new BigQuantity(new BigInteger(value));
    }

    public BigInteger getValue() {
        return value;
    }

    public BigQuantity(BigInteger value) {
        this.value = Objects.requireNonNullElse(value, BigInteger.ZERO);
    }


    public boolean isGreaterThanZero() {
        return this.value.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isGreaterThanZeroOrEquals() {
        return this.value.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isZero() {
        return this.value.compareTo(BigInteger.ZERO) == 0;
    }

    public boolean isGreaterThan(BigQuantity quantity ){
        return this.value.compareTo(quantity.value) > 0;
    }

    public BigQuantity add(BigQuantity quantity) {
        return new BigQuantity(this.value.add(quantity.value));
    }

    public BigQuantity multiply(BigQuantity quantity) {
        return new BigQuantity(this.value.multiply(quantity.value));
    }

    public BigQuantity subtract(BigQuantity quantity) {
        return new BigQuantity(this.value.subtract(quantity.value));
    }

    public BigQuantity divide(BigQuantity quantity) {
        return new BigQuantity(this.value.divide(quantity.value));
    }

}
