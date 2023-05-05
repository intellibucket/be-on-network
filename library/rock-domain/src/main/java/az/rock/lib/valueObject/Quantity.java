package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigInteger;
import java.util.Objects;

@ValueObject
public final class Quantity {
    public static final Quantity ZERO = new Quantity(BigInteger.ZERO);
    private final BigInteger value;

    public static Quantity of(BigInteger value) {
        return new Quantity(value);
    }

    public static Quantity of(long value) {
        return new Quantity(BigInteger.valueOf(value));
    }

    public static Quantity of(int value) {
        return new Quantity(BigInteger.valueOf(value));
    }

    public static Quantity of(String value) {
        return new Quantity(new BigInteger(value));
    }

    public BigInteger getValue() {
        return value;
    }

    public Quantity(BigInteger value) {
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

    public boolean isGreaterThan(Quantity quantity ){
        return this.value.compareTo(quantity.value) > 0;
    }

    public boolean isGreaterThanOrEquals(Quantity quantity ){
        return this.value.compareTo(quantity.value) >= 0;
    }

    public boolean isLessThan(Quantity quantity ){
        return this.value.compareTo(quantity.value) < 0;
    }

    public boolean isLessThanOrEquals(Quantity quantity ){
        return this.value.compareTo(quantity.value) <= 0;
    }

    public boolean isLessThanZero(){
        return this.value.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isLessThanZeroOrEquals(){
        return this.value.compareTo(BigInteger.ZERO) <= 0;
    }


    public boolean isNegative(){
        return this.value.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isPositive(){
        return this.value.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isEquals(Quantity quantity ){
        return this.value.compareTo(quantity.value) == 0;
    }

    public boolean isNotEquals(Quantity quantity ){
        return this.value.compareTo(quantity.value) != 0;
    }

    public Quantity add(Quantity quantity) {
        return new Quantity(this.value.add(quantity.value));
    }

    public Quantity multiply(Quantity quantity) {
        return new Quantity(this.value.multiply(quantity.value));
    }

    public Quantity subtract(Quantity quantity) {
        return new Quantity(this.value.subtract(quantity.value));
    }

    public Quantity divide(Quantity quantity) {
        return new Quantity(this.value.divide(quantity.value));
    }

}
