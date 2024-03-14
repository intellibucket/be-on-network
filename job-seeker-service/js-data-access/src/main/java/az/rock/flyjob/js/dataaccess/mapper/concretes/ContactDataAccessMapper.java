package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ContactDataAccessMapper implements AbstractContactDataAccessMapper {

    private final ResumeDataAccessMapper resumeDataAccessMapper;

    public ContactDataAccessMapper(ResumeDataAccessMapper resumeDataAccessMapper) {
        this.resumeDataAccessMapper = resumeDataAccessMapper;
    }

    @Override
    public Optional<ContactRoot> toRoot(ContactEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) return Optional.empty();
        return Optional.of(ContactRoot.Builder
                .builder()
                .id(ContactID.of(entity.getUuid()))
                .accessModifier(entity.getAccessModifier())
                .formatType(entity.getFormatType())
                .data(entity.getData())
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .liveType(entity.getLiveType())
                .orderNumber(entity.getOrderNumber())
                .resume()
                .lastModifiedDate(entity.getLastModifiedDate())
                .orderNumber(entity.getOrderNumber())
                .rowStatus(entity.getRowStatus())
                .build();
    }


    @Override
    public Optional<ContactEntity> toEntity(ContactRoot root) {
        var optionalEntity = Optional.ofNullable(root);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(ContactEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .accessModifier(root.getAccessModifier())
                .data(root.getData())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .processStatus(root.getProcessStatus())
                .formatType(root.getFormatType())
                .liveType(root.getLiveType())
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .orderNumber(root.getOrderNumber())
                .data(root.getData())
                .rowStatus(root.getRowStatus())
                .resume(root.getResume())
                .build());

    }
}

