package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.lib.event.impl.concretes.auth.create.CoverPictureCreatedEvent;
import az.rock.lib.valueObject.MultipartFileWrapper;

public interface AbstractCoverPictureCreateCommandHandler {
    CoverPictureCreatedEvent handle(MultipartFileWrapper profilePicture);
}
