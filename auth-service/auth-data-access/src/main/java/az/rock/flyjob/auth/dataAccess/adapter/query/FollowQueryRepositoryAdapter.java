package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowRelationQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractFollowDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.FollowQueryJPARepository;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.auth.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class FollowQueryRepositoryAdapter implements AbstractFollowRelationQueryRepositoryAdapter {
    private final FollowQueryJPARepository followQueryJPARepository;
    private final AbstractFollowDataAccessMapper<FollowRelationEntity,FollowRelationRoot> followQueryDataAccessMapper;

    public FollowQueryRepositoryAdapter(FollowQueryJPARepository followQueryJPARepository,
                                        AbstractFollowDataAccessMapper<FollowRelationEntity,FollowRelationRoot> followQueryDataAccessMapper) {
        this.followQueryJPARepository = followQueryJPARepository;
        this.followQueryDataAccessMapper = followQueryDataAccessMapper;
    }

    @Override
    public List<FollowRelationRoot> findMyFollowers(UserID userID) {
        List<FollowRelationEntity> list = this.followQueryJPARepository.findAllMyFollowers(userID.getAbsoluteID());
        return list
                .stream()
                .map(followQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<FollowRelationRoot> findMyFollowings(UserID userID) {
        List<FollowRelationEntity> list = this.followQueryJPARepository.findAllMyFollowings(userID.getAbsoluteID());
        return list
                .stream()
                .map(followQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<FollowRelationRoot> findRelationByUsersID(UUID sourceUserId, UUID targetUserID) {
        List<FollowRelationEntity> list = Objects.requireNonNullElse(
                this.followQueryJPARepository.findRelationByUsersID(sourceUserId,targetUserID),
                List.of()
        );
        return list
                .stream()
                .map(followQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }


    @Override
    public Boolean isFollowerPresentInMyFollowers(UserID userID, UserID followUserID) {
        var presentFollowerInMyFollowers = this.followQueryJPARepository
                                                    .isFollowerPresentInMyFollowers(userID.getAbsoluteID(),followUserID.getAbsoluteID());
        return presentFollowerInMyFollowers;
    }


    @Override
    public Optional<FollowRelationRoot> findActiveRowForUserAndFollowID(UserID userID, UserID followingUserID) {
        var optionalEntity = Optional.ofNullable(this.followQueryJPARepository
                .findByUserAndFollowingUserID(userID.getAbsoluteID(), followingUserID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.followQueryDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }
}
