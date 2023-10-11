package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.lib.valueObject.SwitchCase;

import java.util.UUID;

public interface AbstractPhoneNumberCommandDomainPresentationService {
    void add(PhoneNumberCommandRequest request);

    void change(PhoneNumberChangeRequest request);

    void delete(UUID uuid);

    void enableSmsNotification(SwitchCase switchCase);

    void enableWhatsappNotification(SwitchCase switchCase);

    void setPrimary(SwitchCase switchCase);
}
