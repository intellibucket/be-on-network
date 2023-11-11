package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.user.CoverPictureRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.FileMetaData;

public interface AbstractCoverPictureDomainMapper {
    CoverPictureRoot of(UserID userID, FileMetaData fileMetaData);
}
