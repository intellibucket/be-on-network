package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.security.RoleRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.RoleID;

import java.util.Optional;

@DomainOutputPort
public interface AbstractRoleQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<RoleRoot, RoleID, DetailID> {
    Optional<RoleRoot> findByName(String name);
}
