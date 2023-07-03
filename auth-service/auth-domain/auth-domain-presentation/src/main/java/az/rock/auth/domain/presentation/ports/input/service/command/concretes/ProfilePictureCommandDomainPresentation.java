package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PictureQueryRequest;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractProfilePictureCommandDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfilePictureCommandDomainPresentation implements AbstractProfilePictureCommandDomainPresentation {

    private final AbstractFileStorageAdapter fileStorageService;

    public ProfilePictureCommandDomainPresentation(AbstractFileStorageAdapter fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public UUID uploadProfilePicture(MultipartFileWrapper file) {
        var result = this.fileStorageService.uploadFile(file);
        return null;
    }

    @Override
    public byte[] get(PictureQueryRequest request) {
        var response = this.fileStorageService.get(request.path());
        return new byte[0];
    }


}
