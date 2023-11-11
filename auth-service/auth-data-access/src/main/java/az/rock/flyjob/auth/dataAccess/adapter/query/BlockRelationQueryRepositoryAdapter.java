package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractBlockRelationDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.BlockQueryJPARepository;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class BlockRelationQueryRepositoryAdapter implements AbstractBlockRelationQueryRepositoryAdapter {

    private final BlockQueryJPARepository blockQueryJPARepository;

    private final AbstractBlockRelationDataAccessMapper<BlockRelationEntity, BlockRelationRoot> blockQueryDataAccessMapper;

    public BlockRelationQueryRepositoryAdapter(BlockQueryJPARepository blockQueryJPARepository,
                                               AbstractBlockRelationDataAccessMapper<BlockRelationEntity, BlockRelationRoot> blockQueryDataAccessMapper) {
        this.blockQueryJPARepository = blockQueryJPARepository;
        this.blockQueryDataAccessMapper = blockQueryDataAccessMapper;
    }

    @Override
    public List<BlockRelationRoot> findMyBlockedList(UserID userID) {
        List<BlockRelationEntity> list = this.blockQueryJPARepository.findMyBlockedList(userID.getAbsoluteID());
        return list
                .stream()
                .map(blockQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<BlockRelationRoot> findWhoBlockedMe(UUID currentUserId) {
        List<BlockRelationEntity> list = this.blockQueryJPARepository.findWhoBlockedMe(currentUserId);
        return list
                .stream()
                .map(blockQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<BlockRelationRoot> isPresentInMyBlockedList(UUID userID, UUID targetUserId) {
        List<BlockRelationEntity> list = Objects.requireNonNullElse(this.blockQueryJPARepository
                .isPresentInMyBlockedList(userID, targetUserId),List.of());

        return list
                .stream()
                .map(blockQueryDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Boolean unblockTargetUserAgain(UUID currentUserId, UUID targetUserId) {
        var unblockTargetUserAgain = this.blockQueryJPARepository
                .unblockTargetUserAgain(currentUserId,targetUserId);
        return unblockTargetUserAgain;
    }

    @Override
    public Boolean blockRelationByUsers(UUID currentUserId, UUID targetUserId) {
        var blockRelationByUsers = this.blockQueryJPARepository
                .blockRelationByUsers(currentUserId,targetUserId);
        return blockRelationByUsers;
    }


}
