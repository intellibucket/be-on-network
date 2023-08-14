package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.FileMetaData;

public interface AbstractProfilePictureDomainMapper {
    ProfilePictureRoot of(UserID userID, FileMetaData fileMetaData);
}
