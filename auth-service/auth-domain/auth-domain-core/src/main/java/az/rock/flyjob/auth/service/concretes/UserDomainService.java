package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.root.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;

public class UserDomainService implements AbstractUserDomainService {
    @Override
    public UserCreatedEvent validateAndInitializeUser(UserRoot userRoot) {
        return null;
    }
}
