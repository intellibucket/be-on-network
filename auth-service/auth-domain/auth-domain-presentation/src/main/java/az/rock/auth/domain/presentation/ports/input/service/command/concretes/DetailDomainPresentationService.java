package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractDetailDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractDetailQueryRepositoryAdapter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class DetailDomainPresentationService implements AbstractDetailDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter;

    public DetailDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                           AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.detailQueryRepositoryAdapter = detailQueryRepositoryAdapter;
    }

    @Override
    public DetailPrivateModelResponse queryDetail() {
        var currentUserID = this.securityContextHolder.currentUser();
        return null;
    }
}
