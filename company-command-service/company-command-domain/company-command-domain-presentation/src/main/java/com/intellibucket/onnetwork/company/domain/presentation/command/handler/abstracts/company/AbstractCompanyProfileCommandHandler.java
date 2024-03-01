package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import az.rock.lib.valueObject.Switch;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCompanyProfileCommandHandler {
    void changeHiringStatus(Switch switcher);

    void deleteCompanyProfile();
}
