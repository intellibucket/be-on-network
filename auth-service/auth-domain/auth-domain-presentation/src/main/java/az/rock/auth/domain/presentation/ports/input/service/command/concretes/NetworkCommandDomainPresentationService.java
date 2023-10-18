package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractNetworkRelationCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractNetworkCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractNetworkRelationCommandDomainInnerService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNetworkRelationMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractNetworkRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibukcet.lib.payload.event.create.network.NetworkRelationEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NetworkCommandDomainPresentationService implements AbstractNetworkCommandDomainPresentationService,
        AbstractNetworkRelationCommandDomainInnerService {

    private final AbstractNetworkRelationMessagePublisher networkRelationMessagePublisher;

    private final AbstractNetworkRelationCommandHandler networkCommandHandler;

    private final AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter;
    private final AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter;

    public NetworkCommandDomainPresentationService(AbstractNetworkRelationMessagePublisher networkRelationMessagePublisher,
                                                   AbstractNetworkRelationCommandHandler networkCommandHandler,
                                                   AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter,
                                                   AbstractNetworkRelationCommandRepositoryAdapter networkRelationCommandRepositoryAdapter) {
        this.networkRelationMessagePublisher = networkRelationMessagePublisher;
        this.networkCommandHandler = networkCommandHandler;
        this.networkQueryRepositoryAdapter = networkQueryRepositoryAdapter;
        this.networkRelationCommandRepositoryAdapter = networkRelationCommandRepositoryAdapter;
    }

    @Override
    public void sendRequest(UUID targetUserId) {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleSendRequest(targetUserId);

    }

    @Override
    public void acceptRequest() {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleAcceptRequest();
    }

    @Override
    public void rejectRequest(UUID targetUserId) {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleRejectRequest(targetUserId);
    }

    @Override
    public void cancelRequest(UUID targetUserId) {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleCancelRequest(targetUserId);
    }

    @Override
    public void deleteNetwork(UUID targetUserId) {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleDeleteNetwork(targetUserId);
    }

    @Override
    public void dumpRelation(UserID currentUserId, UserID targetId) {
        var networkRelation = this.networkQueryRepositoryAdapter
                .findNetworkRelationByBothOfUserIDs(currentUserId, targetId);
        networkRelation.forEach(item -> {
            if (item.getRequestOwnerId().equals(targetId.getAbsoluteID())) {
                item.blockReasonStatusByTarget();
            } else if (item.getRequestOwnerId().equals(currentUserId.getAbsoluteID())) {
                item.blockReasonStatusByOwner();
            }
            item.inActive();
            networkRelationCommandRepositoryAdapter.update(item);
        });

    }
}
