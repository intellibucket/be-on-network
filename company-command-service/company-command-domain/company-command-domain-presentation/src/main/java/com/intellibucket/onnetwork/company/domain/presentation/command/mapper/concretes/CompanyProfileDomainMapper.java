package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.concretes;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.CompanyProfileID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyProfileDomainMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompanyProfileDomainMapper implements AbstractCompanyProfileDomainMapper {

    @Override
    public CompanyProfileRoot toNewCompanyProfileRoot(CompanyID companyUUID) {
        return CompanyProfileRoot.Builder.builder()
                .uuid(CompanyProfileID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .companyID(companyUUID)
                .isHiring(false)
                .build();
    }
}
