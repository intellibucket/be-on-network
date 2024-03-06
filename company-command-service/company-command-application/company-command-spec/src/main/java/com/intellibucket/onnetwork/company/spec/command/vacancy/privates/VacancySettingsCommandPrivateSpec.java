package com.intellibucket.onnetwork.company.spec.command.vacancy.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancySettingCommand;
import org.springframework.http.ResponseEntity;

public interface VacancySettingsCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> updateVacancySettings(UpdateRequest<VacancySettingCommand> request);
}
