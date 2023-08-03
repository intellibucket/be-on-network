package az.rock.flyjob.auth.dataAccess.mapper.abstracts;

import az.rock.flyjob.auth.dataAccess.model.entity.user.ProfilePictureEntity;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.AggregateRoot;

public interface AbstractProfilePictureDataAccessMapper <E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<ProfilePictureEntity, ProfilePictureRoot>{
}
