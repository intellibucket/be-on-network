package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;


import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.CompanyProfileID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyProfileDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CompanyProfileDataAccessMapper implements AbstractCompanyProfileDataAccessMapper {
    @Override
    public Optional<CompanyProfileRoot> toRoot(CompanyProfileEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    CompanyProfileRoot.Builder.builder()
                            .uuid(CompanyProfileID.of(entity.getUuid()))
                            .version(Version.of(entity.getVersion()))
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .companyID(CompanyID.of(entity.getCompany().getUuid()))
                            .isHiring(entity.getIsHiring())
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<CompanyProfileEntity> toEntity(CompanyProfileRoot root) {
        var optionalCompanyProfileRoot = Optional.ofNullable(root);
        if (optionalCompanyProfileRoot.isPresent()){
            return Optional.of(
                    CompanyProfileEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .company(CompanyEntity.referenceObject(root.getCompanyID().getAbsoluteID()))
                            .isHiring(root.getHiring())
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
