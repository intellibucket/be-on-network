package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInformationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InformationDataAccessMapper implements AbstractInformationDataAccessMapper {
    @Override
    public Optional<InformationRoot> toRoot(InformationEntity entity) {
        var optionalInformationEntity = Optional.ofNullable(entity);
        if (optionalInformationEntity.isPresent()){
            var informationEntity = optionalInformationEntity.get();
            return Optional.of(
                    InformationRoot.Builder
                            .builder()
                            .id(InformationID.of(informationEntity.getUuid()))
                            .version(Version.of(informationEntity.getVersion()))
                            .processStatus(informationEntity.getProcessStatus())
                            .rowStatus(informationEntity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(
                                    informationEntity.getCreatedDate()
                            ))
                            .lastModifiedDate(GDateTime.toZonedDateTime(
                                    informationEntity.getLastModifiedDate()
                            ))
                            .resume(ResumeID.of(informationEntity.getResume().getUuid()))
                            .accessModifier(informationEntity.getAccessModifier())
                            .firstName(informationEntity.getName())
                            .lastName(informationEntity.getSurname())
                            //TODO
                            .build()
            );
        }else return Optional.empty();
    }

    @Override
    public Optional<InformationEntity> toEntity(InformationRoot root) {
        var optionalInformationRoot = Optional.ofNullable(root);
        if (optionalInformationRoot.isPresent()){
            return Optional.of(
                InformationEntity.Builder
                        .builder()
                        .uuid(root.getRootID().getAbsoluteID())
                        .processStatus(root.getProcessStatus())
                        .rowStatus(root.getRowStatus())
                        .version(root.getVersion().value())
                        .createdDate(
                                GDateTime.toTimestamp(
                                        root.getCreatedDate()
                                )
                        )
                        .lastModifiedDate(
                                GDateTime.toTimestamp(
                                        root.getModificationDate()
                                )
                        )
                        .resume(ResumeEntity.referenceOf(
                                root.getResume().getAbsoluteID()
                        ))
                        .accessModifier(root.getAccessModifier())
                        .name(root.getFirstName())
                        .surname(root.getLastName())
                        .build()
            );
        }else return Optional.empty();
    }
}
