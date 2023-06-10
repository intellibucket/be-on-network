package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;

public class UserDomainService implements AbstractUserDomainService {

    @Override
    public UserCreatedEvent validateAndInitializeUser(UserRoot userRoot) {
        return UserCreatedEvent.of(userRoot);
    }

    @Override
    public CompanyCreatedEvent validateAndInitializeCompany(UserRoot userRoot) {
        return CompanyCreatedEvent.of(userRoot);
    }
}
