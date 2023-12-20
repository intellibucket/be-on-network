package com.intellibucket.onnetwork.vacancy.spec.command.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancyPriorityCommand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VacancyPriorityCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> updatePriority(VacancyPriorityCommand request);

    ResponseEntity<JSuccessResponse> balancePriority(List<VacancyPriorityCommand> request);
}
