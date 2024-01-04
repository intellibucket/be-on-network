package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.concretes;

import az.rock.lib.domain.id.BlockID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractsCompanyDomainMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompanyDomainMapper implements AbstractsCompanyDomainMapper {

    @Override
    public CompanyRoot toNewCompanyRoot(CompanyRegistrationPayload payload) {
            return CompanyRoot.Builder.builder()
                .uuid(CompanyID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .userId(payload.getUserId())
                .name(null)
                .description(null)
                .build();
    }
}
