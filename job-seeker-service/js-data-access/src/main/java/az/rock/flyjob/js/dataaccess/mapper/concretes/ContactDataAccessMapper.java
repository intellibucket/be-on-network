package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
public class ContactDataAccessMapper implements AbstractContactDataAccessMapper {
    @Override
    public Optional<ContactRoot> toRoot(ContactEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var safetyResumeEntity = optionalEntity.get();
            return Optional.of(
                    ContactRoot.Builder.builder()
                            .resume(ResumeID.of(entity.getResume().getUuid()))
                            .accessModifier(AccessModifier.PUBLIC)
                            .data(safetyResumeEntity.getData())
                            .orderNumber(safetyResumeEntity.getOrderNumber())
                            .formatType(ContactFormatType.EMAIL)
                            .liveType(ContactLiveType.COMPANY)
                            .build());

        } else return Optional.empty();
    }

    @Override
    public Optional<ContactEntity> toEntity(ContactRoot root) {
        var optionalContactRoot = Optional.ofNullable(root);
        if(optionalContactRoot.isPresent()) {
            var safetyContactRoot = optionalContactRoot.get();
            return null;
//            return Optional.of(
//                    ContactEntity.Builder.builder()
//                            .uuid(safetyContactRoot.getRootID().getAbsoluteID())
//                            .version(safetyContactRoot.getVersionValue())
//
//                            .build());
    }
        else return Optional.empty();
    }

}
