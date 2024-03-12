package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InterestDataAccessMapper implements AbstractInterestDataAccessMapper<InterestEntity, InterestRoot> {
    @Override
    public Optional<InterestRoot> toRoot(InterestEntity entity) {
        var optionalEnttity=Optional.ofNullable(entity);
        if(optionalEnttity.isEmpty()) return Optional.empty();
        return Optional.of(InterestRoot.Builder.builder()
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .id(InterestID.of(entity.getUuid()))
                        .version(entity.getVersion())
                        .rowStatus(entity.getRowStatus())
                        .processStatus(entity.getProcessStatus())
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .lastModifiedDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .accessModifier(entity.getAccessModifier())
                        .orderNumber(entity.getOrderNumber())
                        .isHobby(entity.getIsHobby())
                        .name(entity.getName())
                        .description(entity.getDescription())
                .build());
    }

    @Override
    public Optional<InterestEntity> toEntity(InterestRoot root) {
        var optionalRoot=Optional.ofNullable(root);
        if(optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(
                InterestEntity.Builder.builder()
                        .uuid(root.getRootID().getAbsoluteID())
                        .resume(ResumeEntity.referenceOf(root.getResume().getAbsoluteID()))
                        .version(root.getVersionValue())
                        .rowStatus(root.getRowStatus())
                        .processStatus(root.getProcessStatus())
                        .accessModifier(root.getAccessModifier())
                        .orderNumber(root.getOrderNumber())
                        .isHobby(root.getHobby())
                        .name(root.getName())
                        .description(root.getDescription())
                        .build());

    }

    @Override
    public Optional<InterestEntity> toNewEntity(InterestRoot root) {
        var optionalNewEntity=Optional.ofNullable(root);
        if(optionalNewEntity.isEmpty()) return Optional.empty();
        return Optional.of(
                InterestEntity.Builder.builder()
                        .uuid(root.getRootID().getAbsoluteID())
                        .resume(ResumeEntity.referenceOf(root.getResume().getAbsoluteID()))
                        .version(root.getVersionValue())
                        .rowStatus(root.getRowStatus())
                        .processStatus(root.getProcessStatus())
                        .accessModifier(root.getAccessModifier())
                        .orderNumber(root.getOrderNumber())
                        .isHobby(root.getHobby())
                        .name(root.getName())
                        .description(root.getDescription())
                        .build());
    }
}
