package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PictureQueryRequest;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractCoverPictureCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractCoverPictureCommandDomainPresentation;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoverPictureCommandDomainPresentation implements AbstractCoverPictureCommandDomainPresentation {

    private final AbstractCoverPictureCreateCommandHandler coverPictureCreateCommandHandler;

    public CoverPictureCommandDomainPresentation(AbstractCoverPictureCreateCommandHandler coverPictureCreateCommandHandler) {
        this.coverPictureCreateCommandHandler = coverPictureCreateCommandHandler;
    }

    @Override
    public UUID uploadProfilePicture(MultipartFileWrapper file) {
        var event = this.coverPictureCreateCommandHandler.handle(file);
        return null;
    }

    @Override
    public byte[] get(PictureQueryRequest request) {
        return new byte[0];
    }
}
