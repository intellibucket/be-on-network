package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

@ValueObject
public class Money {
    private final BigDecimal amount;

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public Money(final BigDecimal amount) {
        this.amount = Objects.requireNonNullElse(amount, BigDecimal.ZERO);
    }

    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThanZeroOrEquals() {
        return this.amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
    }


    public boolean isZero() {
        return this.amount.compareTo(BigDecimal.ZERO) == 0;
    }


    public Money add(Money money) {
        return new Money(this.setScale(this.amount.add((BigDecimal) money.amount)));
    }


    public Money multiply(int multiplier) {
        return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    public Money subtract(Money money) {
        return new Money(this.setScale(this.amount.subtract(money.getAmount())));
    }

    public Money divide(Money money) {
        return new Money(this.setScale(this.amount.divide(money.getAmount(), 2, RoundingMode.HALF_DOWN)));
    }


    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_DOWN);
    }
}
