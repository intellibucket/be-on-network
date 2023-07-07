package az.rock.flyjob.auth.service.abstracts;

import az.rock.lib.valueObject.MultipartFileWrapper;

public interface AbstractProfilePictureDomainService {
    void validate(MultipartFileWrapper multipartFileWrapper);
}
