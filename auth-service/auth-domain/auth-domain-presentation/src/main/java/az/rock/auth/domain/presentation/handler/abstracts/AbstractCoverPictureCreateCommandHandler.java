package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.picture.CoverPictureCreatedEvent;

public interface AbstractCoverPictureCreateCommandHandler {
    CoverPictureCreatedEvent handle(MultipartFileWrapper profilePicture);
}
