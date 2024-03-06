package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;

@DomainOutputPort
public interface AbstractCompanyProfileCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<CompanyProfileRoot> {
}
