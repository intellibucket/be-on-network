package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.AuthenticationLogEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.AuthenticationLogRoot;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogDataAccessMapper implements AbstractDataAccessMapper<AuthenticationLogEntity, AuthenticationLogRoot> {
    @Override
    public AuthenticationLogRoot toRoot(AuthenticationLogEntity entity) {
        return null;
    }

    @Override
    public AuthenticationLogEntity toEntity(AuthenticationLogRoot root) {
        return null;
    }

    @Override
    public AuthenticationLogEntity toNewEntity(AuthenticationLogRoot root) {
        return null;
    }
}
