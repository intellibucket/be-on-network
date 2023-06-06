package az.rock.auth.domain.presentation.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.UserSettingModelResponse;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AbstractUserSettingsQueryDomainPresentationService {

    UserSettingModelResponse getUserSettings();
}