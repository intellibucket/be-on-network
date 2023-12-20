package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.PasswordRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.PasswordID;
import az.rock.lib.domain.id.auth.UserID;

@DomainOutputPort
public interface AbstractPasswordQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<PasswordRoot, PasswordID, UserID> {
}
