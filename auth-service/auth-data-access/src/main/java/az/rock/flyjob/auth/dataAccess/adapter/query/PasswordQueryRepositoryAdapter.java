package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPasswordQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasswordQueryRepositoryAdapter implements AbstractPasswordQueryRepositoryAdapter {
    @Override
    public Optional<PasswordRoot> findById(PasswordID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<PasswordRoot> findByPID(UserID parentID) {
        return Optional.empty();
    }
}
