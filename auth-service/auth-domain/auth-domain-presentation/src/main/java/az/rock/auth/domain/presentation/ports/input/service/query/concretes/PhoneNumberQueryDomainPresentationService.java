package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractPhoneNumberQueryDomainPresentationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneNumberQueryDomainPresentationService implements AbstractPhoneNumberQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;

    public PhoneNumberQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder) {
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public PhoneNumberPrivateModelResponse queryOwnById(UUID phoneNumberUUID) {
        return null;
    }

    @Override
    public PhoneNumberClientModelResponse queryAnyById(UUID phoneNumberUUID) {
        return null;
    }

    @Override
    public List<PhoneNumberPrivateModelResponse> queryOwnAll() {
        return null;
    }

    @Override
    public List<UUID> queryOwnAllId() {
        return null;
    }
}
