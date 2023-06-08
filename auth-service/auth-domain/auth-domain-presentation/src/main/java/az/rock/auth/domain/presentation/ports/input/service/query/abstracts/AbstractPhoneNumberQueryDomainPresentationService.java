package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;

import java.util.List;
import java.util.UUID;

public interface AbstractPhoneNumberQueryDomainPresentationService {
    PhoneNumberPrivateModelResponse queryOwnById(UUID phoneNumberUUID);

    PhoneNumberClientModelResponse queryAnyById(UUID phoneNumberUUID);

    List<PhoneNumberPrivateModelResponse> queryOwnAll();

    List<UUID> queryOwnAllId();
}
