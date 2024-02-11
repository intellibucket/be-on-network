package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query;

import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;

import java.util.List;
import java.util.Optional;

public interface AbstractCompanyEmailQueryRepositoryAdapter {
  List<EmailRoot> getCompanyEmailsByCompanyUuid(CompanyID companyID);

  Boolean isExistEmailAsActive(String email);

  List<EmailRoot> findAllMyEmails(CompanyID companyID);

  Optional<EmailRoot> findEmailById(EmailID emailID);

}
