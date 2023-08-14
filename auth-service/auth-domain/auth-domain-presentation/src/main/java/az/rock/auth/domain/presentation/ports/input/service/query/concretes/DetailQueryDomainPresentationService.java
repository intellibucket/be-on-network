package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractDetailQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractDetailQueryRepositoryAdapter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class DetailQueryDomainPresentationService implements AbstractDetailQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter;

    public DetailQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.detailQueryRepositoryAdapter = detailQueryRepositoryAdapter;
    }

    @Override
    public DetailPrivateModelResponse queryDetail() {
        var currentUserID = this.securityContextHolder.availableUser();
        return null;
    }
}
