package com.intellibucket.onnetwork.company.domain.core.command.service.concrets;

import az.rock.lib.jexception.NoActiveRowException;
import az.rock.lib.valueObject.Switch;
import com.intellibucket.onnetwork.company.domain.core.command.exception.HiringStatusUnchangedException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyProfileDomainService;

import java.util.Optional;

public class CompanyProfileDomainService implements AbstractCompanyProfileDomainService {

    @Override
    public CompanyProfileRoot validateAndChangeHiringStatus(Optional<CompanyProfileRoot> root, Switch switcher) {
        root.ifPresentOrElse(
                companyProfileRoot -> {
                    if (!companyProfileRoot.getHiring().equals(switcher.isOn())) {
                        companyProfileRoot.changeHiringStatus(switcher.isOn());
                    }else throw new HiringStatusUnchangedException();
                },
                () -> {
                    throw new NoActiveRowException();
                }
        );
        return root.get();
    }
}
