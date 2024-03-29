package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.WebsiteID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractWebsiteDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
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
                            .uuid(WebsiteID.of(entity.getUuid()))
                            .version(Version.of(entity.getVersion()))
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .website(entity.getWebsite())
                            .companyID(CompanyID.of(entity.getCompany().getUuid()))
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
        var optionalWebsiteRoot = Optional.ofNullable(root);
        if (optionalWebsiteRoot.isPresent()) {
            return Optional.of(
                    WebsiteEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .company(CompanyEntity.referenceObject(root.getCompanyID().getAbsoluteID()))
                            .isVerified(root.getVerified())
                            .website(root.getWebsite())
                            .verificationRequestDate(GDateTime.toTimestamp(root.getVerificationRequestDate()))
                            .verificationResponseDate(GDateTime.toTimestamp(root.getVerificationResponseDate()))
                            .version(root.getVersionValue())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                            .build());
        }
        return Optional.empty();
    }
}
