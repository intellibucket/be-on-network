package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.OutputPort;

@OutputPort
public interface AbstractUserRepositoryAdapter extends AbstractRepositoryAdapter<UserRoot> {

}
