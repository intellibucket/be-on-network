package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractFollowDataAccessMapper;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.FollowID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FollowDataAccessMapper implements AbstractFollowDataAccessMapper<FollowRelationEntity, FollowRelationRoot> {


    @Override
    public Optional<FollowRelationRoot> toRoot(FollowRelationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
           return Optional.of(
                   FollowRelationRoot.Builder.builder()
                           .followID(FollowID.of(entity.getUuid()))
                           .version(Version.of(entity.getVersion()))
                           .processStatus(entity.getProcessStatus())
                           .rowStatus(entity.getRowStatus())
                           .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                           .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                           .followStatus(entity.getFollowStatus())
                           .followedUserId(entity.getFollowedUserId())
                           .followingUserId(entity.getFollowingUserId())
                           .build()
           );
        }
        return Optional.empty();
    }

    @Override
    public Optional<FollowRelationEntity> toEntity(FollowRelationRoot root) {
        return Optional.empty();
    }

    @Override
    public Optional<FollowRelationEntity> toNewEntity(FollowRelationRoot root) {
        return Optional.empty();
    }
}
