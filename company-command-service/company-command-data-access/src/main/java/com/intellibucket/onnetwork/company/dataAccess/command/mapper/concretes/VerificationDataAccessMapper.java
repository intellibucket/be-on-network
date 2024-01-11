package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.VerificationID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractVerificationDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.VerificationEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.VerificationRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VerificationDataAccessMapper implements AbstractVerificationDataAccessMapper {

    @Override
    public Optional<VerificationRoot> toRoot(VerificationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    VerificationRoot.Builder.builder()
                            .uuid(VerificationID.of(entity.getUuid()))
                            .version(Version.of(entity.getVersion()))
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .companyID(CompanyID.of(entity.getCompany().getUuid()))
                            .isVerified(entity.getIsVerified())
                            .verificationType(entity.getVerificationType())
                            .verificationRequestDate(GDateTime.toZonedDateTime(entity.getVerificationRequestDate()))
                            .verificationResponseDate(GDateTime.toZonedDateTime(entity.getVerificationResponseDate()))
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<VerificationEntity> toEntity(VerificationRoot root) {
        var optionalVerificationRoot = Optional.ofNullable(root);
        if (optionalVerificationRoot.isPresent()) {
            return Optional.of(
                    VerificationEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .company(CompanyEntity.referenceObject(root.getCompanyID().getAbsoluteID()))
                            .isVerified(root.getVerified())
                            .verificationType(root.getVerificationType())
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
