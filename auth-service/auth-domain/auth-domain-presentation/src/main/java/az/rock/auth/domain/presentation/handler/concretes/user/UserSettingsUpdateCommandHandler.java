package az.rock.auth.domain.presentation.handler.concretes.user;

import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserSettingsUpdateCommandHandler;
import az.rock.flyjob.auth.event.user.UserSettingsUpdatedEvent;
import az.rock.lib.valueObject.Language;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsUpdateCommandHandler implements AbstractUserSettingsUpdateCommandHandler {
    @Override
    public UserSettingsUpdatedEvent handleLanguageChange(Language language) {
        return null;
    }
}
