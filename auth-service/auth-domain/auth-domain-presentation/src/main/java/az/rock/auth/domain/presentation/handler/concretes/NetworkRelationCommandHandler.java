package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowRelationCommandHandler;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractNetworkRelationCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractNetworkRelationDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractNetworkRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.NoActiveRowException;
import az.rock.flyjob.auth.exception.block.BlockRelationWhenFollowException;
import az.rock.flyjob.auth.exception.follow.AlreadyFollowedException;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractNetworkRelationDomainService;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.event.create.network.NetworkRelationEvent;
import com.intellibucket.lib.payload.event.create.user.payload.network.NetworkRelationPayload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NetworkRelationCommandHandler implements AbstractNetworkRelationCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter;
    private final AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter;
    private final AbstractNetworkRelationDomainService networkRelationDomainService;
    private final AbstractFollowRelationCommandHandler followRelationCommandHandler;
    private final AbstractNetworkRelationDomainMapper networkRelationDomainMapper;
    private final AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter;

    public NetworkRelationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                         AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter,
                                         AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter,
                                         AbstractNetworkRelationDomainService networkRelationDomainService,
                                         AbstractFollowRelationCommandHandler followRelationCommandHandler,
                                         AbstractNetworkRelationDomainMapper networkRelationDomainMapper,
                                         AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.blockRelationQueryRepositoryAdapter = blockRelationQueryRepositoryAdapter;
        this.networkQueryRepositoryAdapter = networkQueryRepositoryAdapter;
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
        try {
            this.followRelationCommandHandler.handleFollow(UserID.of(targetUserId));
        }catch (AlreadyFollowedException ignored) {}
        return NetworkRelationEvent.of(this.fromRoot(savedRoot.get()));
    }

    @Override
    public NetworkRelationEvent handleAcceptRequest(UUID relationUUID) {
        var currentUserId = this.securityContextHolder.availableUser();
        var inMyNetworkPendingRequest = this.networkQueryRepositoryAdapter.findInMyNetworkPendingRequests(currentUserId);
        var myActiveNetworks = this.networkQueryRepositoryAdapter.findMyNetworks(currentUserId);
        this.networkRelationDomainService.validateActiveNetworkRelation(myActiveNetworks);
        if (inMyNetworkPendingRequest.size() > 0) {
            var optionalActiveRowRelation = inMyNetworkPendingRequest.stream()
                    .filter(networkRelationRoot -> networkRelationRoot.getRootID().getAbsoluteID().equals(relationUUID))
                    .findFirst();
            if (optionalActiveRowRelation.isPresent()){
                var activeRowRelation = optionalActiveRowRelation.get();
                activeRowRelation.accept();
                this.networkRelationCommandRepositoryAdapter.update(activeRowRelation);
                return NetworkRelationEvent.of(this.fromRoot(activeRowRelation));
            }else throw new NoActiveRowException();
        }else throw new NoActiveRowException();
    }

    @Override
    public NetworkRelationEvent handleRejectRequest(UUID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var findNetworkRelationByBothOfUserIDs =
                this.networkQueryRepositoryAdapter.findMutualActiveNetworkRelationOnPendingStatus(currentUserId, UserID.of(targetUserId));
        if (findNetworkRelationByBothOfUserIDs.isPresent()) {
            var networkRelationRoot = findNetworkRelationByBothOfUserIDs.get();
            networkRelationRoot.reject();
            networkRelationRoot.inActive();
            this.networkRelationCommandRepositoryAdapter.update(networkRelationRoot);
            return NetworkRelationEvent.of(this.fromRoot(networkRelationRoot));
        }else {
            throw new NoActiveRowException();
        }

    }

    @Override
    public NetworkRelationEvent handleCancelRequest(UUID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var networkRelation = this.networkQueryRepositoryAdapter.findActiveNetworkRelationOnPendingStatus(currentUserId,UserID.of(targetUserId));
        if (networkRelation.isPresent()) {
            var networkRelationRoot = networkRelation.get();
            networkRelationRoot.cancel();
            networkRelationRoot.inActive();
            this.networkRelationCommandRepositoryAdapter.update(networkRelationRoot);
            return NetworkRelationEvent.of(this.fromRoot(networkRelationRoot));
        }else {
            throw new NoActiveRowException();
        }
    }

    //TODO NETWORK STATUS NE OLMALIDIR
    @Override
    public NetworkRelationEvent handleDeleteNetwork(UUID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var activeNetworkRelation = this.networkQueryRepositoryAdapter.findMyNetworksByUIDs(currentUserId,UserID.of(targetUserId));
        if(activeNetworkRelation.size() > 0){
            var networkRelationRoot = changeRowStatusByUserInMyNetworkList(activeNetworkRelation);
            return NetworkRelationEvent.of(this.fromRoot(networkRelationRoot));
        }else{
            throw new NoActiveRowException();
        }
    }

    private NetworkRelationRoot changeRowStatusByUserInMyNetworkList(List<NetworkRelationRoot> myNetworkList){
        return myNetworkList.stream().peek(item->item.inActive())
                .peek(networkRelationCommandRepositoryAdapter::update).findAny().get();
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
