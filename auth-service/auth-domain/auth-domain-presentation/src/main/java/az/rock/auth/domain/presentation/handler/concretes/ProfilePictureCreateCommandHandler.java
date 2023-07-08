package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractProfilePictureCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractProfilePictureDomainMapper;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractProfilePictureCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractProfilePictureQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.user.ProfilePictureCreatedEvent;
import az.rock.flyjob.auth.service.abstracts.AbstractProfilePictureDomainService;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Component;

@Component
public class ProfilePictureCreateCommandHandler implements AbstractProfilePictureCreateCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractProfilePictureQueryRepositoryAdapter profilePictureQueryRepositoryAdapter;
    private final AbstractProfilePictureCommandRepositoryAdapter profilePictureCommandRepositoryAdapter;
    private final AbstractProfilePictureDomainMapper profilePictureDomainMapper;
    private final AbstractProfilePictureDomainService profilePictureDomainService;

    public ProfilePictureCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                              AbstractFileStorageAdapter fileStorageService,
                                              AbstractProfilePictureQueryRepositoryAdapter profilePictureQueryRepositoryAdapter,
                                              AbstractProfilePictureCommandRepositoryAdapter profilePictureCommandRepositoryAdapter,
                                              AbstractProfilePictureDomainMapper profilePictureDomainMapper,
                                              AbstractProfilePictureDomainService profilePictureDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.fileStorageService = fileStorageService;
        this.profilePictureQueryRepositoryAdapter = profilePictureQueryRepositoryAdapter;
        this.profilePictureCommandRepositoryAdapter = profilePictureCommandRepositoryAdapter;
        this.profilePictureDomainMapper = profilePictureDomainMapper;
        this.profilePictureDomainService = profilePictureDomainService;
    }

    @Override
    public ProfilePictureCreatedEvent handle(MultipartFileWrapper profilePicture) {
        var currentUserId = this.securityContextHolder.availableUser();
        var savedFile = this.fileStorageService.uploadFile(profilePicture);
        return null;
    }
}
