package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.concretes;

import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyEmailDomainMapper;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;

@Component
public class CompanyEmailDomainMapper implements AbstractCompanyEmailDomainMapper {

    @Override
    public EmailRoot toNewCompanyEmailRoot(CompanyEmailCreatedCommand companyEmailChangedCommand, CompanyID companyUuid) {
        return EmailRoot.Builder.builder()
                .uuid(EmailID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .companyID(companyUuid)
                .accessModifier(AccessModifier.PUBLIC)
                .email(companyEmailChangedCommand.getEmail())
                .isPrimary(false)
                .isVerified(false)
                .build();
    }

    @Override
    public EmailRoot mapToEmailRoot(EmailRoot oldEmail , CompanyEmailChangedCommand companyEmailChangedCommand) {
        //FIXME 20240209 ISVERIFIED

        return EmailRoot.Builder
                .builder()
                .uuid(oldEmail.getRootID())
                .version(oldEmail.getVersion())
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .email(companyEmailChangedCommand.getEmail())
                .isPrimary(oldEmail.isPrimary())
                .isVerified(oldEmail.isVerified())
                .build();
    }
}
