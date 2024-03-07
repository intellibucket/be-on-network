package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

import java.util.Optional;

public interface AbstractCompanyQueryRepositoryAdapter {

    Optional<CompanyRoot> getCompanyRoot(CompanyID companyID);
}
