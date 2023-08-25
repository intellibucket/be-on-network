package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibukcet.lib.payload.event.create.picture.ProfilePictureCreatedEvent;

public interface AbstractProfilePictureCreateCommandHandler {
    ProfilePictureCreatedEvent handle(MultipartFileWrapper profilePicture);
}
