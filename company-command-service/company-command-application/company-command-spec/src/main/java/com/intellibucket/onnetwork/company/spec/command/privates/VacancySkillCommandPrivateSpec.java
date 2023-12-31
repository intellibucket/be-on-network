package com.intellibucket.onnetwork.company.spec.command.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancySkillCommand;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface VacancySkillCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> createVacancySkill(UUID vacancyId, CreateRequest<VacancySkillCommand> request);

    ResponseEntity<JSuccessResponse> updateVacancySkill(UpdateRequest<VacancySkillCommand> request);

    ResponseEntity<JSuccessResponse> deleteVacancySkill(UUID vacancySkillId);
}
