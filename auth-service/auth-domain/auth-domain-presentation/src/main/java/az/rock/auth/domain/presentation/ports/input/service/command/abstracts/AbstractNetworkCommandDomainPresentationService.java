package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractNetworkCommandDomainPresentationService {

    void sendRequest(UUID targetUserId);

    void acceptRequest(UUID relationUUID);

    void rejectRequest(UUID targetUserId);
    void cancelRequest(UUID targetUserId);

    void deleteNetwork(UUID targetUserId);


}
