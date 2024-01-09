package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.util.GDateTime;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractWebsiteDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebsiteDataAccessMapper implements AbstractWebsiteDataAccessMapper {
    @Override
    public Optional<WebsiteRoot> toRoot(WebsiteEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    WebsiteRoot.Builder.builder()
                            .uuid(entity.getUuid())
                            .version(entity.getVersion())
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .companyId(entity.getCompany().getUuid())
                            .isVerified(entity.getIsVerified())
                            .verificationRequestDate(GDateTime.toZonedDateTime(entity.getVerificationRequestDate()))
                            .verificationResponseDate(GDateTime.toZonedDateTime(entity.getVerificationResponseDate()))
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<WebsiteEntity> toEntity(WebsiteRoot root) {
        return Optional.empty();
    }
}
