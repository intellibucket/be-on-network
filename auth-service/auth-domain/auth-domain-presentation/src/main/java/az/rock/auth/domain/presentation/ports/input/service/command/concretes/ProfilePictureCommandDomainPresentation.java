package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractProfilePictureCommandDomainPresentation;
import az.rock.flyjob.auth.dfs.service.abstracts.AbstractFileStorageService;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfilePictureCommandDomainPresentation implements AbstractProfilePictureCommandDomainPresentation {

    private final AbstractFileStorageService fileStorageService;

    public ProfilePictureCommandDomainPresentation(AbstractFileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public UUID uploadProfilePicture(MultipartFileWrapper file) {
        var result = this.fileStorageService.uploadFile(file);
        return null;
    }
}
