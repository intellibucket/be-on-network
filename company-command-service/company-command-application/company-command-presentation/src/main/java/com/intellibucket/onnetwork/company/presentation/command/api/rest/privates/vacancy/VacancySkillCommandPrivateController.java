package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.vacancy;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancySkillCommand;
import com.intellibucket.onnetwork.company.spec.command.vacancy.privates.VacancySkillCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/skill", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancySkillCommandPrivateController implements VacancySkillCommandPrivateSpec {

    @Override
    @PutMapping(value = "/create/{vacancyId}")
    public ResponseEntity<JSuccessResponse> createVacancySkill(@PathVariable(name = "vacancyId") UUID vacancyId, @RequestBody CreateRequest<VacancySkillCommand> request) {
        return null;
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<JSuccessResponse> updateVacancySkill(@RequestBody UpdateRequest<VacancySkillCommand> request) {
        return null;
    }

    @Override
    @PutMapping(value = "/delete/{vacancySkillId}")
    public ResponseEntity<JSuccessResponse> deleteVacancySkill(@PathVariable(name = "vacancySkillId") UUID vacancySkillId) {
        return null;
    }
}
