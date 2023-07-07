package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.flyjob.auth.event.user.ProfilePictureCreatedEvent;
import az.rock.lib.valueObject.MultipartFileWrapper;

public interface AbstractProfilePictureCreateCommandHandler {
    ProfilePictureCreatedEvent handle(MultipartFileWrapper profilePicture);
}
