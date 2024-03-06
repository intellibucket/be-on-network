package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PictureQueryRequest;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractProfilePictureCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractProfilePictureCommandDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractProfilePictureMessagePublisher;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfilePictureCommandDomainPresentation implements AbstractProfilePictureCommandDomainPresentation {

    private final AbstractProfilePictureMessagePublisher profilePictureMessagePublisher;

    private final AbstractProfilePictureCreateCommandHandler profilePictureCreateCommandHandler;

    public ProfilePictureCommandDomainPresentation(AbstractProfilePictureMessagePublisher profilePictureMessagePublisher,
                                                   AbstractProfilePictureCreateCommandHandler profilePictureCreateCommandHandler) {
        this.profilePictureMessagePublisher = profilePictureMessagePublisher;
        this.profilePictureCreateCommandHandler = profilePictureCreateCommandHandler;
    }

    @Override
    /**
     * DFS e yazilandan somnra hemin path goturulur. Profile Pictuere Root yaranir ve isdifadecinin user id si
     * vurulur usdune. Onnan sonra insert gedir bazaya. Bazada eger evvelce profile picture root lar varsa onlar onactive edilir.
     *
     */
    public UUID uploadProfilePicture(MultipartFileWrapper file) {
        var event = this.profilePictureCreateCommandHandler.handle(file);
        return null;
    }

    @Override
    public byte[] get(PictureQueryRequest request) {
        //var response = this.fileStorageService.get(request.path());
        return new byte[0];
    }


}
