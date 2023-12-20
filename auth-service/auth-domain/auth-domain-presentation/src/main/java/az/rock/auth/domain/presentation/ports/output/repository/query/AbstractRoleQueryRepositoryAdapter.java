package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.DetailID;
import az.rock.lib.domain.id.auth.RoleID;

import java.util.Optional;

@DomainOutputPort
public interface AbstractRoleQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<RoleRoot, RoleID, DetailID> {
    Optional<RoleRoot> findByName(String name);
}
