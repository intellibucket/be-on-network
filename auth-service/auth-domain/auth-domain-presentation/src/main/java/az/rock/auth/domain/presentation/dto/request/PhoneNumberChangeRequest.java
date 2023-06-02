package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.PhoneNumberType;

import java.util.UUID;

public final class PhoneNumberChangeRequest {
    private final UUID phoneNumberUUID;

    private final String countryCode;

    private final String phoneNumber;

    private final PhoneNumberType type;

    public PhoneNumberChangeRequest(UUID phoneNumberUUID,
                                    String countryCode,
                                    String phoneNumber,
                                    PhoneNumberType type) {
        this.phoneNumberUUID = phoneNumberUUID;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public UUID getPhoneNumberUUID() {
        return phoneNumberUUID;
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
