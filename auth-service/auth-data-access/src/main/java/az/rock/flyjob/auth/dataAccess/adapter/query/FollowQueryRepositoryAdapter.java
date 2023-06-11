package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractFollowDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.FollowQueryJPARepository;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return null;
    }

    @Override
    public List<FollowRelationRoot> findMyFollowings(UserID userID) {
        return null;
    }

    @Override
    public List<FollowRelationRoot> findMyFollowPendingRequests(UserID userID) {
        return null;
    }
}
