package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.AuthorityRoot;
import az.rock.lib.annotation.OutputPort;

@OutputPort
public interface AbstractAuthorityCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<AuthorityRoot> {
}
