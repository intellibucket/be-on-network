package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.lib.valueObject.SwitchCase;

import java.util.UUID;

public interface AbstractEmailCommandDomainPresentationService {
    void add(EmailCreateRequest emailCreateRequest);

    void change(EmailChangeRequest emailChangeRequest);

    void delete(UUID emailUUID);

    void setPrimary(UUID emailUUID);

    void switchEnableNotification(SwitchCase switchCase);

    void switchSubscribedPromotions(SwitchCase switchCase);
}
