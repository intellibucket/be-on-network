package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class UserOutboxDomainMapper implements AbstractUserOutboxDomainMapper {
    @Override
    public UserOutboxRoot mapToDomainModel(AbstractDomainEvent<UserRoot> event) {
        return null;
    }
}
