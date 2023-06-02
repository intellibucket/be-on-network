package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.PhoneNumberType;

public final class PhoneNumberCommandRequest {

    private final String countryCode;

    private final String phoneNumber;

    private final PhoneNumberType type;

    public PhoneNumberCommandRequest(String countryCode, String phoneNumber, PhoneNumberType type) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getType() {
        return type;
    }
}
