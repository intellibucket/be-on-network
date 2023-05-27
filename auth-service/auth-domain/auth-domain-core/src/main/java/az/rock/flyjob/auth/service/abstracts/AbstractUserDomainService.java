package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;

public interface AbstractUserDomainService {
    UserCreatedEvent validateAndInitializeUser(UserRoot userRoot);
}
