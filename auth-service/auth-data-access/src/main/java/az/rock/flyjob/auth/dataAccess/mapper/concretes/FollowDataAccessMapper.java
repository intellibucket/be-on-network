package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractFollowDataAccessMapper;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FollowDataAccessMapper implements AbstractFollowDataAccessMapper<FollowRelationEntity, FollowRelationRoot> {


    @Override
    public Optional<FollowRelationRoot> toRoot(FollowRelationEntity entity) {
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
