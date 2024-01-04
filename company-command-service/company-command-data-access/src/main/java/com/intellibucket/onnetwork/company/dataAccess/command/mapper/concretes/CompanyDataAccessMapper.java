package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.util.GDateTime;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.*;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.VerificationRoot;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@Component
public class CompanyDataAccessMapper implements AbstractCompanyDataAccessMapper {
    private final AbstractWebsiteDataAccessMapper websiteDataAccessMapper;
    private final AbstractCompanyProfileDataAccessMapper companyProfileDataAccessMapper;
    private final AbstractCompanyEmailDataAccessMapper companyEmailDataAccessMapper;
    private final AbstractVerificationDataAccessMapper verificationDataAccessMapper;

    public CompanyDataAccessMapper(AbstractWebsiteDataAccessMapper websiteDataAccessMapper,
                                   AbstractCompanyProfileDataAccessMapper companyProfileDataAccessMapper,
                                   AbstractCompanyEmailDataAccessMapper companyEmailDataAccessMapper,
                                   AbstractVerificationDataAccessMapper verificationDataAccessMapper) {
        this.websiteDataAccessMapper = websiteDataAccessMapper;
        this.companyProfileDataAccessMapper = companyProfileDataAccessMapper;
        this.companyEmailDataAccessMapper = companyEmailDataAccessMapper;
        this.verificationDataAccessMapper = verificationDataAccessMapper;
    }

    @Override
    public Optional<CompanyRoot> toRoot(CompanyEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    CompanyRoot.Builder.builder()
                            .uuid(entity.getUuid())
                            .version(entity.getVersion())
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .userId(entity.getUserUuid())
                            .name(entity.getName())
                            .description(entity.getDescription())
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<CompanyEntity> toEntity(CompanyRoot root) {
        var optionalEntity = Optional.ofNullable(root);
        if (optionalEntity.isPresent()) {
            var emailEntities = Objects.requireNonNullElse(root.getEmails(), new LinkedList<EmailRoot>())
                    .stream()
                    .map(companyEmailDataAccessMapper::toEntity)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            var verificationEntities = Objects.requireNonNullElse(root.getVerifications(), new LinkedList<VerificationRoot>())
                    .stream()
                    .map(verificationDataAccessMapper::toEntity)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            var websiteEntity = websiteDataAccessMapper.toEntity(root.getWebsites());

            var profileEntity = companyProfileDataAccessMapper.toEntity(root.getProfile());

            var companyEntity = CompanyEntity.Builder.builder()
                    .uuid(root.getRootID().getAbsoluteID())
                    .version(root.getVersion().value())
                    .processStatus(root.getProcessStatus())
                    .rowStatus(root.getRowStatus())
                    .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                    .userId(root.getUserID())
                    .name(root.getName())
                    .description(root.getDescription())
                    .email(emailEntities)
                    .verification(verificationEntities)
                    .website(websiteEntity)
                    .profile(profileEntity)
                    .build();

            emailEntities.forEach(emailEntity -> emailEntity.setCompany(companyEntity));
            verificationEntities.forEach(verificationEntity -> verificationEntity.setCompany(companyEntity));
            websiteEntity.ifPresent(websiteEntity1 -> websiteEntity1.setCompany(companyEntity));
            profileEntity.ifPresent(profileEntity1 -> profileEntity1.setCompany(companyEntity));

            return Optional.of(companyEntity);
        }
        return Optional.empty();
    }
}
