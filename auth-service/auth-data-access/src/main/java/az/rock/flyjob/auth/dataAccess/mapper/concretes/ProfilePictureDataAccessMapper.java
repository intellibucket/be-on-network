package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.ProfilePictureEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractProfilePictureDataAccessMapper;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.ProfilePictureID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfilePictureDataAccessMapper implements AbstractProfilePictureDataAccessMapper<ProfilePictureEntity, ProfilePictureRoot> {
    @Override
    public Optional<ProfilePictureRoot> toRoot(ProfilePictureEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if(optionalEntity.isPresent()) {
            var concreteEntity = optionalEntity.get();
            return Optional.of(
                    ProfilePictureRoot.Builder
                            .builder()
                            .id(ProfilePictureID.of(concreteEntity.getUuid()))
                            .userID(UserID.of(concreteEntity.getUser().getUuid()))
                            .version(Version.of(concreteEntity.getVersion()))
                            .processStatus(concreteEntity.getProcessStatus())
                            .rowStatus(concreteEntity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(concreteEntity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(concreteEntity.getLastModifiedDate()))
                            .accessModifier(concreteEntity.getAccessModifier())
                            .fileFormat(concreteEntity.getFileFormat())
                            .filepath(concreteEntity.getFilepath())
                            .filename(concreteEntity.getFilename())
                            .filepathExtraLarge(concreteEntity.getFilepathExtraLarge())
                            .filesize(concreteEntity.getFilesize())
                            .filepathLarge(concreteEntity.getFilepathLarge())
                            .filepathMedium(concreteEntity.getFilepathMedium())
                            .filepathThumbnail(concreteEntity.getFilepathThumbnail())
                            .isCurrent(concreteEntity.getIsCurrent())
                            .region(concreteEntity.getRegion())
                            .build()
            );
        } else return Optional.empty();
    }

    @Override
    public Optional<ProfilePictureEntity> toEntity(ProfilePictureRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if(optionalRoot.isPresent()){
            var concreteRoot = optionalRoot.get();
            return Optional.of(
                    ProfilePictureEntity.Builder
                            .builder()
                            .uuid(concreteRoot.getRootID().getAbsoluteID())
                            .user(UserEntity.referenceObject(concreteRoot.getUserID().getRootID()))
                            .version(concreteRoot.getVersion().value())
                            .processStatus(concreteRoot.getProcessStatus())
                            .rowStatus(concreteRoot.getRowStatus())
                            .createdDate(GDateTime.toTimestamp(concreteRoot.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(concreteRoot.getModificationDate()))
                            .accessModifier(concreteRoot.getAccessModifier())
                            .fileFormat(concreteRoot.getFileFormat())
                            .filepath(concreteRoot.getFilepath())
                            .filename(concreteRoot.getFilename())
                            .filepathExtraLarge(concreteRoot.getFilepathExtraLarge())
                            .filepathLarge(concreteRoot.getFilepathLarge())
                            .filepathMedium(concreteRoot.getFilepathMedium())
                            .filepathThumbnail(concreteRoot.getFilepathThumbnail())
                            .filepathWebp(concreteRoot.getFilepathWebp())
                            .filesize(concreteRoot.getFilesize())
                            .isCurrent(concreteRoot.getCurrent())
                            .region(concreteRoot.getRegion())
                            .build()
            );
        }else return Optional.empty();
    }

}
