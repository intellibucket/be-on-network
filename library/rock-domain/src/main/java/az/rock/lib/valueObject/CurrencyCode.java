package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum CurrencyCode {
    EUR("€"),
    USD("$"),
    AZN("₼"),
    TRY("₺"),
    NONE("NONE");

    private final String sign;

    CurrencyCode(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
