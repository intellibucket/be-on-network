package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.domain.id.UserID;

@DomainOutputPort
public interface AbstractPasswordQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<PasswordRoot, PasswordID, UserID> {
}
