package az.rock.flyjob.auth.dataAccess.mapper.abstracts;

import az.rock.flyjob.auth.dataAccess.model.entity.user.ProfilePictureEntity;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractProfilePictureDataAccessMapper <E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<ProfilePictureEntity, ProfilePictureRoot>{
}
