package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.valueObject.PhoneNumberType;

import java.util.UUID;

public record PhoneNumberPrivateModelResponse(UUID uuid, String countryCode, String phoneNumber, PhoneNumberType type,
                                              Boolean isEnableSmsNotification, Boolean isEnableWhatsappNotification,
                                              Boolean isPrimary, Boolean isVerified) {
    private PhoneNumberPrivateModelResponse(PhoneNumberRoot root){
        this(root.getRootID().getAbsoluteID() , root.getCountryCode(), root.getPhoneNumber(), root.getType(),
                root.getEnableSmsNotification(), root.getEnableWhatsappNotification(), root.getPrimary(),
                root.getVerified());
    }

    public static PhoneNumberPrivateModelResponse of(PhoneNumberRoot root){
        return new PhoneNumberPrivateModelResponse(root);
    }
}
