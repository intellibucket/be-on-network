package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.ProfilePictureRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.ProfilePictureID;
import az.rock.lib.domain.id.auth.UserID;

@DomainOutputPort
public interface AbstractProfilePictureQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<ProfilePictureRoot, ProfilePictureID, UserID> {
}
