package az.rock.flyjob.auth.service.abstracts;

import az.rock.lib.valueObject.MultipartFileWrapper;

public interface AbstractCoverPictureDomainService {
    void validate(MultipartFileWrapper multipartFileWrapper);
}
