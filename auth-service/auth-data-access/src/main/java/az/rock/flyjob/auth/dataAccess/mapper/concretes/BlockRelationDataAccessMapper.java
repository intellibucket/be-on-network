package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractBlockRelationDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BlockRelationDataAccessMapper implements AbstractBlockRelationDataAccessMapper<BlockRelationEntity, BlockRelationRoot> {


    @Override
    public Optional<BlockRelationRoot> toRoot(BlockRelationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if(optionalEntity.isPresent()){
            return Optional.of(
                    BlockRelationRoot.Builder.builder()
                            .uuid(entity.getUuid())
                            .version(entity.getVersion())
                            .processStatus(entity.getProcessStatus())
                            .rowStatus(entity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .userType(entity.getUserType())
                            .userId(entity.getUserId())
                            .targetUserType(entity.getTargetUserType())
                            .targetUserId(entity.getTargetUserId())
                            .description(entity.getDescription())
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<BlockRelationEntity> toEntity(BlockRelationRoot root) {
        var optionalEntity = Optional.ofNullable(root);
        if(optionalEntity.isPresent()){
            return Optional.of(
                    BlockRelationEntity.Builder.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .version(root.getVersion().value())
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                            .userType(root.getUserType())
                            .userId(root.getUserId())
                            .targetUserType(root.getTargetUserType())
                            .targetUserId(root.getTargetUserId())
                            .description(root.getDescription())
                            .build()
            );
        }
        return Optional.empty();
    }
}
