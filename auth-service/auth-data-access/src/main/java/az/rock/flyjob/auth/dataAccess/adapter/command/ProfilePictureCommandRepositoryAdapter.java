package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractProfilePictureCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfilePictureCommandRepositoryAdapter implements AbstractProfilePictureCommandRepositoryAdapter {
    @Override
    public Optional<ProfilePictureRoot> create(ProfilePictureRoot root) {
        return Optional.empty();
    }
}
