package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional(readOnly = true)
public interface AbstractQueryRoleDomainPresentationService {
    RoleRoot findIdByName(String name);
}
