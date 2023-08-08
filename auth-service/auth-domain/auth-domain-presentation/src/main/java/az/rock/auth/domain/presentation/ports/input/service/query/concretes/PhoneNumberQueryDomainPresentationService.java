package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractPhoneNumberQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPhoneNumberQueryRepositoryAdapter;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneNumberQueryDomainPresentationService implements AbstractPhoneNumberQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractPhoneNumberQueryRepositoryAdapter phoneNumberQueryRepositoryAdapter;

    public PhoneNumberQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                     AbstractPhoneNumberQueryRepositoryAdapter phoneNumberQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.phoneNumberQueryRepositoryAdapter = phoneNumberQueryRepositoryAdapter;
    }

    @Override
    public PhoneNumberPrivateModelResponse queryOwnById(UUID phoneNumberUUID) {
        var currentUserID = this.securityContextHolder.availableUser();
        var response = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUserID, PhoneNumberID.of(phoneNumberUUID));
        return   response
                .map(PhoneNumberPrivateModelResponse::of)
                .orElseThrow(()-> new RuntimeException("F0000000011"));
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
