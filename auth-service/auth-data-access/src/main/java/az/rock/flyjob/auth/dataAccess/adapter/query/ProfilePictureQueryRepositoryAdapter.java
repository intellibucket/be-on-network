package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractProfilePictureQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.ProfilePictureRoot;
import az.rock.lib.domain.id.auth.ProfilePictureID;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfilePictureQueryRepositoryAdapter implements AbstractProfilePictureQueryRepositoryAdapter {
    @Override
    public Optional<ProfilePictureRoot> findById(ProfilePictureID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<ProfilePictureRoot> findByPID(UserID parentID) {
        return Optional.empty();
    }
}
