package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowRelationCommandHandler;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractNetworkRelationCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractNetworkRelationDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractNetworkRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.block.BlockRelationWhenFollowException;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractNetworkRelationDomainService;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibukcet.lib.payload.event.create.network.NetworkRelationEvent;
import com.intellibukcet.lib.payload.event.create.user.payload.network.NetworkRelationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NetworkRelationCommandHandler implements AbstractNetworkRelationCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter;
    private final AbstractNetworkRelationDomainService networkRelationDomainService;
    private final AbstractFollowRelationCommandHandler followRelationCommandHandler;
    private final AbstractNetworkRelationDomainMapper networkRelationDomainMapper;
    private final AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter;

    public NetworkRelationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                         AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter,
                                         AbstractNetworkRelationDomainService networkRelationDomainService,
                                         AbstractFollowRelationCommandHandler followRelationCommandHandler,
                                         AbstractNetworkRelationDomainMapper networkRelationDomainMapper,
                                         AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.blockRelationQueryRepositoryAdapter = blockRelationQueryRepositoryAdapter;
        this.networkRelationDomainService = networkRelationDomainService;
        this.followRelationCommandHandler = followRelationCommandHandler;
        this.networkRelationDomainMapper = networkRelationDomainMapper;
        this.networkRelationCommandRepositoryAdapter = networkRelationCommandRepositoryAdapter;
    }

    @Override
    public NetworkRelationEvent handleSendRequest(UUID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var isPresentInBlockList = this.blockRelationQueryRepositoryAdapter.blockRelationByUsers(currentUserId.getAbsoluteID(), targetUserId);
        if (isPresentInBlockList) throw new BlockRelationWhenFollowException();
        this.networkRelationDomainService.validateConnectionItself(currentUserId.getAbsoluteID(), targetUserId);
        var newNetworkRelationRoot = this.networkRelationDomainMapper.toNewNetworkRelationRoot(currentUserId, UserID.of(targetUserId));
        var savedRoot = this.networkRelationCommandRepositoryAdapter.create(newNetworkRelationRoot);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        this.followRelationCommandHandler.handleFollow(UserID.of(targetUserId));
        return NetworkRelationEvent.of(this.fromRoot(savedRoot.get()));
    }

    @Override
    public NetworkRelationEvent handleAcceptRequest(UUID targetUserId) {
        return null;
    }

    @Override
    public NetworkRelationEvent handleRejectRequest(UUID targetUserId) {
        return null;
    }

    @Override
    public NetworkRelationEvent handleCancelRequest(UUID targetUserId) {
        return null;
    }

    @Override
    public NetworkRelationEvent handleDeleteNetwork(UUID targetUserId) {
        return null;
    }


    private NetworkRelationPayload fromRoot(NetworkRelationRoot networkRelationRoot) {
        return NetworkRelationPayload.Builder
                .builder()
                .requestOwnerId(networkRelationRoot.getRequestOwnerId())
                .requestTargetId(networkRelationRoot.getRequestOwnerId())
                .networkStatus(networkRelationRoot.getNetworkStatus())
                .blockReasonStatus(networkRelationRoot.getBlockReasonStatus())
                .build();
    }
}
