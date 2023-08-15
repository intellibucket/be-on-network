package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractFollowDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.FollowQueryJPARepository;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.auth.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FollowQueryRepositoryAdapter implements AbstractFollowQueryRepositoryAdapter {
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
    public List<FollowRelationRoot> findMyFollowPendingRequests(UserID userID) {
        List<FollowRelationEntity> list = this.followQueryJPARepository.findAllMyPendingFollowRequests(userID.getAbsoluteID());
        return list
                .stream()
                .map(followQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<FollowRelationRoot> findInMyFollowPendingRequests(UserID userID) {
        List<FollowRelationEntity> list = this.followQueryJPARepository.findAllInMyPendingFollowRequests(userID.getAbsoluteID());
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
}
