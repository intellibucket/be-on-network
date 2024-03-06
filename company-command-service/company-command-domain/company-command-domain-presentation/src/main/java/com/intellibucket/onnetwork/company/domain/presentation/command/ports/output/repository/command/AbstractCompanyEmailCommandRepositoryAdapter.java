package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;

@DomainOutputPort
public interface AbstractCompanyEmailCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<EmailRoot> {
}
