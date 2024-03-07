package com.intellibucket.onnetwork.company.domain.core.command.service.abstracts;

import az.rock.lib.valueObject.Switch;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;

import java.util.Optional;

public interface AbstractCompanyProfileDomainService {
    CompanyProfileRoot validateAndChangeHiringStatus(Optional<CompanyProfileRoot> root, Switch switcher);
}
