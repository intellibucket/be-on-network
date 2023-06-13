package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@InputPort
@Transactional(readOnly = true)
public interface AbstractPhoneNumberQueryDomainPresentationService {
    PhoneNumberPrivateModelResponse queryOwnById(UUID phoneNumberUUID);

    PhoneNumberClientModelResponse queryAnyById(UUID phoneNumberUUID);

    List<PhoneNumberPrivateModelResponse> queryOwnAll();

    List<UUID> queryOwnAllId();
}
