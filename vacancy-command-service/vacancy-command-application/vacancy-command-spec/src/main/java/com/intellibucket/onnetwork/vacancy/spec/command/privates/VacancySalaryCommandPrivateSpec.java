package com.intellibucket.onnetwork.vacancy.spec.command.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancySalaryCommand;
import org.springframework.http.ResponseEntity;

public interface VacancySalaryCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> updateVacancySalary(UpdateRequest<VacancySalaryCommand> request);
}
