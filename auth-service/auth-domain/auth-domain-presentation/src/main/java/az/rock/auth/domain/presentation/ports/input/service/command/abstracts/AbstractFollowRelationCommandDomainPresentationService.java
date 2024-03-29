package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractFollowRelationCommandDomainPresentationService {

    void follow(UUID targetUserId);

    void unfollow(UUID targetUserId);

    void remove(UUID targetUserId);

}
