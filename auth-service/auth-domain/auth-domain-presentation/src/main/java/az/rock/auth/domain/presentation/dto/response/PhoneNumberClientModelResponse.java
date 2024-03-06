package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import az.rock.lib.valueObject.PhoneNumberType;

import java.util.UUID;

public record PhoneNumberClientModelResponse(UUID uuid, String countryCode, String phoneNumber, PhoneNumberType type) {
    private PhoneNumberClientModelResponse(PhoneNumberRoot root){
        this(root.getRootID().getAbsoluteID() , root.getCountryCode(), root.getPhoneNumber(), root.getType());
    }

    public static PhoneNumberClientModelResponse of(PhoneNumberRoot root){
        return new PhoneNumberClientModelResponse(root);
    }
}
