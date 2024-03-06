package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.Switch;

@InputPort
public interface AbstractCompanyProfileCommandDomainPresentationService {
    void changeHiringStatus(Switch switcher);

    void deleteCompanyProfile();
}
