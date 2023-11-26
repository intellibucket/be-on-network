package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractBlockRelationCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractBlockRelationDomainMapper;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowRelationCommandDomainInnerService;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractNetworkRelationCommandDomainInnerService;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractBlockRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.block.AlreadyBlockedException;
import az.rock.flyjob.auth.exception.block.AlreadyUnblockedException;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractBlockRelationDomainService;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.event.create.block.BlockRelationEvent;
import com.intellibucket.lib.payload.event.create.block.UnblockRelationEvent;
import com.intellibucket.lib.payload.event.create.user.payload.block.BlockRelationPayload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BlockRelationCommandHandler implements AbstractBlockRelationCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractBlockRelationCommandRepositoryAdapter blockRelationCommandRepositoryAdapter;

    private final AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter;

    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;


    private final AbstractBlockRelationDomainService blockRelationDomainService;

    private final AbstractBlockRelationDomainMapper blockRelationDomainMapper;

    private final AbstractFollowRelationCommandDomainInnerService followRelationCommandDomainInnerService;

    private final AbstractNetworkRelationCommandDomainInnerService networkRelationCommandDomainInnerService;

    public BlockRelationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                       AbstractBlockRelationCommandRepositoryAdapter blockRelationCommandRepositoryAdapter,
                                       AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter,
                                       AbstractBlockRelationDomainMapper blockRelationDomainMapper,
                                       AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                       AbstractBlockRelationDomainService blockRelationDomainService,
                                       AbstractFollowRelationCommandDomainInnerService followRelationCommandDomainInnerService,
                                       AbstractNetworkRelationCommandDomainInnerService networkRelationCommandDomainInnerService) {
        this.securityContextHolder = securityContextHolder;
        this.blockRelationCommandRepositoryAdapter = blockRelationCommandRepositoryAdapter;
        this.blockRelationQueryRepositoryAdapter = blockRelationQueryRepositoryAdapter;
        this.blockRelationDomainMapper = blockRelationDomainMapper;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.blockRelationDomainService = blockRelationDomainService;
        this.followRelationCommandDomainInnerService = followRelationCommandDomainInnerService;
        this.networkRelationCommandDomainInnerService = networkRelationCommandDomainInnerService;
    }

    @Override
    public BlockRelationEvent handleBlock(UUID targetUserUuid) {
        var currentUserIdTypePair = this.securityContextHolder.currentUserTypePair();
        var targetUserIdTypePair = this.userQueryRepositoryAdapter.findUserTypeById(UserID.of(targetUserUuid));
        var isPresentInMyBlockList = this.blockRelationQueryRepositoryAdapter.isPresentInMyBlockedList(currentUserIdTypePair.getUserID().getAbsoluteID(), targetUserUuid);
        if(isPresentInMyBlockList.size() != 0) throw new AlreadyBlockedException();
        this.blockRelationDomainService.validateBlockingItself(currentUserIdTypePair.getUserID().getAbsoluteID(),targetUserUuid);
        var newBlockRelationRoot = this.blockRelationDomainMapper.toNewBlockRelationRoot(currentUserIdTypePair,targetUserIdTypePair);
        var savedRoot = this.blockRelationCommandRepositoryAdapter.create(newBlockRelationRoot);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        this.followRelationCommandDomainInnerService.dumpRelation(currentUserIdTypePair.getUserID(),UserID.of(targetUserUuid));
        this.networkRelationCommandDomainInnerService.dumpRelation(currentUserIdTypePair.getUserID(),UserID.of(targetUserUuid));
        return BlockRelationEvent.of(this.fromRoot(savedRoot.get()));
    }
    /**
     *Ozun ozunu block ede bilmediyin ucun unblock controluna ehtiyac yoxdur
     */
    @Override
    public UnblockRelationEvent handleUnblock(UUID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var unblockTargetUserAgain = this.blockRelationQueryRepositoryAdapter.unblockTargetUserAgain(currentUserId.getAbsoluteID(),targetUserId);
        if(unblockTargetUserAgain) throw new AlreadyUnblockedException();
        this.blockRelationDomainService.validateUnblockingItself(currentUserId.getAbsoluteID(),targetUserId);
        var myBlockedList = this.blockRelationQueryRepositoryAdapter.isPresentInMyBlockedList(currentUserId.getAbsoluteID(), targetUserId);
        var savedRoot = this.changeRowStatusByUserInMyBlockedList(myBlockedList);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        return UnblockRelationEvent.of(this.fromRoot(savedRoot.get()));
    }

    private Optional<BlockRelationRoot> changeRowStatusByUserInMyBlockedList(List<BlockRelationRoot> myBlockedList){
        return myBlockedList.stream().peek(AggregateRoot::inActive)
                .peek(blockRelationCommandRepositoryAdapter::update).findFirst();
    }
    private BlockRelationPayload fromRoot(BlockRelationRoot blockRelationRoot){
        return BlockRelationPayload.Builder
                .builder()
                .userType(blockRelationRoot.getUserType())
                .userId(blockRelationRoot.getUserId())
                .targetUserType(blockRelationRoot.getUserType())
                .targetUserId(blockRelationRoot.getUserId())
                .build();
    }
}
