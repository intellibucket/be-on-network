package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.AuthorityEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.AuthorityRoot;
import org.springframework.stereotype.Component;

@Component
public class AuthorityDataAccessMapper implements AbstractDataAccessMapper<AuthorityEntity, AuthorityRoot> {
    @Override
    public AuthorityRoot toRoot(AuthorityEntity entity) {
        return null;
    }

    @Override
    public AuthorityEntity toEntity(AuthorityRoot root) {
        return null;
    }

    @Override
    public AuthorityEntity toNewEntity(AuthorityRoot root) {
        return null;
    }
}

