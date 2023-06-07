package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractQueryRoleDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractQueryRoleRepositoryAdapter;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.RoleID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class RoleQueryDomainPresentationService implements AbstractQueryRoleDomainPresentationService {

    private final AbstractQueryRoleRepositoryAdapter queryRoleRepositoryAdapter;

    public RoleQueryDomainPresentationService(AbstractQueryRoleRepositoryAdapter queryRoleRepositoryAdapter) {
        this.queryRoleRepositoryAdapter = queryRoleRepositoryAdapter;
    }

    @Override
    public RoleRoot findIdByName(String name) {
        var optionalRole = this.queryRoleRepositoryAdapter.findByName(name);
        return optionalRole.orElseThrow(()->new RuntimeException("Role not found"));
    }
}
