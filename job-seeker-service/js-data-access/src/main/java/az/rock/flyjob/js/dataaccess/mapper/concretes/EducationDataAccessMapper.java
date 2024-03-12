package az.rock.flyjob.js.dataaccess.mapper.concretes;


import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EducationDataAccessMapper implements AbstractEducationDataAccessMapper {




    @Override
    public Optional<EducationRoot> toRoot(EducationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(EducationRoot.Builder.builder()
                .uuid(EducationID.of(entity.getUuid()))
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .version(Version.of(entity.getVersion()))
                .rowStatus(entity.getRowStatus())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .lastModifiedDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .accessModifier(entity.getAccessModifier())
                .cityId(entity.getCityId())
                .establishmentUUID(entity.getEstablishmentUUID())
                .establishmentName(entity.getEstablishmentName())
                .orderNumber(entity.getOrderNumber())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .description(entity.getDescription())
                .link(entity.getLink())
                .state(entity.getState())
                .degree(entity.getDegree())
                .build());
    }

    @Override
    public Optional<EducationEntity> toEntity(EducationRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(EducationEntity.builder()
                .uuid(root.getRootID().getAbsoluteID())
                .resume(ResumeEntity.referenceOf(root.getResumeID().getAbsoluteID()))
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .accessModifier(root.getAccessModifier())
                .cityId(root.getCityId())
                .establishmentUUID(root.getEstablishmentUUID())
                .establishmentName(root.getEstablishmentName())
                .orderNumber(root.getOrderNumber())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .description(root.getDescription())
                .link(root.getLink())
                .state(root.getState())
                .degree(root.getDegree())
                .build());
    }
    @Override
    public Optional<EducationEntity> toNewEntity(EducationRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(EducationEntity.builder()
                .resume(ResumeEntity.referenceOf(root.getResumeID().getAbsoluteID()))
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .accessModifier(root.getAccessModifier())
                .cityId(root.getCityId())
                .establishmentUUID(root.getEstablishmentUUID())
                .establishmentName(root.getEstablishmentName())
                .orderNumber(root.getOrderNumber())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .description(root.getDescription())
                .link(root.getLink())
                .state(root.getState())
                .degree(root.getDegree())
                .build());
    }


    @Override
    public Optional<EducationEntity> setRootToExistEntity(EducationEntity entity, EducationRoot educationRoot) {
        var optionalEntity = Optional.ofNullable(entity);
        var optionalRoot = Optional.ofNullable(educationRoot);
        if (optionalRoot.isEmpty() || optionalEntity.isPresent()) return Optional.empty();

        return optionalEntity.map(tempEntity -> {
                    var root = optionalRoot.get();
                    tempEntity.setUuid(root.getRootID().getAbsoluteID());
                    tempEntity.setResume(ResumeEntity.referenceOf(root.getResumeID().getAbsoluteID()));
                    tempEntity.setCityId(root.getCityId());
                    tempEntity.setEstablishmentUUID(root.getEstablishmentUUID());
                    tempEntity.setEstablishmentName(root.getEstablishmentName());
                    tempEntity.setOrderNumber(root.getOrderNumber());
                    tempEntity.setStartDate(root.getStartDate());
                    tempEntity.setEndDate(root.getEndDate());
                    tempEntity.setAccessModifier(root.getAccessModifier());
                    tempEntity.setDescription(root.getDescription());
                    tempEntity.setLink(root.getLink());
                    tempEntity.setState(root.getState());
                    tempEntity.setDegree(root.getDegree());
                    tempEntity.setProcessStatus(root.getProcessStatus());
                    tempEntity.setRowStatus(root.getRowStatus());
                    return tempEntity;
                }
        );

    }
}
