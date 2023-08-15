package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.lib.event.impl.concretes.auth.create.ProfilePictureCreatedEvent;
import az.rock.lib.valueObject.MultipartFileWrapper;

public interface AbstractProfilePictureCreateCommandHandler {
    ProfilePictureCreatedEvent handle(MultipartFileWrapper profilePicture);
}
