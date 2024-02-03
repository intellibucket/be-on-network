package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.abstracts;

import az.rock.lib.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;

public abstract class AbstractCompanyCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<CompanyRegistrationPayload, CompanyCreatedEvent> {
}
