package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigInteger;

@ValueObject
public class Quantity {
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
        this.value = value;
    }


    public Quantity add(Quantity quantity) {
        return new Quantity(this.value.add(quantity.getValue()));
    }

    public Quantity subtract(Quantity quantity) {
        return new Quantity(this.value.subtract(quantity.getValue()));
    }

    public Quantity multiply(Quantity quantity) {
        return new Quantity(this.value.multiply(quantity.getValue()));
    }

    public Quantity divide(Quantity quantity) {
        return new Quantity(this.value.divide(quantity.getValue()));
    }

}
