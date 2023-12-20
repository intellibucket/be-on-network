package com.intellibucket.onnetwork.vacancy.domain.presentation.command.ports.output.publisher;

import az.rock.lib.annotation.DomainOutputPort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DomainOutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractVacancyCommandMessagePublisher {
}
