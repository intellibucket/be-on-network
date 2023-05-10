package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.RoleEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.account.RoleRoot;
import org.springframework.stereotype.Component;

@Component
public class RoleDataAccessMapper  implements AbstractDataAccessMapper<RoleEntity, RoleRoot> {
    @Override
    public RoleRoot toRoot(RoleEntity entity) {
        return null;
    }

    @Override
    public RoleEntity toEntity(RoleRoot root) {
        return null;
    }

    @Override
    public RoleEntity toNewEntity(RoleRoot root) {
        return null;
    }
}
