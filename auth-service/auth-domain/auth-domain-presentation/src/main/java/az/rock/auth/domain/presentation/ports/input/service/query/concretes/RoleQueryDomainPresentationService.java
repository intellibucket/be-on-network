package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractQueryRoleDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractRoleQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.security.RoleRoot;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class RoleQueryDomainPresentationService implements AbstractQueryRoleDomainPresentationService {

    private final AbstractRoleQueryRepositoryAdapter queryRoleRepositoryAdapter;

    public RoleQueryDomainPresentationService(AbstractRoleQueryRepositoryAdapter queryRoleRepositoryAdapter) {
        this.queryRoleRepositoryAdapter = queryRoleRepositoryAdapter;
    }

    @Override
    public RoleRoot findIdByName(String name) {
        var optionalRole = this.queryRoleRepositoryAdapter.findByName(name);
        return optionalRole.orElseThrow(()->new RuntimeException("Role not found"));
    }
}
