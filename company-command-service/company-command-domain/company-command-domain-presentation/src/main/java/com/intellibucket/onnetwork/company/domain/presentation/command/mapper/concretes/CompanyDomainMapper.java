package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.concretes;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyProfileDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractsCompanyDomainMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompanyDomainMapper implements AbstractsCompanyDomainMapper {

    private final AbstractCompanyProfileDomainMapper companyProfileDomainMapper;

    public CompanyDomainMapper(AbstractCompanyProfileDomainMapper companyProfileDomainMapper) {
        this.companyProfileDomainMapper = companyProfileDomainMapper;
    }

    @Override
    public CompanyRoot toNewCompanyRoot(CompanyRegistrationPayload payload) {
        var companyUUID = CompanyID.of(UUID.randomUUID());
        var companyProfileRoot = this.companyProfileDomainMapper.toNewCompanyProfileRoot(companyUUID);
        return CompanyRoot.Builder.builder()
                .uuid(companyUUID)
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .userId(payload.getUserId())
                .name(null)
                .description(null)
                .profile(companyProfileRoot)
                .build();
    }
/*
    @Override
    public CompanyProfileCreatedEvent toCompanyProfileCreatedEvent(CompanyRoot companyRoot) {
        var payload = new CompanyProfileCreatedPayload(companyRoot.getRootID().getAbsoluteID());
        return new CompanyProfileCreatedEvent(payload);
    }

 */
}
