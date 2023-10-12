package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractNetworkRelationCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractNetworkCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNetworkRelationMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowRelationQueryRepositoryAdapter;
import com.intellibukcet.lib.payload.event.create.network.NetworkRelationEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NetworkCommandDomainPresentationService implements AbstractNetworkCommandDomainPresentationService {

    private final AbstractNetworkRelationMessagePublisher networkRelationMessagePublisher;

    private final AbstractNetworkRelationCommandHandler networkCommandHandler;


    public NetworkCommandDomainPresentationService(AbstractNetworkRelationMessagePublisher networkRelationMessagePublisher,
                                                   AbstractNetworkRelationCommandHandler networkCommandHandler) {
        this.networkRelationMessagePublisher = networkRelationMessagePublisher;
        this.networkCommandHandler = networkCommandHandler;
    }

    @Override
    public void sendRequest(UUID targetUserId) {
        NetworkRelationEvent relationEvent = this.networkCommandHandler.handleSendRequest(targetUserId);

    }

    @Override
    public void acceptRequest(UUID targetUserId) {

    }

    @Override
    public void rejectRequest(UUID targetUserId) {

    }

    @Override
    public void cancelRequest(UUID targetUserId) {

    }

    @Override
    public void deleteNetwork(UUID targetUserId) {

    }
}
