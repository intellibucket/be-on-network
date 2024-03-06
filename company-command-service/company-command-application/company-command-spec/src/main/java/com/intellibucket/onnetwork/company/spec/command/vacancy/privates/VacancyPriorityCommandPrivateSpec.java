package com.intellibucket.onnetwork.company.spec.command.vacancy.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyPriorityCommand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VacancyPriorityCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> updatePriority(VacancyPriorityCommand request);

    ResponseEntity<JSuccessResponse> balancePriority(List<VacancyPriorityCommand> request);
}
