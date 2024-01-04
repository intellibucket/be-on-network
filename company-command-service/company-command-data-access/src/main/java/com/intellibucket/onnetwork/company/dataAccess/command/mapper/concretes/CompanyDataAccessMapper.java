package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import az.rock.lib.util.GDateTime;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyDataAccessMapper implements AbstractCompanyDataAccessMapper<CompanyEntity, CompanyRoot> {
    @Override
    public Optional<CompanyRoot> toRoot(CompanyEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if(optionalEntity.isPresent()){
            return Optional.of(
                    CompanyRoot.Builder.builder()
                            .uuid(entity.getUuid())
                            .version(entity.getVersion())
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .userId(entity.getUserUUID())
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
        if(optionalEntity.isPresent()){
            return Optional.of(
                    CompanyEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .version(root.getVersion().value())
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                            .userId(root.getUserID())
                            .name(root.getName())
                            .description(root.getDescription())
                            .build()
            );
        }
        return Optional.empty();
    }
}
