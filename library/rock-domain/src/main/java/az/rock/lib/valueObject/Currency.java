package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum Currency {
    EUR("€"), USD("$"), AZN("₼"), YTL("₺");

    private final String sign;

    Currency(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
