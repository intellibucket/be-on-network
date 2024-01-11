package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyEmailDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class CompanyEmailDataAccessMapper implements AbstractCompanyEmailDataAccessMapper {

    @Override
    public Optional<EmailRoot> toRoot(EmailEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    EmailRoot.Builder.builder()
                            .uuid(EmailID.of(entity.getUuid()))
                            .version(Version.of(entity.getVersion()))
                            .email(entity.getEmail())
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .companyID(CompanyID.of(entity.getCompany().getUuid()))
                            .accessModifier(entity.getAccessModifier())
                            .isVerified(entity.getIsVerified())
                            .isPrimary(entity.getIsPrimary())
                            .verificationCode(entity.getVerificationCode())
                            .verificationRequestDate(GDateTime.toZonedDateTime(entity.getVerificationRequestDate()))
                            .verificationResponseDate(GDateTime.toZonedDateTime(entity.getVerificationResponseDate()))
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<EmailEntity> toEntity(EmailRoot root) {
        var optionalEmailRoot = Optional.ofNullable(root);
        if (optionalEmailRoot.isEmpty()) return Optional.empty();
            return Optional.of(
                    EmailEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .company(CompanyEntity.referenceObject(root.getCompanyID().getAbsoluteID()))
                            .accessModifier(root.getAccessModifier())
                            .email(root.getEmail())
                            .isVerified(root.getVerified())
                            .isPrimary(root.getPrimary())
                            .verificationCode(root.getVerificationCode())
                            .verificationRequestDate(GDateTime.toTimestamp(root.getVerificationRequestDate()))
                            .verificationResponseDate(GDateTime.toTimestamp(root.getVerificationResponseDate()))
                            .version(root.getVersionValue())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                            .build());

    }
}
