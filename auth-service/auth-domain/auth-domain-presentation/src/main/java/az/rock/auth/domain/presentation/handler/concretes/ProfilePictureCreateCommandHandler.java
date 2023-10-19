package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractProfilePictureCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractProfilePictureDomainMapper;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractProfilePictureCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractProfilePictureQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.service.abstracts.AbstractProfilePictureDomainService;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.picture.ProfilePictureCreatedEvent;
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
        //image/profile/0285029385409234_123.jpg
        var root = this.profilePictureDomainMapper.of(currentUserId, savedFile);
        // Evvelce hamisini cek (Roots) sonra inactive ele
        var savedRoot = this.profilePictureCommandRepositoryAdapter.create(root);
        if (savedRoot.isPresent()) {
            //Burda event yaranmali payloada aidiyyati seyler qoulmalidir.
            // Payloadda mutleq seklin yeni rootun id si olmalidi
            return null;
        } else throw new AuthDomainPresentationException("F0000000001");
    }
}
