package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractNetworkDataAccessMapper;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.auth.FollowID;
import az.rock.lib.domain.id.auth.NetworkID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NetworkDataAccessMapper implements AbstractNetworkDataAccessMapper<NetworkRelationEntity, NetworkRelationRoot> {
    @Override
    public Optional<NetworkRelationRoot> toRoot(NetworkRelationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    NetworkRelationRoot.Builder.builder()
                            .networkID(NetworkID.of(entity.getUuid()))
                            .version(Version.of(entity.getVersion()))
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .requestOwnerId(entity.getRequestOwnerId())
                            .requestTargetId(entity.getRequestTargetId())
                            .networkStatus(entity.getNetworkStatus())
                            .blockReasonStatus(entity.getBlockReasonStatus())
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<NetworkRelationEntity> toEntity(NetworkRelationRoot root) {
        var optional = Optional.ofNullable(root);
        if (optional.isPresent()){
            return Optional.of(
                    NetworkRelationEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .version(root.getVersion().value())
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                            .requestOwnerId(root.getRequestOwnerId())
                            .requestTargetId(root.getRequestTargetId())
                            .networkStatus(root.getNetworkStatus())
                            .blockReasonStatus(root.getBlockReasonStatus())
                            .build()
            );
        }
        return Optional.empty();
    }
}
