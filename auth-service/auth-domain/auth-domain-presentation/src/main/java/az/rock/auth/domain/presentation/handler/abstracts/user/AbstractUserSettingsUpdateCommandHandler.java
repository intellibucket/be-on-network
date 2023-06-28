package az.rock.auth.domain.presentation.handler.abstracts.user;

import az.rock.flyjob.auth.event.user.UserSettingsUpdatedEvent;
import az.rock.lib.valueObject.Language;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserSettingsUpdateCommandHandler {
    UserSettingsUpdatedEvent handleLanguageChange(Language language);
}
