package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;


import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@InputPort
@Transactional(readOnly = true)
public interface AbstractBlockRelationQueryDomainPresentationService {
    List<UUID> findMyBlockedList();

    List<UUID> queryWhoBlockedMe();

    List<UUID> queryMyBlockedUserById(UUID targetUserId);
}
