package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.RoleID;

@InputPort
public interface AbstractQueryRoleDomainPresentationService {
    RoleID findIdByName(String name);
}
