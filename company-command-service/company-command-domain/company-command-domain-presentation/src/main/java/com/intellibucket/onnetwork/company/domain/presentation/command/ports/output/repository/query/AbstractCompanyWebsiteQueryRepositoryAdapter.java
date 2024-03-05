package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;

import java.util.Optional;

public interface AbstractCompanyWebsiteQueryRepositoryAdapter {
    Optional<WebsiteRoot> findCompanyWebsiteByCompanyId(CompanyID companyID);

}
