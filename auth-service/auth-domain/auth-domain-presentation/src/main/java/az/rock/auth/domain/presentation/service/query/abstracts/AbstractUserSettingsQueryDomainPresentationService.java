package az.rock.auth.domain.presentation.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.UserSettingResponse;

public interface AbstractUserSettingsQueryDomainPresentationService {
    UserSettingResponse getUserSettings();
}
