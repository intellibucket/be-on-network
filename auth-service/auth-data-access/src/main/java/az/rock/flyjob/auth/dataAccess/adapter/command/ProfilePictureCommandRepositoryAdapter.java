package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractProfilePictureCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.ProfilePictureEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractProfilePictureDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractProfilePictureCustomCommandJPARepository;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfilePictureCommandRepositoryAdapter implements AbstractProfilePictureCommandRepositoryAdapter {
    private final AbstractProfilePictureCustomCommandJPARepository profilePictureCustomCommandJPARepository;
    private final AbstractProfilePictureDataAccessMapper<ProfilePictureEntity,ProfilePictureRoot> profilePictureDataAccessAdapter;

    public ProfilePictureCommandRepositoryAdapter(AbstractProfilePictureCustomCommandJPARepository profilePictureCustomCommandJPARepository,
                                                  AbstractProfilePictureDataAccessMapper<ProfilePictureEntity,ProfilePictureRoot> profilePictureDataAccessAdapter) {
        this.profilePictureCustomCommandJPARepository = profilePictureCustomCommandJPARepository;
        this.profilePictureDataAccessAdapter = profilePictureDataAccessAdapter;
    }

    @Override
    public Optional<ProfilePictureRoot> create(ProfilePictureRoot root) {
        var entity = this.profilePictureDataAccessAdapter.toEntity(root);
        if(entity.isPresent()){
            var savedEntity = this.profilePictureCustomCommandJPARepository.persist(entity.get());
            return this.profilePictureDataAccessAdapter.toRoot(savedEntity);
        }else return Optional.empty();
    }
}
