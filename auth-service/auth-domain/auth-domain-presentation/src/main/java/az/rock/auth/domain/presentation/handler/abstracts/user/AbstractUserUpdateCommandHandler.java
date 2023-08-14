package az.rock.auth.domain.presentation.handler.abstracts.user;

import az.rock.lib.event.impl.concretes.auth.update.UserUpdatedEvent;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserUpdateCommandHandler {
    UserUpdatedEvent handleFirstnameUpdated(String firstname);
    UserUpdatedEvent handleLastnameUpdated(String lastname);
    UserUpdatedEvent handleUsernameUpdated(String username);
    UserUpdatedEvent handleGenderUpdated(Gender gender);

    UserUpdatedEvent handleTimezoneUpdated(TimeZoneID timezone);
}
